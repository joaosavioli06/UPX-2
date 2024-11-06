<p align="center">
  <img src="/img/gmail_profile_400x400-removebg-preview.png" alt="">
</p> 

# Usina de Projetos Experimentais 2 - Grupo ODSCoders
Neste repositório você encontrará o projeto do 2º semestre da disciplina de UPX - 2 (Usina de Projetos Experimentais 2) do grupo ODSCoders da turma A de Análise e Desenvolvimento de Sistemas EAD do Centro Universitário Facens.

## Integrantes
* Arthur Cezar Rivaroli - RA: 248437<br>
* Guilherme Gravalos Morais - RA: 249588<br>
* João Gabriel Savioli - RA: 247617 <br>
* Karla Alejandra Acosta Barrios - RA: 249369 <br>
* Luiz Fernando Brisola - RA: 249429 <br>
* Nathália Top Hondei- RA: 237298 <br>

## Sobre o Projeto

O projeto tem como objetivo desenvolver um sistema de gerenciamento de dispositivos de consumo de energia, focado em monitorar, registrar e exibir informações detalhadas sobre aparelhos elétricos e eletrônicos em uso em ambientes residenciais. O sistema foi projetado para auxiliar os usuários a acompanharem o uso de energia de maneira eficiente, contribuindo para práticas mais sustentáveis e alinhadas com a **ODS 7**, que visa promover o uso de energia acessível e limpa para todos.

Para desenvolver a aplicação, utilizamos a linguagem **Java** em conjunto com o banco de dados **MySQL**, além de uma interface gráfica intuitiva criada no **NetBeans**. A interface permite o cadastro de dispositivos com atributos detalhados, como tipo, potência, voltagem, horas de uso, localização e data de aquisição, além de fornecer campos para observações adicionais e estado de funcionamento. Cada dispositivo registrado é exibido em uma tabela, facilitando a visualização e o gerenciamento.

No código, foi aplicado uma estrutura de controle **MVC (Model-View-Controller)** para organizar as operações de banco de dados, a lógica de negócios e a exibição dos dados na interface. Utilizamos a biblioteca **DefaultTableModel** para atualizar a tabela em tempo real sempre que um dispositivo é adicionado ou alterado. A conexão com o banco de dados é gerida pela classe **ConnectionUtils**, que garante o funcionamento contínuo da aplicação ao manter uma conexão ativa e reutilizável.

O sistema também conta com funcionalidades para limpeza de campos, permitindo uma experiência de cadastro mais dinâmica. O projeto é de uso exclusivo para desktop e foi desenvolvido considerando-se a escalabilidade e a possibilidade de integração com outras plataformas de gerenciamento de energia no futuro.

## Tecnologias Utilizadas

* **Linguagem**: Java
* **Banco de Dados**: MySQL
* **IDE**: NetBeans
