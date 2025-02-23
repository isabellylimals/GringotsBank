
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
    public void buscarCofre(int numerobuscar) {
        if (cofres.isEmpty()) {
            System.out.println("Não há nenhum cofre!");
        } else {
            boolean encontrado = false;
            for (Cofre cofre : cofres) {
                if (cofre.numerocofre == numerobuscar) {
                    System.out.println("Cofre encontrado. " +
                                       "Nome do bruxo: " + cofre.nomebruxo + 
                                       ", Número do cofre: " + cofre.numerocofre + 
                                       ", Saldo Disponível: " + cofre.saldo);
                    encontrado = true;
                    break; 
                }
            }
            if (!encontrado) {
                System.out.println("Cofre não encontrado.");
            }
        }
    }
    
    public void Transferir(BancoGringotes banco) {
        Scanner sc = new Scanner(System.in);
    
        System.out.print("Insira o número do cofre que deseja realizar o saque para transferência:\n");
        int numeroTransferir = sc.nextInt();
        banco.buscarCofre(numeroTransferir); 
        System.out.print("Agora informe o numero do banco para qual deseja fazer a tranferencia:\n");
        int numeroReceber=sc.nextInt();
        banco.buscarCofre(numeroReceber);
        System.out.println("Agora indique o valor da tranferencia:\n");
        double valor=sc.nextDouble();
    }

}