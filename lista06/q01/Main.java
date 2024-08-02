package exercicios.lista06.q01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        // Caminho do arquivo diretamente no código
        String filePath = "C:\\projetos\\faculdade\\lp2\\src\\exercicios\\lista06\\q01\\file.txt";
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            int sum = 0;
            int count = 0;

            while ((line = reader.readLine()) != null) {
                try {
                    int number = Integer.parseInt(line.trim());
                    sum += number;
                    count++;
                } catch (NumberFormatException e) {
                    System.out.println("Linha inválida no arquivo: " + line);
                }
            }

            reader.close();

            if (count == 0) {
                System.out.println("O arquivo não contém números válidos.");
            } else {
                double media = (double) sum / count;
                System.out.println("A média dos números é: " + media);
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}




