# spring-crud-mysql-ssp
To create a CRUD (Create, Read, Update, Delete) application using Spring Boot with MySQL, you can follow these steps:

1. Set up your development environment with Spring Boot and MySQL.
2. Create an entity class representing your data model, annotated with `@Entity` and `@Table` annotations.
3. Implement repository interfaces using Spring Data JPA to perform CRUD operations.
4. Create RESTful APIs using Spring MVC to expose the CRUD endpoints.
5. Configure the MySQL database connection details in your application.properties or application.yml file.
6. Build and run the Spring Boot application.

## DataTables with Server-Side Processing

To implement DataTables with server-side processing, you can use the following steps:

1. Include the DataTables library in your project, either by downloading the files or using a CDN.
2. Configure your server to handle server-side processing requests from DataTables.
3. Implement the server-side logic to handle requests from DataTables, including pagination, sorting, and filtering.
4. Return the response in the appropriate format (e.g., JSON) to DataTables.

## jQuery and Angular

jQuery and Angular are popular JavaScript libraries/frameworks used for web development.

- jQuery is a fast and concise JavaScript library that simplifies HTML document traversal, event handling, and animation.
- Angular is a powerful framework for building web applications, developed and maintained by Google.

Both jQuery and Angular provide features for DOM manipulation, event handling, and AJAX requests. However, Angular provides a more comprehensive framework for building large-scale applications with features like two-way data binding, dependency injection, and component-based architecture.

## MySQL with Liquibase Auto-Create Table

Liquibase is an open-source database-independent migration framework that provides a way to manage database schema changes over time. With Liquibase, you can version control your database schema and apply changes in a controlled manner.

To auto-create tables in MySQL using Liquibase, follow these steps:

1. Include the Liquibase library in your project dependencies.
2. Create a Liquibase changelog file (e.g., `changelog.xml` or `changelog.yaml`) to define your database changes.
3. Specify the table structures and modifications in the changelog file using Liquibase XML or YAML syntax.
4. Configure the MySQL database connection details in your Liquibase properties file.
5. Run your application or execute the Liquibase command-line tool to apply the database changes.

## Database Configuration Details

- Database Name: demodb
- Username: demo
- Password: demo123

Make sure to update the database configuration properties in your Spring Boot application.properties or application.yml file accordingly.

![Alt text](screenshoot.png?raw=true "Optional Title")