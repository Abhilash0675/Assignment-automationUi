1.Need to install the eclipse 2021-03 version. 
2.Need to have a java 15 Version. 
3.For adding the project in the eclipse -> go to file -> click on import option ->maven -> existing maven projects ->next -> RootDirectory click on browse -> select the downloaded workspace path. 
4.Need to keep login.xlsx file path in "Baseclase->getdata method" 
5.By default test scripts will execute in chrome browser in order to execute in firefox need to update the following data : LoginPageTC->perreqiestes() -> WebDriverManager.chromedriver().setup(); -> WebDriverManager.firefoxdriver().setup(); driver = new ChromeDriver(); -> driver = new FirefoxDriver(); 
6.In order to run the test scripts,open Vaisalaa class file-> right click-> run as -> TestNG Test
