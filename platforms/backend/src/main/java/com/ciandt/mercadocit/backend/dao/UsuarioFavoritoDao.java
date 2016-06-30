package com.ciandt.mercadocit.backend.dao;

import com.ciandt.mercadocit.backend.entity.UsuarioFavorito;


import java.util.List;

import static com.ciandt.mercadocit.backend.util.OfyService.ofy;

/**
 * Created by gsanchez on 31/03/2016.
 */
public class UsuarioFavoritoDao extends GenericDao<UsuarioFavorito>{

    public UsuarioFavorito getUsuarioFavoritoByIds(Long idProduto, Long idUsuario){
        return ofy().load().type(UsuarioFavorito.class).filter("idProduto",idProduto).filter("idUsuario",idUsuario).first().now();
    }
}
