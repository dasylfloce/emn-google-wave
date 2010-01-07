package test.client;
import org.cobogw.gwt.waveapi.gadget.client.ParticipantUpdateEvent;
import org.cobogw.gwt.waveapi.gadget.client.ParticipantUpdateEventHandler;
import org.cobogw.gwt.waveapi.gadget.client.StateUpdateEvent;
import org.cobogw.gwt.waveapi.gadget.client.StateUpdateEventHandler;
import org.cobogw.gwt.waveapi.gadget.client.WaveGadget;

import com.google.gwt.gadgets.client.Gadget;
import com.google.gwt.gadgets.client.UserPreferences;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

@Gadget.ModulePrefs(title = "Doodle Gadget")
public class DoodleGadget extends WaveGadget<UserPreferences> {
	
	private AdminView fenetreAdmin;
	
	public DoodleGadget() {	
		fenetreAdmin = new AdminView();
		Button simpleButton = new Button("Créer un évènement",new ClickListener() {
	      public void onClick(Widget sender) {
	        fenetreAdmin.setVisible(true);	        
	      }
	    });
		
	    DockPanel panel = new DockPanel();    
	    panel.add(simpleButton, DockPanel.CENTER);
	    panel.add(fenetreAdmin, DockPanel.SOUTH);
		RootPanel.get().add(panel);
	}

	protected void init(UserPreferences preferences) {
		getWave().addParticipantUpdateEventHandler(new ParticipantUpdateEventHandler() {
			public void onUpdate(ParticipantUpdateEvent event) {
				//handle participants added, also called when wave with gadget is opened.
			}
		});
		getWave().addStateUpdateEventHandler(new StateUpdateEventHandler() {
			public void onUpdate(StateUpdateEvent event) {
				//handle state changes.
			}
		});
	}	
}