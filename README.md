# Conta Bancária com Padrões de Projeto

Este projeto implementa um sistema bancário simples utilizando os padrões de projeto **Singleton**, **Proxy** e **Decorator**. O sistema permite operações de depósito e saque, com gerenciamento de segurança para autorizar essas operações.

## Estrutura do Projeto

### Pacotes

- **com.ufes.contabancaria**: Contém a classe principal e a lógica de execução do sistema.
- **com.ufes.contabancaria.model**: Define as classes do modelo, incluindo `Usuario`, `Operacao`, `ContaCorrente`, e interfaces relacionadas.
- **com.ufes.contabancaria.security**: Implementa a lógica de segurança para autorização de operações bancárias.
- **com.ufes.contabancaria.singleton**: Implementa o padrão Singleton para gerenciar o usuário logado.
- **com.ufes.contabancaria.proxy**: Implementa o padrão Proxy para controlar o acesso às operações da conta corrente.

## Requisitos

- Java 17 ou superior

## Como Executar

1. Clone o repositório ou baixe os arquivos.
2. Abra o projeto em sua IDE favorita (como IntelliJ IDEA ou Eclipse).
3. Compile e execute a classe `Principal`.

## Funcionamento

1. O usuário é criado e autenticado.
2. As operações de depósito e saque são realizadas através do `ContaCorrenteProxy`, que verifica se o usuário está autorizado.
3. Um extrato das operações é emitido e impresso no console.

### Exemplo de Uso

O código abaixo mostra a execução do sistema, onde um usuário realiza operações de saque e depósito:

```java
public static void main(String[] args) {
    Usuario usuario = new Usuario("João", true);
    UsuarioLogado.getInstance().setUsuario(usuario);

    IGerenciadorSeguranca autorizador = new GerenciadorSeguranca();
    ContaCorrenteProxy conta = new ContaCorrenteProxy(1000, autorizador);

    conta.sacar(100);
    conta.depositar(200);

    Stack<Operacao> extrato = conta.emitirExtrado();
    for (Operacao op : extrato) {
        System.out.println(op.getNome() + ": " + op.getValor());
    }
}
```

## Padrões de Projeto Utilizados

- **Singleton**: O `UsuarioLogado` é um singleton que garante que apenas uma instância do usuário logado exista durante a execução do programa.
- **Proxy**: O `ContaCorrenteProxy` atua como um intermediário para controlar o acesso às operações da conta corrente e verificar permissões.
- **Decorator**: Embora não implementado diretamente neste exemplo, este padrão pode ser utilizado para adicionar funcionalidades adicionais às operações bancárias, como registro de auditoria.

## Considerações Finais

Este projeto é uma demonstração básica da aplicação de padrões de projeto em um sistema bancário. Ele pode ser expandido com mais funcionalidades, como suporte a múltiplos usuários, persistência de dados e interfaces gráficas.

## Licença

Este projeto está licenciado sob a licença MIT. Veja o arquivo LICENSE para mais detalhes.
