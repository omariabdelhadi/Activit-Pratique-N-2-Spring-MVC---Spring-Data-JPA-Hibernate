# Gestion des Produits - Mini Projet Spring Boot

## 🎯 Objectif
Développer une application Web JEE capable de gérer des produits en utilisant **Spring Boot, JPA/Hibernate, Spring Data, Thymeleaf et Spring Security**.  
À ce stade, le projet couvre la **couche backend, la couche DAO et les vues avec CRUD complet**.

---

## 🧩 Parties réalisées

### 1️⃣ Création du projet Spring Boot
- Dépendances ajoutées : Spring Web, Spring Data JPA, H2/MySQL, Thymeleaf, Lombok, Spring Security, Spring Validation
- Projet initial prêt à exécuter

### 2️⃣ Création de l’entité Product
- Champs : `id`, `name`, `price`, `quantity`
- Annotations JPA (`@Entity`, `@Id`, etc.) et Lombok (`@Data`, `@NoArgsConstructor`, `@AllArgsConstructor`) ajoutées

### 3️⃣ Création de ProductRepository
- Interface étendant `JpaRepository<Product, Long>`
- Permet de faire toutes les opérations CRUD (create, read, update, delete) automatiquement sans SQL

### 4️⃣ Test de la couche DAO
- Utilisation de `DataLoader.java` pour insérer des produits de test au démarrage
- Vérification de `save()`, `findAll()`, `findById()` et `count()`
- Les données sont stockées dans la base configurée dans `application.properties` (H2 ou MySQL)

### 5️⃣ Injection de dépendances
- DAO et Service injectés via Spring
- Les objets Repository et Services sont utilisés automatiquement par Spring Boot

### 6️⃣ Controller + vues Thymeleaf (CRUD)
- **ProductController** : reçoit les requêtes HTTP pour `/products`, `/products/new`, `/products/save`, etc.
- **Thymeleaf templates** :
  - `products.html` : affiche la liste de tous les produits
  - `formProduct.html` : formulaire pour ajouter ou modifier un produit
  - `layout.html` : template général avec header/footer et Bootstrap
- Fonctionnalités :
  - Afficher la liste des produits
  - Ajouter un produit avec validation du formulaire
  - Modifier un produit existant
  - Supprimer un produit
- Méthodes utilisées :
  - `@GetMapping` → pour afficher les pages
  - `@PostMapping` → pour traiter les formulaires
  - `model.addAttribute(...)` → passer les données aux pages Thymeleaf
  - `redirect:/products` → retour à la liste après un CRUD

---

## ✅ Résultat obtenu
- La couche **backend** fonctionne avec JPA/Hibernate et Spring Data
- La **base de données** contient des produits de test
- La **couche web** fonctionne avec Thymeleaf et Bootstrap
- Toutes les opérations CRUD sont testées et fonctionnelles

---

## 📂 Structure du projet actuelle
src/
├── main/
│ ├── java/
│ │ └── com/example/produits/
│ │ ├── config/
│ │ │ ├── DataLoader.java
│ │ │ └── SecurityConfig.java
│ │ ├── controller/
│ │ │ └── ProductController.java
│ │ ├── entity/
│ │ │ └── Product.java
│ │ └── repository/
│ │ └── ProductRepository.java
│ └── resources/
│ ├── templates/
│ │ ├── layout.html
│ │ ├── products.html
│ │ └── formProduct.html
│ └── application.properties


---

## 🏁 Conclusion
À ce stade du projet :
- La **base de données** est initialisée et peuplée avec des produits de test
- La **couche DAO** fonctionne via Spring Data JPA
- Les **contrôleurs et vues Thymeleaf** permettent l’affichage et la gestion complète des produits (CRUD)  
- L’application est prête pour **la sécurisation avec Spring Security** et l’ajout de fonctionnalités supplémentaires (recherche, filtres, etc.)