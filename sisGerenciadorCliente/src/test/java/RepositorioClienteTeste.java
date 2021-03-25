
import br.com.lm.model.Cliente;
import br.com.lm.persistencia.RepositorioCliente;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author leone.pizzoli
 */
public class RepositorioClienteTeste {

    Cliente cliente;
    RepositorioCliente repCli;

    @Test
    public void salvar() {
        Cliente cliente = new Cliente();
        cliente.setCodigo(Long.MIN_VALUE);
        cliente.setNome("Leone");
        cliente.setLogin("leone.pizzoli");
        cliente.setSenha("123456");

        repCli = new RepositorioCliente();
        repCli.salvar(cliente);

    }

    @Test
    public void listar() {
        repCli = new RepositorioCliente();
        List<Cliente> resultado = repCli.listar();
        try {
            for (Cliente cliente : resultado) {
                System.out.println("Codigo: " + cliente.getCodigo()
                        + "\nNome: " + cliente.getNome() + "\nLogin: " + cliente.getLogin()
                        + "\nSenha: " + cliente.getSenha());
            }
            System.out.println();

        } catch (Exception e) {

        }

    }

    @Test
    public void buscar() {
        Long codigo = 1L;
        cliente = new RepositorioCliente().buscar(codigo);
        if (cliente == null) {
            System.out.println("Registro não encontrado: ");
        } else {
            System.out.println("Registro encontrado: ");
            System.out.println(cliente.toString());
        }
    }

    @Test
    public void excluir() {
        Long codigo = 4L;
        repCli = new RepositorioCliente();
        cliente = new RepositorioCliente().buscar(codigo);
        try {
            if (cliente != null) {
                repCli.deletar(cliente);
                System.out.println("Registro removido com sucesso!!");
                System.out.println(cliente.toString());
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
        repCli = new RepositorioCliente();
        Cliente cliente = new RepositorioCliente().buscar(codigo);

        if (cliente == null) {
            System.out.println("Registro não encontrado");
        } else {
            System.out.println("Registro Alterado com sucesso!");
            System.out.println(cliente.toString());
            editar(cliente);
            repCli.Editar(cliente);
        }
    }
    
    public void editar(Cliente cliente) {
        cliente.setNome("Leone");
        System.out.println(cliente.toString());
    }
}