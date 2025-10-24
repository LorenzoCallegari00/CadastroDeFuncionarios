#  Cadastro de Funcionários

>  **Projeto de Estudos** - Esta é uma aplicação desenvolvida para fins educacionais e aprendizado de tecnologias backend.

Uma API REST para gerenciamento de funcionários e tarefas desenvolvida com Spring Boot. Projeto criado para estudo e prática de conceitos fundamentais de desenvolvimento backend com Java e Spring Framework.

##  Tecnologias Utilizadas

- **Java**
- **Spring Boot**
- **Spring Data JPA**
- **Maven**
- **H2/MySQL**

##  Funcionalidades

-  Cadastro de funcionários
-  Listagem de funcionários
-  Atualização de dados de funcionários
-  Exclusão de funcionários
-  Gerenciamento de tarefas
-  Associação de tarefas a funcionários

##  Pré-requisitos

Antes de começar, você precisará ter instalado em sua máquina:

- [Java JDK 11+](https://www.oracle.com/java/technologies/downloads/)
- [Maven 3.6+](https://maven.apache.org/download.cgi)
- IDE de sua preferência (IntelliJ IDEA, Eclipse, VS Code)

##  Como Executar

1. **Clone o repositório**
```bash
git clone https://github.com/LorenzoCallegari00/CadastroDeFuncionarios.git
cd CadastroDeFuncionarios
```

2. **Configure o banco de dados**
   
   Edite o arquivo `application.properties` em `src/main/resources/` com suas configurações de banco de dados.

3. **Compile e execute o projeto**
```bash
mvn clean install
mvn spring-boot:run
```

4. **Acesse a aplicação**
   
   A API estará disponível em: `http://localhost:8080`

## Endpoints da API

### Funcionários

```http
GET    /api/funcionarios          # Lista todos os funcionários
GET    /api/funcionarios/{id}     # Busca funcionário por ID
POST   /api/funcionarios          # Cadastra novo funcionário
PUT    /api/funcionarios/{id}     # Atualiza funcionário
DELETE /api/funcionarios/{id}     # Remove funcionário
```

### Tarefas

```http
GET    /api/tarefas               # Lista todas as tarefas
GET    /api/tarefas/{id}          # Busca tarefa por ID
POST   /api/tarefas               # Cadastra nova tarefa
PUT    /api/tarefas/{id}          # Atualiza tarefa
DELETE /api/tarefas/{id}          # Remove tarefa
```

## Estrutura do Projeto

```
CadastroDeFuncionarios/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com.example.CadastroDeFuncionarios/
│   │   │       ├── Employees/              # Módulo de Funcionários
│   │   │       ├── Tasks/                  # Módulo de Tarefas
│   │   │       │   └── Controller/
│   │   │       │       └── TasksController
│   │   │       ├── dto/                    # Data Transfer Objects
│   │   │       ├── mapper/                 # Mapeamento de entidades
│   │   │       ├── Model/                  # Entidades JPA
│   │   │       ├── Repository/             # Repositories
│   │   │       ├── Service/                # Camada de serviço
│   │   │       ├── TasksControllerUI       # Interface UI
│   │   │       ├── CadastrodeFuncionariosApplication
│   │   │       └── HomeController
│   │   └── resources/
│   │       ├── db.migration/               # Scripts de migração
│   │       ├── static/                     # Arquivos estáticos
│   │       ├── templates/                  # Templates Thymeleaf
│   │       └── application.properties
```

## Exemplo de Uso

### Cadastrar um Funcionário

```bash
curl -X POST http://localhost:8080/api/funcionarios \
  -H "Content-Type: application/json" \
  -d ' {
        "name": "Pedro Costa",
        "department": "FINANCEIRO",
        "age": 31,
        "imgUrl": "https://i.pravatar.cc/150?img=1",
        "email": "pedro.costa@empresa.com",
        "tasks": {
            "id": 1
        },
        "nivel": "PLENO"
    }'
```

### Listar Funcionários

```bash
curl -X GET http://localhost:8080/api/funcionarios
```

## Aprendizados

Este projeto foi desenvolvido com o objetivo de praticar e consolidar conhecimentos em:

- Desenvolvimento de APIs REST com Spring Boot
- Arquitetura MVC
- Persistência de dados com JPA/Hibernate
- Boas práticas de desenvolvimento
- Versionamento de código com Git

## Roadmap e Melhorias Futuras

O projeto está em constante evolução como ferramenta de aprendizado. Funcionalidades planejadas:

- [ ] **Testes Unitários** - Implementação de testes com JUnit e Mockito
- [ ] **Autenticação e Autorização** - Sistema de login com Spring Security e JWT
- [ ] **Exception Handling** - Tratamento global de exceções e respostas padronizadas
- [ ] **Docker** - Containerização da aplicação para facilitar deploy e execução

## 👤 Autor

**Lorenzo Callegari**

- GitHub: [@LorenzoCallegari00](https://github.com/LorenzoCallegari00)

*Projeto desenvolvido para fins educacionais e de estudo pessoal. Não recomendado para uso em produção.*
