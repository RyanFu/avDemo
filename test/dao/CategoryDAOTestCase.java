package dao;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.demo.DemoException;
import com.demo.bo.Category;
import com.demo.dao.CategoryDAO;
import com.demo.dao.DAOFactory;

import junit.framework.TestCase;


public class CategoryDAOTestCase extends TestCase {

	
	@Test
	public void testSave(){
		Category cat = new Category();
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("name", "lalalala");
		params.put("description", "这是描述信息");
		cat.updateAttributes(params);
		CategoryDAO catDao = new CategoryDAO();
		catDao.save(cat);
		assertTrue(cat.getId() > 0);
	}
	
	@Test
	public void testFindAll(){
		try {
			CategoryDAO cat = (CategoryDAO) DAOFactory.getDAO("CategoryDAO");
			List<?> list = cat.findAll();
			assertNotNull(list);
		} catch (DemoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
