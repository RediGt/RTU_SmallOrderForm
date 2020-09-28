package pac;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Win {

	private JFrame frame;
	private JTextField tFieldName;
	private JTextField tFieldPhone;
	private JTextField tFieldDateTime;
	private JTextField tFieldResult;
	private JButton btnInsert;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Win window = new Win();
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
	public Win() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		File01 customerObj = new File01();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("V\u0101rds");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName.setBounds(10, 10, 111, 31);
		frame.getContentPane().add(lblName);
		
		JLabel lblPhone = new JLabel("T\u0101lrunis");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPhone.setBounds(10, 51, 111, 31);
		frame.getContentPane().add(lblPhone);
		
		JLabel lblDateTime = new JLabel("Datums un laiks");
		lblDateTime.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDateTime.setBounds(10, 92, 158, 31);
		frame.getContentPane().add(lblDateTime);
		
		JLabel lblPurpose = new JLabel("Viz\u012Btes m\u0113r\u0137is");
		lblPurpose.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPurpose.setBounds(10, 133, 158, 31);
		frame.getContentPane().add(lblPurpose);
		
		tFieldName = new JTextField();
		tFieldName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tFieldName.setBounds(184, 14, 242, 31);
		frame.getContentPane().add(tFieldName);
		tFieldName.setColumns(10);
		
		tFieldPhone = new JTextField();
		tFieldPhone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tFieldPhone.setColumns(10);
		tFieldPhone.setBounds(184, 51, 242, 31);
		frame.getContentPane().add(tFieldPhone);
		
		tFieldDateTime = new JTextField();
		tFieldDateTime.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tFieldDateTime.setColumns(10);
		tFieldDateTime.setBounds(184, 92, 242, 31);
		frame.getContentPane().add(tFieldDateTime);
		
		tFieldResult = new JTextField();
		tFieldResult.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tFieldResult.setColumns(10);
		tFieldResult.setBounds(10, 222, 416, 31);
		frame.getContentPane().add(tFieldResult);
		
		JComboBox comboPurpose = new JComboBox(customerObj.visitPurpose);
		comboPurpose.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboPurpose.setBounds(184, 133, 242, 30);
		frame.getContentPane().add(comboPurpose);
		
		btnInsert = new JButton("Iesniegt");
		btnInsert.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String registryResult = customerObj.registry(tFieldName.getText(),
						tFieldPhone.getText(), tFieldDateTime.getText(), 
						String.valueOf(comboPurpose.getSelectedItem()));
				
				if (registryResult.equals("Your registratuin successfully saved!")) 
				{
					tFieldResult.setText(registryResult);
				} 
				else 
					JOptionPane.showMessageDialog(null, "The phone number is of a wrong format!", 
						"Error", JOptionPane.ERROR_MESSAGE);
			}
		});
		btnInsert.setBounds(184, 173, 242, 39);
		frame.getContentPane().add(btnInsert);
	}
}
