package com.ciandt.mercadocit.backend.service;

import com.ciandt.mercadocit.backend.dao.UsuarioLikeDao;
import com.ciandt.mercadocit.backend.entity.UsuarioLike;
import com.google.api.server.spi.response.ConflictException;
import com.google.api.server.spi.response.NotFoundException;

import java.util.List;

/**
 * Created by Garage on 11/08/16.
 */

public class UsuarioLikeService {

    private UsuarioLikeDao usuarioLikeDao;

    public UsuarioLikeService() {usuarioLikeDao = new UsuarioLikeDao();}

    public List<UsuarioLike> list() {
        return usuarioLikeDao.listAll();
    }

    public List<UsuarioLike> listByUsuario(Long id) throws NotFoundException {
        List<UsuarioLike> list = usuarioLikeDao.listByProperty("idUsuario", id);

        if(list == null || list.size() < 1) {
            throw new NotFoundException("UsuarioLike nao encontrado");
        }

        return list;
    }


    public UsuarioLike getById(Long id) throws NotFoundException {
        UsuarioLike item = usuarioLikeDao.getByKey(id);

        if(item == null) {
            throw new NotFoundException("UsuarioLike nao encontrado");
        }

        return item;
    }


    public UsuarioLike insert(UsuarioLike item) throws ConflictException, NotFoundException {
        if(item == null)
        {
            throw new ConflictException("UsuarioLike nao informado.");
        }
        else if(item.getIdProduto() == null || item.getIdUsuario() == null)
        {
            throw new ConflictException("Id do UsuarioLike nao informado.");
        }

        UsuarioLike u = usuarioLikeDao.getProdutoFavoritoByUsuario(item.getIdProduto(), item.getIdUsuario());

        if(u != null)
        {
            throw new ConflictException("UsuarioLike ja cadastrado: Usuario:" + u.getIdUsuario()+" Favorito: "+u.getIdProduto());
        }

        return usuarioLikeDao.insert(item);
    }


    public void update(UsuarioLike item) throws ConflictException, NotFoundException {
        if(item == null)
        {
            throw new ConflictException("UsuarioLike nao informado.");
        }
        else if(item.getIdProduto() == null || item.getIdUsuario() == null)
        {
            throw new ConflictException("Nome do UsuarioLike nao informado.");
        }


        UsuarioLike u = usuarioLikeDao.getById(item.getId());

        if(u == null) {
            throw new NotFoundException("UsuarioLike nao encontrado");
        }

        u = usuarioLikeDao.getProdutoFavoritoByUsuario(item.getIdProduto(),item.getIdUsuario());

        if(u != null && !u.getId().equals(item.getId())) {
            throw new ConflictException("UsuarioLike ja cadastrado: Usuario:" + u.getIdUsuario() + " Favorito: " + u.getIdProduto());
        }

        usuarioLikeDao.update(item);
    }


    public void remove(long id) throws ConflictException, NotFoundException {
        UsuarioLike item = usuarioLikeDao.getByKey(id);

        if(item == null) {
            throw new NotFoundException("UsuarioLike nao encontrado");
        }

        usuarioLikeDao.delete(item);
    }
}
