package alarm;

import java.util.Calendar;

public class alarmMethod1 extends Thread{
	public Calendar cal = Calendar.getInstance();
	
	@Override
	public void run()  {
		while(true) {
			
			
		for(int i=0; i<alarm.alarmdateArray.length; i++) {
		if(alarm.alarmdateArray[i] !=null) {
		String dbdate=alarm.alarmdateArray[i].Date;
		int a =cal.get(Calendar.DAY_OF_WEEK);
		
		if(dbdate.equals(alarm.day.todaydate(a))){
			
			alarm.check2 =true;
		}
			}
		}
		
		
	try {
        Thread.sleep(3000);
    } catch (Exception e) {
    	e.printStackTrace();
    	System.exit(0);
    }
	}
}
}

