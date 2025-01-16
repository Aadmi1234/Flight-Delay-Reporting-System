# Flight Delay Reporting System

## Design

The design of the project is expalined in the given [video](https://drive.google.com/drive/folders/1OSYlnbdjCEysotBM81rcPOEbXsFvd87S?usp=drive_link).

![alt text](metadata/design.png)

## Starting the application

### Without docker

To get to know how to start the application without docker using command line, by the use of maven tasks. View the given [video](https://drive.google.com/file/d/1vZMijEpffiNYOpbHK-0SH7MKCXKSsQww/view?usp=drive_link).

### With docker

```bash
docker build -t flight-delay-reporting-app-image .
docker run -d \
  -p 8761:8761 \
  -p 8081:8081 \
  -p 8180:8180 \
  -p 8280:8280 \
  -p 3306:3306 \
  -v mysql_data:/var/lib/mysql \ 
  --name flight-delay-reporting-app-container \
  flight-delay-reporting-app-image
```

## Working principles and demo

To peek a look at the working principles and a demo of the application, take a loot at this [video](https://drive.google.com/file/d/1xICaCe0RbP9jHkT189tJanBYyaf-kV_J/view?usp=drive_link).

## Contributers

1. Laya Arun (1MS21CS067)
2. Animesh Manik (1MS21CS071)
