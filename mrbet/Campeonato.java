package br.edu.ufcg.computacao.mrbet;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Campeonato {
	private String nome;
	private int participantes;
	private List<Time> times;
	
	public Campeonato(String nome, int participantes) {
		this.nome = nome;
		this.participantes = participantes;
		this.times = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public int getParticipantes() {
		return participantes;
	}

	public List<Time> getTimes() {
		return times;
	}
	
	public boolean isCompleto() {
        return times.size() >= participantes;
    }

	public boolean adicionarTime(Time time) {
        if (times.size() < participantes) {
            times.add(time);
            return true;
        } else {
            return false;
        }
	
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Campeonato other = (Campeonato) obj;
		return Objects.equals(nome, other.nome);
	}

	public boolean verificarPresencaTime(Time time) {
        return times.contains(time);
    }
	
	public List<Time> getTimesParticipantes() {
        return times;
    }
}
