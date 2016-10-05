package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.io.File;
import java.lang.reflect.Field;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.SwingWorker;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import util.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminMainView extends JFrame {
	

	private JPanel contentPane;
		File file1,file2,file3,file4;
		String path1,path2,path3,path4;
		private JPanel panel_1;
		private JLabel lb3;
		private JLabel lb2;
		private JLabel lb;
		private JLabel lb1;
		String a;
	
	/**
	 * Create the frame.
	 */
		public AdminMainView() {
		super("欢迎进入管理员界面 ");
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(380, 90, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		 panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		lb1 = new JLabel("New label");
		lb1.setBounds(74, 59, 54, 50);
		panel_1.add(lb1);
		
		JButton btnNewButton = new JButton("\u9884\u5B9A");
		btnNewButton.addMouseListener(new MouseAdapter() {
			//预定
			public void mouseClicked(MouseEvent e) {
				new YuDing();
				AdminMainView.this.dispose();
				
			}
		});
		btnNewButton.setBounds(191, 73, 93, 23);
		panel_1.add(btnNewButton);
		
		
		
		JButton btnNewButton_1 = new JButton("\u7ED3\u8D26");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			a=JOptionPane.showInputDialog("你的电话号码是？");

			if(a!=null){
				new DingDanView(a);
				AdminMainView.this.dispose();
			}
			else{
				JOptionPane.showMessageDialog(AdminMainView.this,"你还没有输入手机号码");
			}
			}
		});
		btnNewButton_1.setBounds(191, 135, 93, 23);
		panel_1.add(btnNewButton_1);
		file1=new File("util_image/1.jpg");
		path1=file1.getAbsolutePath();	
		
		lb2 = new JLabel("New label");
	
		lb = new JLabel("New label");
		lb.setBounds(0, 0, 450, 39);
		panel_1.add(lb);
		lb.setBounds(0, 0, 450, 50);	
		panel_1.add(lb);
		
		
		lb2.setBounds(74, 119, 54, 50);
		panel_1.add(lb2);
		
		 lb3 = new JLabel("New label");
		 lb3.setBounds(74, 179, 54, 50);
		 panel_1.add(lb3);
		 
		 JButton btnNewButton_2 = new JButton("管理菜式");
		 btnNewButton_2.addMouseListener(new MouseAdapter() {
		//管理菜式
		 	public void mouseClicked(MouseEvent e) {
		 		new ManageView();
		 		AdminMainView.this.dispose();
		 	}
		 });
		 btnNewButton_2.setBounds(191, 194, 93, 23);
		 panel_1.add(btnNewButton_2);
		
		file2=new File("util_image/yuding.jpg");
		path2=file2.getAbsolutePath();
		file3=new File("util_image/maidan.jpg");
		path3=file3.getAbsolutePath();
		file4=new File("util_image/yeji.jpg");
		path4=file4.getAbsolutePath();
		
		
		
		
		new SwingWorker<Void, Void>(){

			protected Void doInBackground() throws Exception {
				 setLableIcon(path1, lb);
				 setLableIcon(path2,lb1);
				 setLableIcon(path3,lb2);
				 setLableIcon(path4,lb3);
				return null;
			}

			protected void done() {
	
				
			}
		
		}.execute();
		
	}
	
	
	//设置Lable图标的图像
	public void setLableIcon(String file, JLabel iconLable) {  
		ImageIcon icon = new ImageIcon(file);  
		icon.getImage();
		Image temp = icon.getImage().getScaledInstance(iconLable.getWidth(),  
				iconLable.getHeight(), Image.SCALE_DEFAULT);  
		icon = new ImageIcon(temp);  
		iconLable.setIcon(icon);  
	}
}
