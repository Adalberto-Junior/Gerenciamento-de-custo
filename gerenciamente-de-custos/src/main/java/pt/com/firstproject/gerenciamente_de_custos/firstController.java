package pt.com.firstproject.gerenciamente_de_custos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/firstproject")        // Define que a minha aplicação vai ser controlada/gerenciada por Spring Boot, e o caminho para acessar a aplicação será "localhost:8080/firstproject"
@RestController   // Define que a classe é um controlador REST, ou seja, ela vai lidar com requisições HTTP e retornar respostas em formato JSON ou XML.
public class firstController {
    
    @GetMapping("/helloworld")   // Define que o método helloWorld() vai ser acessado através de uma requisição GET no caminho "localhost:8080/firstproject/helloworld"
    public String helloWorld() {
        return "Hello World! - Seja bem-vindo ao meu primeiro projeto Spring Boot!";  // Retorna a mensagem "Hello World! - Seja bem-vindo ao meu primeiro projeto Spring Boot!" quando a rota for acessada.
    }

    @GetMapping("/userdata")   // Define que o método userData() vai ser acessado através de uma requisição GET no caminho "localhost:8080/firstproject/userdata"
    public String userData() {
        return "Dados do utilizador: Nome: João, Idade: 30, Email: joao@email.com";  // Retorna os dados do usuário quando a rota for acessada.
    }
}
