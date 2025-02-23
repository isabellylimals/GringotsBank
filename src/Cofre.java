
import java.util.ArrayList;
import java.util.List;

/* Estrutura do Projeto
Classe Cofre

Representa um cofre em Gringotes.
Contém o nome do bruxo, número do cofre e saldo.
Métodos para depositar, sacar e transferir galeões.
Classe BancoGringotes

Gerencia os cofres.
Mantém uma lista (ArrayList<Cofre>) de todos os cofres.
Métodos para criação de cofres, listagem e transações.
Classe Main

Exibe um menu interativo para que o usuário escolha as ações.
Utiliza Scanner para entrada de dados. */
class Cofre{
    protected String nomebruxo;
    protected  int numerocofre;
    protected  Double saldo;
    protected  List<String> historicoTransacoes;
    public Cofre(String nomebruxo, int numerocofre, double saldo){
        this.nomebruxo= nomebruxo;
        this.numerocofre=numerocofre;
        this.saldo=saldo;
        this.historicoTransacoes = new ArrayList<>();
    }
    public void depositar(double valor) {
        saldo += valor;
        historicoTransacoes.add("Depósito de " + valor + " galeões.");
    }
    public Boolean sacar(double valor){
        if (valor <= saldo) {
            saldo -= valor;
            historicoTransacoes.add("Saque de " + valor + " galeões.");
            return true;
        } else {
            historicoTransacoes.add("Tentativa de saque falhou! Saldo insuficiente.");
            return false;
        }
      


    }
    public boolean tranferirGaleoes(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            historicoTransacoes.add("Transferência realizada: -" + valor + " galeões.");
            return true; 
        } else {
            historicoTransacoes.add("Tentativa de transferência falhou! Saldo insuficiente.");
            return false; 
        }
    }


    public void receberGaleoes(double valor) {
        saldo += valor;
        historicoTransacoes.add("Transferência recebida: +" + valor + " galeões.");
    }

    
    public double getSaldo() {
        return saldo;
    }

    public int getNumeroCofre() {
        return numerocofre;
    }

    public String getNomeBruxo() {
        return nomebruxo;
    }

    public void listarTransacoes(int cofreh) {
        System.out.println("\nHistórico de Transações do Cofre " + cofreh + ":");
        for (String transacao : historicoTransacoes) {
            System.out.println(transacao);
        }
    }
}