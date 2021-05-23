package ru.netology.manager;

import ru.netology.domain.Movie;


public class MovieManager {
    private static Movie[] items = new Movie[0];
    private int showMoviesCount = 10; // количество фильмов = 10

    public MovieManager(int showMoviesCount) {
        this.showMoviesCount = showMoviesCount;
    }

    public MovieManager(){
    }

    public void add(Movie item) { // добавить фильм
        // создаём новый массив размером на единицу больше
        int length = items.length + 1;
        Movie[] tmp = new Movie[length];

        // копируем поэлементно
        System.arraycopy(items, 0, tmp, 0, items.length);

        // кладём последним наш элемент
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Movie[] getAll() {
        int resultLength = Math.min(showMoviesCount, items.length);
        Movie[] result = new Movie[resultLength];
        // перебираем массив в прямом порядке
        // но кладём в результаты в обратном
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;

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