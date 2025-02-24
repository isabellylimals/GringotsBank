
import java.util.ArrayList;
import java.util.Scanner;

class BancoGringotes{
    private ArrayList<Cofre> cofres= new ArrayList<>();
    public void Criarcofre(Cofre co){
        cofres.add(co);
        System.out.println("Cofre adicionado com sucesso!");
    }
    public void ListarCofres() {
        if (cofres.isEmpty()) {
            System.out.println("Não há nenhum cofre!");
        } else {
            for (Cofre cofre : cofres) {
                System.out.println("Nome do bruxo: " + cofre.nomebruxo + 
                                   ", \nNúmero do cofre: " + cofre.numerocofre + 
                                   ", \nSaldo disponível: " + String.format("%.2f", cofre.saldo));
            }
        }
    }
    public void listarTransacoes() {
        System.out.println("\nHistórico de Transações do Cofre ");
        for (Cofre cofre : cofres) {
            System.out.println("Transações do cofre " + cofre.numerocofre + ":");
            for (String transacao : cofre.historicoTransacoes) {
                System.out.println(transacao);
            }
        }
    }
    public Cofre buscarCofre(int numerobuscar) {
        for (Cofre cofre : cofres) {
            if (cofre.getNumeroCofre() == numerobuscar) {
                return cofre; 
            }
        }
        return null; 
    }

    
    public void Transferir() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Qual o valor da transferência:");
        double valor = sc.nextDouble();

        System.out.println("Insira o número do cofre de origem (saque):");
        int numeroOrigem = sc.nextInt();
        Cofre cofreOrigem = buscarCofre(numeroOrigem);

        System.out.println("Insira o número do cofre de destino (depósito):");
        int numeroDestino = sc.nextInt();
        Cofre cofreDestino = buscarCofre(numeroDestino);

       
        if (cofreOrigem == null || cofreDestino == null) {
            System.out.println("Um dos cofres não foi encontrado. Verifique os números informados.");
            return;
        }

    
        if (cofreOrigem.tranferirGaleoes(valor)) {
            cofreDestino.receberGaleoes(valor);
            System.out.println("Transferência realizada com sucesso!");
        } else {
            System.out.println("Transferência falhou. Saldo insuficiente no cofre de origem.");
        }
    }
    public int verificarNumero(int numero) {
        for (Cofre cofre : cofres) {
            if (cofre.numerocofre == numero) {
              
                return 1; 
            }
        }
        return 0; 
    }
    
}