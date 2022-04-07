package poly.customer;

import java.time.LocalDate;

public final class RegularCustomer extends AbstractCustomer {
    private LocalDate date;

    public RegularCustomer(String id, String name,
                           int bonusPoints, LocalDate lastOrderDate) {

        super(id, name, bonusPoints);

        setDate(lastOrderDate);
    }


    @Override
    public void collectBonusPointsFrom(Order order) {
        if(order.getTotal() > 100){
            if(date.plusDays(30).isAfter(order.getDate())){
                bonusPoints += order.getTotal() * 1.5;
            } else {
                bonusPoints += order.getTotal();
            }
        }
    }


    @Override
    public String asString() {
        return "REGULAR;" + id + ";" + name + ";" + bonusPoints + ";" + date.toString();
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}