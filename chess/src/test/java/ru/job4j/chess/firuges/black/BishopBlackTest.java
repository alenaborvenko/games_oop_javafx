package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class BishopBlackTest {

    @Test
    public void whenA3Position() {
        BishopBlack testFigure = new BishopBlack(Cell.A3);
        Cell position = testFigure.position();
        assertThat(position, is(Cell.A3));
    }

    @Test
    public void whenD4CopyPosition() {
        BishopBlack test = new BishopBlack(Cell.D4);
        Figure copyTest = test.copy(Cell.B5);
        Cell copyPosition = copyTest.position();
        assertThat(copyPosition, is(Cell.B5));
    }

    @Test
    public void whenWayFromC1ToG5ThenD2E3F4G5() {
        Cell[] expected = new Cell[]{
          Cell.D2,
          Cell.E3,
          Cell.F4,
          Cell.G5
        };
        BishopBlack test = new BishopBlack(Cell.C1);
        Cell[] rsl = test.way(Cell.G5);
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenWayFromD4toA1ThenC3B2A1() {
        Cell[] expected = new Cell[]{
                Cell.C3,
                Cell.B2,
                Cell.A1
        };
        BishopBlack test = new BishopBlack(Cell.D4);
        Cell[] rsl = test.way(Cell.A1);
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenWayFromD4ToG1ThenE3F2G1() {
        Cell[] expected = new Cell[]{
                Cell.E3,
                Cell.F2,
                Cell.G1
        };
        BishopBlack test = new BishopBlack(Cell.D4);
        Cell[] rsl = test.way(Cell.G1);
        assertThat(rsl, is(expected));
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenWayFromD4ToE2ThenImpossibleMoveException() {
        BishopBlack test = new BishopBlack(Cell.D4);
        test.way(Cell.E2);
    }

    @Test
    public void whenFromD4toE2NotDiagonal() {
        BishopBlack test = new BishopBlack(Cell.D4);
        boolean rsl = test.isDiagonal(test.position(), Cell.E2);
        assertThat(rsl, is(false));
    }

    @Test
    public void whenFromD4toB6IsDiagonal() {
        BishopBlack test = new BishopBlack(Cell.D4);
        boolean rsl = test.isDiagonal(test.position(), Cell.B6);
        assertThat(rsl, is(true));
    }
}