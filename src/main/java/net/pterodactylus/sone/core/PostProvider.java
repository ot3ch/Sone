/*
 * Sone - PostProvider.java - Copyright © 2011–2012 David Roden
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

import net.pterodactylus.sone.data.Post;

/**
 * Interface for objects that can provide {@link Post}s by their ID.
 *
 * @author <a href="mailto:bombe@pterodactylus.net">David ‘Bombe’ Roden</a>
 */
public interface PostProvider {

	/**
	 * Returns the post with the given ID, if it exists. If it does not exist
	 * and {@code create} is {@code false}, {@code null} is returned; otherwise,
	 * a new post with the given ID is created and returned.
	 *
	 * @param postId
	 *            The ID of the post to return
	 * @param create
	 *            {@code true} to create a new post if no post with the given ID
	 *            exists, {@code false} to return {@code null} instead
	 * @return The post with the given ID, or {@code null}
	 */
	public Post getPost(String postId, boolean create);

}
