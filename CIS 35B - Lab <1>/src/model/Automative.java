package model;

import java.io.Serializable;

public class Automative implements Serializable {
    private String name;
    private OptionSet[] optionSets;
    private float basePrice;

    public Automative () {}
    public Automative (String name, float basePrice, int size) {
        this.name = name;
        this.basePrice = basePrice;
        optionSets = new OptionSet[size];
        for (int i = 0; i < optionSets.length; i++) { // initialize all optionset within  optionSets array to default optionset
            optionSets[i] = new OptionSet();
        }
    }

    public String getName () {
        return name;
    }

    public float getBasePrice () {
        return basePrice;
    }

    public OptionSet getAnOptionSet (int index) {
        return optionSets[index];
    }

    public void setName (String name) {
        this.name = name;
    }

    public void setBasePrice (float basePrice) {
        this.basePrice = basePrice;
    }

    public void setOptionSets (String name, int size, int index) {
        optionSets[index].setName(name);
        optionSets[index].setOptionSize(size);
    }

    public void setOption (String name, float price, int optionSetIndex, int optionIndex) {
        optionSets[optionSetIndex].setAnOption(name, price, optionIndex);
    }
    /**
     * This method iterates through optionSets array and find the option name that matches, which then
     * returns index of that option, otherwise return -1. 
     * @param name
     * @return
     */
    public int findOptionSet (String name) {
        for (int i = 0; i < optionSets.length; i++) {
            if (optionSets[i].getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }
    /**
     * This method find the index of option by iterating through optionSets array and options array from
     * OptionSet.java class. If it matches name it returns index, otherwise returns -1.
     * @param name
     * @return j or -1
     */
    public int findOption (String name) {
        for (int i = 0; i < optionSets.length; i++) {
            for (int j = 0; j < optionSets[i].getOptions().length; j++) {
                if (optionSets[i].getAnOption(j).getName().equals(name)) {
                    return j;
                }
            }
        }
        return -1;
    }

    public void deleteOptionSet (String name) {
        int index = findOptionSet(name);
        optionSets[index] = new OptionSet();
    }

    public void deleteOption (String optionSetName, String optionName) {
        int optionSetIndex = findOptionSet(optionSetName);
        optionSets[optionSetIndex].deleteOption(optionName);
    }
    /**
     * This method updates an optionset in the optionSet array with new name and the size.
     * @param oldName
     * @param newName
     * @param newSize
     */
    public void updateOptionSet (String oldName, String newName, int newSize) {
        int index = findOptionSet(oldName);
        setOptionSets(newName, newSize, index);
    }
    /**
     * This method updates option in the context of optionset in the optionSets array. It uses findOptionSet method and
     * updateOption from OptionSet.java class.
     * @param oldName
     * @param newName
     * @param newPrice
     * @param optionSetName
     */
    public void updateOption (String oldName, String newName, float newPrice, String optionSetName) {
        int optionSetIndex = findOptionSet(optionSetName);
        optionSets[optionSetIndex].updateOption(oldName, newName, newPrice);
    }

    public void print() {
        System.out.printf("\n~~~~~~~~~~~~~~~~~~~~~~~~~~\n%s\nBase price is $%.2f\n", name, basePrice);
        for (int i = 0; i < optionSets.length; i++) {
            optionSets[i].print();
        }
    }
}