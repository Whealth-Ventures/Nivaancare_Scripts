# Nivaancare_Scripts



NivaanCare is an automated testing framework designed for testing functionalities on the NivaanCare web application using Selenium WebDriver and TestNG.




Table of Contents

Prerequisites

Installation

Running Tests

Project Structure

Test Cases

Generating Random Data

Notes

Prerequisites

Before you can build and run this project, ensure you have the following installed:


Java Development Kit (JDK) 8 or higher

Gradle 5.0 or higher

Chrome WebDriver (compatible with your version of Chrome)

Internet connection (for downloading dependencies)

Installation

Clone the repository:

git clone https://github.com/Whealth-Ventures/NivaanCare_Scripts.git

cd NivaanCare

Configure WebDriver:

Download the ChromeDriver from here and ensure it is available in your system's PATH.

Build the project using Gradle:


gradle build

Running Tests

To run the test suite, use the following Gradle command:


gradle test

This command will compile the project, run the tests, and generate test reports in the build/reports/tests/test directory.

Project Structure

src/main/java: Contains the main Java code.

src/test/java: Contains the test code.

build.gradle: The Gradle build configuration file.

settings.gradle: The Gradle settings file.

Test Cases

The project includes the following test cases located in src/test/java/Appointment.java:

navigateToURL: Tests navigation to the NivaanCare URL and login functionality.

addDoctorsDetails: Tests the process of adding a new doctor's details to the system.

addAppointment: Tests the process of adding a new appointment.

Detailed Test Case Descriptions


navigateToURL

Navigates to the NivaanCare staging URL.

Enters a registered mobile number for login.

Waits for manual CAPTCHA resolution.

Asserts successful navigation to the dashboard.

addDoctorsDetails

Navigates to the team page.

Adds a new doctor with generated random email and mobile number.

Fills in various details like role, service, hospital, availability, and schedule.

Saves the new doctor's information.

addAppointment

Navigates to the appointment page.

Adds a new appointment for an existing or new patient.

Selects clinic team, clinic, appointment type, service, and timeslot.

Enters appointment fee and completes the appointment creation.

Generating Random Data


The Appointment class contains helper methods for generating random data:

generateRandomEmail: Generates a random email address.

generateRandomMobileNumber: Generates a random 10-digit mobile number.
### Test Case 4: Adding PatientDetails for Appointment, Case-2 with No Show
**Description:** This test case automates the process of adding patient details for an appointment and marking the appointment as a "No Show".  
**Priority:** 4

**Steps:**
1. Navigate to the dashboard.
2. Go to the appointment page.
3. Click the "Add Appointment" button.
4. Select a patient named "Test Signup".
5. Choose "Virtual" as the appointment type.
6. Select "Sama Hospital" as the clinic.
7. Choose "Shubhi Doctor1" as the doctor.
8. Select "Test Crp Service" as the service.
9. Choose an available timeslot.
10. Enter an appointment fee of 1000.
11. Click the "Create and Pay" button.
12. Select the "No Show" option from the dropdown.
13. Click the "Record Payment" button.

### Test Case 5: Adding PatientDetails for Appointment, Case-3 with Show and Payment Details
**Description:** This test case automates the process of adding patient details for an appointment, marking the appointment as "Show", and entering the payment details.  
**Priority:** 5

**Steps:**
1. Navigate to the dashboard.
2. Go to the appointment page.
3. Click the "Add Appointment" button.
4. Select a patient named "Test29".
5. Choose "Physical" as the appointment type.
6. Select "Sama Hospital" as the clinic.
7. Choose "Shubhi Doctor1" as the doctor.
8. Select "Test Crp Service" as the service.
9. Choose an available timeslot.
10. Enter an appointment fee of 1000.
11. Click the "Create and Pay" button.
12. Select the "Show" option from the dropdown.
13. Choose "Fully Paid" as the payment type.
14. Select "Cash" as the payment mode.
15. Choose "Clinical Team" as the payment with option.
16. Select "Test" from the clinic team dropdown.
17. Click the "Record Payment" button.

