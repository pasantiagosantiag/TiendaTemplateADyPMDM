package ies.java;


import ies.java.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import static org.hibernate.cfg.JdbcSettings.*;

/**
 * Patrón sigleton
 */
public class SingletonFactory {

    private  SessionFactory sessionFactory=null;
    private static SingletonFactory connection=null;
    private Session session;

    private SingletonFactory() {

         this.sessionFactory = new Configuration()
                 .addAnnotatedClass(Usuario.class)
                 .addAnnotatedClass(Pedido.class)
                 .addAnnotatedClass(Localidad.class)
                 .addAnnotatedClass(LocalidadId.class)
                 .addAnnotatedClass(Articulo.class)
                 .addAnnotatedClass(Camara.class)
                 .addAnnotatedClass(Cesta.class)
                 .addAnnotatedClass(CestaId.class)
                 .addAnnotatedClass(Pedido.class)
                 .addAnnotatedClass(Direnvio.class)
                 .addAnnotatedClass(Linped.class)
                 .addAnnotatedClass(LinpedId.class)
                 .addAnnotatedClass(Provincia.class)
                 .addAnnotatedClass(Marca.class)
                 .addAnnotatedClass(Memoria.class)
                 .addAnnotatedClass(Objetivo.class)
                 .addAnnotatedClass(Pack.class)
                 .addAnnotatedClass(Ptienea.class)
                 .addAnnotatedClass(PtieneaId.class)
                 .addAnnotatedClass(Stock.class)

                 .setProperty(URL,"jdbc:mysql://192.168.10.225:3323/tiendaonline")
                 .setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver")
                 .setProperty("hibernate.connection.username", "iessequeros")
                 .setProperty("hibernate.connection.password", "iessequeros")
                 .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect")


                 //.setProperty("hibernate.dialect", "org.hibernate.orm:hibernate-community-dialects:6.6.4.Final")
                 .setProperty("hibernate.agroal.maxSize", 20)

                 .setProperty("hibernate.show_sql", true)
                // .setProperty("hibernate.hbm2ddl.auto", "update")

                 .setProperty(SHOW_SQL, false)
                 .setProperty(FORMAT_SQL, true)
                 .setProperty(HIGHLIGHT_SQL, true)
                 .buildSessionFactory();

        // export the inferred database schema
        sessionFactory.getSchemaManager().exportMappedObjects(true);

    }
    /*public SessionFactory getSessionFactory(){
        return sessionFactory;
    }*/
    public Session getSession(){
        if(this.session==null){
            session = sessionFactory.openSession();
        }
        return session;
    }
    public void closeSession(){
        session.close();
    }
    public static SingletonFactory getConnection() {
        if (connection== null) {
            connection=new SingletonFactory();
        }
        return connection;
    }
}
