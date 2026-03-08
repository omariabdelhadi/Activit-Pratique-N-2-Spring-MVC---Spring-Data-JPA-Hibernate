package org.example.activiter2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Le nom du produit est requis")
    @Size(min = 3, max = 100, message = "Le nom doit contenir entre 3 et 100 caractères")
    @Column(nullable = false)
    private String name;
    
    @NotNull(message = "Le prix est requis")
    @DecimalMin(value = "0.0", message = "Le prix doit être positif")
    @Digits(integer = 10, fraction = 2, message = "Le prix doit avoir au maximum 10 chiffres et 2 décimales")
    @Column(nullable = false)
    private BigDecimal price;
    
    @NotNull(message = "La quantité est requise")
    @Min(value = 0, message = "La quantité doit être supérieure ou égale à 0")
    @Max(value = 999999, message = "La quantité est trop grande")
    @Column(nullable = false)
    private Integer quantity;
}
