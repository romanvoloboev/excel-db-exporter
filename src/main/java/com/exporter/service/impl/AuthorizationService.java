package com.exporter.service.impl;

import com.exporter.model.Customer;
import com.exporter.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class AuthorizationService implements UserDetailsService {
    private static final Logger LOGGER = Logger.getLogger(AuthorizationService.class.getName());

    @Autowired private CustomerService customerService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Customer customer = null;
        try {
            customer = customerService.selectModel(login);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        }
        if (customer != null) {
                List<GrantedAuthority> authorities = new ArrayList<>();
                return new User(customer.getLogin(), customer.getPassword(), authorities);
        } else {
            throw new UsernameNotFoundException("Customer not found");
        }
    }
}
