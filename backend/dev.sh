#bin/bash

export SPRING_DATASOURCE_URL=jdbc:mysql://localhost:3306/product
export SPRING_DATASOURCE_USERNAME=product_user
export SPRING_DATASOURCE_PASSWORD=product_user_password

mvn clean package && mvn spring-boot:run
