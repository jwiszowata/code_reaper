public void invalidateCanSeeTiles() {
    synchronized (canSeeLock) {
        canSeeValid = false;
    }
}