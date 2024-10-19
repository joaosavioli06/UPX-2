/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author savio
 */
public class Dispositivo {
    
    /*Quando se utiliza o modificador de acesso private em uma variável, você está restringindo o acesso a essa variável apenas à classe onde ela foi declarada,
    no caso, a classe Dispositivo. Isso significa que somente os métodos dessa classe podem acessar ou modificar diretamente essas variáveis. */
    
    private int id; // ID do dispositivo
    private String nome; // Nome do dispositivo
    private String tipo; // Tipo do dispositivo
    private int potencia; // Potência em Watts
    private String voltagem; // tem 3 opções predefinidas (110v, 220v e bivolt), pode usar uma String para armazenar o valor selecionado.
    private Date data; // Data de aquisição
    private float horas; // Horas de uso diárias estimadas (float)
    private String localizacao; // Localização (cômodo)
    private String estado; // como existem apenas duas opções predefinidas (ativo, inativo), pode usar uma String para armazenar o estado.
    private String obs; // Para armazenar texto adicional sobre o dispositivo

    
    // Cosntrutor abaixo
    
    public Dispositivo(int id, String nome, String tipo, int potencia, String voltagem, Date data, float horas, String localizacao, String estado, String obs) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.potencia = potencia;
        this.voltagem = voltagem;
        this.data = data;
        this.horas = horas;
        this.localizacao = localizacao;
        this.estado = estado;
        this.obs = obs;
    }

    // Criando apenas um Getter para o ID, visto que é uma varáivel que não vai ser modificada
    
    public int getId() {
        return id;
    }

    // Getters e Setters abaixo do restante
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public String getVoltagem() {
        return voltagem;
    }

    public void setVoltagem(String voltagem) {
        this.voltagem = voltagem;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public float getHoras() {
        return horas;
    }

    public void setHoras(float horas) {
        this.horas = horas;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
    
    
    
    
    
}

