## Overview
Automation Tests for Friday sales funnel

## Frameworks/Libraries used:

<ul>
  <li>Java</li>
  <li>Selenium</li>
  <li>TestNG</li>
  <li>Maven</li>
</ul>

## How to run?
This service is using maven as a build tool.
<ul>
  <li><b>mvn clean test</b> - to run tests</li>
  <li>By default tests will run in chrome browser,In order to run the tests in firefox, change <b>browserName</b>  value to firefox in config.properties</li>
</ul>

 

## Covered Test scenarios

<ul>
  <li>Full Sales funnel flow until DOB using Manual Vehicle selection</li>
  <li>Full Sales funnel flow until DOB using HSN/TSN</li>
  <li>Covered Negative testcases as part of the sales funnel flow tests- Date Validations</li>
  <li>Vehicle selection using Vehicle Brand search</li>
</ul>

All Test cases uses a data set which is provided in ``` CarTestDataProvider.java``` file