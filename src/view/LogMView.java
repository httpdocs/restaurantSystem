package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;import org.omg.IOP.ComponentIdHelper;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.SwingWorker;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import util.MyObjectOuPutStream;
import util.Object_OutIn_Stream;
import object.*;


public class LogMView extends JFrame  {

	private JPanel contentPane;
	private JTextField jtf;
	File file1,file2,file3;
	String path1,path2,path3;
	String name,passWord;
	ArrayList<Custom_LogIn_Information> list;
	private JTextField textField;
	public int x=0;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogMView frame = new LogMView();
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
	public LogMView() {

		super ("欢迎光临蒙肥羊注册登录界面");
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(380, 90, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);



		JLabel lb1 = new JLabel();
		lb1.setBounds(0, 0, 450, 50);	
		panel.add(lb1);
		file1=new File("util_image/1.jpg");
		path1=file1.getAbsolutePath();


		JLabel jp_jl1 = new JLabel("New label");
		jp_jl1.setBounds(70, 41, 44, 39);
		panel_1.add(jp_jl1);		
		file2=new File("util_image/yh.jpg");
		path2=file2.getAbsolutePath();

		JLabel jp_jl2 = new JLabel("New label");
		jp_jl2.setBounds(70, 90, 44, 39);
		panel_1.add(jp_jl2);		
		file3=new File("util_image/mm.png");
		path3=file3.getAbsolutePath();

		new SwingWorker<Void , Void>(){
			protected Void doInBackground() throws Exception {
				//实现把图标放到指点lable
				setIcon(path1, lb1);			
				setIcon(path2, jp_jl1);
				setIcon(path3, jp_jl2);
				return null;
			}

		}.execute();


		JLabel jp_jl3 = new JLabel("用户名：");
		jp_jl3.setBounds(134, 50, 54, 15);
		panel_1.add(jp_jl3);

		JLabel jp_jl4 = new JLabel("\u5BC6\u7801\uFF1A");
		jp_jl4.setBounds(134, 102, 54, 15);
		panel_1.add(jp_jl4);

		jtf = new JTextField();
		jtf.setBounds(198, 47, 135, 21);
		panel_1.add(jtf);
		jtf.setColumns(10);

		JButton jb = new JButton("注册");
		jb.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {			
				Frame frame1=new Resist_View();		
				LogMView.this.dispose();


			}
		});
		jb.setBounds(137, 150, 93, 23);
		panel_1.add(jb);


		JButton jb_1 = new JButton("确定");	
		jb_1.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				list=new ArrayList<Custom_LogIn_Information>();
				list=Object_OutIn_Stream.in();
				Custom_LogIn_Information customer=null;
				for (Iterator<Custom_LogIn_Information> iterator = list.iterator(); iterator.hasNext();) {
					customer = (Custom_LogIn_Information) iterator.next();
					if((jtf.getText().equals("admin"))&&(textField.getText().equals("ADMIN999"))){					
						Frame framead =new AdminMainView();
						LogMView.this.dispose();
						x=1;
						break;

					}
					else if(customer.getName().equals(jtf.getText())&&customer.getPassWord().equals(textField.getText())){
						try {
							Frame frame=new CustomMainVView(customer);
							LogMView.this.dispose();
							x=1;
							break;
						} catch (Exception e1) {

							e1.printStackTrace();
						}						
					}				
				}	
				if(x==0){
					JOptionPane.showMessageDialog(LogMView.this, "大哥，你不会账号密码都忘记了吧？！还是说你需要赶紧注册个账号呀！");
				}

			}
		});

		jb_1.setBounds(240, 150, 93, 23);
		panel_1.add(jb_1);

		textField = new JTextField();
		textField.setBounds(198, 99, 135, 21);
		panel_1.add(textField);
		textField.setColumns(10);


	}

	//调用设置图标的函数
	public void setIcon(String file, JLabel iconLable) {  
		ImageIcon icon = new ImageIcon(file);  
		icon.getImage();
		Image temp = icon.getImage().getScaledInstance(iconLable.getWidth(),  
				iconLable.getHeight(), Image.SCALE_DEFAULT);  
		icon = new ImageIcon(temp);  
		iconLable.setIcon(icon);  
	}

}  

