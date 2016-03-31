package com.ciandt.mercadocit.backend.service;

import com.ciandt.mercadocit.backend.dao.ProdutoFotoDao;
import com.ciandt.mercadocit.backend.entity.ProdutoFoto;
import com.google.api.server.spi.response.ConflictException;
import com.google.api.server.spi.response.NotFoundException;

import java.util.List;

/**
 * Created by gsanchez on 30/03/2016.
 */
public class ProdutoFotoService {
    
    private ProdutoFotoDao produtoFotoDao;

    public ProdutoFotoService() {produtoFotoDao = new ProdutoFotoDao();}

    public List<ProdutoFoto> list() {
        return produtoFotoDao.listAll();
    }


    public List<ProdutoFoto> list(String nome) throws NotFoundException {
        List<ProdutoFoto> list = produtoFotoDao.listByProperty("nome", nome);

        if(list == null || list.size() < 1) {
            throw new NotFoundException("ProdutoFoto nao encontrado");
        }

        return list;
    }

    public List<ProdutoFoto> listByIdProduto(Long idProduto) throws NotFoundException {
        List<ProdutoFoto> list = produtoFotoDao.listByProperty("idProduto", idProduto);

        if(list == null || list.size() < 1) {
            throw new NotFoundException("ProdutoFoto nao encontrado");
        }

        return list;
    }

    public List<ProdutoFoto> listByBase(Long id) throws NotFoundException {
        List<ProdutoFoto> list = produtoFotoDao.listByProperty("idBase", id);

        if(list == null || list.size() < 1) {
            throw new NotFoundException("ProdutoFoto nao encontrado");
        }

        return list;
    }


    public ProdutoFoto getById(Long id) throws NotFoundException {
        ProdutoFoto item = produtoFotoDao.getByKey(id);

        if(item == null) {
            throw new NotFoundException("ProdutoFoto nao encontrado");
        }

        return item;
    }


    public void insert(ProdutoFoto item) throws ConflictException, NotFoundException {
        if(item == null)
        {
            throw new ConflictException("ProdutoFoto nao informado.");
        }
        else if(item.getNome() == null || item.getNome().isEmpty())
        {
            throw new ConflictException("Nome do ProdutoFoto nao informado.");
        }

        ProdutoFoto u = produtoFotoDao.getByProperty("nome", item.getNome());

        if(u != null)
        {
            throw new ConflictException("ProdutoFoto ja cadastrado: " + u.getNome());
        }

        produtoFotoDao.insert(item);
    }


    public void update(ProdutoFoto item) throws ConflictException, NotFoundException {
        if(item == null)
        {
            throw new ConflictException("ProdutoFoto nao informado.");
        }
        else if(item.getNome() == null || item.getNome().isEmpty())
        {
            throw new ConflictException("Nome do ProdutoFoto nao informado.");
        }


        ProdutoFoto u = produtoFotoDao.getById(item.getId());

        if(u == null) {
            throw new NotFoundException("ProdutoFoto nao encontrado");
        }

        u = produtoFotoDao.getByProperty("nome", item.getNome());

        if(u != null && !u.getId().equals(item.getId()))
        {
            throw new ConflictException("ProdutoFoto ja cadastrado: " + u.getNome());
        }

        produtoFotoDao.update(item);
    }


    public void remove(long id) throws ConflictException, NotFoundException {
        ProdutoFoto item = produtoFotoDao.getByKey(id);

        if(item == null) {
            throw new NotFoundException("ProdutoFoto nao encontrado");
        }

        produtoFotoDao.delete(item);
    }
}
