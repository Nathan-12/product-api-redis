# Products API

This is the Products API, implemented with Spring Boot and using Redis as the caching system.

## Prerequisites

To run the project, you'll need the following installed on your machine:

- [Docker](https://www.docker.com/get-started)
- [Maven](https://maven.apache.org/install.html)
- [JDK 17+](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)

## Starting Redis with Docker

The API uses Redis for caching. To start a Redis instance, you can use the provided `docker-compose.yml` file.

1. Ensure Docker is installed and running.
2. Navigate to the directory containing the `docker-compose.yml` file.
3. Run the following command to start Redis in the background:

```bash
docker-compose up -d
```

## Running API

Once Redis is running, navigate to the root directory of the project and run the following Maven command to start the Spring Boot application:

```bash
mvn spring-boot:run
```

## Requests .json

If you want test the methods, its possible get requests in file .json in: [Insomnia_requests.json](https://github.com/Nathan-12/product-api-redis/blob/main/requests/Insomnia_requests.json)
You can import in Insomnia or Postman for example.

## Author

Nathan Lima - nathanlima.b@gmail.com

