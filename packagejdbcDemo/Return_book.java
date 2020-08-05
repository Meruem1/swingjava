package packagejdbcDemo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Color;

public class Return_book {

	JFrame frame;
	private JTextField textField;
	private JTable table;
	String rdate;
	String bdate;
	SimpleDateFormat df3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Return_book window = new Return_book();
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
	public Return_book() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 505, 340);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("book id");
		lblNewLabel.setBounds(90, 51, 46, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("return date");
		lblNewLabel_1.setBounds(90, 90, 70, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(205, 48, 96, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
			}
		});
		dateChooser.setBounds(205, 90, 96, 19);
		frame.getContentPane().add(dateChooser);
		
		
		JButton btnNewButton = new JButton("Return ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textField.getText().trim().isEmpty()==false && rdate!=null )
				{			

				try
				{
				Class.forName("com.mysql.cj.jdbc.Driver"); 
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/book","root","root");  
				Statement stmt=con.createStatement();  
				System.out.println("connection established");
				
				PreparedStatement ps7=con.prepareStatement("select * from book where issued='issued' and book_id=?");
				ps7.setString(1, textField.getText());
				
				ResultSet rs7= ps7.executeQuery();
				if(rs7.next())
				{
				
				PreparedStatement ps=con.prepareStatement("update book set issued='not issued' where book_id=?");
				ps.setString(1, textField.getText());
				
                int x= ps.executeUpdate();
				
				if(x > 0)
				{
					
				
				PreparedStatement ps2=con.prepareStatement("select return_date from book where book_id=?");
				ps2.setString(1, textField.getText());
				ResultSet rs2= ps2.executeQuery();
				if(rs2.next())
				{
					String date=rs2.getString("return_date");
					//	System.out.println(date);
						set(date);
						
						System.out.println(bdate);
						System.out.println(rdate);
						
						if(bdate.compareTo(rdate)>0)
						{
							
							PreparedStatement ps6=con.prepareStatement("select book_id,book_name,return_date,fine from book where book_id=?");
							ps6.setString(1, textField.getText());
							

									
							ResultSet rs6= ps6.executeQuery();
							table.setModel(DbUtils.resultSetToTableModel(rs6));
							
							JOptionPane.showMessageDialog(null, "Book Returned successfully","Return successful",JOptionPane.INFORMATION_MESSAGE);
						}
						else if(bdate.compareTo(rdate)==0)
							
							
						{
							PreparedStatement ps5=con.prepareStatement("select book_id,book_name,return_date,fine from book where book_id=?");
							ps5.setString(1, textField.getText());
							

									
							ResultSet rs5= ps5.executeQuery();
							table.setModel(DbUtils.resultSetToTableModel(rs5));
							
							
							
							JOptionPane.showMessageDialog(null, "Book Returned successfully","Return successful",JOptionPane.INFORMATION_MESSAGE);
						}
						else if(bdate.compareTo(rdate)<0)
						{
							try {
							Date first= df3.parse(rdate);
							Date second= df3.parse(bdate);
							long daytime=first.getTime()-second.getTime();
							float days=(daytime/(1000*60*60*24));
							
		
							System.out.println(days);
							
							
                            JOptionPane.showMessageDialog(null, "you are late by"+days+"days","Fine",JOptionPane.INFORMATION_MESSAGE);
							
							float fine =days*5;
							System.out.println(fine);
							

						PreparedStatement ps4=con.prepareStatement("update book set fine='"+fine+"' where book_id=?");
						ps4.setString(1, textField.getText());
						int x1= ps4.executeUpdate();
						
						if(x1>0)
						{
						
						PreparedStatement ps1=con.prepareStatement("select book_id,book_name,return_date,fine from book where book_id=?");
						ps1.setString(1, textField.getText());
						

								
						ResultSet rs= ps1.executeQuery();
						
						table.setModel(DbUtils.resultSetToTableModel(rs));
						
						PreparedStatement ps8=con.prepareStatement("update book set return_date='NULL',issued_date='NULL' where book_id=?");
						ps8.setString(1, textField.getText());
						int x8= ps8.executeUpdate();
						
						if(x8>0)
						{
						
						
						JOptionPane.showMessageDialog(null, "Book Returned successfully","Return successful",JOptionPane.INFORMATION_MESSAGE);
						
						textField.setText(null);
						dateChooser.setDate(null);
						}
						}
						
							}
						
							catch(Exception ex)
							{
								System.out.println(ex);
							}
							
							
							
						}
							
							
							
						}
						
				

				}
				}
				else {
				
				JOptionPane.showMessageDialog(null, "Book is not issued","Book is not issued",JOptionPane.ERROR_MESSAGE);
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
		btnNewButton.setBounds(216, 138, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		
		JButton btnNewButton_1 = new JButton("confirm");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				SimpleDateFormat df= new SimpleDateFormat("yyyy-MM-dd");
				String date= df.format(dateChooser.getDate());
				date(date);
				format(df);
				
				 JOptionPane.showMessageDialog(null, "Date selected","date selected",JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		btnNewButton_1.setBounds(325, 86, 85, 21);
		frame.getContentPane().add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 176, 491, 127);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"book_id", "book_name", "return_date", "fine"
			}
		));
		
		JLabel lblNewLabel_2 = new JLabel("   Return Book");
		lblNewLabel_2.setForeground(new Color(0, 0, 128));
		lblNewLabel_2.setBackground(new Color(230, 230, 250));
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setFont(new Font("Monotype Corsiva", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_2.setBounds(171, 10, 173, 28);
		frame.getContentPane().add(lblNewLabel_2);
	}
	

	protected void date(String date2) {
			
		this.rdate=date2;
		
		
	}
	private void set(String date) {
		this.bdate=date;
		
	}
	public void format(SimpleDateFormat df2)
	{
		this.df3=df2;
	}
}









