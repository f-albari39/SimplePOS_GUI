import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class BuyItemForm extends JInternalFrame implements ListSelectionListener, MouseListener{
	
	DataBase DB = new DataBase();
	
	private ArrayList<ArrayList> cakeData = new ArrayList<>();
	private ArrayList<String> cakes = new ArrayList<>();
	
	private String [] columnNames = {
			"Product ID", "Product Name", "Brand", "Stock","Price"};
	
	private String [][] data = new String [1][5];
	
	private int index = 0;
	
	JLabel 
		lbBuyCake 		= new JLabel("Buy Cake"),
		lbProductId		= new JLabel("Product ID"),
		lbProductName	= new JLabel("Product Name"),
		lbStock			= new JLabel("Stock"),
		lbBrand			= new JLabel("Brand"),
		lbPrice			= new JLabel("Price"),
		lbQuantity		= new JLabel("Quantity");
	
	JTable
		tbTabel			= new JTable(data, columnNames);
	
	JTableHeader
		header;
	
	JTextField
		tfProductId		= new JTextField(),
		tfProductName	= new JTextField(),
		tfStock			= new JTextField(),
		tfBrand			= new JTextField(),
		tfPrice			= new JTextField();
	
	JSpinner
		spQuantity		= new JSpinner();
	
	JButton
		btnBuy			= new JButton("Buy"),
		btnCancel		= new JButton("Cancel");
	
	JPanel
		pnlBotBotBuy	= new JPanel(),
		pnlBotBotCancel	= new JPanel(),
		pnlMid			= new JPanel(),
		pnlMidTable		= new JPanel(),
		pnlMidIn		= new JPanel(),		
		pnlBot			= new JPanel(),
		pnlBotMid		= new JPanel(),
		pnlBotBot		= new JPanel();
	
	JScrollPane
		scPane			= new JScrollPane(tbTabel);
	
	private Color 
		utama 			= new Color(102,102,102),
		disable 		= new Color(120,120,120),
		pink 			= new Color(255,204,204),
		white			= new Color(240,240,240);
	
	public void JButton(){
		btnBuy.setFocusPainted(false);
		btnBuy.setBorderPainted(false);
		btnBuy.setContentAreaFilled(false);
		btnBuy.setForeground(pink);
		btnBuy.addMouseListener(this);
		
		btnCancel.setFocusPainted(false);;
		btnCancel.setBorderPainted(false);
		btnCancel.setContentAreaFilled(false);
		btnCancel.setForeground(utama);
	}
	
	public void JTable(){
		cakeData = DB.cakeData();
		data = new String [cakeData.size()][5];
		for (int i = 0; i < cakeData.size(); i++) {
			ArrayList<String> cake = cakeData.get(i);
			for (int j = 0; j < cakeData.get(i).size(); j++) {
				data [i][j] = cake.get(j);
			}
		}
		
		tbTabel = new JTable(data, columnNames);
		tbTabel.setBorder(javax.swing.BorderFactory.createLineBorder(utama, 1));
		scPane = new JScrollPane(tbTabel);
		scPane.getViewport().setBackground(Color.white);
		scPane.setBorder(javax.swing.BorderFactory.createLineBorder(Color.WHITE, 1));
		header = tbTabel.getTableHeader();
		header.setBorder(javax.swing.BorderFactory.createLineBorder(Color.black, 1));
		header.setBackground(utama);
		header.setForeground(pink);
		pnlMidTable.add(scPane, BorderLayout.CENTER);
		
		tbTabel.getSelectionModel().addListSelectionListener(this);
	}
	
	public void JTextField(){
		tfBrand.setEnabled(false);	
		tfPrice.setEnabled(false);
		tfProductId.setEnabled(false);
		tfProductName.setEnabled(false);
		tfStock.setEnabled(false);
		
		tfBrand.setBorder(javax.swing.BorderFactory.createLineBorder(utama, 1));
		tfPrice.setBorder(javax.swing.BorderFactory.createLineBorder(utama, 1));
		tfProductId.setBorder(javax.swing.BorderFactory.createLineBorder(utama, 1));
		tfProductName.setBorder(javax.swing.BorderFactory.createLineBorder(utama));
		tfStock.setBorder(javax.swing.BorderFactory.createLineBorder(utama, 1));
		
		tfBrand.setBackground(Color.WHITE);
		tfPrice.setBackground(Color.WHITE);
		tfProductId.setBackground(Color.WHITE);
		tfProductName.setBackground(Color.WHITE);
		tfStock.setBackground(Color.WHITE);

		tfBrand.setDisabledTextColor(utama);
		tfPrice.setDisabledTextColor(utama);
		tfProductId.setDisabledTextColor(utama);
		tfProductName.setDisabledTextColor(utama);
		tfStock.setDisabledTextColor(utama);
	}
	
	public void JPanel(){
		pnlMid.setBorder(javax.swing.BorderFactory.createLineBorder(Color.WHITE , 10) );
		pnlMid.setLayout(new BorderLayout());
		pnlMid.setBackground(Color.white);
		pnlMid.add(pnlMidIn, BorderLayout.NORTH);
		pnlMid.add(pnlMidTable, BorderLayout.CENTER);
	
		pnlMidIn.setLayout(new GridBagLayout());
		pnlMidIn.setBackground(Color.white);
		pnlMidIn.add(lbBuyCake);
		
		pnlMidTable.setLayout(new BorderLayout());
		pnlMidTable.setBackground(Color.white);
		pnlMidTable.add(scPane, BorderLayout.CENTER);

		pnlBot.setLayout(new BorderLayout());
		pnlBot.setBorder(javax.swing.BorderFactory.createLineBorder(Color.WHITE , 10) );
		pnlBot.setBackground(Color.white);
		pnlBot.add(pnlBotMid, BorderLayout.CENTER);
		pnlBot.add(pnlBotBot, BorderLayout.SOUTH);
		
		pnlBotMid.setBackground(Color.white);
		pnlBotMid.setLayout(new GridLayout(3, 4, 10, 10));
		pnlBotMid.add(lbProductId);
		pnlBotMid.add(tfProductId);
		pnlBotMid.add(lbBrand);
		pnlBotMid.add(tfBrand);
		pnlBotMid.add(lbProductName);
		pnlBotMid.add(tfProductName);
		pnlBotMid.add(lbPrice);
		pnlBotMid.add(tfPrice);
		pnlBotMid.add(lbStock);
		pnlBotMid.add(tfStock);
		pnlBotMid.add(lbQuantity);
		pnlBotMid.add(spQuantity);
		
		pnlBotBot.setBackground(Color.white);
		pnlBotBot.setBorder(javax.swing.BorderFactory.createLineBorder(Color.WHITE , 10) );
		pnlBotBot.setLayout(new FlowLayout());
		pnlBotBot.add(pnlBotBotBuy);
		pnlBotBot.add(pnlBotBotCancel);
		
		pnlBotBotBuy.setLayout(new FlowLayout());
		pnlBotBotBuy.setBackground(utama);
		pnlBotBotBuy.addMouseListener(this);
		pnlBotBotBuy.add(btnBuy);
		
		pnlBotBotCancel.setLayout(new FlowLayout());
		pnlBotBotCancel.setBackground(disable);
		pnlBotBotCancel.add(btnCancel);
	}

	public BuyItemForm() {
		setTitle("Buy Cake");
		setVisible(true);
		setClosable(true);
		setPreferredSize(new java.awt.Dimension(800, 450));
		setLayout(new BorderLayout());
		setBorder(javax.swing.BorderFactory.createLineBorder(utama, 5));
		getContentPane().setBackground(utama);

		JPanel();
		JTextField();
		JButton();
		
		add(pnlMid, BorderLayout.CENTER);
		add(pnlBot, BorderLayout.SOUTH);
		
		JTable();
		
		scPane.setBackground(Color.WHITE);
		tbTabel.setBackground(Color.WHITE);
		tbTabel.setSelectionBackground(utama);
		tbTabel.setSelectionForeground(pink);
		tbTabel.setSelectionMode(1);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		index = tbTabel.getSelectedRow();
		cakeData = DB.cakeData();
		ArrayList<String> cake = cakeData.get(index);
		tfProductId.setText(cake.get(0));
		tfProductName.setText(cake.get(1));
		tfBrand.setText(cake.get(2));
		tfStock.setText(cake.get(3));
		tfPrice.setText(cake.get(4));
		
		btnCancel.addMouseListener(this);
		btnCancel.setForeground(pink);
		pnlBotBotCancel.addMouseListener(this);
		pnlBotBotCancel.setBackground(utama);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnBuy || e.getSource() == pnlBotBotBuy) {
			btnBuy.setForeground(utama);
			pnlBotBotBuy.setBackground(pink);
		}else if (e.getSource() == btnCancel || e.getSource() == pnlBotBotCancel) {
			btnCancel.setForeground(utama);
			pnlBotBotCancel.setBackground(pink);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getSource() == btnBuy || e.getSource() == pnlBotBotBuy) {
			btnBuy.setForeground(pink);
			pnlBotBotBuy.setBackground(utama);
			String value = ""+spQuantity.getValue();
			int val = Integer.parseInt(value);
			
			cakeData = DB.cakeData();
			ArrayList<String> cake = cakeData.get(index);
			
			if (tfBrand.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "You have to select the item first","Select Item", 2);
			}else if (val <= 0) {
				JOptionPane.showMessageDialog(this, "Quantity must be more than 0","Incorrect Format", 2);
			}else if (Integer.parseInt(cake.get(3)) < val) {
				JOptionPane.showMessageDialog(this, "Quantity must be less or equals than the stock","Incorrect Format", 2);
			}
			
		}else if (e.getSource() == btnCancel || e.getSource() == pnlBotBotCancel) {
			btnCancel.setForeground(utama);
			pnlBotBotCancel.setBackground(disable);
			tfBrand.setText("");
			tfPrice.setText("");
			tfProductName.setText("");
			tfProductId.setText("");
			tfStock.setText("");
			
			tbTabel.setEnabled(false);
			tbTabel.setEnabled(true);
			tbTabel.clearSelection();
			
			btnCancel.removeMouseListener(this);
			pnlBotBotCancel.removeMouseListener(this);
		}
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
