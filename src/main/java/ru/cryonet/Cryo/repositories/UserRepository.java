package ru.cryonet.Cryo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.cryonet.Cryo.entityes.UserEntity;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    UserEntity findByUsername(String username);

}
