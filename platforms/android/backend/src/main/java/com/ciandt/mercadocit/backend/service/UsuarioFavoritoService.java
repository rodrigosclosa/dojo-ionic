package com.ciandt.mercadocit.backend.service;

import com.ciandt.mercadocit.backend.dao.UsuarioFavoritoDao;
import com.ciandt.mercadocit.backend.entity.UsuarioFavorito;
import com.google.api.server.spi.response.ConflictException;
import com.google.api.server.spi.response.NotFoundException;

import java.util.List;

/**
 * Created by gsanchez on 31/03/2016.
 */
public class UsuarioFavoritoService {
    private UsuarioFavoritoDao usuarioFavoritoDao;

    public UsuarioFavoritoService() {usuarioFavoritoDao = new UsuarioFavoritoDao();}

    public List<UsuarioFavorito> list() {
        return usuarioFavoritoDao.listAll();
    }


    public List<UsuarioFavorito> list(String nome) throws NotFoundException {
        List<UsuarioFavorito> list = usuarioFavoritoDao.listByProperty("nome", nome);

        if(list == null || list.size() < 1) {
            throw new NotFoundException("UsuarioFavorito nao encontrado");
        }

        return list;
    }

    public List<UsuarioFavorito> listByUsuario(Long id) throws NotFoundException {
        List<UsuarioFavorito> list = usuarioFavoritoDao.listByProperty("idUsuario", id);

        if(list == null || list.size() < 1) {
            throw new NotFoundException("UsuarioFavorito nao encontrado");
        }

        return list;
    }


    public UsuarioFavorito getById(Long id) throws NotFoundException {
        UsuarioFavorito item = usuarioFavoritoDao.getByKey(id);

        if(item == null) {
            throw new NotFoundException("UsuarioFavorito nao encontrado");
        }

        return item;
    }


    public void insert(UsuarioFavorito item) throws ConflictException, NotFoundException {
        if(item == null)
        {
            throw new ConflictException("UsuarioFavorito nao informado.");
        }
        else if(item.getIdProduto() == null || item.getIdUsuario() == null)
        {
            throw new ConflictException("Nome do UsuarioFavorito nao informado.");
        }

        UsuarioFavorito u = usuarioFavoritoDao.getUsuarioFavoritoByIds(item.getIdProduto(), item.getIdUsuario());

        if(u != null)
        {
            throw new ConflictException("UsuarioFavorito ja cadastrado: Usuario:" + u.getIdUsuario()+" Produto: "+u.getIdProduto());
        }

        usuarioFavoritoDao.insert(item);
    }


    public void update(UsuarioFavorito item) throws ConflictException, NotFoundException {
        if(item == null)
        {
            throw new ConflictException("UsuarioFavorito nao informado.");
        }
        else if(item.getIdProduto() == null || item.getIdUsuario() == null)
        {
            throw new ConflictException("Nome do UsuarioFavorito nao informado.");
        }


        UsuarioFavorito u = usuarioFavoritoDao.getById(item.getId());

        if(u == null) {
            throw new NotFoundException("UsuarioFavorito nao encontrado");
        }

        u = usuarioFavoritoDao.getUsuarioFavoritoByIds(item.getIdProduto(),item.getIdUsuario());

        if(u != null && !u.getId().equals(item.getId())) {
            throw new ConflictException("UsuarioFavorito ja cadastrado: Usuario:" + u.getIdUsuario() + " Produto: " + u.getIdProduto());
        }

            usuarioFavoritoDao.update(item);
    }


    public void remove(long id) throws ConflictException, NotFoundException {
        UsuarioFavorito item = usuarioFavoritoDao.getByKey(id);

        if(item == null) {
            throw new NotFoundException("UsuarioFavorito nao encontrado");
        }

        usuarioFavoritoDao.delete(item);
    }
}
