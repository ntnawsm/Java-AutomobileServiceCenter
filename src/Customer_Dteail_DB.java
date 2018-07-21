
import java.sql.*;

public class Customer_Dteail_DB 
{
 /*   
public static int save(String rc,String name,String vt,String phone,String address,String dor,String vor){
		int status=0;
		try
                {
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into custmr (c_rc,c_name,c_vt,c_phone,c_address,c_dor,c_vor) values (?,?,?,?,?,?,?)");
			ps.setString(1,rc);
                        ps.setString(2,name);
			ps.setString(3,vt);
		        ps.setString(4,phone);
			ps.setString(5,address);
                        ps.setString(6,dor);
                        ps.setString(7,vor);
                        status=ps.executeUpdate();
			con.close();
		}catch(Exception e)
                {
                    System.out.println(e);
                }
		return status;
	}
	public static int delete(int rc){
		int status=0;
		try
                {
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from custmr where rc=?");
			ps.setInt(1,rc);
			status=ps.executeUpdate();
			con.close();
		}
                catch(Exception e)
                {
                    System.out.println(e);
                }
		return status;
	}
*/
	public static boolean validate(String rc){
		boolean status=false;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from custmr where c_rc=?");
			ps.setString(1,rc);
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			con.close();
		}
                catch(Exception e)
                {
                System.out.println(e);
                }
		return status;
	}

}
    


