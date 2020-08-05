package packagejdbcDemo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JScrollPane;

public class Admin {

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin window = new Admin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Admin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 891, 543);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("book id");
		lblNewLabel.setBounds(70, 89, 64, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("book name");
		lblNewLabel_1.setBounds(70, 155, 64, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("author");
		lblNewLabel_2.setBounds(70, 209, 46, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("genre");
		lblNewLabel_3.setBounds(70, 252, 46, 13);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(151, 86, 96, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(151, 152, 96, 19);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(151, 206, 96, 19);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(151, 259, 96, 19);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("insert");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
				Class.forName("com.mysql.cj.jdbc.Driver"); 
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/book","root","root");  
				Statement stmt=con.createStatement();  
				
				System.out.println("connection established");
				PreparedStatement ps=con.prepareStatement("insert into book(book_id,book_name,author,genre) values(?,?,?,?)");
				ps.setString(1, textField.getText());
				
				ps.setString(2, textField_1.getText());

				ps.setString(3, textField_2.getText());
				ps.setString(4, textField_3.getText());
				int x= ps.executeUpdate();
				
				if(x > 0)
				{
					System.out.println("Record added successfully");
					JOptionPane.showMessageDialog(null, "Record added successfully","Registration",JOptionPane.INFORMATION_MESSAGE);
					textField.setText(null);
					textField_1.setText(null);
					textField_2.setText(null);
					textField_3.setText(null);
					
				}
				else
					System.out.println("Record addeding Failed");
					}
				catch(Exception e1)
				{
					e1.getStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(31, 330, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("update");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try
				{
				Class.forName("com.mysql.cj.jdbc.Driver"); 
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/book","root","root");  
				Statement stmt=con.createStatement();  
				
				System.out.println("connection established");
				PreparedStatement ps=con.prepareStatement("update book set book_name=?,author=?,genre=? where book_id=?");
				ps.setString(4, textField.getText());
				
				ps.setString(1, textField_1.getText());

				ps.setString(2, textField_2.getText());
				ps.setString(3, textField_3.getText());
				int x= ps.executeUpdate();
				
				if(x > 0)
				{
					System.out.println("Record updated successfully");
					JOptionPane.showMessageDialog(null, "Record updated successfully","Registration",JOptionPane.INFORMATION_MESSAGE);
					textField.setText(null);
					textField_1.setText(null);
					textField_2.setText(null);
					textField_3.setText(null);
					
				}
				else
					System.out.println("Record updating Failed");
					}
				catch(Exception e1)
				{
					e1.getStackTrace();
				}
				
				
				
			}
		});
		btnNewButton_1.setBounds(151, 330, 85, 21);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try
				{
				Class.forName("com.mysql.cj.jdbc.Driver"); 
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/book","root","root");  
				Statement stmt=con.createStatement();  
				
				System.out.println("connection established");
				PreparedStatement ps=con.prepareStatement("delete from book where book_name=?");
				
				ps.setString(1, textField_1.getText());
				int x= ps.executeUpdate();
				
				if(x > 0)
				{
					System.out.println("Record deleted successfully");
					JOptionPane.showMessageDialog(null, "Record deleted successfully","Registration",JOptionPane.INFORMATION_MESSAGE);
					textField.setText(null);
					textField_1.setText(null);
					textField_2.setText(null);
					textField_3.setText(null);
					
				}
				else
					System.out.println("Record deleting Failed");
					}
				catch(Exception e1)
				{
					e1.getStackTrace();
				}
				
				
				
				
			}
		});
		btnNewButton_2.setBounds(278, 330, 85, 21);
		frame.getContentPane().add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(379, 22, 468, 443);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"book_id", "book_name", "author", "genre", "issued"
			}
		));
		
		JButton btnNewButton_3 = new JButton("View all books");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
				Class.forName("com.mysql.cj.jdbc.Driver"); 
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/book","root","root");  
				Statement stmt=con.createStatement();  
				System.out.println("connection established");
				PreparedStatement ps=con.prepareStatement("select book_id,book_name,author,genre,issued from book");

                 ResultSet rs= ps.executeQuery();
                 table.setModel(DbUtils.resultSetToTableModel(rs));
                 
				}
                  catch(Exception ec)
               {
                	  ec.printStackTrace();
                 }
			
				
				
				
			}
		});
		btnNewButton_3.setBounds(124, 394, 142, 21);
		frame.getContentPane().add(btnNewButton_3);
		
		JLabel lblWelcomeAdmin = new JLabel("Welcome Admin");
		lblWelcomeAdmin.setOpaque(true);
		lblWelcomeAdmin.setBackground(new Color(230, 230, 250));
		lblWelcomeAdmin.setFont(new Font("Modern No. 20", Font.BOLD | Font.ITALIC, 25));
		lblWelcomeAdmin.setForeground(new Color(0, 0, 128));
		lblWelcomeAdmin.setBounds(104, 19, 194, 40);
		frame.getContentPane().add(lblWelcomeAdmin);
		
		
	}
	
	
	
	
}
