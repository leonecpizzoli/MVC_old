package br.com.lm.controller;

import br.com.lm.model.Cliente;
import br.com.lm.model.ContaCorrente;
import br.com.lm.persistencia.RepositorioCliente;
import br.com.lm.utilitarios.HibernateUtil;
import br.com.lm.utilitarios.Mensagem;
import br.com.lm.view.TelaListarClientes;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author leone.pizzoli
 */
public class ControladorCliente {

    public ControladorCliente() {
    }
    
    RepositorioCliente repCli;
     List<Cliente> listaCli;
    public void incluir(Cliente cliente) {
        repCli = new RepositorioCliente();
        try {
            if (!repCli.salvar(cliente)) {
            } else {
            }
        } catch (Exception e) {
            Mensagem.showMsg("Não pode inserir!");
        }
    }

    public void alterar(Cliente cliente) {
        repCli = new RepositorioCliente();
        try {
            if (repCli.Editar(cliente)) {
            } else {
                Mensagem.showMsg("\nNão pode ser editado!\n");
            }

        } catch (Exception e) {
            throw e;
        }
    }

    public void excluir(Cliente cliente) {
        repCli = new RepositorioCliente();
        try {
            if (repCli.deletar(cliente)) {
            } else {
                Mensagem.showMsg("Ocorreu um problema ao excluir");
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public List consultar() {
        try {
          
            repCli = new RepositorioCliente();
            listaCli = repCli.listar();
            if (listaCli != null){
                for(int i = 0; i < listaCli.size(); i++){
                    Mensagem.showMsg("ID: "+listaCli.get(i).getCodigo()+
                    "\nNome: "+listaCli.get(i).getNome()+
                    "\nLogin: "+listaCli.get(i).getLogin()+
                    "\nSenha: "+listaCli.get(i).getSenha());
                   
                }
            }
        } catch (Exception e) {

        }
        return repCli.listar();
    }

    public Cliente pesquisar(Cliente cliente) {
        try {
            repCli = new RepositorioCliente();
            cliente = repCli.buscar(cliente.getCodigo());
            if (cliente.getCodigo() != null) {
                Mensagem.showMsg("ID: "+  cliente.getCodigo() + "\nNome: " +
                cliente.getNome()+ "\nLogin: " +  cliente.getLogin() + "\nSenha: "+ cliente.getSenha());
            }
        } catch (Exception e) {

        }
        return cliente;
    }
    
    public Cliente pegarCliente(Cliente cliente) {
        try {
            repCli = new RepositorioCliente();
            cliente = repCli.buscar(cliente.getCodigo());
            
        } catch (Exception e) {

        }
        return cliente;
    }
  
}
