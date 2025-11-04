# 🚖 Rider App Backend API

**Rider App** is a Java-based **Spring Boot** application that orchestrates the **ride-booking lifecycle**, including **driver matching**, **payment**, and **user authentication** for a scalable ride service.  
It is architected as a **stateless backend** using **JWTs** to enable **horizontal scalability**.

---

## 🚀 Key Backend Features

### 🔑 JWT-Based Authentication
- Stateless user authentication using **Access** and **Refresh Tokens**.  
- Refresh Token is secured with **httpOnly cookies** for enhanced security.

### 🗺️ Geo-Spatial Matching
- Leverages **PostgreSQL GeoSpatial** capabilities (`ST_DWithin`, `ST_Distance`) for **low-latency driver proximity searches**.

### 🧠 Strategy Pattern Implementation
- Uses **pluggable strategies** for flexible and extensible logic:
  - **Driver Matching:** Nearest vs. Top-Rated  
  - **Fare Calculation:** Default vs. Surge Pricing  
  - **Payment Processing:** Wallet vs. Cash  

### 💰 Transactional Wallet
- Manages user balances with **financial consistency** ensured via:
  - **Optimistic Locking**
  - **Database Transactions**

---

## 🛠️ Prerequisites & Dependencies

Before you begin, make sure the following are installed:

| Dependency | Version | Purpose |
|-------------|----------|----------|
| **Java Development Kit (JDK)** | 17+ | Required to run the application |
| **Maven** | 3.6.0+ | For project build and dependency management |
| **PostgreSQL** | — | Required for GeoSpatial features |

---

## ⚙️ Installation & Setup Instructions

### 1️⃣ Clone the Repository
-git clone https://github.com/Kranti-Kumar/Rider-App.git
-cd Rider-App

### 2️⃣ Configure Database

-Ensure your PostgreSQL database is running and update the connection details in
-src/main/resources/application.properties (or use environment variables):

-spring.datasource.url=jdbc:postgresql://localhost:5432/riderdb
-spring.datasource.username=postgres
-spring.datasource.password=yourpassword

### 3️⃣ Build the Project
-mvn clean install

### 4️⃣ Run the Application

-Option 1: Using Maven

-mvn spring-boot:run


-Option 2: Using the JAR file
-After building, run:

java -jar target/RiderApp-0.0.1-SNAPSHOT.jar

### 🧭 Core API Endpoints

All protected endpoints require a valid JWT in the Authorization: Bearer <token> header.

-Module	Endpoint	Method	Security	Description
-Auth	/auth/signup	POST	Public	Registers a new user/rider
-Auth	/auth/login	POST	Public	Issues JWTs and sets refresh token cookie
-Rider	/rider/requestRide	POST	RIDER	Submits a new ride request
-Driver	/driver/updateLocation	PATCH	DRIVER	Updates driver’s current GeoSpatial location
-Driver	/driver/acceptRide/{id}	POST	DRIVER	Accepts a pending ride request
-Admin	/auth/onBoardNewDriver/{userId}	POST	ADMIN	Converts an existing user to a driver


### 🧩 Tech Stack Summary

Backend: Spring Boot (Java 17)

Database: PostgreSQL with PostGIS

Auth: JWT, Spring Security

Build Tool: Maven

### 🏗️ Architecture Overview

The Rider App backend follows a modular service-based architecture, ensuring:

Clear separation of concerns

High scalability

Easy maintainability
