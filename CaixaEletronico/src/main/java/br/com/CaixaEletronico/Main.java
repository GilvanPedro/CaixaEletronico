package br.com.CaixaEletronico;

import br.com.CaixaEletronico.Controller.CaixaEletronico;
import br.com.CaixaEletronico.Controller.LoginController;
import br.com.CaixaEletronico.Controller.UsuarioController;
import br.com.CaixaEletronico.Entity.Usuario;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        UsuarioController usuarioController = new UsuarioController();
        LoginController loginController = new LoginController();
        CaixaEletronico caixa = new CaixaEletronico();

        Usuario usuarioLogado = null;

        while (true) {

            if (usuarioLogado == null) {
                System.out.println("\n=== CAIXA ELETRÔNICO ===");
                System.out.println("1 - Criar conta");
                System.out.println("2 - Login");
                System.out.println("0 - Sair");
                System.out.print("Escolha: ");

                int op = sc.nextInt();
                sc.nextLine();

                switch (op) {
                    case 1:
                        System.out.print("Nome: ");
                        String nome = sc.nextLine();

                        System.out.print("CPF: ");
                        String cpf = sc.nextLine();

                        System.out.print("Senha: ");
                        String senha = sc.nextLine();

                        usuarioController.adicionarUsuario(nome, cpf, senha, 0);
                        System.out.println("Conta criada!");
                        break;

                    case 2:
                        System.out.print("ID do usuário: ");
                        long id = sc.nextLong();
                        sc.nextLine();

                        System.out.print("Senha: ");
                        String senhaLogin = sc.nextLine();

                        try {
                            Usuario u = usuarioController.retornarUsuario(id);

                            if (loginController.logar(u, u.getCpf(), senhaLogin)) {
                                usuarioLogado = u;
                            }

                        } catch (Exception e) {
                            System.out.println("Usuário não encontrado");
                        }
                        break;

                    case 0:
                        System.out.println("Encerrando...");
                        return;

                    default:
                        System.out.println("Opção inválida");
                }

            } else {

                System.out.println("\n=== MENU DO USUÁRIO ===");
                System.out.println("1 - Ver saldo");
                System.out.println("2 - Depositar");
                System.out.println("3 - Sacar");
                System.out.println("4 - Transferir");
                System.out.println("0 - Logout");
                System.out.print("Escolha: ");

                int op = sc.nextInt();

                switch (op) {
                    case 1:
                        System.out.println("Saldo: " + usuarioLogado.getSaldo());
                        break;

                    case 2:
                        System.out.print("Valor: ");
                        double dep = sc.nextDouble();
                        caixa.depositarDinheiro(usuarioLogado, dep);
                        break;

                    case 3:
                        System.out.print("Valor: ");
                        double saque = sc.nextDouble();
                        caixa.sacarDinheiro(usuarioLogado, saque);
                        break;

                    case 4:
                        System.out.print("ID destino: ");
                        long idDestino = sc.nextLong();

                        System.out.print("Valor: ");
                        double valor = sc.nextDouble();

                        try {
                            Usuario destino = usuarioController.retornarUsuario(idDestino);
                            caixa.transferirDinheiro(usuarioLogado, destino, valor);
                        } catch (Exception e) {
                            System.out.println("Usuário destino não encontrado");
                        }
                        break;

                    case 0:
                        usuarioLogado = null;
                        System.out.println("Logout realizado");
                        break;

                    default:
                        System.out.println("Opção inválida");
                        break;
                }
            }
        }
    }
}