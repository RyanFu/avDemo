package bo;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.demo.DemoException;
import com.demo.bo.User;
import com.demo.bo.UserActivity;
import com.demo.dao.DAOFactory;
import com.demo.dao.UserActivityDAO;

import junit.framework.TestCase;


public class UserActivityTestCase extends TestCase {

	  @Test
	  public void testInitUser() throws DemoException {

			  //UserDAO userDao=(UserDAO)DAOFactory.getDAO("UserDAO");			  
			 
			  Map<String, Object> params = new HashMap<String, Object>();
			  
			  params.put("user_id", 1);
			  params.put("action", 1);
			  params.put("target_id", 1);
			  params.put("target_type", "movie");
			  
			  UserActivity user = new UserActivity();
			  user.updateAttributes(params);
			  assertNotNull(user.getAction());
			  
			  UserActivityDAO dao = (UserActivityDAO) DAOFactory.getDAO("UserActivityDAO");
			  dao.save(user);
			  assertNotNull(user.getId());
	  }

}
