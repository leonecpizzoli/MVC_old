package br.com.lm.model;

import br.com.lm.utilitarios.Mensagem;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author leone.pizzoli
 */
@Entity
public class Agencia implements Serializable {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    @Column (length = 40, nullable = false)
    private String nome;

    public Agencia() {
    }

    public Agencia(Long codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
     @Override
    public String toString() {
        return "Agencia{" + "codigo=" + codigo + ", nome=" + nome + '}';
    }
    
    public boolean validaAgencia(){
        boolean valido = false;
        if(nome.equals("")|| codigo == null){
            Mensagem.showMsg("Nome ou ID vazios");
            valido = false;
        }else{
            valido = true;
        }
        return valido;
    }

    
}
