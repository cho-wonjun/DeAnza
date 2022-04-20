package util;

import model.Automative;

import java.io.*;

public class FileIO {
    public Automative buildAutoObject (String fileName) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));

            String name = br.readLine();
            float basePrice = Float.parseFloat(br.readLine());
            int size = Integer.parseInt(br.readLine());
            Automative a = new Automative(name, basePrice, size);

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
            e.printStackTrace();
        }
        return null;
    }

    public void serialize (Automative a, String fileName) {
        try {
            ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(fileName));
            oo.writeObject(a);
            oo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Automative deserialize (String filename) {
        try {
            ObjectInputStream oi = new ObjectInputStream(new FileInputStream(filename));
            Automative a = (Automative) oi.readObject();
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
