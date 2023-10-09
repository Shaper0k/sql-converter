package ru.rtech.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;
import ru.rtech.model.RequestBodyFieldDto;

public interface FileService {
    Resource convertSVCToSQLScriptFile(MultipartFile file, RequestBodyFieldDto requestDto);

}
