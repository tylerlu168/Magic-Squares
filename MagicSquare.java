public class MagicSquare
{
    private int[][] square;
    private int i;

    /**
     * Constructs an n by n MagicSquare
     *
     * @param n
     */
    public MagicSquare(int n)
    {
        square = new int[n][n];
    }

    /**
     * Inserts x at the index i, the next available
     * slot following row-major order.
     *
     * @param x
     */
    public void add(int x)
    {
        for (int r = 0; r < square.length; r++) //row major order
        {
            for (int c = 0; c < square[r].length; c++)
            {
                if (square[r][c] == 0)
                {
                    square[r][c] = x; //inputs the numbers into the 2D array
                    return;
                }
            }

        }
    }

    /**
     * @param nums
     * @return The sum of nums
     */
    private int sum(int[] nums)
    {
        int sum = 0;
        for (int j = 0; j < nums.length; j++)
        {
            sum += nums[j];
        }
        return sum;
    }

    /**
     * @return The constant that each row, column,
     * and diagonal should add-up to.
     */
    private int getConstant() //adds the numbers in a row together to find the constant
    {
        int sum = 0;
        for (int j = 0; j < square.length; j++)
        {
            sum += square[j][0];
        }
        return sum;
    }

    /**
     * @return true if each row, column, and diagonal
     *          add-up to the constant; false otherwise
     */
    public boolean isMagical()
    {
        if(isMagicalColumns() && isMagicalRows() && isMagicalDiagonals()) // checks if square is magical
        {
            return true;
        }
        return false;
    }

    /**
     * @return true if each row adds-up to the constant;
     * false otherwise
     */
    private boolean isMagicalRows()
    {
        boolean check = false;
        int sum = 0;
        for (int r = 0; r < square.length; r++) //row major order
        {
            for (int c = 0; c < square[r].length; c++)
            {
                sum += square[r][c];
                if (c == square[r].length - 1)
                {
                    if (sum == getConstant())
                    {
                        check = true;
                    }
                    else
                    {
                        return false;
                    }
                }
            }
            sum = 0;
        }
        return check;
    }

    /**
     * @return true if each column adds-up to the constant;
     * false otherwise
     */
    private boolean isMagicalColumns()
    {
        boolean check = false;
        int sum = 0;
        for (int c = 0; c < square[0].length; c++) //column major order
        {
            for (int r = 0; r < square.length; r++)
            {
                sum += square[r][c];
                if (r == square.length - 1)
                {
                    if (sum == getConstant())
                    {
                        check = true;
                    }
                    else
                    {
                        return false;
                    }
                }
            }
            sum = 0;
        }
        return check;

    }

    /**
     * @return true if each diagonal adds-up to the constant;
     * false otherwise
     */
    private boolean isMagicalDiagonals()
    {
        int sum = 0;
        int sum1 = 0;
        for (int j = 0; j < square.length; j++) //checks for 1st diagonal
        {
            sum += square[j][j];
        }

        int r = 0;
        for (int c = square[r].length - 1; c >= 0; c--) //checks for second diagonal
        {
            sum1 += square[r][c];
            r++;
        }



        if(sum == getConstant() && sum1 == getConstant()) // checks if both diagonals equals constant and is true
        {
            return true;
        }
        else
        return false;
    }

    /**
     * @return A String representation of this MagicSquare.
     */
    public String toString() //output
    {
        String rtn = "";

        for (int[] row : square)
        {
            for (int element : row)
                rtn += element + "\t";
            rtn += "\n";
        }

        return rtn;
    }
}
