package exercises.zad24;

import java.util.ArrayList;

/*
Dato je nekoliko papira dužine int D (od 0 do D) i visine H. Svaki papir ima svoj id koji je
string. Kada se kreira, ceo papir se oboji odabranom bojom. Dato je i nekoliko robota koji
boje papire na sledeći način:
  *   odaberu papir
  *   odaberu tri boje
  *   odaberu pravougaonik (int i, int j, int h) gde je 0<i leva granica, D>j desna granica, a
h<H visina. Mogu odabrati taj pravougaonik ako i samo ako je pravougaonik (i, j, 1)
obojen samo jednom bojom.
  *   U zavisnosti od tipa robot bira broj k (i<k<j), i boji pravougaonik (i, j, h) prvom bojom,
pravougaonik (i, k-1, h/2) drugom bojom, i pravougaonik (k+1, j, h/2) trećom bojom.
  *   Ako je papir na mestu (x, y) bio obojen jednom bojom, a to mesto se nalazi u nekom
od gore navedenih pravougaonika sada će papir na tom mestu biti obojen drugom bojom.
Postoji tri tipa robota:
  *   Prvi računa k kao (i+j)/2
  *   Drugi računa k kao (i+j)/3
  *   Treći računa k kao i+1
  *   Četvrti kao j-1
  *   Peti bira k kao najveći paran broj manji od j.
Dužina papira može biti najviše 5000000, a visina može biti najviše 1000000000.
Implementirati sledeće klase: Papiri, Robot1, Robot2, Robot3, Robot4, Robot5, …..
Implementirati sledeće metode:
  *   kreirajRobota (tip)
  *   kreirajPapir(idPapira, D, H, boja)
  *   obojiPapir (idPapira, robot, i, j, h)
  *   vratiPapir (idPapira)
  *   boja(idPapira, x, y) vraća boju na mestu (x, y)
  *   povrsinaBoja (idPapira, boja) vraća površinu koja je obojena bojom boja
  *   brojMesta (idPapira) vraća broj mesta koja su obojena sa bar dve različite boje
  *   najzastupljenijaBoja(idPapira) vraća boju koja je najzastupljenija na papiru
U glavnom programu čitati iz konzole komande. Komanda je nazivMetoda par1 par2 …
*/
interface Element {
    public void startColoring(int i, int j, int h, String type);

    public int color(int x, int y);

    public int surface(int b);
}

class Rectangle implements Element {
    private int start;
    private int end;
    public int height;
    public int color;
    private ArrayList<Element> list = new ArrayList<>();

    public Rectangle(int start, int end, int height, int color) {
        this.start = start;
        this.end = end;
        this.height = height;
        this.color = color;
    }

    public void add(Element e) {
        if (e instanceof Rectangle) list.add(e);
    }

    @Override
    public void startColoring(int i, int j, int h, String type) {
        StartColor coloring = (StartColor) StartColor.getInstance(1,2,3);
        coloring.setType(type);
        add(coloring.create(i,j,h));
    }

    @Override
    public int color(int x, int y) {
        for (int i = 0; i < list.size(); i++) {
            Rectangle p = (Rectangle) list.get(i);
            if (p.start <= x && x <= p.end && y < p.height) {
                return p.color(x, y);
            }
        }
        return color;
    }

    @Override
    public int surface(int b) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            Rectangle r = (Rectangle) list.get(i);
            sum += r.height * (r.end - r.start);
        }
        int surfaceThis = height * (end - start) - sum;
        int result = 0;
        if (color == b) {
            result = surfaceThis;
        }
        for (int i = 0; i < list.size(); i++) {
            Rectangle r = (Rectangle) list.get(i);
            result += surface(b);
        }
        return result;
    }
}

class Paper extends Rectangle {
    public Paper(int start, int end, int height, int color) {
        super(start, end, height, color);
    }
}

abstract class Strategy {
    public abstract int choosing(int i, int j);

    public static Strategy createStrategy(String type) {
        if (type.equals("1")) {
            return new Strategy1();
        } else if (type.equals("2")) {
            return new Strategy2();
        } else {
            return new Strategy3();
        }
    }
}

class Strategy1 extends Strategy {
    @Override
    public int choosing(int i, int j) {
        return (i + j) / 2;
    }
}

class Strategy2 extends Strategy {
    @Override
    public int choosing(int i, int j) {
        return (i + j) / 3;
    }
}

class Strategy3 extends Strategy {
    @Override
    public int choosing(int i, int j) {
        return i + 1;
    }
}

class Robot {
    Strategy s;
    public int color1,color2,color3;

    public Robot(int color1, int color2, int color3) {
        this.color1 = color1;
        this.color2 = color2;
        this.color3 = color3;
    }
    public void setStrategy(Strategy s){
        this.s=s;
    }
    public void setStrategy(String s){
        this.s=Strategy.createStrategy(s);
    }
    public int getK(int start, int end){
        return s.choosing(start,end);
    }
}

class StartColor{
    private Robot robot;
    private static StartColor instance=null;
    private StartColor(int b1, int b2, int b3){
        robot=new Robot(b1,b2,b3);
    }
    public static Object getInstance(int b1, int b2, int b3){
        if(instance==null){
            instance=new StartColor(b1,b2,b3);
        }
        instance.robot.color1=b1;
        instance.robot.color2=b2;
        instance.robot.color3=b3;
        return instance;
    }
    public void setType(String type){
        robot.setStrategy(type);
    }
    public Rectangle create(int start, int end, int height){
        int k=robot.getK(start,end);
        Rectangle rectangle = new Rectangle(start,end,height, robot.color1);
        rectangle.add(new Rectangle(start,k-1,height/2,robot.color2));
        rectangle.add(new Rectangle(k+1,end,height/2,robot.color3));
        return rectangle;
    }
}

public class main {
    public static void main(String[] args) {

    }
}
