package cantina.visao;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class Dialogo {

	public static void mostrarAviso(String aviso) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Aviso");
		alert.setHeaderText(null);
		alert.setContentText(aviso);
		alert.show();

		
	}
	
	public static boolean fazerPergunta(String pergunta) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Painel De Pergunta");
		alert.setHeaderText(null);
		alert.setContentText(pergunta);
		
		ButtonType buttonTypeSim =new ButtonType("Sim");
		ButtonType buttonTypeNao =new ButtonType("Não");
		
		alert.getButtonTypes().setAll(buttonTypeSim,buttonTypeNao);
		
		Optional<ButtonType> result = alert.showAndWait();
		
		return result.get() == buttonTypeSim ? true : false;
	}
}
