package com.exporter.service;

import com.exporter.model.Customer;

public interface CustomerService {
    Customer selectModel(String login);
    Customer selectAuth();
}
