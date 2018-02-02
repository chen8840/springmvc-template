package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import spittr.Spitter;
import spittr.data.SpitterRepository;

import javax.servlet.http.Part;
import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping("/spitter")
public class SpitterController {
    private SpitterRepository spitterRepository;

    public SpitterController() {}

    @Autowired
    public SpitterController(SpitterRepository spitterRepository) {
        this.spitterRepository = spitterRepository;
    }

    @RequestMapping(value="/register", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
        model.addAttribute("spitter", new Spitter());
        return "registerForm";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegistration(
            @RequestPart("profilePicture") Part profilePicture,
            @Valid Spitter spitter,
            Errors errors) {
        if(errors.hasErrors()) {
            return "registerForm";
        }
        try {
            profilePicture.write(profilePicture.getSubmittedFileName());
        } catch (IOException e) {
            e.printStackTrace();
        }
        spitterRepository.save(spitter);
        return "redirect:/spitter/" + spitter.getUsername();
    }

    @RequestMapping(value="/{username}", method = RequestMethod.GET)
    public String showSpitterProfile(
            @PathVariable("username") String username, Model model) {
        Spitter spitter = spitterRepository.findByUsername(username);
        model.addAttribute(spitter);
        return "profile";
    }
}
