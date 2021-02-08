package com.poo.cadastrodealunos;

import java.io.*;
import java.util.Scanner;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private static String curDir = System.getProperty("user.dir") + "/tmp/cadastro.txt";

    static void cadastrar() throws IOException {
        Scanner ler = new Scanner(System.in);
        String nome = "", ra = "", dtNasc = "";

//        FileReader arqLido = new FileReader(curDir);
//        BufferedReader lerArq = new BufferedReader(arqLido);
//        String lista =  lerArq.lines().collect(Collectors.joining());
//
//        System.out.printf("%s\n", lista);

        System.out.printf("Digite o nome: ");
        nome = ler.nextLine();

        System.out.printf("Digite o RA: ");
        ra = ler.nextLine();

        System.out.printf("Digite a data de nascimento: ");
        dtNasc = ler.nextLine();

        FileWriter arq = new FileWriter(curDir);
        PrintWriter gravarArq = new PrintWriter(arq);

        gravarArq.printf("+--- Lista de alunos ---+\n");
        gravarArq.printf(nome + " - ");
        gravarArq.printf(ra + " - ");
        gravarArq.printf(dtNasc);

        arq.close();
    }

    static void ler() {
        try {
            FileReader arqLido = new FileReader(curDir);
            BufferedReader lerArq = new BufferedReader(arqLido);

            String linha = lerArq.readLine(); // lê a primeira linha
            // a variável "linha" recebe o valor "null" quando o processo
            // de repetição atingir o final do arquivo texto

            while (linha != null) {
                System.out.printf("%s\n", linha);

                linha = lerArq.readLine(); // lê da segunda até a última linha
            }

            arqLido.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
        }

        System.out.println();
    }

    static void editar() {
        // code to be executed
    }
    static void excluir() {
        // code to be executed
    }

    public static void main(String[] args) throws IOException {
        Scanner ler = new Scanner(System.in);
        int opcao = 0;

        while(opcao != 4) {
            System.out.printf("+--- Cadastro de alunos ---+\n");
            System.out.printf("(1) Cadastrar aluno \n");
            System.out.printf("(2) Editar aluno \n");
            System.out.printf("(3) Visualizar lista de alunos \n");
            System.out.printf("(4) Excluir aluno \n");
            System.out.printf("(5) Sair \n\n");
            System.out.printf("Selecione uma opcao: ");

            opcao = ler.nextInt();

            switch (opcao){
                case 1:
                    cadastrar();
                case 2:
                    editar();
                case 3:
                    ler();
                case 4:
                    excluir();
                default:
                    opcao = 5;
            }
        }

    }
}
