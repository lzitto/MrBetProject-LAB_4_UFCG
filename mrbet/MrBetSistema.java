package br.edu.ufcg.computacao.mrbet;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MrBetSistema {
	Map<String, Time> timesCadastrados = new HashMap<>();
	public static Map<String, Time> times = new HashMap<>();
	public static Map<String, Campeonato> campeonatos = new HashMap<>();
	public static Scanner scanner = new Scanner(System.in);
	
	
	public MrBetSistema() {
		this.times = new HashMap<>();
		this.campeonatos = new HashMap<>();
	}

	public static void incluirTimes() {
        System.out.print("Código: ");
        String codigo = scanner.nextLine().toUpperCase();
        if (times.containsKey(codigo)) {
            System.out.println("TIME JÁ EXISTE!");
            return;
        }

        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Mascote: ");
        String mascote = scanner.nextLine();

        Time time = new Time(codigo, nome, mascote);
        times.put(codigo, time);
        System.out.println("INCLUSÃO REALIZADA!");
    }
	
	 public static void recuperarTime() {
	        System.out.print("Código: ");
	        String codigo = scanner.nextLine().toUpperCase();
	        Time time = times.get(codigo);
	        if (time != null) {
	            System.out.println("[" + time.getCodigo() + "] " + time.getNome() + " / " + time.getMascote());
	        } else {
	            System.out.println("TIME NÃO EXISTE!");
	        }
	    }
	 public static void adicionarCampeonato() {
	        System.out.print("Campeonato: ");
	        String nomeCampeonato = scanner.nextLine().toUpperCase();
	        if (campeonatos.containsKey(nomeCampeonato)) {
	            System.out.println("CAMPEONATO JÁ EXISTE!");
	            return;
	        }

	        System.out.print("Participantes: ");
	        int numParticipantes = scanner.nextInt();
	        scanner.nextLine(); // Limpar o buffer do scanner

	        Campeonato campeonato = new Campeonato(nomeCampeonato, numParticipantes);
	        campeonatos.put(nomeCampeonato, campeonato);
	        System.out.println("CAMPEONATO ADICIONADO!");
	    }
	 
	 public static void submenuIncluirTimeEmCampeonato() {
	        System.out.println("\n(I) Incluir time em campeonato ou (V) Verificar se time está em campeonato?");
	        System.out.print("Opção> ");
	        String opcao = scanner.nextLine().toUpperCase();

	        switch (opcao) {
	            case "I":
	                incluirTimeEmCampeonato();
	                break;
	            case "V":
	            	verificarTimeEmCampeonato();
	                break;
	            default:
	                System.out.println("Opção inválida!");
	        }
	    }

	    public static void incluirTimeEmCampeonato() {
	        System.out.print("Código do time: ");
	        String codigoTime = scanner.nextLine().toUpperCase();
	        Time time = times.get(codigoTime);
	        if (time == null) {
	            System.out.println("O TIME NÃO EXISTE!");
	            return;
	        }

	        System.out.print("Nome do campeonato: ");
	        String nomeCampeonato = scanner.nextLine().toUpperCase();
	        Campeonato campeonato = campeonatos.get(nomeCampeonato);
	        if (campeonato == null) {
	            System.out.println("CAMPEONATO NÃO EXISTE!");
	            return;
	        }

	        if (campeonato.isCompleto()) {
	            System.out.println("TODOS OS TIMES DESSE CAMPEONATO JÁ FORAM INCLUÍDOS!");
	            return;
	        }

	        campeonato.adicionarTime(time);
	        System.out.println("TIME INCLUÍDO NO CAMPEONATO!");
	    }
	    
	    public static void verificarTimeEmCampeonato() {
	        System.out.print("Código do time: ");
	        String codigoTime = scanner.nextLine().toUpperCase();
	        Time time = times.get(codigoTime);
	        if (time == null) {
	            System.out.println("O TIME NÃO EXISTE!");
	            return;
	        }

	        System.out.print("Nome do campeonato: ");
	        String nomeCampeonato = scanner.nextLine().toUpperCase();
	        Campeonato campeonato = campeonatos.get(nomeCampeonato);
	        if (campeonato == null) {
	            System.out.println("O CAMPEONATO NÃO EXISTE!");
	            return;
	        }

	        if (campeonato.verificarPresencaTime(time)) {
	            System.out.println("O TIME ESTÁ NO CAMPEONATO!");
	        } else {
	            System.out.println("O TIME NÃO ESTÁ NO CAMPEONATO!");
	        }
	    }
	    
	   public static void exibirCampeonatosDoTime() {
	        System.out.print("Código do time: ");
	        String codigoTime = scanner.nextLine().toUpperCase();
	        Time time = times.get(codigoTime);
	        if (time == null) {
	            System.out.println("O TIME NÃO EXISTE!");
	            return;
	        }

	        System.out.println("\nCampeonatos do " + time.getNome() + ":");
	        for (Map.Entry<String, Campeonato> entry : campeonatos.entrySet()) {
	            Campeonato campeonato = entry.getValue();
	            if (campeonato.verificarPresencaTime(time)) {
	                System.out.println("* " + campeonato.getNome() + " - " + campeonato.getTimesParticipantes().size() + "/" + campeonato.getParticipantes());
	            }
	        }
	    }
	   
	  
	   public static void submenuApostarOuStatus() {
	        System.out.println("\n(A) Apostar ou (S) Status das Apostas?");
	        System.out.print("Opção> ");
	        String opcao = scanner.nextLine().toUpperCase();

	        switch (opcao) {
	            case "A":
	                apostar();
	                break;
	            case "S":
	            	exibirStatusApostas();
	                break;
	            default:
	                System.out.println("Opção inválida!");
	        }
	    }

	   public static void apostar() {
		    System.out.print("Código do time: ");
		    String codigoTime = scanner.nextLine().toUpperCase();
		    Time time = times.get(codigoTime);
		    if (time == null) {
		        System.out.println("O TIME NÃO EXISTE!");
		        return;
		    }

		    System.out.print("Nome do campeonato: ");
		    String nomeCampeonato = scanner.nextLine().toUpperCase();
		    Campeonato campeonato = campeonatos.get(nomeCampeonato);
		    if (campeonato == null) {
		        System.out.println("O CAMPEONATO NÃO EXISTE!");
		        return;
		    }

		    if (campeonato.verificarPresencaTime(time)) {
		        System.out.print("Colocação: ");
		        int colocacao = scanner.nextInt();
		        scanner.nextLine(); // Limpar o buffer do scanner

		        if (colocacao <= 0 || colocacao > campeonato.getParticipantes()) {
		            System.out.println("APOSTA NÃO REGISTRADA! Colocação inválida.");
		            return;
		        }

		        System.out.print("Valor da Aposta: R$");
		        double valorAposta = scanner.nextDouble();
		        scanner.nextLine(); // Limpar o buffer do scanner

		        Aposta aposta = new Aposta(time, campeonato, colocacao, valorAposta);
		        System.out.println("APOSTA REGISTRADA!");
		    } else {
		        System.out.println("O TIME NÃO ESTÁ NO CAMPEONATO!");
		    }
		}
	   
	   public static void exibirStatusApostas() {
	        System.out.println("\nApostas:\n");
	        
	    }

}
