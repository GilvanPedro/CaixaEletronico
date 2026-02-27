package br.com.CaixaEletronico.Controller;

import br.com.CaixaEletronico.Criptografia.Senha;
import br.com.CaixaEletronico.Entity.Usuario;

public class LoginController {
    Senha criptografia = new  Senha();

    public boolean logar(Usuario u, String cpf, String senha){
        if(criptografia.VerificarSenha(senha, u.getSenha())){
            System.out.println("Login realizado com sucesso!");
            return true;
        } else{
            System.out.println("Senha Incorreta!");
            return  false;
        }
    }

    public void criarConta(String nome, String cpf, String senha, double saldo){
        UsuarioController usuarioController = new UsuarioController();

        usuarioController.adicionarUsuario(nome,cpf,senha,saldo);
    }
}
