
package com.MGLC.activitesdoctorants.configuration;


import com.MGLC.activitesdoctorants.dto.YearlyAbsenceCount;
import com.MGLC.activitesdoctorants.repositories.AbsenceRepo;
import com.MGLC.activitesdoctorants.services.DemoDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class DemoDataConf {

    private final DemoDataService demoDataService;
    private final AbsenceRepo absenceRepo;

    @Autowired
    public DemoDataConf(DemoDataService demoDataService, AbsenceRepo absenceRepo) {
        this.demoDataService = demoDataService;
        this.absenceRepo = absenceRepo;
    }

    @PostConstruct
    public void init() {
        // Call the insertDemoData method when the application starts
        demoDataService.insertDemoData();

        List<Object[]> result = absenceRepo.countAbsencesByYear(1L);

        List<YearlyAbsenceCount> absences = result.stream()
                .map(arr -> new YearlyAbsenceCount((Integer) arr[0], (Long) arr[1], (Long) arr[2]))
                .collect(Collectors.toList());

        System.out.println(
                "-------------------------------------------------------LOG---------------------------------------");
        for (YearlyAbsenceCount yearlyAbsenceCount : absences) {
            System.out
                    .println("Year: " + yearlyAbsenceCount.getDate() + ", Count basences: "
                            + yearlyAbsenceCount.getAbsences()
                            + ", Total des reunions: " + yearlyAbsenceCount.getTotal());
        }
        System.out.println(
                "-------------------------------------------------------LOG---------------------------------------");

    }
}