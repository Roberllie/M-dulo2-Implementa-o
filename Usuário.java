package modulo2;

public class Usuario extends Pessoa {
    // Atributos específicos
    private int codigoUsuario;
    private int numEmprestimosAtuais; // Para controlar o limite de empréstimos por vez

    // Construtor
    public Usuario(String nome, int idade, int codigoUsuario) {
        super(nome, idade);
        this.codigoUsuario = codigoUsuario;
        this.numEmprestimosAtuais = 0; // Inicialmente 0
    }

    // Getters
    public int getCodigoUsuario() {
        return codigoUsuario;
    }

    public int getNumEmprestimosAtuais() {
        return numEmprestimosAtuais;
    }

    // Setters
    public void setCodigoUsuario(int codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    // Métodos para controle de empréstimos
    public void registrarNovoEmprestimo() {
        this.numEmprestimosAtuais++;
    }

    public void registrarDevolucao() {
        if (this.numEmprestimosAtuais > 0) {
            this.numEmprestimosAtuais--;
        }
    }

    // Método toString
    @Override
    public String toString() {
        return "Usuario: " + getNome() + "\nIdade: " + getIdade() + "\nCodigo: " + codigoUsuario;
    }
}
