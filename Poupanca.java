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
public class Poupanca extends Conta {
    
    private double rendimento;
    
    public Poupanca(int numero, double saldo, double rendimento) {
        super(numero, saldo);
        this.rendimento = rendimento;
    }
    
    public void creditaRendimento(){
        setSaldo(getSaldo() + (getSaldo() * rendimento));
    }

    @Override
    public String toString() {
        return super.toString() + "Poupanca{" + "rendimento=" + rendimento + '}';
    }
    
}
