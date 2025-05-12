package com.example.rate.models.report;

import com.example.rate.exception.AppException;
import com.example.rate.exception.ErrorCode;
import com.example.rate.mapper.ContractMapper;
import com.example.rate.mapper.ReportMapper;
import com.example.rate.models.user.User;
import com.example.rate.models.user.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class ReportService {
    ReportRepository reportRepository;
    ReportMapper reportMapper;
    UserRepository userRepository;

    public ReportResponse create(ReportRequest request) {
        if(reportRepository.existsByTargetId(request.getTargetId()))
            throw new AppException(ErrorCode.REPORT_EXISTED);
        PerformanceReport report = reportMapper.toReport(request);
        User user = userRepository.findByUsername(request.getUser()).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));
        report.setUser(user);
        report.setCreatedAt(new Date());
        return reportMapper.toReportResponse(reportRepository.save(report));
    }


}
