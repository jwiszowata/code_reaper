public static Number getNumberForLanguage(String lang) {
    Number number = numberMap.get(lang);
    return (number == null) ? OTHER_NUMBER_RULE : number;
}