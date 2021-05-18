package opticalconstants.controller;

import opticalconstants.model.CalculationInput;
import opticalconstants.service.CalculationResult;
import opticalconstants.service.CalculationService;
import opticalconstants.service.CsvService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Controller
public class CalculationController {

    private static final Logger log = LoggerFactory.getLogger(CalculationController.class);

    private final CalculationService calculationService;
    private final CsvService csvService;

    public CalculationController(CalculationService calculationService, CsvService csvService) {
        this.calculationService = calculationService;
        this.csvService = csvService;
    }

    @GetMapping("/")
    public String showInputPage() {
        return "index";
    }

    @PostMapping("/calculate")
    public ModelAndView calculate(@Valid CalculationInput input) throws Exception {
        log.info("Received calculation request. Input: {}", input);
        List<CalculationResult> results = calculationService.calculate(input);
        String fileName = csvService.saveToCsv(results);

        ModelAndView modelAndView = new ModelAndView("results");
        modelAndView.addObject("input", input);
        modelAndView.addObject("resultFile", "/results/" + fileName);
        return modelAndView;
    }

    @GetMapping("/results/{fileName}")
    public ResponseEntity<Resource> downloadResultFile(@PathVariable String fileName) {
        String fileContent = csvService.getCsvFileContent(fileName);
        ByteArrayResource resource = new ByteArrayResource(fileContent.getBytes(StandardCharsets.UTF_8));
        return ResponseEntity.ok()
                .contentLength(fileContent.length())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }
}
