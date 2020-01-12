package nnglebanov.daoexample.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

@Aspect
@Component
public class EntityDetachAspect {
    @Autowired
    EntityManager em;

    @AfterReturning(
            pointcut = "execution(* nnglebanov.daoexample.repositories.impl.*.*(..))",
            returning = "result")
    public void detachEntity(JoinPoint joinPoint, Object result) {
        if (result != null) {
            em.detach(result);
        }
    }
}
