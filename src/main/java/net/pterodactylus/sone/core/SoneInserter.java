/*
 * FreenetSone - SoneInserter.java - Copyright © 2010 David Roden
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package net.pterodactylus.sone.core;

import java.util.logging.Level;
import java.util.logging.Logger;

import net.pterodactylus.sone.data.Sone;
import net.pterodactylus.util.logging.Logging;
import net.pterodactylus.util.service.AbstractService;

/**
 * A Sone inserter is responsible for inserting a Sone if it has changed.
 *
 * @author <a href="mailto:bombe@pterodactylus.net">David ‘Bombe’ Roden</a>
 */
public class SoneInserter extends AbstractService {

	/** The logger. */
	private static final Logger logger = Logging.getLogger(SoneInserter.class);

	/** The Sone to insert. */
	private final Sone sone;

	/**
	 * Creates a new Sone inserter.
	 *
	 * @param freenetInterface
	 *            The freenet interface
	 * @param sone
	 *            The Sone to insert
	 */
	public SoneInserter(FreenetInterface freenetInterface, Sone sone) {
		super("Sone Inserter for “" + sone.getName() + "”");
		this.sone = sone;
	}

	//
	// SERVICE METHODS
	//

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void serviceRun() {
		while (!shouldStop()) {
			synchronized (sone) {
				if (sone.getModificationCounter() > 0) {
					sone.setModificationCounter(0);
				}
			}
			logger.log(Level.FINEST, "Waiting 60 seconds before checking Sone “" + sone.getName() + "” again.");
			sleep(60 * 1000);
		}
	}

}