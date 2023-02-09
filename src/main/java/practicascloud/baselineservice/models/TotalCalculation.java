package practicascloud.baselineservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.util.List;

public class TotalCalculation {

    private BigDecimal investmentWinnings;

    private BigDecimal finalAmount;

    @JsonIgnore
    private BigDecimal contributionAccumulator;

    private List<YearlyCalculation> yearlyCalculations;

    public TotalCalculation() {
    }

    public BigDecimal getInvestmentWinnings() {
        return investmentWinnings;
    }

    public void setInvestmentWinnings(BigDecimal investmentWinnings) {
        this.investmentWinnings = investmentWinnings;
    }

    public BigDecimal getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(BigDecimal finalAmount) {
        this.finalAmount = finalAmount;
    }

    public BigDecimal getContributionAccumulator() {
        return contributionAccumulator;
    }

    public void setContributionAccumulator(BigDecimal contributionAccumulator) {
        this.contributionAccumulator = contributionAccumulator;
    }

    public List<YearlyCalculation> getYearlyCalculations() {
        return yearlyCalculations;
    }

    public void setYearlyCalculations(List<YearlyCalculation> yearlyCalculations) {
        this.yearlyCalculations = yearlyCalculations;
    }

    @Override
    public String toString() {
        return "TotalCalculation{" +
                "investmentWinnings=" + investmentWinnings +
                ", finalAmount=" + finalAmount +
                ", contributionAccumulator=" + contributionAccumulator +
                ", yearlyCalculations=" + yearlyCalculations +
                '}';
    }
}
