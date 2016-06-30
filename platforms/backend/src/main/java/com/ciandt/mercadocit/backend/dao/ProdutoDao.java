package com.ciandt.mercadocit.backend.dao;

import com.ciandt.mercadocit.backend.entity.Produto;

import java.util.List;

import static com.ciandt.mercadocit.backend.util.OfyService.ofy;

/**
 * Created by Gabriel on 29/03/2016.
 */
public class ProdutoDao extends GenericDao<Produto> {
    public List<Produto> getProdutosByUsuario(Long idUsuario){
        return ofy().load().type(Produto.class).filter("idUsuario",idUsuario).list();
    }
}
