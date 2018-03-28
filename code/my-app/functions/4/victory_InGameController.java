public void victory(String score) {
    displayHighScores("true".equalsIgnoreCase(score));
    getGUI().showVictoryDialog((Boolean result) -> victory(result));
}