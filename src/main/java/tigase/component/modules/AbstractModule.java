/*
 * Tigase Jabber/XMPP Server
 * Copyright (C) 2004-2014 "Artur Hefczyc" <artur.hefczyc@tigase.org>
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
 */
package tigase.component.modules;

import java.util.logging.Logger;

import tigase.component.Context;
import tigase.component.eventbus.Event;
import tigase.server.Packet;

/**
 * Abstract class for help building a module. It has implemented few default
 * methods from {@link Module}, {@link ContextAware} and
 * {@link InitializingModule}.
 * 
 * @author bmalkow
 * 
 * @param <CTX>
 *            context of component.
 */
public abstract class AbstractModule<CTX extends Context> implements Module, ContextAware, InitializingModule {

	protected CTX context;

	protected final Logger log = Logger.getLogger(this.getClass().getName());

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void afterRegistration() {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void beforeRegister() {
		if (context == null)
			throw new RuntimeException("Context is not initialized!");
	}

	/**
	 * Fires event.
	 * 
	 * @param event
	 *            event to fire.
	 */
	protected void fireEvent(Event<?> event) {
		context.getEventBus().fire(event, this);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void setContext(Context context) {
		this.context = (CTX) context;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void unregisterModule() {
	}

	/**
	 * Writes single {@linkplain Packet}.
	 * 
	 * @param packet
	 *            {@link Packet} to be written.
	 */
	protected void write(Packet packet) {
		context.getWriter().write(packet);
	}

}
