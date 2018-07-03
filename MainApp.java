package aplicacao;




import dao.Jogadoresdao;
import entidade.Jogadores;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import telas.AdicionarEditarControlador;
import telas.PrimeiraTelaControlador;

public class MainApp extends Application {
	private Stage palcoPrincipal;
	private BorderPane layoutRaiz;

	@Override
	public void start(Stage primaryStage) {
		this.palcoPrincipal = primaryStage;
		this.palcoPrincipal.setTitle("Aplicação ED2");
		iniciaLayoutRaiz();  // exibir o Layout Raiz
		iniciaPrirmeiraTela();
	}

	private Pane carregaLayout(String url) {
		try {	
			FXMLLoader carregador = new FXMLLoader();
			carregador.setLocation(MainApp.class.getResource(url));
			return carregador.load();
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}	
	public void iniciaLayoutRaiz() {
		layoutRaiz = (BorderPane)carregaLayout("../telas/LayoutRaiz.fxml");
		Scene cena = new Scene(layoutRaiz);
		palcoPrincipal.setScene(cena);
		palcoPrincipal.show();
	}
	
	public void iniciaPrirmeiraTela() {
		try {
			FXMLLoader carregador = new FXMLLoader();
			String url = "../telas/PrirmeiraTela.fxml";
			carregador.setLocation(MainApp.class.getResource(url));
			
			AnchorPane primeiraTela = carregador.load();
			layoutRaiz.setCenter(primeiraTela);
			
			PrimeiraTelaControlador controlador = carregador.getController();
			controlador.setMainApp(this);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ObservableList<Jogadores> getLista(){
		Jogadoresdao dao= new Jogadoresdao();
		return getLista();
	}
	
	public boolean mostrarAdicionarEditarPessoa(Jogadores jogadores) {
		try {
			FXMLLoader carregador = new FXMLLoader();
			String url = "../telas/AdicionarEditarJogadores.fxml";
			carregador.setLocation(MainApp.class.getResource(url));
			
			AnchorPane dialogo = carregador.load();
			Stage palcoDialogo = new Stage();
			palcoDialogo.setTitle("Editar Jogador");
			palcoDialogo.initModality(Modality.WINDOW_MODAL);
			palcoDialogo.initOwner(palcoPrincipal);
			
			Scene cena = new Scene(dialogo);
			palcoDialogo.setScene(cena);
			
			AdicionarEditarControlador controlador = carregador.getController();
			controlador.setPalcoDialogo(palcoDialogo);
			controlador.setJogadores(jogadores);
			
			palcoDialogo.showAndWait();
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	public void alerta() {
		Alert alerta = new Alert(AlertType.INFORMATION);
		alerta.setTitle("JANELA DE ALERTA");
		alerta.setHeaderText("Cabeçalho");
		alerta.setContentText("conteúdo");
		alerta.showAndWait();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	public static void mostrarAdicionarEditarJogadores() {
		// TODO Auto-generated method stub
		
	}
}
