package springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.entity.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByRoleName(String roleName);

}
