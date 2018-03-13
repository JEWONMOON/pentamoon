package alarm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import alarm.day;
public class alarm {
	public static AlarmTime[] alarmArray = new AlarmTime[100];
	public static AlarmTime[] alarmdateArray = new AlarmTime[100];
	public static AlarmTime[] alarmtimeArray = new AlarmTime[100];
	public static Scanner scan = new Scanner(System.in);
//	public static go ago = new go();
	public static alarmMethod am = new alarmMethod();
	public static alarmMethod1 am1 = new alarmMethod1();
	public static alarmMethod2 am2 = new alarmMethod2();
	
	static boolean check1;
	static boolean check2;

	public static day day = new day();

	
public static void main(String[] args) throws Exception {
	
	String path = "C://Alarm";
    File file5 = new File(path);
    if(!file5.exists()){
     file5.mkdirs();
    }// 디렉토리 생성
    System.out.println("저장된 알람을 자동으로 불러오는 중입니다.");
    File file1 = new File("C://Alarm//AlarmSetYear.txt");
    boolean isExists1 = file1.exists();
    File file2 = new File("C://Alarm//AlarmSetDate.txt");
    boolean isExists2 = file2.exists();
    File file3 = new File("C://Alarm//AlarmSetTime.txt");
    boolean isExists3 = file3.exists();
    
    
    if(isExists1 && isExists2 && isExists3) { 
    	AlarmRead();
    	 
    } else { 
    	System.out.println("저장된 알람이 없습니다."); }

    try {
    	
    	 am.start();
    	am1.start();
    	am2.start();
    		
    } catch (Exception e) {
    	System.exit(0);
    }


   
System.out.println();
   boolean run = true;		
	   while(run) {
		   System.out.println("----------------------------------------------------------");
			System.out.println("1.알람 기간 설정 | 2.알람시간 설정 |3.알람요일 설정 |4.알림 저장");
			System.out.println("5.알람 기간 확인 | 6.알람시간 확인 |7.알람요일 확인 |8.알림 불러오기");
			System.out.println("9.시작프로그램에 등록|10.종료");
			System.out.println("---------------------------------------------------------");
			System.out.println("원하는 기능의 숫자를 쓰고 Enter> ");
			
		

			int selectNo = scan.nextInt();
			
			if(selectNo == 1) {
				SetPeriod();
			} else if(selectNo == 2) {
				SetAlarm();
			} else if(selectNo == 3) {
				SetDate();
			} else if(selectNo == 4) {
				filewrite();
			}  else if(selectNo == 5) {
				AlarmList1();
			}  else if(selectNo == 6) {
				AlarmList2();
			}  else if(selectNo == 7) {
				AlarmList3();
			}  else if(selectNo == 8) {
				AlarmRead();
			}  else if(selectNo == 9) {
				register();
			}  else if(selectNo == 10) {
				run = false;
			}

			
			
	   }
		System.out.println("프로그램을 종료합니다.");
		System.exit(0);
}

public static void SetPeriod() {
	System.out.println("--------------");
	System.out.println("알람 유효기한 설정");
	System.out.println("--------------");
	
	System.out.print("년도(ex 2018): "); 
	int Year = scan.nextInt();

	
	System.out.print("월(ex 4): "); 
	int Month = scan.nextInt();
	
	System.out.print("일(ex 1): ");
	int Day = scan.nextInt();
	
	AlarmTime NewTime = new AlarmTime(Year,Month,Day);
	for(int i=0; i<alarmArray.length; i++) {
		if(alarmArray[i] == null) {
			alarmArray[i] = NewTime;
			System.out.println("알람 기한이 정해 졌습니다.");
			break;
		}
	}
	
}   

public static void AlarmList1() {
	
	System.out.println("--------------");
	System.out.println("알람목록");
	System.out.println("--------------");
	
	for(int i=0; i<alarmArray.length; i++) {
		AlarmTime NewTime = alarmArray[i];
		if(NewTime != null) {
			System.out.print(NewTime.Year);
			System.out.print("년");
			System.out.print(NewTime.Month);
			System.out.print("월");
			System.out.print(NewTime.Day);
			System.out.print("일까지 알람이 작동합니다.");
			System.out.println();
		}
		}
}


public static void SetDate() {
	
	System.out.println("--------------");
	System.out.println("주중 알람 시간 설정");
	System.out.println("--------------");
	
	
	System.out.println("알람을 원하는  요일(일,월,화,수,목,금,토) (ex 일): ");
	String Date = scan.next();
	
	AlarmTime  datealarmTime = new AlarmTime(Date);
	for(int i=0; i<alarmdateArray.length;i++) {
		if(alarmdateArray[i] == null) {
			alarmdateArray[i] = datealarmTime;
			break;
		}
	}
	
	
}
public static void AlarmList3() {
	System.out.println("--------------");
	System.out.println("주중 알람 요일 설정");
	System.out.println("--------------");
	
	for(int i=0; i<alarmdateArray.length; i++) {
		AlarmTime datealarmTime = alarmdateArray[i];
		if(datealarmTime != null) {
			System.out.print(datealarmTime.Date);
			System.out.print("요일에 알람이 울립니다.");
		
			System.out.println();		
	}
	}
		
}   

public static void SetAlarm() {
	
	
	System.out.print("원하는 알람 시간의'Hour'를 설정해 주세요(ex 10): "); 
	int Year = scan.nextInt();
		
	System.out.print("원하는 알람 시간의'Minute'를 설정해 주세요(ex 5): ");
	int Month = scan.nextInt();
	System.out.print("원하는 메시지안내를 (1-4)쓰세요 1.쉬는 시간 2.점심시간 3.자습시간 4.집에갈시간(ex 1): ");
	int Day =  scan.nextInt();
	
	AlarmTime  NewalarmTime = new AlarmTime(Year,Month,Day);
	for(int i=0; i<alarmtimeArray.length;i++) {
		if(alarmtimeArray[i] == null) {
			alarmtimeArray[i] = NewalarmTime;
			break;
		}
	}
	
}


public static void AlarmList2() {
		for(int i=0; i<alarmtimeArray.length; i++) {
			AlarmTime NewalarmTime = alarmtimeArray[i];
			if(NewalarmTime != null) {
				System.out.print(NewalarmTime.Year);
				System.out.print("시 ");
				System.out.print(NewalarmTime.Month);
				System.out.print("분에 ");
				System.out.print(NewalarmTime.Day);
				System.out.print("번 메세지가 출력이 됩니다");
				System.out.println();
	
		}
		}
	}
           
