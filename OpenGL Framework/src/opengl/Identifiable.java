/**
 * 
 */
package opengl;

import java.util.UUID;

/**
 * @author Linus Vogel <linvogel@student.ethz.ch>
 *
 */
public class Identifiable {
	
	private final UUID uuid = UUID.randomUUID();

	/**
	 * Return the UUID of this object. This can be used to uniquely identify this object.
	 * A known user of this method is the Renderer class.
	 * @return
	 */
	public final UUID getUUID() {
		return uuid;
	}

}
