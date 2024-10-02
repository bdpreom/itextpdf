package com.forenizence.pdf;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassportService {

    @Autowired
    private PassportRepository passportRepository;

    public List<Passport> findAll() {
        return passportRepository.findAll();
    }

    public Passport save(Passport passport) {
        return passportRepository.save(passport);
    }

    // Additional methods for update and delete can be added here

}
