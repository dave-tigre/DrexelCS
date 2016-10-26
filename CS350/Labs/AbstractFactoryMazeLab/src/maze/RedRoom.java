/**
 * 
 */
package maze;

import java.awt.Color;

/**
 * @author dave-tigre
 *
 */
public class RedRoom extends Room{

	public RedRoom(int num) {
		super(num);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Color getColor()
	{
		Color light_red = new Color(255,130,130);
		return light_red;
	}

}
