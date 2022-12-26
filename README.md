# Hiis ZIO Starter project

![Scala Version](https://img.shields.io/badge/Scala-2.13.8-red)
![SBT Version](https://img.shields.io/badge/SBT-1.7.2-blueviolet)
![Scala CI](https://github.com/hiis-io/zio-starter/actions/workflows/scala.yml/badge.svg)

## Description
TODO

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