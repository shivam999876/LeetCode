/**
 * @param {number[][]} moves
 * @return {string}
 */
var tictactoe = function(moves) {
    // Intializing the grid
    let grid = [];
    for(let i = 0; i < 3; i++){
        grid[i] = [];
        for(let j = 0; j< 3;j++ ){
            grid[i][j] = 0;
        }
    }

    //Reading the moves of player A
    for (let i = 0; i<moves.length; i+=2){
        let [row, col] = moves[i];
        grid[row][col] = 1;
    }

    //Reading the moves of player B
    for (let i = 1; i<moves.length; i+=2){
        let [row, col] = moves[i];
        grid[row][col] = -1;
    }
    let rowsResult = []

    //Checking each row and column for a winner 
    for (let i = 0; i<3; i++){
        let rowValue = 0;
        let columnValue = 0;

        for (let j = 0; j<3; j++){ 
           rowValue+= grid[i][j];
           columnValue += grid[j][i];
        }

        if (rowValue === 3 || columnValue === 3) return "A";
        else if (rowValue === -3 || columnValue === -3) return "B";
        else rowsResult.push(rowValue);
    }

    //Checking diganols for a winner
    let firstDiagonal = 0; 
    let secondDiagonal = 0;
    for(let i=0; i<3; i++){
        firstDiagonal += grid[i][i];
        secondDiagonal += grid[i][2-i];
    }
    console.log(firstDiagonal)
    console.log(secondDiagonal)
    if (firstDiagonal === 3 || secondDiagonal === 3) return "A";
    if (firstDiagonal === -3 || secondDiagonal === -3) return "B";

    // console.log(grid)
    // Checking for DRAW or PENDING 
    for(let i = 0; i < 3; i++){
        for(let j = 0; j< 3;j++ ){
            if (grid[i][j] === 0) return "Pending";
        }
    }
    return "Draw";
};