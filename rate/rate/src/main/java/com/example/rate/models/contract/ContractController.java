package com.example.rate.models.contract;

import com.example.rate.dto.response.ApiResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contract")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ContractController {
    ContractService contractService;

    @PostMapping
    ApiResponse<ContractResponse> create(@RequestBody ContractRequest request) {
        ApiResponse<ContractResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(contractService.create(request));
        return apiResponse;
    }

    @GetMapping("/{id}")
    ApiResponse<ContractResponse> getOne(@PathVariable String id) {
        return ApiResponse.<ContractResponse>builder().result(contractService.getOne(id)).build();
    }

    @GetMapping
    List<Contract> getAll() {
        return contractService.getAll();
    }

    @DeleteMapping("{id}")
    void delete(@PathVariable String id) {
        contractService.delete(id);
    }

}
