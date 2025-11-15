package com.grasp.exemplo;

import com.grasp.exemplo.model.Produto;
import com.grasp.exemplo.service.CalculadoraPreco;
import com.grasp.exemplo.service.CalculadoraPrecoImpl;

/**
 * Classe principal que demonstra a aplicação dos princípios GRASP.
 * 
 * PRINCÍPIOS GRASP APLICADOS:
 * 
 * 1. EXPERT (Information Expert):
 *    - Classe Produto: Responsável por seus próprios dados (nome, preço, quantidade)
 *    - Classe CalculadoraPrecoImpl: Responsável por calcular preços (expertise em cálculos)
 *    
 * 2. INDIRECTION (Indireta):
 *    - CalculadoraPreco (interface) atua como intermediária entre Main e CalculadoraPrecoImpl
 *    - Desacopla a lógica de cálculo da apresentação
 *    - Permite trocar a implementação sem modificar o código cliente
 */
public class Main {
    
    public static void main(String[] args) {
        System.out.println("=== DEMONSTRAÇÃO DOS PRINCÍPIOS GRASP ===\n");
        
        // Criando produtos - Produto é EXPERT em seus dados
        Produto produtoEletronico = new Produto("Smartphone", 1500.00, 2, "eletronicos");
        Produto produtoRoupa = new Produto("Camiseta", 50.00, 15, "roupas");
        Produto produtoAlimento = new Produto("Arroz", 20.00, 5, "alimentos");
        
        // Criando a calculadora - Implementa INDIRECTION através de interface
        // Main depende de CalculadoraPreco (interface), não de CalculadoraPrecoImpl
        CalculadoraPreco calculadora = new CalculadoraPrecoImpl();
        
        System.out.println("Princípio GRASP - EXPERT:");
        System.out.println("Cada classe é EXPERT em sua especialidade:");
        System.out.println("  - Produto: conhece dados do produto (nome, preço, quantidade)");
        System.out.println("  - CalculadoraPreco: conhece como calcular preços\n");
        
        System.out.println("Princípio GRASP - INDIRECTION:");
        System.out.println("Interface CalculadoraPreco atua como intermediária");
        System.out.println("  - Desacopla a lógica de cálculo da classe Main");
        System.out.println("  - Permite flexibilidade para trocar implementações\n");
        
        System.out.println("=" + "=".repeat(50) + "\n");
        
        // Teste 1: Eletrônicos com desconto de 15%
        System.out.println("TESTE 1 - Eletrônicos (15% desconto):");
        System.out.println("Produto: " + produtoEletronico);
        double precoEletronico = calculadora.calcularPrecoFinal(produtoEletronico, 2);
        double impostoEletronico = calculadora.calcularImposto(precoEletronico);
        System.out.println("Preço final (com desconto): R$ " + String.format("%.2f", precoEletronico));
        System.out.println("Imposto (7%): R$ " + String.format("%.2f", impostoEletronico));
        System.out.println("Total com imposto: R$ " + String.format("%.2f", precoEletronico + impostoEletronico));
        System.out.println();
        
        // Teste 2: Roupas com quantidade > 10 (duplo desconto)
        System.out.println("TESTE 2 - Roupas (10% desconto + 5% por quantidade):");
        System.out.println("Produto: " + produtoRoupa);
        System.out.println("Quantidade comprada: 15 (acima de 10)");
        double precoRoupa = calculadora.calcularPrecoFinal(produtoRoupa, 15);
        double impostoRoupa = calculadora.calcularImposto(precoRoupa);
        System.out.println("Preço final (com descontos): R$ " + String.format("%.2f", precoRoupa));
        System.out.println("Imposto (7%): R$ " + String.format("%.2f", impostoRoupa));
        System.out.println("Total com imposto: R$ " + String.format("%.2f", precoRoupa + impostoRoupa));
        System.out.println();
        
        // Teste 3: Alimentos com desconto de 5%
        System.out.println("TESTE 3 - Alimentos (5% desconto):");
        System.out.println("Produto: " + produtoAlimento);
        double precoAlimento = calculadora.calcularPrecoFinal(produtoAlimento, 5);
        double impostoAlimento = calculadora.calcularImposto(precoAlimento);
        System.out.println("Preço final (com desconto): R$ " + String.format("%.2f", precoAlimento));
        System.out.println("Imposto (7%): R$ " + String.format("%.2f", impostoAlimento));
        System.out.println("Total com imposto: R$ " + String.format("%.2f", precoAlimento + impostoAlimento));
        System.out.println();
        
        System.out.println("=" + "=".repeat(50));
        System.out.println("\nRESUMO DOS PRINCÍPIOS APLICADOS:");
        System.out.println("\n✓ EXPERT (Information Expert):");
        System.out.println("  - Classe Produto: responsável por armazenar dados do produto");
        System.out.println("  - Classe CalculadoraPrecoImpl: responsável por calcular preços");
        System.out.println("  - Cada classe concentra responsabilidades na sua área de expertise");
        
        System.out.println("\n✓ INDIRECTION (Indireta):");
        System.out.println("  - Interface CalculadoraPreco desacopla cliente da implementação");
        System.out.println("  - Permite trocar CalculadoraPrecoImpl por outra sem alterar Main");
        System.out.println("  - Reduz acoplamento entre camadas");
    }
}
