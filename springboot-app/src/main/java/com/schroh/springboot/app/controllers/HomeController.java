package com.schroh.springboot.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController { // Este controlador sera para manejar rutas y realizar redirect y foward

    @GetMapping({"", "/", "/home"})
    public String home() { // Por ejemplo, si enviamos el formulario podemos utilziar este controlador para redireccionar al usuario hacia otro url

        return "forward:/list"; // Siempre comenzando con '/'
        // return "redirect:/list";
    }
}
    // Forward VS Redirect

//   Con forward, la solicitud se redirige internamente
//   a otra ruta o controlador sin que el navegador del cliente sea consciente de este cambio.
//   El contenido de la URL en el navegador no cambia.

// Con redirect, se envía una respuesta HTTP al cliente (navegador) que le indica que haga una nueva solicitud HTTP a una URL diferente.
// Esto provoca que el navegador cambie la URL en la barra de direcciones.
// con redirect perdes los parametros


// Si por ejemplo creamos un usuario o producto utilizamos redirect

// Uso: redirect se usa cuando quieres que el navegador haga una nueva solicitud HTTP a una URL diferente. Esto es útil, por ejemplo, después de procesar un formulario para evitar el reenvío de formularios al recargar la página (problema de resubmit de formularios).