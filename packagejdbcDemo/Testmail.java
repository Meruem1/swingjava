package packagejdbcDemo;

import java.util.Random;

import com.email.durgesh.Email;

public class Testmail {
	 
	

	public static void main(String[] args)throws Exception {
		 String otp;
		try {
			Email email= new Email("vishalsuryawanshi633@gmail.com","vishal633");
			
			email.setFrom("vishalsuryawanshi633@gmail.com", "Otpmail");
			
			email.setSubject("Yout otp for resetting password");
			
			System.out.println("otp generating");
			 
			
			String otpSting  =generateOTP();
			
			System.out.println("OTP : "+otpSting);
			 otp=otpSting;
			 
			email.setContent(otpSting, "text/html");

			
			email.addRecipient("vishalsuryawanshi633@gmail.com");
			email.send();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	
	
		
	public static String generateOTP() {
		int randomPin   =(int)(Math.random()*9000)+1000;
		String otp  =String.valueOf(randomPin);
		return otp;
	}
	
	}

	
