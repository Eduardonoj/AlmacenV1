package com.eduardolopez.almacen.core.db;

import java.sql.Connection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Conexion {
    private static Conexion instancia;
    private final String PERSISTENCE_UNIT_NAME = "AlmacenPU";
    private EntityManager em;
    public Conexion(){
        try{
            em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME)
                    .createEntityManager();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
   
    public static Conexion getInstancia(){
        if(instancia == null){
            instancia = new Conexion();
        }
        return instancia;
    }
    public void save(Object elemento){
        try{
            em.getTransaction().begin();
            em.persist(elemento);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }
    public void update(Object elemento){
        try{
            em.getTransaction().begin();
            em.merge(elemento);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }
    public void delete(Object elemento){
        try{
            em.getTransaction().begin();
            em.remove(elemento);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }
    public List<?> findAll(Class<?> elemento){
        int posicion = elemento.getTypeName().lastIndexOf(".");
        String clase = elemento.getTypeName().substring(posicion + 1,elemento.getTypeName().length());
        return em.createNamedQuery(clase.concat(".findAll")).getResultList();
    }
    public Object findById(Class<?> clase, Long id){
        return em.find(clase.getClass(), id);
    }
    public Object findById(Class<?> clase, String id){
        return em.find(clase.getClass(), id);
    }
    public EntityManager getEm(){
        return this.em;
    }
    
     public Connection getConnection()
    {
        Connection conexionNativa = null;
        try{
            em.getTransaction().begin();
            conexionNativa = em.unwrap(Connection.class);
            em.getTransaction().commit();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return conexionNativa;
        
    }
}
