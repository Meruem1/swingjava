package packagejdbcDemo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import com.teknikindustries.bulksms.SMS;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Sms2 {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sms2 window = new Sms2();
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
	public Sms2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(245, 39, 96, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(245, 86, 96, 19);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(245, 139, 96, 19);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(245, 193, 96, 19);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username =  textField.getText();
				String password =  textField_1.getText();
				String message =  textField_2.getText();
				String numbers =  textField_3.getText();
				
				
				
				SMS sms=new SMS();
				sms.SendSMS("vishal1235", "Vishal1235", "hello" ,"918286801353", "https://bulksms.vsms.net/eapi/submission/send_sms/2/2.02");
			}
		});
		btnNewButton.setBounds(66, 192, 85, 21);
		frame.getContentPane().add(btnNewButton);
	}

}
