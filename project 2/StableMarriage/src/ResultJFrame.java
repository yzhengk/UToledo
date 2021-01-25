import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;


public class ResultJFrame extends JFrame {

	private JPanel contentPane;
	private JTextPane textPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResultJFrame frame = new ResultJFrame();
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
	public ResultJFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 417, 541);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textPane = new JTextPane();
		textPane.setFont(new Font("Arial", Font.PLAIN, 13));
		textPane.setBounds(10, 50, 381, 443);
		contentPane.add(textPane);
		
		JLabel lblNewLabel = new JLabel("Result : ");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 11, 185, 29);
		contentPane.add(lblNewLabel);
	}
	
	public void showResult(List<Person> list){
		String text = "";
		Person p ;
		for(int i=0;i<list.size();i++){
			p = list.get(i);
			text += "{ " + p.getName() + " , " + p.getPartnerName() + " }\n";
		}
		textPane.setText(text);
		textPane.repaint();
	}

}
