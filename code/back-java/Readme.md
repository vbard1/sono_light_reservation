# Back-end : Java

## Lancer Mysql sur votre pc, au choix :
### - Avec une app Mysql
>documentation d'installation de votre app
### - Avec Docker :

**Note : la commande RUN s'utilise quand le container est inexistant, DB inexistante ou deja présente.**  
Renommer le nom du --volume (dossier-hote) avec le chemin du dossier qui accueillera la db, à l'extérieur du dossier back-end
```sh
docker run --name=sonoLightReservation \
   --volume=/dossier-hote:/var/lib/mysql \
   -p 3308:3306 -e MYSQL_ROOT_PASSWORD=root -d mysql
   
#Exemple:
docker run --name=sonoLightReservation \
   --volume=/home/laurent/Documents/sono_light_reservation_DATABASE/db:/var/lib/mysql \
   -p 3308:3306 -e MYSQL_ROOT_PASSWORD=root -d mysql
```
### Premier lancement, database inexistante: creation de la database :
```sh
#Entrer dans le container en fonctionnement
docker exec -it sonoLightReservation /bin/bash
#Ouvrir le shell mysql
mysql -h 172.17.0.2 -uroot -p --port 3306
#Reset le mot de passe root de la DB (sinon onetime_password par defaut)
ALTER USER 'root'@'localhost' IDENTIFIED BY 'root';
#Creation de la base de données
create database sonoLightReservation;
#Sortir de la database + du container
exit
exit
```
### Creation des tables :
Via une app comme DBeaver avec le script /resources/db_mysql/db_init.sql  
ou avec un script
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
