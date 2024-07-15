package org.schroh.interfaces.repositorio;

import org.schroh.interfaces.modelo.BaseEntity;

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
    public T porId(Integer id) {
        T t = null;
        for (T cli: dataSource){
            if (cli.getId().equals(id)){
                t = cli;
                break;
            }
        }
        return t;
    }

    @Override
    public void crear(T t) {
        this.dataSource.add(t);
    }


    @Override
    public void eliminar(Integer id) {
        this.dataSource.remove(this.porId(id));
    }

    @Override
    public List<T> listar(int desde, int hasta) {
        return dataSource.subList(desde, hasta);
    }
}
