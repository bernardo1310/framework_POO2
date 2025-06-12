# Criador de Banco de Dados Automatizado

## Sobre o projeto

Esse projeto surgiu da minha vontade de entender melhor como funciona a modelagem e a criação de um banco de dados relacional, mas de uma forma mais programática, usando Java. 
A ideia era construir algo que me permitisse **definir tabelas, campos e relacionamentos no código**, e depois gerar automaticamente os scripts SQL prontos para criar tudo no banco real.
Eu quis automatizar o processo que normalmente seria feito escrevendo SQL "na mão", e com isso também pratiquei conceitos importantes de orientação a objetos, como encapsulamento, composição e uso de interfaces.

## Como desenvolvi

Comecei pensando nos principais elementos de um banco de dados:

- O banco em si
- As tabelas
- Os campos (colunas)
- As chaves primárias e estrangeiras

Com isso, criei as seguintes classes:

### 1. BancoDados

Foi a primeira classe que fiz. Representa o banco como um todo. Ele armazena uma lista de tabelas e possui métodos para adicionar/remover tabelas.
Também implementei uma interface `Mantivel` (que explico abaixo), para que ele pudesse se "manter" — ou seja, gerar suas instruções SQL.

### 2. Tabela

Cada banco possui várias tabelas, então criei essa classe com uma lista de campos (`Campo`) e também de chaves estrangeiras (`ChaveEstrangeira`).
Aqui também implementei a interface `Mantivel`.

### 3. Campo

Essa representa uma coluna dentro da tabela. Possui os atributos nome, tipo, se é chave primária e se é nulo.
Achei importante deixar bem flexível.

### 4. ChaveEstrangeira

Fiz essa classe para representar o relacionamento entre tabelas, conectando um campo de uma tabela a outro campo de uma tabela diferente.
Isso ajudou bastante a simular relacionamentos reais entre entidades.

### 5. GeradorDeScript

Essa classe é a "geradora de SQL". Ela pega os dados modelados nas classes acima e monta os comandos SQL para criação do banco e das tabelas. 
Tentei deixar o código bem limpo e reutilizável.

### 6. ExecutorDeScript

Depois de gerar o SQL, eu queria executar direto no banco real, então fiz essa classe com base na `ConfiguracaoConexao`. 
Ela recebe o script e roda no banco usando JDBC.

### 7. ConfiguracaoConexao

Aqui eu só centralizei os dados de conexão: host, porta, usuário e senha. Isso deixou o código mais modular e seguro.

### 8. Interface Mantivel

Essa interface surgiu para padronizar o método `manter()`, que todas as classes (BancoDados, Tabela, Campo) devem implementar.
Ela é usada como ponto de entrada para qualquer tipo de manutenção (geração de script ou atualização futura).


