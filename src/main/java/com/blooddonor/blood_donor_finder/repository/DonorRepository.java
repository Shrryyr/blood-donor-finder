package com.blooddonor.blood_donor_finder.repository;

import com.blooddonor.blood_donor_finder.entity.Donor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonorRepository extends JpaRepository<Donor, Long> {

}
