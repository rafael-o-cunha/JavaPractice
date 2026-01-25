# Generics Type

- Um tipo genérico é uma classe genérica ou uma interface que é parametrizada em relação a tipos.

- O símbolo <> é chamado de "diamond" ou "diamond operator" foi um recurso introduzido no Java 7 e é usado no contexto de tipos genéricos em Java para inferir automaticamente o tipo com base no contexto.
    - Obs.: vem do C++

- Introduz a variável de tipo, T, que pode ser usada em qualquer lugar dentro de uma classe:

- Essa mesma técnica pode ser aplicada para criar interfaces genérica.

- Os nomes de parâmetros de tipo mais comumente usados são:

    E - Elemento (usado extensivamente pelo Java Collections Framework)
    K - Chave
    N - Número
    T - Tipo
    V - Valor
    S, U, V, etc. - 2º, 3º, 4º tipos

## Vantagens simples de usar generics nas interfaces Collection em Java:
- Segurança do tipo de dados;
- Código mais legível;
- Detecta erros mais cedo;
- Reutilização de código;
- Melhor desempenho;

## Referências:
[1] "Java Tutorials - Generics - Generic Types." Oracle. Disponível em: https://docs.oracle.com/javase/tutorial/java/generics/types.html.