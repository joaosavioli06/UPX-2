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
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author savio
 */
public class DispositivoController {
    
    private Connection connection;
    
    public DispositivoController(Connection connection) {
        this.connection = ConnectionUtils.getConnection(); // Antes: this.connection = connection; || import connection.ConnectionUtils;
    }
    
     public void adicionarDispositivo(Dispositivo dispositivo) throws SQLException {
        String sql = "INSERT INTO dispositivos (nome, tipo, potencia, voltagem, data, horas, localizacao, estado, obs) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
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
     }}
    
    // Método para obter dispositivos e retornar uma lista (opcional)
    // public List<Dispositivo> listarDispositivos() {
        // Implementar a lógica para listar os dispositivos do banco de dados
