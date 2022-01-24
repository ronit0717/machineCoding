package com.rccode.service;

import com.rccode.model.Customer;

public interface CustomerService {
    Customer addCustomer(String name);
    Customer getCustomerByName(String name);
}
