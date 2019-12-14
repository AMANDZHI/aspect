package amandzhi.aspect.aop;

import org.springframework.stereotype.Service;

@Service
public class ValidService {

    public boolean check(String password){
        return "psw".equals(password);
    }
}
