# Project Setup

## Docker

### Username and Password

- **Username:** sa
- **Password:** YourPassword123!
- **Port:** 1433

### Command to create a docker container with these characteristics

```sh
docker run -d --name sqlserver-container -e 'ACCEPT_EULA=Y' -e 'SA_PASSWORD=YourPassword123!' -p 1433:1433 mcr.microsoft.com/mssql/server:latest
```
### 
```sh
docker exec -it sqlserver-container /opt/mssql-tools/bin/sqlcmd -S localhost -U sa -P YourPassword123! -Q "CREATE DATABASE nexus;"
```

## Visit
```
http://localhost:8080/swagger-ui.html
```