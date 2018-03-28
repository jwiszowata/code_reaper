public void removeFromComponent(Canvas canvas) {
    canvas.removeFromCanvas(infoPanel);
    canvas.removeFromCanvas(miniMapPanel);
    canvas.removeFromCanvas(compassRose);
    for (UnitButton button : unitButtons) {
        canvas.removeFromCanvas(button);
    }
}