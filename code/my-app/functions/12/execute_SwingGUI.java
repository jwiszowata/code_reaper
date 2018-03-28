private void execute() {
    canvas.removeKeyListener(this);
    canvas.removeMouseListener(this);
    vp.removeMouseListener(this);
    vp.stop();
    canvas.remove(vp);
    if (t != null) {
        t.stop();
    }
    playSound("sound.intro.general");
    showMainPanel(userMsg);
}