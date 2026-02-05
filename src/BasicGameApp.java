//Basic Game Application
//Version 2
// Basic Object, Image, Movement
// Astronaut moves to the right.
// Threaded

//K. Chun 8/2018

//*******************************************************************************
//Import Section
//Add Java libraries needed for the game
//import java.awt.Canvas;

//Graphics Libraries
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.*;
import java.sql.SQLOutput;
import javax.swing.JFrame;
import javax.swing.JPanel;

//todo: make a power varilbe for each class, then make if stament saying name.power > name2.move then isalive=true
//todo: ADD THE WARPING FOR FULL CREDIT
//todo: ADD COMMENTS!!!!!!!!!
//*******************************************************************************
// Class Definition Section

public class BasicGameApp implements Runnable {

   //Variable Definition Section
   //Declare the variables used in the program
   //You can set their initial values too

   //Sets the width and height of the program window
	final int WIDTH = 1500;
	final int HEIGHT = 800;

   //Declare the variables needed for the graphics
	public JFrame frame;
	public Canvas canvas;
   public JPanel panel;

	public BufferStrategy bufferStrategy;
	public Image astroPic;
    public Image NattyNiam;
    public Image RobustRen;
    public Image TyrannicalToby;
    public Image JovialJackson;
    public Image CockyCaden;
    public Image GrittyGideon;
    public Image BackgroundImage;
   //Declare the objects used in the program
   //These are things that are made up of more than one variable type
	private NattyNiam Niam;
    private RobustRen Ren;
    private TyrannicalToby Toby;
    private JovialJackson Jackson;
    private CockyCaden     Caden;
    private GrittyGideon Gideon;




   // Main method definition
   // This is the code that runs first and automatically
	public static void main(String[] args) {
		BasicGameApp ex = new BasicGameApp();   //creates a new instance of the game
		new Thread(ex).start();                 //creates a threads & starts up the code in the run( ) method
	}


   // Constructor Method
   // This has the same name as the class
   // This section is the setup portion of the program
   // Initialize your variables and construct your program objects here.
	public BasicGameApp() {

      setUpGraphics();

      //variable and objects
      //create (construct) the objects needed for the game and load up
		astroPic = Toolkit.getDefaultToolkit().getImage("astronaut.png");//load the picture
        NattyNiam = Toolkit.getDefaultToolkit().getImage("NattyNiam.png");
        RobustRen = Toolkit.getDefaultToolkit().getImage("RobustRen.png");
        TyrannicalToby = Toolkit.getDefaultToolkit().getImage("TryannicalToby.png");
        JovialJackson = Toolkit.getDefaultToolkit().getImage("JoivalJackson.png");
        CockyCaden = Toolkit.getDefaultToolkit().getImage("CockyCaden.png");
        GrittyGideon = Toolkit.getDefaultToolkit().getImage("GDAWG.png");
        BackgroundImage = Toolkit.getDefaultToolkit().getImage("BackgroundTSSG.jpg");

        Niam = new NattyNiam(300,560);
		Ren = new RobustRen(302,221);
        Toby = new TyrannicalToby(1000,500);
        Jackson = new JovialJackson(300,50);
        Caden = new CockyCaden(30,450);
        Gideon = new GrittyGideon(35,580);

        System.out.println(Niam.Power);
        System.out.println(Toby.Power);



    }// BasicGameApp()


//*******************************************************************************
//User Method Section
//
// put your code to do things here.

   // main thread
   // this is the code that plays the game after you set things up
	public void run() {

      //for the moment we will loop things forever.
		while (true) {

         moveThings();  //move all the game objects
         render();  // paint the graphics
         pause(20); // sleep for 10 ms
		}
	}


	public void moveThings()
	{
      //calls the move( ) code in the objects
        Niam.move();
        Gideon.move();
        Toby.move();
        Caden.move();
        Ren.move();
        Jackson.move();
        Crashing();


	}

