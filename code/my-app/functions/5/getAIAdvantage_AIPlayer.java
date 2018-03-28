protected String getAIAdvantage() {
    final String prefix = "model.nationType.";
    String id = (player == null || player.getNationType() == null) ? "" : player.getNationType().getId();
    return (id.startsWith(prefix)) ? id.substring(prefix.length()) : "";
}