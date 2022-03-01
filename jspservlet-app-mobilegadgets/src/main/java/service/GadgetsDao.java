package service;

import java.sql.*;
import model.Gadgets;
import utility.ConnectionManager;

class GadgetsDao {

	ConnectionManager cm;
	Connection con; 
	PreparedStatement st;
	Statement s;
	ResultSet rs;

	public GadgetsDao() throws Exception{
		cm = new ConnectionManager();
		con= cm.getConnection();
	}
	
	public void addGadgets(Gadgets gadget) throws Exception{
		String sql = "insert into gadgets values(?,?,?,?,?,?,?)";
		st = con.prepareStatement(sql);
		st.setInt(1,gadget.gadgetsId);
		st.setString(2,gadget.gadgetsName);
		st.setFloat(3,(float) gadget.gadgetsPrice);
		st.setInt(4,gadget.quantity);
		st.setString(5,gadget.details);
		st.executeUpdate();
		st.close();
	}

	public void updateGadget(Gadgets gadget) throws Exception{
		String sql = "insert into gadgets values(?,?,?,?,?,?,?)";
		st = con.prepareStatement(sql);
		st.setInt(1,gadget.gadgetsId);
		st.setString(2,gadget.gadgetsName);
		st.setFloat(3,(float) gadget.gadgetsPrice);
		st.setInt(4,gadget.quantity);
		st.setString(5,gadget.details);
		st.executeUpdate();
		st.close();
	}
	public Gadgets viewGadgetById(int id) throws Exception{
		String sql="select * from gadgets where gadgetsId="+id;
		s = con.createStatement();
		ResultSet rs = s.executeQuery(sql);
		
		Gadgets gadgets = new Gadgets();
		if(rs.next()){
			gadgets.gadgetsId = rs.getInt(1);
			gadgets.gadgetsName =rs.getString(2);
			gadgets.gadgetsPrice = rs.getFloat(3);
			gadgets.imageUrl =rs.getString(4);
			gadgets.quantity = rs.getInt(5);
			gadgets.details= rs.getString(6);
		}
		rs.close();
		s.close();
		return gadgets;
	}
	public void deleteGadgets(int id) throws SQLException{
		String sql = "delete from gadgets where gadgetsId="+id;
		s = con.createStatement();
		s.executeQuery(sql);
		s.close();
	}
}