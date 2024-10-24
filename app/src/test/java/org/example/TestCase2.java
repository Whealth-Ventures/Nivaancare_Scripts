package org.example;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TestCase2 {
    WebDriver driver;
  //create New Patient and Update details and then goal,notes,diet plan  
   // Generates random full name (combines a first and last name)
    public static String generateFullName() {
        String[] firstNames = {"John", "Jane", "Alice", "Bob", "Charlie"};
        String[] lastNames = {"Smith", "Doe", "Brown", "Johnson", "Taylor"};
        return firstNames[new Random().nextInt(firstNames.length)] + " " +
               lastNames[new Random().nextInt(lastNames.length)];
    }

    // Generates random 10-digit mobile number
    public static String generateMobileNumber() {
        StringBuilder mobile = new StringBuilder("+91");
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            mobile.append(random.nextInt(10));  // Appending digits
        }
        return mobile.toString();
    }

    // Generates random gender
    public static String generateGender() {
        String[] genders = {"Male", "Female", "Other"};
        return genders[new Random().nextInt(genders.length)];
    }
 
    // Generates random age between 18 and 80
    public static String generateAge() {
        return String.valueOf(18 + new Random().nextInt(63));  // Generates a number between 18 and 80
    }
    // Generates random email address
    public static String generateEmailAddress(String fullName) {
        String[] domains = {"gmail.com", "yahoo.com", "outlook.com"};
        String email = fullName.toLowerCase().replace(" ", ".") + 
                       "@" + domains[new Random().nextInt(domains.length)];
        return email;
    }
      // Generates random hospital
      public static String generateHospital() {
        String[] hospitals = {"Sama Hospital"};
        return hospitals[new Random().nextInt(hospitals.length)];
    }

    // Generates random source (for profile questions)
    public static String generateSource() {
        String[] sources = {"Social"};
        return sources[new Random().nextInt(sources.length)];
    }
    public static String generateSubSource() {
        String[] sources = {"Facebook", "Youtube", "Instagram"};
        return sources[new Random().nextInt(sources.length)];
    }


    // Generates random care manager
    public static String generateCareManager() {
        String[] managers = {"Riya Kumari", "OnlyforTesting", "Fardeen Mirza"};
        return managers[new Random().nextInt(managers.length)];
    }

    public static String generateRevenueManager() {
        String[] managers = {"mksdlc", "Revenue Test"};
        return managers[new Random().nextInt(managers.length)];
    }
