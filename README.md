![Java CI with Gradle](https://github.com/nlaert/fota/workflows/Java%20CI%20with%20Gradle/badge.svg)

## To build and run the project:

Open a terminal in the project root and run the following commands:
* `gradlew build`
* `docker-compose up`

**NOTE**: it might be necessary editing the `fota.vehicle_files.path` in *src/main/resources/application.properties*

The application will be listening in <localhost:8080/fota> by default

### Running tests:

Open a terminal in the project root and run the following command:
* `gradlew test`

### Checking the documentation:

Documentation can be found in <localhost:8080/fota/swagger-ui.html>
