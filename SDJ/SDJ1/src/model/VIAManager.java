package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import fileManager.FileManager;

public class VIAManager {

	private MemberList members;
	private LecturerList lecturers;
	private EventList events;
	private ArrayList<File> newsletterFiles;

	public VIAManager () {
	   this.newsletterFiles = new ArrayList<File>();
	}
	
	public void sendReminderEmailToMembers() {

	}

	public void signUpMember(String name, String address, int phone, String email, MyDate dateOfMembership,
			int paymentYear) throws IOException {
		members.addMember(new Member(name, address, phone, email, dateOfMembership));
		FileManager.generateMemberFile(members);
	}

	public void signUpLecturer(String name, String email, int phone, ArrayList<Category> categories,
			boolean wantsAdvertise) throws IOException {
		lecturers.addLecturer(new Lecturer(name, email, phone, categories, wantsAdvertise));
		FileManager.generateLecturerFile(lecturers);
	}

	public void signUpParticipantToEvent(int eventId, Participant participant) throws EventNotFoundException {
		events.getEventByID(eventId).signUpParticipant(participant);
	}

	public void generateNewsletter(String newsletterContent) throws IOException {
	  
      newsletterFiles.add(new File("Newsletter_" + new MyDate().toString() + ".txt"));
      PrintWriter out = new PrintWriter(newsletterFiles.get(newsletterFiles.size() - 1));

      out.println(newsletterContent);

      out.flush();
      out.close();
	   
	}

   public String readNewsletter (MyDate date) throws FileNotFoundException {

      String newsletter = "";
      for (File i : newsletterFiles) {
         if (i.getName().equals("Newsletter_" + date.toString() + ".txt")) {
            Scanner read = new Scanner(i);
            while (read.hasNext())
               newsletter += read.nextLine() + "\n";
            read.close();
            return newsletter;
         } else {
            throw new FileNotFoundException("No newsletter on " + date.toString());
         }
      }
      return "Something went wrong...";
   }

}
