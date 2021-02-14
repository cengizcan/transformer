# EBML-EMI Assessment - Problem 2
This is a Java CLI application that transforms CSV to JSON in required format.

## Options to Run
### Running the Executable JAR
The project is developed with JDK 11 and will required JRE 11+ to run.

A packaged JAR file is located in the `bin` folder. 

Running with console input:
```bash
java -jar ./bin/transformer.jar -i \
first_name,surname,age,nationality,favourite_colour\\n\
John,Keynes,29,British,red\\n\
Sarah,Robinson,54,,blue
```
Running with file input:
```bash
java -jar ./bin/transformer.jar -f ./test-data/case-1.csv
```
### Running in Docker
Navigate to project root. If you want to add your own CSV files for testing, copy them to the `test-data` directory in the project root.
The directory will be copied to the docker container as `test-data` to the working directory.
Then build the docker image:
```bash
docker build -t transformer-cengizcan .
```
Run the docker container in an interactive mode:
```bash
docker container run -it transformer-cengizcan /bin/bash
```
Run CLI application in docker container:
```bash
java -jar transformer.jar -f ./test-data/case-1.csv
```

### CLI Parameters
```
-f     --file      Path of the file to transform
-h     --help      Show this help message and exit
-i     --input     User input to transform
-of    --out-file  If set output will be written to the given path instead of console
-V     --version   Print version information and exit
```
## Building from Source
### Requirements
* JDK 11 (Build with AdoptOpenJDK 11.0.8)
* Apache Maven 3.3.9+ 
  
Run `mvn clean package` to build and package project. Other standard Maven goals are also applicable.
  
## Design Considerations
CSV to JSON transformation is succeeded by `CsvToJsonTransformer` class which implements `Transformer` implementation.
By adding a factory method and a new `Transformer` implementation, extra features can be added like XML to CSV transformation.

`Transformer` interfaces `transform` method accepts two interfaces, `Reader` and `OutputWriter` as parameters. This allows it to work with different types of readers and writers, independent of their internal mechanisms.
