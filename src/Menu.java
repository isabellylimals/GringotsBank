import java.util.Scanner;

public class Menu {

    public void menu() {
        Scanner sc = new Scanner(System.in);
        BancoGringotes banco= new BancoGringotes();
        String escolha;

        do {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("=======================================");
            System.out.println("===== Bem-vindo ao Sistema do Banco Gringotes =====");
            System.out.println("=======================================");
            System.out.println("[1] Adicionar cofre");
            System.out.println("[2] Listar cofres");
            System.out.println("[3] Buscar cofre");
            System.out.println("[4] Realizar saque");
            System.out.println("[5] Realizar transação");
            System.out.println("[6] Realizar transação entre cofres");
            System.out.println("[7] Remover cofre");
            System.out.println("[8] Sair do sistema");
            System.out.println("=======================================");
            System.out.print("Escolha uma das opções: ");
            escolha = sc.nextLine();

            if (!escolha.matches("[1-8]")) {
                System.out.println("Opção inválida. Tente novamente.");
                continue;
            }

            switch (escolha) {
                case "1":
                    System.out.println("Adicionar cofre selecionado.");
                    System.out.print("Digite o nome do bruxo: ");
                    String nomebruxo = sc.nextLine();
                    System.out.print("Digite o número do cofre: ");
                    int numerocofre = sc.nextInt();
                    System.out.print("Digite o saldo inicial do cofre: ");
                    double saldo = sc.nextDouble();
                    sc.nextLine(); 

                    Cofre cofre = new Cofre(nomebruxo, numerocofre, saldo);
                    banco.Criarcofre(cofre);
                    break;
                case "2":
                    System.out.println("Listar cofres selecionado.");
                    break;
                case "3":
                    System.out.println("Buscar cofre selecionado.");
                    break;
                case "4":
                    System.out.println("Realizar saque selecionado.");
                    break;
                case "5":
                    System.out.println("Realizar transação selecionado.");
                    break;
                case "6":
                    System.out.println("Realizar transação entre cofres selecionado.");
                    break;
                case "7":
                    System.out.println("Remover cofre selecionado.");
                    break;
                case "8":
                    System.out.println("Saindo do sistema...");
                    break;
            }
        } while (!escolha.equals("8"));

        sc.close();
    }}



