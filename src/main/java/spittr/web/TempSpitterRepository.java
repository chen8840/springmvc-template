package spittr.web;

import org.springframework.stereotype.Component;
import spittr.Spitter;
import spittr.Spittle;
import spittr.data.SpitterRepository;
import spittr.data.SpittleRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class TempSpitterRepository implements SpitterRepository {

    public Spitter save(Spitter spitter) {
        return null;
    }

    public Spitter findByUsername(String username) {
        return new Spitter(1L, username, null, null, null);
    }
}
