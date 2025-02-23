
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
    public void buscarCofre(Cofre buscar, int numerobuscar){
        if(cofres.isEmpty()){
            System.out.println("Não há nenhum cofre!");
                }else{
                    for (int idx = 0; idx < cofres.size(); idx++) {
                        if(buscar.numerocofre==numerobuscar){
            
                            System.out.println("Cofre encontrado." + "Nome do bruxo:" + buscar.nomebruxo + "Numero do cofre:" + buscar.numerocofre + "Saldo Disponivel:" + buscar.saldo);
                
                        }
                        else{
                            System.out.println("Cofre não encontrado.");
                        }
                    }
    }
}
public void Transferir(double valor){
    Scanner sc= new Scanner(System.in);

    System.out.print("Insira o numero do cofre que deseja realizar o saque para tranferencia:\n");
    int numeroTransferir= sc.nextInt();

}

}