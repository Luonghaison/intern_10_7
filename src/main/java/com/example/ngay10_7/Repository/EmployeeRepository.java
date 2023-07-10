package com.example.ngay10_7.Repository;

import com.example.ngay10_7.Model.Employee;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
//Annotation @Scope được sử dụng để chỉ định phạm vi (scope) của một bean trong Spring framework. Trong trường hợp này, @Scope được sử dụng để chỉ định rằng bean được tạo ra sẽ có phạm vi singleton.
//Phạm vi singleton là phạm vi mặc định của các bean trong Spring framework. Khi một bean được định nghĩa với phạm vi singleton, Spring container sẽ chỉ tạo một và chỉ một instance (thể hiện) của bean đó, và cung cấp chúng cho bất kỳ bean nào yêu cầu.
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    //sử dụng annotation @Modifying để đánh dấu rằng phương thức updateEmployee() sẽ thực hiện các thao tác cập nhật dữ liệu
    @Modifying
    @Query("UPDATE Employee e SET e.name = :name, e.email = :email,e.department = :department WHERE e.id = :id")
    void updateEmployee(@Param("id") Long id, @Param("name") String name, @Param("email") String email, @Param("department") String department);
}
