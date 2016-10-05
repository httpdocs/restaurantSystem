package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.crypto.Data;

import object.Desk;
import util.Object_OutIn_Stream;

import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Yudingview extends JFrame {

	private JPanel contentPane;
	private JTextField txtA;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JButton button_3;
	private JButton button_4;
	private JButton button_5;
	private JLabel imageLb;
	private JButton button_6;

	public Yudingview(String a) {
		setVisible(true);
		Desk desk=new Desk();
		ArrayList<Desk> list =new ArrayList<Desk>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 90, 385, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		
		textField_1 = new JTextField();
		textField_1.setBounds(176, 149, 173, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setText(a);
		lblNewLabel.setBounds(176, 107, 173, 15);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.addMouseListener(new MouseAdapter() {		
			public void mouseClicked(MouseEvent e) {
							desk.setDeskNum(lblNewLabel.getText());
							desk.setDeskStatement(textField_1.getText());
							desk.setReserveMan(textField_2.getText());
							desk.setPhone(textField_3.getText());
							desk.setReserveEatTime(textField_4.getText());
							desk.setReservePeopleNum(textField_5.getText());
							list.add(desk);
							
							if(Object_OutIn_Stream.OutDesk(list)==true){
								JOptionPane.showMessageDialog( Yudingview.this,"成功预订");											
							}
					
			}
		});
		btnNewButton.setBounds(256, 373, 93, 23);
		panel.add(btnNewButton);
		
		textField_2 = new JTextField();
		textField_2.setBounds(176, 199, 173, 21);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(176, 251, 173, 21);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(176, 299, 173, 21);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(176, 342, 173, 21);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		JButton button = new JButton("\u684C\u53F7");
		button.setBounds(10, 103, 116, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("\u9884\u5B9A\u72B6\u6001");
		button_1.setBounds(10, 148, 116, 23);
		panel.add(button_1);
		
		JButton button_2 = new JButton("\u9884\u5B9A\u8005");
		button_2.setBounds(10, 198, 116, 23);
		panel.add(button_2);
		
		button_3 = new JButton("\u624B\u673A\u53F7\u7801");
		button_3.setBounds(10, 250, 116, 23);
		panel.add(button_3);
		
		button_4 = new JButton("\u7528\u9910\u65F6\u95F4");
		button_4.setBounds(10, 298, 116, 23);
		panel.add(button_4);
		
		button_5 = new JButton("\u7528\u9910\u4EBA\u6570");
		button_5.setBounds(10, 341, 116, 23);
		panel.add(button_5);
		
		//添加一个 图片，刚弄的时候老是出错，注意用一个try-catch
		imageLb = new JLabel();
		
		try {
			ImageIcon icon =new ImageIcon("util_image/heng4.jpg");
			icon.getImage();
			Image temp = icon.getImage().getScaledInstance(359,79, Image.SCALE_DEFAULT);  
			icon = new ImageIcon(temp);  
			imageLb.setIcon(icon);
		} catch (Exception e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}  
		imageLb.setBounds(0, 0, 359, 79);
		panel.add(imageLb);
		
		button_6 = new JButton("\u8FD4\u56DE");
		button_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				new YuDing();
				Yudingview.this.dispose();
			}
		});
		button_6.setBounds(153, 373, 93, 23);
		panel.add(button_6);
		

		
		
}
}


























