
  <h3 align="center">Unique Number Consistence Of Letter</h3>

  <p align="center">
    A project with Spring Boot and Greedy Algorithm which is developed for Siemens Case Study. Details are as below;
 
</p>

<details open="open">
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
          <li><a href="#technology-stack">Technology Stack</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>

## About The Project
A Spring Boot command line project which is running with a parameter is 
constructed According to Siemens
Case Study Requirements which consist of Count the minimum
 number of letters that must be deleted from a word to create 
a word in which no two letters occur the same number of times. 
Project Consist of:
- CommandLine Runner Spring Boot application
- Business Services for each step (Resource, Calculation, Provider)
- Greedy Algorithm with O(N) complexity for calculation
- HashMap and PriorityQueue Data Structures
- Unit Test cases (Junit5 - Mockito) with code line coverage 81%


### Built With
* [JDK 1.8](https://www.oracle.com/tr/java/technologies/javase/javase-jdk8-downloads.html)
* [Maven](https://maven.apache.org/)

### Technology Stack
* Spring Boot
* JUnit5
* Mockito

## Getting Started

There are several ways to run a commandLine Spring Boot 
application on your local machine. 
- One way is to construct running configurations using 
your IDE. The application is a commandLine application basically ;
 In your ide configuration please don't forget to set "Program Arguments" as "WordLis.txt".
- Another way; you can run the application on your project directory with command line prompt as below:

```sh
   java -jar unique-number-consistence-of-letter-0.0.1-SNAPSHOT.jar "WordLiat.txt"
   ```
The output should be like:
```sh
   
2021-08-16 11:37:55.022  INFO 16872 --- [  restartedMain] c.s.u.s.MinimumDeletionNumberService     : Algorithm applied to find minimum deletion: 

2021-08-16 11:37:55.022  INFO 16872 --- [  restartedMain] c.s.u.s.MinimumDeletionNumberService     : Algorithm applied to find minimum deletion: 

1- 1
2- 6
3- 0
4- 4
5- 4

Process finished with exit code 0

   ```

### Installation


1. Clone the repo
   ```sh
   git clone https://github.com/evrimmeral/unique-number-consistence-of-letter.git
   ```
2. Build tha project on your local machine
   ```sh
     mvn clean install package
     ```



## Contributing
Any contributions you make are **greatly appreciated**.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/ChangesFeature`)
3. Commit your Changes (`git commit -m 'Add some ChangesFeature'`)
4. Push to the Branch (`git push origin feature/ChangesFeature`)
5. Open a Pull Request


## Contact

Evrim Meral - evrimmeral@gmail.com

Project Link: [https://github.com/evrimmeral/unique-number-consistence-of-letter.git](https://github.com/evrimmeral/unique-number-consistence-of-letter.git)

