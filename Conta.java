/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agencia;

/**
 *
 * @author Alyson
 */
public class Conta {
    
    private int numero;
    private double saldo;

    public Conta(int numero, double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }
    
    public void deposito(double valor){
        System.out.println("Saldo anterior" + saldo);
        saldo += valor;
        System.out.println("Saldo atual"+ saldo);
    }
    
    public boolean saque(double valor){
        if(saldo > valor){
         saldo = saldo - valor;
         return true;
        }
        return false;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Conta{" + "numero=" + numero + ", saldo=" + saldo + '}';
    }

    
}
