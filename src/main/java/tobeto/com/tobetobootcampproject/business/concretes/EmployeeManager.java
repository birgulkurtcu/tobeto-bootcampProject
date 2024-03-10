package tobeto.com.tobetobootcampproject.business.concretes;

import tobeto.com.tobetobootcampproject.business.abstracts.EmployeeService;
import tobeto.com.tobetobootcampproject.business.request.create.CreateEmployeeCreateRequest;
import tobeto.com.tobetobootcampproject.business.request.update.UpdateEmployeeRequest;
import tobeto.com.tobetobootcampproject.business.response.create.CreateEmployeeResponse;
import tobeto.com.tobetobootcampproject.business.response.get.GetAllEmployeeResponse;
import tobeto.com.tobetobootcampproject.business.response.get.GetEmployeeByIdResponse;
import tobeto.com.tobetobootcampproject.business.response.get.GetEmployeeByPositionResponse;
import tobeto.com.tobetobootcampproject.business.response.update.UpdateEmployeeResponse;
import tobeto.com.tobetobootcampproject.business.rules.UserBusinessRules;
import tobeto.com.tobetobootcampproject.core.aspects.logging.Loggable;
import tobeto.com.tobetobootcampproject.core.utilities.modelmapper.ModelMapperService;
import tobeto.com.tobetobootcampproject.core.utilities.paging.PageDto;
import tobeto.com.tobetobootcampproject.core.utilities.results.DataResult;
import tobeto.com.tobetobootcampproject.core.utilities.results.Result;
import tobeto.com.tobetobootcampproject.core.utilities.results.SuccessDataResult;
import tobeto.com.tobetobootcampproject.core.utilities.results.SuccessResult;
import tobeto.com.tobetobootcampproject.dataaaccess.EmployeeRepository;
import tobeto.com.tobetobootcampproject.entities.Employee;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeManager implements EmployeeService {
    private EmployeeRepository employeeRepository;
    private ModelMapperService mapperService;
    private UserBusinessRules userBusinessRules;
    @Override
    @Loggable
    public DataResult<CreateEmployeeResponse> createEmployee(
            CreateEmployeeCreateRequest request)
    {
        userBusinessRules.checkIfEmailExist(request.getEmail());
        userBusinessRules.checkIfUsernameExist(request.getUserName());
        userBusinessRules.checkIfNationalIdentityExist(request.getNationalIdentity());

        Employee employee = mapperService.forRequest()
                .map(request,Employee.class);

        employee.setCreatedDate(LocalDateTime.now());

        employeeRepository.save(employee);

        CreateEmployeeResponse response = mapperService.forResponse()
                .map(employee,CreateEmployeeResponse.class);

        return new SuccessDataResult
                <CreateEmployeeResponse>
                (response,"Employee created successfully.");
    }

    @Override
    public DataResult<List<GetAllEmployeeResponse>> getAllEmployee(

    ) {
        List <Employee> employees = employeeRepository.findAll();

        List <GetAllEmployeeResponse> response = employees.stream()
                .map(employee -> mapperService.forResponse()
                .map(employee, GetAllEmployeeResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult
                <List<GetAllEmployeeResponse>>
                (response, "All Employees Listed");
    }

    @Override
    public DataResult<GetEmployeeByIdResponse> getEmployeeById(
            int id
    ) {
        Employee employee = employeeRepository.findById(id).orElseThrow();

        GetEmployeeByIdResponse response = mapperService.forResponse()
                .map(employee, GetEmployeeByIdResponse.class);

        return new SuccessDataResult
                <GetEmployeeByIdResponse>
                (response, "The Employee Listed");
    }

    @Override
    public DataResult<UpdateEmployeeResponse> updateEmployee(
            UpdateEmployeeRequest request, int id
    ) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("There is no employee with this ID."));

        Employee updatedEmployee = mapperService.forRequest()
                .map(request, Employee.class);

        employee.setId(id);
        employee.setUpdatedDate(LocalDateTime.now());
        employee.setFirstName(updatedEmployee.getFirstName() != null ? updatedEmployee.getFirstName() : employee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName() != null ? updatedEmployee.getLastName() : employee.getLastName());
        employee.setUserName(updatedEmployee.getUserName() != null ? updatedEmployee.getUserName() : employee.getUserName());
        employee.setNationalIdentity(updatedEmployee.getNationalIdentity() != null ? updatedEmployee.getNationalIdentity() : employee.getNationalIdentity());
        employee.setDateOfBirth((updatedEmployee.getDateOfBirth() != null ? updatedEmployee.getDateOfBirth() : employee.getDateOfBirth()));
        employee.setPosition(updatedEmployee.getPosition() != null ? updatedEmployee.getPosition() : employee.getPosition());

        employeeRepository.save(employee);
        UpdateEmployeeResponse response = mapperService.forResponse()
                .map(employee, UpdateEmployeeResponse.class);

        return new SuccessDataResult
                <UpdateEmployeeResponse>
                (response, "Employee Updated");
    }

    @Override
    public DataResult<List<GetEmployeeByPositionResponse>> getEmployeeByPosition(
            String position
    ) {
        List<Employee> employees = employeeRepository.findAllByPosition(position);

        List<GetEmployeeByPositionResponse> response = employees.stream()
                .map(employee -> mapperService.forResponse()
                .map(employee, GetEmployeeByPositionResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult
                <List<GetEmployeeByPositionResponse>>
                (response, "All Employees Listed By Position");
    }

    @Override
    public DataResult<List<GetAllEmployeeResponse>> getAllSorted(
            PageDto pageDto
    ) {
        Sort sort = Sort.by(Sort.Direction.fromString
                (pageDto.getSortDirection()), pageDto.getSortBy());

        Pageable pageable = PageRequest.of
                (pageDto.getPageNumber(), pageDto.getPageSize(), sort);

        Page<Employee> employees = employeeRepository.findAll(pageable);

        List <GetAllEmployeeResponse> response = employees.stream()
                .map(employee -> mapperService.forResponse()
                        .map(employee, GetAllEmployeeResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult
                <List<GetAllEmployeeResponse>>
                (response, "All Employees Sorted");
    }

    @Override
    public Result deleteEmployeeById(
            int id
    ) {
        employeeRepository.deleteById(id);
        return new SuccessResult("Employee Deleted!");
    }
}
