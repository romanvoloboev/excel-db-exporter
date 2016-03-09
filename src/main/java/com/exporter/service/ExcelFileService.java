package com.exporter.service;

import com.exporter.dto.ExcelFileDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @author Roman Voloboev
 */

public interface ExcelFileService {
    Map<String, String> uploadFile(MultipartFile file) throws IOException;
    ExcelFileDTO getFileDTO(Integer id);

    default String formatDateToString(Date date) {
        if (date == null) return "";
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
        dateFormat.setLenient(false);
        return dateFormat.format(date);
    }
}
