/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.time.LocalDate;
import Model.Dispositivo;
import Model.Dispositivo.Estado;
import Model.Dispositivo.Voltagem;
import Model.Usuario;
import java.sql.Connection;

/**
 *
 * @author joao.savioli
 */
public class Main {
    
    public static void main(String[] args){
    
    Dispositivo equipamento;
        equipamento = new Dispositivo(
                1,
                "Geladeira",
                "Eletrodoméstico",
                150,
                Voltagem.V110,
                LocalDate.of(2020,1,8),
                12f,
                "Cozinha",
                Estado.ATIVO,
                "É um equipamento muito bom");

    System.out.println(equipamento.getId());
    System.out.println(equipamento.getNome());
    System.out.println(equipamento.getTipo());
    System.out.println(equipamento.getPotencia());
    System.out.println(equipamento.getVoltagem());
    System.out.println(equipamento.getDataFormatada());
    System.out.println(equipamento.getHoras());
    System.out.println(equipamento.getLocalizacao());
    System.out.println(equipamento.getEstado());
    System.out.println(equipamento.getObs());

    System.out.println(equipamento.getId());
    System.out.println(equipamento.getNome());
    System.out.println(equipamento.getTipo());
    System.out.println(equipamento.getPotencia());
    System.out.println(equipamento.getVoltagem());
    System.out.println(equipamento.getDataFormatada());
    System.out.println(equipamento.getHoras());
    System.out.println(equipamento.getLocalizacao());
    System.out.println(equipamento.getEstado());
    System.out.println(equipamento.getObs());
    
    Dispositivo equipamento2;
        equipamento2 = new Dispositivo(
                1,
                "Geladeira",
                "Eletrodoméstico",
                150,
                Voltagem.V110,
                LocalDate.of(2020,1,8),
                12f,
                "Cozinha",
                Estado.ATIVO);
        
    System.out.println(equipamento2.getId());
    System.out.println(equipamento2.getNome());
    System.out.println(equipamento2.getTipo());
    System.out.println(equipamento2.getPotencia());
    System.out.println(equipamento2.getVoltagem());
    System.out.println(equipamento2.getDataFormatada());
    System.out.println(equipamento2.getHoras());
    System.out.println(equipamento2.getLocalizacao());
    System.out.println(equipamento2.getEstado());
    System.out.println(equipamento2.getObs());
    
    Usuario usuario = new Usuario(1, "joao.savioli", "ninjated10");
    
    System.out.println(usuario.getId());
    System.out.println(usuario.getNome());
  }

    public void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    private static class connection {

        private static Connection getConnection() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        public connection() {
        }
    }
    
    public class TestConnection {
    public static void main(String[] args) {
        Connection conn = connection.getConnection();
        if (conn != null) {
            System.out.println("Conexão estabelecida com sucesso.");
        }
    }
}
    
    
    
    
}
