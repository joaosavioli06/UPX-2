/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Helpers;

import Model.Usuario;
import View.Login;

/**
 *
 * @author joao.savioli
 */
public class LoginHelper {
    
    private final Login view; // Necessário para ter acesso a view

    public LoginHelper(Login view) { // Construtor para poder fazer a criação dos objetos com mais facilidade
        this.view = view;
    }
    
    public Usuario obterModelo(){ // Função que pega os dados que foram inseridos nso campos da view Login
        String nome = view.getTextUsuario().getText();
        char[] senhaArray = view.getSenhaUsuario().getPassword(); // Armazena a senha como char[]
        String senha = new String(senhaArray); // Pode ser convertido temporariamente, mas sem guardar como String
        
        Usuario modelo = new Usuario(0, nome, senha); // Chamada do construtor para criar um usuário
        return modelo; // Retorna a chamada acima como um Modelo pronto a ser utilizado
    }
    
    // Função para verificação de senha usando método definido no modelo de usuário (Usuario.java)
     public boolean validarLogin(Usuario usuarioModelo, String senhaDigitada) {
        return usuarioModelo.verificarSenha(senhaDigitada); // Usa o método de verificação da senha
     }
     
     /*
     O método setarModelo() que você usa no LoginHelper apenas preenche o campo de nome de usuário na tela de login, sem incluir a senha. 
     Esse método é útil para pré-preencher o nome de usuário em algumas situações.
     */
   
    public void setarModelo(Usuario modelo){   // Função que seta o nome de usuário na view (não setamos a senha)
        String nome = modelo.getNome();
        view.getTextUsuario().setText(nome); // Apenas o nome será setado na view
        // Não vamos setar a senha, pois ela não deve ser exibida        
     }
    
    public void limparTela(){
    view.getTextUsuario().setText("");
    view.getSenhaUsuario().setText("");
    }
}
    
 