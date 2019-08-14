package javaMiniProject.service;

import java.util.List;
import java.util.Map;


public interface StudentInformService {
	
	List<Map<String, Object>> basicInform();
	
	List<Map<String, Object>> schoolInform();
	
	void breakApply(int semester, String reason);
	
	void backApply(int semester);

}
