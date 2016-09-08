package com.ciandt.mercadocit.backend.service;

import com.ciandt.mercadocit.backend.dao.ProdutoDao;
import com.ciandt.mercadocit.backend.dao.UsuarioDao;
import com.ciandt.mercadocit.backend.entity.Produto;
import com.ciandt.mercadocit.backend.entity.Usuario;
import com.google.api.server.spi.response.ConflictException;
import com.google.api.server.spi.response.NotFoundException;

import java.util.List;

/**
 * Created by gsanchez on 30/03/2016.
 */
public class ProdutoService {
    private ProdutoDao produtoDao;
    private UsuarioDao usuarioDao;

    public ProdutoService() {
        produtoDao = new ProdutoDao();
        usuarioDao = new UsuarioDao();
    }

    public List<Produto> list() {
        return produtoDao.listAll();
    }


    public List<Produto> list(String nome) throws NotFoundException {
        List<Produto> list = produtoDao.listByProperty("nome", nome);

        if (list == null || list.size() < 1) {
            throw new NotFoundException("Produto nao encontrado");
        }

        return list;
    }

    public List<Produto> listByUsuario(String nomeUsuario){
        Usuario usuario = usuarioDao.getByProperty("nome",nomeUsuario);
        if(usuario != null){
            return produtoDao.getProdutosByUsuario(usuario.getId());
        }
        return null;
    }

    public List<Produto> listByBase(Long id) throws NotFoundException {
        List<Produto> list = produtoDao.listByProperty("idBase", id);

        if (list == null || list.size() < 1) {
            throw new NotFoundException("Produto nao encontrado");
        }

        return list;
    }

    public List<Produto> listByOffset(int offset) throws NotFoundException{
        return produtoDao.getByOffset(offset);
    }


    public Produto getById(Long id) throws NotFoundException {
        Produto item = produtoDao.getByKey(id);

        if (item == null) {
            throw new NotFoundException("Produto nao encontrado");
        }

        return item;
    }


    public Produto insert(Produto item) throws ConflictException, NotFoundException {
        if (item == null) {
            throw new ConflictException("Produto nao informado.");
        } else if (item.getNome() == null || item.getNome().isEmpty() || item.getDescricao() == null || item.getDescricao().isEmpty()) {
            throw new ConflictException("Produto possui erros.");
        }

        Produto u = produtoDao.getByProperty("nome", item.getNome());

        if (u != null) {
            throw new ConflictException("Produto ja cadastrado: " + u.getNome());
        }

        return produtoDao.insert(item);
    }


    public void update(Produto item) throws ConflictException, NotFoundException {
        if (item == null) {
            throw new ConflictException("Produto nao informado.");
        } else if (item.getNome() == null || item.getNome().isEmpty() || item.getDescricao() == null || item.getDescricao().isEmpty() ) {
            throw new ConflictException("Produto possui erros.");
        }


        Produto u = produtoDao.getById(item.getId());

        if (u == null) {
            throw new NotFoundException("Produto nao encontrado");
        }

        u = produtoDao.getByProperty("nome", item.getNome());

        if (u != null && !u.getId().equals(item.getId())) {
            throw new ConflictException("Produto ja cadastrado: " + u.getNome());
        }

        produtoDao.update(item);
    }


    public void remove(long id) throws ConflictException, NotFoundException {
        Produto item = produtoDao.getByKey(id);

        if (item == null) {
            throw new NotFoundException("Produto nao encontrado");
        }

        produtoDao.delete(item);
    }
}
