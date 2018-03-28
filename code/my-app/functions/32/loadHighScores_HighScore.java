public static List<HighScore> loadHighScores() {
    List<HighScore> scores = new ArrayList<>();
    File hsf = FreeColDirectories.getHighScoreFile();
    if (!hsf.exists()) {
        try {
            if (hsf.createNewFile()) {
                logger.info("Created empty high score file: " + hsf.getPath());
                saveHighScores(scores);
            } else {
                logger.warning("High score file not created");
            }
        } catch (IOException ioe) {
            scores = null;
            logger.log(Level.WARNING, "Unable to create high score file: " + hsf.getPath(), ioe);
        }
        return scores;
    }
    try (FileInputStream fis = new FileInputStream(hsf);
        FreeColXMLReader xr = new FreeColXMLReader(fis)) {
        xr.nextTag();
        while (xr.moreTags()) {
            final String tag = xr.getLocalName();
            if (HighScore.TAG.equals(tag)) {
                scores.add(new HighScore(xr));
            }
        }
    } catch (Exception e) {
        logger.log(Level.WARNING, "Error loading high scores.", e);
    }
    tidyScores(scores);
    return scores;
}