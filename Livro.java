package modulo2;

public class Livro {
    // Atributos
    private String titulo;
    private Autor autorPrincipal; // Relação: 1 Livro possui 1 Autor principal
    private String genero;
    private boolean disponivel; // Para controle de empréstimo

    // Construtor
    public Livro(String titulo, Autor autorPrincipal, String genero) {
        this.titulo = titulo;
        this.autorPrincipal = autorPrincipal;
        this.genero = genero;
        this.disponivel = true; // Por padrão, o livro está disponível
        // Adicionar o livro à lista de livros do autor
        autorPrincipal.adicionarLivro(this);
    }

    // Getters
    public String getTitulo() {
        return titulo;
    }

    public Autor getAutorPrincipal() {
        return autorPrincipal;
    }

    public String getGenero() {
        return genero;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    // Setters
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutorPrincipal(Autor autorPrincipal) {
        this.autorPrincipal = autorPrincipal;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    // Métodos para controle de disponibilidade
    public void emprestar() {
        this.disponivel = false;
    }

    public void devolver() {
        this.disponivel = true;
    }

    // Método toString
    @Override
    public String toString() {
        return "Livro: " + titulo + "\nAutor: " + autorPrincipal.getNome() + "\nGenero: " + genero;
    }
}
