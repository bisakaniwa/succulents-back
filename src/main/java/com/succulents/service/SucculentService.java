package com.succulents.service;

import com.succulents.model.Succulent;
import com.succulents.repository.SucculentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.rmi.UnexpectedException;
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

    public Succulent update(Succulent succulent) throws UnexpectedException {
        Optional<Succulent> update = this.repository.findById(succulent.getId());
        if(update.isPresent()) {
            update.get().setGenre(succulent.getGenre());
            update.get().setSpecies(succulent.getSpecies());
            update.get().setPeculiarity(succulent.getPeculiarity());
            update.get().setPopularName(succulent.getPopularName());
            update.get().setReferenceImage(succulent.getReferenceImage());
            update.get().setExtra(succulent.getExtra());
            return this.repository.save(update.get());
        } else {
            throw new UnexpectedException("Oops, something went wrong!");
        }
    }
}
