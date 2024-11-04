/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author savio
 */
public class Dispositivo {
    
    /*Quando se utiliza o modificador de acesso private em uma variável, você está restringindo o acesso a essa variável apenas à classe onde ela foi declarada,
    no caso, a classe Dispositivo. Isso significa que somente os métodos dessa classe podem acessar ou modificar diretamente essas variáveis. */
    
    private String nome; // Nome do dispositivo
    private String tipo; // Tipo do dispositivo
    private int potencia; // Potência em Watts
    private Voltagem voltagem; // Tipo enum
    private LocalDate data; // Data de aquisição
    private float horas; // Horas de uso diárias estimadas (float)
    private String localizacao; // Localização (cômodo)
    private Estado estado; // Tipo enum 
    private String obs; // 

    
    // Construtores abaixo:
    
    public Dispositivo() {
        // Você pode inicializar atributos com valores padrão, se necessário
    }
    
    // Construtor com possibilidade de fazer comentário
    public Dispositivo(String nome, String tipo, int potencia, Voltagem voltagem, LocalDate data, float horas, String localizacao, Estado estado, String obs) {
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

    // Criando enumerations para a seleção de Volts e Estado
    
     public enum Voltagem {
        V110("110v"),
        V220("220v"),
        BIVOLT("Bivolt");

        private final String descricao;

        Voltagem(String descricao) {
            this.descricao = descricao;
        }

        @Override
        public String toString() {
            return descricao;
        }
    }

    public enum Estado {
        ATIVO("Ativo"),
        INATIVO("Inativo");

        private final String descricao;

        Estado(String descricao) {
            this.descricao = descricao;
        }

        @Override
        public String toString() {
            return descricao;
        }
    
    }

    // Getters e Setters abaixo do restante
    
    // Getters e setters são métodos especiais usados em programação orientada a objetos para acessar (get) e modificar (set) os atributos privados de uma classe.
    
    // O método getter é utilizado para retornar o valor de um atributo privado. Ele permite que outras classes acessem os valores dos atributos sem expô-los diretamente.
    
    /* O método setter é utilizado para modificar o valor de um atributo privado. Ele permite que outras classes alterem os valores dos atributos, mas de maneira controlada, 
    geralmente com a possibilidade de realizar verificações ou validações antes de modificar o valor. */
    
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

    public Voltagem getVoltagem() {
        return voltagem;
    }

    public void setVoltagem(Voltagem voltagem) {
        this.voltagem = voltagem;
    }

    public LocalDate getData() {
        return data;
    }

    public String getDataFormatada(){
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return data.format(formatter);
    } //´feito para retornar data no formato BR = dd/mm/yyyy
    
    public void setData(LocalDate data) {
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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
    
}


