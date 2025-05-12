package com.example.rate.models.report;

import com.example.rate.dto.response.ApiResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/report")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ReportController {
    ReportService reportService;

    @PostMapping
    ApiResponse<ReportResponse> create(@RequestBody ReportRequest request) {
        ApiResponse<ReportResponse> response = new ApiResponse<>();
        response.setResult(reportService.create(request));
        return response;
    }
}
