package br.com.projeto.api.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.api.modelo.Pessoa;
import br.com.projeto.api.repositorio.Repositorio;
import org.springframework.web.bind.annotation.PutMapping;


// Annotation - Ensinar um framework, como o spring, a colocar uma ação diferente em uma classe, método ou atributo
@RestController // Define que essa classe é responsável pelo controle
public class Controle {

  @Autowired // Annotation responsável por injetar uma dependência
  // Autowired elimina a necessidade de instanciação 
  private Repositorio acao; // Repositório que será injetado

  @PostMapping("/api") // Annotation utilizada para criar uma rota com suporte a requisição post  
  public Pessoa cadastrar(@RequestBody Pessoa obj) {
    return acao.save(obj); // save - Método responsável por salvar os dados no banco de dados
  }

  @GetMapping("/api") // Annotation utilizada para criar uma rota com suporte a requisição get
  public List<Pessoa> selecionar() {
    return acao.findAll(); // findAll - Método responsável por buscar dados no banco de dados e retornar uma lista com todos os dados encontrados
  }

  @GetMapping("/api/{codigo}") // Annotation utilizada para criar uma rota com suporte a requisição get com parâmetro
  public Pessoa selecionarPeloCodigo(@PathVariable int codigo) {
    return acao.findByCodigo(codigo); // findByCodigo - Método responsável por buscar dados no banco de dados e retornar um dado específico
  }

  @PutMapping("/api")
  public Pessoa editar(@RequestBody Pessoa obj) {      
      return acao.save(obj);
  }

  @DeleteMapping("/api/{codigo}")
  public void remover(@PathVariable int codigo) {
    Pessoa obj = selecionarPeloCodigo(codigo);
    acao.delete(obj);
  }

  @GetMapping("/api/contador") 
  public long contador() { 
    return acao.count(); // count - Método responsável por contar quantos dados existem no banco de dados
  }

  @GetMapping("/api/ordenarNomes")
  public List<Pessoa> ordenarNomes() {
    return acao.findByOrderByNome(); // findByOrderByNome - Método responsável por buscar dados no banco de dados e retornar uma lista com todos os dados encontrados, ordenados pelo nome
  }

  @GetMapping("/api/ordenarNomes/{nome}")
  public List<Pessoa> ordenarNomes(@PathVariable String nome) {
    return acao.findByNomeOrderByIdade(nome); // findByNomeOrderByIdadeDesc - Método responsável por buscar dados no banco de dados e retornar uma lista com todos os dados encontrados, ordenados pelo nome e pela idade de forma decrescente
  }

  @GetMapping("/") // Especifica que o método será uma rota com requisição Get, fazendo com que algum dado seja exibido
  public String mensagem() { // Rota Principal
    return "Hello World!";
  }

  @PostMapping("/pessoa") // Annotation utilizada para criar uma rota com suporte a requisição post
  public Pessoa pessoa(@RequestBody Pessoa p) { // Annotation responsável por obter dados vindos de outras APIs ou do front-end, sua estrutura geralmente é um JSON com as características do modelo
    return p;
  }
  
}

// @GetMapping("/bv/{nome}") // Rota com parâmetro
// public String boasVindas(@PathVariable String nome) { // @PathVariable - Define que o parâmetro é uma variável da rota
//   return "Bem vindo ao Spring Boot!" + nome;
// }