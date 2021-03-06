/*
 * This file is part of Histacom 2, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2015, Histacom Development Team <http://histacom.jamierocks.uk/>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package ml.melonz.histacomrm;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.sun.glass.events.WindowEvent;
import ml.melonz.histacomrm.util.Language;

public class HistacomRewrite {

    public static boolean isMaximised;
    public static String language;
    static JFrame mainmenu;
    static JFrame langselect;
    static JFrame winver95;
    static JFrame os;
    static Point mouseDownCompCoords;
    static JLabel startGame;
    static JLabel HistacomRandomMelonImg;
    
    public static void initMainMenu(String title, String startButtonImg, Boolean resizable, String backgroundimg, int posX, int posY, int sizeX, int sizeY, int defaultClose, String startButtonToolTip, int startButtonPosX, int startButtonPosY, int startButtonSizeX, int startButtonSizeY) {
            mainmenu = new JFrame();
            mainmenu.setTitle(title);
            mainmenu.setIconImage(Toolkit.getDefaultToolkit().getImage(HistacomRewrite.class.getResource(backgroundimg)));
            mainmenu.setBounds(posX, posY, sizeX, sizeY);
            mainmenu.setResizable(resizable);
            mainmenu.setDefaultCloseOperation(defaultClose);
            mainmenu.getContentPane().setLayout(null);

            JLabel startGame = new JLabel("");
            startGame.setToolTipText(startButtonToolTip);
            startGame.setIcon(new ImageIcon(HistacomRewrite.class.getResource(startButtonImg)));
            startGame.setBounds(startButtonPosX, startButtonPosY, startGame.getIcon().getIconWidth(),
                    startGame.getIcon().getIconHeight());
            startGame.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    try {
                    	if (language == "English") {
                    		initOS("Windows 95", JFrame.EXIT_ON_CLOSE, false, 30, 192, 192, 192, 0, 192, 192, "Shows all of your installed programs.");
                    	}
                    	else if (language == "Italiano") {
                    		initOS("Windows 95", JFrame.EXIT_ON_CLOSE, false, 30, 192, 192, 192, 0, 192, 192, "Ti f� vedere tuttle le applicazioni installate.");
                    	}
                    	else if (language == "Nederlands") {
                    		initOS("Windows 95", JFrame.EXIT_ON_CLOSE, false, 30, 192, 192, 192, 0, 192, 192, "Laat alle programma's die ge�nstalleerd zijn zien.");
                    	}

                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    startGame.setIcon(new ImageIcon(HistacomRewrite.class.getResource("/ml/melonz/histacomrm/msnewgame.png")));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    startGame.setIcon(new ImageIcon(HistacomRewrite.class.getResource("/ml/melonz/histacomrm/newGame.png")));
                }
            });

            mainmenu.getContentPane().add(startGame);

            JLabel HistacomRandomMelonImg = new JLabel("");
            HistacomRandomMelonImg.setIcon(new ImageIcon(HistacomRewrite.class.getResource(backgroundimg)));
            HistacomRandomMelonImg.setBounds(0, 0, sizeX, sizeY);
            mainmenu.getContentPane().add(HistacomRandomMelonImg);
            mainmenu.setVisible(true);
    	}

    public static void initOS(String title, int defaultClose, Boolean noSound, int taskbarHeight, int barr, int barg,
            int barb, int backr, int backg, int backb, String startToolTip) {
    	if (language == "English") {
    		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
            int width = gd.getDisplayMode().getWidth();
            int height = gd.getDisplayMode().getHeight();

            if (noSound == false) {
                Sound.win95Start.play();
            }

            os = new JFrame();
            os.setTitle(title);
            os.setUndecorated(true);
            os.setBounds(100, 100, width, height);
            os.setLocation(0, 0);
            os.setDefaultCloseOperation(defaultClose);
            os.getContentPane().setLayout(null);

            JPanel taskbar = new JPanel();
            taskbar.setBounds(0, height - taskbarHeight, width, taskbarHeight);
            taskbar.setBackground((new Color(barr, barg, barb)));
            os.getContentPane().add(taskbar);
            taskbar.setLayout(null);

            JLabel startButton = new JLabel("");
            startButton.setToolTipText(startToolTip);
            startButton.setBounds(3, 4, 54, 22);
            startButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    startButton.setIcon(new ImageIcon(HistacomRewrite.class.getResource(
                            "/ml/melonz/histacomrm/win95StartButton.png")));
                    infoBox("mlg420 gitrekt", "Coming soon!");
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    startButton.setIcon(new ImageIcon(HistacomRewrite.class.getResource(
                            "/ml/melonz/histacomrm/win95StartButton-Hover.png")));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    startButton.setIcon(new ImageIcon(HistacomRewrite.class.getResource(
                            "/ml/melonz/histacomrm/win95StartButton.png")));
                }
            });
            taskbar.add(startButton);
            startButton.setIcon(new ImageIcon(HistacomRewrite.class.getResource(
                    "/ml/melonz/histacomrm/win95StartButton.png")));

            Font font = new Font("Microsoft Sans Serif", Font.BOLD, 14);

            JLabel desktopIco1 = new JLabel("");
            desktopIco1.setToolTipText("Tells you the Windows version.");
            desktopIco1.setBounds(23, 0, 38, 41);
            desktopIco1.setIcon(new ImageIcon(HistacomRewrite.class.getResource("/ml/melonz/histacomrm/winverico.png")));
            desktopIco1.setFont(font);
            desktopIco1.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    if (e.getClickCount() == 2 && !e.isConsumed()) {
                        initWinVer("95", "nonnt-ver4", "950", "� 1995, Microsoft Corp.", "legalthingynoonewillsee");
                    }
                }
            });
            os.getContentPane().add(desktopIco1);

            JLabel desktopText1 = new JLabel("<html><font color='white'>winver.exe -tempico</font></html>");
            desktopText1.setToolTipText("Closes all open windows, exits Windows, and turns off your computer.");
            desktopText1.setBounds(3, 30, 78, 45);
            desktopText1.setFont(font);
            desktopText1.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    if (e.getClickCount() == 2 && !e.isConsumed()) {
                        initWinVer("95", "nonnt-ver4", "950", "� 1995, Microsoft Corp.", "legalthingynoonewillsee");
                    }
                }
            });
            os.getContentPane().add(desktopText1);

            JPanel background = new JPanel();
            background.setBackground(new Color(backr, backg, backb));
            background.setBounds(0, 0, width, height);
            os.getContentPane().add(background);
            background.setLayout(null);

            os.setVisible(true);
    	}
    	
    	else if (language == "Italiano") {
    		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
            int width = gd.getDisplayMode().getWidth();
            int height = gd.getDisplayMode().getHeight();

            if (noSound == false) {
                Sound.win95Start.play();
            }

            os = new JFrame();
            os.setTitle(title);
            os.setUndecorated(true);
            os.setBounds(100, 100, width, height);
            os.setLocation(0, 0);
            os.setDefaultCloseOperation(defaultClose);
            os.getContentPane().setLayout(null);

            JPanel taskbar = new JPanel();
            taskbar.setBounds(0, height - taskbarHeight, width, taskbarHeight);
            taskbar.setBackground((new Color(barr, barg, barb)));
            os.getContentPane().add(taskbar);
            taskbar.setLayout(null);

            JLabel startButton = new JLabel("");
            startButton.setToolTipText(startToolTip);
            startButton.setBounds(3, 4, 54, 22);
            startButton.addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    startButton.setIcon(new ImageIcon(HistacomRewrite.class.getResource(
                            "/ml/melonz/histacomrm/win95StartButton.png")));
                    infoBox("In arrivo presto", "In arrivo presto!");
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    startButton.setIcon(new ImageIcon(HistacomRewrite.class.getResource(
                            "/ml/melonz/histacomrm/win95StartButton-Hover.png")));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    startButton.setIcon(new ImageIcon(HistacomRewrite.class.getResource(
                            "/ml/melonz/histacomrm/win95StartButton.png")));
                }
            });
            taskbar.add(startButton);
            startButton.setIcon(new ImageIcon(HistacomRewrite.class.getResource(
                    "/ml/melonz/histacomrm/win95StartButton.png")));

            Font font = new Font("Microsoft Sans Serif", Font.BOLD, 14);

            JLabel desktopIco1 = new JLabel("");
            desktopIco1.setToolTipText("Ti dice la versione di Windows.");
            desktopIco1.setBounds(23, 0, 38, 41);
            desktopIco1.setIcon(new ImageIcon(HistacomRewrite.class.getResource("/ml/melonz/histacomrm/winverico.png")));
            desktopIco1.setFont(font);
            desktopIco1.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    if (e.getClickCount() == 2 && !e.isConsumed()) {
                        initWinVer("95", "nonnt-ver4", "950", "� 1995, Microsoft Corp.", "legalthingynoonewillsee");
                    }
                }
            });
            os.getContentPane().add(desktopIco1);

            JLabel desktopText1 = new JLabel("<html><font color='white'>winver.exe -provvisorio</font></html>");
            desktopText1.setToolTipText("Ti dice la versione di Windows.");
            desktopText1.setBounds(3, 30, 78, 45);
            desktopText1.setFont(font);
            desktopText1.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    if (e.getClickCount() == 2 && !e.isConsumed()) {
                        initWinVer("95", "nonnt-ver4", "950", "� 1995, Microsoft Corp.", "legalthingynoonewillsee");
                    }
                }
            });
            os.getContentPane().add(desktopText1);

            JPanel background = new JPanel();
            background.setBackground(new Color(backr, backg, backb));
            background.setBounds(0, 0, width, height);
            os.getContentPane().add(background);
            background.setLayout(null);

            os.setVisible(true);
    	}
    	
    	else if (language == "Nederlands") {
    		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
            int width = gd.getDisplayMode().getWidth();
            int height = gd.getDisplayMode().getHeight();

            if (noSound == false) {
                Sound.win95Start.play();
            }

            os = new JFrame();
            os.setTitle(title);
            os.setUndecorated(true);
            os.setBounds(100, 100, width, height);
            os.setLocation(0, 0);
            os.setDefaultCloseOperation(defaultClose);
            os.getContentPane().setLayout(null);

            JPanel taskbar = new JPanel();
            taskbar.setBounds(0, height - taskbarHeight, width, taskbarHeight);
            taskbar.setBackground((new Color(barr, barg, barb)));
            os.getContentPane().add(taskbar);
            taskbar.setLayout(null);

            JLabel startButton = new JLabel("");
            startButton.setToolTipText(startToolTip);
            startButton.setBounds(3, 4, 54, 22);
            startButton.addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    startButton.setIcon(new ImageIcon(HistacomRewrite.class.getResource(
                            "/ml/melonz/histacomrm/win95StartButton.png")));
                    infoBox("Wordt binnenkort verwacht", "Wordt binnenkort verwacht!");
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    startButton.setIcon(new ImageIcon(HistacomRewrite.class.getResource(
                            "/ml/melonz/histacomrm/win95StartButton-Hover.png")));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    startButton.setIcon(new ImageIcon(HistacomRewrite.class.getResource(
                            "/ml/melonz/histacomrm/win95StartButton.png")));
                }
            });
            taskbar.add(startButton);
            startButton.setIcon(new ImageIcon(HistacomRewrite.class.getResource(
                    "/ml/melonz/histacomrm/win95StartButton.png")));

            Font font = new Font("Microsoft Sans Serif", Font.BOLD, 14);

            JLabel desktopIco1 = new JLabel("");
            desktopIco1.setToolTipText("Laat je de Windows-versie zien.");
            desktopIco1.setBounds(23, 0, 38, 41);
            desktopIco1.setIcon(new ImageIcon(HistacomRewrite.class.getResource("/ml/melonz/histacomrm/winverico.png")));
            desktopIco1.setFont(font);
            desktopIco1.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    if (e.getClickCount() == 2 && !e.isConsumed()) {
                        initWinVer("95", "nonnt-ver4", "950", "� 1995, Microsoft Corp.", "legalthingynoonewillsee");
                    }
                }
            });
            os.getContentPane().add(desktopIco1);

            JLabel desktopText1 = new JLabel("<html><font color='white'>winver.exe -tijdelijk</font></html>");
            desktopText1.setToolTipText("Laat je de Windows-versie zien.");
            desktopText1.setBounds(3, 30, 78, 45);
            desktopText1.setFont(font);
            desktopText1.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    if (e.getClickCount() == 2 && !e.isConsumed()) {
                        initWinVer("95", "nonnt-ver4", "950", "� 1995, Microsoft Corp.", "legalthingynoonewillsee");
                    }
                }
            });
            os.getContentPane().add(desktopText1);

            JPanel background = new JPanel();
            background.setBackground(new Color(backr, backg, backb));
            background.setBounds(0, 0, width, height);
            os.getContentPane().add(background);
            background.setLayout(null);

            os.setVisible(true);
    	}
        
    }

    public static void initWinVer(String windowsver, String ntversion, String buildnumber, String copyright,
            String legalmessage) {
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();

        if (windowsver == "95") {
            winver95 = new JFrame();
            winver95.setTitle("Windows");
            winver95.setUndecorated(true);
            winver95.setBounds(100, 100, 305, 183);
            winver95.setLocation(width / 3, height / 3);
            winver95.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            winver95.getContentPane().setLayout(null);

            JLabel lblWindowsVer = new JLabel("Windows 95");
            lblWindowsVer.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
            lblWindowsVer.setBounds(110, 32, 86, 26);
            winver95.getContentPane().add(lblWindowsVer);

            JLabel winverico = new JLabel("");
            winverico.setBounds(130, 55, 76, 50);
            winverico
                    .setIcon(new ImageIcon(HistacomRewrite.class.getResource("/ml/melonz/histacomrm/winverico.png")));
            winver95.getContentPane().add(winverico);

            JLabel lblcopyright = new JLabel("� 1995, Microsoft Corp.");
            lblcopyright.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
            lblcopyright.setBounds(73, 109, 177, 26);
            winver95.getContentPane().add(lblcopyright);

            JPanel titlebar = new JPanel();
            titlebar.setBounds(0, 0, 305, 20);
            titlebar.setBackground(new Color(0, 0, 139));
            titlebar.addMouseListener(new MouseAdapter() {
                public void mouseReleased(MouseEvent e) {
                    mouseDownCompCoords = null;
                }

                public void mousePressed(MouseEvent e) {
                    mouseDownCompCoords = e.getPoint();
                }
            });

            titlebar.addMouseMotionListener(new MouseMotionListener() {
                public void mouseMoved(MouseEvent e) {
                }

                public void mouseDragged(MouseEvent e) {
                    Point currCoords = e.getLocationOnScreen();
                    winver95.setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
                }
            });
            winver95.getContentPane().add(titlebar);
            titlebar.setLayout(null);

            JLabel windowtitle = new JLabel("<html><font color='white'>Windows 95</font></html>");
            windowtitle.setBounds(3, 3, 86, 16);
            windowtitle.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 12));
            titlebar.add(windowtitle);

            JLabel minbtn = new JLabel("");
            minbtn.setBounds(253, 3, 15, 14);
            titlebar.add(minbtn);
            minbtn.setIcon(new ImageIcon(HistacomRewrite.class.getResource("/ml/melonz/histacomrm/win95min.png")));

            JLabel closebtn = new JLabel("");
            closebtn.setBounds(286, 3, 30, 14);
            closebtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    try {
                        winver95.dispose();
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
            });
            titlebar.add(closebtn);

            closebtn.setIcon(new ImageIcon(HistacomRewrite.class.getResource("/ml/melonz/histacomrm/win95close.png")));

            JLabel maxbtn = new JLabel("");
            maxbtn.setBounds(267, 3, 30, 14);
            maxbtn.addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    if (isMaximised) {
                        minbtn.setBounds(253, 3, 15, 14);
                        maxbtn.setBounds(267, 3, 30, 14);
                        closebtn.setBounds(286, 3, 30, 14);
                        winver95.setBounds(100, 100, 305, 183);
                        winver95.setLocation(width / 3, height / 3);
                        titlebar.setBounds(0, 0, 305, 20);
                        isMaximised = false;
                    } else {
                        winver95.setSize(width, height - 30);
                        winver95.setLocation(0, 0);
                        titlebar.setSize(width, 20);
                        minbtn.setLocation(width - 51, 3);
                        maxbtn.setLocation(width - 37, 3);
                        closebtn.setLocation(width - 17, 3);

                        isMaximised = true;
                    }
                }
            });

            titlebar.add(maxbtn);
            maxbtn.setIcon(new ImageIcon(HistacomRewrite.class.getResource("/ml/melonz/histacomrm/win95max.png")));

            JLabel btnNewButton = new JLabel("");
            btnNewButton.setBounds(117, 146, 60, 26);
            btnNewButton.addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    winver95.dispose();
                }
            });
            btnNewButton
                    .setIcon(new ImageIcon(HistacomRewrite.class.getResource("/ml/melonz/histacomrm/win95btn.png")));
            winver95.getContentPane().add(btnNewButton);

            winver95.setVisible(true);

            JLabel txtOK = new JLabel("OK");
            txtOK.setBounds(20, 0, 60, 26);
            txtOK.addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    winver95.dispose();
                }
            });
            btnNewButton.add(txtOK);

            winver95.setVisible(true);
        } else {
        	if (language == "English") {
        		infoBox("The Windows version " + windowsver + " does not exist or is still WIP ATM.", "win" + windowsver + ".winver.nonimp();");
        	}
        	
        	else if (language == "Italiano") {
        		infoBox("La versione di Windows " + windowsver + " non esiste o � in lavorazione in questo momento.", "win" + windowsver + ".winver.nonimp();");
        	}
        	
        	else if (language == "Nederlands") {
        		infoBox("De Windows-versie " + windowsver + "  bestaat niet of er wordt op dit moment nog aan gewerkt.", "win" + windowsver + ".winver.nonimp();");
        	}
            
        }
    }

    public static void infoBox(String infoMessage, String titleBar) {
        JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @SuppressWarnings("unchecked")
			public void run() {
                try {
                	
                	GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
					int width = gd.getDisplayMode().getWidth();
                    int height = gd.getDisplayMode().getHeight();
                    
                	langselect = new JFrame("Language Selector");
                	langselect.setResizable(false);
                    langselect.setBounds(height/5, width/5, 400, 140);
                    langselect.setLayout(new GridLayout(3, 1));
                    langselect.addWindowListener(new WindowAdapter() {
                       @SuppressWarnings("unused")
					public void windowClosing(WindowEvent windowEvent){
                          System.exit(0);
                       }        
                    });  
                    
                    JLabel headerLabel = new JLabel("", JLabel.CENTER);        
                    JLabel statusLabel = new JLabel("",JLabel.CENTER);    

                    statusLabel.setSize(350,100);

                    JPanel controlPanel = new JPanel();
                    controlPanel.setLayout(new FlowLayout());

                    langselect.add(headerLabel);
                    langselect.add(controlPanel);
                    langselect.add(statusLabel);
                    langselect.setVisible(true);  
                    
                    headerLabel.setText("Select the language"); 

                    @SuppressWarnings("rawtypes")
					final DefaultComboBoxModel fruitsName = new DefaultComboBoxModel();

                    fruitsName.addElement("English");
                    fruitsName.addElement("Italiano");
                    fruitsName.addElement("Nederlands");

                    @SuppressWarnings("rawtypes")
					final JComboBox fruitCombo = new JComboBox(fruitsName);    
                    fruitCombo.setSelectedIndex(0);

                    JScrollPane fruitListScrollPane = new JScrollPane(fruitCombo);    
                    JButton showButton = new JButton("OK");
                    
                    showButton.addActionListener(new ActionListener() {
                       public void actionPerformed(ActionEvent e) { 
                          if (fruitCombo.getSelectedIndex() != -1) {                     
                             language = (String) fruitCombo.getItemAt(fruitCombo.getSelectedIndex());             
                          }             
                          if (language == "English") {
                        	  initMainMenu("Histacom Main Menu", "/ml/melonz/histacomrm/newGame.png", false, "/ml/melonz/histacomrm/mainMenu.png", height/3, width/3, 800, 600, JFrame.EXIT_ON_CLOSE, "Starts the game!", 303, 250, 186, 138);
                          }
                          
                          else if (language == "Italiano") {
                        	  initMainMenu("Men� principale di Histacom", "/ml/melonz/histacomrm/newGame.png", false, "/ml/melonz/histacomrm/mainMenu.png", height/3, width/3, 800, 600, JFrame.EXIT_ON_CLOSE, "Comincia il gioco!", 303, 250, 186, 138);
                          }
                          
                          else if (language == "Nederlands") {
                        	  initMainMenu("Histacom Hoofdmenu", "/ml/melonz/histacomrm/newGame.png", false, "/ml/melonz/histacomrm/mainMenu.png", height/3, width/3, 800, 600, JFrame.EXIT_ON_CLOSE, "Start het spel!", 303, 250, 186, 138);
                          }
                       }
                    }); 
                    controlPanel.add(fruitListScrollPane);          
                    controlPanel.add(showButton);    
                    langselect.setVisible(true);  
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
}