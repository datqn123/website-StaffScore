package com.example.rate.mapper;

import com.example.rate.models.report.PerformanceReport;
import com.example.rate.models.report.ReportRequest;
import com.example.rate.models.report.ReportResponse;
import com.example.rate.models.user.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-15T09:59:55+0700",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.7 (Oracle Corporation)"
)
@Component
public class ReportMapperImpl implements ReportMapper {

    @Override
    public PerformanceReport toReport(ReportRequest request) {
        if ( request == null ) {
            return null;
        }

        PerformanceReport.PerformanceReportBuilder performanceReport = PerformanceReport.builder();

        performanceReport.id( request.getId() );
        performanceReport.targetId( request.getTargetId() );
        performanceReport.dedicationScore( request.getDedicationScore() );
        performanceReport.teamworkScore( request.getTeamworkScore() );
        performanceReport.complianceScore( request.getComplianceScore() );

        return performanceReport.build();
    }

    @Override
    public ReportResponse toReportResponse(PerformanceReport performanceReport) {
        if ( performanceReport == null ) {
            return null;
        }

        ReportResponse.ReportResponseBuilder reportResponse = ReportResponse.builder();

        reportResponse.userId( performanceReportUserId( performanceReport ) );
        reportResponse.id( performanceReport.getId() );
        reportResponse.targetId( performanceReport.getTargetId() );
        reportResponse.dedicationScore( performanceReport.getDedicationScore() );
        reportResponse.teamworkScore( performanceReport.getTeamworkScore() );
        reportResponse.complianceScore( performanceReport.getComplianceScore() );
        reportResponse.createdAt( performanceReport.getCreatedAt() );

        return reportResponse.build();
    }

    private String performanceReportUserId(PerformanceReport performanceReport) {
        User user = performanceReport.getUser();
        if ( user == null ) {
            return null;
        }
        return user.getId();
    }
}
