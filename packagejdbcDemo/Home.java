
package packagejdbcDemo;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import java.util.Random;

public class Home {

	 JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
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
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 547, 362);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		

		/* ImageIcon icon= new ImageIcon("images2.jpg"); */
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon(Home.class.getResource("/images.png")));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(160, 60, 207, 159);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				Registration r =new Registration();
				r.Regframe.setVisible(true);
				frame.setVisible(false);
			}
			
		});
		btnNewButton_1.setForeground(new Color(128, 0, 0));
		btnNewButton_1.setBounds(61, 237, 85, 21);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Login");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				Login l =new Login();
				l.frmLogin.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnNewButton_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton_2.setForeground(new Color(128, 0, 0));
		btnNewButton_2.setBounds(182, 275, 108, 21);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton(" Quotes");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s0="There are some fight worth fighting for your life is one of them.";
				String s1="It might be raining but there is rainbow above you";
				String s2="If mesmarizing had face";
				String s3="Beauty is not in the face, but is a kight in heart ";
				String s4="Once you make choice,make yourself choicel-less";
				String s5="Take risks,you might discover something beautiful";
				String s6="you can fail at what you dont love,so you might as well do what you love";
				String s7="One is loved because one is loved,no reason needed for loving someone";
				String s8="Happiness is not destination,it's the path";
				String s9="We suffer more in our imagination than in reality";
			
				
				
				
				String q  =quote();
			
				
				if(q.equals("0"))
				{
				JOptionPane.showMessageDialog(null, s0,"Quotes",JOptionPane.INFORMATION_MESSAGE);
				}
				
				System.out.println(q);
				if(q.equals("1"))
				{
				JOptionPane.showMessageDialog(null, s1,"Quotes",JOptionPane.INFORMATION_MESSAGE);
				}
				if(q.equals("2"))
				{
				JOptionPane.showMessageDialog(null, s2,"Quotes",JOptionPane.INFORMATION_MESSAGE);
				}
				if(q.equals("3"))
				{
				JOptionPane.showMessageDialog(null, s3,"Quotes",JOptionPane.INFORMATION_MESSAGE);
				}
				if(q.equals("4"))
				{
				JOptionPane.showMessageDialog(null, s4,"Quotes",JOptionPane.INFORMATION_MESSAGE);
				}
				if(q.equals("5"))
				{
				JOptionPane.showMessageDialog(null, s5,"Quotes",JOptionPane.INFORMATION_MESSAGE);
				}
				if(q.equals("6"))
				{
				JOptionPane.showMessageDialog(null, s6,"Quotes",JOptionPane.INFORMATION_MESSAGE);
				}
				if(q.equals("7"))
				{
				JOptionPane.showMessageDialog(null, s7,"Quotes",JOptionPane.INFORMATION_MESSAGE);
				}
				if(q.equals("8"))
				{
				JOptionPane.showMessageDialog(null, s8,"Quotes",JOptionPane.INFORMATION_MESSAGE);
				}
				if(q.equals("9"))
				{
				JOptionPane.showMessageDialog(null, s9,"Quotes",JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		btnNewButton_3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton_3.setForeground(new Color(128, 0, 0));
		btnNewButton_3.setBounds(348, 247, 85, 21);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Contact us");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, "contact vishal suryawanshi at vishalsuryawanshi633@gmail.com","Contact us",JOptionPane.INFORMATION_MESSAGE);
				
				
				
			}
		});
		btnNewButton_4.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton_4.setForeground(new Color(128, 0, 0));
		btnNewButton_4.setBounds(397, 182, 108, 21);
		frame.getContentPane().add(btnNewButton_4);
		
		JLabel lblNewLabel_1 = new JLabel("Welcome Reader");
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1.setBackground(new Color(230, 230, 250));
		lblNewLabel_1.setFont(new Font("Monotype Corsiva", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_1.setBounds(182, 10, 168, 39);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Home h= new Home();
				h.frame.setVisible(false);
			}
		});
		btnNewButton.setForeground(new Color(128, 0, 0));
		btnNewButton.setBounds(39, 172, 85, 21);
		frame.getContentPane().add(btnNewButton);
	}
	
	
	public static String quote() {
		int randomPin   =(int)(Math.random()*9);
		String otp  =String.valueOf(randomPin);
		return otp;
	
	}	
}

