# EBML-EMI Assessment

## Running Project in Docker
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
java -jar transformer.jar -f /test-data/case-1.csv
```
