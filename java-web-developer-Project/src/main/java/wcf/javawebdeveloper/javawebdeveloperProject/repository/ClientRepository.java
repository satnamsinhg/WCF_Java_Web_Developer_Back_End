package wcf.javawebdeveloper.javawebdeveloperProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wcf.javawebdeveloper.javawebdeveloperProject.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

}
