public static void stopServer() {
    if (server != null) {
        Controller c = server.getController();
        assertNotNull(c);
        c.shutdown();
        server = null;
    }
}