[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/njI9GLKu)
## 🏦 **Classe: `Gincana`**

### 🎯 **Objetivo**
Implemente a classe `Gincana` conforme as especificações abaixo. Esta classe representa uma gincana de um evento com funcionalidades de inscrever participante , remover participante, transferir participante para outra gincana, reajustar o prêmio da gincana e desativar a gincana.

### 🔑 **Atributos**
1. **`nome`** (`String`) - Nome ou código da gincana.
2. **`premio`** (`Double`) - Valor do prêmio da gincana. 
3. **`qtdInscrito`** (`Integer`) - Quantidade atual de inscritos da gincana.
4. **`ativa`** (`Boolean`) - Status da gincana (ativa ou inativa).

### 🛠️ **Construtor**
- **`public Gincana(String nome, Double premio)`**
   - Inicializa uma gincana com o nome da gincana, valor do prêmio, qtdInscrito `0`, e define a gincana como `ativa`.

### 💰 **Métodos Públicos**

1. **`public void inscrever(Integer qtd)`**
   - Adiciona a qtd de inscritos à qtdInscrito da gincana, desde que:
      - O valor de qtd seja positivo (não pode ser negativo nem zero) e não seja `null`.
      - A gincana esteja ativa.
   - Caso a gincana esteja inativa, a inscrição não será realizada.

2. **`public Integer remover(Integer qtd)`**
   - Deduz o valor de qtd de inscritos a serem removidos da qtdInscrito da gincana, desde que:
      - O valor de qtd seja positivo e não seja `null`.
      - O valor de qtd seja menor ou igual à qtdInscrito.
      - A gincana esteja ativa.
   - Retorna a quantidade de inscritos removidos, caso a remoção tenha sido bem sucedida. 
   - Retorna `null` caso as condições não sejam atendidas, como qtdInscrito menor do que qtd, valor de qtd inválido, ou gincana inativa.

3. **`public Integer desativar()`**
   - Se a gincana já estava desativada, não faz nada e retorna null.
   - Desativa a gincana (`ativa` se torna `false`).
   - Retorna a quantidade de inscritos que haviam na gincana, não esquecendo de zerar `qtdInscrito` antes de retornar. 

4. **`public void transferir(Gincana destino, Integer qtdATransferir)`**
   - Transfere uma quantidade de inscritos (`qtdATransferir`) para outra gincana (`destino`), desde que:
      - A gincana destino seja válida e esteja ativa.
      - O valor de qtdATransferir seja positivo e não seja `null`.
      - Haja quantidade de inscritos suficiente para a transferência na gincana de origem.
      - A gincana origem esteja ativa.
   - Caso as condições não sejam atendidas, a transferência não ocorrerá.

5. **`public Boolean reajustarPremio(Double reajuste)`**
   - Se `reajuste` for zero ou negativo ou `null`, não faz nada e retorna `false`  
   - Atualiza o valor de `premio`, supondo que se o prêmio for reajustado em 20%, o valor passado em `reajuste` será de `0.20`
   - Caso tenha reajustado o prêmio, retorna `true`.

6. **`public String getNome()`**
   - Retorna o nome da gincana.

7. **`public Double getPremio()`**
   - Retorna o valor do prêmio.

8. **`public Integer getQtdInscrito()`**
   - Retorna a quantidade de inscritos.

9. **`public Boolean getAtiva()`**
   - Retorna o status da gincana (`true` para ativa, `false` para inativa).

10. **`public void setNome(String nome)`**
    - Define o nome da gincana.

### ❌ **Setters que não devem existir**
- **`setPremio(Double premio)`**: Não deve existir um setter para o atributo `premio`.
- **`setQtdInscrito(Integer qtdInscrito)`**: Não deve existir um setter para o atributo `qtdInscrito`.
- **`setAtiva(Boolean ativa)`**: Não deve existir um setter para o atributo `ativa`.

### ⚠️ **Atenção aos Nomes e Assinaturas**
- **Nomes dos Atributos e Métodos**: É necessário seguir rigorosamente os nomes dos atributos e métodos conforme especificado.
- **Assinaturas dos Métodos**: As assinaturas dos métodos (nome, tipo de retorno, parâmetros) devem ser exatamente como descritas.
- **Impacto nos Testes**: Qualquer desvio nos nomes ou assinaturas pode causar falhas nos testes automáticos.

### 📦 **Extensões e Classes Auxiliares**
- **Adição de métodos e atributos**: Você pode criar mais métodos e/ou atributos além dos especificados, desde que todas as funcionalidades descritas acima sejam implementadas corretamente.
- **Classes auxiliares**: Já existe uma classe `Main` com um método `main` para auxiliar nos testes manuais, caso deseje testar o comportamento da classe manualmente. No entanto, o que será contabilizado é a lógica empregada na classe `Gincana`.

### 📝 **Como enviar seu código para o Classroom**
1. **Adicionar os arquivos modificados**:
   ```bash
   git add .
   ```
2. **Fazer o commit com seu RA e nome**:
   ```bash
   git commit -m "RA: 123456 - Fulano de Tal"
   ```
3. **Enviar o commit para o repositório**:
   ```bash
   git push
   ```

### 🧪 **Testes do projeto**
- #### <span style="color:red;">**Os testes serão utilizados para atribuir uma nota ao seu trabalho, portanto é essencial que a classe siga rigorosamente o que é pedido.**</span>
- Rode os testes para garantir que a implementação está correta antes de enviar.

---

### 📚 **Lembre-se**: "Aprender não é sobre alcançar a perfeição, mas sobre crescer e evoluir a cada desafio superado." 🌱

### Boa sorte! 🚀

---