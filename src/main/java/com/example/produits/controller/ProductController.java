package com.example.produits.controller;

import com.example.produits.entity.Product;
import com.example.produits.repository.ProductRepository;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private final ProductRepository productRepository;

    /**
     * Afficher la liste de tous les produits
     */
    @GetMapping
    public String listProducts(Model model) {
        log.info("Récupération de la liste des produits");
        model.addAttribute("products", productRepository.findAll());
        return "products";
    }

    /**
     * Afficher le formulaire pour ajouter un nouveau produit
     */
    @GetMapping("/new")
    public String showProductForm(Model model) {
        log.info("Affichage du formulaire d'ajout de produit");
        model.addAttribute("product", new Product());
        return "formProduct";
    }

    /**
     * Sauvegarder un produit avec validation
     */
    @PostMapping("/save")
    public String saveProduct(@Valid @ModelAttribute Product product, 
                              BindingResult result,
                              Model model) {
        if (result.hasErrors()) {
            log.warn("Erreurs de validation lors de la sauvegarde du produit: {}", 
                    result.getFieldErrors());
            return "formProduct";
        }

        try {
            productRepository.save(product);
            log.info("Produit sauvegardé avec succès: {}", product.getName());
        } catch (Exception e) {
            log.error("Erreur lors de la sauvegarde du produit", e);
            model.addAttribute("error", "Erreur lors de la sauvegarde du produit");
            return "formProduct";
        }

        return "redirect:/products";
    }

    /**
     * Supprimer un produit par ID
     */
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        try {
            if (productRepository.existsById(id)) {
                productRepository.deleteById(id);
                log.info("Produit supprimé avec ID: {}", id);
            } else {
                log.warn("Tentative de suppression d'un produit inexistant avec ID: {}", id);
            }
        } catch (Exception e) {
            log.error("Erreur lors de la suppression du produit avec ID: {}", id, e);
        }

        return "redirect:/products";
    }
}
