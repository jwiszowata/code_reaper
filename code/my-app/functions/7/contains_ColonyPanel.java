public boolean contains(int px, int py) {
    int w = getWidth();
    int h = getHeight();
    int dx = Math.abs(w / 2 - px);
    int dy = Math.abs(h / 2 - py);
    return (dx + w * dy / h) <= w / 2;
}