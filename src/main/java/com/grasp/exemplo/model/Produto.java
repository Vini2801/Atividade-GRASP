package com.grasp.exemplo.model;

/**
 * Classe que representa um Produto no sistema.
 * 
 * PRINCÍPIO GRASP: EXPERT (Information Expert)
 * - Aplicação: Esta classe possui responsabilidade de armazenar e gerenciar
 *   dados relacionados a um produto (nome, preço, quantidade).
 * - Justificativa: A classe Produto é a classe que tem MAIS INFORMAÇÃO sobre
 *   os dados de um produto. Por isso, responsabilidades relacionadas aos 
 *   atributos do produto são delegadas para ela (getter/setter).
 * - Métodos aplicados: getName(), getPreço(), getQuantidade() e seus setters.
 * 
 * PRINCÍPIO GRASP: INDIRECTION (Indireta)
 * - Aplicação: Esta classe implementa cálculos básicos sem comunicação direta
 *   com camadas superiores. A lógica de negócio é delegada para serviços.
 * - Justificativa: Evita acoplamento direto entre a apresentação e a lógica
 *   de cálculo de preços (descontos, impostos, etc).
 * - Métodos aplicados: Ao não incluir lógica de cálculo complexa aqui,
 *   permitimos que intermediários (services) façam isso.
 */
public class Produto {
    private String nome;
    private double preco;
    private int quantidade;
    private String categoria;

    // Construtor
    public Produto(String nome, double preco, int quantidade, String categoria) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.categoria = categoria;
    }

    // Getters - Responsabilidade EXPERT: Produto conhece seus dados
    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String getCategoria() {
        return categoria;
    }

    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}
