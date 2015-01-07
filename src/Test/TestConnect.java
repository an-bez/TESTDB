/**
 * 
 */
package Test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ibm.db2.jcc.am.SqlSyntaxErrorException;

import Code.Connect;

/**
 * @author Frosya
 *
 */
public class TestConnect {
static Connect connect;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		connect = new Connect();
	}


	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		connect=null;
	}

	@Before
	public void setUp() throws Exception {
		//Connect.password="";
	}


	@After
	public void tearDown() throws Exception {
		//Connect.password="";
	}

	@Test
	public void test() {
		//Connect.password="1";
	//	assertNotNull(connect.getConnection());
	}

	@Test// (expected=SqlSyntaxErrorException.class)
	public void test1() {
		
	//	assertNull(connect.getConnection());
	
	}

	
}
