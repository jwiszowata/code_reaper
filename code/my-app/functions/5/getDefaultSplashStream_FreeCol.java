private static InputStream getDefaultSplashStream(JarURLConnection juc) throws IOException {
    JarFile jf = juc.getJarFile();
    ZipEntry ze = jf.getEntry(SPLASH_DEFAULT);
    return jf.getInputStream(ze);
}