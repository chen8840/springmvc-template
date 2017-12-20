package spittr.web;

import org.springframework.stereotype.Component;
import spittr.Spittle;
import spittr.data.SpittleRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class RecentSpittles implements SpittleRepository {
    public List<Spittle> findSpittles(long max, int count) {
        List<Spittle> spittles = new ArrayList<Spittle>();
        for(int i = 0; i < 4; i++) {
            spittles.add(new Spittle("Spittle " + i, new Date()));
        }
        return spittles;
    }

    public Spittle findOne(long spittleId) {
        return new Spittle("Spittle", new Date());
    }
}
