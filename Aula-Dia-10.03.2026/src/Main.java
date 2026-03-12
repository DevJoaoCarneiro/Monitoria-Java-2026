import Model.Exercicio1.Eletronico;
import Model.Exercicio1.ItemLoja;
import Model.Exercicio1.Roupas;
import Model.Exercicio2.Aluno;
import Model.Exercicio3.Funcionario;
import Model.Exercicio4.Pedido;
import Model.Exercicio4.PedidoDto;
import Model.Exercicio5.Produto;
import Model.Exercicio6.Cliente;
import Model.Exercicio8.Pessoa;
import Model.Exercicio9.ProdutoEx9;
import Model.Exercicioo10.Vendedor;
import Model.Exercicioo11.PedidoEx11;
import Model.Exercicioo11.Status;
import Model.Exercicioo12.FuncionarioEx12;
import Model.Exercicioo13.Livro;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<ItemLoja> itens = new ArrayList<>();

        itens.add(new Eletronico(1, "Notebook Dell", 4500.00, 2.5));
        itens.add(new Eletronico(2, "Smartphone Samsung", 3200.00, 0.4));
        itens.add(new Eletronico(3, "Tablet Lenovo", 1800.00, 0.6));
        itens.add(new Eletronico(4, "Monitor LG 27", 1200.00, 4.2));
        itens.add(new Eletronico(5, "Headset Gamer", 350.00, 0.5));

        itens.add(new Roupas(6, "Camiseta Básica", 59.90, "Algodão"));
        itens.add(new Roupas(7, "Calça Jeans", 149.90, "Jeans"));
        itens.add(new Roupas(8, "Jaqueta", 299.90, "Couro Sintético"));
        itens.add(new Roupas(9, "Moletom", 189.90, "Moletom"));
        itens.add(new Roupas(10, "Camisa Social", 129.90, "Poliéster"));

        List<String> produtosAcimaDe100Reais = itens
                .stream()
                .filter(x -> x.getPreco() > 1000)
                .map(item -> item.getNome())
                .collect(Collectors.toList());

        System.out.println(produtosAcimaDe100Reais);

        Map<Integer, ItemLoja> mapaProdutos = itens
                .stream()
                .collect(Collectors.toMap(
                        ItemLoja::getId,
                        item -> item
                ));

        mapaProdutos.forEach((id, produto) ->
                System.out.println(id + " - " + produto.getNome())
        );

        //Exercicio 2
        List<Aluno> listaAlunos = new ArrayList<>();
        listaAlunos.add(new Aluno("Ana Silva", 8.5, 20));
        listaAlunos.add(new Aluno("Bruno Souza", 7.0, 22));
        listaAlunos.add(new Aluno("Carla Dias", 9.2, 19));
        listaAlunos.add(new Aluno("Diego Ramos", 6.5, 21));
        listaAlunos.add(new Aluno("Elena Martins", 10.0, 20));
        listaAlunos.add(new Aluno("Fabio Lima", 5.8, 23));
        listaAlunos.add(new Aluno("Giovanna Rock", 8.8, 20));
        listaAlunos.add(new Aluno("Henrique Vaz", 7.5, 24));
        listaAlunos.add(new Aluno("Isabela Rios", 9.5, 19));
        listaAlunos.add(new Aluno("João Castro", 4.5, 22));

        List<Aluno> alunosAprovados = listaAlunos
                .stream()
                .filter(x -> x.getNota() > 7.0)
                .sorted(Comparator.comparing(Aluno::getNota).reversed())
                .collect(Collectors.toList());

        alunosAprovados.forEach(x -> System.out.println(x.getNome() + " - Nota: " + x.getNota()));

        //Exercicio 3
        List<Funcionario> listaFuncionarios = List.of(
                new Funcionario("João", 28, "Desenvolvedor", 5000),
                new Funcionario("Maria", 32, "Analista", 4500),
                new Funcionario("Pedro", 40, "Gerente", 8000),
                new Funcionario("Ana", 25, "Desenvolvedor", 5200),
                new Funcionario("Carlos", 38, "Analista", 4700),
                new Funcionario("Fernanda", 29, "Designer", 4200),
                new Funcionario("Lucas", 35, "Desenvolvedor", 6100),
                new Funcionario("Juliana", 31, "RH", 3900),
                new Funcionario("Rafael", 45, "Diretor", 12000),
                new Funcionario("Camila", 27, "Designer", 4300)
        );

        Map<String, List<Funcionario>> agruparFuncionario = listaFuncionarios
                .stream()
                .collect(Collectors.groupingBy(Funcionario::getCargo));

        agruparFuncionario.forEach((cargo, lista) -> {
            System.out.println("Cargo: " + cargo);

            lista.forEach(funcionario ->
                    System.out.println(" - " + funcionario.getNome())
            );
        });

        List<String> nomeFuncionarioOrdenadas = listaFuncionarios
                .stream()
                .sorted(Comparator.comparing(x -> x.getNome()))
                .map(Funcionario::getNome)
                .collect(Collectors.toList());

        System.out.println(nomeFuncionarioOrdenadas);

        Map<String, Double> mediaSalarialPorCargo = listaFuncionarios
                .stream()
                .collect(Collectors.groupingBy(
                        Funcionario::getCargo,
                        Collectors.averagingDouble(Funcionario::getSalario)));

        mediaSalarialPorCargo.forEach((cargo, salario)->{
            System.out.println("=========================");
            System.out.println("Cargo..."+cargo);
            System.out.println("Salario.."+salario);
        });

        //-------------------------------------------------------------------------------//
        List<Pedido> listaPedidos = List.of(
                new Pedido(1, "João", 150.50),
                new Pedido(2, "Maria", 320.00),
                new Pedido(3, "Pedro", 89.90),
                new Pedido(4, "Ana", 450.75),
                new Pedido(5, "Carlos", 210.40),
                new Pedido(6, "Fernanda", 99.99),
                new Pedido(7, "Lucas", 560.00),
                new Pedido(8, "Juliana", 120.00),
                new Pedido(9, "Rafael", 780.25),
                new Pedido(10, "Camila", 305.60)
        );

        List<PedidoDto> listaPedidosDto = listaPedidos
                .stream()
                .map(x -> new PedidoDto(x.getId(), x.getValorTotal()))
                .collect(Collectors.toList());

        System.out.println(listaPedidosDto);
        //------------------------------------------------------------------------------//
        List<Produto> listaProdutos = new ArrayList<>();

        listaProdutos.add(new Produto("Notebook", 3500.00));
        listaProdutos.add(new Produto("Mouse", 80.00));
        listaProdutos.add(new Produto("Teclado", 150.00));
        listaProdutos.add(new Produto("Monitor", 900.00));
        listaProdutos.add(new Produto("Celular", 2200.00));
        listaProdutos.add(new Produto("Headset", 250.00));
        listaProdutos.add(new Produto("Webcam", 180.00));
        listaProdutos.add(new Produto("Impressora", 700.00));
        listaProdutos.add(new Produto("SSD 1TB", 450.00));
        listaProdutos.add(new Produto("Cadeira Gamer", 1200.00));

        List<Double> precoProdutos = listaProdutos
                .stream()
                .map(Produto::getPreco)
                .collect(Collectors.toList());

        System.out.println(precoProdutos);

        double precoSomado = listaProdutos
                .stream()
                .collect(Collectors.summingDouble(Produto::getPreco));

        double mediaPreco = listaProdutos
                .stream()
                .collect(Collectors.averagingDouble(Produto::getPreco));

        System.out.println("O preco somado..."+precoSomado+"  E a media.."+mediaPreco);

        //------------------------------------------------------------------------------//
        List<Cliente> listaClientes = new ArrayList<>();

        listaClientes.add(new Cliente("João", 22));
        listaClientes.add(new Cliente("Maria", 30));
        listaClientes.add(new Cliente("Pedro", 19));
        listaClientes.add(new Cliente("Ana", 27));
        listaClientes.add(new Cliente("Carlos", 35));
        listaClientes.add(new Cliente("Fernanda", 24));
        listaClientes.add(new Cliente("Lucas", 18));
        listaClientes.add(new Cliente("Juliana", 40));
        listaClientes.add(new Cliente("Ricardo", 28));
        listaClientes.add(new Cliente("Patricia", 33));

        Map<String, Integer> listaMaioresDeIdade = listaClientes
                .stream()
                .sorted(Comparator.comparing(Cliente::getIdade))
                .collect(Collectors.toMap(
                        Cliente::getNome,
                        Cliente::getIdade,
                        (a , b) -> a,
                        LinkedHashMap::new
                ));

        listaMaioresDeIdade.forEach((nome, idade) -> {
            System.out.println("-----------------------");
            System.out.println("Nome..."+nome);
            System.out.println("Idade.."+idade);
        });


         long numeroRegistrosComMaisDe30 = listaClientes
                .stream()
                .filter(x -> x.getIdade() > 30)
                .count();

        System.out.println("Clientes com mais de 30 anos..."+numeroRegistrosComMaisDe30);

        List<String> listaDeNomes = listaClientes
                .stream()
                .map(Cliente::getNome)
                .collect(Collectors.toList());

        System.out.println(listaDeNomes);
        //-------------------------------------------------------------//

        Optional<Produto> produtoMaisCaro = listaProdutos
                .stream()
                .collect(Collectors.maxBy(
                        Comparator.comparing(Produto::getPreco)
                ));


        produtoMaisCaro.ifPresent(x -> System.out.println("Produto mais caro..:"+x.getNome()));

        Optional<Produto> produtoMaisBarato = listaProdutos
                .stream()
                .collect(Collectors.minBy(
                        Comparator.comparing(Produto::getPreco)
                ));

        produtoMaisBarato.ifPresent(x -> System.out.println("Produto mais barato..:"+x.getNome()));

        //----------------------------------------------------------------------------------------//
        List<Pessoa> listaPessoas = new ArrayList<>();

        listaPessoas.add(new Pessoa("João", 22));
        listaPessoas.add(new Pessoa("Maria", 30));
        listaPessoas.add(new Pessoa("Pedro", 19));
        listaPessoas.add(new Pessoa("Ana", 27));
        listaPessoas.add(new Pessoa("Carlos", 35));

        List<String> descricoes = listaPessoas
                .stream()
                .map(Pessoa::getDescricao)
                .collect(Collectors.toList());

        System.out.println(descricoes);

        String descricoesConcat = listaPessoas
                .stream()
                .map(Pessoa::getDescricao)
                .collect(Collectors.joining("---"));

        System.out.println(descricoesConcat);

        //------------------------------------------------------------------------------------//

        List<ProdutoEx9> listaProdutosMap = new ArrayList<>();

        listaProdutosMap.add(new ProdutoEx9(1, "Notebook"));
        listaProdutosMap.add(new ProdutoEx9(2, "Mouse"));
        listaProdutosMap.add(new ProdutoEx9(3, "Teclado"));
        listaProdutosMap.add(new ProdutoEx9(4, "Monitor"));
        listaProdutosMap.add(new ProdutoEx9(5, "Celular"));
        listaProdutosMap.add(new ProdutoEx9(6, "Headset"));
        listaProdutosMap.add(new ProdutoEx9(7, "Webcam"));
        listaProdutosMap.add(new ProdutoEx9(8, "Impressora"));
        listaProdutosMap.add(new ProdutoEx9(9, "SSD 1TB"));
        listaProdutosMap.add(new ProdutoEx9(10, "Cadeira Gamer"));

        Map<Integer, ProdutoEx9> listaProdutoComMap = listaProdutosMap
                .stream()
                .collect(Collectors.toMap(
                        ProdutoEx9::getId,
                        produto -> produto
                ));

        listaProdutoComMap.forEach((id, produto) -> {
            System.out.println("ID: " + id + " | Nome: " + produto.getNome());
        });

        //----------------------------------------------------------------//
        List<Vendedor> listaVendedores = new ArrayList<>();

        listaVendedores.add(new Vendedor("Ana Silva", 15500.50));
        listaVendedores.add(new Vendedor("Bruno Costa", 8200.00));
        listaVendedores.add(new Vendedor("Carla Souza", 12300.75));
        listaVendedores.add(new Vendedor("Diego Oliveira", 5400.20));
        listaVendedores.add(new Vendedor("Elena Martins", 21000.00));
        listaVendedores.add(new Vendedor("Fabio Santos", 9800.30));
        listaVendedores.add(new Vendedor("Gisele Lima", 17250.45));
        listaVendedores.add(new Vendedor("Hugo Ferreira", 3100.00));
        listaVendedores.add(new Vendedor("Iara Rocha", 11000.60));
        listaVendedores.add(new Vendedor("João Pedro", 6700.80));

        List<String> vendedoresQueVenderamMaisQue10Mil = listaVendedores
                .stream()
                .filter(x -> x.getTotalVendas() > 10000)
                .map(Vendedor::getNome)
                .collect(Collectors.toList());

        System.out.println(vendedoresQueVenderamMaisQue10Mil);

        //------------------------------------------------------------------//
        List<PedidoEx11> listaPedidosEx9 = new ArrayList<>();

        // Adicionando 10 pedidos com diferentes status
        listaPedidosEx9.add(new PedidoEx11(101, Status.PAGO));
        listaPedidosEx9.add(new PedidoEx11(102, Status.PENDENTE));
        listaPedidosEx9.add(new PedidoEx11(103, Status.CANCELADO));
        listaPedidosEx9.add(new PedidoEx11(104, Status.PAGO));
        listaPedidosEx9.add(new PedidoEx11(105, Status.PENDENTE));
        listaPedidosEx9.add(new PedidoEx11(106, Status.PAGO));
        listaPedidosEx9.add(new PedidoEx11(107, Status.CANCELADO));
        listaPedidosEx9.add(new PedidoEx11(108, Status.PENDENTE));
        listaPedidosEx9.add(new PedidoEx11(109, Status.PAGO));
        listaPedidosEx9.add(new PedidoEx11(110, Status.PAGO));

        List<PedidoEx11> listaPedidoPagos = listaPedidosEx9
                .stream()
                .filter(x -> x.getStatus() == Status.PAGO)
                .collect(Collectors.toList());

        listaPedidoPagos.forEach((pedidoEx11 -> {
            System.out.println("Pedido..."+pedidoEx11.getId()+" Status.."+pedidoEx11.getStatus());
        }));

        //------------------------------------------------------------------------------------//
        List<FuncionarioEx12> funcionarios = new ArrayList<>();

        // Adicionando 10 funcionários
        funcionarios.add(new FuncionarioEx12("Alice Rocha", 5500.00, "TI"));
        funcionarios.add(new FuncionarioEx12("Beto Oliveira", 4200.50, "Vendas"));
        funcionarios.add(new FuncionarioEx12("Carla Mendes", 7800.00, "Financeiro"));
        funcionarios.add(new FuncionarioEx12("Daniel Silva", 3900.00, "TI"));
        funcionarios.add(new FuncionarioEx12("Eduarda Lima", 6100.20, "RH"));
        funcionarios.add(new FuncionarioEx12("Fernando Vaz", 4500.00, "Vendas"));
        funcionarios.add(new FuncionarioEx12("Giovana Kim", 9200.00, "Diretoria"));
        funcionarios.add(new FuncionarioEx12("Henrique Paz", 3200.00, "Logística"));
        funcionarios.add(new FuncionarioEx12("Irene Santos", 5100.75, "TI"));
        funcionarios.add(new FuncionarioEx12("Jonas Souza", 4800.00, "RH"));

        Map<String, List<String>> listaDeFuncionariosDeTi = funcionarios
                .stream()
                .filter(x -> x.getDepartamento().equals("TI"))
                .collect(Collectors.groupingBy(
                        FuncionarioEx12::getDepartamento,
                        Collectors.mapping(FuncionarioEx12::getNome, Collectors.toList())
                ));

        listaDeFuncionariosDeTi.forEach((cargo, nome) -> {
            System.out.println("Cargo..."+cargo+" Nome..."+nome);
        });

        funcionarios
                .stream()
                .map(x -> new FuncionarioEx12(x.getNome(), x.getSalario() * 1.1, x.getDepartamento()))
                .forEach(f -> System.out.println("Departamento..:"+ f.getDepartamento()+ " | Nome: " + f.getNome()));

        Map<String, Double> totalSalarios = funcionarios
                .stream()
                .collect(Collectors.groupingBy(FuncionarioEx12::getDepartamento, Collectors.summingDouble(FuncionarioEx12::getSalario)));

        totalSalarios.forEach((nome, salario) -> {
            System.out.println("Nome.."+nome+ "  Salario.."+salario);
        });
        //-------------------------------------------------------------------------------------------//
        List<Livro> biblioteca = new ArrayList<>();

        biblioteca.add(new Livro("O Alquimista", "Paulo Coelho", 45.90));
        biblioteca.add(new Livro("Dom Casmurro", "Machado de Assis", 32.00));
        biblioteca.add(new Livro("1984", "George Orwell", 39.90));
        biblioteca.add(new Livro("A Hora da Estrela", "Clarice Lispector", 28.50));
        biblioteca.add(new Livro("O Hobbit", "J.R.R. Tolkien", 59.90));
        biblioteca.add(new Livro("Memórias Póstumas", "Machado de Assis", 35.00));
        biblioteca.add(new Livro("Sapiens", "Yuval Noah Harari", 65.00));
        biblioteca.add(new Livro("Ensaio sobre a Cegueira", "José Saramago", 54.20));
        biblioteca.add(new Livro("O Cortiço", "Aluísio Azevedo", 22.00));
        biblioteca.add(new Livro("Cem Anos de Solidão", "Gabriel García Márquez", 48.00));

        List<Livro> listaDeLivros = biblioteca
                .stream()
                .sorted(Comparator.comparing(Livro::getPreco).reversed())
                .collect(Collectors.toList());

        listaDeLivros.forEach(System.out::println);

    }
}