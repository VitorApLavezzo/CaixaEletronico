import java.util.Scanner;

public class Conta {
    private String nome;
    private String senha;
    private int numConta;
    private double saldo;
    private int saques;
    private String CPF;
    public Conta(String nome, String CPF, String senha, int numConta, double saldo, int saques) {
        this.nome = nome;
        this.CPF = CPF;
        this.senha = senha;
        this.numConta = numConta;
        this.saldo = saldo;
        this.saques = saques;
    }
    // Getters e Setters
    public String getNome() {
        return nome;
    }
    public String getCPF() {
        return CPF;
    }
    public int getNumConta() {
        return numConta;
    }
    public double getSaldo() {
        return saldo;
    }
    public int getSaques() {
        return saques;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public void setSaques(int saques) {
        this.saques = saques;
    }

    public void mostrarMenu() {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("----------------------------------------");
            System.out.println("MENU:");
            System.out.println("1 - Saldo");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Extrato");
            System.out.println("5 - Transferir");
            System.out.println("6 - Fechar");
            int opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("SALDO: " + saldo);
                    break;
                case 2:
                    System.out.println("Quanto deseja depositar?");
                    double qtdDeposito = input.nextDouble();
                    depositar(qtdDeposito);
                    break;
                case 3:
                    System.out.println("Quanto deseja sacar?");
                    double qtdSaque = input.nextDouble();
                    sacar(qtdSaque);
                    break;
                case 4:
                    System.out.println("Olá " + nome);
                    System.out.println("Seu CPF é " + CPF);
                    System.out.println("Seu saldo é " + saldo);
                    System.out.println("Hoje lhe restam " + saques + " saques");
                    break;
                case 5:
                    System.out.println("Quanto deseja transferir?");
                    double qtdTransf = input.nextDouble();
                    // Supondo uma conta de destino
                    Conta contaDestino = new Conta("Paulo", "132456789-10", "152535", 55599, 0, 5);
                    transferir(contaDestino, qtdTransf);
                    break;
                case 6:
                    System.out.println("Agradecemos a preferência");
                    return;
                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }
        }
    }

    public void transferir(Conta contaDestino, double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            contaDestino.setSaldo(contaDestino.getSaldo() + valor);
            System.out.println("Transferência de " + valor + " realizada com sucesso para a conta " + contaDestino.getNumConta());
        } else {
            System.out.println("Saldo insuficiente ou valor inválido para completar esta transação");
        }
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de " + valor + " realizado com sucesso");
        } else {
            System.out.println("Valor inválido");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            if (saques > 0) {
                saldo -= valor;
                saques--;
                System.out.println("Saque de " + valor + " realizado com sucesso. Restam " + saques + " saques");
            } else {
                System.out.println("Limite de saques diários atingido");
            }
        } else {
            System.out.println("Saldo insuficiente ou valor inválido para saque");
        }
    }

    public boolean login(String nomeCorreto, String CPF_Correto, String senhaCorreta, int numContaCorreto) {
        Scanner input = new Scanner(System.in);
        System.out.println("Insira o seu nome");
        String nome = input.nextLine();
        System.out.println("Insira seu CPF");
        String CPF = input.nextLine();
        System.out.println("Insira sua senha");
        String senha = input.nextLine();
        System.out.println("Insira o número da sua conta");
        int numConta = input.nextInt();
        if (nome.equals(nomeCorreto) && CPF.equals(CPF_Correto) && senha.equals(senhaCorreta) && numConta == numContaCorreto) {
            System.out.println("Login efetuado com sucesso");
            return true;
        } else {
            System.out.println("Conta não encontrada ou alguma informação foi digitada incorretamente");
            return false;
        }
    }
}
