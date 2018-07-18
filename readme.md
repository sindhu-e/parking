Project is structured in to following packages.
src/main/java/calculatorTests - Contains all the test files.
src/main/java/datareader - Contains .java files for reading input data from user to run the tests
src/main/java/pages - Page object model files. It contains class to init and access web elements  
src/main/resources - All the input data files in .csv format

Running the tests
1. Install eclipse, JRE 1.8 and Maven plugins for eclipse
2. Download the chrome webdriver to your computer.
3. In src/main/java/calculatorTests/TestSuiteParent.java change the following function System.setProperty()
to point to the directory where the chrome driver is located in your computer.
4. In eclipse, right click on the testng.xml and chose the option Run AS -> TestNG suite

