package opticalconstants.service;

import opticalconstants.model.CalculationInput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CalculationService {

    public static final Logger log = LoggerFactory.getLogger(CalculationService.class);

    public void calculate(CalculationInput input) {
        log.info("Start calculation!");
        for (double n = 0; n <= 10; n+=0.01) {
            CalculationParam calculationParam = new CalculationParam(
                    input.getLambda(),
                    input.getDFilm(),
                    input.getK(),
                    input.getN0(),
                    input.getN2(),
                    input.getTSub(),
                    input.getRSub(),
                    n
                    );
        }
        log.info("Finish calculation!");
    }
}
