package com.ciandt.mercadocit.backend.dao;

import com.google.appengine.api.datastore.Query;
import com.googlecode.objectify.Key;

import java.util.List;

/**
 * Created by rodrigosclosa on 29/12/15.
 */
public interface IGenericDao<T> {

    Key<T> save(T entity);
    void insert(T entity);
    void delete(T entity);
    void update(T entity);
    List<T> listAll();
    T getByProperty(String propName, Object propValue);
    T getByFilter(Query.Filter filtro);
    T getById(Long id);
    T getByKey(Long id);
    List<T> listByProperty(String propName, Object propValue);
    List<T> listByFilter(Query.Filter filtro);
    List<T> listByStartWith(String field, String search);
    T getByPropertys(List<String> propNames, List<Object> propValues);
}
