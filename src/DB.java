
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
	static Connection con;
	public static  Connection getConnection()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql:///service_center","root"," ");
		}
		catch(ClassNotFoundException | SQLException e)
                {   
                    System.out.println(e);
                }
		return con;
	}
}