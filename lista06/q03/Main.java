package exercicios.lista06.q03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        // Caminhos dos arquivos
        String firstNameFilePath = "C:\\projetos\\faculdade\\lp2\\src\\exercicios\\lista06\\q03\\nomes.txt";
        String lastNameFilePath = "C:\\projetos\\faculdade\\lp2\\src\\exercicios\\lista06\\q03\\sobrenomes.txt";
        
        // Lista para armazenar nomes e sobrenomes
        List<String> firstNames = new ArrayList<>();
        List<String> lastNames = new ArrayList<>();
        
        // Ler os arquivos e preencher as listas
        try {
            readNamesFromFile(firstNameFilePath, firstNames);
            readNamesFromFile(lastNameFilePath, lastNames);
        } catch (IOException e) {
            System.out.println("Erro ao ler os arquivos: " + e.getMessage());
            return;
        }
        
        // Solicitar a quantidade de pessoas
        Scanner scanner = new Scanner(System.in);
        int quantidade = 0;
        
        while (true) {
            System.out.print("Digite a quantidade de pessoas a serem geradas: ");
            try {
                quantidade = scanner.nextInt();
                if (quantidade <= 0) {
                    System.out.println("A quantidade deve ser um número inteiro positivo. Tente novamente.");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                scanner.next();
            }
        }
        
        scanner.close();
        
        // Gerar a lista de nomes completos com idades
        List<String> fullNamesWithAges = generateFullNamesWithAges(firstNames, lastNames, quantidade);
        
        // Exibir a lista gerada
        for (String fullNameWithAge : fullNamesWithAges) {
            System.out.println(fullNameWithAge);
        }
    }
    
    // Método para ler nomes de um arquivo e armazená-los em uma lista
    private static void readNamesFromFile(String filePath, List<String> names) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        
        while ((line = reader.readLine()) != null) {
            names.add(line.trim());
        }
        
        reader.close();
    }
    
    // Método para gerar nomes completos com idades
    private static List<String> generateFullNamesWithAges(List<String> firstNames, List<String> lastNames, int quantidade) {
        List<String> fullNamesWithAges = new ArrayList<>();
        Random random = new Random();
        
        for (int i = 0; i < quantidade; i++) {
            String firstName = firstNames.get(random.nextInt(firstNames.size()));
            String lastName = lastNames.get(random.nextInt(lastNames.size()));
            int age = random.nextInt(100); // Gera uma idade entre 0 e 99
            
            String fullNameWithAge = firstName + " " + lastName + ", " + age + " anos";
            fullNamesWithAges.add(fullNameWithAge);
        }
        
        return fullNamesWithAges;
    }
}

