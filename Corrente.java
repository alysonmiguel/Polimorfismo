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
public class Corrente extends Conta{
    
    private double tarifa;

    public Corrente(int numero, double saldo, double tarifa) {
        super(numero, saldo);
        this.tarifa = tarifa;
    }
    
    public void debitaTarifa(){
        setSaldo(getSaldo() - tarifa);
    }

    @Override
    public String toString() {
        return super.toString() + "Corrente{" + "tarifa=" + tarifa + '}';
    }

    
}
