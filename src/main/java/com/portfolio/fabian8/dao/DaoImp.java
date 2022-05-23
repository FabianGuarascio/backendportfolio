package com.portfolio.fabian8.dao;

import com.portfolio.fabian8.model.Proyecto;
import com.portfolio.fabian8.model.Usuario;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class DaoImp implements Dao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public List<Proyecto> getList() {
        String query= "FROM Proyecto";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void borarProyecto(long id) {
        Proyecto proyecto= entityManager.find(Proyecto.class,id);
        entityManager.remove(proyecto);
    }

    @Override
    public void editarProyecto() {

    }

    @Override
    public void crearProyecto(Proyecto proyecto) {
        entityManager.merge(proyecto);
    }

    @Override
    public void modificarProyecto(long id) {
        Proyecto proyecto= entityManager.find(Proyecto.class,id);
        entityManager.merge(proyecto);

    }

    @Override
    public Usuario obtenerUsuarioPorCredenciales(Usuario usuario) {
        String query = "FROM Usuario WHERE email = :email AND password = :password";

        List<Usuario> lista = entityManager.createQuery(query)
                .setParameter("email", usuario.getEmail()).setParameter("password",usuario.getPassword())
                .getResultList();

        if (lista.isEmpty()) {
            return null;
        }
        return lista.get(0);
    }
}
