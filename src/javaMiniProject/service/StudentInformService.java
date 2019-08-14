package javaMiniProject.service;

import java.util.List;
import java.util.Map;


public interface StudentInformService {
	
	List<Map<String, Object>> basicInform(int stuNum);
	
	List<Map<String, Object>> schoolInform(int stuNum);
	
	void breakApply(int stuNum, int semester, String reason);
	
	void backApply(int stuNum, int semester);

}
