private static String readVersion(JarURLConnection juc) throws IOException {
    Manifest mf = juc.getManifest();
    return (mf == null) ? null : mf.getMainAttributes().getValue("Package-Version");
}