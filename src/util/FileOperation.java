package util;

import java.io.File;
import java.io.IOException;

public class FileOperation {
		public static boolean createFile(File fileName){
			boolean flag=false;
			try {
				if(!fileName.exists()){
					fileName.createNewFile();
					flag=true;
				}
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			return flag;
		}
}
