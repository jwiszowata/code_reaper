public String toString() {
    StringBuilder result = new StringBuilder();
    append(result, "Production", production);
    append(result, " Consumption", consumption);
    append(result, " Maximum Production", maximumProduction);
    append(result, " Maximum Consumption", maximumConsumption);
    return result.toString();
}