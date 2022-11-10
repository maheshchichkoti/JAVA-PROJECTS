package studentReportCard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

class Solutions {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(true){
			System.out.println("PRESS 1 to ADD student details");
			System.out.println("PRESS 2 to DELETE student details");
			System.out.println("PRESS 3 to DISPLAY student details");
			System.out.println("PRESS 4 to UPDATE student details");
			System.out.println("PRESS 5 to EXIT");

			int input=sc.nextInt();
			switch(input){

			case 1:
				System.out.println("Enter the id of the Student");
				int id=sc.nextInt();
				System.out.println("Enter the Name of the Student");
				String name=sc.next();
				System.out.println("Enter the marks of English");
				int english=sc.nextInt();
				System.out.println("Enter the marks of Kannada");
				int kannada=sc.nextInt();
				System.out.println("Enter the marks of Maths");
				int maths=sc.nextInt();
				System.out.println("Enter the marks of Science");
				int science=sc.nextInt();
				System.out.println("Enter the marks of Chemistry");
				int chemistry=sc.nextInt();
				System.out.println("Enter the marks of Biology");
				int biology=sc.nextInt();
				Student student = new Student(id, name, english, kannada, maths, science, chemistry, biology);

				boolean ans = StudentMarksCardManage.insertStudentRecordToDB(student);
				if(ans) {
					System.out.println("Student record Inserted Successfully...");
					System.out.println("Student Record:" + student);
				}else {
					System.out.println("Some error Occured While Inserting...Please try Again!");
				}
				break;

			case 2:
				System.out.println("Enter Student ID To Delete: ");
				int userID = sc.nextInt();
				boolean f = StudentMarksCardManage.deleteStudentRecordFromDB(userID);
				if(f) {
					System.out.println("Student Of ID " + userID + " Record Deleted... ");
				}else {
					System.out.println("Something Went Wrong.. Please try Again!");
				}
				break;

			case 3:
				System.out.println("Enter Student ID To Display: ");
				int stdId = sc.nextInt();
				boolean f1 = StudentMarksCardManage.showStudentRecordById(stdId);
				if(f1) {

				}else {
					System.out.println("Student Id is not present!");
				}
				break;

			case 4:
				System.out.println("PRESS 1 to Update Student Name");
				System.out.println("PRESS 2 to Update Student Marks");

				int choice=sc.nextInt();

				if(choice==1) {
					Connection con = JDBCConnection.createc();
					PreparedStatement ps1;
					try {
						ps1 = con.prepareStatement("update student set name=? where id=?");
						System.out.println("Enter the id");
						id=sc.nextInt();
						System.out.println("Enter the new name");
						name=sc.next();
						ps1.setString(1, name);
						ps1.setInt(2, id);
						ps1.executeUpdate();
						System.out.println("Name has been Updated");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else if(choice == 2) {

					System.out.println("Enter the Id of the Student");
					int id1 = sc.nextInt();

					System.out.println("PRESS 1 to UPDATE English marks");
					System.out.println("PRESS 2 to UPDATE Kannada marks");
					System.out.println("PRESS 3 to UPDATE Maths marks");
					System.out.println("PRESS 4 to UPDATE Science marks");
					System.out.println("PRESS 5 to UPDATE Chemistry marks");
					System.out.println("PRESS 6 to UPDATE Biology marks");
					int val = sc.nextInt();

					System.out.println("Enter the updated subject marks");
					int toUpdate = sc.nextInt();

					boolean f2 = StudentMarksCardManage.updateStudentRecord(val,toUpdate,id1);
					if(f2) {
						System.out.println("Student Marks Updated Successfully...");
					}else {
						System.out.println("Something Went Wrong Please try Again!");
					}
				}else {
					
				}
				break;	

		case 5:
			System.out.println("Exiting...\nThank You!!!");
			System.exit(0);
		}
		System.out.println("__________________________________________________________");	
		}
	}
}
