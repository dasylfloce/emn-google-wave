package fr.emn.wave.gadget.doodle.client;

import java.util.Date;
import java.util.HashMap;

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

/**
 * A basic popup date picker to populate the suggestion list
 * @author Florent DAVID, Matthieu SALLAFRANQUE, Jean-François VERDONCK
 * @see DialogBox
 */
public class CalendarView extends DialogBox {

	private HashMap<String, String> delta;

	public CalendarView(final DoodleWaveGadget gadget) {
		super();
		delta = new HashMap<String, String>();
		delta.clear();
		this.setAutoHideEnabled(false);
		this.setAnimationEnabled(true);
		VerticalPanel dialogContents = new VerticalPanel();
		dialogContents.setSpacing(4);
		this.setWidget(dialogContents);

		// The wonderful date picker
		DatePicker datePicker = new DatePicker();
		final Label text = new Label();
		datePicker.addValueChangeHandler(new ValueChangeHandler() {
			public void onValueChange(ValueChangeEvent event) {
				Date date = (Date) event.getValue();
				String dateString = DateTimeFormat.getFormat("dd MMM yyyy")
						.format(date);
				text.setText(dateString);
			}
		});

		// Set the default value
		datePicker.setValue(new Date(), true);
		final SuggestionList dates = new SuggestionList();

		// Add the widgets to the page
		dialogContents.add(text);
		dialogContents.add(datePicker);
		dialogContents.add(dates);

		// Add a close button at the bottom of the dialog
		Button addButton = new Button("Ajouter", new ClickHandler() {
			public void onClick(ClickEvent event) {
				dates.addSuggestion(text.getText());
			}
		});
		dialogContents.add(addButton);

		Button closeButton = new Button("Valider", new ClickHandler() {
			public void onClick(ClickEvent event) {
				CalendarView.this.hide();
				String key = "date";
				String keyVote = "voteNumber";
				for (int i = 0; i < dates.getRowCount(); i++) {
					key += i + 1;
					keyVote += i + 1;
					delta.put(key, dates.getText(i, 0));
					delta.put(keyVote, "0");
					key = "date";
					keyVote = "voteNumber";
				}
				delta.put("suggestionNumber", "" + dates.getRowCount());
				delta.put("validationDates", "1");

				gadget.getWave().getState().submitDelta(delta);
				delta.clear();

			}
		});
		dialogContents.add(closeButton);
	}

}
