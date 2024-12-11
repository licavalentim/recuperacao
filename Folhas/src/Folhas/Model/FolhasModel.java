package Folhas.Model;

import java.util.UUID;

@Entity
@Table(name = "Folhas")
public class FolhasModel {

	@Id
	private UUID id = UUID.randomUUID();
	
	private String nome;
	private String tipo;
	private String formato;
	private String cor;
	private String tamanho; 
	private String textura;
	

	
	
	// Getters e Setters
	 public UUID getId() {
	        return id;
	    }

	    public void setId(UUID id) {
	        this.id = id;
	    }

	    public String getNome() {
	        return nome;
	   
	    }

	    public void setNome(String nome) {
	        this.nome = nome;
	    }

	    public String getTipo(String tipo) {
	        return tipo;
	  
	    }

	    public void setTipo(String tipo) {
	        this.tipo = tipo;
	    }

	    public void getFormato(String formato) {
	        return;   
	    } 

	    public void setFormato(String formato) {
	        this.formato = formato;
	    }

	    public void getCor(String Cor) {
	        return;
	    }

	    public void setCor(String Cor, String cor) {
	        this.cor = cor; 
	    }
	    public void setTamanho (String Tamanho) {
	    	return;
	    }
        public void getTamanho (String Tamanho, String tamanho) {
	       this.tamanho = tamanho;
	    }

        public void setTextura (String Textura) {
        	return;
        }
        public void getTextura (String Textura, String textura) {
        	this.textura = textura;
        }
}
 