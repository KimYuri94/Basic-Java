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



import firstassignment.Gift;
import firstassignment.Baby;

import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class BabyRegister {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		SimpleDateFormat giftDate = new SimpleDateFormat("dd/MM/yyyy");
		String userCommand;
		Baby babybox = new Baby();
		Gift g= new Gift();

		Baby anna = new Baby("01/01/1994 20:20", "anna",'F');
		Baby sara = new Baby("01/01/1992 20:20", "sara",'F');
		Baby hannah = new Baby("02/02/1994 20:19","hannah",'M');

		babybox.addBaby(sara);
		babybox.addBaby(anna);
		babybox.addBaby(hannah);
		
	
		Gift gift1 = new Gift("Yuri", "moeny","01/01/1994");
		Gift gift2 = new Gift("Ryan","cake","02/02/1993");
	
		g.addGift(gift1);
		g.addGift(gift2);

		
		

		
		do {
			System.out.println("say 'exit', 'addbaby', 'listbyage', 'listbyname','addgift','listgifts'");
			userCommand = scanner.next();
			
			switch(userCommand) {
			case "addbaby":
				System.out.println("Say the name of the baby");
				String name = scanner.next();

				System.out.println("Say sex of the baby:F/M");
				char gender = scanner.next().charAt(0);
				while(gender!='F' && gender!='M') {
					System.out.println("It should be either F or M");
					gender = scanner.next().charAt(0);
				}
		
				System.out.println("Say the birthday of the Person(dd/MM/yyyy HH:mm)");
				Date day = new Date();
				
				boolean validDate=false;
				while(!validDate) {
					try {
						day = myFormat.parse(scanner.nextLine());
						validDate=true;
					}catch(ParseException e) {
						System.out.println("Invalid date, type it again");
						validDate=false;
					}
				}
				
		
				Baby b = new Baby(day,name,gender);
				babybox.addBaby(b);
				System.out.println("We have "+babybox.getNumberofBaby()+"babies");
				break;
				
			case "listbyname":
				babybox.sortbyname();
				babybox.printAll();
				break;
				
			case "listbyage":
				babybox.sortbyage();
				babybox.printAll();
				break;
				
			case "addgift":
				System.out.println("Who gave the gifts?");
				String Gname = scanner.next();
				System.out.println("What's the gift?");
				String gift = scanner.next();
				System.out.println("when did you got that gift? (dd/MM/yyyy)");
				Date recievedate = new Date();
				
				boolean validgiftDate = false;
				while(!validgiftDate) {
					try {
						day = giftDate.parse(scanner.nextLine());
						validgiftDate=true;
					}catch(ParseException e) {
						System.out.println("Invalid date, type it again");
						validgiftDate=false;
					}
				}
				Gift newG = new Gift(Gname, gift, recievedate);
				g.addGift(newG);
				System.out.println("We have "+g.getNumberofgift()+" gifts");
				break;
			case"listgifts":
				g.printAll();
				break;
			}
		}while(!userCommand.equals("exit"));
	
	}

}
