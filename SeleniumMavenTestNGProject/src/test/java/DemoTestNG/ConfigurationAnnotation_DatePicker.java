package DemoTestNG;

import org.testng.annotations.*;
@Test

public class ConfigurationAnnotation_DatePicker {
	
	
	public void testMethod_1_DatePicker() {
		
		System.out.println("		(3) - testMethod_1_DatePicker");
		
	}
	
	
	public void testMethod_2_DatePicker() {
		
		System.out.println("		(3) - testMethod_2_DatePicker");
		
	}
	
	@BeforeMethod
	public void beforeMethod_1_DatePicker() {
		System.out.println("	(2) - beforeMethod_1_DatePicker");
	}
	
	
	@AfterMethod
	public void afterMethod_1_DatePicker() {
		System.out.println("	(2) - afterMethod_1_DatePicker");
		System.out.println();
	}
	
	
	@BeforeClass
	public void beforeClass_ConfigurationAnnotation_DatePicker() {
		System.out.println("(1) - beforeClass_ConfigurationAnnotation_DatePicker");
	}
	
	@AfterClass
	public void afterClass_ConfigurationAnnotation_DatePicker() {
		System.out.println("(1) - afterClass_ConfigurationAnnotation_DatePicker");
	}

}
