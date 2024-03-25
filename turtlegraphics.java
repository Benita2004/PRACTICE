package oop;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Polygon;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import uk.ac.leedsbeckett.oop.LBUGraphics;

public class GraphicSystems extends LBUGraphics
{
    public static void main(String[] args)
    {
            new GraphicSystems(); //create instance of class that extends LBUGraphics (could be separate class without main), gets out of static context
    }

    public GraphicSystems()
	 {
             JFrame MainFrame = new JFrame();                //create a frame to display the turtle panel on
             MainFrame.setLayout(new FlowLayout());  //not strictly necessary
             MainFrame.add(this);                                    //"this" is this object that extends turtle graphics so we are adding a turtle graphics panel to the frame
             MainFrame.pack();                                               //set the frame to a size we can see
             MainFrame.setVisible(true);                             //now display it
             reset();
             penDown();
                                                             //call the LBUGraphics about method to display version information.
             setPenColour(Color.WHITE);
             setBackground_Col(new Color(139,0,0));
             displayMessage("Hi this is Benita's OOP assignment");
             clear();
             penDown();
              
	 }
    

     Boolean imgSaved = false;
     ArrayList<String> commands = new ArrayList<>();

     @Override
     public void processCommand(String Command)
     {
        // TODO Auto-generated method stub
		Command=Command.toLowerCase();//allows user input upper case and lower case letters
		String[]Command_Split =Command.split(" ");//splits to enables capture of numeric values
        int Degree;


        try 
            {
                commands.add(Command);
                if (Command_Split[0].equals("about"))
                {
                    if (Command_Split.length > 1)
                    {
                        
                        System.out.println("please enter a valid command");
                        return;
                    }
                    super.about();
                    
                    
                }
                else if(Command_Split.length ==  1 && Command_Split[0].equals("overideabout")) 
                {
                	about();
                	displayMessage("Hi i'm Baridule Benita Aalo");
                	
                }
                else if (Command_Split[0].equals("penup")) //pen is up
                {
                    if (Command_Split.length > 1)
                    {
                        
                        System.out.println("please enter a valid command");
                        displayMessage("Please enter a valid command");
                        return;
                    }
                    penUp();
                    System.out.println("Pen is up");
                    return;
                }
                else if (Command_Split[0].equals("pendown"))
                {
                    if (Command_Split.length > 1)
                    {
                        
                        System.out.println("please enter a valid command");
                        displayMessage("Please enter a valid command");
                        return;
                    }
                    penDown();
                    System.out.println("Pen is down");
                    return;
                }
                else if (Command_Split[0].equals("forward"))
                {
                    if (Command_Split.length < 2)
                    {
                        displayMessage("Command should have a parameter.");
                        commands.remove(commands.size() - 1);//this checks if the user has entered a valid parameter and the length of the array is less than two it removes the last command
                        return;
                    }

                    if (Command_Split.length > 2)
                    {
                        
                        System.out.println("please enter a valid command");
                        displayMessage("Please enter a valid command");//displays the message 
                        return;
                    }

                    Degree = Integer.valueOf(Command_Split[1]);

                    if (Degree < 0)
                    {
                        displayMessage("Parameter should not be negative.");//does not allow a user enter a negative value for degree
                        commands.remove(commands.size() - 1);//removes that particular command from the list of commands that will save
                        return;
                    }

                    forward(Degree);
                    return;
                }
                else if (Command_Split[0].equals("backward"))
                {
                    if (Command_Split.length < 2)
                    {
                        displayMessage("Command should have a parameter.");//ensures user enters a parameter after the backward command
                        commands.remove(commands.size() - 1);//removes that particular command from the list of commands that will save
                        return;
                    }

                    if (Command_Split.length > 2)
                    {
                        
                        System.out.println("please enter a valid command");
                        displayMessage("Please enter a valid command");
                        return;
                    }

                    Degree =Integer.valueOf(Command_Split[1]);	

                    if (Degree < 0)
                    {
                        displayMessage("Parameter should not be negative.");//does not allow a user enter a negative value for degree
                        commands.remove(commands.size() - 1);//removes that particular command from the list of commands that will save
                        return;
                    }

                    forward(-Degree);
                    return;
                }
                else if (Command_Split[0].equals("turnleft"))
                {
                    if (Command_Split.length < 2)//displays error if the user enters forward without a parameter
                    {
                        displayMessage("Command should have a parameter.");
                        commands.remove(commands.size() - 1);
                        return;
                    }

                    if (Command_Split.length > 2)
                    {
                        
                        System.out.println("please enter a valid command");
                        displayMessage("Please enter a valid command");
                        return;
                    }

                    Degree =Integer.valueOf(Command_Split[1]);

                    if (Degree < 0)
                    {
                        displayMessage("Parameter should not be negative.");
                        commands.remove(commands.size() - 1);
                        return;
                    }

                    turnLeft(Degree);
                    return;
                }
                else if (Command_Split[0].equals("turnright"))
                {
                    if (Command_Split.length < 2)//displays error if the user enters forward without a parameter
                    {
                        displayMessage("Command should have a parameter.");
                        commands.remove(commands.size() - 1);
                        return;
                    }

                    if (Command_Split.length > 2)
                    {
                        
                        System.out.println("please enter a valid command");
                        displayMessage("Please enter a valid command");
                        return;
                    }

                    Degree =Integer.valueOf(Command_Split[1]);

                    if (Degree < 0)
                    {
                        displayMessage("Parameter should not be negative.");//checks that user does not enter a negative value for degree
                        commands.remove(commands.size() - 1);
                        return;
                    }

                    turnRight(Degree);
                    return;
                }
                else if (Command_Split[0].equals("green"))
                {
                    if (Command_Split.length > 1)
                    {
                        
                        System.out.println("please enter a valid command");
                        displayMessage("Please enter a valid command");
                        return;
                    }
                    setPenColour(Color.green);
                    displayMessage("Pen Colour has been set to green");
                    return;
                }
                else if (Command_Split[0].equals("red"))
                {
                    if (Command_Split.length > 1)
                    {
                        
                        System.out.println("please enter a valid command");
                        displayMessage("Please enter a valid command");
                        return;
                    }
                    setPenColour(Color.red);
                    displayMessage("Pen Colour has been set to red");
                    return;
                }
                else if (Command_Split[0].equals("black"))
                {
                    if (Command_Split.length > 1)
                    {
                        
                        System.out.println("please enter a valid command");
                        displayMessage("Please enter a valid command");
                        return;
                    }
                    setPenColour(Color.black);
                    displayMessage("Pen Colour has been set to black");
                    return;
                }
                else if (Command_Split[0].equals("white"))
                {
                    if (Command_Split.length > 1)
                    {
                        
                        System.out.println("please enter a valid command");
                        displayMessage("Please enter a valid command");
                        return;
                    }
                    setPenColour(Color.white);
                    displayMessage("Pen Colour has been set to white");
                    return;
                }
                else if (Command_Split[0].equals("reset"))//this is to reset the turtle to its original position 
                {
                    if (Command_Split.length > 1)
                    {
                        
                        System.out.println("please enter a valid command");
                        displayMessage("Please enter a valid command");
                        return;
                    }
                    reset();
                    displayMessage("System has been reset");	
                    return;
                }
                else if (Command_Split[0].equals("clear"))
                {
                    if (Command_Split.length > 1)
                    {
                        
                        System.out.println("please enter a valid command");
                        displayMessage("Please enter a valid command");
                        return;
                    }
                    clear();
                    displayMessage("System is clear");
                    return;
                }
                else if (Command_Split[0].equals("save"))
                {
                    commands.remove(commands.size() - 1);//removes that particular command from the list of commands that will save
                    if (Command_Split.length > 3)
                    {
                        
                        System.out.println("please enter a valid command");
                        displayMessage("Please enter a valid command");
                        return;
                    }
                    imgSaved = doImageSave(Command_Split);
                    reset();
                    clear();
                    penDown();

                    return;
                }
                else if (Command_Split[0].equals("load"))
                {
                    commands.remove(commands.size() - 1);//removes that particular command from the list of commands that will save
                    reset();
                    clear();
                    penDown();//allows user reset, clear and put penDown after loading the image
                    if (Command_Split.length > 3)
                    {
                        
                        System.out.println("please enter a valid command");
                        displayMessage("Please enter a valid command");
                        return;
                    }
                    if (!doImageLoad(Command_Split))
                    {
                        return;
                    }
                }
                else if (Command_Split[0].equals("square"))
                {
                    if (Command_Split.length < 2)//user must input a parameter while passing square command
                    {
                        displayMessage("Command should have a parameter.");
                        commands.remove(commands.size() - 1);
                        return;
                    }

                    if (Command_Split.length > 2)//if user enters value more than two elements in the array it should report an error
                    {
                        
                        System.out.println("please enter a valid command");
                        displayMessage("Please enter a valid command");
                        return;
                    }

                    Degree = Integer.parseInt(Command_Split[1]);

                    square(Degree);
                    return;
                }
                else if (Command_Split[0].equals("triangle"))
                {
                    if (Command_Split.length < 2)//checks that the length of the Command.split array is less than 2
                    {
                        displayMessage("Command should have a parameter.");
                        commands.remove(commands.size() - 1);//removes that particular command from the list of commands that will save
                        return;
                    }

                    if (Command_Split.length > 4)
                    {
                        
                        System.out.println("please enter a valid command");//if a user enters parameters greater than 4 it reports an error because the user has entered too many parameters
                        displayMessage("Please enter a valid command");
                        return;
                    }

                    if (Command_Split.length == 2)//checks if the user enters a parameter for the triangle
                    {
                        Degree = Integer.parseInt(Command_Split[1]);
                        triangle(Degree);
                        return;
                    }

                    if (Command_Split.length == 4)//means user provided the length of the triangle sides as parameters and this creates a complex triangle as requested in the specification
                    {
                        int l1 = Integer.parseInt(Command_Split[1]);
                        int l2 = Integer.parseInt(Command_Split[2]);
                        int l3 = Integer.parseInt(Command_Split[3]);
                        triangle(l1, l2, l3);
                        return;
                    }
                }
                else if (Command_Split[0].equals("penwidth"))//changes the width of the pen to the desired degree
                {
                    if (Command_Split.length < 2)//checks that the length of the Command.split array is less than 2 and reports an error
                    {
                        displayMessage("Command should have a parameter.");
                        commands.remove(commands.size() - 1);
                        return;
                    }

                    if (Command_Split.length > 2)
                    {
                        
                        System.out.println("please enter a valid command");
                        displayMessage("Please enter a valid command");
                        return;
                    }

                    Degree = Integer.parseInt(Command_Split[1]);

                    penWidth(Degree);
                    return;
                }
                else if (Command_Split[0].equals("pencolour"))
                {
                    if (Command_Split.length < 2)
                    {
                        displayMessage("Command should have a parameter.");
                        commands.remove(commands.size() - 1);
                        return;
                    }

                    if (Command_Split.length != 4)//using the r,g, b, and the penColour the commands passed are 4 so this checks if the command entered if valid and reports an error if it does not meet the requirement
                    {
                        
                        System.out.println("please enter a valid command");
                        displayMessage("Please enter a valid command");
                        return;
                    }

                    int r = Integer.parseInt(Command_Split[1]);
                    int g = Integer.parseInt(Command_Split[2]);
                    int b = Integer.parseInt(Command_Split[3]);

                    penColour(r, g, b);
                }
                else 
                {
                    displayMessage("Enter a valid command");
                    commands.remove(commands.size() - 1);
                    return;
                }

            } 
            catch (NumberFormatException e) //checks if user enters an integer and if not it should report an error
            {
                displayMessage("Parameter entered must be an Integer");
				return;
            }

        

     }

