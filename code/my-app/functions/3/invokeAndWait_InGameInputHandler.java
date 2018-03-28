private void invokeAndWait(Runnable runnable) {
    getGUI().invokeNowOrWait(runnable);
}