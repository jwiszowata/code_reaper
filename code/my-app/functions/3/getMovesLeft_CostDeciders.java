public int getMovesLeft() {
    return (index < 0) ? 0 : costDeciders[index].getMovesLeft();
}