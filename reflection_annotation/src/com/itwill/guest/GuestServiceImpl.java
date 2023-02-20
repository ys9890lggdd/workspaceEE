package com.itwill.guest;

import java.util.List;
@MyComponent("guestService")
public class GuestServiceImpl implements GuestService {
	private GuestDao guestDao;
	public GuestServiceImpl() {
		
	}
	
	public GuestDao getGuestDao() {
		return guestDao;
	}
	@MyAutoWire(value = "guestDao")
	public void setGuestDao(GuestDao guestDao) {
		this.guestDao = guestDao;
	}

	@Override
	public List<Guest> selectAll() throws Exception{
		return guestDao.selectAll();
	}

	@Override
	public Guest selectByNo(int no) throws Exception{
		return guestDao.selectByNo(no);
	}

	@Override
	public int insertGuest(Guest guest)throws Exception {
		return guestDao.insertGuest(guest);
	}

	@Override
	public int updateGuest(Guest guest) throws Exception{
		return guestDao.updateGuest(guest);
	}

	@Override
	public int deleteGuest(int no)throws Exception {
		return guestDao.deleteGuest(no);
	}
}
