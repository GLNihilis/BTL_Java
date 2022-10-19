package Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Process_Score {
	MySQL con = new MySQL();
	
	// Phương thức "Lấy danh sách"
	public ArrayList<Student> getListScore(){
		Connection conn = con.getCon();
		
		// Lệnh SQL
		String sql = "Select * from tb_score";
		
		// Tạo danh sách 
		ArrayList<Student> list = new ArrayList();
		try {
			// Tạo truy vấn
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			
			// Thực thi truy vấn
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				// Tạo biến trong lớp "Student"
				Student s = new Student();
				s.setID(rs.getString("ID"));
				s.setName(rs.getString("Name"));
				s.setLiterature(rs.getDouble("Literature"));
				s.setMath(rs.getDouble("Math"));
				s.setEnglish(rs.getDouble("English"));
				s.setPhysical(rs.getDouble("Physical"));
				s.setChemical(rs.getDouble("Chemical"));
				s.setBiology(rs.getDouble("Biology"));
				s.setHistory(rs.getDouble("History"));
				s.setGeography(rs.getDouble("Geography"));
				s.setEthic(rs.getDouble("Ethics"));
				s.setInformatic(rs.getDouble("Informatics"));
				list.add(s);
			}
			conn.close();
		}
		catch (SQLException e) {
			System.out.print("\nCan't Display List Score");
		}
		return list;
	}

	// Phương thức "Thêm"
	public boolean insert_Score(String ID, String Name, double Literature, double Math, double English, double Physical, double Chemical, double Biology, double History, double Geography, double Ethic, double Informatic) {
		Connection conn = con.getCon();
		String sql = "insert into tb_score(ID, Name, Literature, Math, English, Physical, Chemical, Biology, History, Geography, Ethic, Informatic)" + "values(?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			// Tạo truy vấn
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, ID);
			ps.setString(2, Name);
			ps.setDouble(3, Literature);
			ps.setDouble(4, Math);
			ps.setDouble(5, English);
			ps.setDouble(6, Physical);
			ps.setDouble(7, Chemical);
			ps.setDouble(8, Biology);
			ps.setDouble(9, History);
			ps.setDouble(10, Geography);
			ps.setDouble(11, Ethic);
			ps.setDouble(12, Informatic);
			ps.executeUpdate();
			conn.close();
			return true;
		}
		catch (SQLException e) {
			System.out.print("\nCan't Insert Score");
			return false;
		}
	}
	
	// Phương thức "Xóa"
	public boolean delete_Score(String ID) {
		Connection conn = con.getCon();
		String sql = "delete from tb_score where ID = ?";
		try {
			// Tạo truy vấn
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, ID);
			ps.executeUpdate();
			conn.close();
			return true;
		}
		catch (SQLException e) {
			System.out.print("\nCan't Delete Student");
			return false;
		}
	}
	
	// Phương thức "Cập nhật"
	public boolean update_Score(String ID, String Name, double Literature, double Math, double English, double Physical, double Chemical, double Biology, double History, double Geography, double Ethic, double Informatic) {
		Connection conn = con.getCon();
		String sql = "update tb_score set Name = ?, Literature = ?, Math = ?, English = ?, Physical = ?, Chemical = ?, Biology = ?, History = ?, Geography =?, Ethics =?, Informatics = ?" + "Where (ID = ?)";
		try {
			// Tạo truy vấn
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, ID);
			ps.setString(2, Name);
			ps.setDouble(3, Literature);
			ps.setDouble(4, Math);
			ps.setDouble(5, English);
			ps.setDouble(6, Physical);
			ps.setDouble(7, Chemical);
			ps.setDouble(8, Biology);
			ps.setDouble(9, History);
			ps.setDouble(10, Geography);
			ps.setDouble(11, Ethic);
			ps.setDouble(12, Informatic);
			ps.executeUpdate();
			conn.close();
			return true;
		}
		catch (SQLException e) {
			System.out.print("\nCan't Update Student");
			return false;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

