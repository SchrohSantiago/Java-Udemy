package org.schroh.interfaces;

import org.schroh.interfaces.modelo.Cliente;
import org.schroh.interfaces.modelo.Producto;
import org.schroh.interfaces.repositorio.Direccion;
import org.schroh.interfaces.repositorio.FullRepositorio;
import org.schroh.interfaces.repositorio.lista.ClienteListRepositorio;
import org.schroh.interfaces.repositorio.lista.ProductoListRepositorio;

import java.util.List;

public class EjemploRepositorioProducto {
    public static void main(String[] args){

        FullRepositorio<Producto> repo = new ProductoListRepositorio();

        repo.crear(new Producto("Mesa de roble", 170d));
        repo.crear(new Producto("Lampara luz led", 11.99d));
        repo.crear(new Producto("Mesada de marmol 3x2m", 899.20d));

        List<Producto> productos = repo.listar();
        productos.forEach(System.out::println);
        System.out.println("\n/// PAGINAR /// \n");

        List<Producto> paginable = repo.listar(0,1);
        paginable.forEach(System.out::println);
        System.out.println("\n/// ORDENAR /// \n");

        List<Producto> ordenable = repo.listar("nombre", Direccion.ASC);
        ordenable.forEach(System.out::println);
        System.out.println("\n/// EDITAR /// \n");

        Producto actualizar = new Producto("Sillon",13.99);
        actualizar.setId(2);
        repo.editar(actualizar);

        System.out.println(actualizar);

        System.out.println("\n /// ELIMINAR /// \n");

        repo.eliminar(2);
        System.out.println();
        repo.listar().forEach(System.out::println);


    }
}
