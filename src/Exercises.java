import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

@SuppressWarnings("resource")
public class Exercises {
	private static final DecimalFormat df = new DecimalFormat("0.00");

	public static void main(String[] args) {
		menu();
	}

	private static void menu() {
		System.out.println("Selecione qual questão deseja testar:");
		System.out.println("1- Calculadora de salário mínimo");
		System.out.println("2- Ordernar 3 números");
		System.out.println("3- Par ou ímpar?");
		System.out.println("4- Bom dia! Boa tarde! Boa noite!");
		System.out.println("5- Diâmetro, comprimento e área da circunferência");
		System.out.println("6- É doador de sangue?");
		System.out.println("7- É número primo?");
		try {
			Scanner sc = new Scanner(System.in);
			int selecao = sc.nextInt();
			validaSelecao(selecao);
		} catch (Exception exception) {
			System.out.println("Seleção inválida.\nExecute o programa novamente");
		}
	}

	private static void validaSelecao(int selecao) {
		switch(selecao) {
		case 1:
			salarioMinimo();
			break;
		case 2:
			ordernaTresNumeros();
			break;
		case 3:
			parOuImpar();
			break;
		case 4:
			saudacoes();
			break;
		case 5:
			circunferencia();
			break;
		case 6:
			doarSangue();
			break;
		case 7:
			ehPrimo();
			break;
		}
		System.out.println("Pressione Enter para reiniciar");
		try {
			System.in.read();
			menu();
		} catch (IOException e) {
			System.out.println("Até a próxima");
			System.exit(0);
		}
	}

	private static void salarioMinimo() {
		Scanner sc = new Scanner(System.in);
		float salarioMinimo = 1212;
		System.out.println("Digite o valor do seu salário: ");
		float salario = sc.nextFloat();
		System.out.println("Você recebe " + df.format((salario / salarioMinimo)) + " salário(s) mínimo(s)");
	}
	
	private static void ordernaTresNumeros() {
		Scanner sc = new Scanner(System.in);
		int[] numeros = new int[3];
		System.out.println("Digite o primeiro número: ");
		numeros[0] = sc.nextInt();
		System.out.println("Digite o segundo número: ");
		numeros[1] = sc.nextInt();
		System.out.println("Digite o terceiro número: ");
		numeros[2] = sc.nextInt();
		
		Arrays.sort(numeros);
		
		System.out.println("A ordem é a seguinte: " + Arrays.toString(numeros));
	}
	
	private static void parOuImpar() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite um valor");
		int valor = sc.nextInt();
		System.out.println("O valor é " + (valor % 2 == 0 ? "par" : "ímpar"));
	}
	
	private static void saudacoes() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Qual turno você estuda? (M=manhã, T=tarde, N=noite)");
		String turno = sc.nextLine();
		switch (turno) {
		case "M":
			System.out.println("Bom dia!");
			break;
		case "T":
			System.out.println("Boa tarde!");
			break;
		case "N":
			System.out.println("Boa noite!");
			break;
		default:
			System.out.println("Valor inválido");
			saudacoes();
			break;
		}
	}
	
	private static void circunferencia() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite o raio de uma curcunferência: ");
		float raio = sc.nextFloat();
		System.out.println("Diâmetro: " + (raio * 2) + " | Área: " + (Math.PI * Math.pow(raio, 2)));
	}
	
	private static void doarSangue() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite sua idade: ");
		int idade = sc.nextInt();
		if (idade >= 18 && idade <= 67) {
			System.out.println("Pode doar sangue");
		} else {
			System.out.println("Não pode doar sangue");
		}
	}
	
	private static void ehPrimo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite um número: ");
		int num = sc.nextInt();
		boolean result = true;
		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				result = false;
				break;
			}
		}
		System.out.println((!result ? "Não é" : "É") + " primo");
	}
}
