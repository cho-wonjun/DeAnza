package model;

import java.io.Serializable;

class OptionSet implements Serializable {
    private String name;
    private Option[] options;

    protected OptionSet () {}
    protected OptionSet (String name, int size) {
        this.name = name;
        options = new Option[size];
        for (int i = 0; i < options.length; i++) { // initialize all options within the array to be default
            options[i] = new Option();
        }
    }

    protected String getName () {
        return name;
    }

    protected Option[] getOptions () {
        return options;
    }

    protected Option getAnOption (int index) {
        return options[index];
    }

    protected void setName (String name) {
        this.name = name;
    }
    /**
     * This method re-initializes options array.
     * @param size
     */
    protected void setOptionSize (int size) {
        options = new Option[size];
        for (int i = 0; i < options.length; i++) { // initialize all options within the array to be default
            options[i] = new Option();
        }
    }

    protected void setAnOption (String name, float price, int index) {
        options[index].setPrice(price);
        options[index].setName(name);
    }
    /**
     * This method iterates through options array and returns the index of option that method is looking for.
     * Otherwise, it returns -1.
     * @param name
     * @return i or -1
     */
    protected int findOption (String name) {
        for (int i = 0; i < options.length; i++) {
            if (options[i].getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }
    /**
     * This method deletes an option by using findOption method and setting the option to a default option.
     * @param name
     */
    protected void deleteOption (String name) {
        int index = findOption(name);
        if (index > -1) {
            options[index] = new Option(); // delete an option by setting it to default option
        }
    }
    /**
     * This method updates an option from options array at a given option name, oldName.
     * @param oldName
     * @param newName
     * @param newPrice
     */
    protected void updateOption (String oldName, String newName, float newPrice) {
        int index = findOption(oldName);
        if (index > -1) {
            setAnOption(newName, newPrice, index);
        }
    }

    protected void print () {
        System.out.printf("*********%s*********\n", name);
        for (int i = 0; i < options.length; i++) {
            options[i].print();
        }
    }

    protected class Option implements Serializable {
        private String name;
        private float price;

        protected Option () {}
        protected Option (String name, float price) {
            this.name = name;
            this.price = price;
        }

        protected String getName () {
            return name;
        }

        protected float getPrice () {
            return price;
        }

        protected void setName (String name) {
            this.name = name;
        }

        protected void setPrice (float price) {
            this.price = price;
        }

        protected void print() {
            System.out.printf("~ %s: $%.2f\n", name, price);
        }
    }
}