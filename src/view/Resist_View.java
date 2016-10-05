package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import object.Custom_LogIn_Information;
import util.FileOperation;
import util.Object_OutIn_Stream;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Resist_View extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JTextField textField;
	private JLabel label;
	private JTextField textField_1;
	private JLabel label_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	JLabel lb1;
	File file1;
	String path1;
	String aString;
	File cFile;
	public int x=1;//用来标记是否有重复注册的标记

	//调用设置图标的函数
	public void setIcon(String file, JLabel iconLable) {  
		ImageIcon icon = new ImageIcon(file);  
		icon.getImage();
		Image temp = icon.getImage().getScaledInstance(iconLable.getWidth(),  
				iconLable.getHeight(), Image.SCALE_DEFAULT);  
		icon = new ImageIcon(temp);  
		iconLable.setIcon(icon);  
	}  
	
	public Resist_View() {
		super("欢迎进来注册账号哟~");
		
		FileOperation fo=new FileOperation();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(380, 90, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lb1 = new JLabel("\u7528\u6237\u540D");
		lb1.setBounds(67, 10, 54, 15);
		panel.add(lb1);
		
		JLabel lb2 = new JLabel("    \u5BC6\u7801");
		lb2.setBounds(54, 35, 54, 15);
		panel.add(lb2);
		
		JLabel lb3 = new JLabel("\u786E\u8BA4\u5BC6\u7801");
		lb3.setHorizontalAlignment(SwingConstants.TRAILING);
		lb3.setBounds(54, 69, 54, 15);
		panel.add(lb3);
		
		textField = new JTextField();
		textField.setBounds(150, 7, 226, 21);
		panel.add(textField);
		textField.setColumns(10);

		label = new JLabel("   \u5916\u5356\u5730\u5740");
		label.setBounds(47, 100, 93, 15);
		panel.add(label);
		
		textField_1 = new JTextField();
		textField_1.setBounds(150, 97, 226, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		label_1 = new JLabel("      \u7535\u8BDD\u53F7\u7801");
		label_1.setBounds(36, 131, 104, 15);
		panel.add(label_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(150, 128, 226, 21);
		panel.add(textField_2);
		textField_2.setColumns(10);
		

		textField_3 = new JTextField();
		textField_3.setBounds(150, 35, 227, 21);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(150, 66, 226, 21);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		
		
		JButton button = new JButton("\u786E\u5B9A");

		JButton button1 = new JButton("返回");
		button1.setBounds(200, 159, 80, 23);
		panel.add(button1);
		button1.addMouseListener(new MouseAdapter() {
		 	public void mouseClicked(MouseEvent e) {
		 		new LogMView();
		 		Resist_View.this.dispose();
		 	}
		 });
		
		
		button.setBounds(295, 159, 80, 23);
		panel.add(button);
		button.addMouseListener(new MouseAdapter() {
			
			//注册账号				
			@SuppressWarnings("deprecation")
			public void mouseClicked(MouseEvent e) {	


				ArrayList<Custom_LogIn_Information> listc=new ArrayList<Custom_LogIn_Information>();
				listc=Object_OutIn_Stream.in();
				
				Custom_LogIn_Information customert=new Custom_LogIn_Information();
				
				
				
				ArrayList<Custom_LogIn_Information> list=new ArrayList<Custom_LogIn_Information>();	
				Custom_LogIn_Information customer=new Custom_LogIn_Information();
				
				String a1=textField_3.getText();			
				String b1=textField_4.getText();
				
				
				for (Iterator<Custom_LogIn_Information> iterator = listc.iterator(); iterator.hasNext();) {				    
				    customert = (Custom_LogIn_Information) (iterator.next());
				    if(((textField.getText().equals(customert.getName()))&&(customert.getPhone().equals(textField_2.getText())))||(customert.getPhone().equals(textField_2.getText()))){						
						x=0;
				}
					}	
			
				if(x!=0){
					if(a1.equals(b1)&&(x!=0)){
						customer.setName(textField.getText());
						customer.setPassWord(a1);							
						customer.setAddress(textField_1.getText());
						customer.setPhone(textField_2.getText());
						list.add(customer);			
						Object_OutIn_Stream.Out(list);		
						aString=String.format("C:/Users/asus/Desktop/新建文件夹 (5)/diancaisystem/%sdingdan.txt", customer.getPhone());
						cFile=new File(aString);
						fo.createFile(cFile);						
						}
						else{
							JOptionPane.showMessageDialog(Resist_View.this, "大哥，你两次打的密码不一样啊！重来吧！");
						}
					
				}else {
					JOptionPane.showMessageDialog(Resist_View.this, "这个账号已经被注册！");
				}

				//写进文件的时候输出一下写进里面的账号
				ArrayList<Custom_LogIn_Information> list2=new ArrayList<Custom_LogIn_Information>();
				list2=Object_OutIn_Stream.in();
				Custom_LogIn_Information customer2=new Custom_LogIn_Information();
				for (Iterator<Custom_LogIn_Information> iterator = list2.iterator(); iterator.hasNext();) {				    
				    customer2 = (Custom_LogIn_Information) (iterator.next());
				    System.out.println(customer2.getName()+"  "+customer2.getPassWord()+"  "+customer2.getAddress()+"  "+customer2.getPhone());
					}		
			}
			
		});
		
		//实现把图标放到指点lable
				JPanel panel = new JPanel();
				contentPane.add(panel, BorderLayout.NORTH);
				lb1 = new JLabel();
				lb1.setBounds(0, 0, 450, 50);	
				panel.add(lb1);
				file1=new File("util_image/1.jpg");
				path1=file1.getAbsolutePath();
				setIcon(path1, lb1);			
		
		
	}

}
