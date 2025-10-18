package modulo2;

public class Main {
    public static void main(String[] args) {
        
        // 1. Criação das Pessoas (Autor e Usuário)
        Autor jessica = new Autor("Jessica Felix", 30, "Brasileira");
        Usuario lucas = new Usuario("Lucas Rafael", 25, 1001);

        // 2. Criação do Livro
        Livro javaBeginners = new Livro("Java for Beginners", jessica, "Tecnologia");
        
        // 3. Tentativa de empréstimo 1 (Deve ser bem-sucedido)
        Emprestimo emprestimo1 = new Emprestimo(javaBeginners, lucas);
        boolean sucesso1 = emprestimo1.realizarEmprestimo();
        
        // 4. Tentativa de empréstimo 2 (O livro não deve estar disponível)
        // Cria um segundo usuário e um segundo empréstimo para testar a indisponibilidade
        Usuario maria = new Usuario("Maria Silva", 28, 1002);
        Emprestimo emprestimo2 = new Emprestimo(javaBeginners, maria);
        boolean sucesso2 = emprestimo2.realizarEmprestimo();
        
        
        // Exibir o resultado da Main conforme solicitado

        // Resultado da Tentativa 2
        if (!sucesso2) {
            System.out.println("O livro não está disponível");
        }
        
        // Resultado do Empréstimo 1 (Se foi bem-sucedido, imprime os detalhes)
        if (sucesso1) {
            System.out.println(emprestimo1.toString());
        }
        
        // Demonstração da devolução (Opcional, mas boa prática)
        // emprestimo1.finalizarEmprestimo();
        // System.out.println("Status do Livro após devolução: " + javaBeginners.isDisponivel());
    }
}
