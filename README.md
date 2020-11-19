# kyrosb-01

Aplicação backend desenvolvida utilizando a linguagem Java e utilizando o framework Spring Boot, para gerenciamento dos dados do cliente. Dentre as funcionalidades da aplicação, estão: cadastrar um cliente, alteração dos dados de um cliente cadastrado e deletar o cliente já cadastrado.

### Persistência dos Dados

Para a persistência dos dados, foi utilizado o H2 Database, que armazena as informações na memória enquanto a aplicação estiver em execução. Foi escolhida esta tecnologia para acelerar o desenvolvimento das funcionalidades e facilitar o processo de debug e testes.

### Validação

Os dados a serem persistidos no banco são todos validados utilizando os recursos do framework Bean Validation.

### Testes

Os testes foram feitos utilizando o framework JUnit 5 e a biblioteca Mockito.

### Modo de Usar

###### Obs.: recomendo a utilização do postman para realizar as requisições abaixo

##### Cadastro de Cliente

Para cadastro de cliente, utilize a URL a seguir com o método POST, além de configurar o header com Content-Type:application/json.

> http://localhost:8080/api/v1/

##### Alteração de Cliente

Para alteração dos dados do cliente, utilize a URL a seguir com o método PUT, além de configurar o header com Content-Type:application/json. Na URL, certifique-se de substituir {id} pelo número correspondente ao id do cliente que terá os dados alterados.

> http://localhost:8080/api/v1/{id}

##### Deletar o Cliente

Para deletar o cliente, utilize a URL a seguir com o método DELETE. Certifique-se de substituir {id} pelo número correspondente ao id do cliente que será removido.

> http://localhost:8080/api/v1/{id}