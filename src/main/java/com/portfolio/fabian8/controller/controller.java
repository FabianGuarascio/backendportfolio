package com.portfolio.fabian8.controller;

import com.portfolio.fabian8.dao.Dao;
import com.portfolio.fabian8.model.*;
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
    @RequestMapping(value = "api/sobremi")
    public List<Sobremi> getsobremi(){
        return dao.getListSobremi();
    }

    @CrossOrigin
    @RequestMapping(value = "api/habilidadesDuras")
    public List<HabilidadesDuras> getDuras(){
        return dao.getListHabilidadesDuras();
    }

    @CrossOrigin
    @RequestMapping(value = "api/habilidadesBlandas")
    public List<HabilidadesBlandas> getBlandas(){
        return dao.getListHabilidadesBlandas();
    }

    @CrossOrigin
    @RequestMapping(value = "api/proyectos/crear", method = RequestMethod.POST)
    public void crear(@RequestHeader(value="Authorization") String token,@RequestBody Proyecto proyecto){
        if (!validarToken(token)) { return; }
        dao.crearProyecto(proyecto);
    }
    @CrossOrigin
    @RequestMapping(value = "api/habilidadesDuras/crear", method = RequestMethod.POST)
    public void crearDura(@RequestHeader(value="Authorization") String token,@RequestBody HabilidadesDuras hd){
        if (!validarToken(token)) { return; }
        dao.crearDura(hd);
    }

    @CrossOrigin
    @RequestMapping(value = "api/habilidadesBlandas/crear", method = RequestMethod.POST)
    public void crearBlanda(@RequestHeader(value="Authorization") String token,@RequestBody HabilidadesBlandas hb){
        if (!validarToken(token)) { return; }
        dao.crearBlanda(hb);
    }

    @CrossOrigin
    @RequestMapping(value = "api/sobremi/crear", method = RequestMethod.POST)
    public void crearBlanda(@RequestHeader(value="Authorization") String token,@RequestBody Sobremi sm){
        if (!validarToken(token)) { return; }
        dao.crearSobreMi(sm);
    }

    @CrossOrigin
    @RequestMapping(value = "api/proyectos/{id}",method = RequestMethod.DELETE)
    public void borrar(@RequestHeader(value="Authorization") String token,@PathVariable long id){
        if (!validarToken(token)) { return; }
        dao.borarProyecto(id);
    }

    @CrossOrigin
    @RequestMapping(value = "api/habilidadesDuras/{id}",method = RequestMethod.DELETE)
    public void borrarHabilidadDura(@RequestHeader(value="Authorization") String token,@PathVariable long id){
        if (!validarToken(token)) { return; }
        dao.borarHabilidadDura(id);
    }

    @CrossOrigin
    @RequestMapping(value = "api/habilidadesBlandas/{id}",method = RequestMethod.DELETE)
    public void borrarHabilidadBlanda(@RequestHeader(value="Authorization") String token,@PathVariable long id){
        if (!validarToken(token)) { return; }
        dao.borarHabilidadBlanda(id);
    }

    @CrossOrigin
    @RequestMapping(value = "api/sobremi/{id}",method = RequestMethod.DELETE)
    public void borrarSobreMi(@RequestHeader(value="Authorization") String token,@PathVariable long id){
        if (!validarToken(token)) { return; }
        dao.borrarSobreMi(id);
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
