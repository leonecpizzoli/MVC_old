package br.com.lm.utilitarios;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author leone.pizzoli
 */
public class Criptografia {
    public String criptografia(String senha){
        MessageDigest md;
        BigInteger hash;
        String retorno = "";
        try{
            md = MessageDigest.getInstance("MDS");
            hash = new BigInteger(1, md.digest(senha.getBytes()));
            
        }catch(NoSuchAlgorithmException e){
            System.out.println(e);
        }
        return retorno;
    }
}
