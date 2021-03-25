
import br.com.lm.model.Cliente;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import br.com.lm.utilitarios.HibernateUtil;
import org.hibernate.Transaction;

/**
 *
 * @author leone.pizzoli
 */
public class HibernateUtilTeste {

    @Test
    public void conectar() {
        SessionFactory fabrica = HibernateUtil.getFabricaDeSessoes();
        Cliente cliente1 = new Cliente();
        Cliente cliente2 = new Cliente();
        Cliente cliente3 = new Cliente();
        Session sessao = fabrica.openSession();
        Transaction iniciar = sessao.beginTransaction();
        sessao.saveOrUpdate(cliente1);
        sessao.saveOrUpdate(cliente2);
        sessao.saveOrUpdate(cliente3);
        iniciar.commit();
        sessao.close();
        HibernateUtil.getFabricaDeSessoes().close();
    }
}
