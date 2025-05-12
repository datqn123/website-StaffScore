package com.example.rate.mapper;

import com.example.rate.models.admin.Department;
import com.example.rate.models.admin.DepartmentRequest;
import com.example.rate.models.admin.DepartmentResponse;
import com.example.rate.models.admin.DepartmentUpdateRequest;
import com.example.rate.models.contract.Contract;
import com.example.rate.models.contract.ContractRequest;
import com.example.rate.models.contract.ContractResponse;
import com.example.rate.models.contract.ContractUpdateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ContractMapper {
    @Mapping(target = "user", ignore = true)
    Contract toContract(ContractRequest request);
    ContractResponse toContractResponse(Contract contract);
    @Mapping(target = "user", ignore = true)
    void updateContract(@MappingTarget Contract contract, ContractUpdateRequest contractUpdateRequest);
}
