package br.edu.ufcg.computacao.mrbet;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import br.edu.ufcg.computacao.mrbet.Campeonato;
import br.edu.ufcg.computacao.mrbet.Time;
import br.edu.ufcg.computacao.mrbet.MrBetSistema;

public class MrBet {
	Map<String, Time> times = new HashMap<>();
	Map<String, Campeonato> campeonatos = new HashMap<>();
	
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        MrBetSistema mrBet = new MrBetSistema(); // Classe principal que iremos criar

        char opcao;
        do {
            exibirMenu();
            System.out.print("Opção> ");
            opcao = scanner.nextLine().toUpperCase().charAt(0);

            try {
                switch (opcao) {
                	case 'M':
                		MrBetSistema.incluirTimes();
                        break;
                    case 'R':
                    	  
                    	MrBetSistema.recuperarTime();
                        break;
                    case '.':
                    	MrBetSistema.adicionarCampeonato();
                        break;
                    case 'B':
                    	MrBetSistema.submenuIncluirTimeEmCampeonato();
                        break;
                    case 'E':
                    	MrBetSistema.exibirCampeonatosDoTime();
                        break;
                    case 'T':
                    	MrBetSistema.submenuApostarOuStatus();
                        break;      
                    case '!':
                        // Já pode fechar o programa!
                    	System.out.println("Programa encerrado!");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        } while (opcao != '!');

        scanner.close();

    }
    // Método para exibir o menu...
    private static void exibirMenu() {
        System.out.println("(M)Minha inclusão de times");
        System.out.println("(R)Recuperar time");
        System.out.println("(.)Adicionar campeonato");
        System.out.println("(B)Bora incluir time em campeonato e Verificar se time está em campeonato");
        System.out.println("(E)Exibir campeonatos que o time participa");
        System.out.println("(T)Tentar a sorte e status");
        System.out.println("(!)Já pode fechar o programa!");
        System.out.println();
    }

}
