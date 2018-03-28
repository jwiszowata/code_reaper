private GeneralPath getCross(Decoration decoration) {
    double quarterWidth = (WIDTH - DECORATION_SIZE) / 2;
    double quarterHeight = (HEIGHT - DECORATION_SIZE) / 2;
    double offset = 0;
    double width = WIDTH;
    double height = HEIGHT;
    switch(decoration) {
        case SCANDINAVIAN_CROSS:
            offset = CROSS_OFFSET;
            break;
        case GREEK_CROSS:
            width = height = Math.min(WIDTH, HEIGHT) - 2 * DECORATION_SIZE;
            break;
        default:
            break;
    }
    GeneralPath cross = new GeneralPath();
    cross.append(new Rectangle2D.Double((WIDTH - width) / 2, quarterHeight, width, DECORATION_SIZE), false);
    cross.append(new Rectangle2D.Double(quarterWidth - offset, (HEIGHT - height) / 2, DECORATION_SIZE, height), false);
    return cross;
}