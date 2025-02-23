
import java.util.ArrayList;

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
    public void buscarCofre(Cofre buscar, int numerobuscar, double valor){
        if(cofres.isEmpty()){
            System.out.println("Não há nenhum cofre!");
                }else{
                    for (int idx = 0; idx < cofres.size(); idx++) {
                        if(buscar.numerocofre==numerobuscar){
                            buscar.depositar(valor);
                            System.out.println("Depósito realizado no Cofre " + valor);
                
                        }
                        else{
                            System.out.println("Cofre não encontrado.");
                        }
                    }
    }
}}