    public void Crashing() {

        if (Niam.hitbox.intersects(Ren.hitBox)) {
            System.out.println("DEAD!!!");
            Niam.dx = -Niam.dx;
            Ren.dx = -Ren.dx;
            Niam.dy = -Niam.dy;
            Ren.dy = -Ren.dy;
        }

        if (Niam.hitbox.intersects(Toby.hitBox)) {
            System.out.println("DEAD!!!");
            Niam.dx = -Niam.dx;
            Toby.dx = -Toby.dx;
            Niam.dy = -Niam.dy;
            Toby.dy = -Toby.dy;

        }

        if (Niam.hitbox.intersects(Caden.hitBox)) {
            System.out.println("DEAD!!!");
            Niam.dx = -Niam.dx;
            Caden.dx = -Caden.dx;
            Niam.dy = -Niam.dy;
            Caden.dy = -Caden.dy;
        }
        if (Niam.hitbox.intersects(Toby.hitBox)) {
            System.out.println("DEAD!!!");
            Niam.dx = -Niam.dx;
            Toby.dx = -Toby.dx;
            Niam.dy = -Niam.dy;
            Toby.dy = -Toby.dy;
            if (Niam.Power>Toby.Power){
                Niam.iscrasinhg = true;
                Toby.isAlive = false;
                System.out.println(" toby died");
            }
            if (Toby.Power>Niam.Power){
                Toby.iscrasinhg = true;
                Niam.isAlive = false;
                System.out.println(Niam.isAlive);
            }
        }

        if (Niam.hitbox.intersects(Jackson.hitBox)) {
            System.out.println("DEAD!!!");
            Niam.dx = -Niam.dx;
            Jackson.dx = -Jackson.dx;
            Niam.dy = -Niam.dy;
            Jackson.dy = -Jackson.dy;

            }

        if (Niam.hitbox.intersects(Gideon.hitBox)) {
            System.out.println("DEAD!!!");
            Niam.dx = -Niam.dx;
            Gideon.dx = -Gideon.dx;
            Niam.dy = -Niam.dy;
            Gideon.dy = -Gideon.dy;

            if (Niam.Power>Gideon.Power){
                Niam.iscrasinhg = true;
                Gideon.isAlive = false;
                System.out.println("Gideon died");
                Gideon = new GrittyGideon(1000000,1000000);
            }
            if (Gideon.Power>Niam.Power){
                Gideon.iscrasinhg = true;
                Niam.isAlive = false;
                System.out.println("Niam died");

            }
        }


        if (Toby.hitBox.intersects(Niam.hitbox)) {
            System.out.println("DEAD!!!");
            Toby.dx = -Toby.dx;
            Niam.dx = -Niam.dx;
            Toby.dy = -Toby.dy;
            Niam.dy = -Niam.dy;
        }

        if (Toby.hitBox.intersects(Ren.hitBox)) {
            System.out.println("DEAD!!!");
            Toby.dx = -Toby.dx;
            Ren.dx = -Ren.dx;
            Toby.dy = -Toby.dy;
            Ren.dy = -Ren.dy;
        }

        if (Toby.hitBox.intersects(Caden.hitBox)) {
            System.out.println("DEAD!!!");
            Toby.dx = -Toby.dx;
            Caden.dx = -Caden.dx;
            Toby.dy = -Toby.dy;
            Caden.dy = -Caden.dy;
        }

        if (Toby.hitBox.intersects(Jackson.hitBox)) {
            System.out.println("DEAD!!!");
            Toby.dx = -Toby.dx;
            Jackson.dx = -Jackson.dx;
            Toby.dy = -Toby.dy;
            Jackson.dy = -Jackson.dy;
        }

        if (Toby.hitBox.intersects(Gideon.hitBox)) {
            System.out.println("DEAD!!!");
            Toby.dx = -Toby.dx;
            Gideon.dx = -Gideon.dx;
            Toby.dy = -Toby.dy;
            Gideon.dy = -Gideon.dy;
        }


        if (Ren.hitBox.intersects(Jackson.hitBox)) {
            System.out.println("DEAD!!!");
            Ren.dx = -Ren.dx;
            Jackson.dx = -Jackson.dx;
            Ren.dy = -Ren.dy;
            Jackson.dy = -Jackson.dy;
        }

        if (Ren.hitBox.intersects(Caden.hitBox)) {
            System.out.println("DEAD!!!");
            Ren.dx = -Ren.dx;
            Caden.dx = -Caden.dx;
            Ren.dy = -Ren.dy;
            Caden.dy = -Caden.dy;
        }

        if (Ren.hitBox.intersects(Gideon.hitBox)) {
            System.out.println("DEAD!!!");
            Ren.dx = -Ren.dx;
            Gideon.dx = -Gideon.dx;
            Ren.dy = -Ren.dy;
            Gideon.dy = -Gideon.dy;
        }

        if (Caden.hitBox.intersects(Jackson.hitBox)) {
            System.out.println("DEAD!!!");
            Caden.dx = -Caden.dx;
            Jackson.dx = -Jackson.dx;
            Caden.dy = -Caden.dy;
            Jackson.dy = -Jackson.dy;
        }
        if (Caden.hitBox.intersects(Gideon.hitBox)) {
            System.out.println("DEAD!!!");
            Caden.dx = -Caden.dx;
            Gideon.dx = -Gideon.dx;
            Caden.dy = -Caden.dy;
            Gideon.dy = -Gideon.dy;
        }

        if (Gideon.hitBox.intersects(Jackson.hitBox)) {
            System.out.println("DEAD!!!");
            Gideon.dx = -Gideon.dx;
            Jackson.dx = -Jackson.dx;
            Caden.dy = -Caden.dy;
            Jackson.dy = -Jackson.dy;
        }


    }

