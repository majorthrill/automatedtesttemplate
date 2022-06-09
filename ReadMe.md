##Notes 
This is a maven project using Cucumber and Selenium Webdriver and should run as-is.

##Limitations/Quirks.
It is currently configured to use Chrome but can easily be altered to use any number of browsers provided they are supported by selenium. As of the time of writing, to run this locally using the browser for demonstration purposes, chromedriver must be located on the PC. The harness is currently configured to look for it on the root of the C:\ drive.
https://chromedriver.chromium.org/

## Configuration
To run from within Eclipse, please see config.png

## Execution
This is a maven project. 
Assuming Maven is installed on your environment it can be executed in Eclipse or from the command line with using the following arguments.
-Dcucumber.options="--tags @TechExercise"
