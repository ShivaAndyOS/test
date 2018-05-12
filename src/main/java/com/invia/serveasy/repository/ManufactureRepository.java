package com.invia.serveasy.repository;

import com.invia.serveasy.model.Manufacture;
import com.invia.serveasy.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufactureRepository extends JpaRepository<Manufacture, Long> {

}
