package com.exporter.service;

import com.exporter.dto.DefaultExcelRowDTO;
import com.exporter.repository.ExcelFileRepository;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Roman Voloboev
 */

@Service
public class DefaultExcelFileReader implements ExcelFileReader {


    @Autowired
    private ExcelFileRepository excelFileRepository;

    @Transactional
    @Override
    public List<DefaultExcelRowDTO> readContentFromFile(Integer id) throws IOException {
        List<DefaultExcelRowDTO> rowDTOs = new ArrayList<>();
        if (excelFileRepository.exists(id)) {
            byte[] content = excelFileRepository.getOne(id).getContent();
            ByteArrayInputStream inputStream = new ByteArrayInputStream(content);
            HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
            HSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.rowIterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                rowDTOs.add(new DefaultExcelRowDTO(row.getCell(0).getStringCellValue(), row.getCell(1).getStringCellValue(),
                        row.getCell(2).getStringCellValue(), row.getCell(3).getStringCellValue(),
                        row.getCell(4).getStringCellValue(), row.getCell(5).getStringCellValue(),
                        row.getCell(6).getStringCellValue(), row.getCell(7).getStringCellValue()));
            }
        }
        return rowDTOs;
    }
}
