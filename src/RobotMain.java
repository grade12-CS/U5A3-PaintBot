/**
* RobotMain Class
* This class creates simply creates a robot task and runs it.
*
* @author Sarah Yoo 
* @version 1.0 
*/

public class RobotMain
{
    /**
    * main method
    * runs a robot task, this method is needed so Java knows where to start
    *
    * @param arg - optional input arguments from the operating system, not used
    * @return void
    */
    public static void main (String[] args)
    {
      RobotTask task = new RobotTask ();
      task.run ();
    }
}
