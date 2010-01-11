package fr.emn.wave.gadget.doodle.client;
import org.cobogw.gwt.waveapi.gadget.client.ParticipantUpdateEvent;
import org.cobogw.gwt.waveapi.gadget.client.ParticipantUpdateEventHandler;
import org.cobogw.gwt.waveapi.gadget.client.StateUpdateEvent;
import org.cobogw.gwt.waveapi.gadget.client.StateUpdateEventHandler;
import org.cobogw.gwt.waveapi.gadget.client.WaveGadget;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.gadgets.client.UserPreferences;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

@Gadget.ModulePrefs(title = "Doodle-like Gadget", height = 600)
public class Gadget extends WaveGadget<UserPreferences> {
	
	//private AdminView fenetreAdmin;

	public Gadget() {	
		
		//fenetreAdmin = new AdminView();
		
//		Button simpleButton = new Button("Créer un évènement", new ClickHandler() {
//	    public void onClick(ClickEvent event) {
//			fenetreAdmin.setVisible(true);			
//		}
//	    });
	    	    
	    VerticalPanel panel = new VerticalPanel();    
	    DecoratorPanel dPanel = new DecoratorPanel();
	    
	    //dPanel.add(fenetreAdmin);
	    //panel.add(simpleButton);
	    //panel.add(dPanel);
	    
	    
	   final DateTable dateTable = new DateTable();
	    
	   Button voteButton = new Button("Voter", new ClickHandler() {
          public void onClick(ClickEvent event) {
	            dateTable.resolveVote();
	          }
	      });
	   voteButton.setVisible(false);
	// Create the dialog box
	    final AdminView ajoutDate = new AdminView(dateTable, voteButton);
	    
	 // Create a button to show the dialog Box
	    Button openButton = new Button("Ajouter une date",
	        new ClickHandler() {
	          public void onClick(ClickEvent sender) {
	            ajoutDate.show();
	          }
	        });
	     panel.add(openButton);
	     
	     //create table to display dates :
	     
	     panel.add(dateTable);
	     panel.add(voteButton);
	     
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