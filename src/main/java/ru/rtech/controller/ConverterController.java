package ru.rtech.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ru.rtech.model.RequestBodyFieldDto;
import ru.rtech.service.FileService;

@RestController
@RequiredArgsConstructor
public class ConverterController {

    private final FileService fileService;

    @PostMapping(value = "/convert", consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public void getScvFile(
            @RequestPart(value = "file") final MultipartFile multipartFile,
            @RequestPart(value = "body") RequestBodyFieldDto requestDto) {
        fileService.convertSVCToSQLScriptFile(multipartFile, requestDto);
    }

    @PostMapping(value = "/update", consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<Resource> updateScvFile(
            @RequestPart(value = "file") final MultipartFile multipartFile,
            @RequestPart(value = "body") RequestBodyFieldDto requestDto) {
        return ResponseEntity.ok(fileService.updateSVCToSQLScriptFile(multipartFile, requestDto));
    }

}
