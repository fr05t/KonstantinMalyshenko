# KonstantinMalyshenko
**1.	Setup project that has been discussed in the class. Make sure you can run both tests (native and web) successfully.**

  - All test properly run through mobile_hw1.xml

**2.	For existing native mobile autotest try to use another locator (xpath, classname, ?). Define these locators using Appium Inspector. Are there any difference with id version?**
    
  - There are no difference, except sintaxis of locators, i think. 

**3.	Modify existing tests to run on a real device. What should be changed?**

  - We need change deviceName in the desired capabilities.

**4.	Connect a real device to Appium (describe required actions) and run tests. Are there any difference with run on emulator?**
  
  We need to do some steps:
  - Connect mobile phone by the wire
  - Unlock developer's options
  - Turn on Debugging mode on the phone
  - Find phone name in the ADB tools
  - Edit the Appium desired capabilities config: change device name to the one found at the previouse step
  Also we need to accept some allows during the installation. 
  There are no other differences. 
  

**5.	What should be improved/changed in existing test code? Why, for what?**

  - Driver must be moved to the main\java\sources section. 
  - All "green" hardcoded values must be moved to the enums and properties files, it is better for code readability. Moving constants to the config files is the way for easy code usage. 
  - Native and Web test must be separated into the different classes. 
  - PageObjects and AppObjects must be moved to the separete classes. Logic must be separeted from realisation. 
  - For test purpose we need to use asserts methods. It is needed for checking the object conditions.
  - Use annotations to build the logical test structure.



