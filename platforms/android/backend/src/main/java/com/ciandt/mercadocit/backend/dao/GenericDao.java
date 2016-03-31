package com.ciandt.mercadocit.backend.dao;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.cmd.Query;
import com.google.appengine.api.datastore.Query.Filter;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import static com.ciandt.mercadocit.backend.util.OfyService.ofy;

/**
 * Created by rodrigosclosa on 29/12/15.
 */
public class GenericDao<T> implements IGenericDao<T> {

    protected Class<T> clazz;

    @SuppressWarnings("unchecked")
    public GenericDao() {
        clazz = ((Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    }

    @Override
    public Key<T> save(T entity) {
        return ofy().save().entity(entity).now();
    }

    @Override
    public void insert(T entity) {
        save(entity);
    }

    @Override
    public void delete(T entity) {
        ofy().delete().entity(entity).now();
    }

    @Override
    public void update(T entity) {
        save(entity);
    }

    @Override
    public List<T> listAll() {
        Query<T> query = ofy().load().type(clazz);
        return query.list();
    }

    @Override
      public T getByProperty(String propName, Object propValue) {
        return ofy().load().type(clazz).filter(propName, propValue).first().now();
    }

    @Override
    public T getByPropertys(List<String> propNames, List<Object> propValues) {
        Query<T> query = ofy().load().type(clazz);
        for(int index=0; index < propNames.size();index++){
            query = query.filter(propNames.get(index),propValues.get(index));
        }
        return query.list().get(0);
    }

    @Override
    public T getByFilter(Filter filtro) {
        return ofy().load().type(clazz).filter(filtro).first().now();
    }

    @Override
    public T getById(Long id) {
        return ofy().load().type(clazz).id(id).now();
    }

    @Override
    public T getByKey(Long id) {
        return ofy().load().key(Key.create(clazz, id)).now();
    }

    @Override
    public List<T> listByProperty(String propName, Object propValue) {
        return ofy().load().type(clazz).filter(propName, propValue).list();
    }

    @Override
    public List<T> listByFilter(Filter filtro) {
        return ofy().load().type(clazz).filter(filtro).list();
    }

    public List<T> listByStartWith(String field, String search) {
        Query query = ofy().load().type(clazz).filter(field + " >=", search);
        return query.filter(field + " <", search+"\ufffd").list();
    }
}
