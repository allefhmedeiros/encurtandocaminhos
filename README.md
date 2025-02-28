# API :: ESCOPO DO PROJETO

> DESENVOLVIMENTO DE UMA APLICAÇÃO BACKEND QUE SUPORTE REQUISIÇÕES VIA HTTP PARA A APLICAÇÃO ENCURTANDO CAMINHOS. O OBJETIVO DA APLICAÇÃO É GERENCIAR A BASE DE USUÁRIOS QUE ATRAVÉS DO SOFTWARE DE RELACIONAMENTO POSSAM CRIAR PUBLICAÇÕES [INCLUINDO AÇÕES COMO COMENTAR E REAGIR], PROMOVER EVENTOS E PRESTAR DE SERVIÇOS.

# API :: TECNOLOGIAS EMPREGADAS

> - LINGUAGEM DE PROGRAMAÇÃO: JAVA
> - PERSISTÊNCIA DE DADOS: POSTGRESQL
> - SPRINGBOT

# API :: ROTAS
> ###### ROTAS DE USUÁRIO
> - GET - [RETORNA TODOS OS USUÁRIOS] - `http://localhost:8080/usuarios/`
> - GET - [RETORNA USUÁRIO COM BASE NO ID] - `http://localhost:8080/usuarios/4`
> - POST - [CRIA UM NOVO USUÁRIO] - `http://localhost:8080/usuarios/`
> - DELETE - [DELETA USUÁRIO COM BASE NO ID] - `http://localhost:8080/usuarios/4`
> 
> ###### ROTAS DE SERVIÇO
> - GET - [RETORNA TODOS OS SERVIÇOS] - `http://localhost:8080/servicos`
> - GET - [RETORNA UM SERVIÇO COM BASE NO ID] - `http://localhost:8080/servicos/4`
> - PUT - [ATUALIZA UM SERVIÇO COM BASE NO ID] - `http://localhost:8080/servicos/4`
> - DELETE - [DELETA UM SERVIÇO COM BASE NO ID] - `http://localhost:8080/servicos/4`
> - POST - [CRIA UM NOVO SERVIÇO] - `http://localhost:8080/servicos`
> 
> ###### ROTAS DE EVENTO
> - GET - [RETORNA TODOS OS EVENTOS] - `http://localhost:8080/eventos`
> - GET - [RETORNA UM EVENTO COM BASE NO ID] - `http://localhost:8080/eventos/4`
> - PUT - [ATUALIZA UM EVENTO COM BASE NO ID] - `http://localhost:8080/eventos/4`
> - DELETE - [DELETA UM EVENTO COM BASE NO ID] - `http://localhost:8080/eventos/4`
> - POST - [CRIA UM NOVO EVENTO] - `http://localhost:8080/eventos`
> 
> ###### ROTAS DE PUBLICAÇÕES
> - GET - [RETORNA TODOS AS PUBLICAÇÕES] - `http://localhost:8080/publicacoes`
> - GET - [RETORNA UMA PUBLICAÇÃO COM BASE NO ID] - `http://localhost:8080/publicacoes/4`
> - PUT - [ATUALIZA UMA PUBLICAÇÃO COM BASE NO ID] - `http://localhost:8080/publicacoes/4`
> - DELETE - [DELETA UMA PUBLICAÇÃO COM BASE NO ID] - `http://localhost:8080/publicacoes/4`
> - POST - [CRIA UMA NOVA PUBLICAÇÃO] - `http://localhost:8080/publicacoes`
> 
> ###### ROTAS DE COMENTÁRIO
> - GET - [RETORNA TODOS OS COMENTÁRIOS POR PUBLICAÇÃO] - `http://localhost:8080/comentarios/publicacao/4`
> - GET - [RETORNA UM COMENTÁRIO COM BASE NO ID] - `http://localhost:8080/comentarios/1`
> - DELETE - [DELETA UM COMENTÁRIO COM BASE NO ID] - `http://localhost:8080/comentarios/1`
> - POST - [CRIA UM NOVO COMENTÁRIO] - `http://localhost:8080/comentarios`

# API :: ESTRUTURA LÓGICA

![image](https://github.com/user-attachments/assets/a9f6aa99-1482-4728-81dc-ec730cb3cbf6)


# API :: RELACIONAMENTO DE ENTIDADES

![Diagrama1](https://github.com/user-attachments/assets/805f3d19-9204-404d-8b89-7aa53e3e5a13)
