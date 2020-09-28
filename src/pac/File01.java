package pac;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class File01 
{
	String[] visitPurpose = new String[] {"Pirmreizēja konsultācija", "Procedūra", "Atkārtotā vizīte", "Kontrole"};
	String registry(String name, String phone, String dateTime, String purpose) {
		
		try 
		{
			if (isPhoneNum(phone)) {
				FileWriter myFile = new FileWriter("Registry.txt", true);
				PrintWriter writeIntoFile = new PrintWriter(myFile);
				writeIntoFile.printf("%s %s %s %s\n", name, phone, dateTime, purpose);
				myFile.close();
				return "Your registratuin successfully saved!";
			}
			else 
				return "The phone number is of a wrong format!";
		} 
		catch (IOException e) 
		{
			return "An error occurred.";
		}
	}
	
	static boolean isPhoneNum(String userPhone)
	{
		if (userPhone.matches("\\d{8}") ||
				userPhone.matches("\\d{2}[-\\s]\\d{3}[-\\s]\\d{3}"))
			return true;
		else
			return false;		
	}
}
