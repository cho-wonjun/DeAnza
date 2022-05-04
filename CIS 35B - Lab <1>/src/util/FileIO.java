package util;

import model.Automobile;

import java.io.*;

public class FileIO {
    public Automobile buildAutoObject (String fileName) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));

            String name = br.readLine();
            float basePrice = Float.parseFloat(br.readLine());
            int size = Integer.parseInt(br.readLine());
            Automobile a = new Automobile(name, basePrice, size);

            for (int i = 0; i < size; i++) { // optionset
                br.readLine(); // skip a line

                String setName = br.readLine();
                int setSize = Integer.parseInt(br.readLine());

                a.setOptionSets(setName, setSize, i);

                for (int j = 0; j < setSize; j++) { // option
                    String optionName = br.readLine();
                    float optionPrice = Float.parseFloat(br.readLine());

                    a.setOption(optionName, optionPrice, i, j);
                }
            }
            br.close();
            return a;
        } catch (IOException e) {
            return null;
            //e.printStackTrace();
        }
    }

    public void serialize (Automobile a, String fileName) {
        try {
            ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(fileName));
            oo.writeObject(a);
            oo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Automobile deserialize (String filename) {
        try {
            ObjectInputStream oi = new ObjectInputStream(new FileInputStream(filename));
            Automobile a = (Automobile) oi.readObject();
            oi.close();
            return a;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
