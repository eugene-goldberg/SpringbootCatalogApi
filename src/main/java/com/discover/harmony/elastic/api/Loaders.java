package com.discover.harmony.elastic.api;

import com.discover.harmony.elastic.model.BusinessMetadata;
import com.discover.harmony.elastic.model.Customer;
//import com.discover.harmony.elastic.repository.CustomerRepository;
import com.discover.harmony.elastic.api.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

//@Configuration

@Component
public class Loaders {

    @Autowired
    private CustomerRepository repository;

    @PostConstruct
    @Transactional
    public void loadAll(){
        this.repository.deleteAll();
        saveCustomers();
        fetchAllCustomers();
        fetchIndividualCustomers();

    }

    private void saveCustomers() {
        this.repository.save(new Customer("Alice", "Smith"));
        this.repository.save(new Customer("Bob", "Smith"));
    }

    private void fetchAllCustomers() {
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (Customer customer : this.repository.findAll()) {
            System.out.println(customer);
        }
        System.out.println();
    }

    private void fetchIndividualCustomers() {
        System.out.println("Customer found with findByFirstName('Alice'):");
        System.out.println("--------------------------------");
        System.out.println(this.repository.findByFirstName("Alice"));

        System.out.println("Customers found with findByLastName('Smith'):");
        System.out.println("--------------------------------");
        for (Customer customer : this.repository.findByLastName("Smith")) {
            System.out.println(customer);
        }
    }

    private List<BusinessMetadata> getData() {
        List<BusinessMetadata> metadata = new ArrayList<>();
        metadata.add(new BusinessMetadata((long)1,"TradeLine"));
        metadata.add(new BusinessMetadata((long)2,"Credit Line"));
        metadata.add(new BusinessMetadata((long)3,"Other Line"));

        return metadata;
    }
}
