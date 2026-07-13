https://start.spring.io/

./mvnw spring-boot:build-image "-Dspring-boot.build-image.imageName=ergintiravoglu/jobappimage"

docker push ergintiravoglu/jobappimage

docker pull ergintiravoglu/jobappimage

docker run -it -d -p 80:8080 --name jobappimage ergintiravoglu/jobappimage

docker run -d --name db -e POSTGRES_PASSWORD=psswrd postgres
docker run -d --name pgadmin -e PGADMIN_DEFAULT_EMAIL=admin@admin.com -e PGADMIN_DEFAULT_PASSWORD=psswrd dpage/pgadmin
