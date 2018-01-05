# BJSS
This is the repo for the demo test automation for BJSS

## Getting Started

download the project source from the repo - https://github.com/AndrewAllan/BJSS.git
import the maven project into the eclipse IDE

 
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

Eclipse IDE is installed 
JDK 

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

### Break down into end to end tests

Explain what these tests test and why

```
Give an example
```

### And coding style tests

Explain what these tests test and why

```
Give an example
```

## Deployment

Add additional notes about how to deploy this on a live system

## Built With

* [Dropwizard](http://www.dropwizard.io/1.0.2/docs/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [ROME](https://rometools.github.io/rome/) - Used to generate RSS Feeds

## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags). 

## Authors

* **Billie Thompson** - *Initial work* - [PurpleBooth](https://github.com/PurpleBooth)

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Hat tip to anyone who's code was used
* Inspiration
* etc
