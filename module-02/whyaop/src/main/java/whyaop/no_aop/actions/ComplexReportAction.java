package whyaop.no_aop.actions;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import whyaop.no_aop.bls.ComplexReportFormatter;
import whyaop.no_aop.bls.ComplexReportProvider;
import whyaop.no_aop.bls.ComplexReportRepository;
import whyaop.no_aop.ds.FormattedReport;
import whyaop.no_aop.ds.Report;
import whyaop.no_aop.logger.PerformanceLogger;

@Component
public class ComplexReportAction {

    @Autowired
    private ComplexReportProvider complexReportProvider;
    @Autowired
    private ComplexReportFormatter complexReportFormatter;
    @Autowired
    private ComplexReportRepository complexReportRepository;
    @Autowired
    private PerformanceLogger performanceLogger;

    public void perform() throws InterruptedException {
        PerformanceLogger.PerformanceLoggerInfo performanceLoggerInfo;

        performanceLoggerInfo = performanceLogger.start("complexReportProvider.getReport()");
        Report report = complexReportProvider.getReport();
        performanceLogger.stop(performanceLoggerInfo);

        performanceLoggerInfo = performanceLogger.start("complexReportFormatter.formatReport(...)");
        FormattedReport formattedReport = complexReportFormatter.formatReport(report);
        performanceLogger.stop(performanceLoggerInfo);

        performanceLoggerInfo = performanceLogger.start("complexReportRepository.save(...)");
        complexReportRepository.save(formattedReport);
        performanceLogger.stop(performanceLoggerInfo);

        performanceLoggerInfo = performanceLogger.start("complexReportProvider.getReport()");
        report = complexReportProvider.getReport();
        performanceLogger.stop(performanceLoggerInfo);
    }
}
