# BDD-Cucumber-JAVA

BDD Framework with Java(Selenium) and cucumber using gherkin language.

To have consistency for drivers use the following brew command

brew install --cask chromedriver

Once successfully installed , we can see something like this.
This can be added a jenkins set up command as well

![image](https://user-images.githubusercontent.com/38035407/211776019-17b82ced-c405-49b5-ba40-bb4380940e91.png)

Then we can use the following chrome driver path while setting up the property.
For Example for mac we can use the following

System.setProperty("driver.chrome.driver", "/usr/local/bin/chromedriver");
