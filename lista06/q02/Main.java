package exercicios.lista06.q02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String filePath = "C:\\projetos\\faculdade\\lp2\\src\\exercicios\\lista06\\q02\\file.txt";

        Scanner scanner = new Scanner(System.in);

        int quantidade = 0;

        while (true) {
            System.out.print("Digite a quantidade de números a serem extraídos do arquivo: ");
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

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            int sum = 0;
            int count = 0;

            while ((line = reader.readLine()) != null && count < quantidade) {
                try {
                    int number = Integer.parseInt(line.trim());
                    sum += number;
                    count++;
                } catch (NumberFormatException e) {
                    System.out.println("Linha inválida no arquivo: " + line);
                }
            }

            reader.close();

            if (count < quantidade) {
                System.out.println("A quantidade de números no arquivo é inferior à quantidade solicitada.");
            } else {
                double media = (double) sum / quantidade;
                System.out.println("A média dos primeiros " + quantidade + " números é: " + media);
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}


