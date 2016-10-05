package util;

import javax.swing.JPanel;
import javax.swing.*;
import javax.imageio.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
//动态加载一个图片做背景
public class ImagePanel  extends JPanel{
			
		Image im;
		public ImagePanel( Image  im){
			this.im= im;
			int w=170,h=170;
			this.setSize(w,h);
		}	
		
		//画组件jpanel
		public void paintComponent(Graphics g){
			//清屏
			super.paintComponent(g);		
			g.drawImage(im, 0,0 ,170,170 ,this );

		}
}
