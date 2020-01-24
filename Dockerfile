#Use spark core
FROM 192.180.4.103:5000/sparkcore:1.0

RUN apk add --no-cache tzdata
ENV TZ Africa/Nairobi

# Add Maintainer Info
LABEL maintainer="itambo.ibrahim@gmail.com"

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8761 available to the world outside this container
EXPOSE 8888

# The fat jar
ARG JAR_FILE=target/eureka-client-0.1.jar

# Add the application's jar to the container
ADD ${JAR_FILE} eureka-client.jar

# Run the jar file
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/eureka-client.jar"]



#Aftermath
#========================================
#Build
#docker build -t 192.180.4.103:5000/eurekaclient:0.1 .

#Push
#docker push 192.180.4.103:5000/eurekaclient:0.1

#Docker Test

#docker run --name eurekaclient -d -p 8080:8080 192.180.4.103:5000/eurekaclient:0.1
#docker service create --replicas 3 --name eureka-client-service -p 38080:8080 192.180.4.103:5000/eurekaclient:0.1

#Pod / TESTING
#kubectl apply -f docs/pod.yml

#Deployment
#kubectl apply -f docs/deployment.yml

#Service
#kubectl apply -f docs/service.yml
