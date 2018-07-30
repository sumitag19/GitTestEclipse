package driver;

import org.testng.annotations.Test;
import applicationModules.ApplicationFunctions;

public class Driver {

	ApplicationFunctions afs=new ApplicationFunctions();
	
	@Test
	public void Jenk1() throws Throwable{
		afs.exe();
	}

//	@Test
//	public void Jenk2() throws Throwable{
		//afs.exe();
//	} 
}
