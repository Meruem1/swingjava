package packagejdbcDemo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

import java.util.Properties;
import java.util.logging.Logger;

import com.email.durgesh.Email;
import com.mysql.cj.x.protobuf.MysqlxNotice.Warning.Level;
import java.util.Random;

import com.email.durgesh.Email;


public class Forgotpass extends JFrame {

	private JPanel contentPane;
	private JTextField textmail;
	private JTextField textField_1;
	

	/**
	 * Launch the application.
	 */
	String email;
	String otp;
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Forgotpass frame = new Forgotpass();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	/**
	 * Create the frame.
	 * @ otpSting 
	 */
	public Forgotpass() {
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter E-mail");
		lblNewLabel.setBounds(71, 60, 71, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter code");
		lblNewLabel_1.setBounds(71, 148, 61, 13);
		contentPane.add(lblNewLabel_1);
		
		textmail = new JTextField();
		textmail.setBounds(244, 57, 153, 19);
		contentPane.add(textmail);
		textmail.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(244, 145, 153, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(244, 117, 170, 13);
		contentPane.add(lblNewLabel_2);
		 lblNewLabel_2.setVisible(false);
		
		
		
		JButton btnsend = new JButton("Send");
		btnsend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
		        
		        try {
		        	Class.forName("com.mysql.cj.jdbc.Driver"); 
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/reg","root","root");  
					
		            String query = "select * from reg where email LIKE '"+textmail.getText().trim()+"'";
		            PreparedStatement statmnt = con.prepareStatement(query);
		            
		            ResultSet result = statmnt.executeQuery();               
		            if (result.next())
		            {   
		            	try {
		        			Email email= new Email("vishalsuryawanshi633@gmail.com","vishal633");
		        			
		        			email.setFrom("vishalsuryawanshi633@gmail.com", "Otpmail");
		        			
		        			email.setSubject("Your otp for resetting password");
		        			
		        			System.out.println("otp generating");
		        			 
		        			
		        			String otpSting  =generateOTP();
		        			
		        			System.out.println("OTP : "+otpSting);
		        			 otp=otpSting;
		        			 
		        			email.setContent(otpSting, "text/html");

		        			
		        			email.addRecipient(textmail.getText().trim());
		        			email.send();
		        			
		        		}
		        		catch(Exception e1)
		        		{
		        			JOptionPane.showMessageDialog(null, "Invalid Email Address","Login Error",JOptionPane.ERROR_MESSAGE);
				        	textmail.setText(null);
		        			e1.printStackTrace();
		        		}
		           	 lblNewLabel_2.setVisible(true);
		                lblNewLabel_2.setText("Your password mailed to you");     
		                JOptionPane.showMessageDialog(null, "Otp sent successfully","Otp sent",JOptionPane.INFORMATION_MESSAGE);
		            }
		            else
		            {
		            	  lblNewLabel_2.setText("Email Address not found");
		             }
		         
		            
		        } catch (Exception ex) {
		        	ex.printStackTrace();
		            lblNewLabel_2.setText("Email Address not found");
		        }  
		        
		        
		        
			}
			
		});
		
		
		btnsend.setBounds(306, 86, 91, 21);
		contentPane.add(btnsend);
		
		
		JButton btnNewButton = new JButton("Verify");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
		
			
				if(textField_1.getText().contentEquals(otp))
				{
					
					String email=textmail.getText().trim();
					reset frame1 = new reset(email);
					frame1.setVisible(true);
					Forgotpass frame = new Forgotpass();
					frame.setVisible(false);
					
					
				}
				else
				{
					JOptionPane.showMessageDialog(null, "otp doesnt match","Login Error",JOptionPane.ERROR_MESSAGE);
					textmail.setText(null);
					textField_1.setText(null);
				}
				
			}
			
			
		});
		
		btnNewButton.setBounds(306, 174, 91, 21);
		contentPane.add(btnNewButton);
		
	}
	public static String generateOTP() {
		int randomPin   =(int)(Math.random()*9000)+1000;
		String otp  =String.valueOf(randomPin);
		return otp;
	}
	
	

	


	
	

	
}

	
