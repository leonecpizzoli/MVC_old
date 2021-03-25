package br.com.lm.model;

import br.com.lm.utilitarios.Criptografia;
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
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    @Column(length = 40, nullable = false)
    private String nome;
    @Column(length = 40, nullable = false)
    private String login;
    @Column(length = 40, nullable = false)
    private String senha;

    private String confirma;

    public Cliente() {
        nome = "";
        login = "";
        senha = "";
        confirma = "";
    }

    public Cliente(Long codigo, String nome, String login, String senha, String confirma) {
        this.codigo = codigo;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.confirma = confirma;

    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long condigo) {
        this.codigo = condigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getConfirma() {
        return confirma;
    }

    public void setConfirma(String confirma) {
        this.confirma = confirma;
    }

    @Override
    public String toString() {
        return "Cliente{" + "condigo=" + codigo + ", nome=" + nome + ", login=" + login + ", senha=" + senha + '}';
    }

    public Boolean confirmaSenha() {
        boolean confirmado = false;
        try {
            if (!confirma.equals(senha)) {
                nome = "";
                login = "";
                senha = "";
                confirma = "";
                confirmado = false;
            } else {
                confirmado = true;
            }
        } catch (Exception e) {

        }
        return confirmado;
    }

    public Boolean validaCliente() {
        boolean valido = false;
        if (nome.equals("") && login.equals("") && senha.equals("")
                && confirma.equals("")) {
            valido = false;
        } else {
            valido = true;
        }
        return valido;
    }

}
