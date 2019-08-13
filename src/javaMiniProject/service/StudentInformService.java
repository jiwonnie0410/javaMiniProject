package javaMiniProject.service;

import java.util.List;
import java.util.Map;

import javaMiniProject.model.Students;

public interface StudentInformService {
	
	List<Map<String, Object>> basicInform(int stuNum);
	
	List<Map<String, Object>> schoolInform(int stuNum);
	
	void breakApply(int stuNum);
	
	void backApply(int stuNum);

}
