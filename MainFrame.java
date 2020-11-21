package diary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import java.awt.event.ItemListener;
import java.util.Calendar;
import java.awt.event.ItemEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtDay;
	
	private Calendar calendar=Calendar.getInstance();
	private int dayNow=calendar.get(Calendar.DATE);
	private int monthNow=calendar.get(Calendar.MONTH)+1;
	private int yearNow=calendar.get(Calendar.YEAR);
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 555, 317);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(193, 61, 330, 196);
		contentPane.add(scrollPane);
		
		JTextArea txtaDiary = new JTextArea();
		scrollPane.setViewportView(txtaDiary);
		
		txtDay = new JTextField();
		txtDay.setEditable(false);
		txtDay.setBounds(193, 26, 116, 22);
		contentPane.add(txtDay);
		txtDay.setColumns(10);
		txtDay.setText(dayNow+"/"+monthNow+"/"+yearNow);
		
		JCheckBox chckbxGhi = new JCheckBox("Ghi");
		chckbxGhi.setSelected(true);
		chckbxGhi.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(arg0.getStateChange()==2) {
					txtaDiary.setEditable(false);
				}else {
					txtaDiary.setEditable(true);
				}
			}
		});
		chckbxGhi.setBounds(8, 73, 113, 25);
		contentPane.add(chckbxGhi);
		
		JCheckBox chckbxDoc = new JCheckBox("Doc");
		chckbxDoc.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
			}
		});
		chckbxDoc.setBounds(8, 109, 113, 25);
		contentPane.add(chckbxDoc);
		
		JButton btnSave = new JButton("Luu");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String str=txtaDiary.getText();
			}
		});
		btnSave.setBounds(8, 164, 97, 25);
		contentPane.add(btnSave);
		
		
	}
}
