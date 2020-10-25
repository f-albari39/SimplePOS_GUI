import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MemberMainForm extends JFrame implements ActionListener{
	
	JLabel
		lbImage 		= new JLabel("");
	
	JMenu 
		menuTransaction = new JMenu("Transactions"),
		menuOthers 		= new JMenu("Others");
	
	JMenuBar
		bar 			= new JMenuBar();
	
	JMenuItem
		itmBuy			= new JMenuItem("Buy Items"),
		itmTransaction	= new JMenuItem("Transactions");
		
	public MemberMainForm(String email) {
		int x = email.indexOf('@');
		String member = email.substring(0, x);
		setVisible(true);
		setSize(1280, 720);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		setTitle("Welcome, "+member);
		
		lbImage.setIcon(new javax.swing.ImageIcon("D:\\Picture\\FA18[ClC]+BL250.jpg"));
		
		itmBuy.addActionListener(this);
		itmTransaction.addActionListener(this);
		
		menuTransaction.add(itmBuy);
		menuTransaction.add(itmTransaction);
		
		bar.add(menuTransaction);
		bar.add(menuOthers);
		
		add(bar, BorderLayout.NORTH);
		add(lbImage, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == itmBuy) {
			BuyItemForm buy = new BuyItemForm();
			lbImage.setLayout(new GridBagLayout());
			lbImage.add(buy);
		}
	}

}
