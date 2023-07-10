package com.decagon.entity;

import com.decagon.enums.profileEnums.EmploymentStatusType;
import com.decagon.enums.profileEnums.ExtraIncomeType;
import com.decagon.enums.profileEnums.MonthlyIncomeRange;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IncomeStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private EmploymentStatusType employmentStatus;
    private MonthlyIncomeRange monthlyPersonalIncome;
    private boolean hasOtherSourcesOfIncome;
    private ExtraIncomeType extraIncomeDescription;
}
