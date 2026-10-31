package com.blooddonor.blood_donor_finder.service;

import com.blooddonor.blood_donor_finder.entity.Donor;
import com.blooddonor.blood_donor_finder.repository.DonorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonorService {

    private final DonorRepository donorRepository;

    public DonorService(DonorRepository donorRepository) {
        this.donorRepository = donorRepository;
    }

    public Donor addDonor(Donor donor) {
        return donorRepository.save(donor);
    }

    public List<Donor> getAllDonors() {
        return donorRepository.findAll();
    }

    public Donor getDonorById(Long id) {
        return donorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Donor not found with id: " + id));
    }

    public Donor updateDonor(Long id, Donor newData) {
        Donor donor = getDonorById(id);
        donor.setName(newData.getName());
        donor.setBloodGroup(newData.getBloodGroup());
        donor.setCity(newData.getCity());
        donor.setPhone(newData.getPhone());
        donor.setAvailable(newData.isAvailable());
        return donorRepository.save(donor);
    }

    public void deleteDonor(Long id) {
        Donor donor = getDonorById(id);
        donorRepository.delete(donor);
    }
}
