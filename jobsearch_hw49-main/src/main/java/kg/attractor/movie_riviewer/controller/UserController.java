package kg.attractor.movie_riviewer.controller;

import jakarta.validation.Valid;
import kg.attractor.movie_riviewer.model.User;
import kg.attractor.movie_riviewer.model.Vacancy;
import kg.attractor.movie_riviewer.service.UserService;
import kg.attractor.movie_riviewer.service.VacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final VacancyService vacancyService;

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/search")
    public User searchByEmail(@RequestParam String email) {
        return userService.getUserByEmail(email);
    }

    @PostMapping("/users/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody User user) {
        userService.save(user);
        return ResponseEntity.ok("Пользователь успешно зарегистрирован");
    }

    @PostMapping("/vacancies")
    public ResponseEntity<String> createVacancy(@Valid @RequestBody Vacancy vacancy) {
        vacancyService.saveVacancy(vacancy);
        return ResponseEntity.ok("Вакансия создана");
    }
}