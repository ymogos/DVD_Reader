
/* This programs reads dvd from a file by FileReader object
 * User has to make a choice from 1-7 for the dvd menu collection where 7 exits the program
 * use an arrayList to collect the dvd 
 * initiatiaze the dvd object 
 * use of try catch block in case EXception occurs 
 */


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Master {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args)throws IOException {
		 /*
         * 1. File object -> Define the file we are using
         * 2. FileReader Object -> To read from the file
         * 3. BufferedReader -> Read line to line
         */
		
		ArrayList<DVD> dvdCollection;
		char choice;
		dvdCollection=readDvds();
		do {
			
			menu();
			
			System.out.println("Enter Your choice?");
			choice = scanner.next().charAt(0);
			switch(choice) {
			case '1':
			   addDvd(dvdCollection);
			break;
			case '2':
				removeDvd(dvdCollection);
			break;
			case '3':
				editDvd(dvdCollection);
		    break;
			case '4':
				displayDvds(dvdCollection);
			 break;
			case '5':
				displayDvdsById(dvdCollection);
			break;
			case '6':
				displayDvdsByTitle(dvdCollection);
			break;
			case '7':
				writeToFile(dvdCollection);
			break;
			  
			}
			

		}while(choice !='7');


	}
	
	public static void menu() {
		System.out.println("Dvd Collection Menu");
		System.out.println("==================");
		System.out.println("1: Add DVD");
		System.out.println("2: Remove DVD");
		System.out.println("3: Edit DVD");
		System.out.println("4: show DVD's");
		System.out.println("5: Display DVD details by ID");
		System.out.println("6: Search for a DVD by title");
		System.out.println("7: Exit");
	}

	public static ArrayList<DVD> readDvds() throws IOException  {
		ArrayList<DVD> dvds= new ArrayList<DVD>();      //an array list for the dvd
		try {
			
		String fileName= "C:/Users/miyom/Desktop/dvd.txt";//file already exists at this locat
		File dvdfile = new File(fileName);
		FileReader fr= new FileReader(dvdfile);   //Read the file itself
		BufferedReader  br = new BufferedReader(fr);   // line per line reading
		String lines = br.readLine();
		int id=0;
		while(lines!=null) {
			String [] linePerLine= lines.split(",");   // Splitting the line into a String Array
			lines= br.readLine();
			id++;   // id gets added every time a single dvd is read by fileReader so that dvd will have unique id's
			DVD dvd = new DVD(id,linePerLine[0],linePerLine[1],Integer.parseInt(linePerLine[2]),linePerLine[3],linePerLine[4],linePerLine[5]);
			dvds.add(dvd);// adding each dvd to dvd's collection
		 }
		   
		}catch(FileNotFoundException e) {
		   e.printStackTrace();
		}
		return dvds;
	}
	
	public static void addDvd(ArrayList<DVD> dvds) {
		scanner.nextLine();
		System.out.println("Enter Movie Title");
		String title = scanner.nextLine();
		System.out.println("Enter Date");
		String date = scanner.nextLine();
		System.out.println("Enter MPA rating");
		int mparating = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter Director Name");
		String directorName = scanner.nextLine();
		System.out.println("Enter Studio");
		String studio = scanner.nextLine();
		System.out.println("Enter User rating");
		String rating = scanner.nextLine();
		
		DVD dvd = new DVD(dvds.size()+1,title,date,mparating,directorName,studio,rating);
		dvds.add(dvd);
	
	}
	
	public static void editDvd(ArrayList<DVD> dvds) {
		System.out.println("Enter DVD Id?");
		int id = scanner.nextInt();
		
		for(DVD dvd : dvds) {
			if(dvd.getId()==id) {
				scanner.nextLine();
				System.out.println("Enter Movie Title");
				String title = scanner.nextLine();
				dvd.setTitle(title);
				System.out.println("Enter Date");
				String date = scanner.nextLine();
				dvd.setDate(title);
				System.out.println("Enter MPA rating");
				int mparating = scanner.nextInt();
				dvd.setMpaaRating(mparating);
				scanner.nextLine();
				System.out.println("Enter Director Name");
				String directorName = scanner.nextLine();
				dvd.setDirectorName(directorName);
				System.out.println("Enter Studio");
				String studio = scanner.nextLine();
				dvd.setStudio(studio);
				System.out.println("Enter User rating");
				String rating = scanner.nextLine();
				dvd.setUserRating(rating);
			}
		}
	
	}
	
	public static void removeDvd(ArrayList<DVD> dvds) {
		System.out.println("Enter DVD Id?");
		int id = scanner.nextInt();
		for(int i=0;i<dvds.size();i++) {
			if(dvds.get(i).getId()==id) {
				dvds.remove(i);
			}
		}
		
	}
	
	
	
	public static void displayDvdsById(ArrayList<DVD> dvds) {
		System.out.println("Enter DVD Id?");
		int id = scanner.nextInt();
		for(DVD dvd : dvds) {
			if(dvd.getId()==id) {
				System.out.println(dvd.toString());	
			}
		}
		
	}
	
	public static void displayDvdsByTitle(ArrayList<DVD> dvds) {
		scanner.nextLine();
		System.out.println("Enter DVD Title?");
		String title = scanner.nextLine();
		for(DVD dvd : dvds) {
			if(dvd.getTitle().equalsIgnoreCase(title)) { //checks if the title the user write to scanner is equal to DVD's title
				System.out.println(dvd.toString());	
			}
		}
		
	}
	
	public static void displayDvds(ArrayList<DVD> dvds) {
		System.out.println("Id\t\tTitle\t\tDate Released\t\tMPAA Rating\t\tDirector Name \t\t Studio\t\tUser Rating");
		System.out.println("==\t\t===\t\t============\t\t==========\t\t==============\t\t=======\t\t==========\t\t");
		for(DVD dvd: dvds) {
			System.out.println(dvd.toString());
		}
	}
	
	public static void  writeToFile(ArrayList<DVD> dvds) throws IOException  {
		
		try {
			
		String fileName= "C:/Users/miyom/Desktop/dvd.txt";
		File dvdfile = new File(fileName);
		FileWriter fw= new FileWriter(dvdfile); //writing to the same file
		BufferedWriter  bw = new BufferedWriter(fw);
		
		
		for(DVD dvd: dvds) {
			System.out.println(dvd.toString());
			String linePerDvd= "";
			linePerDvd = dvd.getTitle()+","
			             + dvd.getDate()+","
					     + dvd.getMpaaRating()+","
					     + dvd.getDirectorName()+","
					     + dvd.getStudio()+","
					     + dvd.getUserRating()+"\n";
			bw.append(linePerDvd);
		}
		
		   bw.flush();
		   bw.close();
		   
		}catch(FileNotFoundException e) {
		   e.printStackTrace();
		}

	}
	

}