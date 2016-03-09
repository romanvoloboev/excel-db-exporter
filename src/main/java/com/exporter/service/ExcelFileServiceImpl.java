package com.exporter.service;

import com.exporter.dto.ExcelFileDTO;
import com.exporter.model.ExcelFile;
import com.exporter.repository.ExcelFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Roman Voloboev
 */

@Service
public class ExcelFileServiceImpl implements ExcelFileService {

    @Autowired
    private CustomerServiceImpl customerService;

    @Autowired
    private ExcelFileRepository excelFileRepository;

    @Override
    public Map<String, String> uploadFile(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        double size;
        double KBytes = (file.getSize() / 1024);
        if (KBytes < 1024) {
            size = KBytes / 1000;
        } else {
            size = KBytes / 1024;
        }
        size = round(size, 2);
        ExcelFile excelFile = new ExcelFile(fileName, size, new Date(), customerService.selectAuth(), file.getBytes());
        saveFileToDb(excelFile);
        Map<String, String> map = new HashMap<>();
        map.put("status", "ok");
        return map;
    }

    @Transactional(readOnly = true)
    @Override
    public ExcelFileDTO getFileDTO(Integer id) {
        ExcelFile file = excelFileRepository.getOne(id);
        return new ExcelFileDTO(file.getId(), file.getFileName(), file.getFileSize(),
                formatDateToString(file.getUploadDate()), file.getCustomer().getLogin());
    }

    private void saveFileToDb(ExcelFile file) {
        excelFileRepository.save(file);
    }

    private double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}
