package event;

import javafx.beans.property.SimpleDoubleProperty;

public class TableDataM {

	private final SimpleDoubleProperty mValue;

	TableDataM(double  mV) {
		this.mValue = new SimpleDoubleProperty(mV);
	}

	public double getMValue() {
		return mValue.get();
	}

	public void setMValue(double mV) {
		mValue.set(mV);
	}

}
