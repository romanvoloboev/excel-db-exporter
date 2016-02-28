package com.exporter.service;

import com.exporter.model.Customer;
import com.exporter.model.ExcelFile;

import java.util.List;

/**
 * @author Roman Voloboev
 */

public interface CustomerService {
    Customer selectModel(String login);
    Customer selectAuth();
    List<ExcelFile> getCurrentCustomerFilesList();
}
