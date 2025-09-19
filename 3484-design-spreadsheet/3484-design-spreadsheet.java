class Spreadsheet {
    private int[][] spreadSheet;

    public Spreadsheet(int rows) {
        spreadSheet = new int[rows][26];  // rows × 26 columns (A–Z)
    }

    public void setCell(String cell, int value) {
        int col = cell.charAt(0) - 'A';
        int row = Integer.parseInt(cell.substring(1)) - 1;
        spreadSheet[row][col] = value;
    }

    public void resetCell(String cell) {
        int col = cell.charAt(0) - 'A';
        int row = Integer.parseInt(cell.substring(1)) - 1;
        spreadSheet[row][col] = 0;
    }

    public int getValue(String formula) {
        formula = formula.substring(1); // remove '='

        String[] parts = formula.split("\\+");
        int val1 = resolve(parts[0]);
        int val2 = resolve(parts[1]);

        return val1 + val2;
    }

    private int resolve(String token) {
        // If token is a number, parse directly
        if (Character.isDigit(token.charAt(0))) {
            return Integer.parseInt(token);
        }

        // Otherwise, treat it as cell reference
        int col = token.charAt(0) - 'A';
        int row = Integer.parseInt(token.substring(1)) - 1;
        return spreadSheet[row][col];
    }
}
