package driver;

import model.Automative;
import util.FileIO;

public class main {
    public static void main(String[] args) {
        FileIO fi = new FileIO();
        Automative fordZTW = fi.buildAutoObject("focusWagonZTW.txt");
        fordZTW.print();

        System.out.println("");

        fi.serialize(fordZTW, "focusWagonZTW.ser");
        Automative a = fi.deserialize("focusWagonZTW.ser");
        a.print();
    }
}
