public Map.Position step(int x, int y) {
    return ((y & 1) != 0) ? new Map.Position(x + oddDX, y + oddDY) : new Map.Position(x + evenDX, y + evenDY);
}