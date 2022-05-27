package com.portfolio.fabian8.dao;

import com.portfolio.fabian8.model.*;

import java.util.List;

public interface Dao {

    List<Proyecto> getList();
    List<Sobremi> getListSobremi();
    List<HabilidadesBlandas> getListHabilidadesBlandas();
    List<HabilidadesDuras> getListHabilidadesDuras();

    void borarProyecto(long id);
    void borarHabilidadDura(long id);
    void borarHabilidadBlanda(long id);
    void borrarSobreMi(long id);

    void editarProyecto();
    void crearProyecto(Proyecto proyecto);
    void crearDura(HabilidadesDuras hd);
    void crearBlanda(HabilidadesBlandas hb);
    void crearSobreMi(Sobremi sm);

    void modificarProyecto(long id);

    Usuario obtenerUsuarioPorCredenciales(Usuario usuario);

}
