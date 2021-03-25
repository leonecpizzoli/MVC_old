package br.com.lm.utilitarios;

import javax.swing.JOptionPane;

/**
 *
 * @author leone.pizzoli
 */
public class Mensagem {
    public static void showMsg(String msg){
        JOptionPane.showMessageDialog(null, msg);
    }
    public static String insertMsg(String msg){
        return JOptionPane.showInputDialog(null, msg);
        
    }
    
}
