/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Dispositivo;
import Model.Dispositivo.Estado;
import Model.Dispositivo.Voltagem;
import connection.ConnectionUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author savio
 */
public class DispositivoController {
    private Connection connection;
    
    public DispositivoController(Connection connection) {
        this.connection = connection; // Antes: this.connection = connection; || import connection.ConnectionUtils;
    }
    
     public void adicionarDispositivo(Dispositivo dispositivo) throws SQLException {
        String sql = "INSERT INTO dispositivos (nome, tipo, potencia, voltagem, data_aquisicao, horas_uso_diarias, localizacao, estado, obs) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, dispositivo.getNome());
            stmt.setString(2, dispositivo.getTipo());
            stmt.setInt(3, dispositivo.getPotencia());
            stmt.setString(4, dispositivo.getVoltagem().toString());
            stmt.setDate(5, java.sql.Date.valueOf(dispositivo.getData()));
            stmt.setFloat(6, dispositivo.getHoras());
            stmt.setString(7, dispositivo.getLocalizacao());
            stmt.setString(8, dispositivo.getEstado().toString());
            stmt.setString(9, dispositivo.getObs());
            stmt.executeUpdate();
        }
     }
     
       public boolean isNomeDuplicado(String nomeDispositivo) throws SQLException {
        String sql = "SELECT COUNT(*) FROM dispositivos WHERE nome = ?";
        System.out.println("Verificando duplicidade para: " + nomeDispositivo); // Depuração

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
        stmt.setString(1, nomeDispositivo);
        ResultSet rs = stmt.executeQuery();
        
        if (rs.next()) {
            int count = rs.getInt(1);
            System.out.println("Contagem de dispositivos com esse nome: " + count); // Depuração
            return count > 0;
            }
        }
            return false;
}
       
           // Método que retorna as horas formatadas
    public String formatarHoras(float horas) {
        DecimalFormat df = new DecimalFormat();
        
        // Se for inteiro, exibe sem a parte decimal
        if (horas == (int) horas) {
            df.applyPattern("#"); // Padrão para números inteiros
        } else {
            df.applyPattern("#.00"); // Padrão para números com 2 casas decimais
        }
        
        return df.format(horas);
    }
      
        public List<Dispositivo> listarDispositivos() throws SQLException {
        List<Dispositivo> dispositivos = new ArrayList<>();
        String sql = "SELECT * FROM dispositivos"; // Consulta SQL para buscar todos os dispositivos
        
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Dispositivo dispositivo = new Dispositivo();
                dispositivo.setNome(rs.getString("nome"));
                dispositivo.setTipo(rs.getString("tipo"));
                dispositivo.setPotencia(rs.getInt("potencia"));
                dispositivo.setVoltagem(Voltagem.valueOf(rs.getString("voltagem"))); // Altere se o enum tiver nomes diferentes
                dispositivo.setData(rs.getDate("data_aquisicao").toLocalDate());
                dispositivo.setHoras(rs.getFloat("horas_uso_diarias"));
                dispositivo.setLocalizacao(rs.getString("localizacao"));
                dispositivo.setEstado(Estado.valueOf(rs.getString("estado"))); // Altere se o enum tiver nomes diferentes
                dispositivo.setObs(rs.getString("obs"));
                
                String horasFormatadas = formatarHoras(dispositivo.getHoras());
                dispositivo.setHorasFormatadas(horasFormatadas); // Aqui você teria que criar o campo 'horasFormatadas' em Dispositivo
                
                dispositivos.add(dispositivo); // Adiciona o dispositivo à lista
            }
        }
        
        return dispositivos; // Retorna a lista de dispositivos
    }
        }
   
