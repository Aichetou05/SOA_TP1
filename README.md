# Biblio-SOAP

A Spring Boot SOAP Web Service application for library management system (Bibliothèque). This project demonstrates how to build a SOAP-based web service using Spring Boot, JAXB, and XML Schema Definition (XSD).

## 📋 Table of Contents

- [Features](#features)
- [Technologies](#technologies)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Project Structure](#project-structure)
- [WSDL Documentation](#wsdl-documentation)

## ✨ Features

- **Book Management**: Complete CRUD operations for books
- **Borrow/Return System**: Track book availability and manage loans
- **SOAP Web Service**: Standard SOAP protocol implementation
- **XSD-based Contract**: XML Schema Definition for type-safe operations
- **Auto-generated Classes**: JAXB generates Java classes from XSD schema

## 🛠 Technologies

- **Java 17**
- **Spring Boot 3.5.8**
- **Spring Web Services** (SOAP)
- **JAXB** (Java Architecture for XML Binding)
- **Maven** (Build tool)
- **MySQL Connector** (Database driver - configured but using in-memory storage)
- **Spring Data JPA** (For future database integration)

## 📦 Prerequisites

Before running this project, make sure you have:

- **JDK 17** or higher
- **Maven 3.6+**
- **MySQL** (optional, currently using in-memory storage)

## 🚀 Installation

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd biblio-soap
   ```

2. **Build the project**
   ```bash
   mvn clean install
   ```

3. **Run the application**
   ```bash
   mvn spring-boot:run
   ```

   Or run the main class:
   ```bash
   java -jar target/biblio-soap-0.0.1-SNAPSHOT.jar
   ```

The application will start on `http://localhost:8080`

## 📖 Usage

### Accessing the WSDL

Once the application is running, you can access the WSDL definition at:

```
http://localhost:8080/ws/livres.wsdl
```

### SOAP Endpoint

The SOAP service is available at:

```
http://localhost:8080/ws
```

### Testing with SOAP Client

You can test the service using:
- **SoapUI**
- **Postman** (with SOAP support)
- **cURL** (with XML payloads)
- Any SOAP client tool

## 🔌 API Endpoints

The service provides the following SOAP operations:

| Operation | Description | Request | Response |
|-----------|-------------|---------|----------|
| `getLivre` | Get a book by ISBN | `getLivreRequest` (isbn) | `getLivreResponse` (livre) |
| `getAllLivres` | Get all books | `getAllLivresRequest` | `getAllLivresResponse` (livres[]) |
| `addLivre` | Add a new book | `addLivreRequest` (livre) | `addLivreResponse` (livre) |
| `updateLivre` | Update an existing book | `updateLivreRequest` (isbn, livre) | `updateLivreResponse` (livre) |
| `deleteLivre` | Delete a book by ISBN | `deleteLivreRequest` (isbn) | `deleteLivreResponse` (success) |
| `empruntLivre` | Borrow a book (set unavailable) | `empruntLivreRequest` (isbn) | `empruntLivreResponse` (livre) |
| `returnLivre` | Return a book (set available) | `returnLivreRequest` (isbn) | `returnLivreResponse` (livre) |

### Book Model (Livre)

```xml
<livre>
    <isbn>string</isbn>
    <titre>string</titre>
    <auteur>string</auteur>
    <anneePublication>int</anneePublication>
    <disponible>boolean</disponible>
</livre>
```

## 📁 Project Structure

```
biblio-soap/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── mr/supnum/biblio_soap/
│   │   │       ├── BiblioSoapApplication.java    # Main application class
│   │   │       ├── config/
│   │   │       │   └── WebServiceConfig.java     # SOAP configuration
│   │   │       ├── endpoint/
│   │   │       │   └── LivreEndpoint.java        # SOAP endpoints
│   │   │       └── service/
│   │   │           └── LivreService.java         # Business logic
│   │   └── resources/
│   │       ├── application.properties            # Application config
│   │       └── livre.xsd                         # XML Schema Definition
│   └── test/
│       └── java/
│           └── mr/supnum/biblio_soap/
│               └── BiblioSoapApplicationTests.java
├── pom.xml                                       # Maven configuration
└── README.md
```

## 📄 WSDL Documentation

The WSDL (Web Services Description Language) file is automatically generated from the XSD schema. It describes:

- **Namespace**: `http://supnum.mr/livres`
- **Port Type**: `LivresPort`
- **Location**: `/ws/livres.wsdl`

### Example SOAP Request (Get Book)

```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:liv="http://supnum.mr/livres">
   <soapenv:Header/>
   <soapenv:Body>
      <liv:getLivreRequest>
         <liv:isbn>ISBN-001</liv:isbn>
      </liv:getLivreRequest>
   </soapenv:Body>
</soapenv:Envelope>
```

## 🔧 Configuration

### Application Properties

The application configuration is in `src/main/resources/application.properties`:

```properties
spring.application.name=biblio-soap
```

### Maven Build

The project uses JAXB2 Maven Plugin to generate Java classes from the XSD schema during the build process. The generated classes are located in:

```
target/generated-sources/jaxb/mr/supnum/server_manager/wsdl/
```

## 📝 Notes

- Currently, the service uses in-memory storage (HashMap) for books
- The project includes MySQL connector dependency for future database integration
- Sample book is pre-loaded: ISBN-001 "Spring Boot SOAP" by SupNum (2024)

## 👥 Author

SupNum - SOA Course Project

## 📄 License

This project is part of a university course (SOA - Service-Oriented Architecture).

---

**Note**: This is a demonstration project for learning SOAP web services with Spring Boot.

