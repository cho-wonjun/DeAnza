package adapter;

import exception.AutoException;
import model.Automobile;
import util.FileIO;

/**
 * Auto and update methods use methods from Automobile and FileIO class.
 */
abstract class ProxyAutomative {
    private Automobile a1;

    public void buildAuto (String fileName) {
        a1 = new FileIO().buildAutoObject(fileName);
        while (a1 == null) {
            fileName = fix();
            a1 = new FileIO().buildAutoObject(fileName);
        }
    }

    public void printAuto (String modelName) {
        a1.print();
    }

    public void updateOptionSetName (String modelName, String optionSetName, String newName) {
        a1.updateOptionSet(optionSetName, newName);
    }

    public void updateOptionPrice (String modelName, String optionName, String option, float newPrice) {
        a1.updateOption(optionName, optionName, newPrice, option);
    }

    public String fix () {
        AutoException e = new AutoException(101);
        return e.fix();
    }
}