public WebDriver setup(){
        System.out.println("Initializing the driver");
     
        driver = new ChromeDriver();
       driver.manage().window().maximize();
       return driver;
    }

    public void tearDown(){
        if (driver != null) {
            driver.quit();
        }
    }
    public void login() throws InterruptedException{
      
        driver.get("https://staging.nivaancare.co.in/");
              
        // Enter mobile number
        WebElement input = driver.findElement(By.xpath("//*[@placeholder='Registered Mobile Number']"));
        input.sendKeys("9461306458");
      

        Thread.sleep(3000);
        
        // Click on Send OTP
        WebElement sendotp = driver.findElement(By.xpath("//div[text()='Send OTP']"));
        sendotp.click();


        Thread.sleep(3000);

        // Enter OTP digits directly
        int[] otpDigits = {5, 9, 6, 9, 2, 1}; // Your provided OTP digits
        for (int i = 0; i < otpDigits.length; i++) {
            WebElement numberField = driver.findElement(By.xpath("//*[@type='number'][" + (i + 1) + "]"));
            numberField.sendKeys(String.valueOf(otpDigits[i]));
    
        }
   // Click on Sign In
   WebElement SignIn = driver.findElement(By.xpath("//*[@class='form-control  coreBtn text-white undefined']"));
   SignIn.click();
   Thread.sleep(3000);
    }
    
    //method to create a new patient
    public void createPatient() throws InterruptedException {
        String name = generateFullName();
        String mobile=generateMobileNumber();
        String gender = generateGender();
    String age = generateAge();
        String email=generateEmailAddress(name);
        String Hospital=generateHospital();
        String source=generateSource();
        String careManager=generateCareManager();
        String revenuemanger=generateRevenueManager();
        String SubSource=generateSubSource();
        //navigate to patient landing page
driver.get("https://staging.nivaancare.co.in/dashboard");
Thread.sleep(3000);
        driver.get("https://staging.nivaancare.co.in/Patient");
        Thread.sleep(4000);
        driver.findElement(By.xpath("//div[text()='Add Patient']")).click();
        Thread.sleep(3000);

    driver.findElement(By.xpath("//*[@placeholder='Full Name']")).sendKeys(name);
    Thread.sleep(1000);

    driver.findElement(By.xpath("//*[@id='root']/div[2]/div/div[2]/div/div[1]/div/form/div/div[2]/div/div/div[2]/input")).sendKeys(mobile);
    Thread.sleep(1000);

    driver.findElement(By.xpath("//*[@placeholder='Email Address']")).sendKeys(email);
    Thread.sleep(1000);

    driver.findElement(By.xpath("//span[text()='Select Gender']")).click();
    Thread.sleep(1000);
    List<WebElement> Genders=driver.findElements(By.className("rs-picker-select-menu-item"));
    for (WebElement Gender : Genders) {
        if(Gender.getText().equals(gender)){
           Gender.click();
            break;
        }
    }
    Thread.sleep(1000);
    driver.findElement(By.xpath("//*[@placeholder='Age']")).sendKeys(age);
    Thread.sleep(1000);

    driver.findElement(By.xpath("//span[text()='Select Hospital']")).click();
    Thread.sleep(1000);
    List<WebElement> hospitals=driver.findElements(By.className("rs-picker-select-menu-item"));
    for (WebElement hospital : hospitals) {
        if(hospital.getText().equals(Hospital)){
            hospital.click();
            break;
        }
    }
    Thread.sleep(1000);

    driver.findElement(By.xpath("//span[text()='Select Care Managers']")).click();
    Thread.sleep(1000);
    List<WebElement> CareManagers=driver.findElements(By.className("rs-picker-select-menu-item"));
    for (WebElement CareManager : CareManagers) {
        if(CareManager.getText().equals(careManager)){
            CareManager.click();
            break;
        }
    }
    Thread.sleep(1000);
    driver.findElement(By.xpath("//span[text()='Select Revenue Managers']")).click();
    Thread.sleep(1000);
    List<WebElement> RevenueManagers=driver.findElements(By.className("rs-picker-select-menu-item"));
    for (WebElement revenueManager : RevenueManagers) {
        if(revenueManager.getText().equals(revenuemanger)){
           revenueManager.click();
            break;
        }
    }

    Thread.sleep(3000);
    driver.findElement(By.xpath("//span[text()='Source']")).click();
    Thread.sleep(1000);
    List<WebElement>Sources=driver.findElements(By.className("rs-picker-select-menu-item"));
    for (WebElement Source : Sources) {
        if(Source.getText().equals(source)){
           Source.click();
            break;
        }
    }
    Thread.sleep(5000);
    driver.findElement(By.xpath("//span[text()='Sub Source']")).click();
    Thread.sleep(1000);
    List<WebElement>SubSources=driver.findElements(By.className("rs-picker-select-menu-item"));
    for (WebElement Source : SubSources) {
       
                if(Source.getText().equals(SubSource)){
           Source.click();
            break;
        }
    }
    Thread.sleep(5000);
    driver.findElement(By.xpath("//div[text()='Save Details']")).click();
    Thread.sleep(1000);

}

//goal creation from settings
public void createGoalFromSettings(String goalName, String TargetValue, String Frequency, String Notification,String Reminder) throws InterruptedException{
    driver.get("https://staging.nivaancare.co.in/settings");
    Thread.sleep(3000);
    driver.findElement(By.xpath("//div[text()='Global Configurations']")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//div[text()='Goal Creations']")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//*[@placeholder='Goal Name']")).sendKeys(goalName);
    Thread.sleep(1000);
    driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div/div[2]/div/div[1]/div/div/div[4]/div/img")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//*[@placeholder='Value']")).sendKeys(TargetValue);
    Thread.sleep(1000);
WebElement frequency=driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div/div[2]/div/div[1]/div/div/div[5]/div[3]/div/select"));
frequency.click();
Thread.sleep(1000);
Select select=new Select(frequency);
select.selectByVisibleText(Frequency);
Thread.sleep(1000);

driver.findElement(By.xpath("//*[@placeholder='Message is sent after enabling the goal on user profile']")).sendKeys(Notification);
Thread.sleep(1000);
driver.findElement(By.xpath("//*[@placeholder='Reminder is sent everyday at 5pm for all the goals assigned to patients']")).sendKeys(Reminder);
Thread.sleep(1000);

driver.findElement(By.xpath("//div[text()='Save']")).click();
Thread.sleep(4000);
driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div/div/div[2]/div/div[2]/div/table/tr[1]/td[2]/div/div/div[2]/div")).click();
Thread.sleep(5000);
driver.findElement(By.xpath("//div[text()='Update']")).click();
Thread.sleep(5000);
driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div/div[2]/div/div[2]/div/table/tr[1]/td[2]/div/div/div[3]/div")).click();
Alert alert=driver.switchTo().alert();
alert.accept();
Thread.sleep(3000);

}

 @Test
    public void testcase2() throws InterruptedException{
        TestCase2 test=new TestCase2();
test.setup();
test.login();
  test.createPatient();
test.createGoalFromSettings("testGoal", "50", "Weekly", "Notification", "Reminder");
    test.tearDown();
}
}
