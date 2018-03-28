public void actionPerformed(ActionEvent ae) {
    final String url = ae.getActionCommand();
    if (SITE_URL.equals(url) || PROJECT_URL.equals(url) || MANUAL_URL.equals(url)) {
        OSUtils.launchBrowser(url);
    } else {
        super.actionPerformed(ae);
    }
}