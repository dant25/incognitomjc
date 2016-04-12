Um compilador MiniJava simples para a disciplina de Compiladores 2010.1 UFC.

Equipe:
Daniel Nascimento
Jonas Deyson
Thiago Alves



---


Relatório Compiladores - Front End


Introdução

Este projeto trata do desenvolvimento de um compilador elaborado em módulos para a linguagem MiniJava que é um subconjunto da linguagem de programação java. Um compilador é um programa que transforma um texto em uma linguagem de programação em uma outra linguagem executável em um computador. No nosso caso a linguagem inicial é minijava e a final é a Jouette assembly language. O compilador desenvolvido é constituído de vários módulos e interfaces entre esse módulos. Desenvolver o compilador em vários módulos permite, por exemplo, mudar a linguagem final modificando apenas alguns módulos possibilitado o reuso de componentes. Nas interfaces temos as representações intermediárias, que muito frequentemente são árvores, que têm um padrão de entrada e saída para os módulos sendo, assim, tão importantes quanto esses últimos. Para ajudar na geração de código dos módulos de análise léxica e análise sintática foi usado a ferramenta JavaCC.


1 - Análise Léxica

O analisador léxico é a primeira etapa de um compilador, então primeiramente temos que verificar se a entrada do nosso compilador(código-fonte de um programa) está valido e produzir uma sequencia de símbolos, chamados "símbolos léxicos" ou tipos de tokens, descartando espaços em branco e comentários. Esses tokens são unidades na gramática da linguagem fonte que podem ser manipulados mais facilmente pelo parser. As etapas de análise léxica e sintática são independentes porque seria complicado para a última lidar com espaços em branco e comentários em todos os pontos. Os tokens são sempre considerados como a maior cadeia de caracteres que formam um token. No nosso caso usamos o JavaCC para verificar o código-fonte com alfabeto do MiniJava. Na implementação são usados expressões regulares para especificar os tokens e autômatos finitos para fazer o reconhecimento.


2 - Análise Sintática

Sabendo que o nosso código-fonte do programa está dentro do alfabeto do MiniJava, devemos ter um parsing para analisar a sequência de entrada e verificar se está de acordo com uma Gramatica Livre de Contexto, que descreve estruturas sintáticas de forma declarativa e que acrescenta recursividade necessário ao parsing, já pré-estabelecida. O parsing transforma o código-fonte em uma árvore, o que é conveniente para a próxima fase e captura a hierarquia implícita desta entrada, tal como prioridade na multiplicação e divisão. Seguindo as regras da gramática do MiniJava e com a ajuda do JavaCC, construímos a árvore sintática da estrutura. O JavaCC é um gerador léxico e sintático para gramatica LL(k) e usamos nele um Lookahead de 2 níveis. Entender a sintaxe do JavaCC foi uma pequena dificuldade encontrada pela equipe nesta fase.


3 - Tabela de Símbolos

É uma estrutura de dados do tipo tabela hash onde cada identificador no programa é associado com as informações relativas a sua declaração(tipo, escopo, e as vezes sua localização). Ela é utilizada como base para comparações ou mesmo atualizada com novos identificadores durante a saída. A implementação da tabela de símbolos foi feita de acordo com a filosofia teórica de uma Tabela de Símbolos. Não foi seguido o padrão que o livro mostra nessa fase de construção do compilador. Foi senso em comum fazer um implementação de acordo com o nosso conhecimento, logo podemos dize que temos algo original. Preferimos criar uma só classe que gerenciasse os tokens. No livro ele cria uma classe do tipo Simbolo, mas para o nosso entendimento é uma redundância falar que evita comparação de strings se ele implementa a classe Simbolo retornando uma string. Então criamos numa mesma classe o gerenciamento de todas as manipulações que serão feitas sobre os tokens.

4 - Verificação de Tipos
A verificação de tipos é feita usando a tabela de símbolos já criada no modulo anterior. O que realizamos nessa parte é percorrer a arvore de sintaxe abstrata e onde tivermos definições de variáveis, métodos e classes nós inserimos seus valores na nossa tabela de símbolos. Agora quando essas variáveis, métodos e classes forem chamadas nós teremos de verificar na tabela de símbolos se os valores estão de acordo com a chamada ou retorno. Caso os valores não estejam corretos é retornado para o usuário o tipo de erro no código e um breve comentário do que era esperado.

5 - Geração do Código Intermediário
Na geração do código intermediário é uma das fases mais importantes, já que ela é o ponto final do Front-End e o inicio do Back-End. Essa fase visa gerar uma única representação para representar nosso código, assim teríamos um padrão na geração do compilador e tornaria mais fácil mudar a arquitetura de um compilador, já que não precisamos iniciar todo o processo do 0 e sim só continuar da nossa arvore de RI.
A geração do código intermediário é a parte que mais sentimos que o livro não deixa claro como fazer. Para fazer esse modulo vimos que precisava de módulos a frente para a sua implementação e isso gerou mais duvidas para a equipe. O tempo gasto nesse modulo foi muito grande e de certa forma o não andamento nele gerou uma certa desmotivação já que parecia que os problemas não eram resolvidos. Acabou que esse modulo ficou incompleto assim como os módulos que eram envolvidos na implementação do mesmo.
