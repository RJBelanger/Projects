let playerTurn = true;
let computerMoveTimeout = 0;
let gameOver = false;


window.addEventListener("DOMContentLoaded", domLoaded);

function domLoaded() {
	// Setup the click event for the "New game" button
	let newBtn = document.getElementById("newGameButton");
	newBtn.addEventListener("click", newGame);

	// Create click-event listeners for each cell in the game board
	let cells = getGameBoard();
	for (let cell of cells) {
		cell.addEventListener("click", function () { cellClicked(cell); });
	}

	// Call newGame() to make sure the board is clear
	newGame();
}

// Returns an array of 9 <td> elements that make up the game board. The first 3
// elements are the top row, the next 3 the middle row, and the last 3 the
// bottom row.
function getGameBoard() {
	let gameBoardTable = document.getElementById("gameBoard");
	let result = [];
	for (let i = 0; i < 3; i++) {
		for (let j = 0; j < 3; j++) {
			result.push(gameBoardTable.rows[i].cells[j]);
		}
	}
	return result;
}

function newGame() {

	clearTimeout(computerMoveTimeout);
	var board = getGameBoard();
	for(let i = 0; i < 9; i++){
		board[i].innerHTML = "&nbsp";
	}
	playerTurn = true;
	gameOver = false;
	document.getElementById("turnInfo").innerHTML = "Your turn";
}

function cellClicked(cell) {

	if(playerTurn == true){
		if(cell.innerHTML == "&nbsp;"){
			cell.innerHTML = "X";
			cell.style.color = "red";
			switchTurn();
		}
	}
}
function switchTurn() {
	var board = getGameBoard();
	var draw = true;

	if(playerTurn == true){
		console.log("COMPUTER TURN");
		playerTurn = false;
		document.getElementById("turnInfo").innerHTML = "Computer's turn";
		computerMoveTimeout = setTimeout(makeComputerMove, 1000);
	}
	else{
		console.log("PLAYER TURN");
		playerTurn = true;
		document.getElementById("turnInfo").innerHTML = "Your turn";
	}
	console.log("CHECKING FOR WIN OR DRAW");

	if(board[0].innerHTML == "X" && board[1].innerHTML == "X" && board[2].innerHTML == "X"){
		playerTurn = false;
		gameOver = true;
		document.getElementById("turnInfo").innerHTML = "You win!";
		return;
	}
	else if(board[0].innerHTML == "O" && board[1].innerHTML == "O" && board[2].innerHTML == "O"){
		playerTurn = false;
		gameOver = true;
		document.getElementById("turnInfo").innerHTML = "Computer wins!";
		return;
	}
	else if(board[3].innerHTML == "X" && board[4].innerHTML == "X" && board[5].innerHTML == "X"){
		playerTurn = false;
		gameOver = true;
		document.getElementById("turnInfo").innerHTML = "You win!";
		return;
	}
	else if(board[3].innerHTML == "O" && board[4].innerHTML == "O" && board[5].innerHTML == "O"){
		playerTurn = false;
		gameOver = true;
		document.getElementById("turnInfo").innerHTML = "Computer wins!";
		return;
	}
	else if(board[6].innerHTML == "X" && board[7].innerHTML == "X" && board[8].innerHTML == "X"){
		playerTurn = false;
		gameOver = true;
		document.getElementById("turnInfo").innerHTML = "You win!";
		return;
	}
	else if(board[6].innerHTML == "O" && board[7].innerHTML == "O" && board[8].innerHTML == "O"){
		playerTurn = false;
		gameOver = true;
		document.getElementById("turnInfo").innerHTML = "Computer wins!";
		return;
	}
	else if(board[0].innerHTML == "X" && board[3].innerHTML == "X" && board[6].innerHTML == "X"){
		playerTurn = false;
		gameOver = true;
		document.getElementById("turnInfo").innerHTML = "You win!";
		return;
	}
	else if(board[0].innerHTML == "O" && board[3].innerHTML == "O" && board[6].innerHTML == "O"){
		playerTurn = false;
		gameOver = true;
		document.getElementById("turnInfo").innerHTML = "Computer wins!";
		return;
	}
	else if(board[1].innerHTML == "X" && board[4].innerHTML == "X" && board[7].innerHTML == "X"){
		playerTurn = false;
		gameOver = true;
		document.getElementById("turnInfo").innerHTML = "You win!";
		return;
	}
	else if(board[1].innerHTML == "O" && board[4].innerHTML == "O" && board[7].innerHTML == "O"){
		playerTurn = false;
		gameOver = true;
		document.getElementById("turnInfo").innerHTML = "Computer wins!";
		return;
	}

	else if(board[2].innerHTML == "X" && board[5].innerHTML == "X" && board[8].innerHTML == "X"){
		playerTurn = false;
		gameOver = true;
		document.getElementById("turnInfo").innerHTML = "You win!";
		return;
	}
	else if(board[2].innerHTML == "O" && board[5].innerHTML == "O" && board[8].innerHTML == "O"){
		playerTurn = false;
		gameOver = true;
		document.getElementById("turnInfo").innerHTML = "Computer wins!";
		return;
	}

	else if(board[0].innerHTML == "X" && board[4].innerHTML == "X" && board[8].innerHTML == "X"){
		playerTurn = false;
		gameOver = true;
		document.getElementById("turnInfo").innerHTML = "You win!";
		return;
	}
	else if(board[0].innerHTML == "O" && board[4].innerHTML == "O" && board[8].innerHTML == "O"){
		playerTurn = false;
		gameOver = true;
		document.getElementById("turnInfo").innerHTML = "Computer wins!";
		return;
	}
	else if(board[2].innerHTML == "X" && board[4].innerHTML == "X" && board[6].innerHTML == "X"){
		playerTurn = false;
		gameOver = true;
		document.getElementById("turnInfo").innerHTML = "You win!";
		return;
	}
	else if(board[2].innerHTML == "O" && board[4].innerHTML == "O" && board[6].innerHTML == "O"){
		playerTurn = false;
		gameOver = true;
		document.getElementById("turnInfo").innerHTML = "Computer wins!";
		return;
	}
	for(let i = 0; i < 9; i++){
		if(board[i].innerHTML == "&nbsp;"){
			draw = false;
			break;
		}
	}
	if(draw == true){
		document.getElementById("turnInfo").innerHTML = "Draw game";
		playerTurn = false;
		gameOver = true;
		return;
	}
	else{
		console.log("----------NEXT ROUND----------");
		return;
	}
}

function makeComputerMove() {

	var board = getGameBoard();
	if(gameOver == true){
		return;
	}
	else if(board.indexOf("&nbsp;") == -1){
		var i = Math.floor(Math.random() * 9)
		while (board[i].innerHTML != "&nbsp;") {
			var i = Math.floor(Math.random() * 9);
		}
		board[i].innerHTML = "O";
		board[i].style.color = "blue";
		switchTurn();
	}
	else{
		switchTurn();
	}
}