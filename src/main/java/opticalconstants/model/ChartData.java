package opticalconstants.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Data
@Accessors(chain = true)
public class ChartData {

    private List<Double> nList;
    private List<Dataset> datasets;

    public ChartData addDataSet(String label, List<Double> data) {
        if (datasets == null) {
            datasets = new ArrayList<>();
        }
        datasets.add(new Dataset(label, data));
        return this;
    }

    @Data
    @AllArgsConstructor
    private static class Dataset {
        private String label;
        private List<Double> data;
    }
}
