package event;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class TableData {

	private final SimpleDoubleProperty xValue;
	private final SimpleDoubleProperty yValue;

	TableData(double  xV, double yV) {
		this.xValue = new SimpleDoubleProperty(xV);
		this.yValue = new SimpleDoubleProperty(yV);
	}

	public double getXValue() {
		return xValue.get();
	}

	public void setXValue(double xV) {
		xValue.set(xV);
	}

	public double getYValue() {
		return yValue.get();
	}

	public void setYValue(double yV) {
		yValue.set(yV);
	}

}
