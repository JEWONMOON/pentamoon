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
    }// ���丮 ����
    System.out.println("����� �˶��� �ڵ����� �ҷ����� ���Դϴ�.");
    File file1 = new File("C://Alarm//AlarmSetYear.txt");
    boolean isExists1 = file1.exists();
    File file2 = new File("C://Alarm//AlarmSetDate.txt");
    boolean isExists2 = file2.exists();
    File file3 = new File("C://Alarm//AlarmSetTime.txt");
    boolean isExists3 = file3.exists();
    
    
    if(isExists1 && isExists2 && isExists3) { 
    	AlarmRead();
    	 
    } else { 
    	System.out.println("����� �˶��� �����ϴ�."); }

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
			System.out.println("1.�˶� �Ⱓ ���� | 2.�˶��ð� ���� |3.�˶����� ���� |4.�˸� ����");
			System.out.println("5.�˶� �Ⱓ Ȯ�� | 6.�˶��ð� Ȯ�� |7.�˶����� Ȯ�� |8.�˸� �ҷ�����");
			System.out.println("9.�������α׷��� ���|10.����");
			System.out.println("---------------------------------------------------------");
			System.out.println("���ϴ� ����� ���ڸ� ���� Enter> ");
			
		

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
		System.out.println("���α׷��� �����մϴ�.");
		System.exit(0);
}

public static void SetPeriod() {
	System.out.println("--------------");
	System.out.println("�˶� ��ȿ���� ����");
	System.out.println("--------------");
	
	System.out.print("�⵵(ex 2018): "); 
	int Year = scan.nextInt();

	
	System.out.print("��(ex 4): "); 
	int Month = scan.nextInt();
	
	System.out.print("��(ex 1): ");
	int Day = scan.nextInt();
	
	AlarmTime NewTime = new AlarmTime(Year,Month,Day);
	for(int i=0; i<alarmArray.length; i++) {
		if(alarmArray[i] == null) {
			alarmArray[i] = NewTime;
			System.out.println("�˶� ������ ���� �����ϴ�.");
			break;
		}
	}
	
}   

public static void AlarmList1() {
	
	System.out.println("--------------");
	System.out.println("�˶����");
	System.out.println("--------------");
	
	for(int i=0; i<alarmArray.length; i++) {
		AlarmTime NewTime = alarmArray[i];
		if(NewTime != null) {
			System.out.print(NewTime.Year);
			System.out.print("��");
			System.out.print(NewTime.Month);
			System.out.print("��");
			System.out.print(NewTime.Day);
			System.out.print("�ϱ��� �˶��� �۵��մϴ�.");
			System.out.println();
		}
		}
}


public static void SetDate() {
	
	System.out.println("--------------");
	System.out.println("���� �˶� �ð� ����");
	System.out.println("--------------");
	
	
	System.out.println("�˶��� ���ϴ�  ����(��,��,ȭ,��,��,��,��) (ex ��): ");
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
	System.out.println("���� �˶� ���� ����");
	System.out.println("--------------");
	
	for(int i=0; i<alarmdateArray.length; i++) {
		AlarmTime datealarmTime = alarmdateArray[i];
		if(datealarmTime != null) {
			System.out.print(datealarmTime.Date);
			System.out.print("���Ͽ� �˶��� �︳�ϴ�.");
		
			System.out.println();		
	}
	}
		
}   

public static void SetAlarm() {
	
	
	System.out.print("���ϴ� �˶� �ð���'Hour'�� ������ �ּ���(ex 10): "); 
	int Year = scan.nextInt();
		
	System.out.print("���ϴ� �˶� �ð���'Minute'�� ������ �ּ���(ex 5): ");
	int Month = scan.nextInt();
	System.out.print("���ϴ� �޽����ȳ��� (1-4)������ 1.���� �ð� 2.���ɽð� 3.�ڽ��ð� 4.�������ð�(ex 1): ");
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
				System.out.print("�� ");
				System.out.print(NewalarmTime.Month);
				System.out.print("�п� ");
				System.out.print(NewalarmTime.Day);
				System.out.print("�� �޼����� ����� �˴ϴ�");
				System.out.println();
	
		}
		}
	}
           
  static void filewrite() throws IOException { 
	  
	    System.out.println("--------------");
		System.out.println("�˸��� �������Դϴ�.");
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
        	System.out.println("�˶� ������ �Ϸ�Ǿ����ϴ�.");
        	System.out.println("-------------------");
           
        }
		
static void AlarmRead() throws IOException {
	
	
 	System.out.println("����� �˸��� �о� ���� ���Դϴ�....");
 	System.out.println("����� �˸��� �ִ��� Ȯ�� �մϴ�.");
 	File file1 = new File("C://Alarm//AlarmSetYear.txt");
    boolean isExists1 = file1.exists();
    File file2 = new File("C://Alarm//AlarmSetDate.txt");
    boolean isExists2 = file2.exists();
    File file3 = new File("C://Alarm//AlarmSetTime.txt");
    boolean isExists3 = file3.exists();
    
    
    if(isExists1 && isExists2 && isExists3) { 
    
   
	
	try{
        //���� ��ü ����
        File file = new File("C://Alarm//AlarmSetYear.txt");
        //��ĳ�ʷ� ���� �б�
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
        //���� ��ü ����
        File file = new File("C://Alarm//AlarmSetTime.txt");
        //��ĳ�ʷ� ���� �б�
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
 	System.out.println("�����Ⱑ �Ϸ�Ǿ����ϴ�.");
 	System.out.println("-------------------");
    } else { 
    	System.out.println("����� �˶��� �����ϴ�."); }

}


	public static void register() throws IOException {
		
		Path file = Paths.get(System.getProperty("user.dir")+ "\\alarm1.exe");

		Path movePath = Paths.get("C:\\ProgramData\\Microsoft\\Windows\\Start Menu\\Programs\\StartUp");
		 
		Files.move(file , movePath .resolve(file .getFileName()));
		
		System.out.println("�������α׷����� �� ��ϵǾ����ϴ�.");
}
}