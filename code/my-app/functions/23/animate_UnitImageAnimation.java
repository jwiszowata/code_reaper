public void animate() {
    if (gui.getTilePosition(tile) == null)
        return;
    gui.paintImmediatelyCanvasInItsBounds();
    gui.executeWithUnitOutForAnimation(unit, tile, (JLabel unitLabel) -> {
        for (AnimationEvent event : animation) {
            long time = System.nanoTime();
            if (event instanceof ImageAnimationEvent) {
                final ImageAnimationEvent ievent = (ImageAnimationEvent) event;
                final ImageIcon icon = (ImageIcon) unitLabel.getIcon();
                Image image = ievent.getImage();
                if (mirror) {
                    image = ImageLibrary.createMirroredImage(image);
                }
                icon.setImage(image);
                gui.paintImmediatelyCanvasIn(getDirtyAnimationArea());
                time = ievent.getDurationInMs() - (System.nanoTime() - time) / 1000000;
                if (time > 0)
                    Utils.delay(time, "Animation delayed.");
            }
        }
    });
}