   //Pauses or sleeps the computer for the amount specified in milliseconds
   public void pause(int time ){
   		//sleep
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {

			}
   }

   //Graphics setup method
   private void setUpGraphics() {
      frame = new JFrame("Application Template");   //Create the program window or frame.  Names it.

      panel = (JPanel) frame.getContentPane();  //sets up a JPanel which is what goes in the frame
      panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));  //sizes the JPanel
      panel.setLayout(null);   //set the layout

      // creates a canvas which is a blank rectangular area of the screen onto which the application can draw
      // and trap input events (Mouse and Keyboard events)
      canvas = new Canvas();
      canvas.setBounds(0, 0, WIDTH, HEIGHT);
      canvas.setIgnoreRepaint(true);

      panel.add(canvas);  // adds the canvas to the panel.

      // frame operations
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //makes the frame close and exit nicely
      frame.pack();  //adjusts the frame and its contents so the sizes are at their default or larger
      frame.setResizable(false);   //makes it so the frame cannot be resized
      frame.setVisible(true);      //IMPORTANT!!!  if the frame is not set to visible it will not appear on the screen!

      // sets up things so the screen displays images nicely.
      canvas.createBufferStrategy(2);
      bufferStrategy = canvas.getBufferStrategy();
      canvas.requestFocus();
      System.out.println("DONE graphic setup");

   }


	//paints things on the screen using bufferStrategy
	private void render() {
		Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
		g.clearRect(0, 0, WIDTH, HEIGHT);

      //draw the image of the astronaut
       g.drawImage(BackgroundImage,0,0,WIDTH,HEIGHT,null);
        if (Toby.isAlive==true){
            g.drawImage(TyrannicalToby,Toby.xpos, Toby.ypos,Toby.width,Toby.height,null);
        }


        if (Niam.isAlive==true){
            g.drawImage(NattyNiam,Niam.xpos, Niam.ypos, Niam.width,Niam.height,null);
        }
        g.drawRect(Niam.hitbox.x,Niam.ypos, Niam.width,Niam.height);

        if (Gideon.isAlive==true){
            g.drawImage(GrittyGideon,Gideon.xpos, Gideon.ypos,Gideon.width,Gideon.height,null);

        }

        g.drawImage(RobustRen,Ren.xpos, Ren.ypos,Ren.width,Ren.height,null);
        g.drawImage(JovialJackson,Jackson.xpos, Jackson.ypos,Jackson.width,Jackson.height,null);
        g.drawImage(CockyCaden,Caden.xpos, Caden.ypos,Caden.width,Caden.height,null);
        g.drawRect(Toby.hitBox.x,Toby.hitBox.y,Toby.hitBox.width, Toby.hitBox.height);


		g.dispose();

		bufferStrategy.show();
	}
}