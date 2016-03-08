package event;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Events implements Initializable {

	@FXML TableView<TableData> table;
	@FXML TableView<TableDataM> tableTwo;
	@FXML TableColumn<TableData, Integer> tableX;
	@FXML TableColumn<TableData, Integer> tableY;
	@FXML TableColumn<TableDataM, Integer> tableM;
	@FXML TextField xInput;
	@FXML TextField yInput;

	@FXML LineChart<Number, Number> lineChart;
	@FXML NumberAxis xAxis;
	@FXML NumberAxis yAxis;

	double[] xArray;
	double[] yArray;
	double[] mArray;

	int buttonPressed = 0;


	public final static ObservableList<TableData> data = FXCollections.observableArrayList();
	public final static ObservableList<TableDataM> dataM = FXCollections.observableArrayList();

	@Override
	public void initialize(URL url, ResourceBundle resource) {
		System.out.println("Init");
		tableX.setCellValueFactory(new PropertyValueFactory<TableData, Integer>("xValue"));
		tableY.setCellValueFactory(new PropertyValueFactory<TableData, Integer>("yValue"));
		tableM.setCellValueFactory(new PropertyValueFactory<TableDataM, Integer>("mValue"));
		table.setItems(data);
		tableTwo.setItems(dataM);
	}

	public void submitXY() {

		buttonPressed ++;
		TableData entery = new TableData(Double.parseDouble(xInput.getText()), Double.parseDouble(yInput.getText()));
		data.add(entery);

		xArray = new double[data.size()];
		yArray = new double[data.size()];
		mArray = new double[data.size()];
		for(int i = 0; i < xArray.length; i++)
		{
			xArray[i] = Double.parseDouble(tableX.getCellData(i) + "");
			yArray[i] = Double.parseDouble(tableY.getCellData(i) + "");
		}
	}

	public void graph() {

		lineChart.getData().clear();
		dataM.clear();
		XYChart.Series<Number, Number> series = new XYChart.Series<Number,Number>();
		for(int i = 0; i < xArray.length; i++)
		{
			series.getData().add(new XYChart.Data<Number,Number>(xArray[i], yArray[i]));
		}

		lineChart.getData().add(series);

		for(int x = 0; x < mArray.length; x++)
		{
			double slope = 0;
			if(x+1 < mArray.length)
			{
				slope = (yArray[x + 1] - yArray[x]) / (xArray[x + 1] - xArray[x]);
				TableDataM enteryM = new TableDataM(slope);
				dataM.add(enteryM);

			}
			if(x+1 >= mArray.length)
			{
				slope = (yArray[x] - yArray[x - 1]) / (xArray[x] - xArray[x - 1]);
				TableDataM enteryM = new TableDataM(slope);
				dataM.add(enteryM);

			}
			System.out.println("Slope: " + slope);
		}
	}

}
