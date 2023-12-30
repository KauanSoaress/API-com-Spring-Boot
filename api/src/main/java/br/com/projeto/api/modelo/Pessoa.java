package br.com.projeto.api.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // Define que essa classe é uma entidade do banco de dados
@Table(name = "pessoas") // Define o nome da tabela no banco de dados
public class Pessoa { 

  // Atributos
  @Id // Define que o atributo é uma chave primária
  @GeneratedValue(strategy = GenerationType.IDENTITY) // Define que o atributo é auto incrementado, de forma crescente, iniciando com 1
  private int codigo;
  private String nome;
  private String idade;
  
  // Getters e Setters
  public int getCodigo() {
    return codigo;
  }
  public void setCodigo(int codigo) {
    this.codigo = codigo;
  }

  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getIdade() {
    return idade;
  }
  public void setIdade(String idade) {
    this.idade = idade;
  }
  
}
