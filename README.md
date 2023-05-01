# Back-end : Java

## Lancer Mysql sur votre pc
### OU avec une app Mysql
>documentation d'installation de votre app
### OU avec Docker :
```sh
cd ./main/src/resources/db_mysql
docker build -t mysql .

docker run --name=sonolightreservation -v type=bind,src=/Path-link-directory/my.cnf,dst=/etc/my.cnf -v type=bind,src=/Path-link-directory/datadir,dst=/var/lib/mysql -p 3308:3306 -e MYSQL_ROOT_PASSWORD=root -d mysql
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