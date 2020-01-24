# Sample Eureka Client

### Discovery Client :: Eureka
Registers with discovery server as **eureka-client** via settings in **application.yml**

* [Service Registration and Discovery](https://spring.io/guides/gs/service-registration-and-discovery/)

### Config Client
Reads from config server using settings in **bootstrap.yml**. 

NB: Config server in turn reads configs from git repo http://192.180.3.23/microservices/microservice-configs/eureka-client.properties

To refresh configs immediately, instead of waiting for the interval, you need to call the refresh endpoint [http://IPADDRESS:PORT/actuator/refresh](http://IPADDRESS:PORT/actuator/refresh) on this microservice
    

    `curl localhost:8080/actuator/refresh -d {} -H "Content-Type: application/json"`
    

* [Service Registration and Discovery](https://spring.io/guides/gs/service-registration-and-discovery/)

### Running The Service
* Java
    `java -jar target/eureka-client-0.1.jar`

* Docker
    Run
    `docker run --name eurekaclient -d -p 8080:8080 192.180.4.103:5000/eurekaclient:0.1`
    Cleanup:
    `docker stop eurekaclient`
    `docker rm eurekaclient`

### Probing The Service
* Uptime: http://localhost:8080/actuator/health
* Environment: http://localhost:8080/actuator/env
* Actuator: http://localhost:8080/actuator/
* Testing Dynamic Config: http://localhost:8080/test

