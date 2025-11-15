package com.grasp.exemplo;

import com.grasp.exemplo.model.Produto;
import com.grasp.exemplo.service.CalculadoraPreco;
import com.grasp.exemplo.service.CalculadoraPrecoImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Testes unitários para validar os princípios GRASP implementados.
 * 
 * PRINCÍPIOS TESTADOS:
 * 
 * 1. EXPERT: Cada classe é testada isoladamente confirmando que:
 *    - Produto conhece seus dados
 *    - CalculadoraPreco conhece cálculos
 *    
 * 2. INDIRECTION: Testes comprovam que:
 *    - Main pode usar CalculadoraPreco sem conhecer CalculadoraPrecoImpl
 *    - Implementação pode ser trocada sem quebrar testes
 */
public class CalculadoraPrecoTest {
    
    private CalculadoraPreco calculadora;
    private Produto produtoEletronico;
    private Produto produtoRoupa;
    private Produto produtoAlimento;
    
    @Before
    public void setUp() {
        // Princípio INDIRECTION: criamos através da interface
        calculadora = new CalculadoraPrecoImpl();
        
        // Princípio EXPERT: Produto é expert em seus dados
        produtoEletronico = new Produto("TV 55\"", 2000.00, 1, "eletronicos");
        produtoRoupa = new Produto("Calça", 80.00, 1, "roupas");
        produtoAlimento = new Produto("Café", 15.00, 1, "alimentos");
    }
    
    /**
     * Teste do Princípio EXPERT em Produto
     * Verifica que Produto conhece seus próprios dados
     */
    @Test
    public void testProdutoExpert() {
        assertEquals("TV 55\"", produtoEletronico.getNome());
        assertEquals(2000.00, produtoEletronico.getPreco(), 0.01);
        assertEquals(1, produtoEletronico.getQuantidade());
        assertEquals("eletronicos", produtoEletronico.getCategoria());
    }
    
    /**
     * Teste do Princípio EXPERT em CalculadoraPreco
     * Verifica que CalculadoraPreco é expert em calcular descontos de eletrônicos
     */
    @Test
    public void testDescontoEletronicos() {
        // Eletrônicos devem ter 15% de desconto
        double desconto = calculadora.aplicarDescontoCategoria(produtoEletronico);
        assertEquals(0.15, desconto, 0.01);
    }
    
    /**
     * Teste do Princípio EXPERT em CalculadoraPreco
     * Verifica que CalculadoraPreco é expert em calcular descontos de roupas
     */
    @Test
    public void testDescontoRoupas() {
        // Roupas devem ter 10% de desconto
        double desconto = calculadora.aplicarDescontoCategoria(produtoRoupa);
        assertEquals(0.10, desconto, 0.01);
    }
    
    /**
     * Teste do Princípio EXPERT em CalculadoraPreco
     * Verifica que CalculadoraPreco é expert em calcular descontos de alimentos
     */
    @Test
    public void testDescontoAlimentos() {
        // Alimentos devem ter 5% de desconto
        double desconto = calculadora.aplicarDescontoCategoria(produtoAlimento);
        assertEquals(0.05, desconto, 0.01);
    }
    
    /**
     * Teste do Princípio EXPERT em CalculadoraPreco
     * Verifica que CalculadoraPreco é expert em calcular impostos
     */
    @Test
    public void testCalculoImposto() {
        // Imposto deve ser 7% do preço
        double imposto = calculadora.calcularImposto(100.00);
        assertEquals(7.00, imposto, 0.01);
    }
    
    /**
     * Teste do Princípio EXPERT em CalculadoraPreco
     * Verifica cálculo completo com desconto de categoria
     */
    @Test
    public void testCalculoPrecoFinalComDescontoCategoria() {
        // TV 55" custa 2000 * 1 = 2000
        // Com 15% de desconto = 2000 * 0.85 = 1700
        double precoFinal = calculadora.calcularPrecoFinal(produtoEletronico, 1);
        assertEquals(1700.00, precoFinal, 0.01);
    }
    
    /**
     * Teste do Princípio EXPERT em CalculadoraPreco
     * Verifica cálculo com duplo desconto (categoria + quantidade)
     */
    @Test
    public void testCalculoPrecoFinalComDuploDesconto() {
        // Calça custa 80 * 15 = 1200
        // Com 10% de desconto categoria = 1200 * 0.90 = 1080
        // Com 5% de desconto quantidade (15 > 10) = 1080 * 0.95 = 1026
        double precoFinal = calculadora.calcularPrecoFinal(produtoRoupa, 15);
        assertEquals(1026.00, precoFinal, 0.01);
    }
    
    /**
     * Teste do Princípio INDIRECTION
     * Verifica que interface permite abstração da implementação
     * Se trocarmos CalculadoraPrecoImpl por outra implementação,
     * este teste continuará funcionando
     */
    @Test
    public void testIndirectionThroughInterface() {
        // calculadora é do tipo CalculadoraPreco (interface)
        // Não conhecemos a implementação, apenas usamos a interface
        assertNotNull(calculadora);
        
        // Qualquer implementação de CalculadoraPreco funcionaria aqui
        double resultado = calculadora.calcularImposto(100.0);
        assertTrue(resultado > 0);
    }
    
    /**
     * Teste de integração
     * Valida o fluxo completo da aplicação
     */
    @Test
    public void testFluxoCompletoCalculoPreco() {
        // Criar produto (EXPERT: Produto armazena dados)
        Produto notebook = new Produto("Notebook Dell", 3500.00, 1, "eletronicos");
        
        // Calcular preço (EXPERT: CalculadoraPreco calcula)
        // INDIRECTION: Usamos interface, não implementação
        double precoFinal = calculadora.calcularPrecoFinal(notebook, 2);
        double imposto = calculadora.calcularImposto(precoFinal);
        double total = precoFinal + imposto;
        
        // Verificações
        assertTrue(precoFinal > 0);
        assertTrue(imposto > 0);
        assertTrue(total > precoFinal);
        
        // Preço esperado: 3500 * 2 * 0.85 (15% desc) = 5950
        assertEquals(5950.00, precoFinal, 0.01);
    }
}
