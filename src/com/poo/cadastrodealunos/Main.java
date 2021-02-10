package com.poo.cadastrodealunos;

import jdk.jfr.Period;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    private static String curDir = System.getProperty("user.dir") + "/tmp/cadastro.txt";

    static void cadastrar() throws IOException, ParseException {
        Scanner ler = new Scanner(System.in);
        String nome = "", ra = "", dtNasc = "", idade = "";
        SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy");

        ArrayList<String> oldArq = new ArrayList();

        try {
            FileReader arqLido = new FileReader(curDir);
            BufferedReader lerArq = new BufferedReader(arqLido);

            String linha = lerArq.readLine();

            while (linha != null) {
                oldArq.add(linha);
                linha = lerArq.readLine();
            }

        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
        }

        FileWriter arq = new FileWriter(curDir);
        PrintWriter gravarArq = new PrintWriter(arq);

        for (int i=0; i< oldArq.size(); i++) {
            if(oldArq.get(i) != null) {
                gravarArq.printf("%s\n", oldArq.get(i));
            }
        }

        System.out.printf("Digite o nome: ");
        nome = ler.nextLine();

        System.out.printf("Digite o RA: ");
        ra = ler.nextLine();

        System.out.printf("Digite a data de nascimento: ");
        dtNasc = ler.nextLine();

        Date dt = new Date();
        Date dataDe = formato.parse(dtNasc);
        Date dataAte = formato.parse(formato.format(dt));

        long anos = ((dataAte.getTime() - dataDe.getTime()) / (1000*60*60*24) / 30) / 12;
        idade = Long.toString(anos);

        gravarArq.printf("RA: " + ra + " | ");
        gravarArq.printf("Nome: " + nome + " | ");
        gravarArq.printf("Data de nascimento: " + dtNasc + " | ");
        gravarArq.printf("Idade: " + idade);

        oldArq.add(ra + " - " + nome + " - " + dtNasc);

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
        //Instantiating the File class
        String filePath = "D://input.txt";
        //Instantiating the Scanner class to read the file
        Scanner sc = new Scanner(new File(filePath));
        //instantiating the StringBuffer class
        StringBuffer buffer = new StringBuffer();

        //Reading lines of the file and appending them to StringBuffer
        while (sc.hasNextLine()) {
            buffer.append(sc.nextLine()+System.lineSeparator());
        }

        String fileContents = buffer.toString();
        System.out.println("Contents of the file: "+fileContents);

        //closing the Scanner object
        sc.close();

        String oldLine = "No preconditions and no impediments. Simply Easy Learning!";
        String newLine = "Enjoy the free content";
        //Replacing the old line with new line
        fileContents = fileContents.replaceAll(oldLine, newLine);
        //instantiating the FileWriter class
        FileWriter writer = new FileWriter(filePath);
        System.out.println("");
        System.out.println("new data: "+fileContents);
        writer.append(fileContents);
        writer.flush();
    }
    static void excluir() {
        // code to be executed
    }

    public static void main(String[] args) throws IOException, ParseException {
        Scanner ler = new Scanner(System.in);
        int opcao = 0;

        while(opcao != 5) {
            System.out.printf("\n\n+--- Cadastro de alunos ---+\n");
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
                    break;
                case 2:
                    editar();
                    break;
                case 3:
                    ler();
                    break;
                case 4:
                    excluir();
                    break;
                default:
                    opcao = 5;
            }
        }

    }
}
