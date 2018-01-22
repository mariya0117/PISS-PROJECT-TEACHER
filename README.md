Set up of MongoDB

db.createUser({
    user: "springboot",
    pwd: "p@ssword",
    roles: [ "readWrite", "dbAdmin" ]
});

database: springapp


Start of MongoDB
cd /c/'Program Files'/MongoDB/Server/3.4/bin
./mongod
./mongo


Start project: 
mvn clean install
mvn spring-boot:run