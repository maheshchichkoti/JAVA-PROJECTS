package studentReportCard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

class StudentMarksCardManage {

	public static boolean insertStudentRecordToDB(Student student) {
		boolean f = false;
		try {
			Connection con = JDBCConnection.createc();
			PreparedStatement ps1 = con.prepareStatement("insert into student value(?,?,?,?,?,?,?,?,?,?)");
			ps1.setInt(1, student.getId());
			ps1.setString(2,student.getName());
			ps1.setInt(3, student.getEnglish());
			ps1.setInt(4, student.getKannada());
			ps1.setInt(5, student.getMaths());
			ps1.setInt(6, student.getChemistry());
			ps1.setInt(7, student.getScience());
			ps1.setInt(8, student.getBiology());
			ps1.setString(9, student.getResult());
			ps1.setDouble(10, student.getPercentage());
		
			ps1.executeUpdate();
			
			f = true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return f;
	}
	
	public static boolean deleteStudentRecordFromDB(int id) {
		// TODO Auto-generated method stub
		boolean f = false;
		try {
			Connection con = JDBCConnection.createc();
			PreparedStatement ps2 = con.prepareStatement("delete from student where id=?");
			ps2.setInt(1, id);
			ps2.executeUpdate();
			
			f = true;
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		return f;
	}


	public static boolean showStudentRecordById(int id) {
		boolean f = false;
		try {
			Connection con = JDBCConnection.createc();
			PreparedStatement ps3=con.prepareStatement("select * from student where ID=?");
			ps3.setInt(1, id);
			ResultSet details=ps3.executeQuery();
			details.next();
			System.out.println("Id:"+details.getInt(1)+"\nName:"+details.getString(2)+"\nEnglish = "+details.getInt(3)+"\nKannada = "+details.getInt(4)+"\nMaths = "+details.getInt(3)+"\nChemistry = "+details.getInt(3)+"\nScience = "+details.getInt(3)+"\nBiology = "+details.getInt(3)+"\nPercentage :"+details.getDouble(10)+"%\nFinal Result : "+details.getString(9));
			f = true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return f;
	}


	public static boolean updateStudentRecord(int val,int toUpdate,int id) {
		boolean f = false;
		try {
			  Connection con = JDBCConnection.createc();
			 if(val == 1) {
						PreparedStatement pstmt = con.prepareStatement("update student set english=? where id=?");
						pstmt.setInt(1, toUpdate);
						pstmt.setInt(2, id);
						pstmt.executeUpdate();
						f = true;
				}
				else if(val == 2) {
					PreparedStatement pstmt = con.prepareStatement("update student set kannada=? where id=?");
					pstmt.setInt(1, toUpdate );
					pstmt.setInt(2, id);
					pstmt.executeUpdate();
					f = true;
				}
				else if(val == 3) {
					PreparedStatement pstmt = con.prepareStatement("update student set maths=? where id=?");
					pstmt.setInt(1, toUpdate);
					pstmt.setInt(2, id);
					pstmt.executeUpdate();
					f = true;
				}
				else if(val == 4) {
					PreparedStatement pstmt = con.prepareStatement("update student set science=? where id=?");
					pstmt.setInt(1, toUpdate);
					pstmt.setInt(2, id);
					pstmt.executeUpdate();
					f = true;
				}
				else if(val == 5) {
					PreparedStatement pstmt = con.prepareStatement("update student set chemistry=? where id=?");
					pstmt.setInt(1, toUpdate);
					pstmt.setInt(2, id);
					pstmt.executeUpdate();
					f = true;
				}
				else if(val == 6) {
					PreparedStatement pstmt = con.prepareStatement("update student set biology=? where id=?");
					pstmt.setInt(1, toUpdate);
					pstmt.setInt(2, id);
					pstmt.executeUpdate();
					f = true;
				}
				else {
					
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
}
