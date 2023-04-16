package com.pidev.welend.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Configuration
@ConfigurationProperties(prefix = "loan.score.weights")
public class LoanScoreWeights {
    private double creditScore;
    private double income;
    private double debtToIncome;
    private double employmentHistory;
	public double getCreditScore() {
		return creditScore;
	}
	public void setCreditScore(double creditScore) {
		this.creditScore = creditScore;
	}
	public double getIncome() {
		return income;
	}
	public void setIncome(double income) {
		this.income = income;
	}
	public double getDebtToIncome() {
		return debtToIncome;
	}
	public void setDebtToIncome(double debtToIncome) {
		this.debtToIncome = debtToIncome;
	}
	public double getEmploymentHistory() {
		return employmentHistory;
	}
	public void setEmploymentHistory(double employmentHistory) {
		this.employmentHistory = employmentHistory;
	}
    
    

}
