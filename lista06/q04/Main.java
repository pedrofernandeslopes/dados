package exercicios.lista06.q04;

import java.io.BufferedReader;
import java.io.FileWriter;
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
        String firstNameFilePath = "C:\\projetos\\faculdade\\lp2\\src\\exercicios\\lista06\\q04\\nomes.txt";
        String lastNameFilePath = "C:\\projetos\\faculdade\\lp2\\src\\exercicios\\lista06\\q04\\sobrenomes.txt";
        String outputFilePath = "C:\\projetos\\faculdade\\lp2\\src\\exercicios\\lista06\\q04\\nomescompletos.txt";
        
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
        
        // Ordenar a lista de nomes completos
        insertionSort(fullNamesWithAges);
        
        // Escrever a lista ordenada em um arquivo de texto
        try {
            writeNamesToFile(outputFilePath, fullNamesWithAges);
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
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
            
            String fullNameWithAge = firstName + " " + lastName + ", " + age;
            fullNamesWithAges.add(fullNameWithAge);
        }
        
        return fullNamesWithAges;
    }
    
    // Método para ordenar a lista usando ordenação por inserção
    private static void insertionSort(List<String> names) {
        for (int i = 1; i < names.size(); i++) {
            String temp = names.get(i);
            int j = i - 1;
            while (j >= 0 && names.get(j).compareTo(temp) > 0) {
                names.set(j + 1, names.get(j));
                j--;
            }
            names.set(j + 1, temp);
        }
    }
    
    // Método para escrever nomes completos em um arquivo
    private static void writeNamesToFile(String filePath, List<String> names) throws IOException {
        FileWriter writer = new FileWriter(filePath);
        
        for (String name : names) {
            writer.write(name + System.lineSeparator());
        }
        
        writer.close();
    }
}
