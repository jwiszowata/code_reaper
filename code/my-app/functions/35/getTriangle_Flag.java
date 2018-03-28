private GeneralPath getTriangle(UnionShape unionShape, boolean small) {
    GeneralPath path = new GeneralPath();
    double x = 0;
    double y = 0;
    if (small) {
        x = BEND_X;
        y = BEND_Y;
    }
    switch(unionShape) {
        case BEND:
            path.moveTo(0, HEIGHT - y);
            path.lineTo(0, 0);
            path.lineTo(WIDTH - x, 0);
            break;
        case CHEVRON:
            path.moveTo(0, y);
            path.lineTo(CHEVRON_X - x, HEIGHT / 2);
            path.lineTo(0, HEIGHT - y);
            break;
        case TRIANGLE:
            if (unionPosition == UnionPosition.LEFT || unionPosition == UnionPosition.RIGHT) {
                path.moveTo(0, y);
                path.lineTo(WIDTH / 2 - x, HEIGHT / 2);
                path.lineTo(0, HEIGHT - y);
            } else {
                path.moveTo(0, x);
                path.lineTo(HEIGHT / 2 - y, WIDTH / 2);
                path.lineTo(0, WIDTH - x);
            }
            break;
        default:
            break;
    }
    return path;
}