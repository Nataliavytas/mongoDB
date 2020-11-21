# MongoDB final work 

 To see the requirements please click [here](./work-requirements.pdf)​.
  
  ## Getting Started
  
  ### Prerequisites:
   - Java 11
   - Apache Maven 3.6.3 
   If you need to install it please follow the instructions in [Apache Maven](https://maven.apache.org/install.html) website 
   
   ### Installing
- Navigate to the project root directory.

  ```bash
  
   cd ~/mongoDB
  
   ```
  
- Build the project using Maven:
  
    ```bash
  
   mvn clean install
  
    ```
  
- Run the application:

  ```bash
  
   mvn spring-boot:run
  
  ```

- To access Swagger documentation and be able to test the endpoints open the following url in a browser:
  http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#/