Launch the eureka server:
 - cd service-spring-boot-eureka-server
 - mvn spring-boot:run
 
Eureka Server : 
 - GET http://localhost:8761/
  
Launch instance 1 of eureka client :
 - cd service-spring-boot-eureka-client
 - mvn spring-boot:run
 
Launch instance 2 of eureka client :
 - cd service-spring-boot-eureka-client
 - mvn spring-boot:run
 
Launch instance 3 of eureka client :
 - cd service-spring-boot-eureka-client
 - mvn spring-boot:run
 
server.port=0 => search for a free port => multiple instances of the same service can be run on the same host

Endpoints (change the port) :
 - GET http://localhost:50553/hello => simple hello world
 - GET http://localhost:50553/instances/{applicationName} => get instances of a service from registry
 - GET http://localhost:50553/services => get services from registry
 - GET http://localhost:50553/helloremote => call the hello endpoint of an instance with a restTemplate loadbalanced client
 
 Kill an instance and verify it disappears on the registry : http://localhost:8761/
 