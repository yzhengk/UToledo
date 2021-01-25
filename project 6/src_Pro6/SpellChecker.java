import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class SpellChecker extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	HashTable dic;//define dictionary
	/**
	 * constructor
	 */
	public SpellChecker(){
		super();
        this.setBounds(100, 100, 600, 600);
		dic = new HashTable();
		readDic();
	}
	
	/**
	 * read info from dictionary file
	 */
	public void readDic(){
		
		File file = new File("dictionary.txt");
        Scanner scan = null;
        try {
    	   scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("Can't open the file");
		}
		String input;
		String split[];
		while(scan.hasNextLine()){
			input = scan.nextLine();
			split = input.split(" ");
			for(int t=0;t<split.length;t++){
				if(!split.equals(""))dic.Insert(split[t]);
			}
		}
	}
	
	private JTextArea welcome;
	private JTextArea result;
	private JTextField inputWord;
	private JButton button;
	private JPanel jp = new JPanel();
	private JScrollPane js;
	public void main(){
		welcome = new JTextArea("Welcome to SpellChecker Program!");
		welcome.setEditable(false);
		inputWord = new JTextField();
		button = new JButton("submit");
		result = new JTextArea("");
		
		welcome.setBounds(0, 0, 200, 20);
		inputWord.setBounds(20,0,200,20);
		button.setBounds(30,0,200,20);
		button.addActionListener(this); 
		result.setBounds(40,0,200,20);
		
		jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));
		jp.setBounds(0,0,600,600);
		
		jp.add(welcome);
		jp.add(inputWord);
		jp.add(button);
		jp.add(result);
		
		js=new JScrollPane(this.result);
        js.setHorizontalScrollBarPolicy( 
      		  JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
        js.setVerticalScrollBarPolicy( 
      		  JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
        jp.add(js);
		
		this.add(jp);
	       
        this.setVisible(true); 
        this.setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	 @Override
	public void actionPerformed(ActionEvent e) {
		String input = inputWord.getText();
		String[] word = input.split(" ");
		int len = word.length;
		result.append("Spell Check Report:==============================\n");
		for(int i=0;i<len;i++){
			if(dic.Contains(word[i])){
				result.append("Word:   '" + word[i] + "'   true\n");
			} else {
				result.append("Word:   '" + word[i] + "'   false\n");
			}
		}
		this.add(jp);
		this.setVisible(true); 
	}
}
