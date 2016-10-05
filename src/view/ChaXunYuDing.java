package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import view.*;
import object.Desk;
import util.Object_OutIn_Stream;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChaXunYuDing extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private JPanel panel;
	private JButton button;
	private JButton btnNewButton;


	public ChaXunYuDing(String a) {
		ArrayList<Desk> list	=Object_OutIn_Stream.inDesk(a);
		String string[][]=new String[list.size()][6];
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200,20, 900,680);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		button = new JButton("返回");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new YudingTable();
				ChaXunYuDing.this.dispose();
			}
		});
		panel.add(button);
		
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		for (int i = 0; i < string.length; i++) {			
			string[i][0]=list.get(i).getDeskNum();
			string[i][1]=list.get(i).getDeskStatement();
			string[i][2]=list.get(i).getReserveMan();
			string[i][3]=list.get(i).getPhone();
			string[i][4]=list.get(i).getReserveEatTime();
			string[i][5]=list.get(i).getReservePeopleNum();			
		table.setModel(new DefaultTableModel(
				string, new String[] {	"桌子号码","预定状态","预定者","手机号码","用餐时间","用餐人数"		}
			));
		table.setEnabled(false);		
		}
	}

}
