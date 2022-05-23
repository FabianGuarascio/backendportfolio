package com.portfolio.fabian8.controller;

import com.portfolio.fabian8.dao.Dao;
import com.portfolio.fabian8.model.Proyecto;
import com.portfolio.fabian8.model.Usuario;
import com.portfolio.fabian8.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class controller {

    @Autowired
    private Dao dao;

    @Autowired
    private JWTUtil jwtUtil;

    private boolean validarToken(String token) {
        String usuarioId = jwtUtil.getKey(token);
        return usuarioId != null;
    }


    @CrossOrigin
    @RequestMapping(value = "api/proyectos")
    public List<Proyecto> getProyectos(){
        return dao.getList();
    }

    @CrossOrigin
    @RequestMapping(value = "api/proyectos/crear", method = RequestMethod.POST)
    public void crear(@RequestHeader(value="Authorization") String token,@RequestBody Proyecto proyecto){
        if (!validarToken(token)) { return; }
        dao.crearProyecto(proyecto);
    }

    @CrossOrigin
    @RequestMapping(value = "api/proyectos/{id}",method = RequestMethod.DELETE)
    public void borrar(@RequestHeader(value="Authorization") String token,@PathVariable long id){
        if (!validarToken(token)) { return; }
        dao.borarProyecto(id);
    }



    @CrossOrigin
    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String login(@RequestBody Usuario usuario) {

        Usuario usuarioLogueado = dao.obtenerUsuarioPorCredenciales(usuario);
        if (usuarioLogueado != null) {
            String tokenJwt = jwtUtil.create(String.valueOf(usuarioLogueado.getId()), usuarioLogueado.getEmail());
            return tokenJwt;
        }
        return "FAIL";
    }

}
