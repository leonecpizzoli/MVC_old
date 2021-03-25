package br.com.lm.controller;

import br.com.lm.model.ContaCorrente;
import br.com.lm.persistencia.RepositorioCliente;
import br.com.lm.persistencia.RepositorioContaCorrente;
import br.com.lm.utilitarios.Mensagem;

/**
 *
 * @author leone.pizzoli
 */
public class ControladorContaCorrente {

    public ControladorContaCorrente() {
    }
    RepositorioContaCorrente repCC;
    public void incluir(ContaCorrente conta){
        repCC = new RepositorioContaCorrente();
        try{
            if(repCC.salvar(conta)){
            }else{
                Mensagem.showMsg("Impossível de salvar conta.");
            }
        }catch(Exception e){
            throw e;
        }
    }
    
    public void alterar(ContaCorrente conta){
    repCC = new RepositorioContaCorrente();
    try{
        if(repCC.Editar(conta)){        
        }else{
            Mensagem.showMsg("Não foi possível editar!");
        }
    }catch(Exception e){
        throw e;
    }
    }
    
    public void excluir(ContaCorrente conta){
        repCC = new RepositorioContaCorrente();
        try{
             if(repCC.deletar(conta)){
             }else{
                 Mensagem.showMsg("No es possible!");
             }
        }catch(Exception e){
            throw e;
        }
    }
    
    public String consultar(){
        return null;
    }
    public ContaCorrente deposita(ContaCorrente conta, double valor){
        return null;
    }
    public ContaCorrente saca(ContaCorrente conta, double valor){
        return null;
    }
    public ContaCorrente pesquisar(ContaCorrente conta){
         try{
             repCC = new RepositorioContaCorrente();
         
            conta = repCC.buscar(conta.getNroContaCorrente());
            if (conta.getNroContaCorrente()!= null) {
                Mensagem.showMsg("N° da conta: "+  conta.getNroContaCorrente()+ "\nNome do cliente: " +
                conta.getCliente()+ "\nAgencia: " +  conta.getAgencia()+ "\nSaldo: "+ conta.getSaldo());
            }
        }catch (Exception e) {

        }
        return conta;
    } 
    public ContaCorrente pesquisarEspecifico(ContaCorrente conta){
         try{
             repCC = new RepositorioContaCorrente();
         
            conta = repCC.buscar(conta.getNroContaCorrente());
            
        }catch (Exception e) {

        }
        return conta;
    } 
}
    

