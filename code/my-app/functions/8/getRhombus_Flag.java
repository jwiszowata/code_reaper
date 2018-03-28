private GeneralPath getRhombus() {
    GeneralPath rhombus = new GeneralPath();
    rhombus.moveTo(WIDTH / 2, BEND_Y);
    rhombus.lineTo(WIDTH - BEND_X, HEIGHT / 2);
    rhombus.lineTo(WIDTH / 2, HEIGHT - BEND_Y);
    rhombus.lineTo(BEND_X, HEIGHT / 2);
    return rhombus;
}