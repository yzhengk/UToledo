package GUIPhoneBook;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class UserLogin
{
	static final int WIDTH = 480;
	static final int HEIGHT = 300;
	final static String FILEPATH = "info.txt";
	
	public UserLogin()
	{
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e){}
		final PhoneBook pb = new PhoneBook();
		try {
			pb.init(FILEPATH);
		} catch (Exception e2) {}
		JFrame frame = new JFrame("Phone Book");
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int width = screenSize.width;
		int height = screenSize.height;
		
		int x = (width - WIDTH)/2;
		int y = (height - HEIGHT)/2 - 50;
		frame.setLocation(x,y);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			final JTabbedPane tp = new JTabbedPane();
			frame.setContentPane(tp);
			JPanel panel1 = new JPanel();
			JPanel panel2= new JPanel();
			JPanel panel3 = new JPanel();
			JPanel panel4 = new JPanel();
			
			tp.addTab("panel1", panel1);
			tp.setEnabledAt(0,true);
			tp.setTitleAt(0,"Add");
			tp.addTab("panel2", panel2);
			tp.setEnabledAt(1,true);
			tp.setTitleAt(1,"Delete");
			tp.addTab("panel3", panel3);
			tp.setEnabledAt(2,true);
			tp.setTitleAt(2,"Find");
			tp.addTab("panel4", panel4);
			tp.setEnabledAt(3,true);
			tp.setTitleAt(3, "List");
			
			
			tp.setPreferredSize(new Dimension(480,300));
			tp.setTabPlacement(JTabbedPane.TOP);
			
			
			tp.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
			//frame.pack();
			
			panel1.setLayout(new GridBagLayout());
			panel1.setOpaque(true);
			panel2.setLayout(new GridBagLayout());
			panel2.setOpaque(true);
			panel3.setLayout(new GridBagLayout());
			panel3.setOpaque(true);
			panel4.setLayout(new GridBagLayout());
			panel4.setOpaque(true);
			final JLabel l1 = new JLabel("Name");
			final JLabel l2 = new JLabel("PhoneNumber");
			final JLabel l3 = new JLabel("Notes");
			final JTextField t1 = new JTextField(23);
			final JTextField t2 = new JTextField(23);
			final JTextField t3 = new JTextField(23);
			JButton b1 = new JButton("Submmmit");
			JButton b2 = new JButton("Reset");
			
			GridBagConstraints c = new GridBagConstraints();
		//	c.fill = GridBagConstraints.NONE;
		//	c.anchor = GridBagConstraints.CENTER;
		//	c.weightx = 1;
		//	c.weighty = 1;	
			//add(t1,c,0,0,1,1);
			c.gridx = 0;
			c.gridy = 0;
			panel1.add(l1,c);
			c.gridwidth = 2;
			c.gridheight = 1;
			c.gridx = 1;
			panel1.add(t1,c);
			
			c.gridx = 0;
			c.gridy = 1;
			c.gridwidth = 1;
			c.gridheight = 1;
			panel1.add(l2,c);
			c.gridx = 1;
			c.gridwidth = 2;
			c.gridheight = 1;
			panel1.add(t2,c);
			
			c.gridx = 0;
			c.gridy = 2;
			c.gridwidth = 1;
			c.gridheight = 1;
			panel1.add(l3,c);
			c.gridx = 1;
			c.gridwidth = 2;
			c.gridheight = 1;
			panel1.add(t3,c);
			
			c.gridx = 1;
			c.gridy = 3;
			c.gridwidth = 1;
			c.gridheight = 1;
			panel1.add(b1,c);
			
			c.gridx= 2;
			c.gridwidth = 1;
			c.gridheight = 1;
			panel1.add(b2,c);
			frame.setVisible(true);
			frame.pack();
			
			t1.grabFocus(); //t1 grab the focus 
			b1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					User newUser = new User();
					if(t1.getText().trim().length() == 0)
					{
						JOptionPane.showMessageDialog(null,"Name cannot be empty.","Error",JOptionPane.ERROR_MESSAGE);
						return;
					}
					newUser.setName(t1.getText());
					if(!validatePhoneNumber(t2.getText().trim()))
					{
						//System.out.println("illegal phone number");
						JOptionPane.showMessageDialog(null,"illegal phone number","Error",JOptionPane.ERROR_MESSAGE);
						return;
					}
					newUser.setPhoneNumber(t2.getText());
					newUser.setNotes(t3.getText());
					pb.list();
					boolean ac = false;
					try {
					ac = pb.add(newUser);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						pb.save(FILEPATH);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					pb.list();
					if(ac)
					{
						JOptionPane.showMessageDialog(null,"Entry is added successfully","Notice",JOptionPane.INFORMATION_MESSAGE|JOptionPane.DEFAULT_OPTION);
						t1.setText("");
						t2.setText("");
						t3.setText("");
					}
				}
			});
			
			b2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					t1.setText("");
					t2.setText("");
					t3.setText("");
				}
			});
			
			//---------------Pane2-------------------------------//
			final JLabel ll1 = new JLabel("Enter Name");
			final JTextField tt1 = new JTextField(15);
			final JButton bb1 = new JButton("OK");
			panel2.add(ll1);
			panel2.add(tt1);
			panel2.add(bb1);
			bb1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					boolean f = pb.delete(tt1.getText().trim());
					if(!f) 
						JOptionPane.showMessageDialog(null,"No such name","Notice",JOptionPane.WARNING_MESSAGE);
					else
						{
							JOptionPane.showMessageDialog(null,"Entry is deleted successfully","Notice",JOptionPane.INFORMATION_MESSAGE|JOptionPane.DEFAULT_OPTION);
							try {
								pb.save(FILEPATH);
							} catch (FileNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					//tt1.setText("");
	
				}
			});
			
			
			final JLabel ll3 = new JLabel("Enter");
			final JTextField tf3 = new JTextField(15);
			final JTextArea ja3= new JTextArea(2,2);
			ja3.setVisible(false);
			ja3.setEditable(false);
			final JButton bb3 = new JButton("OK");
			final JRadioButton r1 = new JRadioButton("Full name");
			final JRadioButton r2 = new JRadioButton("Partial name");
			ButtonGroup bg = new ButtonGroup();
            r1.setSelected(true);  //set the r1 selected
			bg.add(r1);
			bg.add(r2);
			c.gridx = 0;
			c.gridy = 0;
			panel3.add(r1,c);
			c.gridx = 1;
			panel3.add(r2,c);
			c.gridx = 0;
	    	c.gridy = 1;
			panel3.add(ll3,c);
			c.gridx= 1;
			panel3.add(tf3,c);
			c.gridx = 2;
			panel3.add(bb3,c);
			c.gridx = 1;
			c.gridy = 2;
			panel3.add(ja3,c);
			bb3.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					ja3.setVisible(true);
					Vector<User> result ;
					if(r1.isSelected())
						result = pb.find(tf3.getText().trim());
					else
						result = pb.partialfind(tf3.getText().trim());
						
					if(0 == result.size()) 
						ja3.setText("No such name");
					else
					{
						Iterator<User> it = result.iterator();
						ja3.setText("");
						while(it.hasNext())
						{
	                        User ui = new User();
	                        ui = it.next();
	                        ja3.append(ui.getName()+"\t" + ui.getPhoneNumber() + "\t"
             			           + ui.getNotes() + "\n");
						}
					}
					//tt1.setText("");
	
				}
			});
			
			
			/***********************panel 4***************************************/
			
			final JLabel j4 = new JLabel("All Entries are listed below");
			final JLabel j5 = new JLabel("----------------------------");
			final JTextArea tf4 = new JTextArea(10,30);
