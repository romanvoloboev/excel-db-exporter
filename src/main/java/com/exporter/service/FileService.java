package com.exporter.service;

import com.exporter.dto.ExcelFileDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface FileService {
    Map<String, String> readFile(MultipartFile file) throws IOException;
    List<ExcelFileDTO> getFilesList();
    void parseFile(MultipartFile file) throws IOException;

    default String formatDateToString(Date date) {
        if (date == null) return "";
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
        dateFormat.setLenient(false);
        return dateFormat.format(date);
    }
}
