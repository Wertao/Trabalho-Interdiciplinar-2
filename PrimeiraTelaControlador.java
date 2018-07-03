package telas;

import aplicacao.MainApp;
import dao.Jogadoresdao;
import entidade.Jogadores;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class PrimeiraTelaControlador {
	@FXML
	private TableView<Jogadores> tabelaJogadores;
	@FXML
	private TableColumn<Jogadores, Number> colunaTime;
	@FXML
	private TableColumn<Jogadores, String> colunaNome;
	@FXML	
	private TableColumn<Jogadores, String> colunaIdade;
	@FXML
	private Label lblNome;
	@FXML
	private Label lblTime;
	@FXML
	private Label lblIdade;
	@FXML
	private Label lblEmail;
	
	private MainApp mainApp;
	
	
	public PrimeiraTelaControlador() {
		
	}
	
	@FXML
	private void initialize() {
		colunaTime.setCellValueFactory(c->c.getValue().timeProperty());
		colunaNome.setCellValueFactory(c->c.getValue().nomeProperty());
		colunaIdade.setCellValueFactory(c->c.getValue().idadeProperty());	
	}


	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;		
		Jogadoresdao dao = new Jogadoresdao();
		
		tabelaJogadores.setItems(dao.getListaJogadores());	
		
	}
	
	@FXML
	private void deletarPessoa() {
	
		int indiceSelecionado = tabelaJogadores.getSelectionModel()
				.getSelectedIndex();
		if(indiceSelecionado>=0) {
			//remove a pessoa do banco de dados
			Jogadoresdao jdao = new Jogadoresdao();
			jdao.excluir( tabelaJogadores.getItems().get(indiceSelecionado));
			
			tabelaJogadores.getItems().remove(indiceSelecionado);
		}else {
			Alert alerta = new Alert(AlertType.WARNING);
			alerta.setTitle("Nenhum registro selecionado");
			alerta.setHeaderText("Nenhuma pessoa selecionada");
			alerta.setContentText("Você deve selecionar um registro na tabela");
			alerta.showAndWait();
		}
		
	}
	
	
	public void mostraDetalhes(Jogadores jogadores, Labeled lblTime) {
		if(jogadores !=null) {
			lblNome.setText(jogadores.getNome());
			lblIdade.setText(jogadores.getIdade());
			// foi necessário converter de int para String
			lblTime.setText(String.valueOf(jogadores.getTime()));
			lblEmail.setText(jogadores.getEmail());
			
		}else {
			lblNome.setText("");
			lblIdade.setText("");
			lblTime.setText("");
			lblEmail.setText("");
			lblTime.setText("");
		}
		
	}
	@FXML
	private void cliqueNovaPessoa() {
		Jogadores jogadores = new Jogadores("");
		mainApp.mostrarAdicionarEditarPessoa(jogadores);
		//mainApp.getLista().add(pessoa);
		tabelaJogadores.getItems().add(jogadores);
		
		//recarrega os dados do BD
		Jogadoresdao dao = new Jogadoresdao();
		tabelaJogadores.setItems(dao.getListaJogadores());	
	//	mostraDetalhes(pessoa);
		
	}
	
	@FXML
	private void cliqueEditarPessoa() {
		Jogadores jogadores = tabelaJogadores.getSelectionModel().getSelectedItem();
		if(jogadores!=null) {
			MainApp.mostrarAdicionarEditarJogadores();
			mostraDetalhes(jogadores, lblTime);
		}
	}
	

}
