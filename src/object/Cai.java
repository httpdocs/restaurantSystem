package object;

import java.awt.Frame;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.basic.BasicToolBarUI.DockingListener;

import util.ImagePanel;
import util.Object_OutIn_Stream;
import view.LogMView;
import view.Resist_View;

public class Cai implements Serializable{
		private String caiName;
		private String caiJia;
		File file=new File("cai_image/chu.jpg");
		int  caiNumber=0;
		
		public int getCaiNumber() {
			return caiNumber;
		}
		public void setCaiNumber(int caiNumber) {
			this.caiNumber = caiNumber;
		}
		public File getFile() {
			return file;
		}
		public void setFile(File file) {
			this.file = file;
		}
		public String getCaiName() {
			return caiName;
		}
		public void setCaiName(String caiName) {
			this.caiName = caiName;
		}
		public String getCaiJia() {
			return caiJia;
		}
		public void setCaiJia(String caiJia) {
			this.caiJia = caiJia;
		}
		public Cai(){
			
		}
		public Cai(String caiName,String  caiJia){
			this.caiName=caiName;
			this.caiJia=caiJia;
			
		}
		
		/**
		 * 调用该方法可以返回一个panel
		 * @return  panel
		 */
			public JPanel DrawPanel(File file){
				JPanel jp=new JPanel();
				ImagePanel ip;
				Image im =null;			
				try {
					im = ImageIO.read(new File(file.getAbsolutePath()));
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				ip=new ImagePanel(im);			
				
				 jp.setLayout(null);
				 jp.setSize(920,170);
				 jp.add(ip);
				JLabel lblNewLabel_1 = new JLabel("\u83DC\u540D\uFF1A");
				lblNewLabel_1.setBounds(339, 26, 76, 15);
				 jp.add(lblNewLabel_1);
				
				JLabel label_2 = new JLabel("\u4EF7\u683C\uFF1A");
				label_2.setBounds(339, 65, 76, 15);
				 jp.add(label_2);
				
				JButton btnNewButton = new JButton(this.getCaiName());
				btnNewButton.setBounds(437, 22, 157, 23);
				 jp.add(btnNewButton);
				 
				JButton btnNewButton_1 = new JButton(this.getCaiJia());
				btnNewButton_1.setBounds(437, 61, 157, 23);
				 jp.add(btnNewButton_1);
				
				JButton btnNewButton2 = new JButton("重新上传菜的图片");
				btnNewButton2.setBounds(437, 100, 157, 23);
				 jp.add(btnNewButton2);
				 btnNewButton2.addMouseListener(new MouseAdapter() {
						//重新上传图片
						public void mouseClicked(MouseEvent e) {	
							JFileChooser chooser=new JFileChooser();
							FileNameExtensionFilter filter=new FileNameExtensionFilter("允许的文件类型是jpg类型图片", "jpg");//文件过滤器
							chooser.setFileFilter(filter);//文件过滤器的设定  需要在打开浏览窗口前设定
							
							int value=chooser.showOpenDialog(null);
							if(value==JFileChooser.APPROVE_OPTION){
								File file1=chooser.getSelectedFile();
								try {
									FileInputStream B = new FileInputStream(chooser.getSelectedFile().getAbsolutePath());
									BufferedInputStream C = new BufferedInputStream(B,100);
									FileOutputStream D = new FileOutputStream("image/"+chooser.getSelectedFile().getName());
									BufferedOutputStream E = new BufferedOutputStream(D,100);
									byte[] input = new byte[50];
									int i;
									while((i=C.read(input))!=-1){
										String F = new String(input, 0, i);
										E.write(input, 0, i);
									}
									E.flush();
									E.close();
									C.close();
									D.close();
									B.close();
								} catch (FileNotFoundException e1) {
									// TODO 自动生成的 catch 块
									e1.printStackTrace();
								} catch (IOException e1) {
									// TODO 自动生成的 catch 块
									e1.printStackTrace();
								}	
								setFile(file1);
							}
						}
							
				 });
				 
				JLabel lblNewLabel = new JLabel(new ImageIcon("util_image/zaocanmilk.png"));
				lblNewLabel.setBounds(242, 10, 60, 40);
				 jp.add(lblNewLabel);
				
				JLabel label = new JLabel(new ImageIcon("util_image/f.jpg"));
				label.setBounds(242, 55, 60, 40);
				 jp.add(label);
				
				JLabel lblNewLabel_5 = new JLabel(new ImageIcon("util_image/zj.jpg"));
				lblNewLabel_5.setBounds(633, 23, 25, 27);
				 jp.add(lblNewLabel_5);
				
				JLabel label_1 = new JLabel(new ImageIcon("util_image/js.jpg"));
				label_1.setBounds(670, 23, 25, 27);
				 jp.add(label_1);
				

				return  jp;
			}
			
			public JPanel DrawPanel3(File file){
				ArrayList< Cai>  dingDanlist=new ArrayList<Cai>();
				JPanel jp=new JPanel();
				ImagePanel ip;
				Image im =null;			
				try {
					im = ImageIO.read(new File(file.getAbsolutePath()));
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				ip=new ImagePanel(im);							
				 jp.setLayout(null);
				 jp.setSize(920,170);
				 jp.add(ip);
				 
				JLabel lblNewLabel_1 = new JLabel("\u83DC\u540D\uFF1A");
				lblNewLabel_1.setBounds(339, 26, 76, 15);
				 jp.add(lblNewLabel_1);
				
				JLabel label_2 = new JLabel("\u4EF7\u683C\uFF1A");
				label_2.setBounds(339, 65, 76, 15);
				 jp.add(label_2);
				
				JButton btnNewButton = new JButton(this.getCaiName());
				btnNewButton.setBounds(437, 22, 157, 23);
				 jp.add(btnNewButton);
				 
				JButton btnNewButton_1 = new JButton(this.getCaiJia());
				btnNewButton_1.setBounds(437, 61, 157, 23);
				 jp.add(btnNewButton_1);
				 
				JLabel lblNewLabel = new JLabel(new ImageIcon("util_image/zaocanmilk.png"));
				lblNewLabel.setBounds(242, 10, 60, 40);
				 jp.add(lblNewLabel);
				
				JLabel label = new JLabel(new ImageIcon("util_image/f.jpg"));
				label.setBounds(242, 55, 60, 40);
				 jp.add(label);
				
				 JLabel jb=new JLabel("数量："+Cai.this.getCaiNumber());
				 jb.setBounds(633,23,50,50);
				 jp.add(jb);
					 
				return  jp;
			}
			
			
			
			
			
			
			
			
			
			public JPanel DrawPanel2(File file){
				ArrayList< Cai>  dingDanlist=new ArrayList<Cai>();
				JPanel jp=new JPanel();
				ImagePanel ip;
				Image im =null;			
				try {
					im = ImageIO.read(new File(file.getAbsolutePath()));
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				ip=new ImagePanel(im);							
				 jp.setLayout(null);
				 jp.setSize(920,170);
				 jp.add(ip);
				 
				JLabel lblNewLabel_1 = new JLabel("\u83DC\u540D\uFF1A");
				lblNewLabel_1.setBounds(339, 26, 76, 15);
				 jp.add(lblNewLabel_1);
				
				JLabel label_2 = new JLabel("\u4EF7\u683C\uFF1A");
				label_2.setBounds(339, 65, 76, 15);
				 jp.add(label_2);
				
				JButton btnNewButton = new JButton(this.getCaiName());
				btnNewButton.setBounds(437, 22, 157, 23);
				 jp.add(btnNewButton);
				 
				JButton btnNewButton_1 = new JButton(this.getCaiJia());
				btnNewButton_1.setBounds(437, 61, 157, 23);
				 jp.add(btnNewButton_1);
				 
				JLabel lblNewLabel = new JLabel(new ImageIcon("util_image/zaocanmilk.png"));
				lblNewLabel.setBounds(242, 10, 60, 40);
				 jp.add(lblNewLabel);
				
				JLabel label = new JLabel(new ImageIcon("util_image/f.jpg"));
				label.setBounds(242, 55, 60, 40);
				 jp.add(label);
				
				JLabel lblNewLabel_5 = new JLabel(new ImageIcon("util_image/zj.jpg"));
				lblNewLabel_5.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {			
						Cai.this.caiNumber=Cai.this.getCaiNumber()+1;
						Cai.this.setCaiNumber(Cai.this.caiNumber);
						System.out.println(Cai.this.caiNumber);
					}
				});
				lblNewLabel_5.setBounds(633, 23, 25, 27);
				 jp.add(lblNewLabel_5);
				
				JLabel label_1 = new JLabel(new ImageIcon("util_image/js.jpg"));
				label_1.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {			
						Cai.this.caiNumber=Cai.this.getCaiNumber()-1;
						Cai.this.setCaiNumber(Cai.this.caiNumber);
						System.out.println(Cai.this.caiNumber);
					}
				});
				label_1.setBounds(670, 23, 25, 27);
				 jp.add(label_1);
				return  jp;
			}
			
	
			
}
		

