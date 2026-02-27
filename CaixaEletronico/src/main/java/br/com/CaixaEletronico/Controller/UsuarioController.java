package br.com.CaixaEletronico.Controller;

import br.com.CaixaEletronico.Criptografia.Senha;
import br.com.CaixaEletronico.Entity.Usuario;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioController {
    List <Usuario> usuarios = new ArrayList<>();
    Senha criptografia = new Senha();
    Usuario usuario;

    public void adicionarUsuario(String nome, String cpf, String senha, double saldo){
        usuario = new Usuario(gerarId(), nome, cpf, criptografia.CriptografarSenha(senha), saldo);
        usuarios.add(usuario);
    }

    public void mostrarUsuarios(){
        for(Usuario u : usuarios){
            System.out.println(u);
        }
    }

    public void deletarUsuario(long id){
        for(Usuario u : usuarios){
            if(u.getId() == id){
                usuarios.remove(u);
                return;
            }
        }
    }

    public Usuario retornarUsuario(long id){
        for(Usuario u : usuarios){
            if(u.getId() == id){
                return u;
            }
        }
        throw new RuntimeException("Usuário não encontrado");
    }

    public long gerarId(){
        long maiorId = 0;

        for(Usuario u : usuarios){
            if(u.getId() > maiorId){
                maiorId = u.getId();
            }
        }

        return maiorId + 1;
    }
}
