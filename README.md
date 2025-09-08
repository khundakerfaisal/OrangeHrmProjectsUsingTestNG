## Web Automation on Orange HRM Project Using Test NG
## Prerequisite
- Install jdk-17.0.8
- Selenium Webdriver
- TestNG Framework
- Gradle 8.5
- Install Intellij IDEA community Edition
- Allure 2.25
## About this project
This is Orange HRM PROJECT.Here Admin and Employee both can login with credentials but their roles are different.This project is Facilated to 
Employee information stored and all other admin related activity.We have automated the employee login page and directory page and my info page.
Here We have create regression and smoke suite also and generate test case wise report using gradle and allure report.

## How to run this project
- ```Clone this project:```[] https://github.com/khundakerfaisal/OrangeHrmProjectsUsingTestNG
- ```Add dependencies in build.gradle file```
- ```Hit the following command into the terminal for regression suite:```
  ```bash
  git clone gradle clean test -Pusername="Enterusername" -Ppassword="EnterPassword" -PsuiteName="regresion.xml" 
- ```Hit the following command into the terminal smoke suite:```
  ```bash
  git clone gradle clean test -Pusername="Enterusername" -Ppassword="EnterPassword" -PsuiteName="smoke.xml"
- ```For generating Allure Report use these commands:```
  ```bash
  git clone allure generate allure-results
  git clone allure serve allure-results
  
## Allure Report 

![Regression allure report 2024-01-10_162103](https://github.com/khundakerfaisal/OrangeHrmProjectsUsingTestNG/assets/44666800/188ccaa3-3a64-4b53-a7cf-3ff32573e55b)
![Regression allure report 2nd 2024-01-10_162142](https://github.com/khundakerfaisal/OrangeHrmProjectsUsingTestNG/assets/44666800/41ab176c-812d-4be2-af07-223bfe7a601b)
![image](https://github.com/khundakerfaisal/OrangeHrmProjectsUsingTestNG/assets/44666800/6f4dfa0b-6355-448a-82ed-82314f58a4a9)
![image](https://github.com/khundakerfaisal/OrangeHrmProjectsUsingTestNG/assets/44666800/8b96e5ae-5c2e-4776-94a0-b11ca18c861f)

## Regression Automation Output Video:
https://drive.google.com/file/d/1m2KVSdQDQ5BaCenvyR2fGHUVVlnEvh6r/view?usp=sharing

## Smoke Automation Output Video:
https://drive.google.com/file/d/1_xuglUBFpLf0nbqdd-ztoScmisCEsQEY/view?usp=sharing
## Test Cases
https://docs.google.com/spreadsheets/d/1av9wPJ_Oqzj4pldBFektbmXuFnewF70h/edit?usp=sharing&ouid=101713067954447514942&rtpof=true&sd=true
