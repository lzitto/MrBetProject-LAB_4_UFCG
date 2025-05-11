package br.edu.ufcg.computacao.mrbet;

public class Aposta {
	    private Time time;
	    private Campeonato campeonato;
	    private int colocacao;
	    private double valor;

	    public Aposta(Time time, Campeonato campeonato, int colocacao, double valor) {
	        this.time = time;
	        this.campeonato = campeonato;
	        this.colocacao = colocacao;
	        this.valor = valor;
	    }

		public Time getTime() {
			return time;
		}

		public void setTime(Time time) {
			this.time = time;
		}

		public Campeonato getCampeonato() {
			return campeonato;
		}

		public void setCampeonato(Campeonato campeonato) {
			this.campeonato = campeonato;
		}

		public int getColocacao() {
			return colocacao;
		}

		public void setColocacao(int colocacao) {
			this.colocacao = colocacao;
		}

		public double getValor() {
			return valor;
		}

		public void setValor(double valor) {
			this.valor = valor;
		}

	    // Getters e setters omitidos para brevidade
	}


