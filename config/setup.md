# Project Setup

## Database Configuration

### Username and Password

- **Username:** sa
- **Password:** YourPassword123!
- **Port:** 1433

### Command to create a Docker container for the database with these characteristics

```sh
docker run -d --name sqlserver-container -e 'ACCEPT_EULA=Y' -e 'SA_PASSWORD=YourPassword123!' -p 1433:1433 mcr.microsoft.com/mssql/server:2019-latest
```

### Create the database

```sh
docker exec -it sqlserver-container /opt/mssql-tools/bin/sqlcmd -S localhost -U sa -P YourPassword123! -Q "CREATE DATABASE nexus;"
```

## Broker Setup

### Mosquitto Broker
- **Allow anonymous connections:** true
- **Listener:** 1883

*We are allowing anonymous connections just for testing purposes. In a real scenario, it is recommended to set this value to false.*

```sh
docker run -d --name mosquitto-container -p 1883:1883 eclipse-mosquitto
```

### Configure Mosquitto
```sh
docker exec -it mosquitto-container bash -c 'echo -e "allow_anonymous true\nlistener 1883" >> /mosquitto/config/mosquitto.conf'
```

### Restart Mosquitto to apply changes
```sh
docker restart mosquitto-container
```

## Visit
```
http://localhost:8080/swagger-ui.html
```
---

*Project setup guide authored by Dominik Mendoza. Find more at [DominikMendoza](https://github.com/DominikMendoza)*
