package com.example.rate.mapper;

import com.example.rate.models.contract.Contract;
import com.example.rate.models.contract.ContractRequest;
import com.example.rate.models.contract.ContractResponse;
import com.example.rate.models.contract.ContractUpdateRequest;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-12T00:49:06+0700",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.7 (Oracle Corporation)"
)
@Component
public class ContractMapperImpl implements ContractMapper {

    @Override
    public Contract toContract(ContractRequest request) {
        if ( request == null ) {
            return null;
        }

        Contract.ContractBuilder contract = Contract.builder();

        contract.position( request.getPosition() );
        contract.start( request.getStart() );
        contract.end( request.getEnd() );

        return contract.build();
    }

    @Override
    public ContractResponse toContractResponse(Contract contract) {
        if ( contract == null ) {
            return null;
        }

        ContractResponse.ContractResponseBuilder contractResponse = ContractResponse.builder();

        contractResponse.id( contract.getId() );
        contractResponse.user( contract.getUser() );
        contractResponse.position( contract.getPosition() );
        contractResponse.contractName( contract.getContractName() );
        contractResponse.start( contract.getStart() );
        contractResponse.end( contract.getEnd() );

        return contractResponse.build();
    }

    @Override
    public void updateContract(Contract contract, ContractUpdateRequest contractUpdateRequest) {
        if ( contractUpdateRequest == null ) {
            return;
        }
    }
}
