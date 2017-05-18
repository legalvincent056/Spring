package com.legal.TPInjectionSpectacle;

import java.util.Collection;

public class MusicienMultiInstrumentiste implements Performeur {

	public MusicienMultiInstrumentiste() {
		super();
	}
	
	public void performe() throws PerformanceException {
		for(Instrument instrument : instruments) {
		instrument.jouer();
		}
	}
	
	private Collection<Instrument> instruments;
	public void setInstruments(Collection<Instrument> instruments) {
		this.instruments = instruments;
		}
}
