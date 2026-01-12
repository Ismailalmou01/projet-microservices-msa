# Projet Architecture Microservices - Gestion de Bibliothèque

##
* **Nom :** ALMOU
* **Prénom :** Ismail
* **DSE**

---

## Architecture du Système
Ce projet implémente une architecture microservices complète avec une communication hybride :
* **Synchrone (OpenFeign)** : Pour les vérifications (User/Book) lors de la création d'un emprunt.
* **Asynchrone (Apache Kafka)** : Pour l'envoi de notifications en temps réel.

### Liste des Microservices :
* **Eureka Server** : Annuaire des services (Port 8761).
* **API Gateway** : Point d'entrée unique (Port 9999).
* **User Service** : Gestion des abonnés (Port 8081).
* **Book Service** : Gestion du catalogue (Port 8082).
* **Emprunt Service** : Gestion des prêts et Producteur Kafka (Port 8085).
* **Notification Service** : Consommateur Kafka (Port 8084).

---

## Guide d'Installation

### 1. Pré-requis
* **Java 21** ou supérieur.
* **Maven 3.8+**.
* **Docker Desktop** (avec Docker Compose).

### 2. Déploiement avec Docker
À la racine du projet (`microservicesapp`), exécutez :
```bash
docker-compose up --build
 ```
## Scénario de Test et Résultats :
### Étape 1 : Création d'un Utilisateur
* **Appel :** POST http://localhost:9999/user-service/users

* **Résultat :** Statut 201 Created. L'utilisateur est persisté en base de données.

### Étape 2 : Création d'un Emprunt (Flux Complet)
* **Appel :** POST http://localhost:9999/emprunt-service/emprunts/1/1

* **Résultat :** Statut 200 OK. Le service emprunt a validé les IDs via Feign et a envoyé un message au broker Kafka.

### Étape 3 : Validation Kafka (Notification)
Pour confirmer la réception asynchrone :
``` bash
docker logs notification-service
```
Affichage dans les logs :
````bash
NOTIFICATION REÇUE : Emprunt n°1 | Utilisateur ID : 1 | Livre ID : 1
````