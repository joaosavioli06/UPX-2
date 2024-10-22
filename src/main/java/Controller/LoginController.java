/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import View.Login; // Importando view Login.java
/**
 *
 * @author JOAO.SAVIOLI
 */
public class LoginController { // Estabelece conexão com a View Login.java

    // Construtor abaixo 
    
    private final Login view; 
        
    public LoginController(Login view) { // recebe uma instância da Login.java que representa a interface gráfica
        this.view = view; // a view recebida é armazenada em uma variável de instância. Isso permite que o controlador possoa interagir com a view
    }
    
    public void teste(){ // Função para teste
        System.out.println("Busquei no BD"); // Isso é executado no compilador quando eu clico no botão de login quando a interface gráfica está sendo executada
        
        this.view.exibeMensagem("Teste executado!"); // Essa é a mensagem que aparece na interface gráfica quandoe ela está sendo executada
    }
}
