package packagejdbcDemo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.mysql.cj.protocol.Resultset;
import com.toedter.calendar.JDateChooser;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.SwingConstants;

public class Issue {

	JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Issue window = new Issue();
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
	public Issue() {
		initialize();
	}
	public String date;
	public String rdate;
	private JTable table;
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 626, 443);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("book id");
		lblNewLabel.setBounds(115, 58, 46, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("issue date");
		lblNewLabel_1.setBounds(114, 111, 69, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(239, 55, 96, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(242, 111, 93, 19);
		frame.getContentPane().add(dateChooser);
		
		JButton btnNewButton = new JButton("issue");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if(textField.getText().trim().isEmpty()==false && date!=null )
				{
				try
				{
				Class.forName("com.mysql.cj.jdbc.Driver"); 
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/book","root","root");  
				Statement stmt=con.createStatement();  

				System.out.println("connection established");
	
	
				PreparedStatement ps=con.prepareStatement("update book set issued='Issued' , issued_date=?, return_date=? where book_id=? and issued='not issued'");
				ps.setString(1, date);
				ps.setString(2, rdate);
				ps.setString(3, textField.getText());
				

				int x= ps.executeUpdate();

				if(x > 0)
				{
					System.out.println("book issued successfully");
					JOptionPane.showMessageDialog(null, "book issued successfully","issued",JOptionPane.INFORMATION_MESSAGE);
					
					
					PreparedStatement ps1=con.prepareStatement("select book_id,book_name,issued,issued_date,return_date from book where book_id=?");
					ps1.setString(1, textField.getText());
	                 ResultSet rs= ps1.executeQuery();
	                 table.setModel(DbUtils.resultSetToTableModel(rs));
	                 textField.setText(null);
					dateChooser.setDate(null);
					
					
				}
				else
				{
					System.out.println("Record issuing Failed");
				JOptionPane.showMessageDialog(null, "Check availability again","issued problem",JOptionPane.INFORMATION_MESSAGE);
				}
					}
				catch(Exception e1)
				{
					e1.getStackTrace();
				}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Fields are empty or Frist check avilability and Confirm date","Empty field",JOptionPane.INFORMATION_MESSAGE);
				}
				
				
				
				
			}
		});
		btnNewButton.setBounds(174, 172, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		
		
		JButton btnNewButton_1 = new JButton("confirm");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			SimpleDateFormat df= new SimpleDateFormat("yyyy-MM-dd");
			String date= df.format(dateChooser.getDate());
		//	Date d=new Date();
		//	df.format(d);
			System.out.println(date);
		//	System.out.println(d);
			
			
			date(date);
			rdate(df,date);
			JOptionPane.showMessageDialog(null, "Date Issued","Date Issued",JOptionPane.INFORMATION_MESSAGE);
			
				
			}
		});
		btnNewButton_1.setBounds(348, 113, 136, 21);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Check availability");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				try
				{
				Class.forName("com.mysql.cj.jdbc.Driver"); 
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/book","root","root");  
				Statement stmt=con.createStatement();  

				System.out.println("connection established");

				PreparedStatement ps=con.prepareStatement("select * from book where book_id=? and issued='not issued'");


				ps.setString(1, textField.getText());


                ResultSet x= ps.executeQuery();

               if(x.next())

				{
					System.out.println("Book available");
					JOptionPane.showMessageDialog(null, "Book available","available",JOptionPane.INFORMATION_MESSAGE);

					
				}
				else
				{
					System.out.println("Book not available");
               JOptionPane.showMessageDialog(null, "Book not available","not available",JOptionPane.INFORMATION_MESSAGE);
               textField.setText(null);
           	dateChooser.setDate(null);
					}
				}
				catch(Exception e1)
				{
					e1.getStackTrace();
				}
				
			}
		});
		btnNewButton_2.setBounds(348, 54, 136, 21);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Reset");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				  textField.setText(null);
				dateChooser.setDate(null);
				
			}
		});
		btnNewButton_3.setBounds(324, 172, 85, 21);
		frame.getContentPane().add(btnNewButton_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 203, 612, 203);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"book_id", "book_name", "issued", "issued_date", "return_date"
			}
		));
		
		JLabel lblNewLabel_2 = new JLabel("   Issue Books");
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBackground(new Color(230, 230, 250));
		lblNewLabel_2.setForeground(new Color(0, 0, 128));
		lblNewLabel_2.setFont(new Font("Monotype Corsiva", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_2.setBounds(235, 10, 157, 35);
		frame.getContentPane().add(lblNewLabel_2);
	}

	protected void rdate(SimpleDateFormat df2, String date2) {
		// TODO Auto-generated method stub
		Calendar cal2= Calendar.getInstance();
		
		try {
			Date d=df2.parse(date2);
			cal2.setTime(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		cal2.add(Calendar.MONTH, 1);
		String rdate=df2.format(cal2.getTime());
		this.rdate=rdate;
		System.out.println("return "+rdate);
		
	}


	protected void date(String date2) {
			
		this.date=date2;
		
	}
}



