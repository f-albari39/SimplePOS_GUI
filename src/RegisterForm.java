import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

public class RegisterForm extends JInternalFrame implements MouseListener{
	
	private JPanel 	
		pnlMid 		= new JPanel()	, 
		pnlTop 		= new JPanel()	, 
		pnlBot 		= new JPanel()	,
		pnlBotIn	= new JPanel()	,
		pnlMidIn	= new JPanel()	;
	private JLabel 	
		lbRegister 	= new JLabel()	,
		lbEmail		= new JLabel()	,
		lbPassword 	= new JLabel()	,
		lbAddress	= new JLabel() 	,
		lbDOB		= new JLabel() 	,
		lbGender	= new JLabel() 	,
		lbPhone		= new JLabel()	,
		lbDumb;
	private JTextField
		tfEmail 	= new JTextField(),
		tfPhone		= new JTextField();
	private JPasswordField
		pfPassword	= new JPasswordField();
	private JRadioButton
		rbMale		= new JRadioButton(),
		rbFemale	= new JRadioButton();
	private ButtonGroup 
		bgGender 	= new ButtonGroup();
	private JSpinner
		spDOB		= new JSpinner();
	private JButton 
		btnRegister = new JButton("Register")	;
	private JTextArea
		taAddress	= new JTextArea();
	
	private Color 	
		utama 		= new Color(102,102,102),
		pink 		= new Color(255,204,204);
	
	SimpleDateFormat ddmmyy = new SimpleDateFormat("dd-MMMMM-yy");
	
	private String address, email, password, phone, DOB, gender, role;
	
	public void field(){
		taAddress.setBackground(utama);
		taAddress.setForeground(pink);
		taAddress.setCaretColor(pink);
		taAddress.setBorder(javax.swing.BorderFactory.createLineBorder(utama, 5));
		taAddress.setFont(new java.awt.Font("Segoe UI", 0, 16));
	
		tfEmail.setBackground(utama);
		tfEmail.setForeground(pink);
		tfEmail.setCaretColor(pink);
		tfEmail.setBorder(javax.swing.BorderFactory.createLineBorder(utama, 5));
		tfEmail.setFont(new java.awt.Font("Segoe UI", 0, 16));
		
		tfPhone.setBackground(utama);
		tfPhone.setForeground(pink);
		tfPhone.setCaretColor(pink);
		tfPhone.setBorder(javax.swing.BorderFactory.createLineBorder(utama, 5));
		tfPhone.setFont(new java.awt.Font("Segoe UI", 0, 16));
		
		pfPassword.setBackground(utama);
		pfPassword.setForeground(pink);
		pfPassword.setCaretColor(pink);
		pfPassword.setBorder(javax.swing.BorderFactory.createLineBorder(utama, 5));
		pfPassword.setFont(new java.awt.Font("Segoe UI", 0, 16));
	}
	
	public void lbl(){
		lbAddress.setText("Address");
		lbAddress.setForeground(utama);
		lbAddress.setFont(new java.awt.Font("Segoe UI", 0, 16));
		
		lbDOB.setText("DOB");
		lbDOB.setForeground(utama);
		lbDOB.setFont(new java.awt.Font("Segoe UI", 0, 16));
		
		lbEmail.setText("Email");
		lbEmail.setForeground(utama);
		lbEmail.setFont(new java.awt.Font("Segoe UI", 0, 16));
		
		lbGender.setText("Gender");
		lbGender.setForeground(utama);
		lbGender.setFont(new java.awt.Font("Segoe UI", 0, 16));
		
		lbPassword.setText("Password");
		lbPassword.setForeground(utama);
		lbPassword.setFont(new java.awt.Font("Segoe UI", 0, 16));
		
		lbPhone.setText("Phone");
		lbPhone.setForeground(utama);
		lbPhone.setFont(new java.awt.Font("Segoe UI", 0, 16));
		
		lbRegister.setText("Register");
		lbRegister.setForeground(utama);
		lbRegister.setFont(new java.awt.Font("Segoe UI", 0, 24));
		
	}
	
