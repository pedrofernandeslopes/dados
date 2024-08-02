package exercicios.lista06.q05;

import java.io.Serializable;

public class Pessoa implements Comparable<Pessoa>, Serializable {
    private static final long serialVersionUID = 1L;
    private String nome;
    private String sobreNome;
    private int idade;

    public Pessoa(String nome, String sobreNome, int idade) {
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public int getIdade() {
        return idade;
    }

    public String getNomeCompleto() {
        return nome + " " + sobreNome;
    }

    @Override
    public int compareTo(Pessoa outraPessoa) {
        return getNomeCompleto().compareTo(outraPessoa.getNomeCompleto());
    }
}
