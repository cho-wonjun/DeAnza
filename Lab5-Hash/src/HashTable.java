/**
 * Lab 5 Team 12
 *
 * @author Won Jun Cho and Shivam Sugandhi
 * This is a HashTable class used for efficient lookups and search on currency data.
 */
public class HashTable {

    private int size;
    private int numOfItems;
    private int numOfCollisions;
    private Currency[] hashTable;

    public HashTable(int size) {
        this.size = size;
        this.numOfItems = 0;
        this.hashTable = new Dollar[size];
    }


    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getNumOfItems() {
        return numOfItems;
    }

    public void setNumOfItems(int numOfItems) {
        this.numOfItems = numOfItems;
    }

    public int getNumOfCollisions() {
        return numOfCollisions;
    }

    public void setNumOfCollisions(int numOfCollisions) {
        this.numOfCollisions = numOfCollisions;
    }

    public Currency[] getHashTable() {
        return hashTable;
    }

    public void setHashTable(Currency[] hashTable) {
        this.hashTable = hashTable;
    }

    public double getLoadFactor() {
        return (double) this.numOfItems / this.size;
    }

    public boolean add(Currency currency) {
        int i = 0;
        int bucketsProbed = 0;
        int hashValue = hash(currency.getWholePart(), currency.getFractionalPart());
        int index = hashValue;

        while (bucketsProbed < size) {
            if (hashTable[index] == null) {
                hashTable[index] = currency;
                numOfItems++;
                if (getLoadFactor() >= 0.6) {
                    resize();
                }
                return true;
            }
            i = i + 1;
            index = (hashValue + i + i * i) % size;
            bucketsProbed++;
            numOfCollisions++;
        }
        return false;
    }

    public int search(Currency currency) {
        int i = 0;
        int bucketsProbed = 0;
        int hashValue = hash(currency.getWholePart(), currency.getFractionalPart());
        int index = hashValue;
        while (hashTable[index] != null && bucketsProbed < size) {
            if (hashTable[index] != null && hashTable[index].isEqual(currency)) {
                return index;
            }
            i = i + 1;
            index = (hashValue + i + i * i) % size;
            bucketsProbed++;
        }
        return -1;
    }

    public void resize() {
        int oldSize = size;
        size = sizeOfNextPrimeNum();
        Currency[] newHashTable = new Dollar[size];
        Currency[] temp = hashTable;
        hashTable = newHashTable;
        numOfItems = 0;

        for (int i = 0; i < oldSize; i++) {
            if (temp[i] != null) {
                add(temp[i]);
            }
        }
    }

    private int hash(int whole, int fraction) {
        return (2 * whole + 3 * fraction) % size;
    }

    private int sizeOfNextPrimeNum() {
        int nextSize = size * 2;
        for (int i = 2; i < nextSize; i++) {
            if (nextSize % i == 0) {
                nextSize++;
                i = 2;
            } else {
                continue;
            }
        }
        return nextSize;
    }

}
