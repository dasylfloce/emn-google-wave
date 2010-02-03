package fr.emn.wave.gadget.doodle.client;

import java.util.HashMap;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * @author Florent DAVID, Matthieu SALLAFRANQUE, Jean-François VERDONCK
 */
public class EventCreateView extends DialogBox {
	private HashMap<String, String> delta;

	public EventCreateView(final DoodleWaveGadget gadget) {
		super();
		delta = new HashMap<String, String>();
		delta.clear();
		this.setAutoHideEnabled(false);
		this.setAnimationEnabled(true);
		VerticalPanel dialogContents = new VerticalPanel();
		dialogContents.setSpacing(4);
		this.setWidget(dialogContents);

		// Create textbox for title and description
		Label eventTitlelabel = new Label("Titre :");
		final TextBox eventTitle = new TextBox();
		Label eventDescriptionLabel = new Label("Description :");
		final TextArea eventDescription = new TextArea();

		// Add the widgets to the page
		dialogContents.add(eventTitlelabel);
		dialogContents.add(eventTitle);
		dialogContents.add(eventDescriptionLabel);
		dialogContents.add(eventDescription);

		// Add a close button at the bottom of the dialog
		Button closeButton = new Button("Valider", new ClickHandler() {
			public void onClick(ClickEvent event) {
				EventCreateView.this.hide();
				delta.put("eventTitle", eventTitle.getText());
				delta.put("eventDescription", eventDescription.getText());
				gadget.getWave().getState().submitDelta(delta);
				delta.clear();
			}
		});
		dialogContents.add(closeButton);
	}
}
