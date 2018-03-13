package alarm;


public class day {
	
   public String todaydate(int dayNum) {
       
        
       String day ="";
        
        
        
       switch(dayNum){
           case 1:
               day = "일";
               break ;
           case 2:
               day = "월";
               break ;
           case 3:
               day = "화";
               break ;
           case 4:
               day = "수";
               break ;
           case 5:
               day = "목";
               break ;
           case 6:
               day = "금";
               break ;
           case 7:
               day = "토";
               break ;
                
       }
        
        
        
       return day ;
   }


   
}