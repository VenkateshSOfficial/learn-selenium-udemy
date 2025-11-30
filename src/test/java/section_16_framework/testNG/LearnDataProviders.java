package section_16_framework.testNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class LearnDataProviders {
	@Test(dataProvider = "getData")
	public void execute(String username,String password){
		System.out.println("The username is : " + username + " and the password is : " + password);
	}
	@DataProvider
	public Object[][] getData(){
		return new Object[][]{
				{"Kaushik","password1"},
				{"Babbi","password2"},
				{"Don","password3"}
		};
	}
}
