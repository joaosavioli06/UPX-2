package Controller;

import Controller.Helpers.LoginHelper;
import Model.Usuario;
import View.Login;
import View.MenuPrincipal;
import connection.ConnectionUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class LoginController {
    private final Login view;
    private LoginHelper helper;

    public LoginController(Login view) {
        this.view = view;
        this.helper = new LoginHelper(view);
    }

    public void loginNoSistema() {
        Connection conn = null;
    try {
        System.out.println("Tentando estabelecer conexão com o banco..."); // Log inicial
        
        // Obtenha a conexão usando ConnectionUtils
        conn = ConnectionUtils.getConnection();

        // Verifique se a conexão foi estabelecida corretamente
        if (conn == null || conn.isClosed()) {
        JOptionPane.showMessageDialog(view, "Falha ao conectar ao banco de dados.");
        System.out.println("Conexão com o banco de dados falhou.");
            return;
        }
        
        System.out.println("Conexão com o banco de dados estabelecida com sucesso."); // Confirmação de conexão

        // Obtenha o modelo do usuário
        Usuario usuarioModelo = helper.obterModelo();
        
        // Verificação no terminal
        System.out.println("Usuário obtido: " + usuarioModelo.getNome());

        // Verifique o usuário no banco de dados
        boolean usuarioValido = verificarUsuarioNoBanco(usuarioModelo.getNome(), usuarioModelo.getSenha());

        if (usuarioValido) {
            // Código para abrir a tela do menu principal
            
            System.out.println("Usuário válido, abrindo tela principal..."); // Verificação no terminal
            
            abrirTelaMenuPrincipal();
        } else {
            // Exibir mensagem de erro
            JOptionPane.showMessageDialog(view, "Usuário ou senha inválidos.");
            
            System.out.println("Usuário ou senha inválidos."); // Verificação no terminal
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        // Fechar a conexão após o uso
        ConnectionUtils.closeConnection(conn);
    }
}

    public void cadastrarUsuario() {
        // Pega um usuário da View
        Usuario usuario = helper.obterModelo();

        try (Connection connection = ConnectionUtils.getConnection()) {
            String sql = "INSERT INTO usuarios (nome, senha) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, usuario.getNome());
            statement.setString(2, usuario.getSenha()); // Aqui, você deve criptografar a senha
            statement.executeUpdate();
            view.exibeMensagem("Usuário cadastrado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
            view.exibeMensagem("Erro ao cadastrar usuário: " + e.getMessage());
        }
    }

    public boolean verificarUsuarioNoBanco(String nome, String senha) {
        boolean usuarioValido = false;
        try (Connection connection = ConnectionUtils.getConnection()) {
            String sql = "SELECT * FROM usuarios WHERE nome = ? AND senha = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nome);
            statement.setString(2, senha); // Aqui, você deve usar a senha criptografada

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
    
    private void abrirTelaMenuPrincipal() {
    MenuPrincipal menuPrincipal = new MenuPrincipal();
    menuPrincipal.setVisible(true);
    view.dispose(); // Fecha a tela de login
}
}

/**/