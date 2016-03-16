/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laFerme.service.Crud;

import java.util.List;
import laFerme.entity.Ble;
import laFerme.entity.Fermier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author admins
 */
@Service
public interface BleService extends CrudRepository<Ble, Long>{
    
    
    public List<Ble> findByFermierAndDatePlantationNull(Fermier fermier);
       //s
    public List<Ble> findByFermierAndDatePlantationNotNull(Fermier fermier);
    
}
