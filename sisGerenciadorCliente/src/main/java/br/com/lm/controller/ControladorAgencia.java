package br.com.lm.controller;

import br.com.lm.model.Agencia;
import br.com.lm.persistencia.RepositorioAgencia;
import br.com.lm.persistencia.RepositorioCliente;
import br.com.lm.utilitarios.Mensagem;
import java.util.List;

/**
 *
 * @author leone.pizzoli
 */
public class ControladorAgencia {

    RepositorioAgencia repAgen;
    List<Agencia> listaAgen;
    public void incluir(Agencia agencia) {
        repAgen = new RepositorioAgencia();
        try {
            if (repAgen.salvar(agencia)) {
            } else {
                Mensagem.showMsg("Impossível salvar Agencia");
            }
        } catch (Exception e) {

        }
    }

    public void alterar(Agencia agencia) {
        repAgen = new RepositorioAgencia();
        try {
            if (repAgen.Editar(agencia)) {

            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void excluir(Agencia agencia) {
        repAgen = new RepositorioAgencia();  
        try{
            if(repAgen.deletar(agencia)){
                Mensagem.showMsg("Agencia Excluída!");
            }else{
                Mensagem.showMsg("Não foi possível excluir agencia!");
            }   
        }catch(Exception e){
                
        }
    }

    
        public List consultar() {
        try {
          
            repAgen = new RepositorioAgencia();
            listaAgen = repAgen.listar();
            if (listaAgen != null){
                for(int i = 0; i < listaAgen.size(); i++){
                    Mensagem.showMsg("ID: "+listaAgen.get(i).getCodigo()+
                    "\nNome: "+listaAgen.get(i).getNome());
                   
                }
            }
        } catch (Exception e) {

        }
        return repAgen.listar();
    }

    public Agencia pesquisar(Agencia agencia) {
          try {
            repAgen = new RepositorioAgencia();
            agencia = repAgen.buscar(agencia.getCodigo());
            if (agencia.getCodigo() != null) {
                Mensagem.showMsg("ID: "+  agencia.getCodigo() + "\nNome: " +
                        agencia.getNome());
            }
        } catch (Exception e) {

        }
        return agencia;
    }
    
    public Agencia pegarAgencia(Agencia agencia) {
          try {
            repAgen = new RepositorioAgencia();
            agencia = repAgen.buscar(agencia.getCodigo());
            if (agencia.getCodigo() != null) { 
            }
        } catch (Exception e) {

        }
        return agencia;
    }

}
