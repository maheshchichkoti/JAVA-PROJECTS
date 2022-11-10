package studentPercentageCal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

class Student {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata","root","root");
		Statement st=connection.createStatement();

		int id;
		String name;
		int english;
		int kannada;
		int maths;
		int science;
		int chemistry;
		int biology;
		double percentage;
		String result; 
		PreparedStatement ps;

		Scanner sc=new Scanner(System.in);
		while(true){
			System.out.println("Enter the key");
			System.out.println("1 Add");
			System.out.println("2 Fetch");
			System.out.println("3 Delete");
			System.out.println("4 Update");
			System.out.println("5 Exit");
			
			int input=sc.nextInt();
			switch(input){

			case 1: PreparedStatement ps1= connection.prepareStatement("insert into student value(?,?,?,?,?,?,?,?,?,?)");

			System.out.println("Enter the id of the Student");
			id=sc.nextInt();
			System.out.println("Enter the Name of the Student");
			name=sc.next();
			System.out.println("Enter the marks of English");
			english=sc.nextInt();
			System.out.println("Enter the marks of Kannada");
			kannada=sc.nextInt();
			System.out.println("Enter the marks of Maths");
			maths=sc.nextInt();
			System.out.println("Enter the marks of Science");
			science=sc.nextInt();
			System.out.println("Enter the marks of Chemistry");
			chemistry=sc.nextInt();
			System.out.println("Enter the marks of Biology");
			biology=sc.nextInt();

			int s= kannada+maths+english+science+chemistry+biology;
			percentage=(s*100)/600;
			if((english>=35)	 && (kannada>=35) && (maths>=35) && (chemistry>=35)&& (science>=35)&& (biology>=35)) {
				result="Pass";
			}else
				result="Fail";
			ps1.setInt(1, id);
			ps1.setString(2,name);
			ps1.setInt(3, english);
			ps1.setInt(4, kannada);
			ps1.setInt(5, maths);
			ps1.setInt(6, chemistry);
			ps1.setInt(7, biology);
			ps1.setInt(8, science);
			ps1.setString(9, result);
			ps1.setDouble(10, percentage);

			ps1.execute();
			System.out.println("done"); 

			break;

			case 2:PreparedStatement ps2=connection.prepareStatement("select * from student where ID=?");
			System.out.println("Enter the Id");
			id=sc.nextInt();
			ps2.setInt(1, id);
			ResultSet details=ps2.executeQuery();
			details.next();
			System.out.println("Id:"+details.getInt(1)+"\n"+"Name:"+details.getString(2)+"\n"+"percentage:"+details.getDouble(10)+"%\nFinal Result : "+details.getString(9));
			break;

			case 3:PreparedStatement ps3=connection.prepareStatement("delete from student where id=?");
			System.out.println("Enter the id");
			id=sc.nextInt();
			ps3.setInt(1, id);
			ps3.execute();
			System.out.println("Data is deleted");
			break;  

			case 4: PreparedStatement ps4=connection.prepareStatement("update student set name=?, maths=?, where id=?");
			System.out.println("Enter the id");
			id=sc.nextInt();
			System.out.println("Enter the name");
			name=sc.next();
			System.out.println("Enter the Updated Maths marks");
			maths=sc.nextInt();
			
			ps4.setString(1, name);
			ps4.setInt(2, maths);
			ps4.setInt(3, id);
			ps4.execute();
			System.out.println("Updated");
			break;

			case 5:
				System.out.println("Thank you \nExiting...");
				System.exit(0);
			}
			System.out.println("__________________________________________________________");
		}

	}

}
