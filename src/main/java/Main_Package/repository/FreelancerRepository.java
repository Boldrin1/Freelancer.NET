package Main_Package.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Main_Package.model.Freelancer;

@Repository
public interface FreelancerRepository extends JpaRepository<Freelancer,Long>{

}
