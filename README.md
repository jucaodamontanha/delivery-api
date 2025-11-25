# Projeto Spring Boot (Maven)

Resumo rápido com instruções para configurar o banco de dados e executar o projeto localmente.

## Pré-requisitos
- Java 17+ instalado
- Maven 3.6+
- Banco de dados: PostgreSQL.
- (macOS) Brew/terminal para instalar serviços, se necessário

## Configuração do banco de dados

Abaixo há exemplos para PostgreSQL . Ajuste usuários/senhas conforme sua política.

### PostgreSQL
1. Criar banco e usuário:

   sudo -u postgres psql -c "CREATE USER app_user WITH PASSWORD 'strongpassword';"
   sudo -u postgres psql -c "CREATE DATABASE app_db OWNER app_user;"

2. Exemplo de `application.properties` (colocar em `src/main/resources/application.properties`):

   spring.datasource.url=jdbc:postgresql://localhost:5432/app_db
   spring.datasource.username=app_user
   spring.datasource.password=strongpassword
   spring.jpa.hibernate.ddl-auto=update
   spring.datasource.driver-class-name=org.postgresql.Driver
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect


   
## Variáveis de ambiente (opcional)
É recomendado não versionar credenciais. Exemplo de uso de variáveis de ambiente:

    export SPRING_DATASOURCE_URL="jdbc:postgresql://localhost:5432/app_db"
    export SPRING_DATASOURCE_USERNAME="app_user"
    export SPRING_DATASOURCE_PASSWORD="strongpassword"
    mvn spring-boot:run

O Spring Boot lê `SPRING_DATASOURCE_*` automaticamente.

## Como rodar o projeto

1. Buildar o projeto:

   mvn clean package -DskipTests

2. Rodar em modo desenvolvimento:

   mvn spring-boot:run

3. Rodar o JAR gerado:

   java -jar target/*.jar

4. Rodar testes:

   mvn test



## Observações
- Ajuste `spring.jpa.hibernate.ddl-auto` conforme necessidade (avoid `create` em produção).
- Mantenha credenciais fora do repositório (usar variáveis de ambiente ou Vault).
- Se a aplicação usa migrations (Flyway/Liquibase), execute as migrations em vez de `ddl-auto=update`.
