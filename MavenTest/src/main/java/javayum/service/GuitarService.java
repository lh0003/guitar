package javayum.service;

import javayum.domain.Guitar;

import java.util.List;

public interface GuitarService {
   void addGuitar();
   List<Guitar> findAll();
   Guitar selectGuitar(Integer ID);

}
