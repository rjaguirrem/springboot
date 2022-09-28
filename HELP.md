# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.3/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.3/maven-plugin/reference/html/#build-image)

### Intellij configuration

- Environment variables:
> spring.profiles.active=mysql

### Docker command lines

- MySql
```sh
# Run in cmd:
$ docker run --name mysql -e MYSQL_ROOT_PASSWORD=root -d -p 3306:3306 mysql
# Run in docker terminal:
$ mysql --user=root --password db
# MySql commands:
> show databases;
> show tables;
```
- PostgreSQL
```sh
# Run in cmd:
$ docker run --name postgres -e POSTGRES_PASSWORD=root -d -p 5432:5432 postgres
# Run in docker terminal:
$ psql -U postgres
# PostgreSQL commands:
> \l # show databases
> \c # change database
> \dt # show tables
```
- SqlServer
```sh
# Run in cmd:
$ docker run --name mssql -p 1433:1433 -e 'ACCEPT_EULA=Y' -e 'SA_PASSWORD=Root001!' -d mcr.microsoft.com/mssql/server:2019-latest
# Run in docker terminal:
$ /opt/mssql-tools/bin/sqlcmd -S localhost -U sa -P Root001!
# SqlServer commands:
> select name from sys.databases; # show databases
> select name from sys.sysobjects where xtype = 'U'; # show tables
```
- Oracle
```sh
# Run in cmd:
$ docker run --name oracle -d --privileged -p 1521:1521 absolutapps/oracle-12c-ee
# Run in docker terminal:
$ bash
$ sqlplus system@orcl # password: oracle
# Oracle commands:
> select username from all_users; # show databases
> alter user scott identified by scott account unlock; # unlock hr account
> select table_name from all_tables where owner = 'SCOTT'; # show tables
```
Systems Engineer: Raúl J. Aguirre M.