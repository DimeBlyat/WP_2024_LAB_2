package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.service.ArtistService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ArtistController {
    private final ArtistService artistService;  // Зависност за сервисот за артисти

    // Конструктор за инициализација на ArtistService
    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;  // Инициализација на сервисот
    }

    // Метод за прикажување на сите артисти
    @GetMapping("/artists")
    public String listArtists(Model model) {
        // Преземање на листата на артисти од сервисот
        model.addAttribute("artists", artistService.listArtists());
        // Враќање на името на шаблонот (HTML страна)
        return "artistList";
    }

    // Метод за прикажување на детали за еден артист
    @GetMapping("/artist/{id}")
    public String getArtistDetails(@PathVariable Long id, Model model) {
        // Пребарување на артист по ID
        Artist artist = artistService.findById(id).orElse(null);
        // Додавање на артистот во моделот
        model.addAttribute("artist", artist);
        // Враќање на шаблон за детални информации за артистот
        return "artistDetails";
    }
}