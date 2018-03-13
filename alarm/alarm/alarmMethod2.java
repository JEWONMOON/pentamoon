package alarm;

import java.util.Calendar;

import javax.swing.JFrame;



public class alarmMethod2 extends Thread {
	
	@Override
	public void run() {	
		
		try {
		      Thread.sleep(1000);
   
      } catch (InterruptedException e) {
      	System.exit(0);
      }	
		
		while(true) {
			Calendar cal = Calendar.getInstance();
			int time = cal.get(Calendar.HOUR);
			int time2 = cal.get(Calendar.MINUTE);
			
						
			boolean checkb=alarm.check1;
			boolean checkb1=alarm.check2;
		if(checkb&&checkb1) {
			
		for( int j=0; j<alarm.alarmtimeArray.length; j++) {
			
			if(alarm.alarmtimeArray[j] !=null) {
				int dbhour = alarm.alarmtimeArray[j].Year;
				int dbminute=alarm.alarmtimeArray[j].Month;
				int num =  alarm.alarmtimeArray[j].Day;
//			
//				System.out.println(dbhour);
//				System.out.println(dbminute);
//				System.out.println(cal.get(Calendar.HOUR));
//				System.out.println(cal.get(Calendar.MINUTE));
//				
				
		if((dbhour == time) && (dbminute==time2)){
			
		if(num==1) {
					MainFrame.abc=1; message();}
		else if(num==2) {
					MainFrame.abc=2; message();}
		else if(num==3) {
					MainFrame.abc=3; message(); }
		else if(num==4) {
					MainFrame.abc=4; message(); }
			}
			}
		}
		}
		try {
		       alarm.check2 =false;
	            alarm.check2 =false;
            Thread.sleep(1000);
     
        } catch (InterruptedException e) {
        	System.exit(0);
        }	
}
		}
		



public void message() {
	 try{
         //예외가 발생할 가능성이 있는 소스코드 작성
    
	MainFrame dlg = new MainFrame();
	//JOptionPane.showMessageDialog(null, "쉬는시간입니다","알림", JOptionPane.YES_OPTION, null);
	dlg.setExtendedState(JFrame.NORMAL);
	   dlg.setAlwaysOnTop(true);
	 dlg.setAlwaysOnTop(false);
	 

	 }catch(Exception e){
		 System.exit(0);
		 //처리문장 작성
     }
}


}
