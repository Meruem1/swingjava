package packagejdbcDemo;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

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
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

public class reset extends JFrame {

	private JPanel contentPane;
	private JTextField textnewpass;
	private JTextField textrepass;
	private JButton btnNewButton;
	private JLabel lblef;
	private JLabel lblef2;
	public String user;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/*closing window method*/
	
	
//public void close()
//{
	//WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
	//Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
//}
	
	/**
	 * Create the frame.
	 */
	public reset(String username) 
	{
		
		this.user=username;
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblnewpass = new JLabel("New password");
		lblnewpass.setBounds(67, 61, 118, 13);
		contentPane.add(lblnewpass);
		
		JLabel lblrepass = new JLabel("Re -enter password");
		lblrepass.setBounds(67, 151, 118, 13);
		contentPane.add(lblrepass);
		
		textnewpass = new JTextField();
		textnewpass.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				lblef.setText("");
			}
		});
		textnewpass.setBounds(280, 58, 96, 19);
		contentPane.add(textnewpass);
		textnewpass.setColumns(10);
		
		textrepass = new JTextField();
		textrepass.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				lblef2.setText("");
			}
		});
		
		
		
		textrepass.setBounds(280, 148, 96, 19);
		contentPane.add(textrepass);
		textrepass.setColumns(10);
		
		btnNewButton = new JButton("Submit ");
		btnNewButton.setBounds(167, 198, 85, 21);
		btnNewButton.addActionListener(new ActionListener() {

		

			public void actionPerformed(ActionEvent e) {
				
				
				
				try
				{
				Class.forName("com.mysql.cj.jdbc.Driver"); 
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/reg","root","root");  
				Statement stmt=con.createStatement();  
				
				if(textnewpass.getText().trim().isEmpty() && textrepass.getText().trim().isEmpty())
				{
					lblef.setText("field is empty");
					lblef2.setText("Field is empty");
				}	
				
				else if(textnewpass.getText().trim().isEmpty())
				{
					lblef.setText("field is empty");
				}
				else if(textrepass.getText().trim().isEmpty())
				{
					lblef2.setText("Field is empty");
				}
			
				if(textnewpass.getText().contentEquals(textrepass.getText()))
				{
					if(textnewpass.getText().trim().isEmpty()==false && textrepass.getText().trim().isEmpty()==false)
					{
						
				
					
						PreparedStatement ps=con.prepareStatement("UPDATE reg SET password= ? where email =?");
				
					
				ps.setString(1, textnewpass.getText());
				ps.setString(2, user);
				
				int x1= ps.executeUpdate();
				if(x1 > 0)
				{
					System.out.println("Password reset successfully");
					JOptionPane.showMessageDialog(null, "Password reset successfully","Password reset",JOptionPane.INFORMATION_MESSAGE);
					textnewpass.setText(null);
					textrepass.setText(null);
					
					Login l =new Login();
					reset frame1 = new reset(null);
					frame1.setVisible(false);
				
					l.frmLogin.setVisible(true);
					
				}
				else
					System.out.println("password reset Failed");
					
				}
					else
					{
						JOptionPane.showMessageDialog(null, "Both fields are blank","blank Error",JOptionPane.ERROR_MESSAGE);
					}
				}
				else
				{
					
					JOptionPane.showMessageDialog(null, "Enter same password","Login Error",JOptionPane.ERROR_MESSAGE);
					textnewpass.setText(null);
					textrepass.setText(null);
					
				}
				}
				
					
				
			catch(Exception e1)
				{
					System.out.println(e1);
				}  
				
				
			}
		

		});
		contentPane.add(btnNewButton);
		
		lblef = new JLabel("Enter field");
		lblef.setBounds(290, 87, 96, 13);
		contentPane.add(lblef);
		
		lblef2 = new JLabel("Enter field");
		lblef2.setBounds(290, 176, 96, 13);
		contentPane.add(lblef2);
		}


	
	
	}



