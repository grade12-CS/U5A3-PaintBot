import becker.robots.*;

/**
 *RobotTask class to run a task.
 *@author Sarah Yoo 
 *@version 1.0 
 */

public class RobotTask
{
	/**
	 *run a task. specify tasks to run.
	 *return void
	 */
	public void run ()
	{
		//randomly gets a city file
		City city = null;
		int rC = (int)Math.floor((Math.random()*5));
		System.out.println(rC+"");
		switch (rC) {
			case 0 -> city = new City("Paint0.wld");
			case 1 -> city = new City("Paint1.wld");
			case 2 -> city = new City("Paint2.wld");
			case 3 -> city = new City("Paint3.wld");
			case 4 -> city = new City("Paint4.wld");
			default -> {
			}
		}

		final int avenues = 9, streets = 9; //dimensions of canvas or city
		PaintBot bot = new PaintBot(city, avenues, streets);
		bot.paint();
	}
}
