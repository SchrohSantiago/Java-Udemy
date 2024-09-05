package com.schroh.springboot_app_aop.springboot_aop.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Order(2)
@Component
@Aspect // Configurar POM y ver la anotacion necesaria en la Main Class
public class GreetingAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private final String pointCut = "GreetingServicePointcuts.greetingLoggerPointCut()";

    // Con un * en vez del String decimos que puede devolver cualquier tipo de dato
    @Before(pointCut)// Indicamos en que clase, metodo o package integramos este before
    // Otro ejemplo del buen uso de la programacion orientada a interfaces, "GreetingService" es una interfaz, esta misma podria llegar a implementarse en todas las clases services de Greeting, al interceptar la interfaz el aspecto intercepta todos los metodos de las clases que implementen dicha interfaz
    public void loggerBefore(JoinPoint joinPoint){

        String method = joinPoint.getSignature().getName(); // getSignature hace referencia a la firma de un metodo
        String args = Arrays.toString(joinPoint.getArgs()); // getArgs obtiene los argumentos de un metodo, y Arrays toString genera un array de string
        logger.info("Antes: " + method + " con los argumentos " + args);
    }

    @After(pointCut)

    public void loggerAfter(JoinPoint joinPoint){  // After se ejecuta siempre, haya exception o no.

        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Despues: " + method + " con los argumentos " + args);
    }

    @AfterReturning(pointCut)// La ultizamos para luego de retornar interceptar y realizar determinada accion

    public void loggerAfterReturning(JoinPoint joinPoint){

        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Despues de retornar: " + method + " con los argumentos " + args);
    }

    @AfterThrowing(pointCut)// Lo utilizamos para capturar la exception y realizar determinada accion luego de que se lanza la excepcion

    public void loggerAfterThrowing(JoinPoint joinPoint){

        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Despues de lanzar la excepcion: " + method + " con los argumentos " + args);
    }

    @Around(pointCut)
    public Object loggerAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());

        Object result = null;
        try {
            logger.info("El emtodo " + method + "() con los parametros " + args); // before
            result = joinPoint.proceed();
            logger.info("El metodo " + method + "() retorna el resultado: " + result); // after
            return result;
        } catch (Throwable e) {
            logger.error("Error en la llamada del metodo " + method); // after throwing
            throw e;
        }

    }
}
