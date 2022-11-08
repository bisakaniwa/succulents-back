package com.succulents.service;

import com.succulents.model.Succulent;
import com.succulents.repository.SucculentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SucculentService {

    @Autowired
    private SucculentRepository repository;

    public List<Succulent> findAll() {
        return this.repository.findAll();
    }

    public Succulent findById(Long id) throws ChangeSetPersister.NotFoundException {
        Optional<Succulent> succulent = this.repository.findById(id);
        if (succulent.isPresent()) {
            return succulent.get();
        } else {
            throw new ChangeSetPersister.NotFoundException();
        }
    }

    public Succulent save(Succulent succulent) {
        return this.repository.save(succulent);
    }
}
