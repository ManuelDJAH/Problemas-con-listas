import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static List<Integer> combinarListas(List<Integer> primeraLista, List<Integer> segundaLista) {
        List<Integer> listaFinal = new ArrayList<>();
        int indice1 = 0, indice2 = 0;

        while (indice1 < primeraLista.size() && indice2 < segundaLista.size()) {
            if (primeraLista.get(indice1) < segundaLista.get(indice2)) {
                listaFinal.add(primeraLista.get(indice1));
                indice1++;
            } else {
                listaFinal.add(segundaLista.get(indice2));
                indice2++;
            }
        }

        while (indice1 < primeraLista.size()) {
            listaFinal.add(primeraLista.get(indice1));
            indice1++;
        }

        while (indice2 < segundaLista.size()) {
            listaFinal.add(segundaLista.get(indice2));
            indice2++;
        }

        return listaFinal;
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Para que funcione el codigo, poner dos listas de números entre comillas y separados por comas");
            return;
        }

        List<Integer> primeraLista = procesarEntrada(args[0]);
        List<Integer> segundaLista = procesarEntrada(args[1]);

        List<Integer> listaFinalCombinada = combinarListas(primeraLista, segundaLista);

        System.out.println(listaFinalCombinada);
    }

    private static List<Integer> procesarEntrada(String entrada) {
        return Arrays.stream(entrada.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
    }
}
