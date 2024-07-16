package org.schroh.interfaces.repositorio;

import org.schroh.interfaces.modelo.BaseEntity;
import org.schroh.interfaces.repositorio.excepciones.EscrituraAccesoDatoException;
import org.schroh.interfaces.repositorio.excepciones.LecturaAccesoDatoException;
import org.schroh.interfaces.repositorio.excepciones.ObjetoRepetidoException;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractListRepositorio<T extends BaseEntity> implements FullRepositorio<T> {
    protected List<T> dataSource; // Seria nuestra base de datos ficsticia..

    public AbstractListRepositorio(){
        this.dataSource = new ArrayList<>();
    }

    @Override
    public List<T> listar() {
        return dataSource;
    }

    @Override
    public T porId(Integer id) throws LecturaAccesoDatoException{
        if (id == null || id <= 0 ){
            throw new LecturaAccesoDatoException("Id Invalido, debe ser mayor a 0");
        }
        T t = null;
        for (T cli: dataSource){
            if (cli.getId().equals(id)){
                t = cli;
                break;
            }
        }
        if (t == null){
            throw new LecturaAccesoDatoException("No existe el registro con id " + id);
        }

        return t;
    }

    @Override
    public void crear(T t) throws EscrituraAccesoDatoException, ObjetoRepetidoException, LecturaAccesoDatoException {
        if (t == null) {
            throw new EscrituraAccesoDatoException("Error al insertar objeto null");
        }
        if (dataSource.equals(t.getId())) {
            this.dataSource.add(t);
        } else {
            throw new ObjetoRepetidoException("El objeto ya se encuentra en la lista");
        }
    }


    @Override
    public void eliminar(Integer id)  throws LecturaAccesoDatoException{
        this.dataSource.remove(this.porId(id));
    }

    @Override
    public List<T> listar(int desde, int hasta) {
        return dataSource.subList(desde, hasta);
    }
}
