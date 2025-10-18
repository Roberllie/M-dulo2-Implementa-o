package modulo2;

import java.util.Date;
import java.util.Calendar;
import java.util.TimeZone;

public class Emprestimo {
    // Atributos
    private Livro livro; // Relação: Cada Empréstimo envolve pelo menos 1 Livro (aqui 1)
    private Usuario usuario; // Relação: Cada Empréstimo envolve apenas 1 Usuário
    private Date dataRetirada;
    private Date dataDevolucao;
    private boolean ativo; // Indica se o empréstimo ainda está em vigor

    // Construtor
    public Emprestimo(Livro livro, Usuario usuario) {
        this.livro = livro;
        this.usuario = usuario;
        this.ativo = false; // Começa como inativo
        
        // As datas serão setadas apenas se o empréstimo for bem-sucedido
        this.dataRetirada = null;
        this.dataDevolucao = null;
    }

    // Getters
    public Livro getLivro() {
        return livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Date getDataRetirada() {
        return dataRetirada;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }
    
    public boolean isAtivo() {
        return ativo;
    }

    // Setters
    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    // Método para realizar o empréstimo
    public boolean realizarEmprestimo() {
        // Verifica se o livro está disponível e o usuário tem limite
        // O limite de empréstimos por usuário deve ser controlado externamente ou através de regras mais complexas.
        // Pelo requisito, vamos focar em: Livro não pode estar em mais de 1 empréstimo por vez (controlado por Livro.isDisponivel())
        
        if (livro.isDisponivel()) {
            livro.emprestar(); // Marca o livro como indisponível
            usuario.registrarNovoEmprestimo(); // Registra o empréstimo para o usuário

            // Define as datas: Data de Retirada (agora) e Data de Devolução (exemplo: 7 dias depois)
            Calendar cal = Calendar.getInstance();
            cal.setTimeZone(TimeZone.getTimeZone("BRT")); // Ajusta para o fuso horário BRT
            
            this.dataRetirada = cal.getTime();
            
            cal.add(Calendar.DAY_OF_MONTH, 7); // Adiciona 7 dias para a devolução
            this.dataDevolucao = cal.getTime();
            
            this.ativo = true;
            return true;
        } else {
            return false;
        }
    }
    
    // Método para finalizar o empréstimo (devolução)
    public void finalizarEmprestimo() {
        if (this.ativo) {
            livro.devolver(); // Marca o livro como disponível
            usuario.registrarDevolucao(); // Reduz a contagem de empréstimos do usuário
            this.ativo = false;
        }
    }

    // Método toString (para imprimir o resultado do Empréstimo)
    @Override
    public String toString() {
        // Formato para as datas (aproximado ao da saída, mas usando a data de execução)
        // O formato exato do exemplo (Wed May 08 23:37:21 BRT 2024) é o formato padrão de Date.toString()
        
        String resultado = "";
        resultado += "Livro: " + livro.getTitulo() + "\n";
        resultado += "Autor: " + livro.getAutorPrincipal().getNome() + "\n";
        resultado += "Genero: " + livro.getGenero() + "\n";
        resultado += "Usuario: " + usuario.getNome() + "\n";
        resultado += "Idade: " + usuario.getIdade() + "\n";
        resultado += "Data de Retirada: " + dataRetirada.toString() + "\n";
        resultado += "Data de Devolucao: " + dataDevolucao.toString();
        
        return resultado;
    }
}
