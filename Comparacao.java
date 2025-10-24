import java.util.Arrays;

public class Comparacao {
    public static void main(String[] args) {
        int[] vetor1= {12, 18, 9, 25, 17, 31, 22, 27, 16, 13, 19, 23, 20, 30, 14, 11, 15, 24, 26, 28};
        int[] vetor2 = {5, 7, 9, 10, 12, 14, 15, 17, 19, 21, 22, 23, 24, 25, 27, 28, 29, 30, 31, 32};
        int[] vetor3 = {99, 85, 73, 60, 50, 40, 35, 30, 25, 20, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6};

        testar("Vetor 1", vetor1);
        testar("Vetor 2", vetor2);
        testar("Vetor 3", vetor3);
    }

    private static void testar(String nome, int[] vetorOriginal) {
        System.out.println("\n=== " + nome + " ===");

        medir("Comb Sort", vetorOriginal, 1);
        medir("Gnome Sort", vetorOriginal, 2);
        medir("Bucket Sort", vetorOriginal, 3);
        medir("Bubble Sort (flag)", vetorOriginal, 4);
        medir("Selection Sort", vetorOriginal, 5);
        medir("Cocktail Sort", vetorOriginal, 6);
    }

    private static void medir(String nome, int[] vetorOriginal, int algoritmo) {
        int[] v = Arrays.copyOf(vetorOriginal, vetorOriginal.length);

        long inicio = System.nanoTime();
        switch (algoritmo) {
            case 1 -> OrdenacoesEstatisticas.combSort(v);
            case 2 -> OrdenacoesEstatisticas.gnomeSort(v);
            case 3 -> OrdenacoesEstatisticas.bucketSort(v);
            case 4 -> OrdenacoesEstatisticas.bubbleSort(v);
            case 5 -> OrdenacoesEstatisticas.selectionSort(v);
            case 6 -> OrdenacoesEstatisticas.cocktailSort(v);
        }
        long fim = System.nanoTime();

        double tempo = (fim - inicio) / 1_000_000.0;

        System.out.printf("%-20s | Tempo: %8.4f ms | Iterações: %-6d | Trocas: %-6d%n", nome, tempo, OrdenacoesEstatisticas.quantidadeDeIteracoes, OrdenacoesEstatisticas.quantidadeDeTrocas);
    }
}
