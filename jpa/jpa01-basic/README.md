# JPA Basic
## Database container setup
```bash
docker run --detach --name jpa-mariadb\
 -p 3306:3306\
 --env MARIADB_USER=jpa\
 --env MARIADB_PASSWORD=jpadb\
 --env MARIADB_ROOT_PASSWORD=jpa\
   mariadb:latest
```

```sql
CREATE DATABASE jpa;
GRANT ALL ON jpa.* TO 'jpa'@'%';
```


docker run --detach --name sql-mariadb\
 -p 3306:3306\
 --env MARIADB_USER=sql\
 --env MARIADB_PASSWORD=sqldb\
 --env MARIADB_ROOT_PASSWORD=sql\
   mariadb