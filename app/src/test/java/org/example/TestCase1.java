package org.example;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestCase1 {
     WebDriver driver;
    static ExtentReports report;
    static ExtentTest test;

 
    public WebDriver setup(){
        System.out.println("Initializing the driver");
     
        driver = new ChromeDriver();
                  // Extent Reports configuration
                  report=new ExtentReports("/Users/indianrenters/Downloads/Nivaan_AutomantionScripts/report/index.html",true);
                  test = report.startTest("Test Case 1");
       driver.manage().window().maximize();
       return driver;
    }

    public void tearDown(){
        if (driver != null) {
            driver.quit();
        }
        report.endTest(test);
        report.flush();
    }
    private String generateandomDoctor(){
    String[] name={"Dr.Testdoctor","Dr. test1","Dr. SampleTest","testignDoc","Dr.Testdoctor","Dr. SampleTest","NewDoctor"};

  
    Random random=new Random();
    String doctorName=name[random.nextInt(name.length)];
    return doctorName;
}
private String generateRandomEmail() {
       String characters = "abcdefghijklmnopqrstuvwxyz1234567890";
       StringBuilder email = new StringBuilder();
       Random random = new Random();
       while (email.length() < 10) { // length of the random email string
           int index = random.nextInt(characters.length());
           email.append(characters.charAt(index));
       }
       return email.append("@gmail.com").toString();
   }
   private static final String[] hospitalNames = {
    "Aashlok Hospital",
    "Sama Hospital",
    "Sree Krishna Medical & Research Centre",
    "Gouri Hospital",
    "DardMantra Clinic",
    "SIMM Healthcare",
    "Agarwal's Gynae & Spine pain clinic",
    "Irene Hospital",
    "Apollo Spectra"
};

public static String generateRandomHospitalName() {
    Random random = new Random();
    int index = random.nextInt(hospitalNames.length);
    return hospitalNames[index];
}
private static String generateRandomGender() {
    Random random = new Random();
    // Array of possible genders
    String[] genders = {"Male", "Female", "Other"};
    // Select a random gender from the array
    int index = random.nextInt(genders.length);
    return genders[index];
}
private static String generateRandomService() {
    Random random = new Random();
    // Array of possible genders
    String[] services = {"apt test", "mksdlc","cml test","Vinod Kumar","Riya Kumari"};
    // Select a random gender from the array
    int index = random.nextInt(services.length);
    return services[index];
}

private static String generateRandomService2() {
    Random random = new Random();
    // Array of possible genders
    String[] services = {"crp","consult","procedure","break","followup"};
    // Select a random gender from the array
    int index = random.nextInt(services.length);
    return services[index];
}
   private String generateRandomMobileNumber() {
       Random random = new Random();
       StringBuilder mobileNumber = new StringBuilder("9"); // start with 9 for a 10 digit mobile number
       while (mobileNumber.length() < 10) {
           int digit = random.nextInt(10);
           mobileNumber.append(digit);
       }
       return mobileNumber.toString();
   }private int calculateOffsetForValue(int value) {
   
    int sliderRange = 60; // Example range
    int sliderWidth = 200; // Example width in pixels
    return (value * sliderWidth) / sliderRange;
}
public void login(WebDriver driver) throws InterruptedException{
  String mobile="9461306458";
        // Log the start of the test
        test.log(LogStatus.PASS, "Starting Testcase ");
        try{
        test.log(LogStatus.INFO, "Navigating to URL");
        driver.get("https://staging.nivaancare.co.in/");
        
        // Enter mobile number
        WebElement input = driver.findElement(By.xpath("//*[@placeholder='Registered Mobile Number']"));
        input.sendKeys(mobile);
        test.log(LogStatus.INFO, "Entered mobile number"+mobile);

        Thread.sleep(3000);
        
        // Click on Send OTP
        WebElement sendotp = driver.findElement(By.xpath("//div[text()='Send OTP']"));
        sendotp.click();
        test.log(LogStatus.INFO, "Clicked on Send OTP");

        Thread.sleep(3000);

        // Enter OTP digits directly
        int[] otpDigits = {5, 9, 6, 9, 2, 1}; // Your provided OTP digits
        for (int i = 0; i < otpDigits.length; i++) {
            WebElement numberField = driver.findElement(By.xpath("//*[@type='number'][" + (i + 1) + "]"));
            numberField.sendKeys(String.valueOf(otpDigits[i]));
            test.log(LogStatus.INFO, "Entered OTP digit " + otpDigits[i]);
        }
        
        Thread.sleep(1000);

        // Click on Sign In
        WebElement SignIn = driver.findElement(By.xpath("//*[@class='form-control  coreBtn text-white undefined']"));
        SignIn.click();
       test.log(LogStatus.INFO, "Clicked on Sign In");

        Thread.sleep(3000);
        
        // Log success
       test.log(LogStatus.PASS, "Login performed successfully");

}
catch(Exception e){
    test.log(LogStatus.FAIL, "Login failed");
}
}
public void addDoctorsDetails(String startTime, String endTime) throws InterruptedException{
    String team="Doctor";
    String service= generateRandomService();
    String service2=generateRandomService2();
    String hospital=generateRandomHospitalName();
    test.log(LogStatus.PASS, "Starting TestCase");
    String doctor=generateandomDoctor();
    String gender=generateRandomGender();
    try{
    test.log(LogStatus.INFO, "Adding Doctors Details");
    String randomEmail = generateRandomEmail();
    String randomMobileNumber = generateRandomMobileNumber();

    driver.get("https://staging.nivaancare.co.in/dashboard");
    Thread.sleep(3000);
    driver.get("https://staging.nivaancare.co.in/team");
    Thread.sleep(3000);
    test.log(LogStatus.INFO, "Navigate to Nivaan Staging");
    WebElement addNewTeam=driver.findElement(By.xpath("//*[@id='root']/div[2]/div[1]/div[1]/div[2]/div[2]/div/div"));
    addNewTeam.click();
    test.log(LogStatus.INFO, "Click on add new team");
    Thread.sleep(2000);
    WebElement doctorName=driver.findElement(By.xpath("//*[@placeholder='Full Name']"));
    doctorName.sendKeys(doctor);
    test.log(LogStatus.INFO, "Adding Doctors Name" +doctor);
    WebElement role=driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div/div[1]/div/div/div/div/div[3]/div/div/div"));
    role.click();
    test.log(LogStatus.INFO, "Assigned Role : " +team);
    Thread.sleep(2000);
    WebElement searchRole=driver.findElement(By.xpath("//*[@placeholder='Search']"));
    searchRole.sendKeys(team);
    searchRole.sendKeys(Keys.ENTER);
    Thread.sleep(3000);
    test.log(LogStatus.PASS, "Assigned Role : " +team);
    WebElement SElement=driver.findElement(By.xpath("//*[@placeholder='Select']"));
    SElement.sendKeys(service);
    List<WebElement> options3=driver.findElements(By.xpath("//*[@class='option    ']"));
    for(WebElement option:options3){
        if(option.getText().contains(service)){
            option.click();
            break;
        }
    }
    Thread.sleep(2000);
    test.log(LogStatus.INFO, "Assigned service : " +service);
    WebElement mobileNo=driver.findElement(By.xpath("//*[@placeholder='10 Digit Mobile Number']"));
    mobileNo.sendKeys(randomMobileNumber);
    mobileNo.sendKeys(Keys.ENTER);
    Thread.sleep(2000);
    test.log(LogStatus.PASS, "Assigned mobile number : " +randomMobileNumber);
    WebElement email=driver.findElement(By.xpath("//*[@placeholder='Email Address']"));
    email.sendKeys(randomEmail);
    test.log(LogStatus.PASS, "Assigned email : " +randomEmail);
    WebElement selectService=driver.findElement(By.xpath("//*[@placeholder='Select Service']"));
    selectService.sendKeys(service2);
    List<WebElement> options4=driver.findElements(By.xpath("//*[@class='option    ']"));
    for(WebElement option:options4){
        if(option.getText().contains(service2)){
            option.click();
            break;
        }
    }
    Thread.sleep(2000);
    test.log(LogStatus.PASS, "Assigned service : " +service2);
    WebElement selectHospital=driver.findElement(By.xpath("//*[@placeholder='Select Hospitals']"));
    selectHospital.sendKeys(hospital);
    List<WebElement> options=driver.findElements(By.xpath("//*[@class='option    ']"));
    for(WebElement option:options){
        if(option.getText().contains(hospital)){
            option.click();
            break;
        }
    }
    test.log(LogStatus.PASS, "Assigned Hospital : " +hospital);
    Thread.sleep(3000);
    WebElement next=driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div/div[2]/div[2]/div"));
    next.click();
    Thread.sleep(3000);
    WebElement shortIntro=driver.findElement(By.xpath("//*[@placeholder='Short information about team member']"));
    shortIntro.sendKeys("Experienced Doctor");
    shortIntro.sendKeys(Keys.ENTER);
    Thread.sleep(2000);
    WebElement AddLanguage=driver.findElement(By.xpath("//*[@placeholder='Add Known Languages']"));
    AddLanguage.sendKeys("English");
    List<WebElement> options1=driver.findElements(By.xpath("//*[@class='option    ']"));
    for(WebElement option:options1){
        if(option.getText().contains("English")){
            option.click();
            break;
        }
    }
    test.log(LogStatus.PASS, "Assigned Language : English ");
    Thread.sleep(2000);
    WebElement genderdropdown=driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div/div[1]/div/div/div[2]/div[3]/div/div/div"));
    genderdropdown.click();
    WebElement SearchGender=driver.findElement(By.xpath("//*[@placeholder='Search']"));
    SearchGender.sendKeys(gender);
    SearchGender.sendKeys(Keys.ENTER);
    test.log(LogStatus.PASS, "Assigned gender : " +gender);
    Thread.sleep(2000);
    next.click();
    Thread.sleep(3000);
    WebElement sliderHandle = driver.findElement(By.className("rs-slider-handle"));

    Actions actions = new Actions(driver);
    int xOffset = calculateOffsetForValue(20);
    actions.clickAndHold(sliderHandle).moveByOffset(xOffset, 0).release().perform();
    Thread.sleep(3000);
    WebElement avail1=driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div/div[1]/div/div/div/div[4]/table/tbody/tr[1]/td[2]/select"));
Select select1=new Select(avail1);
select1.selectByVisibleText("Available");
Thread.sleep(2000);
WebElement startTimeInput1 = driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div/div[1]/div/div/div/div[4]/table/tbody/tr[1]/td[3]/div[1]/div[1]/div[1]/input"));

// Set the desired start time
startTimeInput1.clear();
startTimeInput1.sendKeys(startTime);

// Locate the end time input field
WebElement endTimeInput1 = driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div/div[1]/div/div/div/div[4]/table/tbody/tr[1]/td[3]/div[1]/div[1]/div[2]/input"));

// Set the desired end time
endTimeInput1.clear();
endTimeInput1.sendKeys(endTime);
WebElement hospElement1=driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div/div[1]/div/div/div/div[4]/table/tbody/tr[1]/td[3]/div[1]/div[2]/select"));
Select selectHospSelect1=new Select(hospElement1);
selectHospSelect1.selectByVisibleText(hospital);
test.log(LogStatus.PASS, "Assigned hospital : " +hospital);
Thread.sleep(3000);
WebElement avail2=driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div/div[1]/div/div/div/div[4]/table/tbody/tr[2]/td[2]/select"));
Select select2=new Select(avail2);
select2.selectByVisibleText("Available");
Thread.sleep(2000);
WebElement startTimeInput2 = driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div/div[1]/div/div/div/div[4]/table/tbody/tr[2]/td[3]/div[1]/div[1]/div[1]/input"));


// Set the desired start time
startTimeInput2.clear();
startTimeInput2.sendKeys(startTime);

// Locate the end time input field
WebElement endTimeInput2 = driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div/div[1]/div/div/div/div[4]/table/tbody/tr[2]/td[3]/div[1]/div[1]/div[2]/input"));

// Set the desired end time
endTimeInput2.clear();
endTimeInput2.sendKeys(endTime);
WebElement hospElement2=driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div/div[1]/div/div/div/div[4]/table/tbody/tr[2]/td[3]/div[1]/div[2]/select"));
Select selectHospSelect2=new Select(hospElement2);
selectHospSelect2.selectByVisibleText(hospital);
test.log(LogStatus.PASS, "Assigned hospital : " +hospital);
Thread.sleep(3000);
WebElement avail3=driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div/div[1]/div/div/div/div[4]/table/tbody/tr[3]/td[2]/select"));
Select select3=new Select(avail3);
select3.selectByVisibleText("Available");
Thread.sleep(2000);
WebElement startTimeInput3= driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div/div[1]/div/div/div/div[4]/table/tbody/tr[3]/td[3]/div[1]/div[1]/div[1]/input"));

// Set the desired start time
startTimeInput3.clear();
startTimeInput3.sendKeys(startTime);

// Locate the end time input field
WebElement endTimeInput3 = driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div/div[1]/div/div/div/div[4]/table/tbody/tr[3]/td[3]/div[1]/div[1]/div[2]/input"));

// Set the desired end time
endTimeInput3.clear();
endTimeInput3.sendKeys(endTime);
WebElement hospElement3=driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div/div[1]/div/div/div/div[4]/table/tbody/tr[3]/td[3]/div[1]/div[2]/select"));
Select selectHospSelect3=new Select(hospElement3);
selectHospSelect3.selectByVisibleText(hospital);
test.log(LogStatus.PASS, "Assigned hospital : " +hospital);
Thread.sleep(3000);
WebElement avail4=driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div/div[1]/div/div/div/div[4]/table/tbody/tr[4]/td[2]/select"));
Select select4=new Select(avail4);
select4.selectByVisibleText("Available");
Thread.sleep(2000);
WebElement startTimeInput4= driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div/div[1]/div/div/div/div[4]/table/tbody/tr[4]/td[3]/div[1]/div[1]/div[1]/input"));

// Set the desired start time
startTimeInput4.clear();
startTimeInput4.sendKeys(startTime);

// Locate the end time input field
WebElement endTimeInput4 = driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div/div[1]/div/div/div/div[4]/table/tbody/tr[4]/td[3]/div[1]/div[1]/div[2]/input"));

// Set the desired end time
endTimeInput4.clear();
endTimeInput4.sendKeys(endTime);
WebElement hospElement4=driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div/div[1]/div/div/div/div[4]/table/tbody/tr[4]/td[3]/div[1]/div[2]/select"));
Select selectHospSelect4=new Select(hospElement4);
selectHospSelect4.selectByVisibleText(hospital);
test.log(LogStatus.PASS, "Assigned hospital : " +hospital);
Thread.sleep(3000);
WebElement avail5=driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div/div[1]/div/div/div/div[4]/table/tbody/tr[5]/td[2]/select"));
Select select5=new Select(avail5);
select5.selectByVisibleText("Available");
Thread.sleep(2000);
WebElement startTimeInput5 = driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div/div[1]/div/div/div/div[4]/table/tbody/tr[5]/td[3]/div[1]/div[1]/div[1]/input"));

// Set the desired start time
startTimeInput5.clear();
startTimeInput5.sendKeys(startTime);

// Locate the end time input field
WebElement endTimeInput5 = driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div/div[1]/div/div/div/div[4]/table/tbody/tr[5]/td[3]/div[1]/div[1]/div[2]/input"));

// Set the desired end time
endTimeInput5.clear();
endTimeInput5.sendKeys(endTime);
WebElement hospElement5=driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div/div[1]/div/div/div/div[4]/table/tbody/tr[5]/td[3]/div[1]/div[2]/select"));
Select selectHospSelect5=new Select(hospElement5);
selectHospSelect5.selectByVisibleText(hospital);
test.log(LogStatus.PASS, "Assigned hospital : " +hospital);
Thread.sleep(3000);
WebElement avail6=driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div/div[1]/div/div/div/div[4]/table/tbody/tr[6]/td[2]/select"));
Select select6=new Select(avail6);
select6.selectByVisibleText("Available");
Thread.sleep(2000);
WebElement startTimeInput6 = driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div/div[1]/div/div/div/div[4]/table/tbody/tr[6]/td[3]/div[1]/div[1]/div[1]/input"));

// Set the desired start time
startTimeInput6.clear();
startTimeInput6.sendKeys(startTime);

// Locate the end time input field
WebElement endTimeInput6= driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div/div[1]/div/div/div/div[4]/table/tbody/tr[6]/td[3]/div[1]/div[1]/div[2]/input"));

// Set the desired end time
endTimeInput6.clear();
endTimeInput6.sendKeys(endTime);
WebElement hospElement6=driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div/div[1]/div/div/div/div[4]/table/tbody/tr[6]/td[3]/div[1]/div[2]/select"));
Select selectHospSelect6=new Select(hospElement6);
selectHospSelect6.selectByVisibleText(hospital);
test.log(LogStatus.PASS, "Assigned hospital : " +hospital);
Thread.sleep(3000);
WebElement avail7=driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div/div[1]/div/div/div/div[4]/table/tbody/tr[7]/td[2]/select"));
Select select7=new Select(avail7);
select7.selectByVisibleText("Available");
Thread.sleep(2000);
WebElement startTimeInput7 = driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div/div[1]/div/div/div/div[4]/table/tbody/tr[7]/td[3]/div[1]/div[1]/div[1]/input"));

// Set the desired start time
startTimeInput7.clear();
startTimeInput7.sendKeys(startTime);

// Locate the end time input field
WebElement endTimeInput7= driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div/div[1]/div/div/div/div[4]/table/tbody/tr[7]/td[3]/div[1]/div[1]/div[2]/input"));

// Set the desired end time
endTimeInput7.clear();
endTimeInput7.sendKeys(endTime);
WebElement hospElement7=driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div/div[1]/div/div/div/div[4]/table/tbody/tr[7]/td[3]/div[1]/div[2]/select"));
Select selectHospSelect7=new Select(hospElement7);
selectHospSelect7.selectByVisibleText(hospital);
test.log(LogStatus.PASS, "Assigned hospital : " +hospital);
Thread.sleep(3000);     
WebElement nextButton=driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div/div[2]/div[3]/div"));
nextButton.click();
Thread.sleep(3000);
WebElement nextbn2=driver.findElement(By.xpath("//div[text()='Next']"));
nextbn2.click();
Thread.sleep(3000);
WebElement saveDetails=driver.findElement(By.xpath("//div[text()='Save Details']"));
saveDetails.click();
Thread.sleep(3000);
test.log(LogStatus.PASS, "Adding Doctor to the team");
    }
    catch(Exception e){
        test.log(LogStatus.FAIL, "Adding team member failed");
    }

}



    @Test
    public void testcase1() throws InterruptedException{
   WebDriver driver1= setup();
    login(driver1);
    addDoctorsDetails("10:00AM", "04:00PM");
    tearDown();
    }
}
