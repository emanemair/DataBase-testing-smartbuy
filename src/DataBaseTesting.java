import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DataBaseTesting {
	
	
	Connection con; 
	Statement st; 
	ResultSet rs; 
	
	WebDriver driver= new ChromeDriver(); 
	//customer Info 
	String customerFirstName; 
	String customerLastName; 
	String customerEmail; 
	
	@BeforeTest 
	public void MySetup() throws SQLException {
		
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels" , "root" , "123456"); 
		driver.get("https://smartbuy-me.com/ar/account/register");
		
	}
	

	
	
	@Test(priority = 1 , enabled = false)
	public void InsertIntoDatabase() throws SQLException {
		
		String query = "INSERT INTO customers (customerNumber, customerName, contactLastName, contactFirstName, phone, addressLine1 , addressLine2 , city , state , postalCode, country, salesRepEmployeeNumber, creditLimit) values ( \"7854632\" , \"Reem Omran\" , \"Omran\", \"Reem\", \"0799646707\" , \"Amman\" , \"Amman\" , \"Amman\" ,\"Amman\" , \"11011\" , \"JO\", \"1370\", \"200000\")";
		st = con.createStatement(); 
		
		int RowEffected = st.executeUpdate(query); 
		System.out.println(RowEffected); 
	}
	
	
	@Test(priority = 2 , enabled = false )
	public void UpdateQuery() throws SQLException {
		
		String query = "UPDATE customers SET contactFirstName = 'Aseel' WHERE customerNumber = '7854632' "; 
		st = con.createStatement(); 
		
		int RowEffected = st.executeUpdate(query); 
		System.out.println(RowEffected); 
		
	}
	
	@Test (priority = 3 , enabled = false)
	public void ReadData() throws SQLException {
		
		String query = "SELECT * FROM customers WHERE customerNumber = '7854632' ";
		st = con.createStatement(); 
		rs = st.executeQuery(query); 
		
		while (rs.next()) {
			customerFirstName = rs.getNString("contactFirstName"); 
			customerLastName = rs.getNString("contactLastName"); 
			
			customerEmail =customerFirstName +  customerLastName + "@gmail.com"; 
			System.out.println(customerFirstName);
		}
		driver.findElement(By.id("customer[first_name]")).sendKeys(customerFirstName);
		driver.findElement(By.id("customer[last_name]")).sendKeys(customerLastName);
		driver.findElement(By.id("customer[email]")).sendKeys(customerEmail);
		driver.findElement(By.id("customer[password]")).sendKeys("QA@Test123");
	}
	
	@Test(priority = 4 , enabled = true)
	public void DeleteData() throws SQLException {
		
		String query1 = "DELETE FROM orders Where customerNumber ='103'"; 
		st = con.createStatement(); 
		
		int RowsEffected = st.executeUpdate(query1); 
		
		System.out.println(RowsEffected); 
		
	}

}

