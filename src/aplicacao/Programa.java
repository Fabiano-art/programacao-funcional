package aplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import entity.Funcionario;

public class Programa {

	public static void main(String[] args) {
		
		List<Funcionario> lista = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		
		lista.add(new Funcionario("Maria", "maria@gmail.com", 3200));
		lista.add(new Funcionario("Alex", "alex@gmail.com", 1900));
		lista.add(new Funcionario("Marco", "marco@gmail.com", 1700));
		lista.add(new Funcionario("Bob", "bob@gmail.com", 3500));
		lista.add(new Funcionario("Anna", "anna@gmail.com", 2800));
		
		System.out.println("Digite o salario :");
		double salario = sc.nextDouble();
		
		List<Funcionario> lista2 = lista.stream().filter(f -> f.getSalario() > salario).collect(Collectors.toList());
		
		lista2.sort((f1, f2) -> f1.getNome().compareTo(f2.getNome()));
		
		System.out.println("Email dos funcionarios que ganham mais que: "+salario);
		lista2.forEach(System.out::println);
		
		double soma = lista.stream().filter(f -> f.getNome().charAt(0) == 'M').map(f -> f.getSalario()).reduce(0.0, (x, y) -> x + y);
		
		System.out.print("Soma do salário dos funcionarios que começa com a letra M: "+soma);
		
		sc.close();
	}

}