     private Boolean doImageSave(String[] Command_Split) {
        if (Command_Split.length < 3)//this command is set to take 3 parameters to save the image so it return an error if it is not met
        {
            displayMessage("Parameters must be 3.");
            return false;
        }
        if (Command_Split[2].toLowerCase().equals("png") || Command_Split[2].toLowerCase().equals("jpeg"))
        {
            File outputfile = new File(Command_Split[1]+"."+Command_Split[2]);
            try 
            {
                ImageIO.write(getBufferedImage(), Command_Split[2], outputfile); //method to write current image into file
                try 
                {
                    FileWriter commandsFileWriter = new FileWriter("commands" + Command_Split[1] + ".txt");//creates a new file writer to write the commands into a text file
                    for (String command: commands)
                    {
                        commandsFileWriter.write(command + "\n");
                    }
                    commandsFileWriter.close();
                    commands.clear();
                    displayMessage("Image and commands saved successfully!");
                    return true;
                }
                catch (IOException e)
                {
                    displayMessage("Error Writing to commands file");
                    return false;
                }
            }
            catch (IOException e) 
            {
                displayMessage("Error Writing File");
                return false;
            }
        }

        else
        {
            displayMessage("Image format can only be png or jpeg");//if it is not png or jpeg it should report an error
            return false;
        }
        
    }

     
    public Boolean doImageLoad(String[] Command_Split)//this defines a method that takes an array Command_Split and return a boolean value
    {
        if (Command_Split.length < 3)
        {
            displayMessage("Parameters must be 3.");
            return false;
        }

        if (!imgSaved)
        {
            displayMessage("No image has been saved.");//error message no image saved if it has not been saved
            return false;
        }

        if (Command_Split[2].toLowerCase().equals("png") || Command_Split[2].toLowerCase().equals("jpeg"))
        {
            BufferedImage img = null;
            
            try 
            {
                img = ImageIO.read(new File(Command_Split[1] + "." + Command_Split[2]));

                BufferedReader reader;

                try 
                {
                    reader = new BufferedReader(new FileReader("commands" + Command_Split[1] + ".txt"));
                    String line = reader.readLine().replace("\n", "");
                    this.processCommand(line);

                    while (line != null) {
                        // read next line
                        line = reader.readLine();
                        if (line == null)
                        {
                            break;
                        }
                        line = reader.readLine().replace("\n", "");
                        this.processCommand(line);
                        commands.add(line);
                        
                    }
                
                    displayMessage("Image and Commands loaded successfully!");
                    reader.close();
                    System.out.println(commands);
                    return true;
                } 
                catch (Exception e) 
                {
                    displayMessage("Error Reading Commands File");
                    return false;
                }
            }
            catch (Exception e) 
            {
                displayMessage("Error Reading File");
                return false;
            }
        }

        else
        {
            displayMessage("Image format can only be png or jpeg");
            return false;
        }
        
        
    }

    
    
