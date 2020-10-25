import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.DatabaseMetaData;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class LoginForm extends JInternalFrame implements ActionListener, MouseListener{

	private JFrame MainForm;
	
	private JLabel 
		lbLogin 		= new JLabel("Login"),
		lbEmail 		= new JLabel("Email"),
		lbPassword 		= new JLabel("Password"),	  
		lbDum 			= new JLabel(""),	  
		lbDumb;
	private JPanel 
		panel 			= new JPanel(),	  
		pnlMid 			= new JPanel(),	  
		pnlInternal 	= new JPanel(),	  
		pnlBot 			= new JPanel(),	  
		pnlTop 			= new JPanel(),	  
		pnlBtnLogin 	= new JPanel(),	  
		pnlSideAtas 	= new JPanel(),	  
		pnlSideBawah 	= new JPanel(),	  
		pnlSideKiri 	= new JPanel(),	  
		pnlSideKanan 	= new JPanel();
	private JTextField 
		tfEmail 		= new JTextField();
	private JPasswordField 
		pfPassword 		= new JPasswordField();
	private JButton
		btnLogin 		= new JButton("Login");
	private JCheckBox 
		cbAgrrement 	= new JCheckBox("I agree with terms and conditions");
	private Color 
		utama 			= new Color(102,102,102),
		pink 			= new Color(255,204,204);
	
	public void lbLogin(){
		lbLogin.setFont(new java.awt.Font("Segoe UI", 0, 24));
		lbLogin.setForeground(utama);
		lbLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	}
	
	public void btnLogin(){
		btnLogin.setBorderPainted(false);
		btnLogin.setFocusPainted(false);
		btnLogin.setForeground(pink);
		btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 18));
		btnLogin.setContentAreaFilled(false);
		btnLogin.addActionListener(this);
		btnLogin.addMouseListener(this);
	}
	
	public void subLabel(){
		lbEmail.setFont(new java.awt.Font("Segoe UI", 0, 16));
		lbEmail.setForeground(utama);
		lbPassword.setFont(new java.awt.Font("Segoe UI", 0, 16));
		lbPassword.setForeground(utama);
	}
	
	public void pnlBtnLogin(){
		pnlBtnLogin.setBackground(utama);
		pnlBtnLogin.setPreferredSize(new java.awt.Dimension(100, 50));
		pnlBtnLogin.setLayout(new FlowLayout());
		btnLogin();
		
		pnlBtnLogin.add(btnLogin);
	}
	
	public void pnlBot(){
		pnlBot.setLayout(new FlowLayout());
		pnlBot.setBackground(Color.white);
		pnlBot.setBorder(javax.swing.BorderFactory.createLineBorder(Color.white, 10));
		
		pnlBtnLogin();
		
		pnlBot.add(pnlBtnLogin);
	}
	
	public void pnlTop(){
		pnlTop.setBackground(Color.white);
		pnlTop.setLayout(new FlowLayout());
		pnlTop.setBorder(javax.swing.BorderFactory.createLineBorder(Color.white, 10));
		
		lbLogin();
		
		pnlTop.add(lbLogin);
	}
	
	public void pnlMid(){
		tfEmail.setBackground(utama);
		tfEmail.setFont(new java.awt.Font("Segoe UI", 0, 16));
		tfEmail.setForeground(pink);
		tfEmail.setBorder(javax.swing.BorderFactory.createLineBorder(utama,5));
		tfEmail.setCaretColor(pink);
		
		pfPassword.setBackground(utama);
		pfPassword.setFont(new java.awt.Font("Segoe UI", 0, 16));
		pfPassword.setForeground(pink);
		pfPassword.setBorder(javax.swing.BorderFactory.createLineBorder(utama,5));
		pfPassword.setCaretColor(pink);
		
		
		cbAgrrement.setBackground(Color.white);	
		cbAgrrement.setFont(new java.awt.Font("Segoe UI", 0, 16));
		cbAgrrement.setFocusPainted(false);
		cbAgrrement.setForeground(utama);
		
		subLabel();
		
		pnlMid.setBorder(javax.swing.BorderFactory.createLineBorder(Color.white,10));
		pnlMid.setBackground(Color.white);
		pnlMid.setLayout(new GridLayout(3,2,10,10));
		pnlMid.add(lbEmail);
		pnlMid.add(tfEmail);
		pnlMid.add(lbPassword);
		pnlMid.add(pfPassword);
		lbDumb = new JLabel("");
		pnlMid.add(lbDumb);
		pnlMid.add(cbAgrrement);
	}
	
	public void panel() {
		panel.setVisible(true);
		panel.setBackground(Color.white);
		panel.setLayout(new BorderLayout());
		
		pnlTop();
		pnlBot();
		pnlMid();
		
		panel.add(pnlBot, BorderLayout.SOUTH);
		panel.add(pnlTop, BorderLayout.NORTH);
		panel.add(pnlMid, BorderLayout.CENTER);
		
	}

	public LoginForm(JFrame frame) {
		this.MainForm = frame;
		setTitle("LOGIN");
		setVisible(true);
		setClosable(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setPreferredSize(new java.awt.Dimension(500, 320));
		setLayout(new BorderLayout());
		setBorder(javax.swing.BorderFactory.createLineBorder(utama, 5));
		panel();
		
		add(panel, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		btnLogin.setForeground(pink);
		pnlBtnLogin.setBackground(utama);
		
		validasi();
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		btnLogin.setForeground(utama);
		pnlBtnLogin.setBackground(pink);
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
	
	public void validasi(){
		
		DataBase DB = new DataBase();
		
		String email = tfEmail.getText();
		String password = pfPassword.getText();
		
		boolean can = DB.Login(email, password);
		
		int count = email.length() - email.replace("@", "").length();
		
		int x = 0, y = 0, z = 0;
		for (int i = 0; i < password.length(); i++) {
			char tes = password.charAt(i);
			if(Character.isDigit(tes)){
				x++;
			}else if(Character.isLetter(tes)){
				y++;
			}else{
				z++;
			}
		}	

		if(email.equals("") || password.equals("")){
			JOptionPane.showMessageDialog(this, "Email and Password must be Filled",
					"Format is not completed", 2);
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
		}else if (x < 1 || y < 1 || z < 1) {
			JOptionPane.showMessageDialog(this, "Password must be containing digit, letter, and symbol",
					"Format is not completed", 2);
		}else if (!cbAgrrement.isSelected()) {
			JOptionPane.showMessageDialog(this, "You have to agree with terms and conditions",
					"Format is not completed", 2);
		}else if(can){
			MainForm.dispose();
			MemberMainForm MMF = new MemberMainForm(email);
	
		}else{
			JOptionPane.showMessageDialog(this, "Data not found",
					"Data error", 2);
		}
	}



}