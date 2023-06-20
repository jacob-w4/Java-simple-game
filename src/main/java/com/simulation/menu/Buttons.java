package com.simulation.menu;

import com.simulation.Board;
import com.simulation.entities.Goblin;
import com.simulation.entities.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Klasa tworzaca panel przyciskow. Zawiera cztery przyciski do poruszania sie po planszy i jeden dodatkowy do czekania w miejscu.
 * Ponadto posiada piec klas wewnetrzych odpowiedzialnych za poruszanie sie za pomoca klawiszy WASD oraz Q (czekanie).
 * @author Jakub, Marek
 * @version 1.2.0
 */
public class Buttons implements ActionListener{

    private final int buttonsHeigth;
    private final int buttonsWidth;
    private JButton up;
    private JButton down;
    private JButton left;
    private JButton wait;
    private JButton right;
    private JPanel buttonMenu;
    private static int moveCounter;
    private static final Player player = new Player();
    private static final Goblin goblin = new Goblin();
    private static Board board;
    private static boolean nextLvl = false;


    /**
     * Dodaje panel przyciskow do panelu menu.
     * @param menu panel menu
     * @see Menu
     */
    public void add(JPanel menu) {
        menu.add(buttonMenu);
    }

    /**
     * Konstruktor klasy Buttons. Ustawia wartosci atrybutow. Wywoluję metode ktora: <br>
     * 1) tworzy przyciski do poruszania sie po mapie <br>
     * 2) ustawia klawisze rowniez do poruszania sie po mapie.
     * @param heigth wysokosc panelu
     * @param width szerokosc panelu
     * @param board obiekt klasy Board
     * @see Board
     */
    public Buttons(int heigth, int width, Board board) {
        buttonsHeigth = heigth / 2;
        buttonsWidth = width;
        Buttons.board = board;
        start();
    }

