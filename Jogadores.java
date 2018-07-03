package entidade;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Jogadores {
	private IntegerProperty time;
	private StringProperty nome;
	private StringProperty email;
	private StringProperty idade;
	

	public Jogadores(String nome) {
		this.nome = new SimpleStringProperty(nome);
		this.email = new SimpleStringProperty();
		this.idade = new SimpleStringProperty();
		this.time = new SimpleIntegerProperty();
		

	}


	public final IntegerProperty timeProperty() {
		return this.time;
	}
	


	public final int getTime() {
		return this.timeProperty().get();
	}
	


	public final void setTime(final int time) {
		this.timeProperty().set(time);
	}
	


	public final StringProperty nomeProperty() {
		return this.nome;
	}
	


	public final String getNome() {
		return this.nomeProperty().get();
	}
	


	public final void setNome(final String nome) {
		this.nomeProperty().set(nome);
	}
	


	public final StringProperty emailProperty() {
		return this.email;
	}
	


	public final String getEmail() {
		return this.emailProperty().get();
	}
	


	public final void setEmail(final String email) {
		this.emailProperty().set(email);
	}
	


	public final StringProperty idadeProperty() {
		return this.idade;
	}
	


	public final String getIdade() {
		return this.idadeProperty().get();
	}
	


	public final void setIdade(final String idade) {
		this.idadeProperty().set(idade);
	}
	

	
}
