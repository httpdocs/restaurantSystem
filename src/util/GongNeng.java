package util;

import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class GongNeng {
		
	
	//得到文件的路径
		public  String getPath(File file){
			
			return file.getAbsolutePath();		
		
		}
			//设置Lable图标的图像
			public void setLableIcon(String path, JLabel iconLable) {  
				ImageIcon icon = new ImageIcon(path);  
				icon.getImage();
				Image temp = icon.getImage().getScaledInstance(iconLable.getWidth(),  
						iconLable.getHeight(), Image.SCALE_DEFAULT);  
				icon = new ImageIcon(temp);  
				iconLable.setIcon(icon);  
			}
			
			
			//设置Button图标的图像
			public void setButtonIcon(String path, JButton iconLable) {  
				ImageIcon icon = new ImageIcon(path);  
				try {
					icon.getImage();
					Image temp = icon.getImage().getScaledInstance(iconLable.getWidth(),  
							iconLable.getHeight(), Image.SCALE_DEFAULT);  
					icon = new ImageIcon(temp);  
					iconLable.setIcon(icon);
				} catch (Exception e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}  
			}
			
			public GongNeng() {
				
			}
}
