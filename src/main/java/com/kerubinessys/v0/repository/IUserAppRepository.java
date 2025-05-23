package com.kerubinessys.v0.repository;

import com.kerubinessys.v0.model.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserAppRepository extends JpaRepository<UserApp, Long> {

    Optional<UserApp> findByUsernameAndSurnameAndPassword(String username, String surname, String password);
}
