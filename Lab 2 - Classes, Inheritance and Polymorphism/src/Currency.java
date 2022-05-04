import java.util.InputMismatchException;

/**
 * Lab 2 Team 12
 * @author Won Jun Cho
 * This class is designed for Currency class from which other currencies will be derived to build a currency simulator using classes,inheritance and polymorphism.
 */

public abstract class Currency {
    private int wholePart;
    private int fractionalPart;

    Currency() {
        this.wholePart = 0;
        this.fractionalPart = 0;
    }

    Currency(double currencyValue) {
        try {
            if (currencyValue < 0.0) {
                throw new Exception("Invalid currency value");
            }
            this.wholePart = (int) currencyValue;
            this.fractionalPart = ((int) (currencyValue * 100)) % 100;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    Currency(Currency currency) {
        this.wholePart = currency.getWholePart();
        this.fractionalPart = currency.getFractionalPart();
    }

    /**
     *
     * Algorithm getWholePart()
     * Algorithm getFractionalPart()
     *
     * The getter methods gets one of the requested properties of the Currency class on which it is called.
     * Pre:
     * Post:
     * Return: integer value of the one of the property of the Currency class.
     */

    /*
     * return the whole or fractional part property of this class.
     */
    public int getWholePart() {
        return wholePart;
    }

    /**
     *
     * Algorithm setWholePart (wholePart)
     * Algorithm setFractionalPart (fractionalPart)
     *
     *
     * The setter methods sets one of the properties of the class on which it is called using the input parameter .
     * Pre:  wholePart or fractionalPart - integer value of the respective property.
     * Post: the class property whole part or fractional part is set to the given input value for this object.
     * Return:
     */

    /*
     * set the one of the property of this class to the given input value.
     */
    public void setWholePart(int wholePart) {
        this.wholePart = wholePart;
    }

    public int getFractionalPart() {
        return fractionalPart;
    }

    public void setFractionalPart(int fractionalPart) {
        this.fractionalPart = fractionalPart;
    }

    public abstract String getName ();

    public abstract void setName (String name);

    /**
     *
     * Algorithm add (currency)
     *
     * This method adds the given input currency value to the current value using their whole and fractional part.
     * Pre: currency - input currency value to be added to the current value.
     * Post:  The current value of currency is added by adding whole and fractional part.
     * Return:
     */

    /*
     * add the whole part of the input currency to current whole part property
     * add the fractional part of the input currency to the current fractional part property.
     * if(fractional part is greater than 100){
     *      increment whole part
     *      adjust fractional part using remainder operator.
     * }
     */
    public void add(Currency currency) {
        this.wholePart += currency.getWholePart();
        this.fractionalPart += currency.getFractionalPart();
        if (this.fractionalPart >= 100) {
            this.wholePart++;
            this.fractionalPart = this.fractionalPart % 100;
        }
    }

    /**
     *
     * Algorithm subtract (currency)
     *
     * This method subtracts the given input currency value from the current value using their whole and fractional part.
     * Pre: currency - input currency value to be subtracted from the current value.
     * Post:  The current value of currency is subtracted by subtracting whole and fractional part.
     * Return:
     */

    /*
     * subtract the whole part of the input currency from the current whole part property
     * if(fractional part of input is greater than current fractional part){
     *      decrement the whole part
     *      adjust fractional part using 100-(input fractional part- current fractional part).
     * }else{
     * subtract the fractional part of the input currency from the current fractional part property.
     * }
     */
    public void subtract(Currency currency) {
        this.wholePart -= currency.getWholePart();
        if (currency.getFractionalPart() > this.fractionalPart) {
            this.wholePart--;
            this.fractionalPart = 100 - (currency.getFractionalPart() - this.fractionalPart);
        } else {
            this.fractionalPart -= currency.getFractionalPart();
        }
    }




    /**
     *
     * Algorithm equals (currency)
     *
     * This method checks for equality between the given input currency value and the current value by comparing their
     * whole and fractional part.
     * Pre: currency - input currency value to be compared to the current value.
     * Post:
     * Return: true or false depending on the whether the two values are equal or not.
     */

    /*
     * return true if both whole and fractional part are equals and false otherwise.
     */
    public boolean isEqual(Currency currency) {
        return this.wholePart == currency.getWholePart() && this.fractionalPart == currency.getFractionalPart();
    }

    /**
     *
     * Algorithm isGreater (currency)
     *
     * This method compares the given input currency value to the current value for greater value between them by comparing
     * their whole and fractional part.
     * Pre: currency - input currency value to be compared to the current value.
     * Post:
     * Return: true or false depending on the whether the current value is greater than input value.
     */

    /*
     *  if(current whole part and fractional part is greater than input whole part and fractional part){
     *      return true
     *   }
     *  else{
     *     return false
     *  }
     */
    public boolean isGreater(Currency currency) {
        if (this.wholePart > currency.getWholePart() || this.wholePart == currency.getWholePart() && this.fractionalPart > currency.getFractionalPart()) {
            return true;
        } else {
            return false;
        }
    }

    public abstract void print();

    public abstract boolean isSameType(Currency currency);
}

