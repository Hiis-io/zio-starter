# Patronize authentication server

![Scala Version](https://img.shields.io/badge/Scala-2.13.8-red)
![SBT Version](https://img.shields.io/badge/SBT-1.7.2-blueviolet)
![Scala CI](https://github.com/hiis-io/zio-auth-server/actions/workflows/scala.yml/badge.svg)

## Description
This is a zio 2 scala application that implements an authentication and authorization server using REST API. It is made up of several subprojects as seen in [`modules`](./modules) directory.

- Application: This is the aggregate of all the other modules and makes up the full application. Depends on [`service-consumer`](./modules/service-consumer) and [`service-gateway`](./modules/service-gateway)
- Common: Contains common code used by all other modules
- Service Gateway: Contains the REST API implementation of the Authentication server. It depends on [`common`](./modules/common) module
- Service Consumer: Contains Notification service implementation of the Authentication server. Depends on [`common`](./modules/common) module

## External Dependencies

This application makes use of several external services which are required to run the application successfully.

- Mongodb
- Redis
- Kafka

Make sure all the services below are up and running before launching the application. You could optionally execute the [`docker-compose.yml`](./docker-compose.yml) file by running `docker compose -f docker-compose.yml`, for that to work you need to have docker installed in your system. This will spin up all the required services and also provide web apps to visualize your data in Kafka, Redis and Mongodb. All required configurations for these services should be setup in  [`application.conf`](./modules/application/src/main/resources/application.conf)

## Running the application
To run the application make sure you have sbt installed and all the external dependencies are up and running and described above, then run `sbt application/run`

## Testing
TODO


## Building application (SBT assembly & Docker)

- To build the fat jar using sbt assembly simply run the command `sbt build` with your desired configurations set up
  in [`application.conf`](./modules/application/src/main/resources/application.conf)
- To build the docker image simply run `sbt build-docker` with your desired configurations set up
  in [`application.conf`](./modules/application/src/main/resources/application.conf). Make sure you change the docker
  user in [`build.sbt`](./build.sbt)

## Development
- Clone the project
- Make sure you have `sbt` installed in your computer.
- Import the project in your preferred sbt supported IDE (we recommend Intellij Idea, the community version will suffice)
- Make sure all external dependencies are up and running (See External dependencies section above)
- Start coding and testing. 
- Pull request are welcomed.

## Contributing
This project is open to contributions be it through issues or pull request. Have a look at our [`contribution guide`](./CONTRIBUTING.md) before you get started.


## License

[MIT](https://choosealicense.com/licenses/mit/)