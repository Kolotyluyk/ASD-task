package java.com.jm2dev.localidades;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UnitTests {
	@BeforeClass

	@AfterClass
	public void tearDown() {

	}

	@Test
	public void retrieveSingleProvinceFromDatabase() {
	}

	@Test
	public void retrieveAllSpanishProvinces() {
		Assert.assertEquals(44, 52);
	}

}
