package whyaop.with_aop.actions;

import com.spring.professional.exam.tutorial.module02.question01.with.aop.bls.ComplexReportFormatter;
import com.spring.professional.exam.tutorial.module02.question01.with.aop.bls.ComplexReportProvider;
import com.spring.professional.exam.tutorial.module02.question01.with.aop.bls.ComplexReportRepository;
import com.spring.professional.exam.tutorial.module02.question01.with.aop.ds.FormattedReport;
import com.spring.professional.exam.tutorial.module02.question01.with.aop.ds.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import whyaop.with_aop.bls.ComplexReportFormatter;
import whyaop.with_aop.bls.ComplexReportProvider;
import whyaop.with_aop.bls.ComplexReportRepository;
import whyaop.with_aop.ds.FormattedReport;
import whyaop.with_aop.ds.Report;

@Component
public class ComplexReportAction {

    @Autowired
    private ComplexReportProvider complexReportProvider;
    @Autowired
    private ComplexReportFormatter complexReportFormatter;
    @Autowired
    private ComplexReportRepository complexReportRepository;

    public void perform() throws InterruptedException {
        Report report = complexReportProvider.getReport();
        FormattedReport formattedReport = complexReportFormatter.formatReport(report);
        complexReportRepository.save(formattedReport);

        report = complexReportProvider.getReport();
    }
}
