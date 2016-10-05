package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import object.*;

public class Object_OutIn_Stream {

	//out从控制台写出到顾客登录文件
	public static boolean Out(ArrayList<Custom_LogIn_Information> list){

		File file=new File("customer_login_message.txt"); 
		ObjectOutputStream output=null;
		try {
			if(file.length()<1){
				output=new ObjectOutputStream(new FileOutputStream(file,true));	
			}
			else{
				output=new MyObjectOuPutStream(new FileOutputStream(file,true));
			}

			for (Iterator<Custom_LogIn_Information> iterator = list.iterator(); iterator.hasNext();) {							
				output.writeObject(iterator.next());	
			}
			output.close();

		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

		return true;	
	}


	//in从顾客的登录信息文件写进控制台
	public static ArrayList<Custom_LogIn_Information> in(){
		File file=new File("customer_login_message.txt"); 
		ArrayList<Custom_LogIn_Information> list=new ArrayList<Custom_LogIn_Information>();

		ObjectInputStream input=null;	

		try {
			input=new ObjectInputStream(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}	
		Custom_LogIn_Information customer=new Custom_LogIn_Information();
		try {
			while((customer=( Custom_LogIn_Information)input.readObject())!=null){
				list.add(customer);
			}
			input.close();
		} catch (ClassNotFoundException | IOException e) {
			// TODO 自动生成的 catch 块
			//e.printStackTrace();
		}
		return list;
	}

	//outDesk从控制台写出到桌子信息的文件
	public static boolean OutDesk(ArrayList<Desk> list){

		File file=new File("desk_information.txt"); 
		ObjectOutputStream output=null;
		try {
			if(file.length()<1){
				output=new ObjectOutputStream(new FileOutputStream(file,true));	
			}
			else{
				output=new MyObjectOuPutStream(new FileOutputStream(file,true));
			}

			for (Iterator<Desk> iterator = list.iterator(); iterator.hasNext();) {							
				output.writeObject(iterator.next());	
			}
			output.close();

		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

		return true;	
	}


	public static ArrayList<Desk> inDesk(){
		File file=new File("desk_information.txt"); 
		ArrayList<Desk> list=new ArrayList<Desk>();

		ObjectInputStream input=null;	

		try {
			input=new ObjectInputStream(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}	
		Desk desk=new Desk();
		try {
			while((desk=( Desk)input.readObject())!=null){
				list.add(desk);
			}
			input.close();
		} catch (ClassNotFoundException | IOException e) {
			// TODO 自动生成的 catch 块
			//e.printStackTrace();
		}
		return list;
	}

	public static ArrayList<Desk> inDesk(String a){
		File file=new File("desk_information.txt"); 
		ArrayList<Desk> list=new ArrayList<Desk>();

		ObjectInputStream input=null;	

		try {
			input=new ObjectInputStream(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}	
		Desk desk=new Desk();
		try {
			while((desk=( Desk)input.readObject())!=null){
				if(desk.getReserveMan().equals(a)){
					list.add(desk);	
				}
							}
			input.close();
		} catch (ClassNotFoundException | IOException e) {
			// TODO 自动生成的 catch 块
			//e.printStackTrace();
		}
		return list;
	}


	//outCai从控制台写出到cai信息的文件,但是写入文件每次都是重新写的
	public static boolean OutCai(ArrayList<Cai> list){

		File file=new File("cai.txt"); 
		ObjectOutputStream output=null;
		try {

			output=new ObjectOutputStream(new FileOutputStream(file));	

			for (Iterator<Cai> iterator = list.iterator(); iterator.hasNext();) {							
				output.writeObject(iterator.next());	
			}
			output.close();

		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return true;	
	}


	//incai从cai信息文件写进控制台

	public static ArrayList<Cai> inCai(){
		File file=new File("cai.txt"); 
		ArrayList<Cai> list=new ArrayList<Cai>();

		ObjectInputStream input=null;	

		try {
			input=new ObjectInputStream(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}	
		Cai cai=new Cai();
		try {
			while((cai=( Cai)input.readObject())!=null){
				list.add(cai);
			}
			input.close();
		} catch (ClassNotFoundException | IOException e) {
			// TODO 自动生成的 catch 块
			//e.printStackTrace();
		}
		return list;
	}
	
	
	//outCai从控制台写出到dingdan信息的文件
		public static boolean OutDingDan(ArrayList<Cai> list){
			File file=new File("dingdan.txt");
			ObjectOutputStream output=null;
			try {
				if(file.length()<1){
					output=new ObjectOutputStream(new FileOutputStream(file,true));	
				}
				else{
					output=new MyObjectOuPutStream(new FileOutputStream(file,true));
				}

				for (Iterator<Cai> iterator = list.iterator(); iterator.hasNext();) {							
					output.writeObject(iterator.next());	
				}
				output.close();

			} catch (FileNotFoundException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			return true;	
		}


		//indingdan从dingdan信息文件写进控制台
/**
 * 
 * @param file  是每个人的那个订单文件
 * @return 返回一个list
 */
		public static ArrayList<Cai> inDingDan(){
			File file=new File("dingdan.txt");
			ArrayList<Cai> list=new ArrayList<Cai>();

			ObjectInputStream input=null;	

			try {
				input=new ObjectInputStream(new FileInputStream(file));
			} catch (FileNotFoundException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}	
			Cai cai=new Cai();
			try {
				while((cai=( Cai)input.readObject())!=null){
					list.add(cai);
				}
				input.close();
			} catch (ClassNotFoundException | IOException e) {
				// TODO 自动生成的 catch 块
				//e.printStackTrace();
			}
			return list;
		}

		//outCai从控制台写出到dingdan信息的文件
		public static boolean OutGeRenDingDan(ArrayList<Cai> list,File file){
				ObjectOutputStream output=null;
				try {

					output=new ObjectOutputStream(new FileOutputStream(file));	

					for (Iterator<Cai> iterator = list.iterator(); iterator.hasNext();) {							
						output.writeObject(iterator.next());	
					}
					output.close();

				} catch (FileNotFoundException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				return true;	
			}


		//incai从cai信息文件写进控制台
/**
 * 
 * @param file  是每个人的那个订单文件
 * @return 返回一个list
 */
		public static ArrayList<Cai> inGeRenDingDan(File file){
			ArrayList<Cai> list=new ArrayList<Cai>();

			ObjectInputStream input=null;	

			try {
				input=new ObjectInputStream(new FileInputStream(file));
			} catch (FileNotFoundException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}	
			Cai cai=new Cai();
			try {
				while((cai=( Cai)input.readObject())!=null){
					list.add(cai);
				}
				input.close();
			} catch (ClassNotFoundException | IOException e) {
				// TODO 自动生成的 catch 块
				//e.printStackTrace();
			}
			return list;
		}

		
		
}