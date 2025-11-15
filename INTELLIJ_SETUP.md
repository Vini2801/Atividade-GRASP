# Como Abrir no IntelliJ IDEA

## 📖 Instruções Passo a Passo

### 1. Abrir o Projeto

1. Abra o **IntelliJ IDEA**
2. Clique em **File** → **Open** (ou **Open Project**)
3. Navegue até a pasta `/workspaces/Atividade-GRASP`
4. Selecione a pasta e clique em **Open**

### 2. Configurar o JDK (se necessário)

Se o IntelliJ pedir para configurar o JDK:
1. Clique em **File** → **Project Structure** (ou pressione `Ctrl+Alt+Shift+S`)
2. Selecione **Project** no painel esquerdo
3. Em **SDK**, escolha Java 11 ou superior
4. Se não tiver JDK instalado, clique em **Download JDK** e escolha a versão

### 3. Maven Configuration

O IntelliJ deve reconhecer automaticamente que este é um projeto Maven:
- Aguarde até que o IntelliJ carregar e indexar o projeto
- Você deve ver um painel do **Maven** no lado direito (ou em **View** → **Tool Windows** → **Maven**)

### 4. Compilar e Testar

#### Compilar:
1. Clique em **Build** → **Build Project** (ou pressione `Ctrl+F9`)
2. Ou use o painel Maven: clique em `m` → **Lifecycle** → **clean** → **compile**

#### Executar Testes:
1. Use o painel Maven: **m** → **Lifecycle** → **test**
2. Ou abra a classe `CalculadoraPrecoTest.java` e pressione `Ctrl+Shift+F10`

#### Executar a Aplicação:
1. Abra a classe `Main.java`
2. Clique com botão direito e selecione **Run 'Main.main()'**
3. Ou pressione `Shift+F10` com o cursor em `Main.java`

## 📁 Estrutura do Projeto no IntelliJ

```
Atividade-GRASP
├── src
│   ├── main
│   │   └── java
│   │       └── com.grasp.exemplo
│   │           ├── Main.java
│   │           ├── model
│   │           │   └── Produto.java
│   │           └── service
│   │               ├── CalculadoraPreco.java
│   │               └── CalculadoraPrecoImpl.java
│   └── test
│       └── java
│           └── com.grasp.exemplo
│               └── CalculadoraPrecoTest.java
├── target (gerado automaticamente)
├── pom.xml
└── README.md
```

## 🎯 Funcionalidades do IntelliJ para Aproveitar

### Code Navigation
- **Ctrl+Click** em uma classe ou método para ir à definição
- **Ctrl+H** para ver a hierarquia de classes/interfaces
- **Ctrl+B** para ir à definição do símbolo sob o cursor

### Refactoring
- **Shift+F6** para renomear classes/métodos
- **Ctrl+Alt+M** para extrair um método

### Code Analysis
- **Alt+Enter** para mostrar sugestões de correção
- O IntelliJ destaca automaticamente problemas de código

### Run Configurations
- Clique no dropdown ao lado do botão Run (▶)
- Selecione **Edit Configurations**
- Você pode criar configurações customizadas para executar o Main ou testes

## 🚀 Atalhos Úteis

| Atalho | Ação |
|--------|------|
| `Ctrl+F9` | Compilar projeto |
| `Shift+F10` | Executar classe/arquivo atual |
| `Ctrl+Shift+F10` | Executar testes da classe |
| `Ctrl+H` | Ver hierarquia de classes |
| `Ctrl+F12` | Ver estrutura do arquivo |
| `Alt+Insert` | Gerar código (getters, setters, etc) |
| `Ctrl+Alt+L` | Formatar código |

## 📝 Notas Importantes

1. **Maven**: O `pom.xml` configura todas as dependências e plugins
2. **Java 11**: O projeto está configurado para Java 11+
3. **Testes**: Todos os 9 testes devem passar sem erros
4. **Comentários**: Todos os comentários explicam quais princípios GRASP estão sendo aplicados

## ✅ Checklist de Configuração

- [ ] Projeto aberto no IntelliJ
- [ ] JDK configurado (Java 11+)
- [ ] Pasta `target` visível (projeto compilou)
- [ ] Pom.xml reconhecido pelo Maven
- [ ] Projeto compilado sem erros
- [ ] 9 testes JUnit passaram
- [ ] Main.java executável

Se tudo estiver funcionando, o projeto está pronto para estudo e desenvolvimento! 🎉
