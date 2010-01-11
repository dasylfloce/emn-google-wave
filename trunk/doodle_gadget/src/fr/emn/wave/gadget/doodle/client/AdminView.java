package fr.emn.wave.gadget.doodle.client;

import java.util.Date;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DatePicker;

public class AdminView extends DialogBox {

	public AdminView(final DateTable dateTable, final Button voteButton) {
		super();
		this.setAutoHideEnabled(true);
		this.setAnimationEnabled(true);
		VerticalPanel dialogContents = new VerticalPanel();
		dialogContents.setSpacing(4);
		this.setWidget(dialogContents);

		// Le super datePicker
		DatePicker datePicker = new DatePicker();
		final Label text = new Label();

		datePicker.addValueChangeHandler(new ValueChangeHandler() {
			public void onValueChange(ValueChangeEvent event) {
				Date date = (Date) event.getValue();
				String dateString = DateTimeFormat.getMediumDateFormat()
						.format(date);
				text.setText(dateString);
			}
		});

		// Set the default value
		datePicker.setValue(new Date(), true);

		// Add the widgets to the page
		dialogContents.add(text);
		dialogContents.add(datePicker);

		// Add a close button at the bottom of the dialog
		Button closeButton = new Button("Valider", new ClickHandler() {
			public void onClick(ClickEvent event) {
				AdminView.this.hide();
				dateTable.addRow(text.getText());
				voteButton.setVisible(true);
			}
		});
		dialogContents.add(closeButton);
	}

}
