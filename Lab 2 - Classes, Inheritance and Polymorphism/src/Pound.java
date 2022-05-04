/**
 * Lab 2 Team 12
 * @author Won Jun Cho
 * This class is designed for Pound which inherits from Currency class to build a currency simulator using classes,inheritance and polymorphism.
 */
public class Pound extends Currency {
    private String name;

    Pound() {
        super();
        this.name = "Pound";
    }

    Pound(double input) {
        super(input);
        this.name = "Pound";
    }

    /**
     *
     * Algorithm getName ()
     *
     * The getter methods gets one of the requested properties of the class on which it is called.
     * Pre:
     * Post:
     * Return: string value of the name property.
     */

    /*
     * return the name property of this class.
     */
    public String getName() {
        return name;
    }

    /**
     *
     * Algorithm setName (name)
     *
     * The setter methods sets one of the properties of the class on which it is called using the input parameter .
     * Pre: name - string value of the currency name
     * Post: the class property name is set to the given input value for this object.
     * Return:
     */

    /*
     * set the name property of this class to the given input value.
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     *
     * Algorithm add (currency)
     *
     * This method adds the given input currency value to the current value if the currency is of same type and valid.
     * Pre: currency - input currency value to be added to current value.
     * Post:  The current value of currency is added if the currency is same and if not exception is thrown.
     * Return:
     */

    /*
     * try{
     *   if(check currency is same){
     *     add(currency) using base class add method
     *  }else{
     *    throw exception if currency is different
     *  }
     * }catch{
     *    print exception message
     * }
     */
    @Override
    public void add (Currency currency) {
        try {
            if (isSameType(currency)) {
                super.add(currency);
            }else{
                throw new Exception("Invalid addition");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    /**
     *
     * Algorithm subtract (currency)
     *
     * This method subtracts the given input currency value from the current value if the currency is of same type and valid.
     * Pre: currency - input currency value to be subtracted from the current value.
     * Post: The current value of currency is subtracted if the currency is same and the resultant value is greater than
     * zero and if not exception is thrown.
     * Return:
     */

    /*
     * try{
     *   if(check currency is same or current value is greater than value to be subtracted){
     *       subtract(currency) using base class subtract method
     *   }else{
     *      throw exception if currency is different or current value is less than input value to be subtracted
     *   }
     * }catch{
     *    print exception message
     * }
     */
    @Override
    public void subtract (Currency currency) {
        try {
            if (isSameType(currency) && this.isGreater(currency)) {
                super.subtract(currency);
            }else{
                throw new Exception("Invalid subtraction");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     *
     * Algorithm equals (currency)
     *
     * This method checks for equality between the given input currency value and the current value of the same type.
     * Pre: currency - input currency value to be compared to the current value.
     * Post:
     * Return: true or false depending on the whether the two values are equal or not.
     */

    /*
     * try{
     *   if(check currency is same){
     *          return equals(currency) using base class equals method for equality comparison.
     *     }else{
     *       throw exception if currency is different.
     *  }catch{
     *       print exception message
     *    }
     *  return false
     */
    @Override
    public boolean isEqual (Currency money) {
        if (isSameType(money)) {
            super.isEqual(money);
        }
        return false;
    }

    /**
     *
     * Algorithm isGreater (currency)
     *
     * This method compares the given input currency value of the same type to the current value for greater value between them.
     * Pre: currency - input currency value to be compared to the current value.
     * Post:
     * Return: true or false depending on the whether the current value is greater than input value.
     */

    /*
     * try{
     *  if(check currency is same){
     *       return isGreater(currency) using base class isGreater method to check for greater value.
     *  }else{
     *      throw exception if currency is different
     *    }
     *  }catch{
     *      print exception message
     * }
     */
    public boolean isGreater(Currency currency) {
        try{
            if(isSameType(currency)){
                return super.isGreater(currency);
            }else {
                throw new Exception("Invalid Comparison");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    /**
     *
     * Algorithm isSameType (currency)
     *
     * This method checks whether the currency is of same type or not by checking the name property.
     * Pre: currency - input currency for type checking.
     * Post:
     * Return: true or false depending on whether currency is of same type or not.
     */
    @Override
    public boolean isSameType (Currency currency) {
        return this.name.equals(currency.getName());
    }

    /**
     *
     * Algorithm print ()
     *
     * This method prints the current currency value using the whole,fractional and name property.
     * Pre:
     * Post: prints the current currency value.
     * Return:
     */

    /*
     * format the string using whole and fractional part with two places after decimal.
     * print the formatted string of whole and fractional part followed by the name property.
     */
    @Override
    public void print () {
        if (this.getFractionalPart() < 10) {
            System.out.print(this.getWholePart() + ".0" + this.getFractionalPart() + " " + name + " ");
        } else {
            System.out.print(this.getWholePart() + "." + this.getFractionalPart() + " " + name + " ");
        }
    }
}

