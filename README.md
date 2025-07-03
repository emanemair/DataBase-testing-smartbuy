# Database Testing with Java, MySQL, and Selenium

This project demonstrates how to connect a Java application to a MySQL database to perform CRUD operations and integrate it with Selenium WebDriver for UI testing on a registration form.

## 🔍 Project Overview

The core idea of this project is to:
- Connect to a MySQL database using JDBC.
- Perform basic database operations (Insert, Read, Update, Delete) on the `customers` table.
- Use Selenium to autofill a web registration form using data retrieved from the database.

## 📂 Features

- ✅ Insert new customer records into the database.
- ✅ Update existing customer information.
- ✅ Read customer data and use it to auto-fill a web form using Selenium WebDriver.
- ✅ Delete customer-related data (e.g., orders).

## 🛠️ Technologies Used

- **Java** (JDK 8+)
- **MySQL** (JDBC Driver)
- **Selenium WebDriver**
- **TestNG** (for test management and annotations)

## 🚀 Getting Started

### Prerequisites

- Java JDK installed
- MySQL Server with `classicmodels` database
- Chrome browser and [ChromeDriver](https://sites.google.com/a/chromium.org/chromedriver/) installed
- Maven (optional) or manage dependencies manually
- TestNG library
- JDBC Connector for MySQL

### Setup

1. Clone the repository.
2. Import the project into your IDE (Eclipse/IntelliJ).
3. Make sure your `classicmodels` MySQL database is running.
4. Update database connection string if necessary:
   ```java
   con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels" , "root" , "your_password");

5. Run the test cases using TestNG.


## ✅ Test Cases

| Test Method         | Description                                               |
|---------------------|-----------------------------------------------------------|
| `InsertIntoDatabase`| Adds a new customer to the database.                      |
| `UpdateQuery`       | Updates customer’s first name.                            |
| `ReadData`          | Reads customer data and fills in a web form.              |
| `DeleteData`        | Deletes order records related to a specific customer.     |

## 🔐 Security Note

- **Never commit sensitive information** (e.g., database passwords) to version control.
- Consider using `.env` files or **environment variables** for secure credential management.

## 📸 Example Website Used

- **[SmartBuy Registration Page](https://smartbuy-me.com/ar/account/register)**



