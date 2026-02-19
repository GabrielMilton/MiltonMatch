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
import org.w3c.dom.html.HTMLDOMImplementation;

import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.*;
import java.sql.SQLOutput;
import javax.swing.*;
//these two are here to be able to dispaly text
import java.awt.Color;
import java.awt.Font;



//todo: ADD THE WARPING FOR FULL CREDIT ADD IT TO A POWERUP
//todo: ADD COMMENTS!!!!!!!!!
//todo: make altbackground varible make if stament like: if this image is alive and the rest are dead then this backgorund and text will show up.
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
    public Image NiamBackground;
    public Image TobyBackground;
    public Image RenBackground;
    public Image Cadenackground;
    public Image GideonBackground;
    public Image JacksonBackground;

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
        NiamBackground = Toolkit.getDefaultToolkit().getImage("200_d.gif");
        TobyBackground = Toolkit.getDefaultToolkit().getImage("Toby's.Gif.gif");


        Niam = new NattyNiam(300,560);
		Ren = new RobustRen(450,221);
        Toby = new TyrannicalToby(1000,500);
        Jackson = new JovialJackson(900,50);
        Caden = new CockyCaden(10,450);
        Gideon = new GrittyGideon(600,580);
        //This dispays the "power" of each charachter on to the terminal
        System.out.println("Niam's power:" + Niam.Power);
        System.out.println("Toby's power:" + Toby.Power);
        System.out.println("Gideon's power:" + Gideon.Power);
        System.out.println("Caden's power:" + Caden.Power);
        System.out.println("Ren's power:" + Ren.Power);
        System.out.println("Jackson's power:" + Jackson.Power);



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
//These if statements check if two charachters intercest with eachother and if they do it checks their power, whose ever power is bigger makes the other dissapear
        if (Niam.hitbox.intersects(Ren.hitBox)) {
            System.out.println("DEAD!!!");
            Niam.dx = -Niam.dx;
            Ren.dx = -Ren.dx;
            Niam.dy = -Niam.dy;
            Ren.dy = -Ren.dy;
            if (Niam.Power>Ren.Power){
                Niam.iscrasinhg = true;
                Ren.isAlive = false;
                System.out.println("Ren died");
                Ren.xpos =1000000;
                Ren.ypos =2000;
            }
            if (Niam.Power<Ren.Power){
                Ren.iscrasinhg = true;
                Niam.isAlive = false;
                System.out.println("Niam died");
                Niam.xpos = 103572400;
                Niam.ypos = 1000003420;
            }
            // This if stamtents is if both of their powers are equal then the power restets for one of them
            if (Niam.Power==Ren.Power){
                Niam.Power = (int)(Math.random()*10)+1;
            }
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
                System.out.println("Ren died");
                Gideon.xpos =1000000;
                Gideon.ypos =2000;
            }
            if (Niam.Power<Gideon.Power){
                Gideon.iscrasinhg = true;
                Niam.isAlive = false;
                System.out.println("Niam died");
                Niam.xpos = 103572400;
                Niam.ypos = 1000003420;
            }
            if (Niam.Power==Gideon.Power){
                Gideon.Power = (int)(Math.random()*10)+1;
            }
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
            if (Niam.Power>Caden.Power){
                Niam.iscrasinhg = true;
                Caden.isAlive = false;
                System.out.println("Caden died");
                Caden.xpos = 10000900;
                Caden.ypos = 100300;
            }
            if (Niam.Power<Caden.Power){
                Caden.iscrasinhg = true;
                Niam.isAlive = false;
                System.out.println("Niam died");
                Niam.xpos = 194832;
                Niam.ypos = 20000;
            }
            if (Niam.Power==Caden.Power){
                Niam.Power = (int)(Math.random()*10)+1;
            }
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
                Toby.xpos = 23906842;
                Toby.ypos = 79546440;
            }
            if (Toby.Power>Niam.Power) {
                Toby.iscrasinhg = true;
                Niam.isAlive = false;
                System.out.println("Niam died");
                Niam.xpos = 194832;
                Niam.ypos = 20000;
            }
            if (Niam.Power==Toby.Power){
                Niam.Power = (int)(Math.random()*10)+1;
            }
        }

        if (Niam.hitbox.intersects(Jackson.hitBox)) {
            System.out.println("DEAD!!!");
            Niam.dx = -Niam.dx;
            Jackson.dx = -Jackson.dx;
            Niam.dy = -Niam.dy;
            Jackson.dy = -Jackson.dy;
            if (Niam.Power>Jackson.Power){
                Niam.iscrasinhg = true;
                Jackson.isAlive = false;
                System.out.println(" Jackson's died");
                Jackson.width = 1;
                Jackson.height =1;
                Jackson.xpos = 284352832;
                Jackson.ypos = 62364592;
            }
            if (Niam.Power<Jackson.Power) {
                Jackson.iscrasinhg = true;
                Niam.isAlive = false;
                System.out.println("Niam died");
                Niam.xpos = 194832;
                Niam.ypos = 20000;
            }
            if (Niam.Power==Jackson.Power){
                Niam.Power = (int)(Math.random()*10)+1;
                Jackson.Power = (int)(Math.random()*10)+1;
            }

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
                Gideon.xpos = 10235348;
                Gideon.ypos = 439682398;
            }
            if (Gideon.Power>Niam.Power){
                Gideon.iscrasinhg = true;
                Niam.isAlive = false;
                System.out.println("Niam died");
                Niam.xpos = 194832;
                Niam.ypos = 20000;
                if (Gideon.Power==Niam.Power){
                    Niam.Power = (int)(Math.random()*10)+1;
                    Gideon.Power = (int)(Math.random()*10)+1;
                }
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
            if (Toby.Power>Ren.Power){
                Toby.iscrasinhg = true;
                Ren.isAlive = false;
                System.out.println("Ren died");
                Ren.xpos =1000000;
                Ren.ypos =2000;

            }
            if (Toby.Power<Ren.Power){
                Ren.iscrasinhg = true;
                Toby.isAlive = false;
                System.out.println("Toby died");
                Toby.xpos = 23906842;
                Toby.ypos = 79546440;
            }
            if (Toby.Power==Ren.Power){
                Toby.Power = (int)(Math.random()*10)+1;
                Ren.Power = (int)(Math.random()*10)+1;
            }
        }

        if (Toby.hitBox.intersects(Caden.hitBox)) {
            System.out.println("DEAD!!!");
            Toby.dx = -Toby.dx;
            Caden.dx = -Caden.dx;
            Toby.dy = -Toby.dy;
            Caden.dy = -Caden.dy;
            if (Toby.Power>Caden.Power){
                Toby.iscrasinhg = true;
                Caden.isAlive = false;
                System.out.println("Caden died");
                Caden.xpos = 13958124;
                Caden.ypos = 143000;
            }
            if (Toby.Power<Caden.Power){
                Caden.iscrasinhg = true;
                Toby.isAlive = false;
                System.out.println("Toby died");
                Toby.xpos = 23906842;
                Toby.ypos = 79546440;
            }
            if (Toby.Power==Caden.Power){
                Toby.Power = (int)(Math.random()*10)+1;
                Caden.Power = (int)(Math.random()*10)+1;
            }
        }

        if (Toby.hitBox.intersects(Jackson.hitBox)) {
            System.out.println("DEAD!!!");
            Toby.dx = -Toby.dx;
            Jackson.dx = -Jackson.dx;
            Toby.dy = -Toby.dy;
            Jackson.dy = -Jackson.dy;
            if (Toby.Power>Jackson.Power){
                Toby.iscrasinhg = true;
                Jackson.isAlive = false;
                System.out.println("Jackson died");
                Jackson.width = 1;
                Jackson.height =1;
                Jackson.xpos = 28352832;
                Jackson.ypos = 623592;
            }
            if (Toby.Power<Jackson.Power){
                Jackson.iscrasinhg = true;
                Toby.isAlive = false;
                System.out.println("Toby died");
                Toby.xpos = 23906842;
                Toby.ypos = 79546440;
            }
            if (Toby.Power==Jackson.Power){
                Toby.Power = (int)(Math.random()*10)+1;
                Jackson.Power = (int)(Math.random()*10)+1;
            }
        }



        if (Toby.hitBox.intersects(Gideon.hitBox)) {
            System.out.println("DEAD!!!");
            Toby.dx = -Toby.dx;
            Gideon.dx = -Gideon.dx;
            Toby.dy = -Toby.dy;
            Gideon.dy = -Gideon.dy;
            if (Toby.Power>Gideon.Power){
                Toby.iscrasinhg = true;
                Gideon.isAlive = false;
                System.out.println("Gideon died");
                Gideon.xpos = 10235348;
                Gideon.ypos = 439682398;
            }
            if (Toby.Power<Gideon.Power){
                Gideon.iscrasinhg = true;
                Toby.isAlive = false;
                System.out.println("Niam died");
                Toby.xpos = 23906842;
                Toby.ypos = 79546440;
            }
            if (Toby.Power==Gideon.Power) {
                Toby.Power = (int) (Math.random() * 10) + 1;
                Gideon.Power = (int) (Math.random() * 10) + 1;
            }
        }

        if (Ren.hitBox.intersects(Jackson.hitBox)) {
            System.out.println("DEAD!!!");
            Ren.dx = -Ren.dx;
            Jackson.dx = -Jackson.dx;
            Ren.dy = -Ren.dy;
            Jackson.dy = -Jackson.dy;
            if (Ren.Power>Jackson.Power){
                Ren.iscrasinhg = true;
                Jackson.isAlive = false;
                Jackson.width = 1;
                Jackson.height =1;
                Jackson.dx = 1;
                System.out.println("Jackson died");
                Jackson.xpos = 28352832;
                Jackson.ypos = 623592;
            }
            if (Ren.Power<Jackson.Power){
                Jackson.iscrasinhg = true;
                Ren.isAlive = false;
                System.out.println("Ren died");
            }
            if (Ren.Power==Jackson.Power){
                Ren.Power = (int)(Math.random()*10)+1;
                Jackson.Power = (int)(Math.random()*10)+1;
            }
        }

        if (Ren.hitBox.intersects(Caden.hitBox)) {
            System.out.println("DEAD!!!");
            Ren.dx = -Ren.dx;
            Caden.dx = -Caden.dx;
            Ren.dy = -Ren.dy;
            Caden.dy = -Caden.dy;
            if (Ren.Power>Caden.Power){
                Ren.iscrasinhg = true;
                Caden.isAlive = false;
                System.out.println("Caden died");
                Caden.xpos = 13958124;
                Caden.ypos = 143000;
            }
            if (Ren.Power<Caden.Power){
                Caden.iscrasinhg = true;
                Ren.isAlive = false;
                System.out.println("Ren died");
                Ren = new RobustRen(100200000,1000000);
            }
            if (Ren.Power==Caden.Power){
                Ren.Power = (int)(Math.random()*10)+1;
                Caden.Power = (int)(Math.random()*10)+1;
            }
        }

        if (Ren.hitBox.intersects(Gideon.hitBox)) {
            System.out.println("DEAD!!!");
            Ren.dx = -Ren.dx;
            Gideon.dx = -Gideon.dx;
            Ren.dy = -Ren.dy;
            Gideon.dy = -Gideon.dy;
            if (Ren.Power>Gideon.Power){
                Ren.iscrasinhg = true;
                Gideon.isAlive = false;
                System.out.println("Gideon died");
                Gideon.xpos = 10235348;
                Gideon.ypos = 439682398;
            }
            if (Ren.Power<Gideon.Power){
                Gideon.iscrasinhg = true;
                Ren.isAlive = false;
                System.out.println("Ren died");
                Ren.xpos =1000000;
                Ren.ypos =2000;
            }
            if (Ren.Power==Gideon.Power){
                Ren.Power = (int)(Math.random()*10)+1;
                Gideon.Power = (int)(Math.random()*10)+1;
            }
        }

        if (Caden.hitBox.intersects(Jackson.hitBox)) {
            System.out.println("DEAD!!!");
            Caden.dx = -Caden.dx;
            Jackson.dx = -Jackson.dx;
            Caden.dy = -Caden.dy;
            Jackson.dy = -Jackson.dy;
            if (Caden.Power>Jackson.Power){
                Caden.iscrasinhg = true;
                Jackson.isAlive = false;
                Jackson.width = 1;
                Jackson.height =1;
                Jackson.dx = 1;
                System.out.println("Jackson died");
                Jackson.xpos = 28352832;
                Jackson.ypos = 623592;
            }
            if (Caden.Power<Jackson.Power){
                Jackson.iscrasinhg = true;
                Ren.isAlive = false;
                System.out.println("Jacko died");
                Jackson.xpos = 28352832;
                Jackson.ypos = 623592;
            }
            if (Caden.Power==Jackson.Power){
                Caden.Power = (int)(Math.random()*10)+1;
                Jackson.Power = (int)(Math.random()*10)+1;
            }
        }
        if (Caden.hitBox.intersects(Gideon.hitBox)) {
            System.out.println("DEAD!!!");
            Caden.dx = -Caden.dx;
            Gideon.dx = -Gideon.dx;
            Caden.dy = -Caden.dy;
            Gideon.dy = -Gideon.dy;
            if (Caden.Power>Gideon.Power){
                Caden.iscrasinhg = true;
                Gideon.isAlive = false;
                System.out.println("Gideon died");
                Gideon.xpos = 10235348;
                Gideon.ypos = 439682398;
            }
            if (Caden.Power<Gideon.Power){
                Gideon.iscrasinhg = true;
                Caden.isAlive = false;
                System.out.println("Ren died");
                Caden.xpos = 13958124;
                Caden.ypos = 143000;
            }
            if (Caden.Power==Gideon.Power){
                Caden.Power = (int)(Math.random()*10)+1;
                Gideon.Power = (int)(Math.random()*10)+1;
            }
        }

        if (Gideon.hitBox.intersects(Jackson.hitBox)) {
            System.out.println("DEAD!!!");
            Gideon.dx = -Gideon.dx;
            Jackson.dx = -Jackson.dx;
            Gideon.dy = -Gideon.dy;
            Jackson.dy = -Jackson.dy;
            if (Gideon.Power>Jackson.Power){
                Gideon.iscrasinhg = true;
                Jackson.isAlive = false;
                Jackson.width = 1;
                Jackson.height =1;
                Jackson.dx = 1;
                System.out.println("Jackson died");
                Jackson.xpos = 28352832;
                Jackson.ypos = 623592;
            }
            if (Gideon.Power<Jackson.Power){
                Jackson.iscrasinhg = true;
                Gideon.isAlive = false;
                System.out.println("Gideon died");
                Gideon.xpos = 10235348;
                Gideon.ypos = 439682398;
            }
            if (Gideon.Power==Jackson.Power){
                Gideon.Power = (int)(Math.random()*10)+1;
                Jackson.Power = (int)(Math.random()*10)+1;
            }
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

      //draws the image of the charachters

       g.drawImage(BackgroundImage,0,0,WIDTH,HEIGHT,null);
        if (Toby.isAlive==true){
            g.drawImage(TyrannicalToby,Toby.xpos, Toby.ypos,Toby.width,Toby.height,null);
        }

            g.drawImage(NattyNiam,Niam.xpos, Niam.ypos, Niam.width,Niam.height,null);
        g.drawRect(Niam.hitbox.x,Niam.ypos, Niam.width,Niam.height);

        if (Gideon.isAlive==true){
            g.drawImage(GrittyGideon,Gideon.xpos, Gideon.ypos,Gideon.width,Gideon.height,null);
        }
        System.out.println(Toby.isAlive);
        if(Niam.isAlive == true&&Gideon.isAlive==false&& Toby.isAlive==false&&Ren.isAlive==false&&Caden.isAlive==false&&Jackson.isAlive==false) {
        g.drawImage(NiamBackground,0,0,WIDTH,HEIGHT,null);
        g.setColor(Color.RED);
            g.setFont(new Font("Arial",Font.BOLD,100));
            g.drawString("Niam Won!!!",500,400);
            System.out.println("won");
            Niam.width = 250;
            Niam.height = 250;
            g.drawImage(NattyNiam,Niam.xpos, Niam.ypos, Niam.width,Niam.height,null);
        }
        //these if staments are for the winner of the match, it checks to see if everyone else is dead
        // If they are the only one alive and everyone is dead, than a custom background and text apears on the screen.(I didn't have enough time to do all of them but was able to do a cuppole)
        if(Toby.isAlive == true&&Niam.isAlive==false&& Gideon.isAlive==false&&Ren.isAlive==false&&Caden.isAlive==false&&Jackson.isAlive==false) {
            g.drawImage(NiamBackground,0,0,WIDTH,HEIGHT,null);
            g.setColor(Color.YELLOW);
            g.setFont(new Font("Arial",Font.BOLD,100));
            g.drawString("Toby Won!!!",500,400);
            System.out.println("won");
            Toby.width = 250;
            Toby.height = 250;
            g.drawImage(TyrannicalToby,Toby.xpos, Toby.ypos, Toby.width,Toby.height,null);
        }
        if(Niam.isAlive == true&&Gideon.isAlive==false&& Toby.isAlive==false&&Ren.isAlive==false&&Caden.isAlive==false&&Jackson.isAlive==false) {
            g.drawImage(NiamBackground,0,0,WIDTH,HEIGHT,null);
            g.setColor(Color.RED);
            g.setFont(new Font("Arial",Font.BOLD,100));
            g.drawString("Niam Won!!!",500,400);
            System.out.println("won");
            Niam.width = 250;
            Niam.height = 250;
            g.drawImage(NattyNiam,Niam.xpos, Niam.ypos, Niam.width,Niam.height,null);
        }
        if(Caden.isAlive == true&&Gideon.isAlive==false&& Toby.isAlive==false&&Ren.isAlive==false&&Niam.isAlive==false&&Jackson.isAlive==false) {
            g.setColor(Color.RED);
            g.setFont(new Font("Arial",Font.BOLD,100));
            g.drawString("Caden Won!!!",500,400);
            System.out.println("won");
            Caden.width = 250;
            Caden.height = 250;
            g.drawImage(CockyCaden,Caden.xpos, Caden.ypos, Caden.width,Caden.height,null);
        }
        if(Gideon.isAlive == true&&Niam.isAlive==false&& Toby.isAlive==false&&Ren.isAlive==false&&Caden.isAlive==false&&Jackson.isAlive==false) {
            g.drawImage(NiamBackground,0,0,WIDTH,HEIGHT,null);
            g.setColor(Color.RED);
            g.setFont(new Font("Arial",Font.BOLD,100));
            g.drawString("Gideon Won!!!",500,400);
            System.out.println("won");
            Gideon.width = 250;
            Gideon.height = 250;
            g.drawImage(GrittyGideon,Gideon.xpos, Gideon.ypos, Gideon.width,Gideon.height,null);
        }
        if(Ren.isAlive == true&&Gideon.isAlive==false&& Toby.isAlive==false&&Niam.isAlive==false&&Caden.isAlive==false&&Jackson.isAlive==false) {
            g.setColor(Color.RED);
            g.setFont(new Font("Arial",Font.BOLD,100));
            g.drawString("Ren Won!!!",500,400);
            System.out.println("won");
            Ren.width = 250;
            Ren.height = 250;
            g.drawImage(RobustRen,Ren.xpos, Ren.ypos, Ren.width,Ren.height,null);
        }
        if(Jackson.isAlive == true&&Gideon.isAlive==false&& Toby.isAlive==false&&Ren.isAlive==false&&Caden.isAlive==false&&Niam.isAlive==false) {
            g.setColor(Color.RED);
            g.setFont(new Font("Arial",Font.BOLD,100));
            g.drawString("Jackson Won!!!",500,400);
            System.out.println("won");
            Jackson.width = 450;
            Jackson.height = 450;
            g.drawImage(JovialJackson,Jackson.xpos, Jackson.ypos, Jackson.width,Jackson.height,null);
        }
        g.drawImage(RobustRen,Ren.xpos, Ren.ypos,Ren.width,Ren.height,null);
        g.drawImage(JovialJackson,Jackson.xpos, Jackson.ypos,Jackson.width,Jackson.height,null);
        g.drawImage(CockyCaden,Caden.xpos, Caden.ypos,Caden.width,Caden.height,null);
        g.drawRect(Toby.hitBox.x,Toby.hitBox.y,Toby.hitBox.width, Toby.hitBox.height);


		g.dispose();

		bufferStrategy.show();
	}
}