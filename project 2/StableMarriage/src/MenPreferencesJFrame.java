
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.JScrollPane;


public class MenPreferencesJFrame extends JFrame {

	private JPanel contentPane;
	private JTextPane textPane ;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenPreferencesJFrame frame = new MenPreferencesJFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public MenPreferencesJFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 561, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 48, 525, 309);
		contentPane.add(scrollPane);
		
		textPane = new JTextPane();
		scrollPane.setViewportView(textPane);
		textPane.setFont(new Font("Arial", Font.PLAIN, 13));
		
		JLabel lblManPreferences = new JLabel("Man Preferences:");
		lblManPreferences.setFont(new Font("Arial", Font.PLAIN, 14));
		lblManPreferences.setBounds(10, 10, 124, 28);
		contentPane.add(lblManPreferences);
	}
	
	public void  showContent(List<Person> manList){
		String text = "";
		Person p ;
		for(int i=0;i<manList.size();i++){
			p = manList.get(i);
			text += p.getName() + " : ";
			for(int j=0;j<p.getPreferences().size();j++){
				text += p.getPreferences().get(j) + " , ";
			}
			text += "\n";
		}
		textPane.setText(text);
		textPane.repaint();
	}
}
