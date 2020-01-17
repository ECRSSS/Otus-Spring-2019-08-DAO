package nnglebanov.daoexample.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EntityDetachAspect {
   // @Autowired
   // EntityManager em;
/*
    @AfterReturning(
            pointcut = "execution(* nnglebanov.daoexample.repositories.impl.*.*(..))",
            returning = "result")
    public void detachEntity(JoinPoint joinPoint, Object result) {
     *//*   if (result != null) {
            em.detach(result);
        }*//*
    }*/
}
