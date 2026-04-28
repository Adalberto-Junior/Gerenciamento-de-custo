package pt.com.firstproject.gerenciamente_de_custos.contoller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/expensemanagement")        // Define que a minha aplicação vai ser controlada/gerenciada por Spring Boot, e o caminho para acessar a aplicação será "localhost:8080/expensemanagement"
public class expenseManagementController {
    
    /*
    * Registrar a despesa
    * Criar tabela de despesas na base de dados
    * criar entidade de despesa com os seguintes campos: id, descrição, valor, data, categoria, data_criacao, email (model)
    */

    @PostMapping("/create")   // Define que o método createExpense() vai ser acessado através de uma requisição POST no caminho "localhost:8080/expensemanagement/create"
    public void createExpense() {
        // Lógica para criar uma nova despesa
    }
}
