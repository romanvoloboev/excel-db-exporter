package com.exporter.service;

import com.exporter.dto.ExcelFileDTO;
import com.exporter.model.Customer;
import com.exporter.model.ExcelFile;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Roman Voloboev
 */

public interface CustomerService {
    Customer selectModel(String login);
    Customer selectAuth();
    List<ExcelFileDTO> getCurrentCustomerFilesList();

    default String formatDateToString(Date date) {
        if (date == null) return "";
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
        dateFormat.setLenient(false);
        return dateFormat.format(date);
    }
}
