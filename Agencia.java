/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agencia;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Alyson
 */
public class Agencia {

    private ArrayList<Conta> contas = new ArrayList<>();
    private Scanner entrada = new Scanner(System.in);
    int numero = 0;

    public void menu() {
        int op;
        int nc;
        do {
            System.out.println("\n1-Criar Conta \n2-Acessar Conta \n3-Sair do aplicativo");
            op = entrada.nextInt();
            switch (op) {
                case 1:
                    criarConta();
                    break;
                case 2:
                    System.out.println("Qual o numero da conta?");
                    nc = entrada.nextInt();
                    if (existeConta(nc)) {
                        acessarConta(nc);
                    } else {
                        System.out.println("Infelizmente náo foi encotrado neunha conta");
                    }
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opção invalida!");

            }

        } while (op
                != 3);
    }

    private void criarConta() {
        double saldo = 0;
        Conta c = null;
        System.out.println("\n1-Conta Corrente \n2-Conta Poupança \n3-Voltar");

        int op = entrada.nextInt();

        if (op == 1 || op == 2) {
            System.out.println("Numero da conta = " + (numero + 1) + "");
            System.out.println("Agora Imforme o saldo da conta");
            saldo = entrada.nextDouble();
        }

        switch (op) {
            case 1:
                System.out.println("Qual a tarifa?");
                c = new Corrente(numero++, saldo, entrada.nextDouble());
                contas.add(c);
                break;
            case 2:
                System.out.println("Qual é o rendimento?");
                c = new Poupanca(numero++, saldo, entrada.nextDouble());
                contas.add(c);
                break;
            case 3:
                break;
            default:
                System.out.println("Opção invalida!");
        }

    }

    private boolean existeConta(int numero) {
        --numero;
        for (Conta c : contas) {
            if (c.getNumero() == numero) {
                return true;
            }
        }
        return false;
    }

    private void acessarConta(int numero) {

        int op;
        do {
            System.out.println("\n1 - Deposito\n2 - Saque \n3 - Ver saldo\n4 - Manutencao \n5 - sair");
            op = entrada.nextInt();
            switch (op) {
                case 1:
                    System.out.println("Qual a quantia?");
                    double valor = entrada.nextDouble();
                    contas.get(numero - 1).deposito(valor); // erro
                    break;
                case 2:
                    System.out.println("Digite o valor");
                    if (!contas.get(numero - 1).saque(entrada.nextDouble())) {
                        System.out.println("Saldo Insuficiente");
                    }
                    break;
                case 3:
                    System.out.println("Saldo = " + contas.get(numero - 1).getSaldo());
                    break;
                case 4:
                    for (Conta conta : contas) {
                        if (conta instanceof Corrente) {
                            ((Corrente) conta).debitaTarifa();
                        } else {
                            ((Poupanca) conta).creditaRendimento();
                        }
                    }
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Entrada invalida");
            }
        } while (op != 5);
    }

}
