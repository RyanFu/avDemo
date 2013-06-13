package dao;

import java.util.List;

import org.junit.Test;

import com.demo.bo.Movie;
import com.sun.java.swing.plaf.motif.resources.motif;

import junit.framework.TestCase;

public class MovieDAOTestCase extends TestCase {

	@Test
	public void testFindByPage(){
		com.demo.dao.MovieDAO dao = new com.demo.dao.MovieDAO();
		List<Movie> list = (List<Movie>) dao.findByPage(0, 5);
		list.hashCode();
		assertNotNull(list);
	}
}
