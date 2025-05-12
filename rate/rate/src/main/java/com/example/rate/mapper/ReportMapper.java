package com.example.rate.mapper;

import com.example.rate.models.report.PerformanceReport;
import com.example.rate.models.report.ReportRequest;
import com.example.rate.models.report.ReportResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReportMapper {
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    PerformanceReport toReport(ReportRequest request);
    @Mapping(target = "userId", source = "user.id")
    ReportResponse toReportResponse(PerformanceReport performanceReport);
}
