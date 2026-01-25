import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        
        //genericsList();

        //genericsMap();

        //genericsSet();
        
    }

    public static void genericsList() {
        // Exemplo sem Generics
		List listaSemGenerics = new ArrayList();
		listaSemGenerics.add("Elemento 1");
		listaSemGenerics.add(10); // Permite adicionar qualquer tipo de objeto

		// Exemplo com Generics
		List<String> listaGenerics = new ArrayList<>();
		listaGenerics.add("Elemento 1");
		listaGenerics.add("Elemento 2");

		// Iterando sobre a lista com Generics
		for (String elemento : listaGenerics) {
			System.out.println(elemento);
		}

		// Iterando sobre a lista sem Generics (necessário fazer cast)
		for (Object elemento : listaSemGenerics) {
			String str = elemento.toString(); //cast feito via toString pois ocorria erro de compilação usando parsing
			System.out.println(str);
		}
    }

     public static void genericsMap() {
        // Exemplo sem Generics
		Map mapaSemGenerics = new HashMap();
		mapaSemGenerics.put("Chave 1", 10);
		mapaSemGenerics.put("Chave 2", "valor"); // Permite adicionar qualquer tipo de objeto

		// Exemplo com Generics
		Map<String, Integer> mapaGenerics = new HashMap<>();
		mapaGenerics.put("Chave 1", 10);
		mapaGenerics.put("Chave 2", 20);

		// Iterando sobre o mapa com Generics
		for (Map.Entry<String, Integer> entry : mapaGenerics.entrySet()) {
			String chave = entry.getKey();
			int valor = entry.getValue();
			System.out.println("Chave: " + chave + ", Valor: " + valor);
		}

		// Iterando sobre o mapa sem Generics (necessário fazer cast)
		for (Object obj : mapaSemGenerics.entrySet()) {
			Map.Entry entry = (Map.Entry) obj;
			String chave = entry.getKey().toString();
			Object valor = entry.getValue();
			System.out.println("Chave: " + chave + ", Valor: " + valor);
		}
    }

     public static void genericsSet() {
        // Exemplo sem Generics
		Set conjuntoSemGenerics = new HashSet();
		conjuntoSemGenerics.add("Elemento 1");
		conjuntoSemGenerics.add(10); // Permite adicionar qualquer tipo de objeto

		// Exemplo com Generics
		Set<String> conjuntoGenerics = new HashSet<>();
		conjuntoGenerics.add("Elemento 1");
		conjuntoGenerics.add("Elemento 2");

		// Iterando sobre o conjunto com Generics
		for (String elemento : conjuntoGenerics) {
			System.out.println(elemento);
		}

		// Iterando sobre o conjunto sem Generics (necessário fazer cast)
		for (Object elemento : conjuntoSemGenerics) {
			String str = elemento.toString();
			System.out.println(str);
		}
    }
}
