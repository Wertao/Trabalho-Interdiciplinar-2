package telas;


import dao.Jogadoresdao;
import entidade.Jogadores;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AdicionarEditarControlador {
	@FXML
	private TextField txtTime;
	@FXML
	private TextField txtNome;
	@FXML
	private TextField txtEmail;
	@FXML
	private TextField txtIdade;
	
	private Stage palcoDialogo;
	private Jogadores Jogadores;
	
	
	@FXML
	private void initialize() {
		
	}
	
	public void setPalcoDialogo(Stage palcoDialogo) {
		this.palcoDialogo = palcoDialogo;
	}
	
	public void setJogadores(Jogadores jogadores) {
		this.Jogadores = jogadores;
		txtTime.setText(String.valueOf(jogadores.getTime()));
		txtNome.setText(jogadores.getNome());
		txtEmail.setText(jogadores.getEmail());
		txtIdade.setText(jogadores.getIdade());
	}
	@FXML
	private void cliqueOk() {
		//pessoa.setCodigo(Integer.parseInt(txtCodigo.getText()));
		Jogadores.setEmail(txtEmail.getText());
		Jogadores.setIdade(txtIdade.getText());
		Jogadores.setNome(txtNome.getText());
		
		//insere os dados no banco de dados
		Jogadoresdao jdao = new Jogadoresdao();
		if (Jogadores.getTime()>0) {
			jdao.alterar(Jogadores);
		} else {
			jdao.inserir(Jogadores);
		}
		jdao.listar();
		
		palcoDialogo.close();
	}
	@FXML
	private void cliqueCancelar() {
		palcoDialogo.close();
	}
}
