package opticalconstants.mapper;

import opticalconstants.model.ChartData;
import opticalconstants.service.CalculationResult;
import org.apache.commons.math3.util.Precision;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ChartDataMapper {

    public ChartData toChartDataRecords(List<CalculationResult> calculationResults) {
        var chartData = new ChartData();
        var nList = calculationResults.stream()
                .map(CalculationResult::getN)
                .map(x -> Precision.round(x, 4))
                .collect(Collectors.toList());
        var tCalcList = calculationResults.stream()
                .map(CalculationResult::getTCalc)
                .map(x -> Precision.round(x, 4))
                .collect(Collectors.toList());
        var rCalcList = calculationResults.stream()
                .map(CalculationResult::getRCalc)
                .map(x -> Precision.round(x, 4))
                .collect(Collectors.toList());
        var tExpList = calculationResults.stream()
                .map(CalculationResult::getTExp)
                .map(x -> Precision.round(x, 4))
                .collect(Collectors.toList());
        var rExpList = calculationResults.stream()
                .map(CalculationResult::getRExp)
                .map(x -> Precision.round(x, 4))
                .collect(Collectors.toList());

        chartData.setNList(nList)
                .addDataSet("Tcalc", tCalcList)
                .addDataSet("Rcalc", rCalcList)
                .addDataSet("Texp", tExpList)
                .addDataSet("Rexp", rExpList);
        return chartData;
    }
}
