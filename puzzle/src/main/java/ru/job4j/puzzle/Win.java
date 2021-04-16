package ru.job4j.puzzle;

public class Win {
    /** Алгоритм нахождения выигрышной/проигрышной позиции
     * 0. Предполагаем, что мы проиграли
     * 1. Найдем главную диагональ (выигрышная позиция всегда пересекает ее)
     * 2. Для каждой ячейки из диагонали
     * 2.1.   Если в этой ячейке стоит 1 и из этой ячейки по горизонтали или по вертикали стоят все 1, то
     * 2.1.1.       ВЫИГРАЛИ
     * 2.1.2.       поиск остановлен
     *
     * @param board - игровая площадка
     * @return - boolean выиграл или проиграл
     */
    public static boolean check(int[][] board) {
        boolean rsl = false;
        int[] diagonal = extractDiagonal(board);
        for (int i = 0; i < board.length; i++) {
            if (diagonal[i] == 1 && (monoHorizontal(board, i) || monoVertical(board, i))) {
                rsl = true;
                break;
            }
        }
        return rsl;
    }

    /**
     * Метод выделения главной диагонали игровой площадки
     *
     * @param board - игровая площадка
     * @return массив из диагональных элементов площадки
     */
    public static int[] extractDiagonal(int[][] board) {
        int[] rsl = new int[board.length];
        for (int row = 0; row < board.length; row++) {
            rsl[row] = board[row][row];
        }
        return rsl;
    }

    /** Метод поиска выигрышной комбинации по горизонтали
     *
     * Алгоритм поиска
     *
     * 1. Предполагаем, что мы выиграли
     * 2. Для каждой ячейки из строки row
     * 2.1.    Если ячейка != 1
     * 2.1.1.      Проигрыш
     * 2.1.2.      Поиск остановлен
     *
     * @param board - игровая площадка
     * @param row - строка, в которой ищется выигрышная комбинация
     * @return boolean выиграли или нет
     */
    public static boolean monoHorizontal(int[][] board, int row) {
        boolean result = true;
        for (int cell:board[row]) {
            if (cell != 1) {
                result = false;
                break;
            }
        }
        return result;
    }

    /** Метод поиска выигрышной комбинации по вертикали
     *
     * Алгоритм поиска
     *
     * 1. Предполагаем, что мы выиграли
     * 2. Для каждой ячейки из столбца column (меняется строка из игровой площадки)
     * 2.1.    Если ячейка != 1
     * 2.1.1.      Проигрыш
     * 2.1.2.      Поиск остановлен
     *
     * @param board - игровая площадка
     * @param column - столбец, в которой ищется выигрышная комбинация
     * @return boolean выиграли или нет
     */
    public static boolean monoVertical(int[][] board, int column) {
        boolean result = true;
        for (int[] row : board) {
            if (row[column] != 1) {
                result = false;
                break;
            }
        }
        return result;
    }
}

