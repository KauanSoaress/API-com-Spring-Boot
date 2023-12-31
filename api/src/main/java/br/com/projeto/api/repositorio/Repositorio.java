package br.com.projeto.api.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto.api.modelo.Pessoa;

@Repository // Annotation responsável por definir que essa classe é um repositório
public interface Repositorio extends CrudRepository<Pessoa, Integer> { // CrudRepository - Interface responsável por fornecer métodos para manipulação de dados no banco de dados, nele tem que ser passado o modelo que está sendo usado e o tipo da chave primária
  
  // Método responsável por buscar dados no banco de dados e retornar uma lista com todos os dados encontrados
  List<Pessoa> findAll(); 

  // Como não há dados duplicados, o retorno é somente Pessoa, caso retornasse uma lista, teria que ser List<Pessoa>
  Pessoa findByCodigo(int codigo);

  List<Pessoa> findByOrderByNome();

  List<Pessoa> findByNomeOrderByIdade(String nome);

  List<Pessoa> findByNomeContaining(String termo);

  List<Pessoa> findByNomeStartsWith(String termo); 

  List<Pessoa> findByNomeEndsWith(String termo);

  @Query(value= "SELECT SUM(idade) FROM pessoas", nativeQuery = true) // Query - Annotation responsável por definir uma query personalizada 
  int somaIdades();

  @Query(value= "SELECT * FROM pessoas WHERE idade >= :idade", nativeQuery = true) // :idade - Parâmetro que será passado para a query
  List<Pessoa> idadeMaiorIgual(int idade);

  int countByCodigo(int codigo); // countByCodigo - Método responsável por contar quantos dados existem no banco de dados, com base no código passado como parâmetro

}
