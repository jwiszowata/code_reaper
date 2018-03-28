public void hideSplashScreen() {
    if (splash != null) {
        splash.setVisible(false);
        splash.dispose();
        splash = null;
    }
}