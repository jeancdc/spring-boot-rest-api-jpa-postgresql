# spring-boot-rest-api-jpa-postgresql

## Summary
This project is a demo of a REST application with JPA and a POSTGRESQL database.

## First steps
- `brew install postgresql`
- `brew services start postgresql` 
- `brew cask install pgadmin4`
- `psql --list`:
```
                                   List of databases
   Name    |    Owner    | Encoding | Collate | Ctype |        Access privileges
-----------+-------------+----------+---------+-------+---------------------------------
 postgres  | john        | UTF8     | C       | C     |
 template0 | john        | UTF8     | C       | C     | =c/"john"                      +
           |             |          |         |       | "ay31281-dev"=CTc/"john"
 template1 | john        | UTF8     | C       | C     | =c/"john"                      +
           |             |          |         |       | "john"=CTc/"john"
(3 rows)
```
- `psql postgres`
- `\du`:
```
                                    List of roles
  Role name  |                         Attributes                         | Member of
-------------+------------------------------------------------------------+-----------
 john        | Superuser, Create role, Create DB, Replication, Bypass RLS | {}
```
- launch the pgAdmin application and create a new server with `localhost` host name and your role name as username
- in the application.properties file:
```
spring.datasource.username=john
```
