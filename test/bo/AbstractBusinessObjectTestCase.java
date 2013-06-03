package bo;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.demo.DemoException;
import com.demo.bo.User;

import junit.framework.TestCase;


public class AbstractBusinessObjectTestCase extends TestCase {

	  @Test
	  public void testInitUser() throws DemoException {

			  //UserDAO userDao=(UserDAO)DAOFactory.getDAO("UserDAO");			  
			 
			  Map<String, Object> params = new HashMap<String, Object>();
			  
			  params.put("username", "lalala");
			  params.put("password", "loolo");
			  params.put("meiyou", "多余的参数");
			  
			  User user = new User();
			  user.updateAttributes(params);
			  assertNotNull(user.getUsername());
			  assertNotNull(user.getPassword());
	  }
}
