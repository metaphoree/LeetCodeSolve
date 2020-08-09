import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class WordSearch_79 {

    boolean found = false;
    String targetString = "";
    int targetCount = 0;
    int maxRow = 0;
    int maxCol = 0;
    char[][] givenBoard;
    char[] targetStrArray = new char[2000];

    public boolean exist(char[][] board, String word) {
        if (word.equals("")) {
            return false;
        }

        maxCol = board[0].length;
        maxRow = board.length;
        if (maxCol == 0 || maxRow == 0) {
            return false;
        }

        targetStrArray = word.toCharArray();
        targetString = word;
        targetCount = targetStrArray.length;
        givenBoard = new char[maxRow][maxCol];
        givenBoard = board;
        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxCol; j++) {
                if (givenBoard[i][j] == targetStrArray[0] && !found) {
                    BFS(i, j,
                            new ArrayList<>(Arrays.asList(i)),
                            new ArrayList<>(Arrays.asList(j)), givenBoard[i][j] + "",
                            0, new HashMap<String, Boolean>());
                }
            }
        }
        return found;
    }

    public void BFS(int row, int col, List<Integer> rowList, List<Integer> colList,
                    String cust_str, int count, HashMap<String, Boolean> visited) {
        if (found) {
            return;
        }
        if (count == targetCount - 1) {
            if (cust_str.equals(targetString)) {
                found = true;
            }
            return;
        }
        visited = new HashMap<String, Boolean>();
        for (int i = 0; i < rowList.size(); i++) {
            visited.put(rowList.get(i) + "," + colList.get(i), true);
        }
        int p = 0;
        int newRow = 0;
        int newCol = 0;
        while (p != 4 && !found) {
            if (p == 0) {
                newRow = row - 1;
                newCol = col;
            } else if (p == 1) {
                newRow = row + 1;
                newCol = col;
            } else if (p == 2) {
                newRow = row;
                newCol = col + 1;
            } else if (p == 3) {
                newRow = row;
                newCol = col - 1;
            }
            if (isValidRC(newRow, newCol, maxRow, maxCol) && visited.get(newRow + "," + newCol) == null
                    && !found) {
                if (targetStrArray[count + 1] != givenBoard[newRow][newCol]) {
                    p++;
                    continue;
                }
                List<Integer> tempR = new ArrayList<>(rowList);
                tempR.add(newRow);
                List<Integer> tempC = new ArrayList<>(colList);
                tempC.add(newCol);
                BFS(newRow, newCol, tempR, tempC, cust_str + givenBoard[newRow][newCol], count + 1, visited);
            }
            p++;
        }
    }

    public boolean isValidRC(int row, int col, int maxRow, int maxCol) {
        if (row < maxRow && row >= 0) {
            if (col < maxCol && col >= 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board =
                {
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'}
                };
        System.out.println(new WordSearch_79().exist(board, "ABCB"));
    }
}
