public boolean equals(Object o) {
    if (o instanceof Turn) {
        return this.turn == ((Turn) o).turn;
    }
    return false;
}