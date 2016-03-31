package com.ciandt.mercadocit.backend.service;

import com.ciandt.mercadocit.backend.dao.BaseDao;
import com.ciandt.mercadocit.backend.entity.Base;
import com.google.api.server.spi.response.ConflictException;
import com.google.api.server.spi.response.NotFoundException;

import java.util.List;

/**
 * Created by rodrigosclosa on 29/12/15.
 */
public class BaseService {

    private BaseDao baseDao;

    public BaseService() {
        baseDao = new BaseDao();
    }
    
    public List<Base> list() {
        return baseDao.listAll();
    }
    
    public List<Base> list(String nome) throws NotFoundException {
        List<Base> list = baseDao.listByProperty("nome", nome);

        if(list == null || list.size() < 1) {
            throw new NotFoundException("Tipo de incidente não encontrado");
        }

        return list;
    }
    
    public Base getById(Long id) throws NotFoundException {
        Base item = baseDao.getByKey(id);

        if(item == null) {
            throw new NotFoundException("Tipo de incidente não encontrado");
        }

        return item;
    }
    
    public void insert(Base item) throws ConflictException, NotFoundException {
        if(item == null)
        {
            throw new ConflictException("Usuário não informado.");
        }
        else if(item.getNome() == null || item.getNome().isEmpty())
        {
            throw new ConflictException("Nome do usuário não informado.");
        }

        Base u = baseDao.getByProperty("nome", item.getNome());

        if(u != null)
        {
            throw new ConflictException("Descrição já cadastrado: " + u.getNome());
        }

        baseDao.insert(item);
    }
    
    public void update(Base item) throws ConflictException, NotFoundException {
        if(item == null)
        {
            throw new ConflictException("Usuário não informado.");
        }
        else if(item.getNome() == null || item.getNome().isEmpty())
        {
            throw new ConflictException("Nome do usuário não informado.");
        }

        Base u = baseDao.getById(item.getId());

        if(u == null) {
            throw new NotFoundException("Tipo de incidente não encontrado");
        }

        u = baseDao.getByProperty("descricao", item.getNome());

        if(u != null && !u.getId().equals(item.getId()))
        {
            throw new ConflictException("Descrição já cadastrada: " + u.getNome());
        }

        baseDao.update(item);
    }

    public void remove(long id) throws ConflictException, NotFoundException {
        Base item = baseDao.getByKey(id);

        if(item == null) {
            throw new NotFoundException("Tipo de Incidente não encontrado");
        }

        baseDao.delete(item);
    }
}
