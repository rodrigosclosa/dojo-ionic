package com.ciandt.mercadocit.backend.service;

import com.ciandt.mercadocit.backend.dao.ProdutoComentarioDao;
import com.ciandt.mercadocit.backend.entity.ProdutoComentario;
import com.google.api.server.spi.response.ConflictException;
import com.google.api.server.spi.response.NotFoundException;

import java.util.List;

/**
 * Created by Garage on 07/04/16.
 */
public class ProdutoComentarioService {
    private ProdutoComentarioDao produtoComentarioDao;

    public ProdutoComentarioService() {
        produtoComentarioDao = new ProdutoComentarioDao();
    }


    public List<ProdutoComentario> list() {
        return produtoComentarioDao.listAll();
    }

    public List<ProdutoComentario> listByProduto(Long id) throws NotFoundException {
        List<ProdutoComentario> list = produtoComentarioDao.listByProperty("idProduto", id);

        if(list == null || list.size() < 1) {
            throw new NotFoundException("ProdutoComentario nao encontrado");
        }

        return list;
    }


    public ProdutoComentario getById(Long id) throws NotFoundException {
        ProdutoComentario item = produtoComentarioDao.getByKey(id);

        if(item == null) {
            throw new NotFoundException("ProdutoComentario nao encontrado");
        }

        return item;
    }


    public ProdutoComentario insert(ProdutoComentario item) throws ConflictException, NotFoundException {
        if(item == null)
        {
            throw new ConflictException("ProdutoComentario nao informado.");
        }
        else if(item.getComentario() == null || item.getComentario().isEmpty())
        {
            throw new ConflictException("Comentario nao informado.");
        }

        return produtoComentarioDao.insert(item);
    }


    public void update(ProdutoComentario item) throws ConflictException, NotFoundException {
        if(item == null)
        {
            throw new ConflictException("ProdutoComentario nao informado.");
        }
        else if(item.getComentario() == null || item.getComentario().isEmpty())
        {
            throw new ConflictException("Nome do ProdutoComentario nao informado.");
        }


        ProdutoComentario u = produtoComentarioDao.getById(item.getId());

        if(u == null) {
            throw new NotFoundException("ProdutoComentario nao encontrado");
        }

        produtoComentarioDao.update(item);
    }


    public void remove(long id) throws ConflictException, NotFoundException {
        ProdutoComentario item = produtoComentarioDao.getByKey(id);

        if(item == null) {
            throw new NotFoundException("ProdutoComentario nao encontrado");
        }

        produtoComentarioDao.delete(item);
    }
}
