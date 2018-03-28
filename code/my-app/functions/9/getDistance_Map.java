public static int getDistance(int ax, int ay, int bx, int by) {
    int r = (bx - ax) - (ay - by) / 2;
    if (by > ay && ay % 2 == 0 && by % 2 != 0) {
        r++;
    } else if (by < ay && ay % 2 != 0 && by % 2 == 0) {
        r--;
    }
    return Math.max(Math.abs(ay - by + r), Math.abs(r));
}