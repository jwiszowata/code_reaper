public void showOpeningVideo(final String userMsg) {
    canvas.closeMenus();
    final Video video = ResourceManager.getVideo("video.opening");
    boolean muteAudio = !getSoundController().canPlaySound();
    final VideoComponent vp = new VideoComponent(video, muteAudio);
    final class AbortListener implements ActionListener, KeyListener, MouseListener, VideoListener {

        private Timer t = null;

        @Override
        public void keyPressed(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e1) {
            execute();
        }

        @Override
        public void keyTyped(KeyEvent e2) {
        }

        @Override
        public void mouseClicked(MouseEvent e3) {
            execute();
        }

        @Override
        public void mouseEntered(MouseEvent e4) {
        }

        @Override
        public void mouseExited(MouseEvent e5) {
        }

        @Override
        public void mousePressed(MouseEvent e6) {
        }

        @Override
        public void mouseReleased(MouseEvent e7) {
        }

        @Override
        public void stopped() {
            execute();
        }

        @Override
        public void actionPerformed(ActionEvent ae8) {
            execute();
        }

        private void setTimer(Timer t1) {
            this.t = t1;
        }

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
    }
    AbortListener l = new AbortListener();
    vp.addMouseListener(l);
    canvas.showVideoComponent(vp, l, l);
    vp.play();
    Timer t2 = new Timer(80000, l);
    l.setTimer(t2);
    t2.setRepeats(false);
    t2.start();
}