/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laFerme.service.Crud;

import java.util.List;
import laFerme.entity.Carotte;
import laFerme.entity.Fermier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public interface CarotteService extends CrudRepository<Carotte, Long>{
    
    public List<Carotte> findByFermier (Fermier fermier);
    
    public List<Carotte> findByFermierAndDatePlantationNull(Fermier fermier);
    
    public List<Carotte> findByFermierAndDatePlantationNotNull(Fermier fermier);
    
    }

