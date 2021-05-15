package opticalconstants.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CalculationInput {

    private Double lambda;
    private Double k;
    private Integer precision;
    private Double dFilm;
    private Double rSub;
    private Double tSub;
    private Double n0;
    private Double n2;

}
