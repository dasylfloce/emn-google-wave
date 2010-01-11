package fr.emn.wave.gadget.doodle.client;

import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;

public class DateTable extends FlexTable {

	public DateTable() {
		super();
		this.setBorderWidth(1);
		this.setCellPadding(5);

	}

	public void addRow(String date) {
		int numRows = this.getRowCount();
		this.getCellFormatter().setHorizontalAlignment(numRows, 0,
				HasHorizontalAlignment.ALIGN_CENTER);

		this.setText(numRows, 0, date);
		this.setText(numRows, 1, "0");
		this.setWidget(numRows, 2, new CheckBox());
	}

	public void resolveVote() {
		int numRows = this.getRowCount();
		for (int i = 0; i < numRows; i++) {
			int value = new Integer(this.getText(i, 1)).intValue();
			CheckBox checkBox = (CheckBox) getWidget(i, 2);
			if (checkBox.getValue()) {
				value++;
			}
			String s = "" + value;
			this.setText(i, 1, s);
		}
	}
}
