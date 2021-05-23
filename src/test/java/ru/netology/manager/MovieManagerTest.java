package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

public class MovieManagerTest {
    private ru.netology.manager.MovieManager movieManager = new ru.netology.manager.MovieManager();
    private Movie first = new Movie(1, "https://www.kinopoisk.ru", "Бладшот", "боевик");
    private Movie second = new Movie(2, "https://www.kinopoisk.ru", "Вперёд", "мультфильм");
    private Movie third = new Movie(3, "https://www.kinopoisk.ru", "Отель <<Белград>>", "комедия");
    private Movie fourth = new Movie(4, "https://www.kinopoisk.ru", "Джентльмены", "боевик");
    private Movie fifth = new Movie(5,"https://www.kinopoisk.ru", "Человек-невидимка", "ужасы");
    private Movie sixth = new Movie(6, "https://www.kinopoisk.ru", "Тролли. Мировой тур", "мультфильм");
    private Movie seventh = new Movie(7, "https://www.kinopoisk.ru", "Форсаж 9", "комедиябоевик");
    private Movie eighth = new Movie(8, "https://www.kinopoisk.ru", "Прабабушка легкого поведения", "комедия");
    private Movie ninth = new Movie(9, "https://www.kinopoisk.ru", "Номер один", "комедия");
    private Movie tenth = new Movie(10, "https://www.kinopoisk.ru", "Девятаев", "биография");
    private Movie eleventh = new Movie(11, "https://www.kinopoisk.ru", "Мортал комбат", "фэнтези");

    @BeforeEach
    public void setUp() {
        movieManager.add(first);
        movieManager.add(second);
        movieManager.add(third);
    }

    @Test
    public void testForTestsSake() {
        Movie movie = new Movie(9, "https://www.kinopoisk.ru", "Номер один", "комедия");
        assertEquals( 9, movie.getId());
        assertEquals("https://www.kinopoisk.ru", movie.getImageUrl());
        assertEquals("Номер один", movie.getName());
        assertEquals("комедия", movie.getGenre());
    }

    @Test
    public void testAddMoreMovie() {
        movieManager.add(fourth);

        Movie[] actual = movieManager.getAll();
        Movie[] expected = new Movie[]{fourth, third, second, first};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testAddMoreTenMovie() {
        movieManager.add(fourth);
        movieManager.add(fifth);
        movieManager.add(sixth);
        movieManager.add(seventh);
        movieManager.add(eighth);
        movieManager.add(ninth);
        movieManager.add(tenth);
        movieManager.add(eleventh);

        Movie[] actual = movieManager.getAll();
        Movie[] expected = new Movie[]{eleventh,tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};

        assertArrayEquals(expected, actual);
    }

    @Test
    void testadds() {
        Movie movie = new Movie(1, "https://www.kinopoisk.ru", "Бладшот", "боевик");
        movieManager.add(first);
        assertEquals(movieManager.getAll().length, 8);
    }

    @Test
    void testSetMoviesCount() {
        MovieManager manager = new MovieManager(1);
        Movie first = new Movie(1, "https://www.kinopoisk.ru", "Бладшот", "боевик");
        Movie second = new Movie(2, "https://www.kinopoisk.ru", "Вперёд", "мультфильм");
        manager.add(first);
        manager.add(second);
        assertEquals(1, manager.getAll().length);
        assertEquals(manager.getAll()[0].getName(), "Вперёд");
    }

    @Test
    void testMoviesQueue() {
        movieManager.add(first);
        movieManager.add(second);
        movieManager.add(third);
        movieManager.add(fourth);
        movieManager.add(fifth);
        assertEquals(movieManager.getAll()[0].getName(), "Человек-невидимка");
        assertEquals(movieManager.getAll()[4].getName(), "Бладшот");
    }
}

//        @Test
//        public void shouldNotRemoveIfNotExists() {
//            CartManager manager = new CartManager();
//            int idToRemove = 4;
//            Movie first = new Movie(1, 1, "first", 1, 1);
//            Movie second = new Movie(2, 2, "second", 1, 1);
//            Movie third = new Movie(3, 3, "third", 1, 1);
//            manager.add(first);
//            manager.add(second);
//            manager.add(third);
//
//            manager.removeById(idToRemove);
//
//            Movie[] actual = manager.getAll();
//            Movie[] expected = new Movie[]{third, second, first};
//
//            assertArrayEquals(expected, actual);
//        }


