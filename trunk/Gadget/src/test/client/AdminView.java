package test.client;



import java.util.Date;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DatePicker;

public class AdminView extends DockPanel {
	
	public AdminView() {
		super();
		this.setTitle("Création de l'évènement");
		this.add(new Label("Super evenement"), DockPanel.CENTER);
		this.setStyleName("admin_panel");
		this.setSize("400px", "300px");		
		this.setVisible(false);
		
		DatePicker datePicker = new DatePicker();
		final Label text = new Label();
		
		datePicker.addValueChangeHandler(new ValueChangeHandler() {
	      public void onValueChange(ValueChangeEvent event) {
	        Date date = (Date) event.getValue();
	        String dateString = DateTimeFormat.getMediumDateFormat().format(date);
	        text.setText(dateString);
	      }
	    });
		
		// Set the default value
	    datePicker.setValue(new Date(), true);
	    
	    // Add the widgets to the page
	    this.add(text);
	    this.add(datePicker);



		
		Button closeButton = new Button("Valider");
		closeButton.addClickListener(new ClickListener() {
			public void onClick(Widget sender) {
				AdminView.this.setVisible(false);
			}
		});
		this.add(closeButton, DockPanel.SOUTH); 
	}

}
