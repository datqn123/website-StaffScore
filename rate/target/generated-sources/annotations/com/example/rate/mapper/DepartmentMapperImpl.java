package com.example.rate.mapper;

import com.example.rate.models.department.Department;
import com.example.rate.models.department.DepartmentRequest;
import com.example.rate.models.department.DepartmentResponse;
import com.example.rate.models.department.DepartmentUpdateRequest;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-15T09:59:55+0700",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.7 (Oracle Corporation)"
)
@Component
public class DepartmentMapperImpl implements DepartmentMapper {

    @Override
    public Department toDepartment(DepartmentRequest request) {
        if ( request == null ) {
            return null;
        }

        Department.DepartmentBuilder department = Department.builder();

        department.id( request.getId() );
        department.departmentName( request.getDepartmentName() );
        department.departmentHead( request.getDepartmentHead() );
        department.divisionDirector( request.getDivisionDirector() );

        return department.build();
    }

    @Override
    public DepartmentResponse toDepartmentResponse(Department department) {
        if ( department == null ) {
            return null;
        }

        DepartmentResponse.DepartmentResponseBuilder departmentResponse = DepartmentResponse.builder();

        departmentResponse.id( department.getId() );
        departmentResponse.departmentName( department.getDepartmentName() );
        departmentResponse.departmentHead( department.getDepartmentHead() );
        departmentResponse.divisionDirector( department.getDivisionDirector() );

        return departmentResponse.build();
    }

    @Override
    public void updateDepartment(Department department, DepartmentUpdateRequest request) {
        if ( request == null ) {
            return;
        }

        department.setDepartmentName( request.getDepartmentName() );
        department.setDepartmentHead( request.getDepartmentHead() );
        department.setDivisionDirector( request.getDivisionDirector() );
    }
}
