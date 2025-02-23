
import java.util.ArrayList;
import java.util.Scanner;

class BancoGringotes{
    private ArrayList<Cofre> cofres= new ArrayList<>();
    public void Criarcofre(Cofre co){
        cofres.add(co);
        System.out.println("Cofre adicionado com sucesso!");
    }
    public void Listarcofres(Cofre lista){
        if(cofres.isEmpty()){
            System.out.println("Não há nenhum cofre!");
                }else{
                    for (int idx = 0; idx < cofres.size(); idx++) {
                             
                        System.out.println("Nome do bruxo:" + lista.nomebruxo + "Numero do cofre:"+ lista.numerocofre + "Saldo disponivel: %.2f" + lista.saldo);
                        
                    }
                }
    }
    public void Transacoes(){}
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
    }}