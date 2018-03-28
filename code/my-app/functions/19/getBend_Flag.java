private GeneralPath getBend(boolean sinister) {
    GeneralPath path = new GeneralPath();
    if (sinister) {
        path.moveTo(0, HEIGHT);
        path.lineTo(0, HEIGHT - BEND_Y);
        path.lineTo(WIDTH - BEND_X, 0);
        path.lineTo(WIDTH, 0);
        path.lineTo(WIDTH, BEND_Y);
        path.lineTo(BEND_X, HEIGHT);
    } else {
        path.moveTo(0, 0);
        path.lineTo(BEND_X, 0);
        path.lineTo(WIDTH, HEIGHT - BEND_Y);
        path.lineTo(WIDTH, HEIGHT);
        path.lineTo(WIDTH - BEND_X, HEIGHT);
        path.lineTo(0, BEND_Y);
    }
    return path;
}