# Criador de Banco de Dados Automatizado

## Sobre o projeto

Esse é um projeto da disciplina de POO 2, trabalho sobre Frameworks. A ideia era construir algo que me permitisse **definir tabelas, campos e relacionamentos no código**,  
e depois gerar automaticamente os scripts SQL prontos para criar tudo no banco real.  
Eu quis automatizar o processo que normalmente seria feito escrevendo SQL "na mão", pensando em conceitos importantes de orientação a objetos,  
como encapsulamento, composição e uso de interfaces.

---

## Como funciona o projeto

1. **Estrutura básica**  
   O projeto tem classes para representar o banco de dados, tabelas, campos e chaves estrangeiras, além de uma interface para operações de manutenção.

2. **Geração automática de scripts SQL**  
   O sistema gera automaticamente os scripts SQL para criar bancos de dados e tabelas, incluindo chaves primárias e estrangeiras, com base nas informações das classes.

3. **Configuração de conexão**  
   As configurações de conexão com o MySQL são feitas através de classes específicas, permitindo definir host, porta, usuário, senha e nome do banco.

4. **Execução dos scripts**  
   Um componente executa os scripts SQL gerados no banco real usando JDBC, facilitando a criação automática das estruturas no banco.

5. **Exemplo prático no Main**  
   A classe `Main` demonstra como montar os bancos, criar as tabelas com suas relações, gerar os scripts e executar no MySQL.

6. **Diagrama de classes**  
   O projeto possui um diagrama de classes organizado que mostra as relações entre as classes, usando ligações padrão de associação, composição e herança para facilitar o entendimento.

---

## Planejamento das classes principais

### 1. BancoDados

Representa o banco como um todo. Armazena uma lista de tabelas e possui métodos para adicionar/remover tabelas.  
Implementa a interface `Mantivel` para gerar suas instruções SQL.

---

### 2. Tabela

Representa uma tabela do banco. Possui listas de campos (`Campo`) e de chaves estrangeiras (`ChaveEstrangeira`).  
Também implementa a interface `Mantivel`.

---

### 3. Campo

Representa uma coluna da tabela. Contém atributos como nome, tipo, se é chave primária e se aceita valor nulo.

---

### 4. ChaveEstrangeira

Representa o relacionamento entre tabelas, conectando um campo de uma tabela a um campo de outra tabela, simulando relacionamentos reais.

---

### 5. GeradorDeScript

Classe responsável por gerar o código SQL a partir dos dados modelados nas classes, criando comandos para bancos e tabelas.

---

### 6. ExecutorDeScript

Executa os scripts SQL no banco real, usando as configurações definidas em `ConfiguracaoConexao` e JDBC.

---

### 7. ConfiguracaoConexao

Centraliza os dados da conexão ao banco: host, porta, usuário, senha e nome do banco.

---

### 8. Interface Mantivel

Padroniza o método `manter()`, implementado por `BancoDados`, `Tabela` e `Campo`, para facilitar operações de manutenção (como geração e execução de scripts).
