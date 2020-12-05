package dict;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.org.apache.bcel.internal.generic.NEW;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JMenuItem;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtWord;
	private JTextField txtMeaning;
	private JTextField txtCount;
	
	public static List<Dictionary> lstDict = new ArrayList<Dictionary>();

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
		setBounds(100, 100, 520, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 502, 26);
		contentPane.add(menuBar);
		
		JMenuItem mntmInsert = new JMenuItem("Insert");
		menuBar.add(mntmInsert);
		
		JMenuItem mntmSearch = new JMenuItem("Search");
		mntmSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchFrame frame=new SearchFrame();
				frame.setVisible(true);
				MainFrame.this.setVisible(false);
			}
		});
		menuBar.add(mntmSearch);
		
		txtWord = new JTextField();
		txtWord.setBounds(71, 39, 116, 22);
		contentPane.add(txtWord);
		txtWord.setColumns(10);
		
		txtMeaning = new JTextField();
		txtMeaning.setBounds(346, 39, 116, 22);
		contentPane.add(txtMeaning);
		txtMeaning.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Word");
		lblNewLabel.setBounds(20, 42, 56, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Meaning");
		lblNewLabel_1.setBounds(278, 39, 56, 16);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 83, 322, 168);
		contentPane.add(scrollPane);
		
		JTextArea txtaDict = new JTextArea();
		txtaDict.setEditable(false);
		scrollPane.setViewportView(txtaDict);
		
		JLabel lblNewLabel_2 = new JLabel("Count");
		lblNewLabel_2.setBounds(82, 274, 56, 16);
		contentPane.add(lblNewLabel_2);
		
		txtCount = new JTextField();
		txtCount.setEditable(false);
		txtCount.setBounds(143, 271, 116, 22);
		contentPane.add(txtCount);
		txtCount.setColumns(10);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String word=txtWord.getText().toString();
				String meaning = txtMeaning.getText().toString();
				
				lstDict.add(new Dictionary(word,meaning));
				String sresult="";
				for(Dictionary item:lstDict) {
					sresult+=item.getWord()+": "+item.getMeaning()+"\n";
				}
				txtaDict.setText(sresult);
				txtCount.setText(String.valueOf(lstDict.size()));
				txtWord.setText("");
				txtMeaning.setText("");
				
			}
		});
		btnInsert.setBounds(365, 101, 97, 25);
		contentPane.add(btnInsert);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String word=txtWord.getText().toString();
				String meaning = txtMeaning.getText().toString();
				
				for(Dictionary item:lstDict) {
					if(word.equals(item.getWord()) && meaning.equals(item.getMeaning())) {
						lstDict.remove(item);
						break;
					}
				}
				
				String sresult="";
				for(Dictionary item:lstDict) {
					sresult+=item.getWord()+": "+item.getMeaning()+"\n";
				}
				txtaDict.setText(sresult);
				txtCount.setText(String.valueOf(lstDict.size()));
				txtWord.setText("");
				txtMeaning.setText("");
			}
		});
		btnDelete.setBounds(365, 182, 97, 25);
		contentPane.add(btnDelete);
		
		
	}
}
