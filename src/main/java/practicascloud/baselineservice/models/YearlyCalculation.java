package practicascloud.baselineservice.models;

import java.math.BigDecimal;

public class YearlyCalculation {

    private int year;

    private BigDecimal initialInvestment;

    private BigDecimal contribution;

    private BigDecimal interestRate;

    private BigDecimal finalAmount;

    public YearlyCalculation() {
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public BigDecimal getInitialInvestment() {
        return initialInvestment;
    }

    public void setInitialInvestment(BigDecimal initialInvestment) {
        this.initialInvestment = initialInvestment;
    }

    public BigDecimal getContribution() {
        return contribution;
    }

    public void setContribution(BigDecimal contribution) {
        this.contribution = contribution;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public BigDecimal getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(BigDecimal finalAmount) {
        this.finalAmount = finalAmount;
    }

    @Override
    public String toString() {
        return "YearlyCalculation{" +
                "year=" + year +
                ", initialInvestment=" + initialInvestment +
                ", contribution=" + contribution +
                ", interestRate=" + interestRate +
                ", finalAmount=" + finalAmount +
                '}';
    }
}
