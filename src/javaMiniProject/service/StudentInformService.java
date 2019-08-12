package javaMiniProject.service;

import javaMiniProject.model.Students;

public interface StudentInformService {
	
	Students basicInform(int stuNum);
	
	Students schoolInform(int stuNum);
	
	void breakApply(int stuNum);
	
	void backApply(int stuNum);

}
