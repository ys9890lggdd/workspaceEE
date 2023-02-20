package com.itwill.guest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
@MyComponent(value = "guestDao")
public class GuestDaoImpl implements GuestDao {
	private DataSource dataSource;
	
	public GuestDaoImpl() {
		
	}
	
	public DataSource getDataSource() {
		return dataSource;
	}
	@MyAutoWire(value = "dataSource")
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<Guest> selectAll() throws Exception{
		
		List<Guest> guestList=new ArrayList<Guest>();
		Connection con=dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(GuestSQL.GUEST_SELECT_ALL);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()) {
			guestList.add(new Guest(rs.getInt("guest_no"),
							rs.getString("guest_name"),
							rs.getString("guest_date"),
							rs.getString("guest_email"),
							rs.getString("guest_homepage"),
							rs.getString("guest_title"),
							rs.getString("guest_content")));
		}
		
		return guestList;
		
	}

	@Override
	public Guest selectByNo(int no) throws Exception{
		Guest guest=null;
		return guest;
	}

	@Override
	public int insertGuest(Guest guest)throws Exception {
		return 0;
	}
	@Override
	public int updateGuest(Guest guest) throws Exception{
		return 0;
	}
	@Override
	public int deleteGuest(int no)throws Exception {
		return 0;
	}
}
