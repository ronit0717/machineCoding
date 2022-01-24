package com.rccode.service.impl;

import com.rccode.model.Customer;
import com.rccode.repository.LedgerCoRepository;
import com.rccode.service.CacheService;
import com.rccode.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

    private LedgerCoRepository repository;
    private CacheService cacheService;

    private static final String KEY_PREFIX = "cust_";

    public CustomerServiceImpl(LedgerCoRepository repository, CacheService cacheService) {
        this.repository = repository;
        this.cacheService = cacheService;
    }

    /**
     * Adds a customer if not already present
     * @param name of the customer
     * @return Customer object
     */
    @Override
    public Customer addCustomer(String name) {
        Customer customer = getCustomerByName(name);
        if (customer == null) {
            customer = new Customer(name);
            repository.addCustomer(customer);
        }
        return customer;
    }

    /**
     * Returns the customer object. First check is done in cache, if cache miss, then repository is checked
     * @param name of the customer
     * @return Customer object
     */
    @Override
    public Customer getCustomerByName(String name) {
        String cacheKey = KEY_PREFIX + name.toLowerCase();
        Customer customer;

        try {
            customer = (Customer)cacheService.get(cacheKey);
            if (customer != null) {
                return customer;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        customer = repository.getCustomerByName(name);
        if (customer == null) {
            return null;
        }
        cacheService.put(cacheKey, customer);
        return customer;
    }

}
