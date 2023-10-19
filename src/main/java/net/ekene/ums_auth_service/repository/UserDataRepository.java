package net.ekene.ums_auth_service.repository;

import net.ekene.model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDataRepository extends JpaRepository<UserData, Long> {

    Optional<UserData> findUserDataByEmailIgnoreCase (String email);
}
