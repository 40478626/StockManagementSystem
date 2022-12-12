package com.example.test.Repository;

import com.example.test.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.security.SecureRandom;

public interface LocationRepository extends JpaRepository<Location, String> {
}
