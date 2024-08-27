
import com.mycompany.dependencyinjection.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mycompany.bookstoreapi.Customer;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author Ashwithaa
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}

