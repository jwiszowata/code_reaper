public void run() {
    viewFreeColDialog(fcd, tile);
    new Thread(fcd.toString()) {

        @Override
        public void run() {
            while (!fcd.responded()) {
                Utils.delay(500, "Dialog interrupted.");
            }
            handler.handle(fcd.getResponse());
        }
    }.start();
}