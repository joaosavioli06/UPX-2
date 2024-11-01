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
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author JOAO.SAVIOLI
 */
public class LoginController { // Estabelece conexão com a View Login.java
    private final Login view; 
    private LoginHelper helper;
        
    public LoginController(Login view) { // recebe uma instância da Login.java que representa a interface gráfica
        // Teste de conexão
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
          boolean usuarioValido = verificarUsuarioNoBanco(usuario.getNome(), usuario.getSenha());
        
        // Se o usuário da view bater com o nome e senha do BD, redireciona para a view MenuPrincipal.java
        if (usuarioValido) {
            Main mainView = new Main(); // Supondo que você tenha uma classe Main
            mainView.setVisible(true);
            view.dispose(); // Fecha a tela de login
        } else {
            // Senão bater as informações, mostrar mensagem: "Usuário ou senha inválidos"
            view.exibeMensagem("Usuário ou senha inválidos");
        }
    }

    public void cadastrarUsuario() {
          // Pega um usuário da View
        Usuario usuario = helper.obterModelo();

        try {
            // Estabelece a conexão com o banco de dados
            Connection connection = ConnectionUtils.getConnection();
            String sql = "INSERT INTO usuarios (nome, senha) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, usuario.getNome());
            statement.setString(2, usuario.getSenha());
            statement.executeUpdate();
            view.exibeMensagem("Usuário cadastrado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
            view.exibeMensagem("Erro ao cadastrar usuário: " + e.getMessage());
        }
    }
  

    public boolean verificarUsuarioNoBanco(String nome, String senha) {
        boolean usuarioValido = false;
        try {
            Connection connection = ConnectionUtils.getConnection();
            String sql = "SELECT * FROM usuarios WHERE nome = ? AND senha = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nome);
            statement.setString(2, senha);
            ResultSet resultSet = statement.executeQuery();

            // Se um usuário for encontrado, o login é válido
            if (resultSet.next()) {
                usuarioValido = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarioValido;
    }
}

