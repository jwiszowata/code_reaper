public static String getValidGUIScales() {
    StringBuilder sb = new StringBuilder(64);
    for (int i = GUI_SCALE_MIN_PCT; i <= GUI_SCALE_MAX_PCT; i += GUI_SCALE_STEP_PCT) sb.append(i).append(',');
    sb.setLength(sb.length() - 1);
    return sb.toString();
}