package modulo2;

import java.util.ArrayList;
import java.util.List;

public class Autor extends Pessoa {
    // Atributos específicos
    private String nacionalidade;
    // Relação: Cada Autor pode escrever N Livros (Lista de Livros)
    private List<Livro> livrosEscritos;

    // Construtor
    public Autor(String nome, int idade, String nacionalidade) {
        super(nome, idade);
        this.nacionalidade = nacionalidade;
        this.livrosEscritos = new ArrayList<>();
    }

    // Getters
    public String getNacionalidade() {
        return nacionalidade;
    }

    public List<Livro> getLivrosEscritos() {
        return livrosEscritos;
    }

    // Setters
    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    // Método para adicionar Livro
    public void adicionarLivro(Livro livro) {
        this.livrosEscritos.add(livro);
    }

    // Método toString
    @Override
    public String toString() {
        return "Autor: " + getNome() + "\nNacionalidade: " + nacionalidade;
    }
}