  static void filewrite() throws IOException { 
	  
	    System.out.println("--------------");
		System.out.println("알림을 저장중입니다.");
		System.out.println("--------------");
			 
      PrintWriter aMM = new PrintWriter("C://Alarm//AlarmSetYear.txt"); 
            for(int i=0; i<alarm.alarmArray.length; i++) {
    			if(alarm.alarmArray[i] !=null) {
    		int dbyear=alarm.alarmArray[i].Year;
    		int	dbmonth=alarm.alarmArray[i].Month;
    		int dbday=alarm.alarmArray[i].Day;
                
    		aMM.println(dbyear);
    		aMM.println(dbmonth);
    		aMM.println(dbday);
                
                
            }
            }
            aMM.close();
          
     PrintWriter aM3 = new PrintWriter("C://Alarm//AlarmSetDate.txt");
            
     		for(int i=0; i<alarm.alarmdateArray.length; i++) {
    		if(alarm.alarmdateArray[i] !=null) {
    		String dbdate=alarm.alarmdateArray[i].Date;
                
                aM3.println(dbdate);
            }
     		}
            aM3.close();
  
            
     PrintWriter aM5 = new PrintWriter("C://Alarm//AlarmSetTime.txt");
            
     for( int j=0; j<alarm.alarmtimeArray.length; j++) {
    		
    		if(alarm.alarmtimeArray[j] !=null) {
    			int dbhour = alarm.alarmtimeArray[j].Year;
    			int dbminute=alarm.alarmtimeArray[j].Month;
    			int num =  alarm.alarmtimeArray[j].Day;
    		
                aM5.println(dbhour);
                aM5.println(dbminute);
                aM5.println(num);
                
                
            }
     }
            aM5.close();

             System.out.println("-------------------");
        	System.out.println("알람 저장이 완료되었습니다.");
        	System.out.println("-------------------");
           
        }
		
static void AlarmRead() throws IOException {
	
	
 	System.out.println("저장된 알림을 읽어 오는 중입니다....");
 	System.out.println("저장된 알림이 있는지 확인 합니다.");
 	File file1 = new File("C://Alarm//AlarmSetYear.txt");
    boolean isExists1 = file1.exists();
    File file2 = new File("C://Alarm//AlarmSetDate.txt");
    boolean isExists2 = file2.exists();
    File file3 = new File("C://Alarm//AlarmSetTime.txt");
    boolean isExists3 = file3.exists();
    
    
    if(isExists1 && isExists2 && isExists3) { 
    
   
	
	try{
        //파일 객체 생성
        File file = new File("C://Alarm//AlarmSetYear.txt");
        //스캐너로 파일 읽기
        Scanner scan = new Scanner(file);
        while(scan.hasNextInt()){
       	int Year = scan.nextInt();
       	int Month = scan.nextInt();
       	int Day = scan.nextInt();
       	
       	AlarmTime NewYear = new AlarmTime(Year,Month,Day);
       	for(int i=0; i<alarm.alarmArray.length; i++) {
       		if(alarm.alarmArray[i] == null) {
       			alarm.alarmArray[i] = NewYear;
       		break;	
       		}
       	}
        }
        //System.out.println(scan.useDelimiter("\\z").next());
    }catch (FileNotFoundException e) {
     
    }

	BufferedReader cr = new BufferedReader(new FileReader("C://Alarm//AlarmSetDate.txt"));
    while(true) {
    	
    	
    	String dbdate= cr.readLine();
        if (dbdate==null) break;
       	AlarmTime  datealarmTime = new AlarmTime(dbdate);
    	for(int i=0; i<alarm.alarmdateArray.length;i++) {
    		if(alarm.alarmdateArray[i] == null) {
    			alarm.alarmdateArray[i] = datealarmTime;
    			break;
    		}
    	}
		
    }
    cr.close();
    
	 try{
        //파일 객체 생성
        File file = new File("C://Alarm//AlarmSetTime.txt");
        //스캐너로 파일 읽기
        Scanner scan = new Scanner(file);
        while(scan.hasNextInt()){
       	int Year = scan.nextInt();
       	int Month = scan.nextInt();
       	int Day = scan.nextInt();
       	
       	AlarmTime  NewalarmTime = new AlarmTime(Year,Month,Day);
       	for(int i=0; i<alarm.alarmtimeArray.length;i++) {
       		
       		if(alarm.alarmtimeArray[i] == null) {
       			
       			alarm.alarmtimeArray[i] = NewalarmTime;
       			break;
       		}
       		
       	}
        }
        //System.out.println(scan.useDelimiter("\\z").next());
    }catch (FileNotFoundException e) {
        // TODO: handle exception
    }
	 System.out.println("-------------------");
 	System.out.println("블러오기가 완료되었습니다.");
 	System.out.println("-------------------");
    } else { 
    	System.out.println("저장된 알람이 없습니다."); }

}


	public static void register() throws IOException {
		
		Path file = Paths.get(System.getProperty("user.dir")+ "\\alarm1.exe");

		Path movePath = Paths.get("C:\\ProgramData\\Microsoft\\Windows\\Start Menu\\Programs\\StartUp");
		 
		Files.move(file , movePath .resolve(file .getFileName()));
		
		System.out.println("시작프로그램으로 잘 등록되었습니다.");
}
}