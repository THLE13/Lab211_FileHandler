package common;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import model.Person;
import java.util.Scanner;

public class PersonManagement extends ArrayList<Person> {

    Library library = new Library();

    public List<Person> readFromFile(String path, int minSalary) throws FileNotFoundException, IOException {
        File file = new File(path);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()) {
            try {
                String line = scanner.nextLine();
                String token[] = line.split(";");
                double salary = Double.parseDouble(token[2].trim());
                if (salary >= minSalary) {
                    this.add(new Person(token[0].trim(), token[1].trim(), salary));
                }
            } catch (Exception e) {
            }
        }
        return this;
    }

    public String readFromFile(String fileName) throws FileNotFoundException {
        File f = new File(fileName);
        Scanner sc = new Scanner(f);

        if (!f.exists()) {
            System.out.println("File not exits!");
        }
        String s = "";
        while (sc.hasNext()) {
            s += sc.nextLine() + "\n";
        }
        return s;

    }

    public void writeToFile(String fileName, String s) throws IOException {
        File f = new File(fileName);
        FileWriter fw = new FileWriter(f, true);
        PrintWriter pw = new PrintWriter(fw);
        pw.append(s);
        pw.close();
        System.out.println("Write to file successfully!");
    }
    
    public void copyFile(String fileSrc, String newFile) throws FileNotFoundException, IOException {
        String result = readFromFile(fileSrc);
        writeToFile(newFile, result);
        System.out.println("Copy done...");
    }

}
