package DemoTestNG;

import org.testng.annotations.*;

public class ConfigurationAnnotation_ListBox {
	
	@Test
	public void testMethod_3_ListBox() {
		
		System.out.println("		(3) - testMethod_3_ListBox");
		
	}
	
	@Test
	public void testMethod_4_ListBox() {
		
		System.out.println("		(3) - testMethod_4_ListBox");
		
	}
	
	@BeforeMethod
	public void beforeMethod_1_ListBox() {
		System.out.println("	(2) - beforeMethod_1_ListBox");
	}
	
	
	@AfterMethod
	public void afterMethod_1_ListBox() {
		System.out.println("	(2) - afterMethod_1_ListBox");
		System.out.println();
	}
	
	
	@BeforeClass
	public void beforeClass_ConfigurationAnnotation_ListBox() {
		System.out.println("(1) - beforeClass_ConfigurationAnnotation_ListBox");
	}
	
	@AfterClass
	public void afterClass_ConfigurationAnnotation_ListBox() {
		System.out.println("(1) - afterClass_ConfigurationAnnotation_ListBox");
	}
	

}
