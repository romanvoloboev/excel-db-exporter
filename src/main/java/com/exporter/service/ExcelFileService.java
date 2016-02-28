package com.exporter.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

/**
 * @author Roman Voloboev
 */

public interface ExcelFileService {
    Map<String, String> uploadFile(MultipartFile file) throws IOException;
}
