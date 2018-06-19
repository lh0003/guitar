package javayum.service;

import javayum.domain.GuitarSpec;

public interface GuitarSpecService {

    void insertGuitarSpec();
    GuitarSpec selectGuitarSpec(Integer specId);
    void addSpec(String builder,String model1,String type,Integer numStrings1,String backWood,String topWood );
    GuitarSpec formmer();
}
