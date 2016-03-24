package com.ciandt.mercadocit.backend.util;

import com.ciandt.mercadocit.backend.entity.Base;
import com.ciandt.mercadocit.backend.entity.Predio;
import com.ciandt.mercadocit.backend.entity.Usuario;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;

/**
 * Created by rodrigosclosa on 29/12/15.
 */
public class OfyService {

    static {
        ObjectifyService.register(Base.class);
        ObjectifyService.register(Predio.class);
        ObjectifyService.register(Usuario.class);
    }

    public static Objectify ofy() {
        return ObjectifyService.ofy();
    }

    public static ObjectifyFactory factory() {
        return ObjectifyService.factory();
    }

}