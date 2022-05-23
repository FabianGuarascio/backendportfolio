package com.portfolio.fabian8.dao;

import com.portfolio.fabian8.model.Proyecto;
import com.portfolio.fabian8.model.Usuario;

import java.util.List;

public interface Dao {

    List<Proyecto> getList();
    void borarProyecto(long id);
    void editarProyecto();
    void crearProyecto(Proyecto proyecto);
    void modificarProyecto(long id);

    Usuario obtenerUsuarioPorCredenciales(Usuario usuario);

}
