/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Controller.Helpers.LoginHelper;
import Model.Usuario;
import View.Login; // Importando view Login.java
import View.Main;
import connection.ConnectionUtils;
import java.sql.Connection;
/**
 *
 * @author JOAO.SAVIOLI
 */
public class LoginController { // Estabelece conexão com a View Login.java

    // Construtor abaixo 

    private final Login view; 
    private LoginHelper helper;
        
    public LoginController(Login view) { // recebe uma instância da Login.java que representa a interface gráfica
        Connection connection = ConnectionUtils.getConnection();
        if (connection != null) {
            System.out.println("Conexão estabelecida com sucesso.");
        }

        this.view = view; // a view recebida é armazenada em uma variável de instância. Isso permite que o controlador possoa interagir com a view
        this.helper = new LoginHelper(view);
    }
    
    public void loginNoSistema(){
        // Pega um usuário da View
        Usuario usuario = helper.obterModelo();
        // Pesquisa o usuário no Banco de Dados
        
        // Se o usuário da view bater com o nome e senha do BD, redireciona para a view MenuPrincipal.java
        
        // Senão bater as informações, mostrar mensagem: "Usuário ou senha inválidos"
        
    }
}
