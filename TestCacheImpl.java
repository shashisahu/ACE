package chache;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestCacheImpl {
	ChacheImpl chacheImpl;
	@Before
	public void setUp() throws Exception {
		chacheImpl=new ChacheImpl(2000l, 400l);
	}

	@Test
	public void testPutObject() {
		chacheImpl.putObject("Shashi", 1);
		chacheImpl.putObject("Sahu", 2);
		chacheImpl.putObject("Sapient", 3);
		chacheImpl.putObject("Aricent", 4);
		chacheImpl.putObject("TCS", 5);
		
	}	
	@Test
	public void testGetObject() {
		chacheImpl.putObject("Shashi", 1);
		chacheImpl.putObject("Sahu", 2);
		chacheImpl.putObject("Sapient", 3);
		chacheImpl.putObject("Aricent", 4);
		chacheImpl.putObject("TCS", 5);
		
		Assert.assertEquals("Shashi",chacheImpl.getObject(1));
		
	}

}
