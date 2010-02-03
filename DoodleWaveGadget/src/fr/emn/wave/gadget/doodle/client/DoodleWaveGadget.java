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
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * A basic gwt wave-compliant gadget, helpful for planning issues.
 * Based on the working principle of www.doodle.com
 * @author Florent DAVID, Matthieu SALLAFRANQUE, Jean-François VERDONCK
 * @see www.doodle.com
 */
@DoodleWaveGadget.ModulePrefs(title = "Doodle Gadget", height = 450)
public class DoodleWaveGadget extends WaveGadget<UserPreferences> {
	private VerticalPanel mainPanel;
	private EventCreateView ecv;
	private CalendarView dv;
	private MainView mainView;
	private Button addEventButton;

	public DoodleWaveGadget() {
		mainPanel = new VerticalPanel();
		mainPanel.setStyleName("container");
		RootPanel.get().add(mainPanel);
		ecv = new EventCreateView(this);

		addEventButton = new Button("Créer un évènement", new ClickHandler() {
			public void onClick(ClickEvent event) {
				ecv.show();
				addEventButton.setVisible(false);
			}
		});
		mainPanel.add(addEventButton);
		mainView = new MainView(this);
		mainPanel.add(mainView);

	}

	protected void init(UserPreferences preferences) {
		getWave().addParticipantUpdateEventHandler(
				new ParticipantUpdateEventHandler() {
					public void onUpdate(ParticipantUpdateEvent event) {
						// handle participants added, also called when wave with
						// gadget is opened.
					}
				});
		getWave().addStateUpdateEventHandler(new StateUpdateEventHandler() {
			public void onUpdate(StateUpdateEvent event) {
				if (getWave().getState().get("validationDates") != null) {
					initEtatFinal();
				} else {
					if (getWave().getState().get("eventDescription") != null) {
						initEtatDates();
					} else {
						initStandard();
					}
				}
			}
		});
	}

	public void initEtatFinal() {
		addEventButton.setVisible(false);
		mainView.update(this);
	}

	public void initEtatDates() {
		addEventButton.setVisible(false);
		dv = new CalendarView(this);
		dv.show();
	}

	public void initStandard() {
		addEventButton.setVisible(true); // On the first step, we should only see the create event button
	}

	public VerticalPanel getPanel() {
		return mainPanel;
	}
}