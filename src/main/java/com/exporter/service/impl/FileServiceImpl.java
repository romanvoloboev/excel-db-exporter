package com.exporter.service.impl;

import com.exporter.dto.DefaultExcelRowDTO;
import com.exporter.dto.ExcelFileDTO;
import com.exporter.model.Content;
import com.exporter.model.File;
import com.exporter.repository.ContentRepository;
import com.exporter.repository.FileInfoRepository;
import com.exporter.service.FileService;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * @author Roman Voloboev
 */

@Service
public class FileServiceImpl implements FileService {
    private File file;

    @Autowired
    private CustomerServiceImpl customerService;

    @Autowired
    private FileInfoRepository fileInfoRepository;

    @Autowired
    private ContentRepository contentRepository;

    @Override
    public Map<String, String> readFile(MultipartFile uploadedFile) throws IOException {
        String fileName = uploadedFile.getOriginalFilename();

        double size;
        double KBytes = (uploadedFile.getSize() / 1024);
        if (KBytes < 1024) {
            size = KBytes / 1000;
        } else {
            size = KBytes / 1024;
        }
        size = round(size, 2);
        file = new File(fileName, size, new Date(), customerService.selectAuth());


        Map<String, String> map = new HashMap<>();
        map.put("status", "ok");
        return map;
    }

    @Transactional(readOnly = true)
    @Override
    public ExcelFileDTO getFileDTO(Integer id) {
        File file = fileInfoRepository.getOne(id);
        return new ExcelFileDTO(file.getId(), file.getFileName(), file.getFileSize(),
                formatDateToString(file.getUploadDate()), file.getCustomer().getLogin());
    }

    @Transactional
    @Override
    public List<ExcelFileDTO> getFilesList() {
        List<File> files = fileInfoRepository.findAll();
        List<ExcelFileDTO> excelFileDTOs = new ArrayList<>();
        if (!files.isEmpty()) {
            for (File file: files) {
                excelFileDTOs.add(new ExcelFileDTO(file.getId(), file.getFileName(), file.getFileSize(),
                        formatDateToString(file.getUploadDate()), file.getCustomer().getLogin()));
            }
            return excelFileDTOs;
        }
        return excelFileDTOs;
    }

    @Transactional
    @Override
    public void parseFile(MultipartFile file) throws IOException {
        byte[] content = file.getBytes();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(content);
        List<Content> contents = new ArrayList<>();
        switch (file.getContentType()) {
            //for .xls format
            case "application/vnd.ms-excel":
                HSSFWorkbook hssfWorkbook = new HSSFWorkbook(inputStream);
                HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);
                contents = readFormat(hssfSheet);
                break;
            //for .xlsx format
            case "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet":
                XSSFWorkbook xssfWorkbook = new XSSFWorkbook(inputStream);
                XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
                contents = readFormat(xssfSheet);
                break;
        }

        List<Content> contentAll = contentRepository.findAll();

        if (contentAll != null && !contentAll.isEmpty()) {
            Iterator<Content> contenrsFromDb = contentAll.listIterator();
            Iterator<Content> contentsFromFile = contents.listIterator();
            while (contenrsFromDb.hasNext() && contentsFromFile.hasNext()) {

            }
        } else {
            contentRepository.save(contents);
        }




   }


    private List<Content> readFormat(Sheet sheet) throws IOException {
        List<Content> contents = new ArrayList<>();
        Iterator<Row> rowIterator = sheet.rowIterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            contents.add(new Content(
                    row.getCell(0).getStringCellValue(),
                    row.getCell(1).getStringCellValue(),
                    row.getCell(2).getStringCellValue(),
                    row.getCell(3).getStringCellValue(),
                    row.getCell(4).getStringCellValue(),
                    row.getCell(5).getStringCellValue(),
                    row.getCell(6).getStringCellValue(),
                    row.getCell(7).getStringCellValue(),
                    row.getCell(8).getStringCellValue(),
                    row.getCell(9).getStringCellValue(),
                    row.getCell(10).getStringCellValue(),
                    row.getCell(11).getStringCellValue(),
                    row.getCell(12).getStringCellValue()));
        }
        return contents;
    }


    private void saveFileToDb(File file) {
        fileInfoRepository.save(file);
    }

    private double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}
