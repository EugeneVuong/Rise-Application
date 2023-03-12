
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Menu extends JFrame implements ActionListener {
  private JPanel mainMenu;
  private JPanel mathMenu;
  private JFrame window;
  private Questions question;
  private Lesson lesson;
  static int width;
  static int height;
  
  /**
   * Initializes the JFrame
   */
  public Menu() {

    //Window Config
    width = 800;
    height = 600;
    window = new JFrame("Rise Client | Only way of learning");
    window.setLayout(null);
    window.setSize(width, height);
    window.setResizable(false);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    //Main Menu
    mainMenu = new JPanel();

    //Math Menu
    mathMenu = new JPanel();

    runMainMenuGUI();


  }

  
/**
 * Displays title screen and credits, and contains the code for the appearance.
 */
  public void runMainMenuGUI(){

    JLabel rise = new JLabel();

    try {
      ImageIcon logo = new ImageIcon("src/main/resources/images/rise_logo.png");
      Image riseIcon = logo.getImage();
      Image riseMod = riseIcon.getScaledInstance((int) (logo.getIconWidth()), ((int)logo.getIconHeight()), java.awt.Image.SCALE_SMOOTH);
      logo = new ImageIcon(riseMod);
      rise = new JLabel(logo);
      rise.setBounds(0, -((int)window.getHeight()/12), (int)window.getWidth(), (int)window.getHeight());
    } catch (Exception e){
      System.out.print("Rise Logo could not be found!");
    }

    //Rise Button Config
    JButton button = new JButton("Rise Up!");
    button.setForeground(Color.GRAY);
    button.setBackground(Color.WHITE);
    button.setFocusPainted(false);
    button.setFont(new Font("Dialog", Font.BOLD, 12));
    button.setBounds((int)window.getWidth()/2 - 100, ((int)window.getHeight()/2), 200, 40);
    button.setActionCommand("start");
    button.addActionListener(this);

    //Credits
    String fullText = "Made with <3 by Eugene Vuong, Nathan Tran, Naveen Jacob, Matthew Neng, Ethan Lau and Andrew Nguyen";    
    
    JLabel credits = new JLabel(fullText, JLabel.LEFT);
    credits.setFont(new Font("Ariel", Font.BOLD, 12));
    credits.setForeground(Color.WHITE);
    credits.setBounds(175, 540, (int)window.getWidth(), 20);
    
    //Names array
    String [] names = new String[6];
    String processed = "Made with <3 by Eugene Vuong, Nathan Tran, Matthew Neng, Naveen Jacob, Ethan Lau, Andrew Nguyen,";
    names[0] = fullText.substring(fullText.indexOf("Eugene Vuong"), fullText.indexOf(","));
    for(int i = 1; i < names.length; i++){
      processed = processed.substring(processed.indexOf(",") + 2);
      names[i] = processed.substring(0, processed.indexOf(","));
    }

    //Role List
    String roleList = "TEAM ROLES \nTeam Leader: " + names[0] + "\nQA Tester: " + names[1] + ", " + names[2] + "\nDevelopers: " + names[3] + ", " + names[4] + "\nSoftware Architect: " + names[5];
    
    JTextArea roles = new JTextArea(roleList, 50, 50);
    roles.setFont(new Font("Ariel", Font.BOLD, 12));
    roles.setForeground(Color.WHITE);
    roles.setBounds(0, 0, (int)window.getWidth(), 100);
    roles.setOpaque(false);
    roles.setEditable(false);


    //Background Label Config
    JLabel background = new JLabel();

    try {
      ImageIcon gradient = new ImageIcon("src/main/resources/images/Pure-CSS3-Gradient-Background-Animation.gif");
      //Scaled BG
      Image bgGradient = gradient.getImage();
      Image bgMod = bgGradient.getScaledInstance(width, height, Image.SCALE_DEFAULT);
      gradient = new ImageIcon(bgMod);
      background = new JLabel(gradient);
      background.setBounds(0, 0, (int)window.getWidth(), (int)window.getHeight());
    } catch (Exception e){
      System.out.print("Background Image could not be found!");
    }


    
    //JPanel 
    mainMenu.setBounds(0, 0, (int)window.getWidth(), (int)window.getHeight());
    mainMenu.setLayout(null);

    mainMenu.add(button);
    mainMenu.add(credits);
    mainMenu.add(roles);
    try{
      mainMenu.add(rise);
    }catch(Exception e){
      System.out.print("Rise Logo could not be loaded!");
    }

    try{
      mainMenu.add(background);
    }catch(Exception e){
      System.out.print("Background could not be loaded!");
    }

    
    //Windows Config
    window.add(mainMenu);
    window.validate();
    window.setVisible(true);

    mainMenu.setVisible(true);
  }
/**
 * Manages all the buttons for the main game and tutorials.
 */
  public void runMathMenuGUI(){
    //Panel
    mathMenu.setBounds(0, 0, (int)window.getWidth(), (int)window.getHeight());
    mathMenu.setLayout(null);

    //Panel of Buttons
    JPanel mathButtons = new JPanel();
    mathButtons.setBounds((int)window.getWidth()/2 - (int)window.getWidth()/4, (int)window.getHeight()/2 - (int)window.getHeight()/4, (int)window.getWidth()/2, (int)window.getHeight()/2);
    mathButtons.setLayout(new GridLayout(3, 2, 0, 0));
    
    

    //Background Label Config
    ImageIcon gradient = new ImageIcon("src/main/resources/images/bg_75.gif");

    //Scaled BG
    Image bgGradient = gradient.getImage();
    Image bgMod = bgGradient.getScaledInstance(width, height, Image.SCALE_DEFAULT);
    gradient = new ImageIcon(bgMod);

    
    JLabel background = new JLabel(gradient);
    background.setBounds(0, 0, (int)window.getWidth(), (int)window.getHeight());

    //Back Buttons
    JButton back = new JButton("Back");
    back.setForeground(Color.GRAY);
    back.setBackground(Color.WHITE);
    back.setFocusPainted(false);
    back.setFont(new Font("Dialog", Font.BOLD, 12));
    back.setBounds(0, 0, 100, 20);
    back.setActionCommand("back");
    back.addActionListener(this);

    //Math Buttons
    JButton addition = new JButton("Addition!");
    JButton subtraction = new JButton("Subtraction!");
    JButton multiplication = new JButton("Multiplication!");
    JButton division = new JButton("Division!");
    JButton factorial = new JButton("Factorial!");
    JButton tutorial = new JButton("Tutorials!");

    //Adding GUI
    mathMenu.add(back);
    mathButtons.add(tutorial);
    mathMenu.add(mathButtons);
    mathButtons.add(addition);
    mathButtons.add(subtraction);
    mathButtons.add(multiplication);
    mathButtons.add(division);
    mathButtons.add(factorial);
    
    
    mathMenu.add(background);

    
    window.add(mathMenu);

    addition.setActionCommand("addition");
    addition.addActionListener(this);
    tutorial.setActionCommand("tutorial");
    tutorial.addActionListener(this);
    subtraction.setActionCommand("subtraction");
    subtraction.addActionListener(this);
    multiplication.setActionCommand("multiplication");
    multiplication.addActionListener(this);
    division.setActionCommand("division");
    division.addActionListener(this);
    factorial.setActionCommand("factorial");
    factorial.addActionListener(this);
    
    mathMenu.setVisible(true);
  }
/**
 * Returns the menu frame
 * @return the menu JFrame
 */
  public JFrame getJFrame(){
    return this.window;
  }

  
  
/**
 * Manages all the event handlers for every button in this class
 */
  public void actionPerformed(ActionEvent evt) {
    if (evt.getActionCommand().equals("start")) {
      mainMenu.setVisible(false);
      runMathMenuGUI();
    }else if (evt.getActionCommand().equals("back")) {
      mathMenu.setVisible(false);
      runMainMenuGUI();
    }else if (evt.getActionCommand().equals("tutorial")) {
      mathMenu.setVisible(false);
      lesson = new Lesson(this);
      lesson.runLessonGUI();
    } else if (evt.getActionCommand().equals("addition")) {
      mathMenu.setVisible(false);
      question = new Questions("addition", this);
      question.runMathGUI();
    } else if (evt.getActionCommand().equals("subtraction")) {
      mathMenu.setVisible(false);
      question = new Questions("subtraction", this);
      question.runMathGUI();
    } else if (evt.getActionCommand().equals("multiplication")) {
      mathMenu.setVisible(false);
      question = new Questions("multiplication", this);
      question.runMathGUI();
    } else if (evt.getActionCommand().equals("division")) {
      mathMenu.setVisible(false);
      question = new Questions("division", this);
      question.runMathGUI();
    } else if (evt.getActionCommand().equals("factorial")) {
      mathMenu.setVisible(false);
      question = new Questions("factorial", this);
      question.runMathGUI();
    }

  }

}