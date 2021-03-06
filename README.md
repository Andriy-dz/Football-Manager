# Football-Manager

### Postman commands for docker

###### Inject Data:
- Post: localhost:8081/injector

###### Player:
- Post: localhost:8081/players    
  body: {"name":"Andrew", "age":21, "experience":0, "teamId":1}
- Get: localhost:8081/players/{id}
- Put: localhost:8081/players/{id}
  body: {"name":"Andrew", "age":22, "experience":12, "teamId":1}
- Put: localhost:8081/players?fromTeamId=1&toTeamId=2&playerId=1
- Delete: localhost:8081/players/{id}

###### Team:
- Post: localhost:8081/teams  
  body: {"name":"Dinamo", "commission":9, "budget":10000000}
- Get: localhost:8081/teams/{id}
- Put: localhost:8081/teams/{id}    
  body: {"name":"Dinamo", "commission":9, "budget":100000000}
- Delete: localhost:8081/teams/{id}

## Implementation details and technologies

### Project based on 3-layer architecture:
>- Presentation layer (controllers)
>- Application layer (services)
>- Data access layer (DAO)

### Technologies
>- Spring Boot
>- Spring Boot WEB
>- Spring Boot DATA
>- Hibernate
>- Hibernate validator
>- PostgreSQL
>- Lombok
>- Maven
>- Maven Checkstyle Plugin

### Diagram DB
![drawing](http://dl4.joxi.net/drive/2022/05/19/0052/3292/3415260/60/fcac289cf4.jpg)

## Setup by docker
Execute commands in the terminal :
- mvn clean package
- docker-compose up
