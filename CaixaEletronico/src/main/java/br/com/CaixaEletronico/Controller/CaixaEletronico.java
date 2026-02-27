package br.com.CaixaEletronico.Controller;

import br.com.CaixaEletronico.Entity.Usuario;

public class CaixaEletronico {
    double saldoAtualizado;

    public void sacarDinheiro(Usuario u, double valor){
        if(valor <= 0){
            System.out.println("Valor precisa ser maior que zero");
            return;
        }

        if(u.getSaldo() < valor){
            System.out.println("Saldo insuficiente");
            return;
        }

        u.setSaldo(u.getSaldo() - valor);
    }

    public void depositarDinheiro(Usuario u, double valor){
        if(valor <= 0){
            System.out.println("Valor precisa ser maior que zero");
            return;
        }

        u.setSaldo(u.getSaldo() + valor);
    }

    public void transferirDinheiro(Usuario origem, Usuario destino, double valor){
        if(valor <= 0){
            System.out.println("Valor precisa ser maior que zero");
            return;
        }

        if(origem.getSaldo() < valor){
            System.out.println("Saldo insuficiente");
            return;
        }

        origem.setSaldo(origem.getSaldo() - valor);
        destino.setSaldo(destino.getSaldo() + valor);
    }
}
