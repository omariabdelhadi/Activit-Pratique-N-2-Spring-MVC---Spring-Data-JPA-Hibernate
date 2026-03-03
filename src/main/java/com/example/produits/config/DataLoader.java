package com.example.produits.config;

import com.example.produits.entity.Product;
import com.example.produits.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
@Slf4j
public class DataLoader {

    @Bean
    CommandLineRunner loadData(ProductRepository productRepository) {
        return args -> {
            log.info("========== Début du chargement des données de test ==========");

            // Créer et sauvegarder des produits
            Product product1 = new Product(null, "Laptop", new BigDecimal("999.99"), 5);
            Product product2 = new Product(null, "Souris", new BigDecimal("25.50"), 150);
            Product product3 = new Product(null, "Clavier Mécanique", new BigDecimal("149.99"), 25);
            Product product4 = new Product(null, "Écran 27 pouces", new BigDecimal("349.99"), 12);
            Product product5 = new Product(null, "USB-C Cable", new BigDecimal("15.99"), 200);

            log.info("Sauvegarde des produits...");
            productRepository.save(product1);
            productRepository.save(product2);
            productRepository.save(product3);
            productRepository.save(product4);
            productRepository.save(product5);

            log.info("========== Liste de tous les produits ==========");
            productRepository.findAll().forEach(product ->
                    log.info("ID: {}, Nom: {}, Prix: {}, Quantité: {}",
                            product.getId(),
                            product.getName(),
                            product.getPrice(),
                            product.getQuantity())
            );

            log.info("========== Statistiques ==========");
            long totalProducts = productRepository.count();
            log.info("Nombre total de produits: {}", totalProducts);

            log.info("========== Test de récupération par ID ==========");
            productRepository.findById(1L).ifPresentOrElse(
                    product -> log.info("Produit trouvé: {}", product),
                    () -> log.warn("Produit avec ID 1 non trouvé")
            );

            log.info("========== Fin du chargement des données de test ==========");
        };
    }
}
