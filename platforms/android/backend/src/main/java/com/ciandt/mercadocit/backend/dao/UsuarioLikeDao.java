package com.ciandt.mercadocit.backend.dao;

import com.ciandt.mercadocit.backend.entity.UsuarioLike;

import static com.ciandt.mercadocit.backend.util.OfyService.ofy;

/**
 * Created by Garage on 11/08/16.
 */

public class UsuarioLikeDao  extends GenericDao<UsuarioLike>{

    public UsuarioLike getProdutoFavoritoByUsuario(Long idProduto, Long idUsuario){
        return ofy().load().type(UsuarioLike.class).filter("idProduto",idProduto).filter("idUsuario",idUsuario).first().now();
    }
}
