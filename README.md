Spring boot mysql


Add BRIDGE NETWORK

docker network create -d bridge my-bridge-network

Add VOLUME 


mkdir -p /home/priya/eclipse-workspace/may21/mysql8-data


docker run --name mysql-standalone --net my-bridge-network --volume=/home/priya/eclipse-workspace/may21/mysql8-data:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=persondb -e MYSQL_USER=sa -e MYSQL_PASSWORD=password -d mysql


docker ps


docker logs mysql-standalone


verify application properties spring.datasource.url pointing to docker mysql container name


mvn -U clean compile package


docker build -t springboot-mysql .	


docker image ls


docker container run --network my-bridge-network --name springboot-mysql -p 8080:8080 -d springboot-mysql


docker logs springboot-mysql

browser

http://localhost:8080/swagger-ui.html

POST JSON

{ "age": 29, "firstName": "shivapriya", "lastName": "t" }

PUT JSON

{ "age": 30, "firstName": "shivapriya", "lastName": "tm" }


docker exec -it mysql-standalone bash

mysql -u sa -p 


password


use persondb


select * from person


CLEANUP

docker stop mysql-standalone

docker stop springboot-mysql

docker rm mysql-standalone

docker rm springboot-mysql

docker rmi springboot-mysql

