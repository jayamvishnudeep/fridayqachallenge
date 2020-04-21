## Overview
Automation Tests for Friday sales funnel

## Technologies/Frameworks used:

<ul>
  <li>Java</li>
  <li>Selenium</li>
  <li>TestNG</li>
  <li>Maven</li>
  <li>Jacoco</li>

</ul>

## How to run?
This service is using maven as a build tool.
<ul>
  <li><b>mvn clean install</b> - use this command while running the tests for the first time</li>
  <li><b>mvn clean test</b> - to run tests</li>
  <li>By default tests will run in chrome browser,In order to run the tests in firefox, change <b>browserName</b>  value to firefox in <b>src/main/java/friday/qa/config/config.properties</b></li>
  <li>After running the tests, if wanted to check for the html report of the Jacoco then look into this path <b>target/site/jacoco/index.html</b> </li>
</ul>

 

## Covered Test scenarios

<ul>
  <li>Full Sales funnel flow until DOB using Manual Vehicle selection</li>
  <li>Full Sales funnel flow until DOB using HSN/TSN</li>
  <li>Covered Negative test cases as part of the sales funnel flow tests- Date Validations</li>
  <li>Vehicle selection using Vehicle Brand search</li>
   <li>Added a library where it captures a screenshot when the test fails and the screenshot name will be the failed test's method name and the captured screen will be saved at <b>src/main/java/friday/qa/data/screenshots</b></li>
</ul>

All Test cases uses a data set which is provided in ``` CarTestDataProvider.java``` file