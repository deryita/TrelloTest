How to run tests:
1) Install Maven tool to your machine following the steps: https://maven.apache.org/install.html
2) Copy the whole directory of the code to the local machine
3) Open a new terminal and go under directory: \TrelloTest
4) Execute command: "mvn clean test" to run tests.

Improvements to be added:
1) Advanced test reporting via external tool (e.g. Allure)
2) API tests to be structured with POJO and json parsers, for requests and responses
3) API and UI tests to have advanced assertions (eg. schema validation, assertion of urls..)
4) Tests are runnable on Docker
5) Drivers are configurable via a config file. Now only Google Chrome is supported
6) The tests are runnable via a tool (e.g. CI/CD)
7) A cleanup script should run in case tests are abruptly ended or after the tests are executed successfully
8) More detailed test scenarios needed, (e.g. modifying, deleting, security scenarios)