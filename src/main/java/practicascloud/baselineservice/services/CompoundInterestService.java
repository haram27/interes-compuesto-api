package practicascloud.baselineservice.services;

import org.springframework.stereotype.Service;
import practicascloud.baselineservice.models.CalculationInput;
import practicascloud.baselineservice.models.TotalCalculation;
import practicascloud.baselineservice.models.YearlyCalculation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class CompoundInterestService {

    private final int scale = 2;
    private final int roundingMode = BigDecimal.ROUND_HALF_UP;
    private final BigDecimal divider = new BigDecimal("100").setScale(scale, roundingMode);

    public TotalCalculation calculate(CalculationInput input) {

        int year = 1;
        TotalCalculation totalCalculation = new TotalCalculation();
        List<YearlyCalculation> yearlyCalculations = new ArrayList<>();

        totalCalculation.setYearlyCalculations(yearlyCalculations);
        totalCalculation.setContributionAccumulator(new BigDecimal("0"));
        input.setAnnualContribution(input.getAnnualContribution() == null ? new BigDecimal("0") :
                input.getAnnualContribution());
        input.setContributionIncrease(input.getContributionIncrease() == null ? new BigDecimal("0") :
                input.getContributionIncrease());

        addYearCalculations(totalCalculation, year, input);

        totalCalculation.setFinalAmount(totalCalculation.getYearlyCalculations().get(
                totalCalculation.getYearlyCalculations().size() - 1).getFinalAmount());
        totalCalculation.setInvestmentWinnings(calculateInvestmentWinnings(totalCalculation.getFinalAmount(),
                input.getInitialInvestment(), totalCalculation.getContributionAccumulator()));
        System.out.println(totalCalculation);

        return totalCalculation;
    }

    private void addYearCalculations(TotalCalculation totalCalculation, int year, CalculationInput input) {

        YearlyCalculation yearlyCalculation = new YearlyCalculation();
        int lastIndex = totalCalculation.getYearlyCalculations().size() - 1;

        yearlyCalculation.setYear(year);

        yearlyCalculation.setInitialInvestment(year == 1 ? input.getInitialInvestment() :
                totalCalculation.getYearlyCalculations().get(lastIndex).getFinalAmount());

        yearlyCalculation.setContribution(year == 1 ? input.getAnnualContribution() :
                calculateAnnualContribution(totalCalculation.getYearlyCalculations().get(lastIndex).getContribution(),
                        input.getContributionIncrease()));

        yearlyCalculation.setInterestRate(calculateInterestRate(yearlyCalculation.getInitialInvestment(),
                yearlyCalculation.getContribution(), input.getPercentRate()));

        yearlyCalculation.setFinalAmount(calculateFinalAmount(yearlyCalculation.getInitialInvestment(),
                yearlyCalculation.getContribution(), yearlyCalculation.getInterestRate()));

        System.out.println(yearlyCalculation);
        totalCalculation.setContributionAccumulator(
                totalCalculation.getContributionAccumulator().add(yearlyCalculation.getContribution()));
        totalCalculation.getYearlyCalculations().add(yearlyCalculation);
        year++;

        if (year <= input.getInvestmentYears()) {
            addYearCalculations(totalCalculation, year, input);
        }

    }

    private BigDecimal calculateAnnualContribution(BigDecimal previousContribution, BigDecimal contributionIncrease) {
        BigDecimal one = new BigDecimal("1").setScale(scale, roundingMode);

        previousContribution = previousContribution.setScale(scale, roundingMode);
        contributionIncrease = contributionIncrease.setScale(scale, roundingMode);

        BigDecimal result = contributionIncrease.divide(divider);
        result = one.add(result);
        result = previousContribution.multiply(result);
        result = result.setScale(scale, roundingMode);
        return result;
    }

    private BigDecimal calculateInterestRate(BigDecimal initialInvestment, BigDecimal contribution,
                                             BigDecimal percentRate) {
        initialInvestment = initialInvestment.setScale(scale, roundingMode);
        contribution = contribution.setScale(scale, roundingMode);
        percentRate = percentRate.setScale(scale, roundingMode);

        BigDecimal result = percentRate.divide(divider);
        result = (initialInvestment.add(contribution)).multiply(result);
        result = result.setScale(scale, roundingMode);
        return result;
    }

    private BigDecimal calculateFinalAmount(BigDecimal initialInvestment, BigDecimal contribution,
                                            BigDecimal interestRate) {
        initialInvestment = initialInvestment.setScale(scale, roundingMode);
        contribution = contribution.setScale(scale, roundingMode);
        interestRate = interestRate.setScale(scale, roundingMode);

        BigDecimal result = initialInvestment.add(contribution).add(interestRate);
        result = result.setScale(scale, roundingMode);
        return result;
    }

    private BigDecimal calculateInvestmentWinnings(BigDecimal finalAmount, BigDecimal initialInvestment,
                                                   BigDecimal contributions) {
        finalAmount = finalAmount.setScale(scale, roundingMode);
        initialInvestment = initialInvestment.setScale(scale, roundingMode);
        contributions = contributions.setScale(scale, roundingMode);

        BigDecimal result = finalAmount.subtract(initialInvestment).subtract(contributions);
        result = result.setScale(scale, roundingMode);
        return result;
    }

}
