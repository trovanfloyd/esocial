# eSocial


**[PROJETO EM DESENVOLVIMENTO] Atenção!** API ainda em desenvolvimento.

## Guia rápido

### Pré-requisitos

- Git (https://git-scm.com/)
- Docker (https://www.docker.com/)
- Docker Compose (https://docs.docker.com/compose/)

### Download e construção

1. Clone o projeto

```shellscript
$ git clone http://srv-gitlab/seplag/esocial-spring.git
$ cd esocial
```

2. Crie um arquivo `src/docker/maven/settings.xml` caso tenha alguma configuração específica do maven (essa configuração será copiada para o docker conseguir fazer a build)

3. Construa as imagens docker

```shellscript
$ docker-compose build
```

### Configuração

1. Copie sua chave para a pasta `./assinador/src/main/resources`

```shellscript
$ cp local/da/chave/esocial.pfx ./assinador/src/main/resources/esocial.pfx
```

2. Edite o arquivo de configuração `application.properties` para ficar de acordo com seu ambiente


### Execução

```shellscript
docker-compose up
```
> Obs: O docker-compose sobe um banco postgres e a aplicação Java

Verifique se a aplicação está no ar acessando a url

```
http://localhost:8080/esocial-jt-service/actuator/health
```

## Características

O projeto é dividido nos seguintes módulos:

- extrator: Modelos básicos do esocial e geração dos arquivos XML
- assinador: Assinatura digital dos arquivo XML
- mensageiro: Pacote de mapeamento dos serviços do WSDL / API RESTful para comunicação com eSocial-GOV.

O **extrator** é o módulo que recebe os dados de uma **ocorrência\*** dos sistemas de origem, tranforma em um **evento** do eSocial e cria o arquivo XML.

O **assinador** é módulo que assina o arquivo XML criado pelo extrator

O **mensageiro** é o módulo do sistema eSocial na Seplag, que recebe dados de ocorrências da vida funcional dos trabalhadores/servidores e os comunica ao sistema eSocial governametal central [eSocial-Gov](https://portal.esocial.gov.br/).

Em poucas palavras, este módulo transmite para o eSocial-Gov e posteriormente consulta o resultado de processamento com eventuais erros. Além disso, fornece API para consulta do estado interno da aplicação.

Todos os móludos foram construídos em [Java 8](http://www.oracle.com/technetwork/pt/java/javaee/overview/index.html) utilizando o framework [Spring Boot](https://spring.io/projects/spring-boot). É uma aplicação primordialmente de _backend_ que fornece API RESTful.


> Obs. 1: para não confundir os conceitos, os dados recebidos pelo extrator são chamados de "ocorrencia" enquanto que os XMLs que são enviados para o eSocial-Gov são chamados de "eventos".


## Instalação

### Pré-requisitos

- [Java EE 8](http://www.oracle.com/technetwork/pt/java/javaee/overview/index.html);
- [Maven 3.3.9](https://maven.apache.org/index.html) (ou superior);
- [Git 2.15.0](https://git-scm.com/) (ou superior);
- [Certificado Digital ICP-Brasil A1 válido](https://portal.esocial.gov.br/institucional/ambiente-de-producao-restrita/perguntas-frequentes-producao-restrita#02---certificado-digital) (obrigatório mesmo para testes).

### Banco de dados

Atualmente, o **extrator**, **assinador** e **mensageiro** utilizam **PostgreSQL** mas em teoria é compatível com outros bancos. Os parâmetros de conexão devem ser passados no arquivo de configuração, como explicado mais adiante.

#### Criação/Atualização do banco de dados

Os scripts de criação do banco ficam localizados em . Os scripts podem ser executados de forma manual, porém utilizamos o [flyway](https://flywaydb.org/) para automatizar esse processo.

Execute o seguinte comando preenchendo os valores com a URL de conexão do banco, usuário e senha para criar / atualizar as tabelas no seu banco de dados.

```shellscript
$ cd src/extrator
$ mvn flyway:migrate -Dflyway.url=... -Dflyway.user=... -Dflyway.password=...
# i.e: mvn flyway:migrate -Dflyway.url=jdbc:postgresql://localhost:5432/postgres -Dflyway.user=postgres -Dflyway.password=esocial
```

### Download da aplicação

```bash
git clone http://srv-gitlab/seplag/esocial-spring.git
```

### Configuração

Os seguintes parâmetros de configuração (conexão com o banco de dados e etc) devem ser passado editando o arquivo `resources/application-(dev,homol,prod).properties`.

```properties

spring.datasource.url=
spring.datasource.username=
spring.datasource.password=
spring.datasource.driver-class-name=
spring.jpa.database-platform=
```

> Obs.: Como qualquer aplicação Spring Boot, existem outras maneiras de [sobreescrever os parâmetros de configuração](https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-external-config.html).

### Build e execução

Para fazer build do projeto, execute:

```bash
cd src
mvn clean package
```

E para iniciar:

```bash
java -jar src/extrator/target/extrator*.jar
java -jar src/assinador/target/assinador*.jar
java -jar src/mensageiro/target/mensageiro*.jar
```

Verifique se a aplicação está no ar acessando a url

```
http://localhost:8080/extrator/actuator/health
http://localhost:8080/assinador/actuator/health
http://localhost:8080/mensageiro/actuator/health
```

### Testando o envio


O log da aplicação irá exibir o status da transmissão para o eSocial-Gov, e também será possível consultar pelo método **GET** em alguns instantes:



### Limpando o ambiente de Produção Restrita

É possível apagar os dados enviados para o ambiente de produção restrita por comando via **POST**

```
/extrator/producao-restrita/acoes/limpar/{nrInsc}
```

## API Rest

### Documentação dos serviços pode ser acessada em:

http://localhost:8080/api/esocial/extrator/swagger-ui.html

## Escopo

### O que esse software **faz**?

Esse pedaço da solução compreende:

- Recepção de ocorrências provenientes dos sistemas de origem;
- Conversão dessas ocorrências em eventos do eSocial, no formato XML;
- Orquestração do envio dos eventos ao eSocial-GOV;
- Consulta do resultado do processamento dos eventos enviados; e
- Gerência dos detalhes de conexão com o eSocial-GOV (assinatura dos eventos, conexão com certificado, etc.).

### O que esse software **não faz**?

Não tratamos nesse projeto de:

- Extração e/ou transformação de dados dos sistemas finalísticos das organizações usuárias;
- Manipulação de qualquer forma que seja dos dados recebidos; e
- Validação semântica dos dados recebidos.

## Estado atual

Atualmente, o sistema já é capaz de receber dados de eventos de tabela, transmitir de forma automática
para o eSocial-GOV e exibir o resultado do processamento (sucesso ou mensagens de erro).


### Status por evento

#### 0.1.0

| Fase          | Evento | Nome Evento                         | Versão | Envio Inicial |
| ------------- | ------ | ----------------------------------- | -----: | ------------: |
| Envio inicial | S-1000 | Empregador/Contribuinte             | 2.4.02 |         Feito |
| Envio inicial | S-1005 | Estabelecimentos                    | 2.4.02 |   **Fazendo** |
| Envio inicial | S-1010 | Rubricas                            | 2.4.02 |   **Fazendo** |
| Envio inicial | S-1020 | Lotações Tributárias                | 2.4.02 |   **Fazendo** |
| Envio inicial | S-1030 | Cargos/Empregos Públicos            | 2.4.02 |         Feito |
| Envio inicial | S-1035 | Carreiras Públicas                  | 2.4.02 |         Feito |
| Envio inicial | S-1040 | Funções/Cargos em Comissão          | 2.4.02 |   **Fazendo** |
| Envio inicial | S-1050 | Horários/Turnos de Trabalho         |     NA |   **Fazendo** |
| Envio inicial | S-1070 | Processos Administrativos/Judiciais | 2.4.02 |   **Fazendo** |
| Envio inicial | S-1080 | Operadores Portuários               |     NA |            NA |
| Inclusão      | S-1005 | Estabelecimentos                    | 2.4.02 |         Feito |
| Inclusão      | S-1010 | Rubricas                            | 2.4.02 |   **Fazendo** |
| Inclusão      | S-1020 | Lotações Tributárias                | 2.4.02 |   **Fazendo** |
| Inclusão      | S-1030 | Cargos/Empregos Públicos            | 2.4.02 |         Feito |
| Inclusão      | S-1035 | Carreiras Públicas                  | 2.4.02 |         Feito |
| Inclusão      | S-1040 | Funções/Cargos em Comissão          | 2.4.02 |   **Fazendo** |
| Inclusão      | S-1050 | Horários/Turnos de Trabalho         |     NA |            NA |
| Inclusão      | S-1070 | Processos Administrativos/Judiciais | 2.4.02 |   **Fazendo** |
| Alteração     | S-1000 | Empregador/Contribuinte             | 2.4.02 |   **Fazendo** |
| Alteração     | S-1005 | Estabelecimentos                    | 2.4.02 |   **Fazendo** |
| Alteração     | S-1010 | Rubricas                            | 2.4.02 |   **Fazendo** |
| Alteração     | S-1020 | Lotações Tributárias                | 2.4.02 |   **Fazendo** |
| Alteração     | S-1030 | Cargos/Empregos Públicos            | 2.4.02 |   **Fazendo** |
| Alteração     | S-1035 | Carreiras Públicas                  | 2.4.02 |   **Fazendo** |
| Alteração     | S-1040 | Funções/Cargos em Comissão          | 2.4.02 |   **Fazendo** |
| Alteração     | S-1050 | Horários/Turnos de Trabalho         |     NA |            NA |
| Alteração     | S-1070 | Processos Administrativos/Judiciais | 2.4.02 |   **Fazendo** |
| Exclusão      | S-1005 | Estabelecimentos                    | 2.4.02 |   **Fazendo** |
| Exclusão      | S-1010 | Rubricas                            | 2.4.02 |   **Fazendo** |
| Exclusão      | S-1020 | Lotações Tributárias                | 2.4.02 |   **Fazendo** |
| Exclusão      | S-1030 | Cargos/Empregos Públicos            | 2.4.02 |   **Fazendo** |
| Exclusão      | S-1035 | Carreiras Públicas                  | 2.4.02 |   **Fazendo** |
| Exclusão      | S-1040 | Funções/Cargos em Comissão          | 2.4.02 |   **Fazendo** |
| Exclusão      | S-1050 | Horários/Turnos de Trabalho         |     NA |            NA |
| Exclusão      | S-1070 | Processos Administrativos/Judiciais | 2.4.02 |   **Fazendo** |

**Próximos eventos serão analisados após conclusão da primeira fase.**

