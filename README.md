# Adding tenants without application restart in SaaS style multi-tenant web app with Spring Boot 2 and Spring Security 5
SaaS application style multi-tenancy with database per tenant using Spring Boot 2 + JPA + Hibernate + Spring Security 5. This app
is built with MsSQL as the database. It can be adapted to use any other database like MySQL Server.

**Note:** This app reads the tenant information from a separate database table and does not require an application restart when new tenants are added.


## Getting Started

This is a typical maven project. Download the source as a zip file or checkout the code 
and import as an Existing Maven project in your IDE.

### Prerequisites

* Java 8
* Spring Boot 2
* MsSQL
* Not mandatory, but you can use any suitable IDE like Spring STS


## Authors

* **Sujith Kumar Sirisanagandla** - *Initial work* - [Sj]



## License

This project is licensed under the Apache License - see the [LICENSE.md](LICENSE.md) file for details

