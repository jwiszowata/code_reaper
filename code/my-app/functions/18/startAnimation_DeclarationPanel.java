public void startAnimation() {
    ActionListener taskPerformer = (ActionEvent ae) -> {
        if (counter < points.length - 1) {
            counter += 20;
            if (counter > points.length) {
                counter = points.length - 1;
                ((Timer) ae.getSource()).stop();
                notifyStopped();
            }
            validate();
            repaint();
        } else {
            ((Timer) ae.getSource()).stop();
            notifyStopped();
        }
    };
    new Timer(ANIMATION_DELAY, taskPerformer).start();
}