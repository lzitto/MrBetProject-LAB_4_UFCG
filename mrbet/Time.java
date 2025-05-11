package br.edu.ufcg.computacao.mrbet;

import java.util.Objects;

public class Time {
    private final String codigo;
    private final String nome;
    private final String mascote;

    public Time(String codigo, String nome, String mascote) {
        this.codigo = codigo;
        this.nome = nome;
        this.mascote = mascote;
    }

    @Override
	public int hashCode() {
		return Objects.hash(codigo, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Time other = (Time) obj;
		return Objects.equals(codigo, other.codigo) && Objects.equals(nome, other.nome);
	}

	public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getMascote() {
        return mascote;
    }

    @Override
    public String toString() {
        return "Time{" +
                "codigo='" + codigo + '\'' +
                ", nome='" + nome + '\'' +
                ", mascote='" + mascote + '\'' +
                '}';
        // [250_PB] Nacional de Patos / Canário 

    }
}

