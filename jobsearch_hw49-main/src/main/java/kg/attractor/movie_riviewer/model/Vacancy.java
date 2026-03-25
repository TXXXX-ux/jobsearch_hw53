package kg.attractor.movie_riviewer.model;



import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Vacancy {
    private Integer id;
    private Integer userId;

    @NotBlank(message = "Категория вакансии должна быть указана")
    private String category;

    @NotBlank(message = "Заголовок вакансии обязателен")
    @Size(min = 5, max = 100, message = "Заголовок должен быть от 5 до 100 символов")
    private String title;

    @NotBlank(message = "Описание вакансии не может быть пустым")
    @Size(min = 10, message = "Описание слишком короткое")
    private String description;
}