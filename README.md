# pizza_plaza_back

Sistema web desenvolvido como projeto universitário da disciplina de Programação Web, com foco em arquitetura moderna baseada em microserviços, APIs REST e integração entre front-end e back-end.

# 1. Escopo do Cliente

O cliente é proprietário de uma rede de pizzarias com atendimento físico e digital. Atualmente, enfrenta dificuldades no controle de pedidos, organização do histórico de vendas e gestão de acessos dos funcionários ao sistema.

O objetivo do projeto é desenvolver uma plataforma web completa que:

- Atraia mais clientes;
- Permita pedidos online de forma simples e intuitiva;
- Organize pedidos da loja física e digital em um único sistema;
- Facilite o rastreamento de pedidos;
- Controle o acesso de funcionários ao sistema;
- Melhore a gestão e o controle das vendas.

# 2. Objetivos do Sistema

O sistema Pizza Plaza será responsável por:
- Cadastro e autenticação de usuários (clientes, vendedores e administradores);
- Cadastro e gerenciamento de pizzas;
- Registro e gerenciamento de pedidos;
- Rastreamento de pedidos em tempo real;
- Controle de permissões por perfil de usuário;
- Centralização do histórico de vendas (loja física + online).

# 3. Arquitetura do Projeto

O sistema será desenvolvido utilizando arquitetura de microserviços, promovendo escalabilidade, organização e separação de responsabilidades.

Arquitetura Geral:
- Front-end: Angular (MVC)
- Back-end: APIs REST com Quarkus, Maven para controle de bibliotecas e build. Este projeto será dividido em:
    -  back: salva as interfaces que o front end usará para interagir com a regra de negócio;
    -  core: biblioteca contendo os serviços que sabem realizar as operações com as regras de negócios;
    -  entity: biblioteca contendo o mapeamente de entidades do banco de dados utilizando JPA e Hibernate;
- Persistência: Hibernate
- Banco de Dados: PostgreSQL

# 4. Microserviços Propostos

O sistema será dividido nos seguintes microserviços:
- Serviço de Autenticação responsável por:
    - Login e cadastro de usuários
    - Controle de permissões
    - Autorização por perfil (ADMIN, VENDEDOR, CLIENTE)

- Serviço de Produtos (Pizzas) responsável por:
    - Cadastro de pizzas
    - Atualização de valores
    - Controle de disponibilidade
    - Consulta de cardápio online

- Serviço de Pedidos responsável por:
    - Criação de pedidos
    - Integração com pedidos da loja física
    - Atualização de status (Recebido, Em preparo, Saiu para entrega, Entregue)
    - Rastreamento do pedido pelo cliente
      
- Serviço de Vendas e Histórico responsável por:
    - Registro de vendas
    - Relatórios
    - Consulta de histórico consolidado

# 5. Modelagem de Dados

O banco de dados será implementado utilizando:
- PostgreSQL como SGBD relacional
- Hibernate (JPA) para mapeamento objeto-relacional

Principais Entidades:
- Usuário
- Cliente
- Vendedor
- Administrador
- Pizza
- Pedido
- ItemPedido
- Venda
