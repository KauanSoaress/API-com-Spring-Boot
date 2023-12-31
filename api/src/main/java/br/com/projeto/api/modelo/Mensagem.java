package br.com.projeto.api.modelo;

import org.springframework.stereotype.Component;

@Component // Annotation responsável por definir que essa classe é um componente 
public class Mensagem {

  private String mensagem;

  public String getMensagem() {
    return mensagem;
  }

  public void setMensagem(String mensagem) {
    this.mensagem = mensagem;
  }
  
}
