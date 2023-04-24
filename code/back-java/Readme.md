# Back-end : Java

## Lancer Mysql sur votre pc
### OU avec une app Mysql
>documentation d'installation de votre app
### OU avec Docker :
```sh
cd ./main/src/resources/db_mysql
docker build -t mysql .

docker run --name=sonolightreservation \
   -v type=bind,src=/Path-link-directory/my.cnf,dst=/etc/my.cnf \
   -v type=bind,src=/Path-link-directory/datadir,dst=/var/lib/mysql \
   -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -d mysql
```
### utiliser le container Docker :
```sh
docker start id-du-container
docker stop id-du-container
```

## Lancer le serveur de developpement:

### Choix 1. avec un IDE java
1. Ouvrir le projet dans IDE
2. update le projet avec les nouvelles info du pom.xml
3. lancer l'application ApiApplication.java

### Choix 2. avec le terminal
```sh
cd back-java
mvn spring-boot:run
```
## Tests dans le navigateur depuis
http://localhost:9000/

# Front-end : Java