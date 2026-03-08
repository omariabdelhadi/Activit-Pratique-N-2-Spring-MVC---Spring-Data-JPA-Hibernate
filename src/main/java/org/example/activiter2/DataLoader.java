package org.example.activiter2;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    
    private final ProductRepository productRepository;
    
    @Override
    public void run(String... args) throws Exception {
        // Créer des produits de test
        productRepository.save(new Product(null, "Laptop", new BigDecimal("999.99"), 10));
        productRepository.save(new Product(null, "Souris", new BigDecimal("25.50"), 50));
        productRepository.save(new Product(null, "Clavier", new BigDecimal("75.00"), 30));
        productRepository.save(new Product(null, "Moniteur", new BigDecimal("299.99"), 15));
        productRepository.save(new Product(null, "Casque Audio", new BigDecimal("150.00"), 20));
    }
}
