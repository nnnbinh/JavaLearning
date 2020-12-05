package dict;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class SearchFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtWord;
	private JTextField txtMeaning;
	private JTextField txtCount;

	/**
	 * Launch the application.
	 */
	List<Dictionary> lstDictionaries=MainFrame.lstDict;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchFrame frame = new SearchFrame();
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
	public SearchFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWord = new JLabel("Word");
		lblWord.setBounds(12, 39, 56, 16);
		contentPane.add(lblWord);
		
		txtWord = new JTextField();
		txtWord.setBounds(90, 36, 116, 22);
		contentPane.add(txtWord);
		txtWord.setColumns(10);
		
		JLabel lblMeaning = new JLabel("Meaning");
		lblMeaning.setBounds(12, 88, 56, 16);
		contentPane.add(lblMeaning);
		
		txtMeaning = new JTextField();
		txtMeaning.setEditable(false);
		txtMeaning.setColumns(10);
		txtMeaning.setBounds(90, 85, 116, 22);
		contentPane.add(txtMeaning);
		
		JLabel lblNewLabel_1_1 = new JLabel("Count");
		lblNewLabel_1_1.setBounds(12, 174, 56, 16);
		contentPane.add(lblNewLabel_1_1);
		
		txtCount = new JTextField();
		txtCount.setEditable(false);
		txtCount.setColumns(10);
		txtCount.setBounds(90, 171, 116, 22);
		contentPane.add(txtCount);
		
		JLabel lblNoData = new JLabel("Khong co du lieu");
		lblNoData.setForeground(Color.RED);
		lblNoData.setBounds(90, 120, 246, 16);
		lblNoData.setVisible(false);
		contentPane.add(lblNoData);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtMeaning.setText("");
				String word=txtWord.getText().toString();
				lblNoData.setVisible(false);
				for(Dictionary item: lstDictionaries) {
					if(word.equals(item.getWord())) {
						txtMeaning.setText(item.getMeaning());
					}
				}
				if(txtMeaning.getText().equals("")) {
					lblNoData.setVisible(true);
				}
				txtCount.setText(String.valueOf(lstDictionaries.size()));
			}
		});
		btnSearch.setBounds(239, 60, 97, 25);
		contentPane.add(btnSearch);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 432, 26);
		contentPane.add(menuBar);
		
		JMenuItem mntmInsert = new JMenuItem("Insert");
		mntmInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame frame=new MainFrame();
				frame.setVisible(true);
				SearchFrame.this.setVisible(false);
			}
		});
		menuBar.add(mntmInsert);
		
		JMenuItem mntmSearch = new JMenuItem("Search");
		menuBar.add(mntmSearch);
		
		
	}

}
