# Sistema de Caixa Eletrônico em Java

Este projeto consiste em um sistema de gerenciamento de contas bancárias escrito em Java. Ele permite aos usuários realizar operações como login, criação de contas, depósito, saque, transferência de fundos e consulta de saldo.

## Estrutura dos Scripts

O projeto é composto por dois scripts principais:

1. `Executar.java`: Responsável por iniciar o sistema e gerenciar a interação inicial com o usuário.
2. `Conta.java`: Define a classe `Conta`, que contém os métodos e atributos necessários para operar uma conta bancária.

## Funcionalidades

### `Executar.java`

- Solicita ao usuário se ele possui cadastro.
- Caso afirmativo, tenta fazer o login.
- Caso negativo, oferece a criação de uma nova conta.
- Gerencia a interação inicial com o usuário, redirecionando para o menu de operações da conta.

### `Conta.java`

- Define atributos de uma conta bancária: nome, CPF, senha, número da conta, saldo e saques restantes.
- Inclui métodos para:
  - Login.
  - Depósito.
  - Saque.
  - Transferência de fundos.
  - Exibição de menu de operações.

## Como Executar

1. Certifique-se de ter o [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) instalado em seu sistema.

2. Compile os arquivos Java usando o comando:

    ```sh
    javac Executar.java Conta.java
    ```

3. Execute o programa usando o comando:

    ```sh
    java Executar
    ```

## Fluxo de Uso

1. **Inicialização**:
   - O programa pergunta ao usuário se ele já possui um cadastro (`S` para sim, `N` para não).

2. **Login**:
   - Se o usuário já possui uma conta, ele deve fornecer seu nome, CPF, senha e número da conta para fazer o login.
   - Se as credenciais estiverem corretas, o menu de operações da conta é exibido.

3. **Criação de Conta**:
   - Se o usuário não possui uma conta, ele pode optar por criar uma fornecendo nome, CPF e senha.
   - Um número de conta é gerado aleatoriamente.
   - O usuário pode optar por fazer um depósito inicial.

4. **Menu de Operações**:
   - Após o login ou a criação de uma conta, o menu de operações é exibido, permitindo:
     - Verificar saldo.
     - Fazer depósitos.
     - Realizar saques.
     - Verificar extrato.
     - Transferir fundos para outra conta.
     - Encerrar o atendimento.