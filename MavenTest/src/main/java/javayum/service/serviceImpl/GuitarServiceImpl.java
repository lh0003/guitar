package javayum.service.serviceImpl;

import javayum.dao.GuitarDao;
import javayum.domain.Guitar;
import javayum.service.GuitarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("GuitarService")
public class GuitarServiceImpl implements GuitarService {


    @Autowired
    private GuitarDao guitarDao;

    @Override
    public void addGuitar() {
        guitarDao.insertGuitar();
    }

    @Override
    public List<Guitar> findAll() {
        return guitarDao.findAll();
    }

    @Override
    public Guitar selectGuitar(Integer ID) {
        return guitarDao.selectGuitar(ID);
    }

}
