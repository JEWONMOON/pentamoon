package alarm;

import java.util.Calendar;


public class alarmMethod extends Thread {
	
@Override
	public  void run() {

		while(true) {
			 Calendar cal = Calendar.getInstance();		
		//	System.out.println(alarm.check1);
		for(int i=0; i<alarm.alarmArray.length; i++) {
			if(alarm.alarmArray[i] !=null) {
		int dbyear=alarm.alarmArray[i].Year;
		int	dbmonth=alarm.alarmArray[i].Month;
		int dbday=alarm.alarmArray[i].Day;
		
//		System.out.println(dbyear);
//		System.out.println(dbmonth);
//		System.out.println(dbday);
//		System.out.println(alarm.check1);
//		
//		
//		System.out.println(cal.get(Calendar.YEAR));
//		System.out.println(cal.get(Calendar.MONTH)+1);
//		System.out.println(cal.get(Calendar.DATE));
//		System.out.println(alarm.check2);
		 
		if(dbyear>=cal.get(Calendar.YEAR) && dbmonth >= cal.get(Calendar.MONTH)+1&&
				dbday>=cal.get(Calendar.DATE)) {
			
			alarm.check1 =true;
		
		}
		
		}
		}
		
		
	try {
        Thread.sleep(3000);
    } catch (InterruptedException e) {
    	e.printStackTrace();
    	
    }		
	}
}
}


