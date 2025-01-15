# Flight Delay Reporting System

## To run the application

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

## Contributers

1. Laya Arun (1MS21CS067)
2. Animesh Manik (1MS21CS071)
