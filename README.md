# Gestion des Produits - Mini Projet Spring Boot

## 🎯 Objectif
Implémenter les bases d'une application Web JEE pour gérer des produits en utilisant **Spring Boot, JPA, Hibernate et Spring Data**.  
À ce stade, l’accent est mis sur la **création du projet, l’entité Product et la couche DAO**.

---

## 🧩 Partie réalisée

1. **Création du projet Spring Boot**  
   - Dépendances ajoutées : Spring Web, Spring Data JPA, H2, MySQL, Lombok  
   - Projet initial prêt à exécuter

2. **Création de l’entité Product**  
   - Champs : `id`, `name`, `price`, `quantity`  
   - Annotations JPA et Lombok ajoutées

3. **Création de ProductRepository**  
   - Interface étendant `JpaRepository<Product, Long>`  
   - Permet d’effectuer les opérations CRUD (save, findAll, findById, deleteById) sans SQL

4. **Test de la couche DAO**  
   - CommandLineRunner ou test simple pour vérifier que les produits sont bien enregistrés et lus depuis la base de données

---

## ✅ Résultat obtenu
- Une **base solide backend** fonctionnelle  
- Accès aux produits via **DAO / Repository**  
- Connexion à la base de données opérationnelle  
- Vérification que **JPA et Hibernate** fonctionnent correctement  
- Projet Spring Boot prêt pour intégrer le Web et la sécurité

---

## 🧠 Ce qui reste à faire
- Création des **Controllers Spring MVC**  
- Création des **vues Thymeleaf** pour afficher, ajouter, supprimer et modifier des produits  
- Sécurisation avec **Spring Security**  
- Ajout de fonctionnalités supplémentaires (recherche, édition, validation…)

---

## 📂 Structure du projet actuelle
src/
├── main/
│ ├── java/
│ │ └── ma/ensa/di/
│ │ ├── dao/
│ │ │ └── ProductRepository.java
│ │ └── metier/
│ │ └── Product.java
│ └── resources/
│ └── application.properties


> À ce stade, il n’y a **pas encore de Controller ni de vues**, seulement la couche **données**.

---

## 🏁 Conclusion
La première étape du projet est terminée : la **couche backend** est opérationnelle avec JPA, Hibernate et Spring Data.  
La prochaine étape sera de créer l’**interface web** et d’ajouter la **logique métier côté client**.
