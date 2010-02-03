package fr.emn.wave.gadget.doodle.client;

import java.util.HashMap;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Main view of the doodle gadget
 * @author Florent DAVID, Matthieu SALLAFRANQUE, Jean-François VERDONCK
 */
public class MainView extends VerticalPanel {

	private Label title; // Title for the event
	private Label description; // A small description related to the event
	private Grid grid;
	private Button pollButton;
	private Label finalResult;
	private int suggestionNumber;

	public MainView(final DoodleWaveGadget gadget) {
		super();
		this.setVisible(false);
		title = new Label();
		title.setStyleName("eventTitle");

		description = new Label();

		grid = new Grid(0, 0);
		grid.setStyleName("table");
		grid.setBorderWidth(2);
		grid.setCellPadding(5);
		pollButton = new Button("Voter", new ClickHandler() {
			public void onClick(ClickEvent event) {
				if (gadget.getWave().getState().get(
						gadget.getWave().getViewer().getId()) == null) {
					String keyVote = "voteNumber";
					HashMap<String, String> delta = new HashMap<String, String>();
					for (int i = 0; i < suggestionNumber; i++) {
						int value = Integer.parseInt(grid.getText(i, 1));
						CheckBox checkBox = (CheckBox) grid.getWidget(i, 2);
						if (checkBox.getValue()) {
							value++;
						}
						String s = "" + value;
						keyVote += i + 1;
						delta.put(keyVote, s);
						keyVote = "voteNumber";
					}
					delta.put(gadget.getWave().getViewer().getId(), "1");
					gadget.getWave().getState().submitDelta(delta);
				} else {
					Window
							.alert("On ne peut voter qu'une seule fois ! Cheater.");
				}
			}
		});
		finalResult = new Label("");

		this.add(title);
		this.add(description);
		this.add(grid);
		this.add(pollButton);
		this.add(finalResult);
	}

	public void update(final DoodleWaveGadget gadget) {
		title.setText(gadget.getWave().getState().get("eventTitle"));
		description.setText(gadget.getWave().getState().get("eventDescription"));
		suggestionNumber = Integer.parseInt(gadget.getWave().getState().get("suggestionNumber"));
		grid.resize(suggestionNumber, suggestionNumber);
		this.setVisible(true);
		String date = "date";
		String keyVote = "voteNumber";
		for (int i = 0; i < suggestionNumber; i++) {
			date += i + 1;
			keyVote += i + 1;
			grid.setText(i, 0, gadget.getWave().getState().get(date));
			grid.setText(i, 1, gadget.getWave().getState().get(keyVote));
			grid.setWidget(i, 2, new CheckBox());
			date = "date";
			keyVote = "voteNumber";
		}

		String choosenDate = "";
		int max = 0;
		keyVote = "voteNumber";
		for (int i = 0; i < suggestionNumber; i++) {
			keyVote += i + 1;
			if (Integer.parseInt(gadget.getWave().getState().get(keyVote)) > max) {
				max = Integer
						.parseInt(gadget.getWave().getState().get(keyVote));
				choosenDate = grid.getText(i, 0);
			}
			keyVote = "voteNumber";
		}
		if (choosenDate != "") {
			finalResult.setText("La date retenue est le " + choosenDate + ".");
		}
	}
}
