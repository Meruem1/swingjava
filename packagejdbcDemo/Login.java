package packagejdbcDemo;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;

public class Login {

	JFrame frmLogin;
	private JTextField textUsername;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setBounds(100, 100, 505, 318);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login ");
		lblNewLabel.setBounds(195, 10, 95, 25);
		frmLogin.getContentPane().add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(78, 82, 77, 13);
		frmLogin.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(78, 116, 77, 13);
		frmLogin.getContentPane().add(lblPassword);
		
		textUsername = new JTextField();
		textUsername.setBounds(229, 79, 128, 19);
		frmLogin.getContentPane().add(textUsername);
		textUsername.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(70, 220, 85, 21);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				if(textUsername.getText().trim().isEmpty()==false  &&  passwordField.getText().trim().isEmpty()==false)
					{			
					
try
{
Class.forName("com.mysql.cj.jdbc.Driver"); 
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/reg","root","root");  
 
System.out.println("connection established");
PreparedStatement ps=con.prepareStatement("select * from reg where name=? and password=? and Role = 'admin'");
ps.setString(1, textUsername.getText());
ps.setString(2, passwordField.getText());



ResultSet x= ps.executeQuery();

if(x.next())
{
	System.out.println("Logeed in successfully");

		JOptionPane.showMessageDialog(null, "Logeed in successfully as admin","login",JOptionPane.INFORMATION_MESSAGE);
		
		Admin a=new Admin();
		a.frame.setVisible(true);
		frmLogin.setVisible(false);
		
		
		
		
		textUsername.setText(null);
		passwordField.setText(null);
	}
	else
	{
		
		PreparedStatement ps1=con.prepareStatement("select * from reg where name=? and password=? and Role = 'student'");
		ps1.setString(1, textUsername.getText());
		ps1.setString(2, passwordField.getText());
		
		String s=textUsername.getText();
		
		ResultSet x1= ps1.executeQuery();
		if(x1.next())
		{
		
JOptionPane.showMessageDialog(null, "Logeed in successfully as student","login",JOptionPane.INFORMATION_MESSAGE);
		
		Student s1=new Student();
		
		s1.frame.setVisible(true);
		
		frmLogin.setVisible(false);
	}
		else
		{
			JOptionPane.showMessageDialog(null, "Invalid login","Login Error",JOptionPane.ERROR_MESSAGE);
		}

	}


}
catch(Exception e1)
{
	System.out.println(e1);
} 
					}
else
{
	JOptionPane.showMessageDialog(null, "fields are empty","Login Error",JOptionPane.ERROR_MESSAGE);
}
			
				
			}
		});
		frmLogin.getContentPane().add(btnLogin);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(205, 220, 85, 21);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textUsername.setText(null);
				passwordField.setText(null);
			}
		});
		frmLogin.getContentPane().add(btnReset);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(340, 220, 85, 21);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmLogin = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frmLogin, "confirm if you want to exit","Login",
						JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION)
				{
					System.exit(0);
				}
								
			}
		});
		frmLogin.getContentPane().add(btnExit);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 198, 426, 2);
		frmLogin.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 47, 426, 2);
		frmLogin.getContentPane().add(separator_1);
		
		JCheckBox chckbxshowpassword = new JCheckBox("show password");
		chckbxshowpassword.setBounds(246, 146, 111, 21);
		chckbxshowpassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxshowpassword.isSelected())
				{
					passwordField.setEchoChar((char)0);
				}
				else
				{
					passwordField.setEchoChar('*');
				}
			}
		});
		
		
		
		frmLogin.getContentPane().add(chckbxshowpassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(229, 113, 128, 19);
		frmLogin.getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("Forgot password");
		btnNewButton.setBounds(367, 112, 114, 21);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textUsername.getText().trim().isEmpty()==false  &&  passwordField.getText().trim().isEmpty()==false)
				{			
				
					Forgotpass.main(null);
					
					frmLogin.setVisible(false);
					
				
				
				}
				else
				{
					JOptionPane.showMessageDialog(null, "fields are empty","Login Error",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		frmLogin.getContentPane().add(btnNewButton);
		
		
	}
}




