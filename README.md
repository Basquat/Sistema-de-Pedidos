# 🛒 Sistema de Pedidos

Sistema de gerenciamento de pedidos desenvolvido em **Java 25** com **Spring Boot 4**, utilizando uma interface de linha de comando (CLI) interativa. O sistema permite cadastrar clientes, associar cartões de crédito e registrar pedidos, com persistência de dados em banco **MySQL**.

---

## 📋 Funcionalidades

| Opção | Descrição |
|-------|-----------|
| 1     | Criar conta de cliente |
| 2     | Listar todos os clientes |
| 3     | Adicionar cartão de crédito |
| 4     | Fazer um pedido |
| 5     | Listar todos os pedidos |
| 0     | Sair do sistema |

---

## 🏗️ Arquitetura

O projeto segue a arquitetura em camadas padrão do Spring Boot:

```
CLI (AppRunner)
    └── Service (lógica de negócio)
            └── Repository (acesso ao banco via Spring Data JPA)
                    └── Model (entidades JPA mapeadas para MySQL)
```

### Entidades

- **Cliente** — Nome, CPF, CEP, login, senha e data de nascimento
- **Cartão** — Nome no cartão, CVV, número e data de vencimento
- **Pedido** — Descrição, valor e frete

### Pacotes

```
com.example.sistemadepedidos
├── CLI/            → AppRunner (interface de linha de comando)
├── models/         → Entidades JPA (clienteModel, cartaoModel, pedidoModel)
├── Repository/     → Interfaces Spring Data JPA
├── Service/        → Regras de negócio
└── SistemaDePedidosApplication.java
```

---

## ⚙️ Tecnologias

- Java 25
- Spring Boot 4.0.3
- Spring Data JPA + Hibernate
- Spring Cloud Netflix Eureka (cliente de descoberta de serviços)
- Spring Cloud OpenFeign (comunicação entre serviços)
- MySQL 9 (`mysql-connector-j`)
- Lombok
- Maven

---

## 🗄️ Banco de Dados

O projeto usa **MySQL**. Configure a conexão em `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/sistemadepedidos?useSSL=false&serverTimezone=UTC
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

> O Hibernate cria/atualiza as tabelas automaticamente com `ddl-auto=update`.  
> Certifique-se de que o banco `sistemadepedidos` já existe antes de iniciar.

---

## 🚀 Como executar

### Pré-requisitos

- Java 25+
- Maven 3.9+ (ou use o `mvnw` incluso)
- MySQL rodando localmente na porta `3306`

### Passos

**1. Clone o repositório**
```bash
git clone https://github.com/seu-usuario/sistemaDePedidos.git
cd sistemaDePedidos
```

**2. Crie o banco de dados no MySQL**
```sql
CREATE DATABASE sistemadepedidos;
```

**3. Configure as credenciais** em `src/main/resources/application.properties`

**4. Execute a aplicação**
```bash
# Windows
.\mvnw.cmd spring-boot:run

# Linux/macOS
./mvnw spring-boot:run
```

A aplicação iniciará o CLI interativo no terminal automaticamente após o boot do Spring.

---

## 🧪 Testes

```bash
.\mvnw.cmd test
```

Para rodar um teste específico:
```bash
.\mvnw.cmd test -Dtest=NomeDaClasseTest
```

---

## 📦 Build

Para gerar o `.jar` executável:
```bash
.\mvnw.cmd package -DskipTests
```

O artefato será gerado em `target/sistemaDePedidos-0.0.1-SNAPSHOT.jar`.

Para executá-lo diretamente:
```bash
java -jar target/sistemaDePedidos-0.0.1-SNAPSHOT.jar
```

---

## 👨‍💻 Autor

Desenvolvido como projeto de estudo de Spring Boot com persistência JPA e interface CLI.
