package studentReportCard;

import java.sql.Connection;
import java.sql.DriverManager;

class JDBCConnection {
	static Connection con;
	public static Connection createc() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String user = "root";
			String password = "root";
			String url = "jdbc:mysql://localhost:3306/studentdata";
			con = DriverManager.getConnection(url,user,password);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
