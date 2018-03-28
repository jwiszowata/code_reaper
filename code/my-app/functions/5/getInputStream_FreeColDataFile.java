public BufferedInputStream getInputStream(String filename) throws IOException {
    final URLConnection connection = getURI(filename).toURL().openConnection();
    connection.setDefaultUseCaches(false);
    return new BufferedInputStream(connection.getInputStream());
}