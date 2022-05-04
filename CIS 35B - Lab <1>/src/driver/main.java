package driver;

import adapter.BuildAuto;
import adapter.CreateAuto;
import adapter.UpdateAuto;
import model.Automobile;
import util.FileIO;

public class main {
    public static void main(String[] args) {
//        FileIO fi = new FileIO();
//        Automobile fordZTW = fi.buildAutoObject("focusWagonZTW.txt");
//        fordZTW.print();
//
//        System.out.println("");
//
//        fi.serialize(fordZTW, "focusWagonZTW.ser");
//        Automobile a = fi.deserialize("focusWagonZTW.ser");
//        a.print();

        CreateAuto b = new BuildAuto();
        b.buildAuto("focusWagonZTW.txt");
        b.printAuto("Focus Wagon ZTW");
        UpdateAuto c = (UpdateAuto) b;
        c.updateOptionSetName("Focus Wagon ZTW", "Transmission", "Side Impact Air Bags");
        c.updateOptionPrice("Focus Wagon ZTW", "Fort Knox Gold Clearcoat Metallic", "Color", 15);
        ((CreateAuto)c).printAuto("Focus Wagon ZTW");

        CreateAuto a = new BuildAuto();
        a.buildAuto("txt");
        a.printAuto("Focus Wagon ZTW");
    }
}
