package opticalconstants.service;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import opticalconstants.mapper.CsvRecordMapper;
import opticalconstants.model.CsvRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CsvService {

    @Value("${csv.folder}")
    private String csvFolder;

    private final CsvRecordMapper mapper;

    @PostConstruct
    private void createCsvFolderIfNotExists() {
        new File(csvFolder).mkdirs();
    }

    public String saveToCsv(List<CalculationResult> itemsToSave) throws Exception {
        String fileName = String.format("%s_%s.csv", System.currentTimeMillis(), UUID.randomUUID());
        Writer writer = new FileWriter(csvFolder + fileName, false);

        StatefulBeanToCsv<CsvRecord> sbc = new StatefulBeanToCsvBuilder<CsvRecord>(writer)
                .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
                .build();

        sbc.write(mapper.toCsvRecords(itemsToSave));
        writer.close();
        return fileName;
    }


    @SneakyThrows
    public String getCsvFileContent(String fileName) {
        return Files.readString(new File(csvFolder + fileName).toPath());
    }
}
