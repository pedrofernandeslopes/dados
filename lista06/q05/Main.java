package exercicios.lista06.q05;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        // Caminhos dos arquivos
        String firstNameFilePath = "C:\\projetos\\faculdade\\lp2\\src\\exercicios\\lista06\\q05\\nomes.txt";
        String lastNameFilePath = "C:\\projetos\\faculdade\\lp2\\src\\exercicios\\lista06\\q05\\sobrenomes.txt";
        String outputFilePath = "C:\\projetos\\faculdade\\lp2\\src\\exercicios\\lista06\\q05\\nomescompletos.dat";
        
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
        
        // Gerar a lista de pessoas
        List<Pessoa> pessoas = generatePessoas(firstNames, lastNames, quantidade);
        
        // Ordenar a lista de pessoas
        Collections.sort(pessoas);
        
        // Escrever a lista ordenada em um arquivo de texto
        try {
            writePessoasToFile(outputFilePath, pessoas);
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
    
    // Método para gerar objetos Pessoa
    private static List<Pessoa> generatePessoas(List<String> firstNames, List<String> lastNames, int quantidade) {
        List<Pessoa> pessoas = new ArrayList<>();
        Random random = new Random();
        
        for (int i = 0; i < quantidade; i++) {
            String firstName = firstNames.get(random.nextInt(firstNames.size()));
            String lastName = lastNames.get(random.nextInt(lastNames.size()));
            int age = random.nextInt(100); // Gera uma idade entre 0 e 99
            
            Pessoa pessoa = new Pessoa(firstName, lastName, age);
            pessoas.add(pessoa);
        }
        
        return pessoas;
    }
    
    // Método para escrever objetos Pessoa em um arquivo
    private static void writePessoasToFile(String filePath, List<Pessoa> pessoas) throws IOException {
        try (FileOutputStream fileOut = new FileOutputStream(filePath);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(pessoas);
        }
    }
}

