# Mobile_Apps_Automation-Appium
Appium Framework with Page Object Model using Maven and TestNG


Steps to run Automation Task:

Tools and configuration:

1.Install JAVA JDK from Orcale<br/>
Verion used: "12.0.1"<br/>

2.Install Android SDK and set ANDROID_HOME & PATH in the bash profile<br/>
Version used :<br/>
Build-tools:"28.0.3"<br/>

ex:<br/>
export ANDROID_HOME=/Users/ngeorge1/Library/Android/sdk<br/>
export PATH=$PATH:$ANDROID_HOME/tools<br/>
export PATH=$PATH:$ANDROID_HOME/platform-tools<br/>

3.Install MAVEN and set MAVEN HOME & PATH in the bash profile<br/>
Verion used:"3.6.1"<br/>
ex:<br/>
export MAVEN_HOME=/Users/ngeorge1/Downloads/apache-maven-3.6.1<br/>
export PATH=$PATH:$MAVEN_HOME/bin

4.Install Appium from terminal. Run the following commands in terminal to install appium<br/>
Version used:"1.13.0"<br/>

ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"

brew install node

npm install -g grunt-cli

npm install -g appium

npm install wd

Test Suite Configurations:

5.Create an Android Virtual Device(AVD) with a unique name and update DEVICE_NAME_AND variable in the Config file located in the below location:
/comcabifypricecal/src/test/java/Utils/Config.java

ex:"Pixel3"

To run the test suite:

6.Go to to the project root folder from terminal and run the following command:<br/>
mvn install

Results:

Once the build is done, a report is generated in the Reports folder as “AndroidSanityReport” and screens shots in Screenhots folder

