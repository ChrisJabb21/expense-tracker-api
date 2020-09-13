### Chibibank Expense Tracker 

A expense tracker 

Spring Boot RESTful API made to connect with backend (repository,service,domain patterns) using JDBCTemplate along with user login and registration and tracking and implementing a session token for maintaining a session and controlling access. 

//to add to project board and wiki
(WIP to be expanded upon and planning to incorprate a frontend to project and trying to implement session tokens starting with JWT and considering Auth0 or Okta.)

### Getting Started
## Creating the Database

# PostgreSQL Set Up  
- download and install a postgreSQL server on postgresql.org
- create a superuser (default user is postgresql and set the password) and go through postgresql installation.

# Script execution
- set up the environment variable for postgresql (psql) based your machine
- run the command  ```psql -U postgres --file em_db.sql``` the command line in the project directory to create database on your machine

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.3.3.RELEASE/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.3.3.RELEASE/maven-plugin/reference/html/#build-image)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.3.3.RELEASE/reference/htmlsingle/#using-boot-devtools)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.3.3.RELEASE/reference/htmlsingle/#boot-features-developing-web-applications)
* [JDBC API](https://docs.spring.io/spring-boot/docs/2.3.3.RELEASE/reference/htmlsingle/#boot-features-sql)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/docs/2.3.3.RELEASE/reference/htmlsingle/#production-ready)



### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Accessing Relational Data using JDBC with Spring](https://spring.io/guides/gs/relational-data-access/)
* [Managing Transactions](https://spring.io/guides/gs/managing-transactions/)
* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)

* [Accessing data with PostgreSQL](https://spring.io/guides/gs/accessing-data-postgresql/)
