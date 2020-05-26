import javafx.fxml.FXML;
import javafx.event.*;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;


public class mainController {
	@FXML LineChart<String, Number> lineChart; 

	
	public void btn(ActionEvent event) {
		XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();
		series.getData().add(new XYChart.Data<String, Number>("Jan", 200));
		series.getData().add(new XYChart.Data<String, Number>("Jan", 200));
		series.getData().add(new XYChart.Data<String, Number>("Jan", 200));
		series.getData().add(new XYChart.Data<String, Number>("Jan", 200));
		series.getData().add(new XYChart.Data<String, Number>("Jan", 200));
		series.getData().add(new XYChart.Data<String, Number>("Jan", 200));
		
		lineChart.getData().add(series);
		}
	
	
	
}
