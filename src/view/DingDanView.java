package view;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.border.EmptyBorder;

import object.Cai;
import object.Custom_LogIn_Information;
import util.Object_OutIn_Stream;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DingDanView extends JFrame {
	File file;
	ArrayList<Cai> list=new ArrayList<Cai>();
	private JPanel contentPane;
	
	public DingDanView(String phone){
		super("你的订单详情");
		file=new File(String.format("%sdingdan.txt", phone));
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(160, 20, 930, 670);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton button = new JButton("\u8FD4\u56DE");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new AdminMainView();
				DingDanView.this.dispose();
			}
		});
		
		JPanel panelx = new JPanel();
		contentPane.add(panelx, BorderLayout.SOUTH);
		JButton btnNewButton = new JButton("返回");
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		new AdminMainView();
		DingDanView.this.dispose();
			}
		});
		panelx.add(btnNewButton);
		
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

			list=Object_OutIn_Stream.inGeRenDingDan(file);
			for (Iterator<Cai> iterator = list.iterator(); iterator.hasNext();) {
										Cai cai = (Cai) iterator.next();
										JPanel p=new JPanel();
										p=cai.DrawPanel3(cai.getFile());
			group.addComponent(p, GroupLayout.PREFERRED_SIZE, 920, GroupLayout.PREFERRED_SIZE);
			group2.addComponent(p, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE);
			}
			
			gl_panelCenter.setHorizontalGroup(group);
			gl_panelCenter.setVerticalGroup(group2);
			panelCenter.setLayout(gl_panelCenter);
		
		
	}
	
	public DingDanView(Custom_LogIn_Information custom) {
		super("你的订单详情");
		file=new File(String.format("%sdingdan.txt", custom.getPhone()));
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(160, 20, 930, 670);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton button = new JButton("\u8FD4\u56DE");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new CustomMainVView(custom);
				DingDanView.this.dispose();
			}
		});
		
		JButton btnNewButton = new JButton("结账");
	
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			JOptionPane.showMessageDialog(DingDanView.this, "请稍等，服务员正在路上。");
			}
		});
		panel.add(btnNewButton);
		panel.add(button);
		

		
		
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

			list=Object_OutIn_Stream.inGeRenDingDan(file);
			for (Iterator<Cai> iterator = list.iterator(); iterator.hasNext();) {
										Cai cai = (Cai) iterator.next();
										JPanel p=new JPanel();
										p=cai.DrawPanel3(cai.getFile());
			group.addComponent(p, GroupLayout.PREFERRED_SIZE, 920, GroupLayout.PREFERRED_SIZE);
			group2.addComponent(p, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE);
			}
			
			gl_panelCenter.setHorizontalGroup(group);
			gl_panelCenter.setVerticalGroup(group2);
			panelCenter.setLayout(gl_panelCenter);
	}
	
	}

