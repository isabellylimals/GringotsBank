import java.util.Scanner;

public class Menu {

    public void menu() {
        Scanner sc = new Scanner(System.in);
        BancoGringotes banco = new BancoGringotes();
        
        String escolha;

        do {
            System.out.flush();
            System.out.println("=======================================");
            System.out.println("Bem-vindo ao Sistema do Banco Gringotes");
            System.out.println("=======================================");
            System.out.println("[1] Adicionar cofre");
            System.out.println("[2] Listar cofres");
            System.out.println("[3] Buscar cofre");
            System.out.println("[4] Realizar saque");
            System.out.println("[5] Realizar deposito");
            System.out.println("[6] Realizar transação entre cofres");
            System.out.println("[7] Listar transações");
            System.out.println("[8] Remover cofre do sistema");
            System.out.println("[9] Sair do sistema");
            System.out.println("=======================================");
            System.out.print("Escolha uma das opções:\n ");
            escolha = sc.nextLine();

            if (!escolha.matches("[1-9]")) {
                System.out.println("Opção inválida. Tente novamente.");
                continue;
            }

            switch (escolha) {
                case "1":
                    System.out.println("Adicionar cofre selecionado.");
                    String nomebruxo;
                    do {
                        System.out.print("Digite o nome do bruxo: ");
                        nomebruxo = sc.nextLine();
                        if (!nomebruxo.matches("[a-zA-Z]+")) {
                            System.out.println("Nome inválido. Digite apenas letras.");
                        } else {
                            break;
                        }
                    } while (true);
                    int numerocofre;
                    do {
                        System.out.print("Digite o número do cofre: ");
                        numerocofre = sc.nextInt();
                        sc.nextLine(); 
                        if (banco.verificarNumero(numerocofre) == 1) {
                            System.out.println("Esse número de cofre já existe, insira outro.");
                        } else {
                            break; 
                        }
                    } while (true);
                    
                    double saldo;
                    do {
                        System.out.print("Digite o saldo inicial do cofre: ");
                        while (!sc.hasNextDouble()) {
                            System.out.println("Saldo inválido. Digite um número válido.");
                            sc.next(); 
                        }
                        saldo = sc.nextDouble();
                        sc.nextLine();
                        if (saldo < 0) {
                            System.out.println("Saldo não pode ser negativo. Tente novamente.");
                        } else {
                            break;
                        }
                    } while (true);

                    Cofre cofre = new Cofre(nomebruxo, numerocofre, saldo);
                    banco.Criarcofre(cofre);
                    break;
                case "2":
                    System.out.println("Listar cofres selecionado.");
                    banco.ListarCofres();
                    break;
                case "3":
                    System.out.println("Buscar cofre selecionado.");
                    System.out.print("Qual o numero do cofre que deseja buscar? ");
                    int num = sc.nextInt();
                    sc.nextLine(); // o erro era aqui
                    banco.buscarCofre(num);
                    System.out.println();
                    break;
                case "4":
                    System.out.println("Realizar saque selecionado.");
                    System.out.print("Digite o número do cofre: ");
                    numerocofre = sc.nextInt();
                    System.out.print("Digite o valor a ser sacado: ");
                    double valorSaque = sc.nextDouble();
                    sc.nextLine(); 

                    Cofre cofreSaque = banco.buscarCofre(numerocofre);
                    if (cofreSaque != null) {
                        if (cofreSaque.sacar(valorSaque)) {
                            System.out.println("Saque realizado com sucesso.");
                        } else {
                            System.out.println("Saldo insuficiente.");
                        }
                    } else {
                        System.out.println("Cofre não encontrado.");
                    }
                    break;
                case "5":
                    System.out.println("Realizar deposito selecionado.");
                    System.out.print("Digite o número do cofre: ");
                    numerocofre = sc.nextInt();
                    System.out.print("Digite o valor a ser depositado: ");
                    double valorDeposito = sc.nextDouble();
                    sc.nextLine(); 

                    Cofre cofreDeposito = banco.buscarCofre(numerocofre);
                    if (cofreDeposito != null) {
                        cofreDeposito.depositar(valorDeposito);
                        System.out.println("Depósito realizado com sucesso.");
                    } else {
                        System.out.println("Cofre não encontrado.");
                    }
                    break;
                case "6":
                    System.out.println("Realizar transação entre cofres selecionado.");
                    banco.Transferir();
                    break;
                case "7":
                    System.out.println("Listar transações selecionado.");
                    banco.listarTransacoes();
                    break;
                case "8":
                    System.out.println("Remover cofre selecionado.");
                    System.out.print("Digite o número do cofre que deseja remover: ");
                    int numRemover = sc.nextInt();
                    sc.nextLine(); // Consume newline
                    banco.removercofre(numRemover);
                    break;
                case "9":
                    System.out.println("Saindo do sistema...");
                    break;
            }
        } while (!escolha.equals("9"));

        sc.close();
    }
}



