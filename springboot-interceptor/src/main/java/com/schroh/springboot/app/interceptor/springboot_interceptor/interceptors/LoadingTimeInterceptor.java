package com.schroh.springboot.app.interceptor.springboot_interceptor.interceptors;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Nullable;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Component("timeInterceptor")
public class LoadingTimeInterceptor implements HandlerInterceptor { // Siempre utilizamos esta interfaz

    private static final Logger logger = LoggerFactory.getLogger(LoadingTimeInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        HandlerMethod controller = ((HandlerMethod)handler);
        logger.info("LoadingTimeInterceptor: preHandle() entrando..." + controller.getMethod().getName());

        long start = System.currentTimeMillis(); // Calcular el tiempo de respuesta del controlador
        request.setAttribute("start",start);

//        Map<String, String> json = new HashMap<>();
//        json.put("error", "No tenes acceso a este recurso");
//
//        ObjectMapper mapper = new ObjectMapper();
//        String jsonString = mapper.writeValueAsString(json);
//        response.setContentType("application/json");
//        response.setStatus(401);
//        response.getWriter().write(jsonString);

        return false; // El return false no permite que se ejecute el controller, esto sirve para prohibir determinadas cosas a los users
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView)
            throws Exception {

       long end = System.currentTimeMillis();

       long start = (long)request.getAttribute("start");
       long result = end - start;

       logger.info("Tiempo transcurrido: " + result + " ms");
       logger.info("LoadingTimeInterceptor: postHandle() saliendo..." + ((HandlerMethod) handler).getMethod().getName());
    }
}