    public void square(int length)
    {
        forward(length);
        turnLeft(90);
        forward(length);
        turnLeft(90);
        forward(length);
        turnLeft(90);
        forward(length);
        reset();
    }

    public void penColour(int r, int g, int b)//this line of code allows the user create an RGB  color by inputing 3 parameters
    {
        Color newColor = new Color(r, g, b);
        setPenColour(newColor);
        
    }

    public void penWidth(int width)//this takes a width for the pen and allows use
    {
        setStroke(width);
    }

    public void triangle(int length)
    {
        penUp();
        forward(50);
        penDown();
        turnLeft(60);
        forward(length);
        turnRight(120);
        forward(length);
        turnRight(120);
        forward(length);
        reset();
        
    }
//This is a method in a class that can be used to draw a triangle using the current position of the pen.it takes three parameters 
    public void triangle(int length1, int length2, int length3) 
    {

        int x1, x2, x3, y1, y2, y3;

        int ogX = getxPos();
        int ogY = getyPos();

        x1 = ogX;
        y1 = ogY;
        x2 = ogX;
        setyPos(y1 + length1);
        y2 = getyPos();
        setxPos(x1 + length3);
        double temp_y = (Math.pow(length1, 2) + Math.pow(length2, 2) - Math.pow(length3, 2)) / (2 * length1);
        y3 = (int) temp_y;
        setyPos(y3);
        double temp_x = Math.sqrt((Math.pow(length2, 2) - Math.pow(y3, 2)));
        x3 = (int) temp_x;
        setxPos(x3);

        Polygon tri = new Polygon(new int[] {x1, x2, x3}, new int[] {y1, y2, y3}, 3);

        Graphics g = getGraphics2DContext();

        g.setColor(Color.red);

        g.drawPolygon(tri);

        reset();
        penDown();
            
        }
}
				
				
				
			
										
					
					
				
				
		
		

