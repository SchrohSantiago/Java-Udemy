package org.schroh.patrones.observer.ejemplos;

import org.schroh.patrones.observer.UsuarioRepositorio;

public class EjemploObserver2 {
    public static void main(String[] args) {
        UsuarioRepositorio repo = new UsuarioRepositorio();
        repo.addObserver((observable, usuario) -> System.out.println("Enviando email al usuario" + usuario));
        repo.addObserver((observable, usuario) -> System.out.println("Enviando email al administrador" + usuario));
        repo.addObserver((observable, usuario) -> System.out.println("Guardando info del usuario en el logs" + usuario));
        repo.crearUsuario("Santiago");
    }
}
