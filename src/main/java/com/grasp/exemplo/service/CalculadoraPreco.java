package com.grasp.exemplo.service;

import com.grasp.exemplo.model.Produto;

/**
 * Interface que define o contrato para cálculo de preços de produtos.
 * 
 * PRINCÍPIO GRASP: INDIRECTION (Indireta)
 * - Aplicação: Esta interface atua como intermediária entre classes que precisam
 *   calcular preços (como Controller) e a implementação concreta do cálculo.
 * - Justificativa: Permite descacoplar a lógica de cálculo de quem a utiliza,
 *   proporcionando flexibilidade para trocar implementações sem alterar código cliente.
 * - Métodos: calcularPrecoFinal(), aplicarDesconto() e calcularImposto()
 *   recebem produtos e realizam cálculos através de um intermediário.
 */
public interface CalculadoraPreco {
    
    /**
     * Calcula o preço final considerando descontos por quantidade.
     * @param produto Produto para o qual calcular o preço
     * @param quantidadeCompra Quantidade que será comprada
     * @return Preço final após descontos
     */
    double calcularPrecoFinal(Produto produto, int quantidadeCompra);
    
    /**
     * Aplica desconto ao preço do produto baseado na categoria.
     * @param produto Produto para aplicar desconto
     * @return Valor do desconto em reais
     */
    double aplicarDescontoCategoria(Produto produto);
    
    /**
     * Calcula imposto sobre o preço do produto.
     * @param preco Preço base para cálculo
     * @return Valor do imposto
     */
    double calcularImposto(double preco);
}
