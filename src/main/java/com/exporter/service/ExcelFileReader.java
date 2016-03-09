package com.exporter.service;

import com.exporter.dto.DefaultExcelRowDTO;

import java.io.IOException;
import java.util.List;

/**
 * @author Roman Voloboev
 */

public interface ExcelFileReader {
    List<DefaultExcelRowDTO> readContentFromFile(Integer id) throws IOException;
}
