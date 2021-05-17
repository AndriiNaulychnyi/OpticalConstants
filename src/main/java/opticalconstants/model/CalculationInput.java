package opticalconstants.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class CalculationInput {

    @NotNull
    private Double lambda;
    @NotNull
    private Double k;
    @NotNull
    private Integer precision;
    @NotNull
    private Double dFilm;
    @NotNull
    private Double rSub;
    @NotNull
    private Double tSub;
    @NotNull
    private Double n0;
    @NotNull
    private Double n2;

}
