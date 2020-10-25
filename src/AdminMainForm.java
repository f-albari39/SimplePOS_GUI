import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class AdminMainForm extends JInternalFrame{
	
	private String [] namaColumn 	= {"ID","Nama"};
	private String [][] data		= {	{"123","Fakhri"},
										{"321","Albari"}};
	
	JTable jt;
	
	public void table(){
		jt = new JTable(data, namaColumn);
		jt.setBounds(50,50,200,230);
		JScrollPane js = new JScrollPane(jt);
		add(js);
		setSize(300,400);
		setVisible(true);
	}
	public AdminMainForm() {
		table();
	}

}
