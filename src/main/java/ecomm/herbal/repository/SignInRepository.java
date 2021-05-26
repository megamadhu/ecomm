package ecomm.herbal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ecomm.herbal.entity.Signup;

@Repository
public interface SignInRepository extends JpaRepository<Signup, Long> {

	@Query("select u from Signup u where u.signupKey.username = :uname")
	Signup getByUsername(@Param(value = "uname") String uname);

	@Query("select u from Signup u where u.signupKey.username = :uname and u.signupKey.password = :pass")
	Signup getByUsernamePassword(@Param(value = "uname") String uname, @Param(value = "pass") String pass);

}
