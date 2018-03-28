private void addSuggestion(Map<UnitType, Suggestion> suggestions, UnitType expert, Suggestion suggestion) {
    if (suggestion == null || expert == null)
        return;
    Suggestion now = suggestions.get(expert);
    if (now == null || now.amount < suggestion.amount) {
        suggestions.put(expert, suggestion);
    }
}