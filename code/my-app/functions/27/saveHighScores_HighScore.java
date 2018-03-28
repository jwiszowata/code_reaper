public static boolean saveHighScores(List<HighScore> scores) {
    boolean ret = false;
    if (scores == null)
        return false;
    tidyScores(scores);
    File hsf = FreeColDirectories.getHighScoreFile();
    try (FileOutputStream fos = new FileOutputStream(hsf);
        FreeColXMLWriter xw = new FreeColXMLWriter(fos, FreeColXMLWriter.WriteScope.toSave(), true)) {
        ret = true;
        xw.writeStartDocument("UTF-8", "1.0");
        xw.writeStartElement(HIGH_SCORES_TAG);
        for (HighScore score : scores) score.toXML(xw);
        xw.writeEndElement();
        xw.writeEndDocument();
        xw.flush();
    } catch (FileNotFoundException fnfe) {
        logger.log(Level.WARNING, "Failed to open high scores file.", fnfe);
        ret = false;
    } catch (IOException ioe) {
        logger.log(Level.WARNING, "Error creating FreeColXMLWriter.", ioe);
        ret = false;
    } catch (XMLStreamException xse) {
        logger.log(Level.WARNING, "Failed to write high scores file.", xse);
        ret = false;
    }
    return ret;
}