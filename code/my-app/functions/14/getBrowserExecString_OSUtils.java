private static final String[] getBrowserExecString(String url) {
    final String os = getOperatingSystem();
    if (os == null) {
        return null;
    } else if (os.toLowerCase().contains("mac")) {
        return new String[] { "open", "-a", "Safari", url };
    } else if (os.toLowerCase().contains("windows")) {
        return new String[] { "rundll32.exe", "url.dll,FileProtocolHandler", url };
    } else if (os.toLowerCase().contains("linux")) {
        return new String[] { "xdg-open", url };
    } else {
        return new String[] { "firefox", url };
    }
}