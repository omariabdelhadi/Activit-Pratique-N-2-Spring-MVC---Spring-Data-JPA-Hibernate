package org.example.activiter2;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    
    private final ProductRepository productRepository;
    
    /**
     * Affiche la liste de tous les produits
     */
    @GetMapping
    public String listProducts(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "products";
    }
    
    /**
     * Affiche le formulaire pour créer un nouveau produit
     */
    @GetMapping("/new")
    public String showProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "formProduct";
    }
    
    /**
     * Affiche le formulaire pour éditer un produit existant
     */
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            model.addAttribute("product", product.get());
            return "formProduct";
        }
        return "redirect:/products";
    }
    
    /**
     * Sauvegarde un nouveau produit
     */
    @PostMapping("/save")
    public String saveProduct(@Valid @ModelAttribute("product") Product product, 
                              BindingResult result) {
        if (result.hasErrors()) {
            return "formProduct";
        }
        productRepository.save(product);
        return "redirect:/products";
    }
    
    /**
     * Met à jour un produit existant
     */
    @PostMapping("/update")
    public String updateProduct(@Valid @ModelAttribute("product") Product product, 
                                BindingResult result) {
        if (result.hasErrors()) {
            return "formProduct";
        }
        productRepository.save(product);
        return "redirect:/products";
    }
    
    /**
     * Supprime un produit
     */
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
        return "redirect:/products";
    }
}
