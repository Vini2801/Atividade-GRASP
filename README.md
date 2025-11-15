# Atividade GRASP - Aplicação de Cálculo de Preços

## 📋 Descrição

Aplicação simples em Java que demonstra a aplicação de **dois princípios GRASP** (General Responsibility Assignment Software Patterns):

1. **EXPERT (Information Expert)** - Cada classe é responsável por uma expertise específica
2. **INDIRECTION (Indireta)** - Usar intermediários para desacoplar componentes

## 🎯 Princípios GRASP Implementados

### 1. **EXPERT (Information Expert)**

**O que é:** Atribuir uma responsabilidade à classe que tem a informação necessária para cumpri-la.

**Aplicação no projeto:**

- **Classe `Produto`**: É o EXPERT em dados de produtos
  - Armazena nome, preço, quantidade, categoria
  - Fornece métodos getters/setters para acessar seus dados
  - Localização: `src/main/java/com/grasp/exemplo/model/Produto.java`

- **Classe `CalculadoraPrecoImpl`**: É o EXPERT em cálculos de preço
  - Concentra toda lógica de cálculo de preços, descontos e impostos
  - Implementa regras de negócio (desconto por categoria, por quantidade)
  - Localização: `src/main/java/com/grasp/exemplo/service/CalculadoraPrecoImpl.java`

**Por que atender aos princípios GRASP:**
- Cada classe centraliza a lógica relacionada ao seu domínio
- Facilita manutenção (mudanças em cálculos ficam em um só lugar)
- Melhora coesão (High Cohesion)

### 2. **INDIRECTION (Indireta)**

**O que é:** Atribuir responsabilidade a uma classe intermediária para desacoplar componentes.

**Aplicação no projeto:**

- **Interface `CalculadoraPreco`**: Atua como intermediária
  - Define contrato de métodos para cálculo
  - Desacopla cliente (Main) da implementação (CalculadoraPrecoImpl)
  - Localização: `src/main/java/com/grasp/exemplo/service/CalculadoraPreco.java`

- **Implementação `CalculadoraPrecoImpl`**: Esconde complexidade
  - Main não conhece detalhes de como os cálculos são feitos
  - Pode ser substituída por outra implementação sem afetar Main
  - Reduz acoplamento (Low Coupling)

**Por que atender aos princípios GRASP:**
- Desacopla apresentação da lógica de negócio
- Permite flexibilidade para trocar implementações
- Facilita testes (pode mockar a interface)

## 📁 Estrutura do Projeto

```
Atividade-GRASP/
├── pom.xml                          # Configuração Maven
├── README.md                        # Este arquivo
├── .gitignore                       # Arquivos ignorados pelo Git
└── src/
    ├── main/java/com/grasp/exemplo/
    │   ├── Main.java               # Classe principal de demonstração
    │   ├── model/
    │   │   └── Produto.java        # Modelo de Produto (EXPERT)
    │   └── service/
    │       ├── CalculadoraPreco.java       # Interface (INDIRECTION)
    │       └── CalculadoraPrecoImpl.java    # Implementação (EXPERT)
    └── test/java/com/grasp/exemplo/
        └── CalculadoraPrecoTest.java       # Testes JUnit
```

## 🛠️ Requisitos

- Java 11 ou superior
- Maven 3.6+
- IntelliJ IDEA (ou qualquer IDE Java)

## 🚀 Como Executar

### 1. Compilar o Projeto

```bash
mvn clean compile
```

### 2. Executar a Classe Main

```bash
mvn exec:java -Dexec.mainClass="com.grasp.exemplo.Main"
```

Ou via IDE:
- Abra a classe `Main.java`
- Clique em Run ou pressione Shift + F10 (IntelliJ)

### 3. Executar os Testes

```bash
mvn test
```

## 📊 Exemplo de Saída

```
=== DEMONSTRAÇÃO DOS PRINCÍPIOS GRASP ===

Princípio GRASP - EXPERT:
Cada classe é EXPERT em sua especialidade:
  - Produto: conhece dados do produto (nome, preço, quantidade)
  - CalculadoraPreco: conhece como calcular preços

Princípio GRASP - INDIRECTION:
Interface CalculadoraPreço atua como intermediária
  - Desacopla a lógica de cálculo da classe Main
  - Permite flexibilidade para trocar implementações

==================================================

TESTE 1 - Eletrônicos (15% desconto):
Produto: Produto{nome='Smartphone', preco=1500.0, quantidade=2, categoria='eletronicos'}
Preço final (com desconto): R$ 2550,00
Imposto (7%): R$ 178,50
Total com imposto: R$ 2728,50
...
```

## 💡 Como os Princípios GRASP são Aplicados

### Exemplo 1: Cálculo de Preço com Desconto

```java
// Classe Main (Cliente)
CalculadoraPreco calculadora = new CalculadoraPrecoImpl();  // INDIRECTION - usa interface
Produto produto = new Produto("Smartphone", 1500, 2, "eletronicos");  // EXPERT - Produto

// Main não sabe COMO calcular, delega para quem sabe (EXPERT)
double preco = calculadora.calcularPrecoFinal(produto, 2);
```

**Princípios em ação:**
- **INDIRECTION**: Main depende de `CalculadoraPreco` (interface), não de `CalculadoraPrecoImpl`
- **EXPERT**: `CalculadoraPrecoImpl` é expert em calcular preços
- **EXPERT**: `Produto` é expert em seus dados

### Exemplo 2: Cálculo de Imposto

```java
// CalculadoraPrecoImpl é EXPERT em calcular imposto
@Override
public double calcularImposto(double preco) {
    return preco * ALIQUOTA_IMPOSTO;  // Sabe a alíquota correta
}
```

**Princípios em ação:**
- **EXPERT**: Apenas `CalculadoraPrecoImpl` conhece como calcular imposto
- Facilita mudança: se alíquota mudar, altera-se em um único lugar

## 📋 Casos de Teste

O projeto inclui testes JUnit que validam:

| Teste | Propósito | Princípio GRASP |
|-------|-----------|-----------------|
| `testProdutoExpert()` | Produto armazena seus dados | EXPERT |
| `testDescontoEletronicos()` | Cálculo de desconto correto | EXPERT |
| `testCalculoImposto()` | Cálculo de imposto correto | EXPERT |
| `testCalculoPrecoFinalComDescontoCategoria()` | Integração de cálculos | EXPERT |
| `testIndirectionThroughInterface()` | Interface desacopla cliente | INDIRECTION |

## 🎓 Conclusão

Este projeto demonstra como aplicar princípios GRASP melhora:

✅ **Coesão**: Cada classe tem uma responsabilidade bem definida  
✅ **Desacoplamento**: Classes não dependem de implementações concretas  
✅ **Manutenibilidade**: Mudanças concentram-se em uma classe  
✅ **Testabilidade**: Componentes podem ser testados isoladamente  

## 📝 Notas

- Todo código inclui comentários explicativos dos princípios GRASP
- Cada método indica qual princípio está sendo aplicado
- Os testes servem como exemplos de uso dos princípios
