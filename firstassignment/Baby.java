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
import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;

public class Baby {
	
	public String name;
	public String Sbirthday;
	public char gender;
	public Date birthday;
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	public ArrayList<Baby> baby;
	
	public Baby() {
		baby = new ArrayList<>();
	}

	
	public Baby(String Sbirthday, String name, char gender){
		try {
			this.birthday = simpleDateFormat.parse(Sbirthday);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.name = name;
		this.gender = gender;
	}
	
	public Baby(Date birthday, String name, char gender){
		this.birthday = birthday;
		this.name = name;
		this.gender = gender;
	}
	
	

	public void setDbirthday(Date birthday) {
		this.birthday=birthday;
	}
	
	public Date getbirthday() {
		return birthday;
	}

	public void setBirthday(String Sbirthday) {
		try {
			this.birthday = simpleDateFormat.parse(Sbirthday);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}

	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	public char getGender() {
		return gender;
	}
	
	public boolean isOlder(Baby baby) {
			if(baby.getbirthday().compareTo(birthday)<0) {
				return true;
			}
			else {
				return false;
			}
				
		
	}


	
	public int howOld() {
		Calendar today = Calendar.getInstance();
			@SuppressWarnings("deprecation")
		int age = today.get(Calendar.YEAR) - (1900+birthday.getYear());
		return age;
		
	}
	
	public void printAll() {
		for(Baby b : baby) {
			String d = simpleDateFormat.format(b.getbirthday());
			System.out.println(b.getName()+" "+b.getGender()+" "+d);
		}
	}
	
	public int getNumberofBaby() {
		return baby.size();
	}
	
	public void addBaby(Baby b) {
		baby.add(b);
	}


	public void sortbyname() {
			for(int i=0; i<baby.size()-1;i++)  {
			for(int j=i+1; j<baby.size();j++) {
				Baby b1 = baby.get(i);
				Baby b2 = baby.get(j);
				if(b1.getName().compareTo(b2.getName())>0)  {
					Baby aux = b1;
					baby.set(j, aux);
					baby.set(i,b2);
				}
			}
		}
		
		}

	public void sortbyage() {
		for(int i=0; i<baby.size()-1;i++)  {
			for(int j=i+1; j<baby.size();j++) {
				Baby b1 = baby.get(i);
				Baby b2 = baby.get(j);
				if(b1.isOlder(b2)) {
					Baby aux = b1;
					baby.set(j, aux);
					baby.set(i,b2);
				}
			}
		}
	}

}
