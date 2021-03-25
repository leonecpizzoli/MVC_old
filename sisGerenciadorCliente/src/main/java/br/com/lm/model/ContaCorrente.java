package br.com.lm.model;

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
public class ContaCorrente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nroContaCorrente;
    @Column(length = 40, nullable = false)
    private String cliente;
    @Column(length = 40, nullable = false)
    private String agencia;
    @Column(length = 40, nullable = false)
    private double saldo ;

    public ContaCorrente() {
    }

    public ContaCorrente(Long nroContaCorrente, String cliente, String agencia, double saldo) {
        this.nroContaCorrente = nroContaCorrente;
        this.cliente = cliente;
        this.agencia = agencia;
        this.saldo = saldo;
    }

    public Long getNroContaCorrente() {
        return nroContaCorrente;
    }

    public void setNroContaCorrente(Long nroContaCorrente) {
        this.nroContaCorrente = nroContaCorrente;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;

    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "ContaCorrente{" + "nroContaCorrente=" + nroContaCorrente + ", cliente=" + cliente + ", agencia=" + agencia + ", saldo=" + saldo + '}';
    }

}