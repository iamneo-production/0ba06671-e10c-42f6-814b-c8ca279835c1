package testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
 
import java.sql.Connection;
import java.sql.SQLException;
 
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
 
import model.BlogList;
import service.GadgetsDao;
 
class GadgetsDaoTest {
     
    private static GadgetsDao dao;
     
    @BeforeAll
    static void init() {
        Connection conn = ConnectionManager.getConnection();
        try {
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        dao = new GadgetsDao(conn);
    }
     
    @AfterAll
    static void teardown() {
        Connection conn = ConnectionManager.getConnection();
        try {
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     
    @Test
    void addListTest() {
        Gadgets list = new Gadgets();
        list.setGadgetName("backcase");
		list.setGadgetPrice(1000);
		list.setImageUrl("xyz.jpg");
		list.setQuantity(1);
		list.setDetails("best case");
        dao.addGadgets(list);
        Gadgets listFromDb = dao.viewGadgetsById(1);
        assertEquals("backcase", listFromDb.getGadgetsName(), "Gadgets Name must be equal");
    }
    
    @Test
    void deleteListTest() {
        dao.deleteGadgets(1);
        Gadgets listFromDb = dao.viewGadgetsById(1);
        assertNull(listFromDb.getGadgetsName(), "Gadgets should be null");
    }
    
    @Test
    void updateListTest() {
        Gadgets list = new Gadgets();
        list.setGadgetName("backcase");
		list.setGadgetPrice(1000);
		list.setImageUrl("xyz.jpg");
		list.setQuantity(1);
		list.setDetails("best case");
        dao.addGadgets(list);
        list.setGadgetsName("powerbank");
        dao.updateGadgets(list);
        Gadgets listFromDb = dao.viewGadgetsById(1);
        assertEquals("powerbank", listFromDb.getGadgetsName(), "Gadgets Name must be equal");
    }
 
}