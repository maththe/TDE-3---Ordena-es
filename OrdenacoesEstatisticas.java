public class OrdenacoesEstatisticas {

    public static int quantidadeDeTrocas;
    public static int quantidadeDeIteracoes;

    private static void trocar(int[] vetor, int indiceA, int indiceB) {
        int temporario = vetor[indiceA];
        vetor[indiceA] = vetor[indiceB];
        vetor[indiceB] = temporario;
        quantidadeDeTrocas++;
    }

    // COMB SORT
    public static void combSort(int[] vetor) {
        quantidadeDeTrocas = 0;
        quantidadeDeIteracoes = 0;

        int tamanho = vetor.length;
        int intervalo = tamanho;
        boolean houveTroca = true;

        while (intervalo > 1 || houveTroca) {
            intervalo = (int) (intervalo / 1.3);
            if (intervalo < 1) intervalo = 1;
            houveTroca = false;

            for (int i = 0; i + intervalo < tamanho; i++) {
                quantidadeDeIteracoes++;
                if (vetor[i] > vetor[i + intervalo]) {
                    trocar(vetor, i, i + intervalo);
                    houveTroca = true;
                }
            }
        }
    }

    // GNOME SORT
    public static void gnomeSort(int[] vetor) {
        quantidadeDeTrocas = 0;
        quantidadeDeIteracoes = 0;

        int indice = 0;
        int tamanho = vetor.length;

        while (indice < tamanho) {
            quantidadeDeIteracoes++;
            if (indice == 0 || vetor[indice] >= vetor[indice - 1]) {
                indice++;
            } else {
                trocar(vetor, indice, indice - 1);
                indice--;
            }
        }
    }

    // BUCKET SORT
    public static void bucketSort(int[] vetor) {
        quantidadeDeTrocas = 0;
        quantidadeDeIteracoes = 0;

        int tamanho = vetor.length;
        if (tamanho <= 1) return;

        int valorMaximo = vetor[0];
        for (int i = 1; i < tamanho; i++) {
            if (vetor[i] > valorMaximo) valorMaximo = vetor[i];
        }
        if (valorMaximo == 0) return;

        int quantidadeDeBaldes = (int) Math.sqrt(tamanho);
        if (quantidadeDeBaldes < 1) quantidadeDeBaldes = 1;

        int[][] baldes = new int[quantidadeDeBaldes][tamanho];
        int[] quantidadeEmCadaBalde = new int[quantidadeDeBaldes];

        for (int i = 0; i < tamanho; i++) {
            quantidadeDeIteracoes++;
            int indiceDoBalde = (int) ((long) vetor[i] * (quantidadeDeBaldes - 1) / valorMaximo);
            baldes[indiceDoBalde][quantidadeEmCadaBalde[indiceDoBalde]++] = vetor[i];
        }

        int posicaoFinal = 0;
        for (int indiceBalde = 0; indiceBalde < quantidadeDeBaldes; indiceBalde++) {
            ordenarBaldePorInsercao(baldes[indiceBalde], quantidadeEmCadaBalde[indiceBalde]);
            for (int j = 0; j < quantidadeEmCadaBalde[indiceBalde]; j++) {
                vetor[posicaoFinal++] = baldes[indiceBalde][j];
            }
        }
    }

    private static void ordenarBaldePorInsercao(int[] vetor, int tamanho) {
        for (int i = 1; i < tamanho; i++) {
            int chave = vetor[i];
            int j = i - 1;
            while (j >= 0 && vetor[j] > chave) {
                vetor[j + 1] = vetor[j];
                j--;
                quantidadeDeTrocas++;
            }
            vetor[j + 1] = chave;
        }
    }

    // BUBBLE SORT 
    public static void bubbleSort(int[] vetor) {
        quantidadeDeTrocas = 0;
        quantidadeDeIteracoes = 0;

        int tamanho = vetor.length;
        boolean houveTroca;

        do {
            houveTroca = false;
            for (int i = 1; i < tamanho; i++) {
                quantidadeDeIteracoes++;
                if (vetor[i - 1] > vetor[i]) {
                    trocar(vetor, i - 1, i);
                    houveTroca = true;
                }
            }
            tamanho--;
        } while (houveTroca);
    }

    // SELECTION SORT 
    public static void selectionSort(int[] vetor) {
        quantidadeDeTrocas = 0;
        quantidadeDeIteracoes = 0;

        int tamanho = vetor.length;

        for (int i = 0; i < tamanho - 1; i++) {
            int indiceMinimo = i;
            for (int j = i + 1; j < tamanho; j++) {
                quantidadeDeIteracoes++;
                if (vetor[j] < vetor[indiceMinimo]) {
                    indiceMinimo = j;
                }
            }
            if (indiceMinimo != i) {
                trocar(vetor, i, indiceMinimo);
            }
        }
    }

    // COCKTAIL SORT 
    public static void cocktailSort(int[] vetor) {
        quantidadeDeTrocas = 0;
        quantidadeDeIteracoes = 0;

        int inicio = 0;
        int fim = vetor.length - 1;
        boolean houveTroca = true;

        while (houveTroca) {
            houveTroca = false;
            for (int i = inicio; i < fim; i++) {
                quantidadeDeIteracoes++;
                if (vetor[i] > vetor[i + 1]) {
                    trocar(vetor, i, i + 1);
                    houveTroca = true;
                }
            }
            if (!houveTroca) break;

            houveTroca = false;
            fim--;

            for (int i = fim; i > inicio; i--) {
                quantidadeDeIteracoes++;
                if (vetor[i - 1] > vetor[i]) {
                    trocar(vetor, i - 1, i);
                    houveTroca = true;
                }
            }
            inicio++;
        }
    }
}
