package ru.rtech.service;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import ru.rtech.model.CsvFieldDto;

public interface CsvReadService {

    List<CsvFieldDto> getValuesFieldCsv(MultipartFile file);

}
