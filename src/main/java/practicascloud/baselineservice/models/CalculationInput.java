package practicascloud.baselineservice.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class CalculationInput {

    @NotNull(message = "La inversión inicial debe ser igual o mayor a $1,000.00")
    @Min(value = 1000, message = "La inversión inicial debe ser igual o mayor a $1,000.00")
    private BigDecimal initialInvestment;

    @Min(value = 0, message = "La aportación anual debe ser igual o mayor a cero")
    private BigDecimal annualContribution;

    @Min(value = 0, message = "El incremento a la aportación anual debe ser igual o mayor a cero")
    private BigDecimal contributionIncrease;

    @Min(value = 1, message = "Los años de inversión deben ser mayor a cero")
    private int investmentYears;

    @Positive(message = "El rendimiento de inversión debe ser mayor a cero")
    private BigDecimal percentRate;

    public CalculationInput() {
    }

    public BigDecimal getInitialInvestment() {
        return initialInvestment;
    }

    public void setInitialInvestment(BigDecimal initialInvestment) {
        this.initialInvestment = initialInvestment;
    }

    public BigDecimal getAnnualContribution() {
        return annualContribution;
    }

    public void setAnnualContribution(BigDecimal annualContribution) {
        this.annualContribution = annualContribution;
    }

    public BigDecimal getContributionIncrease() {
        return contributionIncrease;
    }

    public void setContributionIncrease(BigDecimal contributionIncrease) {
        this.contributionIncrease = contributionIncrease;
    }

    public int getInvestmentYears() {
        return investmentYears;
    }

    public void setInvestmentYears(int investmentYears) {
        this.investmentYears = investmentYears;
    }

    public BigDecimal getPercentRate() {
        return percentRate;
    }

    public void setPercentRate(BigDecimal percentRate) {
        this.percentRate = percentRate;
    }

    @Override
    public String toString() {
        return "CalculationInput{" +
                "initialInvestment=" + initialInvestment +
                ", annualContribution=" + annualContribution +
                ", contributionIncrease=" + contributionIncrease +
                ", investmentYears=" + investmentYears +
                ", percentRate=" + percentRate +
                '}';
    }
}
