package org.sid.serviceinventory;

import org.sid.serviceinventory.entities.Product;
import org.sid.serviceinventory.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class ServiceInventoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceInventoryApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProductRepository productRepository, RepositoryRestConfiguration restConfiguration){
        restConfiguration.exposeIdsFor(Product.class);
        return args ->{
            productRepository.save((new Product(null,"Hp",788,25)));
            productRepository.save((new Product(null,"Iphon Z",88,240)));
            productRepository.save((new Product(null,"Azus",1288,40)));
            productRepository.findAll().forEach(p->{
                System.out.println(p.getName());
            });
        };
    }
}