	public void rb(){
		bgGender.add(rbFemale);
		bgGender.add(rbMale);
		
		rbFemale.setText("Female");
		rbFemale.setBackground(Color.white);
		rbFemale.setForeground(utama);
		rbFemale.setFont(new java.awt.Font("Segoe UI", 0, 18));
		rbFemale.setFocusPainted(false);
		
		rbMale.setText("Male");
		rbMale.setBackground(Color.white);
		rbMale.setForeground(utama);
		rbMale.setFont(new java.awt.Font("Segoe UI", 0, 18));
		rbMale.setFocusPainted(false);
	}
	
	public void btnRegister(){
		btnRegister.setBorderPainted(false);
		btnRegister.setFocusPainted(false);
		btnRegister.setForeground(pink);
		btnRegister.setFont(new java.awt.Font("Segoe UI", 1, 18));
		btnRegister.setContentAreaFilled(false);
		btnRegister.addMouseListener(this);
	}
		
	public void pnlMid(){
		Calendar calendar = new GregorianCalendar(2000, 10, 10);
		
		spDOB.setModel(new SpinnerDateModel());
		spDOB.setBackground(utama);
		spDOB.setForeground(pink);
		spDOB.setValue(calendar.getTime());
		spDOB.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		spDOB.setEditor(new JSpinner.DateEditor(spDOB, "dd - MMM - yyyy"));
		spDOB.getEditor().getComponent(0).setBackground(utama);
		spDOB.getEditor().getComponent(0).setForeground(pink);
		
		pnlMid.setBackground(Color.white);
		pnlMid.setLayout(new GridLayout(6,2,10,10));
		pnlMid.setBorder(javax.swing.BorderFactory.createLineBorder(Color.white, 10));
		
		pnlMid.add(lbEmail);
		pnlMid.add(tfEmail);
		pnlMid.add(lbPassword);
		pnlMid.add(pfPassword);
		pnlMid.add(lbPhone);
		pnlMid.add(tfPhone);
		pnlMid.add(lbDOB);
		pnlMid.add(spDOB);
		pnlMid.add(lbGender);
		pnlMid.add(pnlMidIn);
		pnlMid.add(lbAddress);
		pnlMid.add(taAddress);
	}
	
	public void pnlMidIn(){
		pnlMidIn.setBackground(Color.white);
		pnlMidIn.setLayout(new FlowLayout());
		pnlMidIn.add(rbMale);
		pnlMidIn.add(rbFemale);
		
	}
	
	public void pnlBotIn(){
		pnlBotIn.setLayout(new FlowLayout());
		pnlBotIn.setBackground(utama);
		btnRegister();
		pnlBotIn.add(btnRegister);
		pnlBotIn.addMouseListener(this);
	}
	
	public void pnlBot(){
		pnlBot.setBackground(Color.white);
		pnlBot.setLayout(new FlowLayout());
		pnlBot.setBorder(javax.swing.BorderFactory.createLineBorder(Color.white, 10));
		pnlBotIn();
		pnlBot.add(pnlBotIn);
	}
	
	public void pnlTop(){
		pnlTop.setLayout(new FlowLayout());
		pnlTop.setBackground(Color.white);
		pnlTop.setBorder(javax.swing.BorderFactory.createLineBorder(Color.white, 10));
		pnlTop.add(lbRegister);
	}
	
