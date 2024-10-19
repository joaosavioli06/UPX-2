/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.time.LocalDate;
import Model.Dispositivo;
import Model.Dispositivo.Estado;
import Model.Dispositivo.Voltagem;

/**
 *
 * @author joao.savioli
 */
public class Main {
    
    public static void main(String[] args){
    
    String nome = "João";
    System.out.println(nome);
    
    Dispositivo equipamento = new Dispositivo(
            1, 
            "Geladeira", 
            "Eletrodoméstico",
            150, 
            Voltagem.V110, 
            LocalDate.of(2020,1,8), 
            12f, 
            "Cozinha", 
            Estado.ATIVO, 
            "Nenhuma");

    
    
    System.out.println(equipamento.getId());
    System.out.println(equipamento.getNome());
    System.out.println(equipamento.getTipo());
    System.out.println(equipamento.getPotencia());
    System.out.println(equipamento.getVoltagem());
    System.out.println(equipamento.getData());
    System.out.println(equipamento.getHoras());
    System.out.println(equipamento.getLocalizacao());
    System.out.println(equipamento.getObs());
    
    }
    
}
