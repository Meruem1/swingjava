package packagejdbcDemo;

import java.awt.EventQueue;


import javax.swing.JFrame;

import packagejdbcDemo.Login;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JToggleButton;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import java.awt.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

public class Registration {

	JFrame Regframe;
	private JTextField textname;
	private JTextField textadd;
	private JTextField textcno;
	private JTextField textmail;
	private JPasswordField passwordField;
	private JTextField textnamee;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration window = new Registration();
					window.Regframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Registration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Regframe = new JFrame();
		Regframe.getContentPane().setForeground(new Color(0, 0, 255));
		Regframe.setBounds(100, 100, 705, 492);
		Regframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLogin.setBounds(276, 403, 85, 21);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Login l =new Login();
				l.frmLogin.setVisible(true);
				 Regframe.setVisible(false);
			}
		});
		JLabel lblname2 = new JLabel("New label");
		lblname2.setBounds(573, 105, 85, 13);
		lblname2.setVisible(false);
		Regframe.getContentPane().add(lblname2);
		
		JLabel lblgender2 = new JLabel("New label");
		lblgender2.setBounds(573, 140, 85, 13);
		lblgender2.setVisible(false);
		Regframe.getContentPane().add(lblgender2);
		
		JLabel lbladd2 = new JLabel("New label");
		lbladd2.setBounds(573, 180, 85, 13);
		lbladd2.setVisible(false);
		Regframe.getContentPane().add(lbladd2);
		
		JLabel lblcno2 = new JLabel("New label");
		lblcno2.setBounds(573, 212, 85, 13);
		lblcno2.setVisible(false);
		Regframe.getContentPane().add(lblcno2);
		
		JLabel lblemail2 = new JLabel("New label");
		lblemail2.setBounds(573, 250, 85, 13);
		lblemail2.setVisible(false);
		Regframe.getContentPane().add(lblemail2);
		
		JLabel lblpass2 = new JLabel("New label");
		lblpass2.setBounds(573, 285, 85, 13);
		lblpass2.setVisible(false);
		Regframe.getContentPane().add(lblpass2);
		
		
		Regframe.getContentPane().setLayout(null);
		Regframe.getContentPane().add(btnLogin);
		
		JLabel lblReg = new JLabel("  Registration Form");
		lblReg.setForeground(new Color(0, 0, 139));
		lblReg.setFont(new Font("Monotype Corsiva", Font.BOLD | Font.ITALIC, 25));
		lblReg.setBackground(new Color(230, 230, 250));
		lblReg.setOpaque(true);
		lblReg.setHorizontalAlignment(SwingConstants.LEFT);
		lblReg.setBounds(237, 10, 215, 40);
		Regframe.getContentPane().add(lblReg);
		
		JLabel lblName = new JLabel("username");
		lblName.setBounds(122, 105, 76, 13);
		Regframe.getContentPane().add(lblName);
		
		JLabel lblMail = new JLabel("E-mail");
		lblMail.setBounds(122, 250, 76, 13);
		Regframe.getContentPane().add(lblMail);
		
		JLabel lblCno = new JLabel("Contact No.");
		lblCno.setBounds(122, 212, 106, 13);
		Regframe.getContentPane().add(lblCno);
		
		JLabel lblpass = new JLabel("password");
		lblpass.setBounds(122, 285, 96, 13);
		Regframe.getContentPane().add(lblpass);
		
		JLabel lbladd = new JLabel("Address");
		lbladd.setBounds(122, 180, 106, 13);
		Regframe.getContentPane().add(lbladd);
		
		
		textname = new JTextField();
		textname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				lblname2.setText("");
			}
		});
		textname.setBounds(441, 102, 96, 19);
		Regframe.getContentPane().add(textname);
		textname.setColumns(10);
		
		
		JLabel lblNewLabel = new JLabel("Gender");
		lblNewLabel.setBounds(122, 142, 76, 13);
		Regframe.getContentPane().add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();

		comboBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				lblgender2.setText("");
			}
		});
		comboBox.addItem("Select");
		comboBox.addItem("Male");
		comboBox.addItem("Female");
		comboBox.setSelectedItem(null);
		comboBox.setBounds(441, 138, 96, 21);
		Regframe.getContentPane().add(comboBox);
		
		
		textadd = new JTextField();
		textadd.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				lbladd2.setText("");
			}
		});
		textadd.setBounds(441, 177, 96, 19);
		Regframe.getContentPane().add(textadd);
		textadd.setColumns(10);
		
		textcno = new JTextField();
		textcno.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				lblcno2.setText("");
			}
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_DELETE))
				{
					Toolkit.getDefaultToolkit().beep(); 
				e.consume();
				}
			}
			
		});
		textcno.setBounds(441, 206, 96, 19);
		Regframe.getContentPane().add(textcno);
		textcno.setColumns(10);
		
		textmail = new JTextField();
		textmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				lblemail2.setText("");
			}
		});
		textmail.setBounds(441, 247, 96, 19);
		Regframe.getContentPane().add(textmail);
		textmail.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 60, 719, 2);
		Regframe.getContentPane().add(separator);
		
	
		


		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				
				try
				{
				Class.forName("com.mysql.cj.jdbc.Driver"); 
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/reg","root","root");  
				Statement stmt=con.createStatement();  
				
				
				
				if(textname.getText().trim().isEmpty()  &&  textadd.getText().trim().isEmpty()
						&& textcno.getText().trim().isEmpty() && textmail.getText().trim().isEmpty() && passwordField.getText().trim().isEmpty())
				{
					lblname2.setVisible(true);
					lblname2.setText("field is empty");
					lblgender2.setVisible(true);
					lblgender2.setText("Field is empty");
					lbladd2.setVisible(true);
					lbladd2.setText("Field is empty");
					lblcno2.setVisible(true);
					lblcno2.setText("Field is empty");
					lblemail2.setVisible(true);
					lblemail2.setText("Field is empty");
					lblpass2.setVisible(true);
					lblpass2.setText("Field is empty");
				}
				
				
				else if(textname.getText().trim().isEmpty())
				{
					lblname2.setVisible(true);
					lblname2.setText("field is empty");
				}
				else if(comboBox.getSelectedIndex()==-1)
				{
					lblgender2.setVisible(true);
					lblgender2.setText("Field is empty");
				}
				else if(textadd.getText().trim().isEmpty())
				{
					lbladd2.setVisible(true);
				lbladd2.setText("Field is empty");
				}
				else if(textcno.getText().trim().isEmpty())
				{
					lblcno2.setVisible(true);
				lblcno2.setText("Field is empty");
				}
				else if(textmail.getText().trim().isEmpty())
				{
					lblemail2.setVisible(true);
				lblemail2.setText("Field is empty");
				}
				else if(passwordField.getText().trim().isEmpty())
				{
					lblpass2.setVisible(true);
				lblpass2.setText("Field is empty");
				}
					if(textname.getText().trim().isEmpty()==false  &&  textadd.getText().trim().isEmpty()==false
						&& textcno.getText().trim().isEmpty()==false && textmail.getText().trim().isEmpty()==false && passwordField.getText().trim().isEmpty()==false)
					{
						
						
						
					
				System.out.println("connection established");
				

				PreparedStatement ps1=con.prepareStatement("select * from reg where name=? ");
				ps1.setString(1, textname.getText());
				ResultSet x1= ps1.executeQuery();
				if(x1.next()==false)
				
				{
				
				
				
				PreparedStatement ps=con.prepareStatement("insert into reg(name,gender,address,contact_no,email,password) values(?,?,?,?,?,?)");
				ps.setString(1, textname.getText());
				
				String value= comboBox.getSelectedItem().toString();
				
				ps.setString(2, value);
				ps.setString(3, textadd.getText());
				ps.setString(4, textcno.getText());
				ps.setString(5, textmail.getText());
				ps.setString(6, passwordField.getText());
				
		
				
				int x= ps.executeUpdate();
				if(x > 0)
				{
					System.out.println("Registration done successfully");
					JOptionPane.showMessageDialog(null, "Registered successfully","Registration",JOptionPane.INFORMATION_MESSAGE);
					textname.setText(null);
					textadd.setText(null);
					textcno.setText(null);
					textmail.setText(null);
					passwordField.setText(null);
					comboBox.setSelectedIndex(-1);
				}
				else
				{
					System.out.println("Registration Failed");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Username already taken","change username",JOptionPane.ERROR_MESSAGE);
				}
				
					}
	
				}
			catch(Exception e1)
				{
					System.out.println(e1);
				}  
				
				
			}
		});
		btnSubmit.setBounds(336, 340, 85, 21);
		Regframe.getContentPane().add(btnSubmit);
		
		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				lblpass2.setText("");
			}
		});
		passwordField.setBounds(441, 282, 96, 19);
		Regframe.getContentPane().add(passwordField);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 370, 709, 2);
		Regframe.getContentPane().add(separator_1);
		
		JButton btnreset = new JButton("reset");
		btnreset.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnreset.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnreset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				textname.setText(null);
				comboBox.setSelectedIndex(-1);
				textadd.setText(null);
				textcno.setText(null);
				textmail.setText(null);
				passwordField.setText(null);
				lblname2.setVisible(false);
				lblgender2.setVisible(false);
				lbladd2.setVisible(false);
				lblemail2.setVisible(false);
				lblpass2.setVisible(false);
				lblcno2.setVisible(false);
			}
			
		});
		btnreset.setBounds(222, 340, 85, 21);
		Regframe.getContentPane().add(btnreset);
		
		JLabel lblNewLabel_1 = new JLabel("login if already Registered");
		lblNewLabel_1.setBounds(257, 379, 185, 13);
		Regframe.getContentPane().add(lblNewLabel_1);
		
		
		
		
		
	}
}
