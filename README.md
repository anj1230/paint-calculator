## Synopsis

The **Paint Calculator** is a hypothetical project that calculates how many gallons of paint would be required to paint a number of rooms.

## Requirements

* Python 3 (not 2)
* Pip

## What we're looking for

* Install Python / Pip
* Run application
* Write tests against the application. They do not have to be in Python, and should be in whatever language you are most comfortable with.
* Write a test plan for the application.  You are free to determine the structure and length of the test plan.
* You are allowed to change any of the source code as you see fit to make things easier for yourself. You are encouraged to fix any bugs you discover.
* Explain any problems you had while writing the tests, and what you did to make it easier. Pointing to localhost for the application is OK.
* What would be the proper level of execution for tests of this application?  If this differs from the testing level you wrote tests for, please explain where they would be better suited.

## Instructions

Because each applicant's code should be secret from one another, we should not submit it to the same repo.

1. Clone the repo (do not fork)
2. Create a new public repo on Github
3. Add the new repo as as a new remote
* `git remote add uptake <url>`
4. Initialize the new repo with what is cloned
* `git push uptake master`
5. Create a new branch off of master to put your changes on
6. Run the application locally
* `pip3 install -r requirements.txt`
* `python3 app/run.py`
7. Perform testing and debugging activities

## Submitting 

To make it easier on everybody, it's best if we use a PR to diff what work was completed.

1. Make any and all commits to your new branch and push the changes
* `git push uptake <branch>`
2. Create a PR to your new repo
3. Make sure you include your test plan and any automated tests, as well as update this README to instruct someone on how to run the tests
4. Include any other text in a file - which tests would be suited for a different level of execution, or any problems encountered...etc
5. Send the link to the PR

## Running Tests

Write instructions for how a user executes the automated tests you created.

Prerequesties:

Jre1.8 or below
ChromeBrowser-version 50-64.- preferably 64
Eclipse
TestNg

Once the application is up and running using steps 1-6 in the instructions

Navigate to the project url
Clone the repo
Import the project folder PaintCalculatorAutomation from git to eclipse.
Chromedriver is added inside the PaintCalculatorAutomation folder. Open the project and edit the chromeDriver path inside PaintCalculatorAutomation\src\TestCases\TestScript1.java, to your local path.
Selenium drivers are inside seleniumDrivers folder. Add the jars in the build path.
Configure the JRE system Library and TestNg library in the build path.
RightClick on TestScript1-->Run As-->TestNgTest
This should open the browser and start execution.
Give it few seconds to complete the execution, once it is finished the results will be available in the Console window.
Click on the Results of TestNG tab. It will display the total passed, failed and skipped test with time taken during the execution.
 To access HTML reports reports go to the PaintCalculatorAutomation folder and open test-output folder.
Open ‘emailable-report.html‘, with browser.This should open detailed report
