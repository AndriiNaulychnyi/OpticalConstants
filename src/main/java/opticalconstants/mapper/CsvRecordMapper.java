package opticalconstants.mapper;

import opticalconstants.model.CsvRecord;
import opticalconstants.service.CalculationResult;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CsvRecordMapper {

    List<CsvRecord> toCsvRecords(List<CalculationResult> calculationResults);

    CsvRecord toCsvRecords(CalculationResult calculationResult);
}
