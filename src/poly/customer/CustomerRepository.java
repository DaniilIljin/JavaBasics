package poly.customer;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerRepository {

    private final DateTimeFormatter formatter = DateTimeFormatter
            .ofPattern("yyyy-MM-dd");

    private static final String FILE_PATH = "src/poly/customer/data.txt";

    private List<AbstractCustomer> customers = createCustomers(readFromFile());

    public List<String> readFromFile(){
        try {
            return Files.readAllLines(Paths.get(FILE_PATH));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<AbstractCustomer> createCustomers(List<String> customersData){
        List<AbstractCustomer> currentCustomers = new ArrayList<>();
        for (String line : customersData) {
            String[] needed = line.split(";");
            if (needed[0].equals("GOLD")){
                currentCustomers.add(new GoldCustomer(needed[1], needed[2],
                        Integer.valueOf(needed[3])));
            } else {
                currentCustomers.add(new RegularCustomer(needed[1],
                        needed[2], Integer.valueOf(needed[3]), LocalDate.parse(needed[4], formatter)));
            }
        }
        return currentCustomers;
    }

    public void writeToFile(List<AbstractCustomer> customers){
        try {
            FileWriter writer = new FileWriter(FILE_PATH.toString());
            for (AbstractCustomer customer : customers) {
                writer.write(customer.toString() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Optional<AbstractCustomer> getCustomerById(String id) {
        customers = createCustomers(readFromFile());
        return customers.stream()
                .filter(each -> each.getId().equals(id))
                .findFirst();
    }

    public void remove(String id) {
        if(getCustomerById(id).isPresent()){
            AbstractCustomer a = getCustomerById(id).get();
            customers.remove(a);
            writeToFile(customers);
        }
    }

    public void save(AbstractCustomer customer) {
        if(customers.contains(customer)){
            writeToFile(customers);
        } else {
            customers.add(customer);
            writeToFile(customers);
        }
    }

    public int getCustomerCount() {
        return readFromFile().size();
    }
}
