package object;

import java.io.Serializable;

public class Desk implements Serializable {
		private String deskNum;
		private String deskStatement;
		private String reserveMan;
		private String phone;	
		private String reserveEatTime;
		private String reservePeopleNum;
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
	
		public String getDeskStatement() {
			return deskStatement;
		}
		public void setDeskStatement(String deskStatement) {
			this.deskStatement = deskStatement;
		}
		public String getReserveMan() {
			return reserveMan;
		}
		public void setReserveMan(String reserveMan) {
			this.reserveMan = reserveMan;
		}
		public String getReserveEatTime() {
			return reserveEatTime;
		}
		public void setReserveEatTime(String reserveEatTime) {
			this.reserveEatTime = reserveEatTime;
		}
	
		public String getDeskNum() {
			return deskNum;
		}
		public void setDeskNum(String deskNum) {
			this.deskNum = deskNum;
		}
		public String getReservePeopleNum() {
			return reservePeopleNum;
		}
		public void setReservePeopleNum(String reservePeopleNum) {
			this.reservePeopleNum = reservePeopleNum;
		}
		public Desk(){
			
		}
		public Desk(	String deskNum,String deskStatement, String reserveMan,String phone,String reserveEatTime,String reservePeopleNum){
					this.deskNum=deskNum;
					this.deskStatement=deskStatement;
					this.reserveEatTime=reserveEatTime;
					this.reserveMan=reserveMan;
					this.phone=phone;
					this.reservePeopleNum=reservePeopleNum;		
		}
}
