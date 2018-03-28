public void reallyClose() {
    try {
        super.close();
    } catch (IOException ioe) {
    }
}