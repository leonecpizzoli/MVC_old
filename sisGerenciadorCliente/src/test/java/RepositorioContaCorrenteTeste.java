/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.com.lm.model.Cliente;
import br.com.lm.model.ContaCorrente;
import br.com.lm.persistencia.RepositorioAgencia;
import br.com.lm.persistencia.RepositorioContaCorrente;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 *
 * @author leone.pizzoli
 */
public class RepositorioContaCorrenteTeste {
    
    public RepositorioContaCorrenteTeste() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    Cliente cliente;
    RepositorioContaCorrente repCC;
    ContaCorrente conta;
    @Test
    public void salvar() {
        conta = new ContaCorrente();
        repCC = new RepositorioContaCorrente();
        conta.setNroContaCorrente(Long.MIN_VALUE);
        conta.setCliente(cliente.getNome());
        
        repCC.salvar(conta);

    }

    /*@Test
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
                repAgen.Excluir(agency);
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
}*/

}
