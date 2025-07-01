# ⚽ Sistema de Gerenciamento de Jogadores e Times

Aplicação backend desenvolvida em Java com o framework Spring Boot. O projeto tem como objetivo gerenciar jogadores e times de forma integrada, explorando operações CRUD e mapeamento de relacionamentos entre entidades.

## 🚀 Tecnologias Utilizadas

- Java 17  
- Spring Boot  
- Spring Data JPA (Hibernate)  
- MySQL  
- Maven  
- Lombok  
- Postman (para testes de requisição)  
- Swagger (se configurado)  

## 📁 Estrutura do Projeto

O projeto segue a arquitetura em camadas:
📦 src
┣ 📂controller
┣ 📂service
┣ 📂repository
┣ 📂model
┗ 📜 application.properties

---

```markdown

## ▶️ Como Executar o Projeto

### Pré-requisitos

- Java 17 instalado  
- MySQL em execução  
- Maven configurado  

### Passos

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git
````

2. Crie o banco de dados:

   ```sql
   CREATE DATABASE gerenciamento_jogadores;
   ```

3. Configure o `application.properties`:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/gerenciamento_jogadores
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   spring.jpa.hibernate.ddl-auto=update
   ```

4. Execute a aplicação:

   ```bash
   mvn spring-boot:run
   ```

5. Teste os endpoints com Postman ou Swagger:

   * `POST /jogadores e /times`
   * `GET /jogadores e /times`
   * `GET /jogadores/{id} e /times/{id}`
   * `DELETE /jogadores/{id} e /times/{id}`
   * `PUT /jogadores/{id} e /times/{id}`

