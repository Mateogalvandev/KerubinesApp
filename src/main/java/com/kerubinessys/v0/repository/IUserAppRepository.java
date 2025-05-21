package com.kerubinessys.v0.repository;

import com.kerubinessys.v0.model.UserApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserAppRepository extends JpaRepository<UserApp, Long> {
}
