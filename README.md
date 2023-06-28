# SonoLight_reservation
 Une application web de réservation de matériel sonorisation et lumière

Font-end : Angular
Back-end : Java + Mysql

## Lancer Mysql sur votre pc, au choix :
### - Avec une app Mysql
>documentation d'installation de votre app
### - Avec Docker :
**Note : la commande RUN s'utilise quand le container est inexistant, DB inexistante ou deja présente.**  
Renommer le nom du --volume (dossier-hote) avec le chemin du dossier qui accueillera la db, à l'extérieur du dossier back-end
```sh
docker run --name=sonoLightReservation --volume=/dossier-hote:/var/lib/mysql -p 3308:3306 -e MYSQL_ROOT_PASSWORD=root -d mysql

#Exemple pour les utilisateurs de Windows :
docker run --name=sonoLightReservation --volume=C:\Users\bardi\Documents\enviro_slr:/var/lib/mysql -p 3308:3306 -e MYSQL_ROOT_PASSWORD=root -d mysql

#Exemple pour les utilisateurs de linux :
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

# Front-end : Angular

## Prérequis
- Node.js doit être installé sur votre machine. Vous pouvez le télécharger depuis le site officiel : https://nodejs.org/en/download/.
- Angular CLI doit être installé. Pour ce faire, ouvrez un terminal et entrez la commande suivante :
```sh
npm install -g @angular/cli
```

## Déployer le projet Angular
1. Ouvrez un terminal et naviguez jusqu'au dossier contenant le projet Angular.
2. Installez les dépendances du projet en exécutant la commande suivante :
```sh
npm install
```
3. Vous pouvez maintenant construire le projet en exécutant la commande suivante :
```sh
ng build
```

## Lancer le serveur de développement
1. Dans le terminal, naviguez jusqu'au dossier contenant le projet Angular.
2. Lancez le serveur de développement en exécutant la commande suivante :
```sh
ng serve
```
3. Le serveur sera accessible sur http://localhost:4200/.

Notez que vous pouvez également spécifier un port différent en ajoutant l'option --port. Par exemple, pour lancer le serveur sur le port 9000, vous pouvez exécuter la commande suivante :
```sh
ng serve --port 9000
```