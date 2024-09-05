package com.schroh.springboot_app_aop.springboot_aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Order(1) // Es para organizar el orden de ejecucion de los Aspectos.
@Component  // IMPORTANTE:  El orden 1 es el primero en entrar y ultimo en salir
@Aspect
public class GreetingFooAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private final String pointCut = "GreetingServicePointcuts.greetingLoggerPointCut()";

    @Before(pointCut)// Indicamos en que clase, metodo o package integramos este before
    // Otro ejemplo del buen uso de la programacion orientada a interfaces, "GreetingService" es una interfaz, esta misma podria llegar a implementarse en todas las clases services de Greeting, al interceptar la interfaz el aspecto intercepta todos los metodos de las clases que implementen dicha interfaz
    public void loggerBefore(JoinPoint joinPoint){

        String method = joinPoint.getSignature().getName(); // getSignature hace referencia a la firma de un metodo
        String args = Arrays.toString(joinPoint.getArgs()); // getArgs obtiene los argumentos de un metodo, y Arrays toString genera un array de string
        logger.info("Primero: " + method + " invocado con los parametros " + args);
    }

    @After(pointCut)
    public void loggerAfter(JoinPoint joinPoint){  // After se ejecuta siempre, haya exception o no.

        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Depois: " + method + " con los argumentos " + args);
    }
}
