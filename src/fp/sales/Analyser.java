package fp.sales;


import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Analyser {

    private Repository repository;

    public Analyser(Repository repository) {
        this.repository = repository;
    }

    public Double getTotalSales() {
        return repository.getEntries().stream()
                .mapToDouble(Entry::getAmount)
                .sum();
    }

    public Double getSalesByCategory(String category) {
        return repository.getEntries().stream()
                .filter(x -> x.getCategory().equals(category))
                .mapToDouble(Entry::getAmount)
                .sum();
    }

    public Double getSalesBetween(LocalDate start, LocalDate end) {
        return repository.getEntries().stream()
                .filter(x -> x.getDate().compareTo(start) > 0)
                .filter(x -> x.getDate().compareTo(end) < 0)
                .mapToDouble(Entry::getAmount)
                .sum();
    }

    public String mostExpensiveItems() {
        return repository.getEntries().stream()
                .sorted(Collections.reverseOrder(Comparator.comparing(Entry::getAmount)))
                .limit(3)
                .map(Entry::getProductId)
                .sorted()
                .collect(Collectors.joining(", "));
    }

    public String statesWithBiggestSales() {
        Map<String, Double> stateAndSales = repository.getEntries().stream()
                .collect(Collectors.toMap(
                        Entry::getState,
                        Entry::getAmount,
                        Double::sum));
        Map<String, Double> copy = new HashMap<>(stateAndSales);
        return stateAndSales.keySet().stream()
                .sorted(Collections.reverseOrder(Comparator.comparing(x -> copy.get(x))))
                .limit(3)
                .collect(Collectors.joining(", "));
    }
}
