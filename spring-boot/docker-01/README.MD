- reference : https://bmuschko.github.io/gradle-docker-plugin/current/user-guide/


**run as**
```bash
./gradlew dockerBuildImage
docker run -d -p 8080:8080 com.example/docker-01:0.0.1-snapshot
```