import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.io.StringWriter;

public class Mangawang 
{
    public static void main(String[] args) 
    {
        JFrame frame = new JFrame("hehe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        /* 
         * Initial text box.
         * In this case, the names will be placed.
         * All of them requires this one text box.
        */
        JLabel label = new JLabel("Sinong shiniship sa bebe ko? - Bianca"); // title of the textbox
        JTextField textField = new JTextField(20);
        JButton button = new JButton("Attempt to Ship"); // button

        panel.add(label);
        panel.add(textField);
        panel.add(button);

        frame.add(panel);

        Person me = new Person();

        button.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                String otherPerson = textField.getText();
                /*
                 * If the other person is Bianca herself, then the program will spam a thousand windows of the class.
                 * The poem is encapsulated inside an object deep in the code to prevent early leakage.
                 */
                if (otherPerson.equalsIgnoreCase("Bianca")) 
                {
                    Poem BiancaPoem = newTacoPoem();

                    for (int i = 0; i < 400; i++) // Spams 1000 windows
                    {
                        SwingUtilities.invokeLater(() -> 
                        {
                            JFrame poemFrame = new JFrame("Mwaaaaa mwaaaaa @Rhea Bianca May C. Mangawang, I love youu soo muchh <33");
                            poemFrame.setSize(800, 540);
                            poemFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                            JTextArea poemArea = new JTextArea();
                            poemArea.setEditable(false);
                            poemArea.setText(BiancaPoem.getPoemText());
                            poemFrame.add(new JScrollPane(poemArea));

                            poemFrame.setLocation(
                                    (int) (Math.random() * Toolkit.getDefaultToolkit().getScreenSize().width),
                                    (int) (Math.random() * Toolkit.getDefaultToolkit().getScreenSize().height));
                            poemFrame.setVisible(true);
                        });

                        try 
                        {
                            Thread.sleep(1);
                        } 
                        catch (InterruptedException interruptedException) 
                        {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
                /*
                 * This section of the code deals with the man's name. If it is the input,
                 * it will show these, because obviously, no one ships someone to himself.
                 * You cannot marry yourself, and no one can.
                 * Hence, the code will mock the shipper for shipping him to himself.
                 */
                else if (otherPerson.equalsIgnoreCase("Adriaan")) 
                {
                    Mockery adriaanText = mockYourself();

                    for (int i = 0; i < 5; i++) 
                    {
                        SwingUtilities.invokeLater(() -> 
                        {
                            JFrame adriaanFrame = new JFrame("Haha wtf are you even doing?!");
                            adriaanFrame.setSize(500, 100);
                            adriaanFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                            JTextArea adriaanArea = new JTextArea();
                            adriaanArea.setEditable(false);
                            adriaanArea.setText(adriaanText.getMockeryText());
                            adriaanFrame.add(new JScrollPane(adriaanArea));

                            adriaanFrame.setLocation(
                                    (int) (Math.random() * Toolkit.getDefaultToolkit().getScreenSize().width),
                                    (int) (Math.random() * Toolkit.getDefaultToolkit().getScreenSize().height));
                            adriaanFrame.setVisible(true);
                        });
                    }
                }
                else 
                {
                   /* 
                    * This section of the code deals with other names. This one currenntly holds
                    * the original section of the code, where if any other name is put except for
                    * Bianca and Adriaan, then it would spam the anti ship things a thousand times.
                    * Works like the YouAreAnIdiot virus.
                    */
                    try 
                    {
                        me.attemptToShip(otherPerson); // Normal logic
                    } 
                    catch (IsInARelationshipError ex) 
                    {
                        StringWriter sw = new StringWriter();
                        ex.printStackTrace(new PrintWriter(sw));
                        String stackTrace = sw.toString();

                        for (int i = 0; i < 400; i++) // 4,000 popups
                        {
                            SwingUtilities.invokeLater(() -> 
                            {
                                JFrame popupFrame = new JFrame("Bawal na ako iship! @Rhea Bianca Mangawang mii amorr ohhh :<");
                                popupFrame.setSize(700, 400);
                                popupFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                                JTextArea textArea = new JTextArea(stackTrace);
                                textArea.setEditable(false);
                                popupFrame.add(new JScrollPane(textArea));

                                popupFrame.setLocation(
                                        (int) (Math.random() * Toolkit.getDefaultToolkit().getScreenSize().width),
                                        (int) (Math.random() * Toolkit.getDefaultToolkit().getScreenSize().height));
                                popupFrame.setVisible(true);
                            });

                            try 
                            {
                                Thread.sleep(1);
                            } 
                            catch (InterruptedException interruptedException) 
                            {
                                Thread.currentThread().interrupt();
                            }
                        }
                    }
                }
            }
        });

        frame.setVisible(true);
    }

    private static Mockery mockYourself() 
    {
        return new Mockery("Haha wtf are you even doing to yourself, look!\n" +
                "Don't ship himself to himself!");
    }

    private static Poem newTacoPoem() 
    {
        return new Poem(
            "From endless hours to fleeting seconds,\n" +
            "Pain arrived with heavy reckonings.\n" +
            "With suffering vast and blood profuse,\n" +
            "High hopes shattered, dreams let loose.\n\n" +
            "But one day came, without a clue,\n" +
            "In the depths of darkness I once knew.\n" +
            "A light so bright, unseen before,\n" +
            "Knocked gently, ready to explore.\n\n" +
            "From shadows grim and fears untamed,\n" +
            "You called me forth, no longer maimed.\n" +
            "A shell that bore defeat's harsh sting,\n" +
            "You mended, gave it strength to cling.\n\n" +
            "For all the times you stood so near,\n" +
            "A steady presence, calm and clear.\n" +
            "Through every trial, you held me tight,\n" +
            "A guiding star in my endless night.\n\n" +
            "And though these words may softly weave,\n" +
            "A hidden truth I must now leave:\n" +
            "In every rhyme, a piece of me,\n" +
            "A love so pure, it longs to be.\n\n" +
            "So here I stand, my heart laid bare,\n" +
            "With hope and courage, if you care.\n" +
            "We could write a story, just us two—\n" +
            "A tale of love that starts with you.\n\n" +
            "https://open.spotify.com/playlist/2REGe8iSmKI7FRC0HxU4Lk?si=abc433dc55014190&pt=92bf60c0f3e2393eae52347c81440056");
    }
}

/*
 * This section is sanctioned by Sir Dexter Mariano.
 * This code is object-oriented and follows the principles of encapsulation,
 * inheritance, and polymorphism.
 * However, it is mostly just encapsulation and inheritance I think.
 */
class Person 
{
    // is hardcoded
    private boolean takenInARelationship = true; // the person here is removed for obvious reasons.

    public void attemptToShip(String otherPerson) 
    {
        if (isTakenInARelationship()) 
        {
            throw new IsInARelationshipError("private boolean takenInARelationship == true;");
        } 
        else 
        {
            JOptionPane.showMessageDialog(null, "Shipping successful with " + otherPerson + "!");
        }
    }

    private boolean isTakenInARelationship() 
    {
        return takenInARelationship;
    }
}

class IsInARelationshipError extends RuntimeException 
{
    public IsInARelationshipError(String message) 
    {
        super(message);
    }
}

class Poem 
{
    private final String poemText;

    public Poem(String poemText) 
    {
        this.poemText = poemText;
    }

    public String getPoemText() 
    {
        return poemText;
    }
}

class Mockery 
{
    private final String mockeryText;

    public Mockery(String mockeryText) 
    {
        this.mockeryText = mockeryText;
    }

    public String getMockeryText() 
    {
        return mockeryText;
    }
}