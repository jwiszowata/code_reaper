private void nextTile() {
    boolean started = n != 0;
    do {
        n++;
        final int width = currentRadius * 2;
        if (n >= width * 4) {
            currentRadius++;
            if (currentRadius > radius) {
                x = y = UNDEFINED;
                break;
            } else if (!started) {
                x = y = UNDEFINED;
                break;
            } else {
                n = 0;
                started = false;
                Position step = Direction.NE.step(x, y);
                x = step.x;
                y = step.y;
            }
        } else {
            int i = n / width;
            Direction direction;
            switch(i) {
                case 0:
                    direction = Direction.SE;
                    break;
                case 1:
                    direction = Direction.SW;
                    break;
                case 2:
                    direction = Direction.NW;
                    break;
                case 3:
                    direction = Direction.NE;
                    break;
                default:
                    throw new IllegalStateException("i=" + i + ", n=" + n + ", width=" + width);
            }
            Position step = direction.step(x, y);
            x = step.x;
            y = step.y;
        }
    } while (!isValid(x, y));
}