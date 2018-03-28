public void run() {
    while (!fcd.responded()) {
        Utils.delay(500, "Dialog interrupted.");
    }
    handler.handle(fcd.getResponse());
}