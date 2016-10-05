package view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import object.Cai;
import util.ImagePanel;
import util.Object_OutIn_Stream;

import javax.swing.JScrollPane;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Cursor;

public class ManageView extends JFrame {
	ArrayList<Cai> list= new ArrayList<Cai>();

	private JPanel contentPane=null;
	private JPanel panel=null;

	/**
	 * Create the frame.
	 */
	public ManageView() {	
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(200, 0, 950, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelSouth = new JPanel();
		contentPane.add(panelSouth, BorderLayout.NORTH);
		panelSouth.setLayout(new BorderLayout(0, 0));
				
		//处理北部的panel
		panelSouth.setLayout(new FlowLayout());
		JButton ps_jb1=new JButton("增加菜式",new ImageIcon("util_image/zaocanmilk.png"));
		panelSouth.add(ps_jb1);
		ps_jb1.addMouseListener(new MouseAdapter() {
			//预定
			public void mouseClicked(MouseEvent e) {	
				String b = null;String a=null;
				Cai cai=new Cai();
				a=JOptionPane.showInputDialog("输入你想加入的菜的名字");
				if(a!=null){
				cai.setCaiName(a);
				 b=JOptionPane.showInputDialog("输入你这道菜的价格");
				 if(b!=null){
					 
				 cai.setCaiJia(b);
				 list.add(cai);
				
				Object_OutIn_Stream.OutCai(list);		
				 }
				}
				}	
			});

	
		JButton ps_jb2=new JButton("删除菜式",new ImageIcon("util_image/zaocanmilk.png"));
		panelSouth.add(ps_jb2);
		ps_jb2.addMouseListener(new MouseAdapter() {
			//删除
			public void mouseClicked(MouseEvent e) {	
				String a;
				int lable=0;
				a=JOptionPane.showInputDialog("输入你想删除的菜的名字");
				
				Cai cai=new Cai();
				list=Object_OutIn_Stream.inCai();
				for (Iterator<Cai> iterator = list.iterator(); iterator.hasNext();) {
					Cai cai2 = (Cai) iterator.next();
					if(cai2.getCaiName().equals(a)){
						list.remove(cai2);
						lable=1;
					}				
				}
				if(	lable==1)
				Object_OutIn_Stream.OutCai(list);		
				}
		
		});
		
		JButton ps_jb3=new JButton("刷新",new ImageIcon("util_image/zaocanmilk.png"));
		panelSouth.add(ps_jb3);
		ps_jb3.addMouseListener(new MouseAdapter() {
			//预定
			public void mouseClicked(MouseEvent e) {	
				Object_OutIn_Stream.OutCai(list);
				ManageView f=new ManageView();
				ManageView.this.dispose();
				}
		
		});
		
		JButton ps_jb4=new JButton("返回",new ImageIcon("util_image/zaocanmilk.png"));
		panelSouth.add(ps_jb4);
		ps_jb4.addMouseListener(new MouseAdapter() {
			//预定
			public void mouseClicked(MouseEvent e) {	
			new AdminMainView();
			ManageView.this.dispose();
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
								p= cai.DrawPanel(cai.getFile());
			group.addComponent(p, GroupLayout.PREFERRED_SIZE, 920, GroupLayout.PREFERRED_SIZE);
			group2.addComponent(p, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE);
			}
			
			gl_panelCenter.setHorizontalGroup(group);
			gl_panelCenter.setVerticalGroup(group2);
			panelCenter.setLayout(gl_panelCenter);
			
	}
}
