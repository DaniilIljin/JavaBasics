package fp.sales;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class Repository {

    private static final String FILE_PATH = "src/fp/sales/sales-data.csv";

    private final DateTimeFormatter formatter = DateTimeFormatter
            .ofPattern("dd.MM.yyyy");

    public List<Entry> getEntries(){
        try {
            List<String> lines = Files.readAllLines(Paths.get(FILE_PATH));
            lines.remove(0);
            return lines.stream()
                    .map(this::makeNewEntry)
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Entry makeNewEntry(String line){
        String[] array = line.split("\t");
        Entry needed = new Entry();
        needed.setDate(LocalDate.parse(array[0], formatter));
        needed.setState(array[1]);
        needed.setProductId(array[2]);
        needed.setCategory(array[3]);
        needed.setAmount(Double.parseDouble(String.join(".",array[5].split(","))));
        return needed;
    }

}
