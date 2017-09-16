package ie.distilled.bizops.roomchecker.beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class TestBean {
	
	public void runTest() {
		System.out.println("Test OK!");
	}

}
