public int getNewTurns() {
    return (index < 0) ? 0 : costDeciders[index].getNewTurns();
}