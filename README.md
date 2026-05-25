 
 
## Criar, configurar e iniciar o projeto (1)

### Setup base

- [x] criar projeto
- [x] configurar containers (aplicação e banco de dados)
- [x] iniciar projeto webapp
- [x] configurar pom.xml
- [x] rodar projeto para validar

- [x] iniciar projeto webapp

```bash
  mvn archetype:generate \
  -DgroupId=com.example \
  -DartifactId=app \
  -DarchetypeArtifactId=maven-archetype-webapp \
  -DinteractiveMode=false
```

- [x] configurar pom.xml

```bash
<properties>
	<maven.compiler.source>1.8</maven.compiler.source>
	<maven.compiler.target>1.8</maven.compiler.target>
</properties>

[...]

<dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>javax.servlet-api</artifactId>
      <version>4.0.1</version>
      <scope>provided</scope>
</dependency>


[...]

<build>
	<finalName>app</finalName>
	
	<plugins>

          <plugin>
              <groupId>org.apache.tomcat.maven</groupId>
              <artifactId>tomcat7-maven-plugin</artifactId>
              <version>2.2</version>

              <configuration>
                  <port>8080</port>
                  <path>/</path>
              </configuration>

          </plugin>

      </plugins>
</build>

```


---

## Criar estrutura MVC e configurar Eclipse (2)

- [x] criar estrutura MVC
- [ ] criar primeira rota
- [ ] ajustar eclipse para poder iniciar, parar, reiniciar o tomcat que está dentro do container
- [ ] ajustar eclipse para debug da aplicação


- [x] web.xml para interpretação das scriptlets no jsp

```xml
<?xml version="1.0" encoding="UTF-8"?>

<web-app
    xmlns="http://xmlns.jcp.org/xml/ns/javaee"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="
        http://xmlns.jcp.org/xml/ns/javaee
        http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
    version="4.0">

</web-app>
```

Antes a resposta devolvida pelo servlet só era interpretada com:

```html
<h`><%= request.getAttribute("message") %></h1>
```

foi possível usar:
```html
<h1>${message}</h1>
```


---

## Configurar e testar acesso pela aplicação ao banco de dados (3)

- [ ] criar banco de dados no postgres (usar dbeaver para gerenciar o postgres
- [ ] criar estrutura de tabelas necessárias (CRUD de Pets simples)
- [ ] configurar aplicação para se conectar com o banco de dados
- [ ] realizar primeira conexão e consulta ao banco de dados para testar
- [ ] criar carga de dados no banco de dados


---

## Criar funcionalidade de consulta de massa de dados (4)

- [ ] criar funcionalidade de consulta de lista de dados
- [ ] aplicar paginação na listagem
- [ ] criar filtro de busca na página


---

## criar funcionalidade de consultar unidade (5)

- [ ] criar funcionalidade de consultar uma unidade
- [ ] criar pagina de visualização
- [ ] navegar entre a pagina de listagem e a pagina de consulta


---

## criar funcionalidade de edição (6)

- [ ] criar funcionalidde de edição de uma unidade
- [ ] fazer reúso da tela de consulta para edição dos dados
- [ ] salvar visualizando os dados atualizados.


---

## criar deleção de unidade de registro (7)

- [ ] criar funcionalidade de seleção de unidade a partir da tela de listagem
- [ ] criar modal de confirmação da deleção
- [ ] usar soft Delete.


---

## Aplicar estilo css nas paginas (8)

- [ ] aplicar css nas paginas
- [ ] configurar bootstrap
- [ ] adicionar assets


---

## criar cadastro de unidade de registro (9)

 - [ ] criar modal de cadastro de pet
 - [ ] usar ajax (para praticar)
 - [ ] o botão ficará na tela principal onde tem a listagem
 - [ ] ao salvar a listagem será atualizada sem recarregar a página.


---


