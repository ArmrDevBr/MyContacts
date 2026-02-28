# MyContacts - Sistema de Agenda de Contatos em Java

Este é um sistema de gerenciamento de contatos via linha de comando (CLI) desenvolvido em Java. O projeto foi criado com o objetivo de aplicar os pilares da Programação Orientada a Objetos (POO) e boas práticas de desenvolvimento.

## 🚀 Funcionalidades

- **Adicionar Contatos:** Permite cadastrar contatos pessoais e comerciais.
- **Diferenciação de Tipos:** Contatos comerciais possuem o campo adicional "Empresa".
- **Listagem Completa:** Exibe todos os contatos salvos na memória.
- **Busca por Nome:** Localiza contatos específicos utilizando filtros.
- **Remoção Segura:** Permite remover contatos após confirmação.
- **Validação de E-mail:** Garante que o e-mail inserido contenha o caractere `@`.

## 🏗️ Conceitos de POO Aplicados

- **Encapsulamento:** Uso de atributos `private` e métodos `getters/setters` nas classes `Contato` e `ContatoComercial`.
- **Herança:** A classe `ContatoComercial` estende a classe `Contato`, reaproveitando atributos e métodos.
- **Polimorfismo:** Sobrescrita (`@Override`) do método `toString()` para exibir informações específicas de cada tipo de contato.
- **Tratamento de Exceções:** Implementação de `ContatoNaoEncontradoException` para lidar com buscas sem resultados de forma elegante.
- **Collections:** Uso de `ArrayList` para armazenamento dinâmico e `Iterator` para manipulação segura da lista.

## 🛠️ Tecnologias Utilizadas

- **Linguagem:** Java 17+
- **Paradigma:** Orientada a Objetos
- **Ferramentas:** IDE (NetBeans/IntelliJ/VS Code)

## 📁 Estrutura do Projeto

```text
src/
└── mycontacts/
    ├── app/           # Classe Main (Ponto de entrada)
    ├── controller/    # Lógica de negócio (Agenda.java)
    ├── model/         # Entidades (Contato, ContatoComercial)
    ├── exceptions/    # Exceções personalizadas
    └── utils/         # Classes utilitárias (ValidadorEmail)
