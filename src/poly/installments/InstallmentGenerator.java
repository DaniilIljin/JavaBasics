package poly.installments;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class InstallmentGenerator {

    private ArrayList<Installment> neededInstalment = new ArrayList<>();
    private Integer ammount;
    private Integer months;
    private Integer instAmm;
    private LocalDate dateForInstallment;

    public List<Installment> generateRowsFor(Integer amount, LocalDate periodStart, LocalDate periodEnd) {
        this.months = Period.between(periodStart, periodEnd).getMonths();
        this.dateForInstallment = periodStart;
        this.ammount = amount;
        instAmm = amount;
        if(months != 0 && amount > 3){
            instAmm = amount / (months + 1);
            if(instAmm < 3){
                instAmm = 3;
            }
        }
        neededInstalment.add(new Installment(instAmm, dateForInstallment));
        this.ammount -= instAmm;
        if (this.ammount != 0) {
            extracted();
        }
        return neededInstalment;
    }

    private void extracted() {
        for (int i = 0; i < months; i++) {
            if(i == months - 1 || ammount < 2 * instAmm){
                instAmm = ammount;
            }
            if(i == months - 2 && ammount > 2 * instAmm){
                    instAmm = ammount / 2;
            }
            dateForInstallment = dateForInstallment.plusMonths(1).withDayOfMonth(1);
            neededInstalment.add(new Installment(instAmm, dateForInstallment));
            ammount -= instAmm;
            if(ammount == 0){
                break;
            }
        }
    }
}
