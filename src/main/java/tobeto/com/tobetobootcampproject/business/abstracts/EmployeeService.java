package tobeto.com.tobetobootcampproject.business.abstracts;

import tobeto.com.tobetobootcampproject.business.request.create.CreateEmployeeCreateRequest;
import tobeto.com.tobetobootcampproject.business.request.update.UpdateEmployeeRequest;
import tobeto.com.tobetobootcampproject.business.response.create.CreateEmployeeResponse;
import tobeto.com.tobetobootcampproject.business.response.get.GetAllEmployeeResponse;
import tobeto.com.tobetobootcampproject.business.response.get.GetEmployeeByIdResponse;
import tobeto.com.tobetobootcampproject.business.response.get.GetEmployeeByPositionResponse;
import tobeto.com.tobetobootcampproject.business.response.update.UpdateEmployeeResponse;
import tobeto.com.tobetobootcampproject.core.utilities.paging.PageDto;
import tobeto.com.tobetobootcampproject.core.utilities.results.DataResult;
import tobeto.com.tobetobootcampproject.core.utilities.results.Result;

import java.util.List;

public interface EmployeeService {
    DataResult<CreateEmployeeResponse> createEmployee(
            CreateEmployeeCreateRequest request
    );

    DataResult<List<GetAllEmployeeResponse>> getAllEmployee(

    );

    DataResult<GetEmployeeByIdResponse> getEmployeeById(
            int id
    );

    DataResult<UpdateEmployeeResponse> updateEmployee(
            UpdateEmployeeRequest request,
            int id
    );

    DataResult<List<GetEmployeeByPositionResponse>> getEmployeeByPosition(
            String position
    );

    DataResult<List<GetAllEmployeeResponse>> getAllSorted(
            PageDto pageDto
    );

    Result deleteEmployeeById(
            int id
    );
}
