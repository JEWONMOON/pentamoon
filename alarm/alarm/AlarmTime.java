package alarm;

public class AlarmTime {
	
	public int Year;
	public int Month;
	public int Day;
	public String Date;
	public int Hour;
	public int Minute;
	public byte num;
	
	public AlarmTime(String Date) {
		this.Date=Date;	
}
	public AlarmTime() {}
	
public AlarmTime(int Hour) {
	this.Hour=Hour;	
}

public void AlarmTime1(int Minute) {
	this.Minute=Minute;	
}

	
	
	
	public AlarmTime(int Year, int Month, int Day) {
		this.Year=Year;
		this.Month=Month;
		this.Day=Day;
		
	}
	
	

}
