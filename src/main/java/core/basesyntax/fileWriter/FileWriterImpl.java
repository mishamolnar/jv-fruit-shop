package core.basesyntax.fileWriter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FileWriterImpl {
    public void writeInFile(Set<Map.Entry<String, Integer>> entries, String toFile) {
        File file = new File(toFile);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write("fruit,quantity");
            bufferedWriter.newLine();
            for (Map.Entry<String, Integer> fruit : entries) {
                bufferedWriter.write(fruit.getKey() + "," + fruit.getValue());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file" + toFile, e);
        }
    }
}
