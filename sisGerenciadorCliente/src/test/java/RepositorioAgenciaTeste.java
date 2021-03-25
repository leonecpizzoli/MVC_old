
import br.com.lm.model.Agencia;
import br.com.lm.model.Cliente;
import br.com.lm.persistencia.RepositorioAgencia;
import br.com.lm.persistencia.RepositorioCliente;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author leone.pizzoli
 */
public class RepositorioAgenciaTeste {
    Agencia agency;
    RepositorioAgencia repAgen;
    
   
     @Test
    public void salvar() {
        agency = new Agencia();
        repAgen = new RepositorioAgencia();
        agency.setCodigo(Long.MIN_VALUE);
        agency.setNome("Itaú");
        
        repAgen.salvar(agency);

    }

    @Test
    public void listar() {
        repAgen = new RepositorioAgencia();
        List<Agencia> resultado = repAgen.listar();
        try {
            for (Agencia agency : resultado) {
                System.out.println("Codigo: " + agency.getCodigo()
                        + "\nNome: " + agency.getNome());
            }
            System.out.println();

        } catch (Exception e) {

        }

    }

    @Test
   
    public void buscar() {
        Long codigo = 1L;
        agency = new RepositorioAgencia().buscar(codigo);
        if (agency == null) {
            System.out.println("Registro não encontrado: ");
        } else {
            System.out.println("Registro encontrado: ");
            System.out.println(agency.toString());
        }
    }

    @Test
    
    public void excluir() {
        Long codigo = 4L;
        repAgen = new RepositorioAgencia();
        agency = new RepositorioAgencia().buscar(codigo);
        try {
            if (agency != null) {
                repAgen.deletar(agency);
                System.out.println("Registro removido com sucesso!!");
                System.out.println(agency.toString());
            } else {
                System.out.println("Registro não encontrado: ");

            }

        } catch (Exception e) {
            throw e;
        }
    }

    @Test
    public void alterar() {
        Long codigo = 1L;
        repAgen = new RepositorioAgencia();
        Agencia agency = new RepositorioAgencia().buscar(codigo);

        if (agency == null) {
            System.out.println("Registro não encontrado");
        } else {
            System.out.println("Registro Alterado com sucesso!");
            System.out.println(agency.toString());
            editar(agency);
            repAgen.Editar(agency);
        }
    }
    
    public void editar(Agencia agency) {
        agency.setNome("Itaú");
        System.out.println(agency.toString());
    }
}
