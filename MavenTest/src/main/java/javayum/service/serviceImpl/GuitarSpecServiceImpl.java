package javayum.service.serviceImpl;

import javayum.dao.GuitarSpecDao;
import javayum.domain.GuitarSpec;
import javayum.service.GuitarSpecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;

@org.springframework.transaction.annotation.Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("GuitarSpecService")
public class GuitarSpecServiceImpl implements GuitarSpecService {
    @Autowired
    private GuitarSpecDao guitarSpecDao;

    @Override
    public void addSpec(String builder, String model1, String type, Integer numStrings1, String backWood, String topWood) {
        guitarSpecDao.addSpec(builder,model1,type,numStrings1,backWood,topWood);
    }

    @Override
    public GuitarSpec formmer() {
        return guitarSpecDao.formmer();
    }

    @Override
    public void insertGuitarSpec() {
        guitarSpecDao.insertSpec();
    }

    @Override
    public GuitarSpec selectGuitarSpec(Integer specId) {
        return guitarSpecDao.selectGuitarSpec(specId);
    }
}
