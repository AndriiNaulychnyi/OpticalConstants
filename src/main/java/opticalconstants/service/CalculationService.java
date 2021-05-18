package opticalconstants.service;

import opticalconstants.model.CalculationInput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalculationService {

    public static final Logger log = LoggerFactory.getLogger(CalculationService.class);

    public List<CalculationResult> calculate(CalculationInput input) {
        log.info("Start calculation!");
        List<CalculationResult> calculationResults = new ArrayList<>();
        for (double n = 0; n <= 10; n+=0.01) {
            CalculationResult calculationResult = new CalculationResult(
                    input.getLambda(),
                    input.getDFilm(),
                    input.getK(),
                    input.getN0(),
                    input.getN2(),
                    input.getTSub(),
                    input.getRSub(),
                    input.getTExp(),
                    input.getRExp(),
                    n);

            calculationResults.add(calculationResult);
        }
        log.info("Calculation finished!");
        return calculationResults;
    }
}
