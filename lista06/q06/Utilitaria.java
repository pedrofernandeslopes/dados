package exercicios.lista06.q06;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.List;
import exercicios.lista06.q05.Pessoa;

public class Utilitaria {

    public static void main(String[] args) {
        // Caminho do arquivo gerado na questão anterior
        String inputFilePath = "C:\\projetos\\faculdade\\lp2\\src\\exercicios\\lista06\\q05\\nomescompletos.dat";

        // Lista para armazenar objetos Pessoa
        List<Pessoa> pessoas;

        // Ler os objetos Pessoa do arquivo
        try {
            pessoas = readPessoasFromFile(inputFilePath);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao ler os objetos do arquivo: " + e.getMessage());
            return;
        }

        // Calcular a idade média
        double mediaIdade = calcularMediaIdade(pessoas);

        // Exibir a idade média
        System.out.println("A idade média das pessoas é: " + mediaIdade);
    }

    // Método para ler objetos Pessoa de um arquivo
    @SuppressWarnings("unchecked")
    private static List<Pessoa> readPessoasFromFile(String filePath) throws IOException, ClassNotFoundException {
        try (FileInputStream fileIn = new FileInputStream(filePath);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            return (List<Pessoa>) objectIn.readObject();
        }
    }

    // Método para calcular a idade média
    private static double calcularMediaIdade(List<Pessoa> pessoas) {
        if (pessoas == null || pessoas.isEmpty()) {
            return 0;
        }

        int somaIdades = 0;
        for (Pessoa pessoa : pessoas) {
            somaIdades += pessoa.getIdade();
        }

        return (double) somaIdades / pessoas.size();
    }
}
