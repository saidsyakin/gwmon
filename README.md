
# Gas Water Monitoring System

## How to Build and Install 

### Dev
1. How to start service
- Start app as Spring Boot app in your favorite IDE.
To specify custom config you can provide the same program arguments as specified below.
- or like this:
Build service
```
mvn clean install
```
Start
```
java -jar ./target/gwmon-0.0.1-SNAPSHOT.jar
```
Start with custom config
```
java -jar ./target/gwmon-0.0.1-SNAPSHOT.jar --spring.config.location=./src/main/resources/application.yaml
```
 
### Prod
1. Build fat jar
```bash
mvn clean install 
```
2. Install app 
```bash
sudo mkdir -p /opt/gwmon-api
sudo cp ./target/gwmon-0.0.1-SNAPSHOT.jar /opt/gwmon-api/gwmon-api.jar && sudo chmod +x /opt/gwmon-api/gwmon-api.jar
sudo cp ./conf/prod/init.d/gwmon-api /etc/init.d/gwmon-api  
``` 
Make sure that app auto starts as service.

3. Start/stop/restart service
```bash
sudo service gwmon-api start|stop|restart
```
4. How to access the service 
- Service will be accessible at
```
http://localhost:8080/
```
You can easily change port in the application.yaml

5. How to access the Swagger page
- Swagger will be accessible at
```
http://localhost:8080/swagger-ui
```


