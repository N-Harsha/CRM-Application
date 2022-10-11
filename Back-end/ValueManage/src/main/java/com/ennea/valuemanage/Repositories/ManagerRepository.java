package com.ennea.valuemanage.Repositories;

import com.ennea.valuemanage.Model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager,Long> {
}
