package CTA2;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class popupWindow {
	static JLabel header = new JLabel(); 
	static JLabel amountLbl = new JLabel("Amount"); 
	static JTextField amountTxt = new JTextField(); 
	static JButton confirm = new JButton("Confirm"); 
	static JButton cancel = new JButton("Cancel"); 
	
	public popupWindow(String state) {
		JFrame popupFrame = new JFrame(); 
		GridBagLayout l = new GridBagLayout(); 
		popupFrame.setLayout(l);
		popupFrame.setSize(1000,700);
		popupFrame.setTitle("How Much?");
		popupFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		popupFrame.setVisible(true);
		popupFrame.setLocationRelativeTo(null);
		
		JPanel popupPanel = new JPanel(new GridBagLayout()); 
		popupFrame.setContentPane(popupPanel);
		
		switch(state) {
		case "withdraw": 
			header.setText("How much would you like to withdraw?"); 
			break; 
		case "deposit":
			header.setText("How much would you like to deposit?");
			break; 
		};
		
		
		GridBagConstraints f = new GridBagConstraints(); 
		f.gridx = 0; 
		f.gridy = 0; 
		f.anchor = GridBagConstraints.CENTER; 
		f.weightx = 3.0; 
		f.weighty = 1.0; 
		popupPanel.add(header,f);
		
		f.gridx = 0; 
		f.gridy = 1; 
		f.anchor = GridBagConstraints.CENTER; 
		f.weightx = 3.0; 
		f.weighty = 1.0; 
		popupPanel.add(amountLbl,f);
		
		amountTxt.setEditable(true);
		amountTxt.setPreferredSize(new Dimension(400,30));
		f.gridx = 1; 
		f.gridy = 1; 
		f.anchor = GridBagConstraints.CENTER; 
		f.fill = GridBagConstraints.HORIZONTAL; 
		f.weightx = 3.0; 
		f.weighty = 1.0; 
		popupPanel.add(amountTxt,f);
		
		confirm.setPreferredSize(new Dimension(200,30));
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch(state) {
				case "withdraw":
					//get User input value 
					double text = Double.parseDouble(amountTxt.getText());
					//get current balance value
					double num = Double.parseDouble(accountSummaryGUI.balanceTxt.getText());
					//update value 
					if(num-text < 0) {
						JOptionPane.showMessageDialog(null, "Your withdrawal has triggered an overdraft. 30$ fee will be charged to your balance.", "Alert", JOptionPane.INFORMATION_MESSAGE);
						String updatedVal = String.valueOf(num-text-30); 
						//update balance on GUI
						accountSummaryGUI.updateTextField(updatedVal,accountSummaryGUI.balanceTxt); 
					} else {
						String updatedVal = String.valueOf(num-text); 
						//update balance on GUI
						accountSummaryGUI.updateTextField(updatedVal,accountSummaryGUI.balanceTxt); 
					};
					//close frame
					popupFrame.setVisible(false);
					confirm.removeActionListener(this);
					return; 
				case "deposit":
					double text2 =Double.parseDouble(amountTxt.getText()); 
					//get current balance value
					double num2 = Double.parseDouble(accountSummaryGUI.balanceTxt.getText());
					//update value 
					String updatedVal2 = String.valueOf(num2+text2); 
					//update balance on GUI
					accountSummaryGUI.updateTextField(updatedVal2,accountSummaryGUI.balanceTxt); 
					//close frame
					popupFrame.setVisible(false);
					confirm.removeActionListener(this);
					return; 
				}
			}
		}); 
		f.gridx = 0; 
		f.gridy = 2; 
		f.anchor = GridBagConstraints.EAST; 
		f.weightx = 3.0; 
		f.weighty = 1.0; 
		popupPanel.add(confirm,f);
		
		cancel.setPreferredSize(new Dimension(200,30));
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				popupFrame.dispose(); 
			}
		}); 
		f.gridx = 1; 
		f.gridy = 2; 
		f.anchor = GridBagConstraints.WEST; 
		f.weightx = 3.0; 
		f.weighty = 1.0; 
		popupPanel.add(cancel,f);
		
		popupFrame.pack(); 
	}
	

}; 
