package amandzhi.aspect;

import amandzhi.aspect.aop.AspectAnnotation;
import org.springframework.stereotype.Service;

@AspectAnnotation
@Service
public class CoachService {
    public void say(String message) {
        System.out.println(message + " : coach");
    }

    public String getAnswer() {
        return "ready";
    }

    public void jump() {
        System.out.println("jump");
    }
}