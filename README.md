# HelloFreshAutomationTask
To execute the test cases run the testing.xml file.
To configure which browser you would like the tests to run the tests with, change browser parameter to firefox or safari
If you want to execute tests on Safari make sure to allow remote automation option from develop menu in Safari browser itself
This webdriver factory is found in the Testbase file
This framework had been developed on Mac so if you are executing the test cases
on a windows laptop please make sure to replace the unix drivers in the drivers folder with the drivers.exe files
which I have added for you in a folder names windows-drivers.
The logs is added to log4j-properties.
The screenshots is taken for only failed test cases.
The test-output folder contains the TestNG emailable report which you can open in a browser and see a human readable
report.
The Framework is designed in page object model paradigme so the pagesfactory package will contain only the pages
and their defined locators and functions and the tests will call those pages to perform the required
scenarios and Tests contains the assertions.
