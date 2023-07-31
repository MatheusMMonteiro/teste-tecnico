# Teste Técnico

Teste técnico - Sistema de Gestão de Funcionários


### 📋 Pré-requisitos

Para iniciar o projeto é necessário a versão 11 do JDK ou superior.

[Download aqui!](https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html)


## 📦 Executando o projeto na IDE

Importe o projeto na sua IDE de preferência e instale as dependências necessárias para o mesmo.

Execute o arquivo ```TechApplication.java``` para iniciar o projeto.

Em seguida, no navegador, para visualizar a documentação, acesse ```http://localhost:8080```

## 📦 Executando o projeto com Docker

Certifique-se de ter o Docker instalado na sua máquina. [Saiba mais](https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html)

Para o primeiro passo, vamos gerar uma imagem Docker a partir do Dockerfile, que se encontra na raiz do projeto

Abra a linha de comando na pasta root do projeto e execute o comando a seguir: 

```docker build -t api:release .```

Em seguida, iremos criar um container para executar nossa imagem que foi gerada. Onde estará disponível na porta 8080.

Execute o seguinte comando:

 ```docker run -d --name api_container -p 8080:8080 api:release```

Agora abra o navegador e visualize a aplicação em ```http://localhost:8080/API```