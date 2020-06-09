# Simple-Authentication-Service
A Simple Authentication Service using java


This is a web service application to let users:
- Register
- Authenticate (Login)
- A simple API with a test response that only answers the clients after loging in.
- Logout

technologies:
- Java
- Spring Boot
- MySQL database
- Maven

Services are Restful.

After cloning the project, you can build a jar file to use or you can use embeded tomcat which spring boot provides and use 
your system as a server. 

sthe context path is :

/authentication-service/api

and you can access on 8080 port on the server, for example:

localhost:8080/authentication-service/api

Swagger is also configed to test APIs and other documentation.

It's provided in this url: 

localhost:8080/authentication-service/api/swagger-ui.html#/
