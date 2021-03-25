package br.com.lm.utilitarios;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author leone.pizzoli
 */
public class HibernateUtil {
    
    private static SessionFactory fabricaDeSessões = criarFabricaDeSessões();

    public static SessionFactory getFabricaDeSessoes(){
        return fabricaDeSessões;
    }
    private static SessionFactory criarFabricaDeSessões() {
        try{
            Configuration configuracao = new Configuration().configure();
            
            ServiceRegistry registro = new StandardServiceRegistryBuilder().applySettings(configuracao.getProperties()).build();
            
            SessionFactory fabrica =  configuracao.buildSessionFactory(registro);
            
            return fabrica;
        }catch(Throwable ex){
            System.err.println("\nA fabrica não foi criada\n" + ex);
                    
           throw new ExceptionInInitializerError(ex);
        }
    }
}