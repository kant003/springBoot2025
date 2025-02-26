- Extension pack for java
- SpringBoot extension pack (vmware)
- SpringBoot dashboard
- lombok Annotations
- rest client
- maven for java


# Crear contenedor mysql
```bash
docker run -d -p 3306:3306 --name mysql -e MYSQL_ROOT_PASSWORD=Ad1234 mysql
```


# Entrar en mysql 
```bash
docker exec -it backend-db-1 mysql -uroot -p

create database superheroes;

```


