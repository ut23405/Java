package test1;

import java.util.List;
import test1.SyainDao;
import test1.SyainDto;

public class Test1 {
    public static void main(String[] args) {        
    	SyainDao syainDao = new SyainDao();
    	List<SyainDto> sd = syainDao.findAll();
    	
        for (SyainDto s: sd) {
            System.out.println(s.getId());
            System.out.println(s.getName());
            System.out.println(s.getRomaji());
        }
    }
}