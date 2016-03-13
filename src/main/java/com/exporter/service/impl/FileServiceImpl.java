package com.exporter.service.impl;

import com.exporter.dto.ExcelFileDTO;
import com.exporter.model.RowItem;
import com.exporter.model.File;
import com.exporter.repository.RowItemRepository;
import com.exporter.repository.FileRepository;
import com.exporter.service.FileService;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.*;

@Service
public class FileServiceImpl implements FileService {
    private File file;

    @Autowired
    private CustomerServiceImpl customerService;

    @Autowired
    private FileRepository fileRepository;

    @Autowired
    private RowItemRepository rowItemRepository;

    @Transactional
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

        parseFile(uploadedFile);

        Map<String, String> map = new HashMap<>();
        map.put("status", "ok");
        return map;
    }

    @Transactional
    @Override
    public List<ExcelFileDTO> getFilesList() {
        List<File> files = fileRepository.findAll();
        List<ExcelFileDTO> excelFileDTOs = new ArrayList<>();
        if (!files.isEmpty()) {
            for (File file: files) {
                excelFileDTOs.add(new ExcelFileDTO(file.getId(), file.getFileName(), file.getFileSize(),
                        formatDateToString(file.getUploadDate()), file.getAddedRecordsCount(),
                        file.getIgnoredRecordsCount(), file.getCustomer().getLogin()));
            }
            return excelFileDTOs;
        }
        return excelFileDTOs;
    }

    @Transactional
    @Override
    public void parseFile(MultipartFile uploadedFile) throws IOException {
        byte[] content = uploadedFile.getBytes();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(content);
        List<RowItem> rowsFromFile = new ArrayList<>();
        switch (uploadedFile.getContentType()) {
            //for .xls format
            case "application/vnd.ms-excel":
                HSSFWorkbook hssfWorkbook = new HSSFWorkbook(inputStream);
                HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);
                rowsFromFile = readFormat(hssfSheet);
                break;
            //for .xlsx format
            case "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet":
                XSSFWorkbook xssfWorkbook = new XSSFWorkbook(inputStream);
                XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);
                rowsFromFile = readFormat(xssfSheet);
                break;
        }
        List<RowItem> rowsFromDB = rowItemRepository.findAll();
        int ignored = 0;
        int added;
        if (rowsFromDB != null && !rowsFromDB.isEmpty()) {
            for (RowItem rowFromDB : rowsFromDB) {
                for (Iterator<RowItem> fileIterator = rowsFromFile.iterator(); fileIterator.hasNext(); ) {
                    RowItem rowFromFile = fileIterator.next();
                    //если есть совпадение названия КА в бд и файле
                    if (rowFromDB.getKA().toUpperCase().equals(rowFromFile.getKA().toUpperCase())) {
                        //и если содержимое этих совпавших строк идентично
                        if (rowFromDB.equals(rowFromFile)) {
                            ignored++;
                            //то удаляем строку из коллекции, в которой загружены строки из файла
                            fileIterator.remove();
                        } else {
                            // если содержимое не идентично
                            // то удаляем из БД старую запись
                            rowItemRepository.delete(rowFromDB);
                        }
                    }
                }
            }
            rowItemRepository.save(rowsFromFile);
        } else {
            rowItemRepository.save(rowsFromFile);
        }
        added = rowsFromFile.size();
        file.setAddedRecordsCount(added);
        file.setIgnoredRecordsCount(ignored);
        fileRepository.save(file);
   }

    @Transactional(readOnly = true)
    public List<RowItem> getRowItems(){
        return rowItemRepository.findAll();
    }


    private List<RowItem> readFormat(Sheet sheet) throws IOException {
        List<RowItem> rowItems = new ArrayList<>();
        Iterator<Row> rowIterator = sheet.rowIterator();
        //пропускаем заголовки
        rowIterator.next();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            RowItem rowITem = new RowItem(
                    String.valueOf(row.getCell(0).getNumericCellValue()),
                    row.getCell(1).getStringCellValue(),
                    row.getCell(2).getStringCellValue(),
                    row.getCell(3).getStringCellValue(),
                    row.getCell(4).getStringCellValue(),
                    row.getCell(5).getStringCellValue(),
                    String.valueOf(row.getCell(6).getNumericCellValue()),
                    String.valueOf(row.getCell(7).getNumericCellValue()),
                    row.getCell(8).getStringCellValue(),
                    row.getCell(9).getStringCellValue(),
                    row.getCell(10).getStringCellValue(),
                    row.getCell(11).getStringCellValue(),
                    row.getCell(12).getStringCellValue());
            System.out.println(rowITem.toString());
            rowItems.add(rowITem);
        }
        return rowItems;
    }

    private double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}
