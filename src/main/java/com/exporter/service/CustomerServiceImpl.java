package com.exporter.service;

import com.exporter.model.Customer;
import com.exporter.model.ExcelFile;
import com.exporter.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Roman Voloboev
 */

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Transactional(readOnly = true)
    @Override
    public Customer selectModel(String login) {
        return customerRepository.getCustomerByLogin(login);
    }

    @Transactional(readOnly = true)
    @Override
    public Customer selectAuth() {
        try {
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            return selectModel(userDetails.getUsername());
        } catch (Exception e) {
            return null;
        }
    }

    @Transactional
    @Override
    public List<ExcelFile> getCurrentCustomerFilesList() {
        return selectAuth().getFiles();
    }
}
