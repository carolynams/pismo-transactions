# Pismo Transactions - Rotina de transações

Projeto responsável por calcular a rotina de transações, sendo dividido em três API's:

* createAccount: API responsável por criar uma conta
* findAccount: API responsável por buscar uma conta
* createTrasanction: API responsável por criar transacao

# Como Funciona?

Com base nas informações recebidas pelas APIs, é possível criar e buscar uma conta, além de criar uma transação.

O fluxo de transação é dividido em 4 tipos: COMPRA À VISTA, COMPRA PARCELADA, SAQUE ou PAGAMENTO. Apenas para o tipo
PAGAMENTO, a transação é salva com valor positivo, pois se trata de uma transação de entrada. Para os demais tipos, o
valor transacionado é negativado, pois são transações de saída.

## Pré-requisitos

* [Java 11](https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html)
* [Maven](https://maven.apache.org/install.html)
* [Docker](https://docs.docker.com/engine/install/ubuntu/)
  ou [WSL](https://learn.microsoft.com/pt-br/windows/wsl/install)

## Rodando localmente

1. Extraia o arquivo transaction-routine.zip para uma pasta e entre no diretório do projeto

  ```bash
  cd transaction-routine
  ```

2. Instale as dependências

  ```bash
  mvn clean install
  ```

3. Acesse a pasta de target

  ```bash
  cd target/
  ```

4. Inicie o servidor atraves do jar

  ```bash
  java -jar transaction-routine-0.0.1.jar
  ```

5. Ou execute atraves da classe Application.class

## Rodando via Docker (Ubuntu)

1. Extraia o arquito transaction-routine.zip para uma pasta e entre no diretório do projeto

```bash
  cd transaction-routine
```

2. Execute o seguinte comando para criar a imagem no docker:

```bash
  sudo docker build -t transaction-routine .
```

3. Executando o container

```bash
  sudo docker run -i transaction-routine
```

4. Após a execução do comando a cima, o programa já estará rodando.