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
    
    public Usuario obterModelo(){ // Função que pega os dados que foram inseridos nos campos da view Login
        String nome = view.getTextUsuario().getText();
        String senha = view.getSenhaUsuario().getText();
        
          System.out.println("Nome de Usuário: " + nome);
          System.out.println("Senha: " + senha);
        
        Usuario modelo = new Usuario(0, nome, senha); // Chamada do construtor para criar um usuário
        return modelo; // Retorna a chamada acima como um Modelo pronto a ser utilizado
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
    
    
 