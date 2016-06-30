package com.ciandt.mercadocit.backend.service;

import com.ciandt.mercadocit.backend.dao.UsuarioDao;
import com.ciandt.mercadocit.backend.entity.Usuario;
import com.google.api.server.spi.response.ConflictException;
import com.google.api.server.spi.response.NotFoundException;

import java.util.List;

/**
 * Created by Adriana on 29/03/2016.
 */
public class UsuarioService {

    private UsuarioDao usuarioDao;

    public UsuarioService(){
         usuarioDao = new UsuarioDao();
     }

    public List<Usuario> list(){
        return usuarioDao.listAll();
    }

    public List<Usuario> list(String nome) throws NotFoundException{
        List<Usuario> list = usuarioDao.listByProperty("nome", nome);

        if(list == null || list.size() < 1) {
            throw new NotFoundException("Nome não encontrado");
        }

        return list;
    }

    public Usuario getById(Long id) throws NotFoundException{
        Usuario usuario = usuarioDao.getByKey(id);

        if(usuario == null) {
            throw new NotFoundException("ID não encontrado");
        }

        return usuario;
    }

    public Usuario insert(Usuario usuario) throws ConflictException, NotFoundException{
        if(usuario == null) {
            throw new ConflictException("Usuario não informado.");
        }
        else if(usuario.getNome() == null || usuario.getNome().isEmpty()){
            throw new ConflictException("Nome do usuário não encontrado.");
        }

        Usuario u = usuarioDao.getByProperty("nome", usuario.getNome());

        if(u != null){
            throw new ConflictException("Nome já existente" + u.getNome());
        }

        return usuarioDao.insert(usuario);
    }

    public void update(Usuario usuario) throws ConflictException, NotFoundException{
        if(usuario == null){
            throw new ConflictException("Usuario não informado.");
        }
        else if(usuario.getNome() == null || usuario.getNome().isEmpty()){
            throw new ConflictException("Nome do usuário não informado.");
        }

        Usuario u = usuarioDao.getByKey(usuario.getId());

        if(u == null){
            throw new NotFoundException("Usuário não encontrado.");
        }

        if(u.getNome().equals(usuario.getNome())){
           throw new ConflictException("Nome já existente");
        }

        usuarioDao.update(usuario);
    }

    public void remove(Long id) throws ConflictException, NotFoundException{
        Usuario u = usuarioDao.getByKey(id);

        if(u == null){
            throw new NotFoundException("Usuario não encontrado.");
        }

        usuarioDao.delete(u);
    }
}
