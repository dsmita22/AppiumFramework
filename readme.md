# Let start with Appium Test

### Steps to start
* First install java jdk
* Install maven and setup path
* install android studio and avd manager
* Create emulator
* Use eclipse or Intelij
* Setup empty maven project
* Install nodejs >12 to install appium
* Verify appium using install appium-doctor
* Check appium version
* Install appium server or appium desktop
* Download dependencies from maven central repository
* Add test to test package
* Go to app folder and find uiautomator to locate elements
* Clean project using maven clean command

### How to write tests
* Get xpath, id , classname using uiautomator to locate elements
* xpath syntex: 
        tagname[@attribute='value']
 *Syntex for AndroidUiautomator using attribute:
          driver.findElementByAndroidUIAutomator("attribute(\"value\")")          
  *Syntex for AndroidUiautomator using property:
            driver.findElementByAndroidUIAutomator("new UiSelector().property()value");