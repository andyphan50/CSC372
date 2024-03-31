package CTA2;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerModel;

public class accountSummaryGUI {
	static JLabel accountHeaderLbl = new JLabel("Account Summary"); 
	static JLabel userLbl = new JLabel("User:"); 
	static JLabel accountIDLbl = new JLabel("Account ID:"); 
	static JLabel balanceLbl = new JLabel("Current Balance: "); 
	static JLabel rateLbl = new JLabel("Interest rate: "); 
	static JLabel userTxt = new JLabel(); 
	static JLabel accountIDTxt = new JLabel(); 
	static JLabel balanceTxt = new JLabel(); 
	static JLabel rateTxt = new JLabel(); 
	static JButton withdrawBtn = new JButton("Withdraw"); 
	static JButton depositBtn = new JButton("Deposit"); 
	static JButton closeBtn = new JButton("Close"); 
	Dimension buttonSize = new Dimension(180,30); 
	
	public static void updateTextField(String text, JLabel label) {
		label.setText(text);
	}
	
	public accountSummaryGUI(String firstName,String lastName,int ID,double balance,double rate) {
		//Create Account window Frame
				JFrame accountFrame = new JFrame(); 
				GridBagLayout layout2 = new GridBagLayout(); 
				accountFrame.setLayout(layout2);
				accountFrame.setSize(1000,700);
				accountFrame.setTitle("Bank Account");
				accountFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				accountFrame.setVisible(true);
				accountFrame.setLocationRelativeTo(null);
				
		//Create JPanel for account summary
				JPanel accountPanel = new JPanel(new GridBagLayout()); 
				accountFrame.setContentPane(accountPanel); 
				
				GridBagConstraints c = new GridBagConstraints(); 
				Font font = new Font("Arial", Font.BOLD, 24); 
				accountHeaderLbl.setFont(font);
				c.gridx = 0; 
				c.gridy = 0; 
				c.anchor = GridBagConstraints.CENTER; 
				c.weightx = 3.0; 
				c.weighty = 1.0; 
				accountPanel.add(accountHeaderLbl,c);
			
				
				c.gridx = 0; 
				c.gridy = 1; 
				c.anchor = GridBagConstraints.WEST; 
				c.weightx = 1.0; 
				c.weighty = 1.0; 
				c.insets = new Insets(10,10,10,10);
				accountPanel.add(userLbl,c);
				
				
				String fullName = firstName + ' ' + lastName; 
				userTxt.setText(fullName);
				c.gridx = 1; 
				c.gridy = 1; 
				c.anchor = GridBagConstraints.WEST; 
				c.weightx = 1.0; 
				c.weighty = 1.0; 
				c.insets = new Insets(10,10,10,10);
				accountPanel.add(userTxt,c);
				
				
				c.gridx = 0; 
				c.gridy = 2; 
				c.anchor = GridBagConstraints.WEST; 
				c.weightx = 1.0; 
				c.weighty = 1.0; 
				c.insets = new Insets(10,10,10,10);
				accountPanel.add(accountIDLbl,c);
				

				accountIDTxt.setText(String.valueOf(ID));
				c.gridx = 1; 
				c.gridy = 2; 
				c.anchor = GridBagConstraints.WEST; 
				c.weightx = 1.0;
				c.weighty = 1.0; 
				c.insets = new Insets(10,10,10,10);
				accountPanel.add(accountIDTxt,c);
				
				
				c.gridx = 0; 
				c.gridy = 3; 
				c.anchor = GridBagConstraints.WEST; 
				c.weightx = 1.0; 
				c.weighty = 1.0; 
				c.insets = new Insets(10,10,10,10);
				accountPanel.add(balanceLbl,c);
				
				 
				balanceTxt.setText(String.valueOf(balance));
				c.gridx = 1; 
				c.gridy = 3; 
				c.anchor = GridBagConstraints.WEST; 
				c.weightx = 1.0; 
				c.weighty = 1.0; 
				c.insets = new Insets(10,10,10,10);
				accountPanel.add(balanceTxt,c);
				
				
				c.gridx = 0; 
				c.gridy = 4; 
				c.anchor = GridBagConstraints.WEST; 
				c.weightx = 1.0; 
				c.weighty = 1.0; 
				c.insets = new Insets(10,10,10,10);
				accountPanel.add(rateLbl,c);
				
				String rateFullText = String.valueOf(rate)+"%"; 
				rateTxt.setText(rateFullText);
				c.gridx = 1; 
				c.gridy = 4; 
				c.anchor = GridBagConstraints.WEST; 
				c.weightx = 1.0; 
				c.weighty = 1.0; 
				c.insets = new Insets(10,10,10,10);
				accountPanel.add(rateTxt,c);
				
	
				JLabel askUserLbl = new JLabel("What would you like to do?"); 
				c.gridx = 0; 
				c.gridy = 5; 
				c.anchor = GridBagConstraints.CENTER; 
				c.fill = GridBagConstraints.HORIZONTAL; 
				c.weightx = 4.0; 
				c.weighty = 1.0; 
				c.insets = new Insets(10,10,30,10);
				accountPanel.add(askUserLbl,c);
				
				
				withdrawBtn.setPreferredSize(buttonSize);
				withdrawBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						popupWindow obj = new popupWindow("withdraw"); 
					}
				});
				c.gridx = 0; 
				c.gridy = 6; 
				c.anchor = GridBagConstraints.CENTER; 
				c.fill = GridBagConstraints.HORIZONTAL; 
				c.weightx = 1.0; 
				c.weighty = 1.0; 
				c.insets = new Insets(10,10,10,10);
				accountPanel.add(withdrawBtn,c);
				
				depositBtn.setPreferredSize(buttonSize);
				depositBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						popupWindow obj = new popupWindow("deposit");
					}
				});
				c.gridx = 1; 
				c.gridy = 6; 
				c.anchor = GridBagConstraints.CENTER; 
				c.fill = GridBagConstraints.HORIZONTAL; 
				c.weightx = 1.0; 
				c.weighty = 1.0; 
				c.insets = new Insets(10,10,10,10);
				accountPanel.add(depositBtn,c);
				
				closeBtn.setPreferredSize(buttonSize);
				closeBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						accountFrame.dispose(); 
					}
				});
				c.gridx = 2; 
				c.gridy = 6; 
				c.anchor = GridBagConstraints.CENTER; 
				c.fill = GridBagConstraints.HORIZONTAL; 
				c.weightx = 1.0; 
				c.weighty = 1.0; 
				c.insets = new Insets(10,10,10,10);
				accountPanel.add(closeBtn,c);
				
				accountFrame.pack(); 
	}

}
