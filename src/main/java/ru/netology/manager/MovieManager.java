package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.Movie;

@NoArgsConstructor
public class MovieManager {
    private int showMoviesCount = 10; // количество фильмов = 10
    private Movie[] items = new Movie[0];

    public MovieManager(int showMoviesCount) {
        this.showMoviesCount = showMoviesCount;
    }

    public void addMovie(Movie item) { // добавить фильм
        // создаём новый массив размером на единицу больше
        int length = items.length + 1;
        Movie[] tmp = new Movie[length];

        // копируем поэлементно
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        System.arraycopy(items, 0, tmp, 0, items.length);

        // кладём последним наш элемент
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Movie[] getMovies() {
        Movie[] reverse = new Movie[items.length];
        int currentIndex = 0;
        // перебираем массив в прямом порядке
        // но кладём в результаты в обратном
        for (int i = reverse.length - 1; i >= 0; i--) {
            reverse[currentIndex] = items[i];
            currentIndex++;
        }
        if (reverse.length <= showMoviesCount) {
            return reverse;
        } else {
            Movie[] results = new Movie[showMoviesCount];
            for (int i = 0; i < showMoviesCount; i++) {
                results[i] = reverse[i];
            }
            return results;
        }
    }
//    // наивная реализация
//    public void removeMovie(int id) { //  удалить фильм
//        int length = items.length - 1;
//        Movie[] tmp = new Movie[length];
//        int index = 0;
//        for (Movie item : items) {
//            if (item.getId() != id) {
//                tmp[index] = item;
//                index++;
//            }
//        }
//        // меняем наши элементы
//        items = tmp;
//    }
}