package packagejdbcDemo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;

public class Student {

	JFrame frame;
	private JTextField textField;
	private JTable table;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	String s1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student window = new Student();
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
	public Student() {
		initialize();
	}

	public Student(String s) {
		// TODO Auto-generated constructor stub
		this.s1=s;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 907, 546);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("   BOOK DETAILS");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setFont(new Font("Monotype Corsiva", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setBackground(new Color(230, 230, 250));
		lblNewLabel.setBounds(339, 10, 222, 53);
		frame.getContentPane().add(lblNewLabel);
		

		JComboBox comboBox = new JComboBox();
		comboBox.addMouseListener(new MouseAdapter() {
			
			
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "paulo coelho", "Gorge Orwell", "Harper Lee", "F Scotty Fitzgerald", "Jane Austan", "William Shakespeare", "Marcel Proust", "Leo Tolstoy", "J. D. Salinger", "Jhon Steinbeck", "James Joyce"}));
		comboBox.setEnabled(false);
		comboBox.setBounds(645, 102, 142, 21);
		frame.getContentPane().add(comboBox);
		
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("search by name");
		rdbtnNewRadioButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rdbtnNewRadioButton.enable(false);
				comboBox.setEnabled(false);
				comboBox.setSelectedIndex(-1);
				
				
			}
		});
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		
		System.out.println(s1);
		
		rdbtnNewRadioButton.setBounds(91, 102, 134, 21);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("search by author");
		rdbtnNewRadioButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				
				comboBox.setEnabled(true);
			}
		});
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		rdbtnNewRadioButton_1.setBounds(511, 102, 105, 21);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		
		textField = new JTextField();
		textField.setBounds(254, 103, 96, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		
		JButton btnNewButton = new JButton("view books");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				try
				{
				Class.forName("com.mysql.cj.jdbc.Driver"); 
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/book","root","root");  
				Statement stmt=con.createStatement();  
				System.out.println("connection established");
				PreparedStatement ps=con.prepareStatement("select book_id,book_name,author,genre from book");

                 ResultSet rs= ps.executeQuery();
                 table.setModel(DbUtils.resultSetToTableModel(rs));
                 
				}
                  catch(Exception ec)
               {
                	  ec.printStackTrace();
                 }
			}
		});
		btnNewButton.setBounds(263, 466, 112, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Home");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Home h =new Home();
				h.frame.setVisible(true);
				frame.setVisible(false);
				
		
				
			}
		});
		btnNewButton_1.setBounds(142, 466, 85, 21);
		frame.getContentPane().add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(62, 141, 773, 321);
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
		
		JButton btnNewButton_2 = new JButton("search");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try
				{
				Class.forName("com.mysql.cj.jdbc.Driver"); 
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/book","root","root");  
				Statement stmt=con.createStatement();  
				System.out.println("connection established");
				PreparedStatement ps=con.prepareStatement("select * from book where author=? ");
				ps.setString(1,textField.getText() );
				ResultSet x= ps.executeQuery();
				  
				 
						System.out.println(" successfully");
						//JOptionPane.showMessageDialog(null, "Record deleted successfully","Registration",JOptionPane.INFORMATION_MESSAGE);
			     table.setModel(DbUtils.resultSetToTableModel(x));
			    
			
					
				}
			      catch(Exception ec)
			   {
			    	  ec.printStackTrace();
			     }

				
			}
		});
		btnNewButton_2.setBounds(377, 102, 85, 21);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("search");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
				Class.forName("com.mysql.cj.jdbc.Driver"); 
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/book","root","root");  
				Statement stmt=con.createStatement();  
				System.out.println("connection established");
				PreparedStatement ps=con.prepareStatement("select * from book where author=? ");
				
				String value= comboBox.getSelectedItem().toString();
				
				ps.setString(1,value);
				ResultSet x= ps.executeQuery();
				  
				 
						System.out.println(" successfully");
						//JOptionPane.showMessageDialog(null, "Record deleted successfully","Registration",JOptionPane.INFORMATION_MESSAGE);
			     table.setModel(DbUtils.resultSetToTableModel(x));
			    
			
					
				}
			      catch(Exception ec)
			   {
			    	  ec.printStackTrace();
			     }

				
			}
		});
		btnNewButton_3.setBounds(797, 102, 85, 21);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Issue book");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Issue i=new Issue();
				i.frame.setVisible(true);
				frame.setVisible(false);
				
				
				
			}
			
			
			
			
			
		});
		btnNewButton_4.setBounds(414, 466, 105, 21);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Return book");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Return_book r= new Return_book();
				r.frame.setVisible(true); 
				frame.setVisible(false);
			}
		});
		btnNewButton_5.setBounds(557, 466, 105, 21);
		frame.getContentPane().add(btnNewButton_5);
	
		
	}

}
