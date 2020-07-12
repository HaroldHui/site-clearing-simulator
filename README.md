# Site Clearing Simulator
This java application is a solution to the Site Clearing Simulator and it is created by Shu Hui (shu.hui.dev@gmail.com)

## How to run
### Prerequisites
- `java 11`
- `gradlw 7.0`

### Testing
```bash
$ ./gradlew test
```

### Running
- Package the app to a jar file
```bash
$ ./gradlew jar
```

- Run the jar
```bash
$ java -jar build/libs/site-clearing-simulation.jar <relative path of the input file>
```

## Assumptions
- The site map should always be a rectangular shape
- All the characters in map file should be valid (o,t,T,r)

## Design
Basically this simulator program has 4 packages and 2 main classes

Packages:
- `costs`: Represent different types of cost and tell you how many credits that cost needed. 
- `blocks`: Represent different types of square block. Each kind of `Block` has a List of `Cost`
- `commands`: All the commands classes implement an interface class `Command`. 
The interface defines that all commands should return 3 things: the result state, the cost of command and the current position.
- `report`: Responsible to genrate the result report which include all commands it ran and itemized costs of the clearing operation.

Some important classes:
- `MapReader`: read map file and convert it to a 2 dimension `Block` array.
- `ConstructionSiteSimulator`: Control the workflow and keep all run time status. 
(like current position, total cost and all commands you issued) 

## Things cloud be improved

- Unit test of ReportGenerator
- End to End test