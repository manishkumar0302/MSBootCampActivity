package com.ms.boot.conversionMS.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.ms.boot.conversionMS.model.Factor;

@Component
public interface ConversionRepository extends JpaRepository<Factor, Integer> {

	Optional<Factor> findById(String id);

	Optional<Factor> findByCountryCode(String id);

}
