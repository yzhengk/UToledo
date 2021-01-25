import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;

public class MainWindow {

	private JFrame frmStablemarriageGuiApp;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextPane tpFileName ; //name of the input file
	private JTextPane tpNumber ;//the number of men and women
	private JTextPane tpWomenList ;//the lists of men 
	private JTextPane tpManList ;//the lists of women
	private JLabel lbErrorMsg ;//show read file error msg
	private JRadioButton rdbtnNewRadioButton ;//Men Propose radio button
	private List<Person> manList ;//save the men person list
	private List<Person> womenList ;////save the women person list
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try { 
					MainWindow mainWindow = new MainWindow();
					mainWindow.frmStablemarriageGuiApp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public MainWindow() {
		initialize();
	}


	private void initialize() {
		frmStablemarriageGuiApp = new JFrame();
		frmStablemarriageGuiApp.setTitle("StableMarriage GUI App");
		frmStablemarriageGuiApp.setBounds(100, 100, 624, 590);
		frmStablemarriageGuiApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStablemarriageGuiApp.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 588, 55);
		frmStablemarriageGuiApp.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Input file name:");
		lblNewLabel.setBounds(10, 10, 107, 15);
		panel.add(lblNewLabel);
		
		tpFileName = new JTextPane();
		tpFileName.setText("inputdata.txt");
		tpFileName.setBackground(new Color(255, 255, 255));
		tpFileName.setBounds(113, 10, 307, 21);
		panel.add(tpFileName);
		
		JButton btnOk = new JButton("Check");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getFileData(tpFileName,tpNumber,lbErrorMsg,tpManList,tpWomenList);
			}
		});
		btnOk.setBounds(443, 6, 93, 23);
		panel.add(btnOk);
		
		lbErrorMsg = new JLabel("");
		lbErrorMsg.setBounds(113, 38, 465, 15);
		panel.add(lbErrorMsg);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 73, 588, 417);
		frmStablemarriageGuiApp.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblManList = new JLabel("Man List :");
		lblManList.setBounds(10, 76, 82, 15);
		panel_1.add(lblManList);
		
		JLabel lblNewLabel_1 = new JLabel("Women List :");
		lblNewLabel_1.setBounds(10, 228, 82, 15);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNumber = new JLabel("Number :");
		lblNumber.setBounds(10, 10, 54, 15);
		panel_1.add(lblNumber);
		
		tpNumber = new JTextPane();
		tpNumber.setEditable(false);
		tpNumber.setBounds(10, 35, 568, 30);
		panel_1.add(tpNumber);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 253, 568, 117);
		panel_1.add(scrollPane_1);
		
		tpWomenList = new JTextPane();
		scrollPane_1.setViewportView(tpWomenList);
		tpWomenList.setEditable(false);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 101, 568, 117);
		panel_1.add(scrollPane);
		
		tpManList = new JTextPane();
		scrollPane.setViewportView(tpManList);
		tpManList.setEditable(false);
		
		JButton btnShowMenP = new JButton("show men preferences");
		
		btnShowMenP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenPreferencesJFrame  menjf = new MenPreferencesJFrame();
				menjf.setVisible(true);
				menjf.showContent(manList);
			}
		});
		btnShowMenP.setBounds(121, 380, 168, 30);
		panel_1.add(btnShowMenP);
		
		JButton btnShowWomenP = new JButton("show women preferences");
		
		btnShowWomenP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WomenPreferencesJFrame womenjf = new WomenPreferencesJFrame();
				womenjf.setVisible(true);
				womenjf.showContent(womenList);
			}
		});
		btnShowWomenP.setBounds(323, 380, 168, 30);
		panel_1.add(btnShowWomenP);
		
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 500, 588, 42);
		frmStablemarriageGuiApp.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		rdbtnNewRadioButton = new JRadioButton("Men Propose");
		rdbtnNewRadioButton.setSelected(true);
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(18, 6, 121, 23);
		panel_2.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Women Propose");
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(141, 6, 121, 23);
		panel_2.add(rdbtnNewRadioButton_1);
		
		JButton btnNewButton_1 = new JButton("Run");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				runResult();
				
			}
		});
		btnNewButton_1.setBounds(344, 4, 121, 27);
		panel_2.add(btnNewButton_1);
	}
	
	
	protected void runResult() {
		
		if(rdbtnNewRadioButton.isSelected()){
			Algorithm.GaleShapley(manList,womenList);
		}
		else{
			Algorithm.GaleShapley(womenList,manList);
		}
		ResultJFrame frame = new ResultJFrame();
		if(rdbtnNewRadioButton.isSelected()){
			frame.showResult(manList);
		}
		else{
			frame.showResult(womenList);
		}
		frame.setVisible(true);
	}

	

	public void  getFileData(JTextPane tpFileName
			, JTextPane tpNumber
			, JLabel lbErrorMsg
			, JTextPane tpManList
			, JTextPane tpWomenList ) {
		manList = new ArrayList<Person>();
		womenList = new ArrayList<Person>();
		String result = ReadFile.readFile(tpFileName.getText().trim(), manList, womenList);
		if(result != "true"){
			lbErrorMsg.setForeground(Color.red);
			lbErrorMsg.setText(result);
		}
		else{
			lbErrorMsg.setText("");
		}
		Integer n = manList.size();
		tpNumber.setText(n.toString());
		tpNumber.repaint();
		
		lbErrorMsg.repaint();
		String manlistText = "";
		for(int i = 0; i < manList.size(); i++){
			manlistText += manList.get(i).getName() + " , ";
		}
		tpManList.setText(manlistText);
		tpManList.repaint();
		
		String womenlistText = "";
		for(int i = 0; i < womenList.size(); i++){
			womenlistText += womenList.get(i).getName() + " , ";
		}
		tpWomenList.setText(womenlistText);
		tpWomenList.repaint();
	}
}