	public RegisterForm() {
		setTitle("Register");
		setVisible(true);
		setClosable(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setPreferredSize(new java.awt.Dimension(360, 440));
		setLayout(new BorderLayout());
		setBorder(javax.swing.BorderFactory.createLineBorder(utama, 5));
		
		field();
		rb();
		lbl();
		pnlTop();
		pnlBot();
		pnlMid();
		pnlMidIn();
		
		add(pnlTop, BorderLayout.NORTH);
		add(pnlMid, BorderLayout.CENTER);
		add(pnlBot, BorderLayout.SOUTH);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		btnRegister.setForeground(pink);
		pnlBotIn.setBackground(utama);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		DataBase DB = new DataBase();
		
		btnRegister.setForeground(utama);
		pnlBotIn.setBackground(pink);
		
		email = tfEmail.getText();
		password = pfPassword.getText();
		DOB = "";
		phone = tfPhone.getText();
		address = taAddress.getText();
		gender = "";
		
		
		int count = email.length() - email.replace("@", "").length();
		
		int v = 0,x = 0, y= 0, z= 0;
		for (int i = 0; i < password.length(); i++) {
			char p = password.charAt(i);
			if(Character.isDigit(p)){
				x++;
			}else if(Character.isLetter(p)){
				y++;
			}else{
				z++;
			}
		}
		
		for (int i = 0; i < phone.length(); i++) {
			char p = phone.charAt(i);
			if (!Character.isDigit(p)) {
				v++;
			}
		}
		
		if (	tfEmail.getText().equals("") || tfPhone.getText().equals("") ||
				taAddress.getText().equals("") || pfPassword.getText().equals("") ||
				(!rbFemale.isSelected() && !rbMale.isSelected()) ){
			JOptionPane.showMessageDialog(this, "All field must be filled", "Data is not completed", 2);
		}else if(!email.contains(".") && !email.contains("@")){
			JOptionPane.showMessageDialog(this, "Email must be containing '@' and '.'",
					"Format is not completed", 2);
		}else if(count > 1){
			JOptionPane.showMessageDialog(this, "Email must be containing only one '@'",
					"Format is not completed", 2);
		}else if (email.startsWith("@") || email.startsWith(".") || 
					email.endsWith("@") || email.endsWith(".")) {
			JOptionPane.showMessageDialog(this, "Email can not be started or ended with '@' or '.'",
					"Format is not completed", 2);
		}else if (password.length() < 6 || password.length() > 12) {
			JOptionPane.showMessageDialog(this, "Password must be 6 - 12 characters",
					"Format is not completed", 2);
		}else if (x < 1 || y < 1 || z < 1) {
			JOptionPane.showMessageDialog(this, "Password must be containing digit, letter, and symbol",
					"Format is not completed", 2);	
		}else if (phone.length() < 11 || phone.length() > 12) {
			JOptionPane.showMessageDialog(this, "Phone must be exactly 11 - 12 digits",
					"Format is not completed", 2);
		}else if (!phone.startsWith("08")) {
			JOptionPane.showMessageDialog(this, "Phone must be started with '08'",
					"Format is not completed", 2);
		}else if (v != 0) {
			JOptionPane.showMessageDialog(this, "Phone must be number",
					"Format is not completed", 2);
		}else if (!address.endsWith("Street")) {
			JOptionPane.showMessageDialog(this, "Address must be ended with 'Street'",
					"Format is not completed", 2);
		}else if(!DB.validasiRegister(email)){
			JOptionPane.showMessageDialog(this, "Email already used",
					"Format is not completed", 2);
		}else{
			if (rbFemale.isSelected()) {
				gender = "Female";
			}else{
				gender = "Male";
			}
			role = "Member";
			String dob = ""+ spDOB.getValue();

			String month = "";
			if (dob.substring(4,7).equals("Jan")) {
				month = "01";
			}else if (dob.substring(4,7).equals("Feb")) {
				month = "02";
			}else if (dob.substring(4,7).equals("Mar")) {
				month = "03";
			}else if (dob.substring(4,7).equals("Apr")) {
				month = "04";
			}else if (dob.substring(4,7).equals("May")) {
				month = "05";
			}else if (dob.substring(4,7).equals("Jun")) {
				month = "06";
			}else if (dob.substring(4,7).equals("Jul")) {
				month = "07";
			}else if (dob.substring(4,7).equals("Aug")) {
				month = "08";
			}else if (dob.substring(4,7).equals("Sep")) {
				month = "09";
			}else if (dob.substring(4,7).equals("Oct")) {
				month = "10";
			}else if (dob.substring(4,7).equals("Nov")) {
				month = "11";
			}else if (dob.substring(4,7).equals("Dec")) {
				month = "12";
			}
			
			DOB = ""+ dob.substring(24)+"-"+month+"-"+ dob.substring(8, 10);
			DB.addMember(email, password, phone, gender, DOB, address, role);

			JOptionPane.showMessageDialog(this, email+" has been registered", "Welcome", 2);
			this.setVisible(false);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
