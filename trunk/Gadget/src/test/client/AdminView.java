package test.client;


import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class AdminView extends DockPanel {
	
	public AdminView() {
		super();
		this.setTitle("Création de l'évènement");
		this.add(new Label("Super evenement"), DockPanel.CENTER);
		this.setStyleName("admin_panel");
		this.setSize("400px", "300px");		
		this.setVisible(false);
		
		Button closeButton = new Button("Valider");
		closeButton.addClickListener(new ClickListener() {
			public void onClick(Widget sender) {
				AdminView.this.setVisible(false);
			}
		});
		this.add(closeButton, DockPanel.SOUTH); 
	}

}