    /**
     * Metode ktora: <br>
     * 1) tworzy przyciski do poruszania sie po mapie <br>
     * 2) ustawia klawisze rowniez do poruszania sie po mapie.
     */
    public void start() {
        // Tworzenie przyciskow
        up = new JButton("up");
        down = new JButton("down");
        left = new JButton("left");
        right = new JButton("right");
        wait = new JButton("wait");
        // Stworzenie panelu dla przyciskow
        buttonMenu = new JPanel();
        buttonMenu.setPreferredSize(new Dimension(buttonsWidth, buttonsHeigth));
        buttonMenu.setLayout(new GridLayout(3, 1, 0, 0));


        // Ustawienie pozycji
        JPanel topPanel = new JPanel();
        JPanel midPanel = new JPanel();
        JPanel botPanel = new JPanel();

        // Wylaczenie skupianie na tekscie dla przyciskow
        up.setFocusPainted(false);
        down.setFocusPainted(false);
        right.setFocusPainted(false);
        left.setFocusPainted(false);
        wait.setFocusPainted(false);

        // Dodanie przyciskow do poszczegolnych paneli
        topPanel.add(up);
        midPanel.add(left);
        midPanel.add(wait);
        midPanel.add(right);
        botPanel.add(down);

        // Ustawienie rozmiarow przyciskow
        up.setPreferredSize(new Dimension(75, 75));
        down.setPreferredSize(new Dimension(75, 75));
        right.setPreferredSize(new Dimension(75, 75));
        left.setPreferredSize(new Dimension(75, 75));
        wait.setPreferredSize(new Dimension(75,75));


        // Dodanie paneli do panelu glownego
        buttonMenu.add(topPanel);
        buttonMenu.add(midPanel);
        buttonMenu.add(botPanel);

        // Ustawienie funkcji klikniecia dla przyciskow
        up.addActionListener(this);
        down.addActionListener(this);
        left.addActionListener(this);
        right.addActionListener(this);
        wait.addActionListener(this);

        // Tworzenie obiektów odpowiedzialnych za poruszanie sie klawiszami
        Action upAction = new UpAction();
        Action downAction = new DownAction();
        Action rightAction = new RightAction();
        Action leftAction = new LeftAction();
        Action waitAction = new WaitAction();

        // Przypisanie odpowiednich klawiszy i nadanie im funkcjonalosci
        buttonMenu.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('w'),"upAction");
        buttonMenu.getActionMap().put("upAction", upAction);
        buttonMenu.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('s'),"downAction");
        buttonMenu.getActionMap().put("downAction", downAction);
        buttonMenu.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('d'),"rightAction");
        buttonMenu.getActionMap().put("rightAction", rightAction);
        buttonMenu.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('a'),"leftAction");
        buttonMenu.getActionMap().put("leftAction", leftAction);
        buttonMenu.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('q'),"waitAction");
        buttonMenu.getActionMap().put("waitAction", waitAction);
    }

    /**
     * Metoda, ktora ustawia następna plansze oraz szuka nowych pozycji gracza i goblinow.
     * @see Player#findPlayerPos()
     * @see Goblin#findGoblinPos()
     */
    public static void nextLvl() {
        // Usuniecie pozostalych na planszy przeciwnikow
        for (int i = 0; i < Goblin.getAmount(); i++) {
            goblin.goblinDies(i);
        }
        //Zmiana planszy na kolejny poziom
        if (Board.getCurrentLvL() == 2) {
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 20; j++) {
                    board.getFieldStateArray()[i][j] = Board.getFieldStateArray2()[i][j];
                }
            }
        } else if (Board.getCurrentLvL() == 3) {
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 20; j++) {
                    board.getFieldStateArray()[i][j] = Board.getFieldStateArray3()[i][j];
                }
            }
        }
        // Odszukanie nowych pozycji dla gracza i przeciwnikow,i odswiezenie planszy
        player.findPlayerPos();
        goblin.findGoblinPos();
        board.refresh();
        nextLvl = true;
    }

    /**
     * Porusza graczem w lewo (pod warunkiem, ze nie jest to ściana) oraz zmienia losowo pozycje goblinow.
     * Usuwa goblinow z planszy gdy zaatakuja gracza, odejmuje zycie gracza.
     * W przypadku przejscia na nowa plansze ustawia ponownie pokonanych przeciwnikow na plansze.
     * @see Player#movePlayer(int, String)
     * @see Goblin#moveGoblin()
     * @see Goblin#goblinDies(int)
     */
    public void moveLeft() {
        // Zmiana pozycji gracza w lewo
        player.movePlayer(-1, "x");
        // Ustawienie nowej pozycji gracza na planszy
        board.setFieldStateArray(player.getPlayerPosition(), player.getOldPostion());
        for (int i = 0; i < Goblin.getAmount(); i++) {
            // Atakowanie gracza przez przeciwinkow
            if (Math.abs(player.getPlayerPosition()[0] - goblin.getGoblinPosition()[i][1]) <= 1 && Math.abs(player.getPlayerPosition()[1] - goblin.getGoblinPosition()[i][0]) <= 1) {
                Stats.decreaseHealth();
                if (player.getPlayerPosition()[0] == goblin.getGoblinPosition()[i][1] && player.getPlayerPosition()[1] == goblin.getGoblinPosition()[i][0]) {
                    goblin.goblinDies(i);
                } else {
                    board.changeTo0(goblin.getGoblinPosition()[i]);
                    goblin.goblinDies(i);
                }
                Stats.increaseBodyCount();
                board.refresh();
            }
        }
        // Zmiana pozycji przeciwnika, jezeli nie ma zmiany planszy na kolejny poziom
        if (!nextLvl) {
            goblin.moveGoblin();
            board.setFieldStateArray2(goblin.getGoblinPosition(), goblin.getGoblinOldPosition());
        }
        board.refresh();
        nextLvl = false;
    }

    /**
     * Porusza graczem w prawo (pod warunkiem, ze nie jest to ściana) oraz zmienia losowo pozycje goblinow.
     * Usuwa goblinow z planszy gdy zaatakuja gracza, odejmuje zycie gracza.
     * W przypadku przejscia na nowa plansze ustawia ponownie pokonanych przeciwnikow na plansze.
     * @see Player#movePlayer(int, String)
     * @see Goblin#moveGoblin()
     * @see Goblin#goblinDies(int)
     */
    public void moveRight() {
        // Zmiana pozycji gracza w prawo
        player.movePlayer(1, "x");
        // Ustawienie nowej pozycji gracza na planszy
        board.setFieldStateArray(player.getPlayerPosition(), player.getOldPostion());
        for (int i = 0; i < Goblin.getAmount(); i++) {
            // Atakowanie gracza przez przeciwinkow
            if (Math.abs(player.getPlayerPosition()[0] - goblin.getGoblinPosition()[i][1]) <= 1 && Math.abs(player.getPlayerPosition()[1] - goblin.getGoblinPosition()[i][0]) <= 1) {
                Stats.decreaseHealth();
                if (player.getPlayerPosition()[0] == goblin.getGoblinPosition()[i][1] && player.getPlayerPosition()[1] == goblin.getGoblinPosition()[i][0]) {
                    goblin.goblinDies(i);
                } else {
                    board.changeTo0(goblin.getGoblinPosition()[i]);
                    goblin.goblinDies(i);
                }
                Stats.increaseBodyCount();
                board.refresh();
            }
        }
        // Zmiana pozycji przeciwnika, jezeli nie ma zmiany planszy na kolejny poziom
        if (!nextLvl) {
            goblin.moveGoblin();
            board.setFieldStateArray2(goblin.getGoblinPosition(), goblin.getGoblinOldPosition());
        }
        board.refresh();
        nextLvl = false;
    }

    /**
     * Porusza graczem w gorę (pod warunkiem, ze nie jest to sciana) oraz zmienia losowo pozycje goblinow.
     * Usuwa goblinow z planszy gdy zaatakuja gracza, odejmuje zycie gracza.
     * W przypadku przejscia na nowa plansze ustawia ponownie pokonanych przeciwnikow na plansze.
     * @see Player#movePlayer(int, String)
     * @see Goblin#moveGoblin()
     * @see Goblin#goblinDies(int)
     */
    public void moveUp() {
        // Zmiana pozycji gracza w gore
        player.movePlayer(-1, "y");
        // Ustawienie nowej pozycji gracza na planszy
        board.setFieldStateArray(player.getPlayerPosition(), player.getOldPostion());
        for (int i = 0; i < Goblin.getAmount(); i++) {
            // Atakowanie gracza przez przeciwinkow
            if (Math.abs(player.getPlayerPosition()[0] - goblin.getGoblinPosition()[i][1]) <= 1 && Math.abs(player.getPlayerPosition()[1] - goblin.getGoblinPosition()[i][0]) <= 1) {
                Stats.decreaseHealth();

                if (player.getPlayerPosition()[0] == goblin.getGoblinPosition()[i][1] && player.getPlayerPosition()[1] == goblin.getGoblinPosition()[i][0]) {
                    goblin.goblinDies(i);
                } else {
                    board.changeTo0(goblin.getGoblinPosition()[i]);
                    goblin.goblinDies(i);
                }
                Stats.increaseBodyCount();
                board.refresh();
            }
        }
        // Zmiana pozycji przeciwnika, jezeli nie ma zmiany planszy na kolejny poziom
        if (!nextLvl) {
            goblin.moveGoblin();
            board.setFieldStateArray2(goblin.getGoblinPosition(), goblin.getGoblinOldPosition());
        }
        board.refresh();
        nextLvl = false;
    }

    /**
     * Porusza graczem w dol (pod warunkiem, ze nie jest to sciana) oraz zmienia losowo pozycje goblinow.
     * Usuwa goblinow z planszy gdy zaatakuja gracza, odejmuje zycie gracza.
     * W przypadku przejscia na nowa plansze ustawia ponownie pokonanych przeciwnikow na plansze.
     * @see Player#movePlayer(int, String)
     * @see Goblin#moveGoblin()
     * @see Goblin#goblinDies(int)
     */
    public void moveDown() {
        // Zmiana pozycji gracza w dol
        player.movePlayer(1, "y");
        // Ustawienie nowej pozycji gracza na planszy
        board.setFieldStateArray(player.getPlayerPosition(), player.getOldPostion());
        for (int i = 0; i < Goblin.getAmount(); i++) {
            // Atakowanie gracza przez przeciwinkow
            if (Math.abs(player.getPlayerPosition()[0] - goblin.getGoblinPosition()[i][1]) <= 1 && Math.abs(player.getPlayerPosition()[1] - goblin.getGoblinPosition()[i][0]) <= 1) {
                Stats.decreaseHealth();
                if (player.getPlayerPosition()[0] == goblin.getGoblinPosition()[i][1] && player.getPlayerPosition()[1] == goblin.getGoblinPosition()[i][0]) {
                    goblin.goblinDies(i);
                } else {
                    board.changeTo0(goblin.getGoblinPosition()[i]);
                    goblin.goblinDies(i);
                }
                Stats.increaseBodyCount();
                board.refresh();
            }
        }
        // Zmiana pozycji przeciwnika, jezeli nie ma zmiany planszy na kolejny poziom
        if (!nextLvl) {
            goblin.moveGoblin();
            board.setFieldStateArray2(goblin.getGoblinPosition(), goblin.getGoblinOldPosition());
        }
        board.refresh();
        nextLvl = false;
    }

    /**
     * Zmienia losowo pozycje goblinow.
     * Usuwa goblinow z planszy gdy zaatakuja gracza, odejmuje zycie gracza.
     * W przypadku przejscia na nową planszę ustawia ponownie pokonanych przeciwnikow na planszę.
     * @see Goblin#moveGoblin()
     * @see Goblin#goblinDies(int)
     */
    public void stop() {
        for (int i = 0; i < Goblin.getAmount(); i++) {
            // Atakowanie gracza przez przeciwinkow
            if (Math.abs(player.getPlayerPosition()[0] - goblin.getGoblinPosition()[i][1]) <= 1 && Math.abs(player.getPlayerPosition()[1] - goblin.getGoblinPosition()[i][0]) <= 1) {
                Stats.decreaseHealth();
                if (player.getPlayerPosition()[0] == goblin.getGoblinPosition()[i][1] && player.getPlayerPosition()[1] == goblin.getGoblinPosition()[i][0]) {
                    goblin.goblinDies(i);
                } else {
                    board.changeTo0(goblin.getGoblinPosition()[i]);
                    goblin.goblinDies(i);
                }
                Stats.increaseBodyCount();
                board.refresh();
            }
        }
        // Zmiana pozycji przeciwnika, jezeli nie ma zmiany planszy na kolejny poziom
        if (!nextLvl) {
            goblin.moveGoblin();
            board.setFieldStateArray2(goblin.getGoblinPosition(), goblin.getGoblinOldPosition());
        }
        board.refresh();
        nextLvl = false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Ruch za pomocą przyciskow
        if (e.getSource() == up) {
            moveUp();
            moveCounter++;
        } else if (e.getSource() == down) {
            moveDown();
            moveCounter++;
        } else if (e.getSource() == left) {
            moveLeft();
            moveCounter++;
        } else if (e.getSource() == right) {
            moveRight();
            moveCounter++;
        } else if (e.getSource() == wait) {
            stop();
        }
    }

    /**
     * @return liczba wykonanych ruchow
     */
    public static int getMoveCounter() {
        return moveCounter;
    }

    /**
     * Klasa wewnetrzna odpowiedzialna za ruch do gory za pomoca klawisza.
     */
    private class UpAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            moveUp();
            moveCounter++;
        }
    }
    /**
     * Klasa wewnetrzna odpowiedzialna za ruch w dol za pomoca klawisza.
     */
    private class DownAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            moveDown();
            moveCounter++;
        }
    }
    /**
     * Klasa wewnetrzna odpowiedzialna za ruch w prawo za pomoca klawisza.
     */
    private class RightAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            moveRight();
            moveCounter++;
        }
    }
    /**
     * Klasa wewnetrzna odpowiedzialna za ruch w lewo za pomoca klawisza.
     */
    private class LeftAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            moveLeft();
            moveCounter++;
        }
    }
    /**
     * Klasa wewnetrzna odpowiedzialna za stanie w miejscu za pomoca klawisza.
     */
    private class WaitAction extends AbstractAction {

        @Override
        public void actionPerformed(ActionEvent e) {
            stop();
        }
    }
}
