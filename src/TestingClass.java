import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestingClass {

	public static void main(String[] a){
//		try {
//			String date = "29-02-2014";
//			Date last_date_date = new SimpleDateFormat("dd-MM-yyyy").parse(date);
//			
//			//System.out.println(new SimpleDateFormat("dd-MM-yyyy").format(last_date_date));
//			String finalDate = "";
//			finalDate=new SimpleDateFormat("dd-MM-yyyy").format(last_date_date);
////			String dmy[]=finalDate.split("-");
////			int d = Integer.parseInt(dmy)
//			if(date.equals(finalDate)){
//				System.out.println("Correct Date "+ finalDate);
//			} else{System.out.println("Sorry Wrong Date" + finalDate);
//			
//		} 
//		}catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;
        try {
            DATE_FORMAT.setLenient(false);
            date = DATE_FORMAT.parse("1-7-2014");
            System.out.println(date);
            System.out.println(DATE_FORMAT.format(date));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Date date2 = new Date();
//        date2.setTime(0);
        
        System.out.println(date2);
        if(!date.before(date2))
        System.out.println(date2);
        else
        	System.out.println("Soory and Old date is entered");
        
        
	
	}
}
