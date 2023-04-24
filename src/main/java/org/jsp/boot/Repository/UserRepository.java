/**
 * 
 */
package org.jsp.boot.Repository;

import org.jsp.boot.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
