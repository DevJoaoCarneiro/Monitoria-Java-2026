import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Produto> produtos=List.of(
                new Produto(1,"Notebook","Eletronico",3500),
                new Produto(2,"Mouse","Eletronico",80),
                new Produto(3,"Teclado","Eletronico",150),
                new Produto(4,"Camiseta","Roupa",60),
                new Produto(5,"Jaqueta","Roupa",250),
                new Produto(6,"Monitor","Eletronico",900),
                new Produto(7,"Calça","Roupa",120),
                new Produto(8,"Headset","Eletronico",300)
        );

        //-------------------------------------------------------------------//
        List<String> mapeamentoDeNomes = produtos
                .stream()
                .map(Produto::getNome)
                .collect(Collectors.toList());

        mapeamentoDeNomes.forEach(System.out::println);

        //----------------------------------------------------//
        List<Produto> produtosMaiorQue100 = produtos
                .stream()
                .filter(x -> x.getPreco() > 100)
                .collect(Collectors.toList());

        produtosMaiorQue100.forEach(System.out::println);

        //------------------------------------------------------//

        List<String> precoForMaiorQue100 = produtos
                .stream()
                .filter(x -> x.getPreco() > 100)
                .map(Produto::getNome)
                .collect(Collectors.toList());

        precoForMaiorQue100.forEach(System.out::println);

        //------------------------------------------------//
        List<Produto> listaOrdenada = produtos
                .stream()
                .sorted(Comparator.comparing(Produto::getNome).reversed())
                .collect(Collectors.toList());

        listaOrdenada.forEach(System.out::println);

        //--------------------------------------------------//

        long contagemDeRegistrosMaiorQue200 = produtos
                .stream()
                .filter(x -> x.getPreco() > 200)
                .count();

        System.out.println("Tem.."+contagemDeRegistrosMaiorQue200+" Registro maior que 200");

        //--------------------------------------------------//
        Map<String, List<Produto>> mapeamentoDeLista = produtos
                .stream()
                .collect(Collectors.groupingBy(
                        Produto::getCategoria
                ));

        mapeamentoDeLista.forEach((categoria, lista) -> {
            System.out.println("=================================");
            System.out.println("Categoria..."+categoria);
            System.out.println("Produto....:"+lista);
        });

        //------------------------------------------------------------//
        Map<String, Double> mediaPrecoPorCategoria = produtos
                .stream()
                .collect(Collectors.groupingBy(
                        Produto::getCategoria,
                        Collectors.averagingDouble(Produto::getPreco)
                ));

        mediaPrecoPorCategoria.forEach((categoria, media) -> {
            System.out.println("Categoria..:"+categoria);
            System.out.println("Media......:"+media);
        });
    }
}