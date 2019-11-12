package utilities;


import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class Helper {

	// Method to take screenshot when the test cases fail
	public static void captureScreenshot(WebDriver driver , String screenshotname)
	{
		Path dest = Paths.get("./Screenshots",screenshotname+".png"); 
		try {
			Files.createDirectories(dest.getParent());
			FileOutputStream out = new FileOutputStream(dest.toString());
			out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
			out.close();
		} catch (IOException e) {
			System.out.println("Excpetion while taking screenshot"+ e.getMessage());
		}
	}

	//method to generate random email address
	public static String generateRandomEmailAddress() {
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder salt = new StringBuilder();
		Random random = new Random();
		while (salt.length() < 10) { // length of the random string.
			int index = (int) (random.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String randomString = salt.toString()+"@gmail.com";
		return randomString;
	}

	//method to read from csvFile
	public static String[] readCredentials() throws IOException {
		CSVReader reader;
		String CSV_File = System.getProperty("user.dir") + "/LoginCredentials.csv";
		reader = new CSVReader(new FileReader(CSV_File));
		String [] csvCell;
		String [] records = null;
		while ((csvCell = reader.readNext()) != null) {
			records = new String[]{csvCell[0], csvCell[1], csvCell[2]};
		}
		return records;
	}
}
