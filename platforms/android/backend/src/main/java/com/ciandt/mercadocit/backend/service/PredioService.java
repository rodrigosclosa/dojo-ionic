package com.ciandt.mercadocit.backend.service;

import com.ciandt.mercadocit.backend.dao.PredioDao;
import com.ciandt.mercadocit.backend.entity.Predio;
import com.google.api.server.spi.response.ConflictException;
import com.google.api.server.spi.response.NotFoundException;

import java.util.List;

/**
 * Created by gsanchez on 24/03/2016.
 */
public class PredioService {
    private PredioDao predioDao;

    public PredioService() {
        predioDao = new PredioDao();
    }


    public List<Predio> list() {
        return predioDao.listAll();
    }


    public List<Predio> list(String nome) throws NotFoundException {
        List<Predio> list = predioDao.listByProperty("nome", nome);

        if(list == null || list.size() < 1) {
            throw new NotFoundException("Predio nao encontrado");
        }

        return list;
    }

    public List<Predio> listByBase(Long id) throws NotFoundException {
        List<Predio> list = predioDao.listByProperty("idBase", id);

        if(list == null || list.size() < 1) {
            throw new NotFoundException("Predio nao encontrado");
        }

        return list;
    }


    public Predio getById(Long id) throws NotFoundException {
        Predio item = predioDao.getByKey(id);

        if(item == null) {
            throw new NotFoundException("Predio nao encontrado");
        }

        return item;
    }


    public void insert(Predio item) throws ConflictException, NotFoundException {
        if(item == null)
        {
            throw new ConflictException("Predio nao informado.");
        }
        else if(item.getNome() == null || item.getNome().isEmpty())
        {
            throw new ConflictException("Nome do Predio nao informado.");
        }

        Predio u = predioDao.getByProperty("nome", item.getNome());

        if(u != null)
        {
            throw new ConflictException("Predio ja cadastrado: " + u.getNome());
        }

        predioDao.insert(item);
    }


    public void update(Predio item) throws ConflictException, NotFoundException {
        if(item == null)
        {
            throw new ConflictException("Predio nao informado.");
        }
        else if(item.getNome() == null || item.getNome().isEmpty())
        {
            throw new ConflictException("Nome do Predio nao informado.");
        }


        Predio u = predioDao.getById(item.getId());

        if(u == null) {
            throw new NotFoundException("Predio nao encontrado");
        }

        u = predioDao.getByProperty("nome", item.getNome());

        if(u != null && !u.getId().equals(item.getId()))
        {
            throw new ConflictException("Predio ja cadastrado: " + u.getNome());
        }

        predioDao.update(item);
    }


    public void remove(long id) throws ConflictException, NotFoundException {
        Predio item = predioDao.getByKey(id);

        if(item == null) {
            throw new NotFoundException("Predio nao encontrado");
        }

        predioDao.delete(item);
    }
}
