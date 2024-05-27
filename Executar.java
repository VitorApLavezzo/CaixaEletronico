import java.util.Random;
import java.util.Scanner;

public class Executar {
	public static void main(String[] args) 
    {
		Scanner input = new Scanner(System.in);
        iniciarConta(input);
	}

	public static void iniciarConta(Scanner input)
	{
		Random gerador = new Random();
		String Resposta;
		System.out.println("Ola você ja possui um cadastro conosco? digite S para SIM e N para NÃO");
		Resposta = input.nextLine().toUpperCase();
		
		while (!Resposta.equals("S") && !Resposta.equals("N"))
		{
			System.out.println("Resposta invalida tente novamente");
			Resposta = input.nextLine().toUpperCase();
		}
		
		if (Resposta.equals("S")) {
            Conta conta = new Conta("", "", "", 0, 0, 0);
            if (conta.login("nome", "CPF", "senha", 12345)) {
                conta.mostrarMenu();
            } else {
                iniciarConta(input);
            }
        }
		else if (Resposta.equals("N"))
		{
			System.out.println("Gostaria de criar? digite S para SIM e N para NÃO");
			Resposta = input.nextLine().toUpperCase();
			
			while (!Resposta.equals("S") && !Resposta.equals("N"))
			{
				System.out.println("Resposta invalida tente novamente");
				Resposta = input.nextLine().toUpperCase();
			}
				
			if (Resposta.equals("S"))
			{
				System.out.println("Entendido, vamos criar a sua conta");
				System.out.println("Insira o seu nome");
				String nome_C = input.nextLine();
				System.out.println("Insira seu CPF");
				String CPF_C = input.nextLine();
				System.out.println("Insira sua senha");
				String senha_C = input.nextLine();
				int numConta_C = gerador.nextInt(99999);
				System.out.println("Numero da conta gerado com sucesso, o numero de sua conta é " + numConta_C);
				System.out.println("Deseja realizar um deposito? digite S para SIM e N para NÃO");
				Resposta = input.nextLine().toUpperCase();
                double saldoInicial = 0;
                if (Resposta.equals("S")) {
                    System.out.println("Quanto deseja depositar?");
                    saldoInicial = input.nextDouble();
                    input.nextLine();
                }
				Conta novaConta = new Conta(nome_C, CPF_C, senha_C, numConta_C, saldoInicial, 5);
                System.out.println("Conta criada com sucesso");
                novaConta.mostrarMenu();
            } 
            else {
                System.out.println("Entendido, obrigado pela preferência");
            }
		}
	}
}