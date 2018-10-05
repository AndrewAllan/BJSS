

This is demo test automation the automation was developed in java

## Getting Started

download the project source from the repo - https://github.com/AndrewAllan/BJSS.git

import the maven project into the eclipse IDE

### Prerequisites

Eclipse IDE
JDK
Chrome webBrowser
Maven

## Running the tests
TEST 1:  HAPPY PATH, PURCHASE 2 ITEMS = (right click the class TestCase1 and select testNG to run the 1st test)
 ```
1. ‘Quick view’ an item 2. Change the size of the item 3. Add that item to your basket 4. Continue shopping 5. ‘Quick view’ a different item (leave the size at the default) 6. Add that item to your basket 7. View the basket and confirm that the items are of the size you selected, that their prices are correct, that Total Products is the sum of the two items and that ‘Total’ equals the Total Products + Shipping. 8. Proceed through checkout to payment (complete by wire) (Logout)
```

TEST 2: REVIEW PREVIOUS ORDERS AND ADD A MESSAGE = (right click the class TestCase2 and select testNG to run the 2nd test)
 ```
 (Login to the site using the above credentials) 1. View previous orders 2. Select an item from your previous order (there will be others – confirm this by date/time) and add a comment 3. Confirm that the comment appears under ‘messages’ (Logout) 
```

TEST 3: CAPTURE IMAGES = (right click the class TestCase3 and select testNG  to run the 3rd test)
``` 
(Login to the site using the above credentials) From Test 2 create an assertion which will cause a fail (e.g. confirm the dress is red when in fact it is blue) and capture a screen-grab on fail using Selenium (Logout) 
```

TEST 4: API CALLS = (right click the class CRUD and select testNG to run the 4th test)
``` 
1. Visit https://reqres.in/ where you will find the documentation needed to create your API calls using that base URL. 2. Create ‘happy path’ tests for each of the CRUD actions, demonstrating that you have asserted against one or more things of value which demonstrate success or failure of the test. 
```
TO RUN ALL TESTS RIGHT CLICK THE XML FILE TestSuit.xml AND RUN AS TESTNG SUIT

### Reporting

The standard testNG report can be found in the test-output folder/

Extent reporting can be found in the Reports folder.

Note: for the Extent reports the file should be moved or deleted after each run if this is not done the testcases will continue to be added to the same report.

### ScreenShots

When a test fails it should take a screenshot and store it in the location ./errorScreenshots the screen shot should also be added to the extent report.

### logging

I have used log4j for logging purposes i have set it to output both to file(test.log) and to console

## Built With

* [testNG](http://testng.org/docs/) - Testing Framework
* [Maven](https://maven.apache.org/) - Dependency Management
* [Selenium](http://www.seleniumhq.org/) - Used For Browser Automation
* [Rest Assured](http://rest-assured.io/) - Used For RESTful API Testing
* [Extent Reporting](http://extentreports.com/) - Used For Reporting

## Known issues

* Some page object classes might only have one locator this was done purely from a forward-thinking perspective as there are more locators available on screen they just weren’t required for the tests.
* Within test 2 and 3 was specified that I select the order by date and time but on screen only the date is displayed because of this I have set it to select the first element on the matching date.
*The menu class has the locators for both the menu in the heading and the menu for navigation I would normally split these out into separate classes but due to the fact I won’t be building on it I didn’t think it was required.

