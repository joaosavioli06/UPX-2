/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

/**
 *
 * @author savio
 */

public class Usuario {
   
    private final int id; // ID user & aplicando campo final para segurança do ID não ser modificado acidentalmente
    private String nome; // Nome user
    private String senha; // Senha user
    // private String nivelAcesso (ideia para talvez utilizar futuramente)
    private final String salt; // Salt para aumentar a segurança da senha
    
    /* Se a senha de um usuário for "minhaSenha123" e o sistema gerar um salt aleatório como "a9d4g5s2", a senha e o salt seriam concatenados, resultando em "minhaSenha123a9d4g5s2". 
    Esse valor seria passado para o algoritmo de hash para gerar a versão criptografada da senha. 
    
    * O sistema aplica o algoritmo de hash SHA-256 ao valor concatenado:
    * Resultado do hash: d8f9d9e7a4b3b... (uma sequência longa de caracteres)
    * O hash resultante é o que será armazenado no banco de dados, junto com o salt "a9d4g5s2".
    */
    
    // Cosntrutor abaixo
    
    public Usuario(int id, String nome, String senha) {
        this.id = id;
        this.nome = nome;
        this.salt = gerarSalt(); // Gera o salt ao criar o usuário
        setSenha (senha); // Criptografa e armazena a senha como hash
    }

    // Gerando apenas o getter para o ID
    
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Gerando apeans o setter para a senha
    
    private void setSenha(String senha) { // private para a senha ser gerenciado só dentro da classe
        this.senha = criptografarSenha(senha, this.salt);
    }
    
    // Método para criptografar a senha com SHA-256
    private String criptografarSenha(String senha, String salt) {
        try {
            // Concatena a senha com o salt
            String senhaComSalt = senha + salt;
            
            // Cria uma instância de MessageDigest usando SHA-256
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            
            // Calcula o hash da senha
            byte[] hashBytes = md.digest(senhaComSalt.getBytes());
            
            // Converte o hash em uma string hexadecimal
            return Base64.getEncoder().encodeToString(hashBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Erro ao criptografar a senha!", e);
        }
    }

    // Método para gerar o salt (número aleatório seguro)
    private String gerarSalt() {
        SecureRandom random = new SecureRandom();
        byte[] saltBytes = new byte[16];
        random.nextBytes(saltBytes);
        return Base64.getEncoder().encodeToString(saltBytes); // Converte o salt para uma string
    }

    // Método para verificar a senha (comparando com o hash armazenado)
    public boolean verificarSenha(String senhaDigitada) {
        // Gera o hash da senha digitada com o mesmo salt e compara com o hash armazenado
        String senhaDigitadaHash = criptografarSenha(senhaDigitada, this.salt);
        return this.senha.equals(senhaDigitadaHash);
    }
}