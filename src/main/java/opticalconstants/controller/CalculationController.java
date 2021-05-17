package opticalconstants.controller;

import lombok.RequiredArgsConstructor;
import opticalconstants.model.CalculationInput;
import opticalconstants.service.CalculationParam;
import opticalconstants.service.CalculationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class CalculationController {

    private static final Logger log = LoggerFactory.getLogger(CalculationController.class);
    private final CalculationService calculationService;

    public CalculationController(CalculationService calculationService) {
        this.calculationService = calculationService;
    }

    @GetMapping("/")
    public String showInputPage() {
        return "index";
    }

    @PostMapping("/calculate")
    public List<CalculationParam> calculate(@RequestBody CalculationInput input) {
        log.info("Received calculation request. Input: {}", input);
        return calculationService.calculate(input);
    }
}
