/*
 * Tigase Jabber/XMPP Server
 * Copyright (C) 2004-2012 "Artur Hefczyc" <artur.hefczyc@tigase.org>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. Look for COPYING file in the top folder.
 * If not, see http://www.gnu.org/licenses/.
 *
 * $Rev$
 * Last modified by $Author$
 * $Date$
 */
package tigase.server.sreceiver;

/**
 * Simple news distributor task.
 *
 * Created: Fri May 11 08:53:16 2007
 *
 * @author <a href="mailto:artur.hefczyc@tigase.org">Artur Hefczyc</a>
 * @version $Rev$
 */
public class NewsDistributor extends RepoRosterTask {

	private static final String TASK_TYPE = "News Distribution";
	private static final String TASK_HELP =
		"The task acts as a newsletter over Jabber/XMPP protocol."
		+ " Users can subscribe to the news just by adding task JID"
		+ " to their roster, unsubscribing is equally simple - remove"
		+ " JID from roster to stop receiving news.";

	public String getType() {
		return TASK_TYPE;
	}

	public String getHelp() {
		return TASK_HELP;
	}

} // NewsDistributor
