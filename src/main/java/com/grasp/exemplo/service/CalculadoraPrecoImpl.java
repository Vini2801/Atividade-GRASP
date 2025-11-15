package com.grasp.exemplo.service;

import com.grasp.exemplo.model.Produto;

/**
 * Implementação da interface CalculadoraPreco.
 * 
 * PRINCÍPIO GRASP: EXPERT (Information Expert)
 * - Aplicação: Esta classe possui a EXPERTISE (especialidade) de calcular preços,
 *   descontos e impostos. Ela concentra toda a lógica de negócio relacionada
 *   a cálculos de valores.
 * - Justificativa: É a classe que "sabe" como calcular preços. Por isso, todas
 *   as responsabilidades relacionadas a cálculo de valor são concentradas aqui.
 *   Outras classes delegam para ela.
 * - Métodos aplicados: calcularPrecoFinal(), aplicarDescontoCategoria(),
 *   calcularImposto() - toda lógica de cálculo fica nesta classe.
 * 
 * PRINCÍPIO GRASP: INDIRECTION (Indireta)
 * - Aplicação: Esta classe implementa a interface CalculadoraPreco, atuando como
 *   intermediária que esconde a complexidade de cálculos.
 * - Justificativa: Permite que classes cliente (como Controller) não saibam
 *   os detalhes de COMO os cálculos são feitos, apenas que pode chamar os métodos
 *   da interface.
 * - Métodos aplicados: Todas as implementações dos métodos da interface atuam
 *   como pontos de indireção.
 */
public class CalculadoraPrecoImpl implements CalculadoraPreco {
    
    // Constantes para descontos por categoria
    private static final double DESCONTO_ELETRONICOS = 0.15;      // 15%
    private static final double DESCONTO_ALIMENTOS = 0.05;        // 5%
    private static final double DESCONTO_ROUPAS = 0.10;           // 10%
    private static final double DESCONTO_PADRAO = 0.0;            // Sem desconto
    
    // Constante para imposto
    private static final double ALIQUOTA_IMPOSTO = 0.07;          // 7% de ICMS
    
    // Limite de quantidade para desconto progressivo
    private static final int QUANTIDADE_LIMITE = 10;
    private static final double DESCONTO_QUANTIDADE = 0.05;       // 5% acima de 10 unidades

    /**
     * Calcula o preço final considerando descontos por quantidade e categoria.
     * 
     * Algoritmo:
     * 1. Obtém informações do produto (preço, categoria, quantidade)
     * 2. Aplica desconto por categoria
     * 3. Verifica se há desconto por quantidade
     * 4. Retorna preço final após descontos
     * 
     * @param produto Produto para o qual calcular o preço
     * @param quantidadeCompra Quantidade que será comprada
     * @return Preço final após descontos
     */
    @Override
    public double calcularPrecoFinal(Produto produto, int quantidadeCompra) {
        double precoBruto = produto.getPreco() * quantidadeCompra;
        
        // Aplicar desconto de categoria
        double desconto = aplicarDescontoCategoria(produto);
        double precoComDescontoCategoria = precoBruto - (precoBruto * desconto);
        
        // Aplicar desconto por quantidade se aplicável
        if (quantidadeCompra > QUANTIDADE_LIMITE) {
            precoComDescontoCategoria = precoComDescontoCategoria - 
                                       (precoComDescontoCategoria * DESCONTO_QUANTIDADE);
        }
        
        return precoComDescontoCategoria;
    }

    /**
     * Aplica desconto específico baseado na categoria do produto.
     * 
     * Regras de negócio:
     * - Eletrônicos: 15% de desconto
     * - Roupas: 10% de desconto
     * - Alimentos: 5% de desconto
     * - Outros: Sem desconto
     * 
     * @param produto Produto para aplicar desconto
     * @return Percentual do desconto (0.15 = 15%, por exemplo)
     */
    @Override
    public double aplicarDescontoCategoria(Produto produto) {
        String categoria = produto.getCategoria().toLowerCase();
        
        switch (categoria) {
            case "eletronicos":
                return DESCONTO_ELETRONICOS;
            case "roupas":
                return DESCONTO_ROUPAS;
            case "alimentos":
                return DESCONTO_ALIMENTOS;
            default:
                return DESCONTO_PADRAO;
        }
    }

    /**
     * Calcula imposto sobre um valor de preço.
     * Alíquota padrão: 7% de ICMS
     * 
     * @param preco Preço base para cálculo
     * @return Valor do imposto em reais
     */
    @Override
    public double calcularImposto(double preco) {
        return preco * ALIQUOTA_IMPOSTO;
    }
}
