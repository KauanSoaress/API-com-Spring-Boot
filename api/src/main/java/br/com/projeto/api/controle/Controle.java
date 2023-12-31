package br.com.projeto.api.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.api.modelo.Cliente;
import br.com.projeto.api.modelo.Pessoa;
import br.com.projeto.api.repositorio.Repositorio;
import br.com.projeto.api.servico.Servico;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PutMapping;


// Annotation - Ensinar um framework, como o spring, a colocar uma ação diferente em uma classe, método ou atributo
@RestController // Define que essa classe é responsável pelo controle
public class Controle {

  @Autowired
  private Servico servico;

  @Autowired // Annotation responsável por injetar uma dependência
  // Autowired elimina a necessidade de instanciação 
  private Repositorio acao; // Repositório que será injetado

  @PostMapping("/api") // Annotation utilizada para criar uma rota com suporte a requisição post  
  public ResponseEntity<?> cadastrar(@RequestBody Pessoa obj) {
    return servico.cadastrar(obj); // save - Método responsável por salvar os dados no banco de dados
  }

  @GetMapping("/api") // Annotation utilizada para criar uma rota com suporte a requisição get
  public ResponseEntity<?> selecionar() {
    return servico.selecionar(); // findAll - Método responsável por buscar dados no banco de dados e retornar uma lista com todos os dados encontrados
  }

  @GetMapping("/api/{codigo}") // Annotation utilizada para criar uma rota com suporte a requisição get com parâmetro
  public ResponseEntity<?> selecionarPeloCodigo(@PathVariable int codigo) {
    return servico.selecionarPeloCodigo(codigo); // findByCodigo - Método responsável por buscar dados no banco de dados e retornar um dado específico
  }

  @PutMapping("/api")
  public ResponseEntity<?> editar(@RequestBody Pessoa obj) {      
    return servico.editar(obj);
  }

  @DeleteMapping("/api/remover/{codigo}")
  public ResponseEntity<?> remover(@PathVariable int codigo) {
    return servico.remover(codigo);
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

  @GetMapping("/api/nomeContem/{termo}")
  public List<Pessoa> nomeContem(@PathVariable String termo) {
    return acao.findByNomeContaining(termo); // findByNomeContaining - Método responsável por buscar dados no banco de dados e retornar uma lista com todos os dados encontrados, que contenham o termo passado como parâmetro
  }

  @GetMapping("/api/iniciaCom/{termo}")
  public List<Pessoa> nomeComeca(@PathVariable String termo) {
    return acao.findByNomeStartsWith(termo); // findByNomeStartsWith - Método responsável por buscar dados no banco de dados e retornar uma lista com todos os dados encontrados, que comecem com o termo passado como parâmetro
  }

  @GetMapping("/api/terminaCom/{termo}")
  public List<Pessoa> nomeTermina(@PathVariable String termo) {
    return acao.findByNomeEndsWith(termo); // findByNomeEndsWith - Método responsável por buscar dados no banco de dados e retornar uma lista com todos os dados encontrados, que terminem com o termo passado como parâmetro
  }

  @GetMapping("/api/somaIdades")
  public int somaIdades() {
    return acao.somaIdades(); // somaIdades - Método responsável por buscar dados no banco de dados e retornar a soma de todas as idades
  }

  @GetMapping("/api/idadeMaiorIgual/{idade}")
  public List<Pessoa> idadeMaiorIgual(@PathVariable int idade) {
    return acao.idadeMaiorIgual(idade); // idadeMaiorIgual - Método responsável por buscar dados no banco de dados e retornar uma lista com todos os dados encontrados, que tenham idade maior ou igual ao parâmetro passado
  }

  @GetMapping("/") // Especifica que o método será uma rota com requisição Get, fazendo com que algum dado seja exibido
  public String mensagem() { // Rota Principal
    return "Hello World!";
  }
  
  @PostMapping("/pessoa") // Annotation utilizada para criar uma rota com suporte a requisição post
  public Pessoa pessoa(@RequestBody Pessoa p) { // Annotation responsável por obter dados vindos de outras APIs ou do front-end, sua estrutura geralmente é um JSON com as características do modelo
    return p;
  }
  
  @GetMapping("/status") // Annotation utilizada para criar uma rota com suporte a requisição get
  public ResponseEntity<?> status() { // ResponseEntity - Classe responsável por retornar uma resposta ao front-end
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @PostMapping("/cliente")
  public void cliente(@Valid @RequestBody Cliente obj) { // @Valid - Annotation responsável por validar os dados que estão sendo recebidos
    
  }
}