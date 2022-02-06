# Testiranje Projekt
- This project runs test using TestNG
- Selenium WebDriverManager is used to drive browsers
- Tests are preformed on two browsers. I choose chrome and edge, but it can be changed.
- Object oriented principles are used

## Files to download:
1. Chrome browser: https://www.google.com/chrome/
2. Java JDK: https://www.oracle.com/java/technologies/downloads/#java8
3. InteliiJ: https://www.jetbrains.com/idea/download/#section=windows
4. Chrome Driver: https://chromedriver.chromium.org/downloads

## Importing Project (IntelliJ IDEA)
1. Clone this git repository
2. Open InteliiJ
3. File->open->TestiranjeProjekt (root directory)

## How do I run tests
1. Open IntelliJ
2. Build project
3. Initiate testing in console
- write 'mvn test' in console
4. Open surefire-report
- surefire report is located in 'target\surefire-reports\index.html'

## How to change or add browsers on which tests are preformed
1. Add new case in Testovi.java
![image](https://user-images.githubusercontent.com/23449108/152692387-b8104fdd-5e48-45b5-a5d3-f0c071e4117c.png)
Syntax for other browsers is shown bellow
![image](https://user-images.githubusercontent.com/23449108/152691762-19da5846-298f-497b-b7a9-5883e97d04d5.png)
2. You need to change parameter value in testng.xml to name of case for browser
![image](https://user-images.githubusercontent.com/23449108/152692406-7e3a9942-b708-4d65-ba5b-1725e470bb47.png)





