package util;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
public class SQL {
	private String User = "root";//���ݿ��û���
	private String Password = "sherlock";//���ݿ�����
	private String url = "jdbc:mysql://localhost:3306/steam?useUnicode=true&characterEncoding=UTF-8";//���ݿ����
	private Connection con = null;//��������
	private Statement sta = null;//���ݿ����
	private ResultSet rs = null;//���Ҳ���
	private PreparedStatement psta = null;
	public Connection connection(String Url, String User, String Password){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(Url, User, Password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("��һ�����ӳ���");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("�ڶ������ӳ���");
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
			System.out.println("��ѯʧ��");
		}
		try {
			rs = sta.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			System.out.println("��ӳ���");
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
			System.out.println("��ӳ���1");
			
		}
		try {
			i = sta.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			System.out.println("��ӳ���2");
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
			System.out.println("sta�رմ���");
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			System.out.println("con�رմ���");
		}
	}
}