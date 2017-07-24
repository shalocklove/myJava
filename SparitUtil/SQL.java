package util;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
public class SQL {
	private String User = "root";//数据库用户名
	private String Password = "sherlock";//数据库密码
	private String url = "jdbc:mysql://localhost:3306/steam?useUnicode=true&characterEncoding=UTF-8";//数据库加载
	private Connection con = null;//建立连接
	private Statement sta = null;//数据库操作
	private ResultSet rs = null;//查找操作
	private PreparedStatement psta = null;
	public Connection connection(String Url, String User, String Password){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(Url, User, Password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("第一步连接出错");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("第二步连接出错");
		}
		return con;
	}
	public ResultSet select(String sql, Connection conn){
		try {
			sta = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			System.out.println("查询失败");
		}
		try {
			rs = sta.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			System.out.println("添加出错");
		}
		this.rs = rs;
		this.sta = sta;
		this.con = conn;
		return rs;
	}
	
	public int change(String sql, Connection conn){
		int i = 0;
		try {
			sta = conn.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			System.out.println("添加出错1");
			
		}
		try {
			i = sta.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			System.out.println("添加出错2");
		}
		this.sta = sta;
		this.con = conn;
		return i;
	}
	public void closeSelect() throws SQLException{
		rs.close();
		sta.close();
		con.close();
	}
	public void closeChange() {
		try {
			sta.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			System.out.println("sta关闭错误");
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			System.out.println("con关闭错误");
		}
	}
}