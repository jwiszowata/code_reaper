public int compareTo(ImageLocation other) {
    int dy = other.y - this.y;
    return (dy == 0) ? other.x - this.x : dy;
}