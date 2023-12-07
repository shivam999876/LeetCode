/**
 * @param {number[][]} moves
 * @return {string}
 */
var tictactoe = function(moves) {
    const n = 3;
    const grid = Array.from({ length: n }, () => Array(n).fill(' '));

    for (let i = 0; i < moves.length; i++) {
        const [row, col] = moves[i];
        const player = i % 2 === 0 ? 'A' : 'B';

        grid[row][col] = player;

        if (checkWinner(grid, row, col, player)) {
            return player;
        }
    }

    return moves.length === n * n ? 'Draw' : 'Pending';
};

const checkWinner = (grid, row, col, player) => {
    // Check row
    if (grid[row].every(cell => cell === player)) {
        return true;
    }

    // Check column
    if (grid.every(row => row[col] === player)) {
        return true;
    }

    // Check diagonal (if applicable)
    if (row === col && grid.every((row, i) => row[i] === player)) {
        return true;
    }

    // Check anti-diagonal (if applicable)
    if (row + col === grid.length - 1 && grid.every((row, i) => row[grid.length - 1 - i] === player)) {
        return true;
    }

    return false;
};