package CTA2;
import javax.swing.*; 
import java.awt.*;
import java.awt.event.*; 
import java.util.List; 
import java.util.*; 



public class GUI {
	static JLabel firstNameLbl = new JLabel("First Name:"); 
	static JLabel lastNameLbl = new JLabel("Last Name:"); 
	static JTextField firstNameTxt = new JTextField(); 
	static JTextField lastNameTxt = new JTextField(); 
	static JButton signUpBtn = new JButton("Sign Up");  
	static JButton closeBtn = new JButton("Cancel");
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub\
		
		//Create Initial Window Frame
		JFrame appFrame = new JFrame(); 
		GridBagLayout layout = new GridBagLayout(); 
		appFrame.setLayout(layout);
		appFrame.setSize(800,500);
		appFrame.setTitle("Create Account");
		appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		appFrame.setVisible(true);
		appFrame.setLocationRelativeTo(null);
		
		//Create Account window Frame
		JFrame accountFrame = new JFrame(); 
		GridBagLayout layout2 = new GridBagLayout(); 
		accountFrame.setLayout(layout2);
		accountFrame.setSize(1000,700);
		accountFrame.setTitle("Bank Account");
		accountFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		accountFrame.setVisible(false);
		
		//Create header panel and body panel for greeting
		JPanel header = new JPanel(); 
		JPanel accntCreatePnl = new JPanel(new GridBagLayout()); 
		
		GridBagConstraints headerConfig = new GridBagConstraints(); 
		headerConfig.gridx = 0; 
		headerConfig.gridy = 0; 
		headerConfig.fill = GridBagConstraints.HORIZONTAL; 
		headerConfig.weightx = 1.0; 
		headerConfig.insets = new Insets(10,10,10,10); 
		//Creating greeting label
		JLabel greeting = new JLabel("Welcome please enter your information below to create an account:"); 
		header.add(greeting); 
		appFrame.add(header, headerConfig); 
		
		//Create 2nd Panel for body 
		GridBagConstraints accntCreateConfig = new GridBagConstraints(); 
		accntCreateConfig.gridx = 0; 
		accntCreateConfig.gridy = 1; 
		accntCreateConfig.fill = GridBagConstraints.HORIZONTAL; 
		accntCreateConfig.weightx = 1.0; 
		accntCreateConfig.insets = new Insets(10,10,10,10); 
		appFrame.add(accntCreatePnl, accntCreateConfig);
		
		//Add labels to body panel
		GridBagConstraints firstNamePos = new GridBagConstraints(); 
		firstNamePos.gridx = 0; 
		firstNamePos.gridy = 0; 
		firstNamePos.anchor = GridBagConstraints.EAST; 
		firstNamePos.weightx = 1.0; 
		firstNamePos.insets = new Insets(10,0,10,10); 
		accntCreatePnl.add(firstNameLbl, firstNamePos); 
		
		GridBagConstraints lastNamePos = new GridBagConstraints(); 
		lastNamePos.gridx = 0; 
		lastNamePos.gridy = 1; 
		lastNamePos.anchor = GridBagConstraints.EAST;  
		lastNamePos.weightx = 1.0; 
		lastNamePos.insets = new Insets(10,0,10,10); 
		accntCreatePnl.add(lastNameLbl, lastNamePos); 
		
		GridBagConstraints firstNameField = new GridBagConstraints(); 
		firstNameTxt.setEditable(true);
		firstNameField.gridx = 1; 
		firstNameField.gridy = 0; 
		firstNameField.fill = GridBagConstraints.HORIZONTAL; 
		firstNameField.weightx = 1.0; 
		firstNameField.insets = new Insets(10,10,10,0); 
		accntCreatePnl.add(firstNameTxt, firstNameField); 
		
		GridBagConstraints lastNameField = new GridBagConstraints(); 
		lastNameTxt.setEditable(true);
		lastNameField.gridx = 1; 
		lastNameField.gridy = 1; 
		lastNameField.fill = GridBagConstraints.HORIZONTAL; 
		lastNameField.weightx = 1.0; 
		lastNameField.insets = new Insets(10,10,10,0); 
		accntCreatePnl.add(lastNameTxt, lastNameField); 
		
		
		//Define Snap button position and event handler
		GridBagConstraints signUpPos = new GridBagConstraints(); 
		signUpBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String firstName = firstNameTxt.getText();
				String lastName = lastNameTxt.getText(); 
				appFrame.dispose(); 
				checkingAccount obj = new checkingAccount(firstName,lastName); 
				obj.displayAccount();
				accountSummaryGUI start = new accountSummaryGUI(firstName,lastName,obj.accountID,obj.balance,obj.interest);
				

			}
			
		});
		signUpPos.gridx = 0; 
		signUpPos.gridy = 2; 
		signUpPos.anchor = GridBagConstraints.EAST;  
		signUpPos.weightx = 1.0; 
		signUpPos.insets = new Insets(10,10,10,10); 
		accntCreatePnl.add(signUpBtn, signUpPos); 
		
		
		//Define close button position and event handler
		GridBagConstraints closePos = new GridBagConstraints(); 
		closeBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				appFrame.dispose(); 
				
			}
			
		}); 
		closePos.gridx = 1; 
		closePos.gridy = 2; 
		closePos.anchor = GridBagConstraints.WEST;  
		closePos.weightx = 1.0; 
		closePos.insets = new Insets(10,10,10,10); 
		accntCreatePnl.add(closeBtn, closePos); 
		
		appFrame.pack(); 
	}

}
