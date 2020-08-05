package packagejdbcDemo;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
 
public class sms {

	private JFrame frame;
	private JTextField textField;
	private static JTextField textField_1;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sms window = new sms();
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
	public sms() {
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
		textField.setBounds(228, 44, 96, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(228, 95, 96, 19);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(228, 139, 96, 19);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(215, 188, 85, 21);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					// Construct data
					String apiKey = "apikey=" + textField.getText();
					String message = "&message=" +textField_1.getText();
				//	String sender = "&sender=" + textField_2.getText();
					String numbers = "&numbers=" +textField_3.getText();
					
					// Send data
					HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
					String data = apiKey + message + numbers ;
					conn.setDoOutput(true);
					conn.setRequestMethod("POST");
					conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
					conn.getOutputStream().write(data.getBytes("UTF-8"));
					final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
					final StringBuffer stringBuffer = new StringBuffer();
					String line;
					while ((line = rd.readLine()) != null) {
						//stringBuffer.append(line);
					
						
						JOptionPane.showMessageDialog(null, "message"+line);
					}
					rd.close();
					
					//return stringBuffer.toString();
				} catch (Exception ex) {
					//System.out.println("Error SMS "+e);
					JOptionPane.showMessageDialog(null, ex);
				//	return "Error "+e;
				}

			}
		});
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("api");
		lblNewLabel.setBounds(98, 47, 46, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("message");
		lblNewLabel_1.setBounds(98, 98, 80, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("number");
		lblNewLabel_3.setBounds(98, 142, 46, 13);
		frame.getContentPane().add(lblNewLabel_3);
		
		JButton gen = new JButton("generate");
		gen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					int randomPin   =(int)(Math.random()*9000)+1000;
					String otp  =String.valueOf(randomPin);
					textField_1.setText("your otp is"+otp);
					String message = "&message=" + textField_1.getText();
					gen.setVisible(true);
					
					//return otp;
				
			}
		});
		gen.setBounds(93, 188, 85, 21);
		frame.getContentPane().add(gen);
	}



}
