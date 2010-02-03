package fr.emn.wave.gadget.doodle.client;

import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;

/**
 * Date slots are stored within a dynamic table
 * @author Florent DAVID, Matthieu SALLAFRANQUE, Jean-François VERDONCK
 * @see FlexTable
 */
public class SuggestionList extends FlexTable {

	public SuggestionList() {
		super();
	}

	/**
	 * Adds a suggestion to the existing table
	 * @param suggestion
	 */
	public void addSuggestion(String suggestion) {
		int numRows = this.getRowCount();
		this.getCellFormatter().setHorizontalAlignment(numRows, 0,
				HasHorizontalAlignment.ALIGN_CENTER);

		this.setText(numRows, 0, suggestion);
	}
}
