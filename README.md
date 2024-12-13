# MaeAtipicas

Bem-vindo ao repositório **MaeAtipicas**! Este projeto está sendo desenvolvido para criar uma plataforma robusta que ofereça suporte e recursos para mães de crianças com necessidades especiais. O foco principal está no desenvolvimento do backend utilizando Java e Spring Boot.

---

## Objetivo do Projeto

O objetivo do **MaeAtipicas** é criar um sistema que auxilie mães de crianças atípicas, oferecendo ferramentas e informações práticas para gerenciar desafios diários e promover a inclusão.

---

## Status do Projeto

🛠️ **Em desenvolvimento**  
Atualmente, estamos trabalhando na estruturação do backend, utilizando Java e Spring Boot. Funcionalidades estão sendo planejadas e implementadas.

---

## Funcionalidades Planejadas

- **API REST**: Desenvolvimento de endpoints para fornecer dados e funcionalidades ao frontend (em construção).  
- **Gerenciamento de Usuários**: Cadastro, login e controle de acesso com autenticação e autorização.  
- **Recursos Educacionais**: API para armazenar e disponibilizar materiais informativos.  
- **Comunidade Virtual**: Planejamento para integração futura de um espaço de troca de experiências.  
- **Ferramentas de Rotina**: Desenvolvimento de APIs para criação de guias, checklists e acompanhamento de tarefas.  

---

## Tecnologias Utilizadas

As principais tecnologias e ferramentas usadas no desenvolvimento incluem:  

- **Java**: Linguagem principal do backend.  
- **Spring Boot**: Framework para acelerar o desenvolvimento do backend.  
- **H2**: Banco de dados para armazenamento de informações.  
- **Maven**: Gerenciador de dependências.  
- **JUnit**: Para testes automatizados do backend.  

---

## Como Contribuir

Quer ajudar no desenvolvimento do **MaeAtipicas**? Siga os passos abaixo:  

1. Faça um **Fork** deste repositório.  
2. Crie uma branch com o nome da sua feature ou correção.  
   ```
   git checkout -b minha-feature
   ```
3. Realize as alterações necessárias e faça o commit.  
   ```
   git commit -m "Descrição da alteração"
   ```
4. Envie um **Pull Request** explicando as mudanças feitas.  

---

## Como Executar o Projeto Localmente

1. **Clone o repositório**:  
   ```
   git clone https://github.com/llucasmenezes/MaeAtipicas.git
   ```

2. **Configure o ambiente**: Certifique-se de ter o Java JDK 17 ou superior, Maven e MySQL instalados.

3. **Configure o banco de dados**:  
   Crie um banco de dados MySQL e atualize as configurações no arquivo `application.properties`.  
   ```
   spring.datasource.url=jdbc:mysql://localhost:3306/maeatipicas
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   ```

4. **Execute a aplicação**:  
   No terminal, rode o comando abaixo na raiz do projeto:  
   ```
   mvn spring-boot:run
   ```

5. A aplicação estará disponível em:  
   ```
   http://localhost:8080
   ```

---

## Licença

Este projeto está licenciado sob a [Licença MIT](https://opensource.org/licenses/MIT). Sinta-se à vontade para usar, modificar e compartilhar, mantendo os créditos.

---

## Contato

Para dúvidas, sugestões ou feedback, entre em contato:  

- **Criador**: Andre Lucas da Silva Menezes  
- **Email**: [llucasmenezes.dev@gmail.com](mailto:llucasmenezes.dev@gmail.com)  

---

Acompanhe o progresso do projeto e faça parte da construção dessa iniciativa que busca transformar vidas!
