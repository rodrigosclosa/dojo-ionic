package com.ciandt.mercadocit.backend.dao;

import com.ciandt.mercadocit.backend.entity.Produto;
import com.ciandt.mercadocit.backend.util.Constantes;

import java.util.List;

import static com.ciandt.mercadocit.backend.util.OfyService.ofy;

/**
 * Created by Gabriel on 29/03/2016.
 */
public class ProdutoDao extends GenericDao<Produto> {
    public List<Produto> getProdutosByUsuario(Long idUsuario){
        return ofy().load().type(Produto.class).filter("idUsuario",idUsuario).list();
    }

    public List<Produto> getByOffset(int offset){
        return ofy().load().type(Produto.class).limit(Constantes.LIMIT_PRODUTO).offset(offset).list();
    }
}
