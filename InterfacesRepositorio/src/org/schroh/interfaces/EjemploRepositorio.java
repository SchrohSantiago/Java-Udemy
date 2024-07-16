package org.schroh.interfaces;

import org.schroh.interfaces.modelo.Cliente;
import org.schroh.interfaces.repositorio.*;
import org.schroh.interfaces.repositorio.excepciones.AccesoDatoException;
import org.schroh.interfaces.repositorio.excepciones.EscrituraAccesoDatoException;
import org.schroh.interfaces.repositorio.excepciones.LecturaAccesoDatoException;
import org.schroh.interfaces.repositorio.excepciones.ObjetoRepetidoException;
import org.schroh.interfaces.repositorio.lista.ClienteListRepositorio;

import java.util.List;

public class EjemploRepositorio {
    public static void main(String[] args){
        try {
            FullRepositorio<Cliente> repo = new ClienteListRepositorio();
            Cliente santiago = new Cliente("Santiago", "Schroh");
            repo.crear(santiago);
            repo.crear(santiago);
            repo.crear(new Cliente("Javi", "Hernandez"));
            repo.crear(new Cliente("Samad", "Hammad"));


            List<Cliente> clientes = repo.listar();
            clientes.forEach(System.out::println);
            System.out.println("\n/// PAGINAR /// \n");

            List<Cliente> paginable = repo.listar(0, 1);
            paginable.forEach(System.out::println);
            System.out.println("\n/// ORDENAR /// \n");

            List<Cliente> ordenable = repo.listar("nombre", Direccion.ASC);
            ordenable.forEach(System.out::println);
            System.out.println("\n/// EDITAR /// \n");

            Cliente actualizar = new Cliente("Carlos", "Simons");
            actualizar.setId(2);
            repo.editar(actualizar);

            System.out.println(actualizar);

            System.out.println("\n /// ELIMINAR /// \n");

            repo.eliminar(2);
            System.out.println();
            repo.listar().forEach(System.out::println);
        } catch (ObjetoRepetidoException e){
            System.out.println("El objeto ya existe" + e.getMessage());
            e.printStackTrace();
        }
        catch (LecturaAccesoDatoException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (EscrituraAccesoDatoException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (AccesoDatoException e){
            System.out.println("Generica: " + e.getMessage());
            e.printStackTrace();
        }

    }
}
