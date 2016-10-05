package view;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import object.Cai;
import object.Custom_LogIn_Information;
import util.FileOperation;
import util.Object_OutIn_Stream;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;

public class CustomMainVView extends JFrame {

	private JPanel contentPane;
	ArrayList<Cai> list=new ArrayList<Cai>();
	ArrayList<Cai> dingdanlist=new ArrayList<Cai>();
	File filedingdan;
	

	
	public CustomMainVView(Custom_LogIn_Information custom_LogIn_Information) {
		
	super(String.format("欢迎【%s】顾客来到蒙肥羊自助餐厅点餐系统",custom_LogIn_Information.getName() ));
		filedingdan=new File(String.format("%sdingdan.txt", custom_LogIn_Information.getPhone()));
		FileOperation fo=new FileOperation();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(90, 10, 950, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JButton button_1 = new JButton("查看订单");
		panel.add(button_1);
		button_1.addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {				
		new DingDanView(custom_LogIn_Information);
		CustomMainVView.this.dispose();
			}
		});
		
		JButton button_2 = new JButton("确认订单");
		panel.add(button_2);
		button_2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {			
			
				for (Iterator iterator = list.iterator(); iterator.hasNext();) {
					Cai cai = (Cai) iterator.next();
					if(cai.getCaiNumber()>0){
						dingdanlist.add(cai);
					}					
				}
				if(!filedingdan.exists()){
					fo.createFile(filedingdan);
				}if(dingdanlist.size()>=1){
				Object_OutIn_Stream.OutGeRenDingDan(dingdanlist, filedingdan);
				Object_OutIn_Stream.OutDingDan(dingdanlist);
				System.out.println("已经写进这个顾客的订单文件里面了");
				}
				else{
					JOptionPane.showMessageDialog(CustomMainVView.this, "你什么菜都还没点哦！");
				}
			}
		});
		
		JButton button = new JButton("结账");
		panel.add(button);
		button.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {			
				JOptionPane.showMessageDialog(CustomMainVView.this, "请稍等，服务员正在路上！");
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JPanel panelCenter = new JPanel();
		panelCenter.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		scrollPane.setViewportView(panelCenter);
		panelCenter.setLayout(new BorderLayout(0, 0));
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		GroupLayout gl_panelCenter = new GroupLayout(panelCenter);
		
		//设置水平横条不显示
		ParallelGroup group=gl_panelCenter.createParallelGroup(Alignment.LEADING);
		SequentialGroup group2 = gl_panelCenter.createSequentialGroup();		

			list=	Object_OutIn_Stream.inCai();
			for (Iterator<Cai> iterator = list.iterator(); iterator.hasNext();) {
										Cai cai = (Cai) iterator.next();
										JPanel p=new JPanel();
										p=cai.DrawPanel2(cai.getFile());
			group.addComponent(p, GroupLayout.PREFERRED_SIZE, 920, GroupLayout.PREFERRED_SIZE);
			group2.addComponent(p, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE);
			}
			
			gl_panelCenter.setHorizontalGroup(group);
			gl_panelCenter.setVerticalGroup(group2);
			panelCenter.setLayout(gl_panelCenter);
	}
			
}
