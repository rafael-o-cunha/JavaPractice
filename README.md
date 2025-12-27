
## Recursos usados

### CommandLineRunner


## anotations usadas no projeto de prática de injeção de dependência com springboot

### @Component
    Registra uma classe como componente que será gerenciado pelo framework.


### @Service
    Registra uma classe como componente que será gerenciado pelo framework.
    a diff entre ela e o Component é que ela possui semântica, ou seja, o framework entende como component normalmente, 
    e o desenvolvedor tem clareza do papel da classe(ajuda quando não há no pacote ou no nome da classe o termo "service")


### @Autowired
    No sprint há duas formas simples de fazer a injeção.
        -> com o construtor na classe, ele irá reconhecer e irá realizar a instância.
        -> com esta annotation @autowired...

    se o atributo é declarado, é anotado como Component/Service, e é anotado com autowired, automaticamente o springboot identifica que poderá ser injetado e resolve.

    O framework faz reúso de instância para otimização de memória através do padrão de projeto singleton, ou seja,
    quando um objeto é anotado em uma classe como autowired mas também é anotado em outra classe, ele identificará que poderá usar o mesmo
    objeto instanciado.

    Com o autowired o construtor pode ser omitido, bastando anotar os atributos que o construtor receberia por parâmetro