import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowStateListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JInternalFrame.JDesktopIcon;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;

public class MainForm extends JFrame implements ActionListener{
	
	private LoginForm LF;
	private RegisterForm RF;
	
	private JTabbedPane 
		tp = new JTabbedPane();
	private JMenuBar 
		mb = new JMenuBar();
	private JMenu 
		m1 = new JMenu("Menu");
	private JMenuItem 
		login = new JMenuItem("Login"),
		register = new JMenuItem("Register");
	private JLabel 	
		image = new JLabel(""),
		dum = new JLabel("");
	
	private int can1 = 1, can2 = 1;
	
	public MainForm() {
		setSize(1280, 720);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		
		register.addActionListener(this);
		login.addActionListener(this);
		m1.add(login);
		m1.add(register);
		mb.add(m1);
		
		image.setIcon(new javax.swing.ImageIcon("D:\\Picture\\FA.WPP000.NO[FA]0.png"));
		add(mb, BorderLayout.NORTH);
		add(image, BorderLayout.CENTER);
		
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == login){
			if(can1 == 1){
				if (can2 > 1) {
					if (RF.isVisible()) {
						RF.setVisible(false);
						image.remove(RF);
						LF = new LoginForm(this);
						image.setLayout(new GridBagLayout());
						image.add(LF);
						can1++;
					}else{
						LF = new LoginForm(this);
						image.setLayout(new GridBagLayout());
						image.add(LF);
						can1++;
					}
				}else{
					LF = new LoginForm(this);
					image.setLayout(new GridBagLayout());
					image.add(LF);
					can1++;
				}	
			}else if(can2 > 1){
				if (RF.isVisible()) {
					RF.setVisible(false);
					image.remove(RF);
					LF = new LoginForm(this);
					image.setLayout(new GridBagLayout());
					image.add(LF);
				}else {
					if (!LF.isVisible()) {
						LF = new LoginForm(this);
						image.setLayout(new GridBagLayout());
						image.add(LF);
					}
				}
			}else if(!LF.isVisible()){
				LF = new LoginForm(this);
				image.setLayout(new GridBagLayout());
				image.add(LF);
			}
		}else if(e.getSource() == register) {
			if(can2 == 1){
				if (can1 > 1) {
					if (LF.isVisible()) {
						LF.setVisible(false);
						image.remove(LF);
						RF = new RegisterForm();
						image.setLayout(new GridBagLayout());
						image.add(RF);
						can2++;
					}else{
						RF = new RegisterForm();
						image.setLayout(new GridBagLayout());
						image.add(RF);
						can2++;
					}
				}else{
				RF = new RegisterForm();
				image.setLayout(new GridBagLayout());
				image.add(RF);
				can2++;
				}
			}else if(can1 > 1){
				if (LF.isVisible()) {
					LF.setVisible(false);
					image.remove(LF);
					RF = new RegisterForm();
					image.setLayout(new GridBagLayout());
					image.add(RF);
				}else {
					if (!RF.isVisible()) {
						RF = new RegisterForm();
						image.setLayout(new GridBagLayout());
						image.add(RF);
					}	
				}
			}else if(!RF.isVisible()){
				RF = new RegisterForm();
				image.setLayout(new GridBagLayout());
				image.add(RF);
			}
			
		}
	}
}
