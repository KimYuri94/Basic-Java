// <KIM YURI>

// <CQG9IY>

// <Basic Java & First Assignment>

// <2017.10.31>

//This solution was submitted and prepared by <KIM YURI, CQG9IY> for the
//<First Assignment> assignment of the <Basic Java> course.

// I declare that this solution is my own work.

// I have not copied or used third party solutions.

// I have not passed my solution to my classmates, neither  made it public.

// %% Students regulation of Eotvos Lorand University (ELTE Regulations
// Vol. II. 74/C. § ) states that as long as a student presents another
// students work - or at least the significant part of it - as his/her own
// performance, it will count as a disciplinary fault. The most serious

// consequence of a disciplinary fault can be dismissal of the student from
// the University.



package firstassignment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;


public class Gift {
	public String name;
	public String description;
	public Date date;
	SimpleDateFormat giftDate = new SimpleDateFormat("dd/MM/yyyy");
	public ArrayList<Gift> gift;

	public Gift() {
		gift = new ArrayList<Gift>();
	}
	
	public Gift(String name, String description, Date date) {
		this.name = name;
		this.description = description;
		this.date = date;
	}
	
		public Gift(String name, String description, String sdate) {
		
		try {
			this.date = giftDate.parse(sdate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.name = name;
		this.description = description;
	}
	
	
	public void printAll(){
		for(Gift g : gift) {
			String gd = giftDate.format(g.date);
			System.out.println(g.name+" gave the " + g.description + " for baby on " +gd);
		}
	}
	
	public int getNumberofgift() {
		return gift.size();
	}
	
	public void addGift(Gift g) {
		gift.add(g);
	}
}