//			tf4.append("Name" + "\t" + "PhoneNumber" + "\t" + "Notes\n");
//			tf4.append("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			tf4.setEditable(false);
			c.gridx = 0;
			c.gridy = 0;
			c.gridwidth = 1;
			c.gridheight = 1;
			panel4.add(j4,c);
			c.gridy = 1;
			panel4.add(j5,c);
			c.gridy = 2;
			panel4.add(tf4,c);
			
			
			tp.addChangeListener(new ChangeListener(){
	            public void stateChanged(ChangeEvent e){
	                int selectedIndex = tp.getSelectedIndex();  
	               // String title = tp.getTitleAt(selectedIndex); 

                    if(3 == selectedIndex)
	                {
	                	tf4.setText("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
	                	tf4.append("Name" + "\t" + "PhoneNumber" + "\t" + "Notes\n");
	        			tf4.append("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	                	Vector<User> lists = pb.list();
                		Iterator<User> it = lists.iterator();
                		while(it.hasNext())
                		{ 
                			User tmp = new User();
                			tmp = it.next();
                            tf4.append("\n");
                			tf4.append(tmp.getName()+"\t" + tmp.getPhoneNumber() + "\t"
                			           + tmp.getNotes());
	                	}
	                }
	            }
	        });

	}
	
	public static boolean validatePhoneNumber(String phoneNumber)
	{ 
		String regex = "(^\\d{3}-\\d{3}-\\d{4}$)|(^\\(\\d{3}\\)\\d{3}-\\d{4}$)|(^\\d{3}-\\d{4}$)" ;
		Pattern pat = Pattern.compile(regex);
		Matcher ma = pat.matcher(phoneNumber);
		boolean rs = ma.find();
		return rs;
	}

		    public static void main(String[] args) throws Exception 
		    {
		    	new UserLogin();
		    }

}
