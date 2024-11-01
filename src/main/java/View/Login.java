/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.LoginController; // Necessário importar para o Controlador poder se comunicar com a View
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author savio
 */
public class Login extends javax.swing.JFrame {

    private final LoginController controller;

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        controller = new LoginController(this); // Isso aqui foi adicionado para que o controller do Login fosse reconhecido por ele mesmo, indicando que ele mesmo é o próprio controlador
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TextUsuario = new javax.swing.JTextField();
        SenhaUsuario = new javax.swing.JPasswordField();
        BtnLogar = new javax.swing.JButton();
        LabelUsuario = new javax.swing.JLabel();
        LabelSenha = new javax.swing.JLabel();
        LabelFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TextUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TextUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(TextUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 390, 150, 30));

        SenhaUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(SenhaUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 470, 150, 30));

        BtnLogar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        BtnLogar.setText("Login");
        BtnLogar.setBorder(null);
        BtnLogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLogarActionPerformed(evt);
            }
        });
        getContentPane().add(BtnLogar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 530, 90, 30));

        LabelUsuario.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        LabelUsuario.setForeground(new java.awt.Color(255, 255, 255));
        LabelUsuario.setText("Usuário");
        getContentPane().add(LabelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 350, 140, -1));

        LabelSenha.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        LabelSenha.setForeground(new java.awt.Color(255, 255, 255));
        LabelSenha.setText("Senha");
        getContentPane().add(LabelSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 430, 140, -1));

        LabelFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/login.png"))); // NOI18N
        getContentPane().add(LabelFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1170, 666));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TextUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextUsuarioActionPerformed

    private void BtnLogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLogarActionPerformed

    }//GEN-LAST:event_BtnLogarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnLogar;
    private javax.swing.JLabel LabelFundo;
    private javax.swing.JLabel LabelSenha;
    private javax.swing.JLabel LabelUsuario;
    private javax.swing.JPasswordField SenhaUsuario;
    private javax.swing.JTextField TextUsuario;
    // End of variables declaration//GEN-END:variables

    // Função abaixo criada com a ajuda no Netbeans pela função na linha 24 (LoginController) para exibição de mensagem configurada na controller (LoginController) 
    
    public void exibeMensagem(String mensagem) { 
        JOptionPane.showMessageDialog(null, mensagem);
    }

    // Getters e Setters criados para que possamos pegar as informações da View de Login e enviá-las ao controlador (LoginController)
    // Getters e Setters do TextUsuario e SenhaUsuario abaixo:
    
    public JPasswordField getSenhaUsuario() {
        return SenhaUsuario;
    }

    public void setSenhaUsuario(JPasswordField SenhaUsuario) {
        this.SenhaUsuario = SenhaUsuario;
    }

    public JTextField getTextUsuario() {
        return TextUsuario;
    }

    public void setTextUsuario(JTextField TextUsuario) {
        this.TextUsuario = TextUsuario;
    }
    
    
}


