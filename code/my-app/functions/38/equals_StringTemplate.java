public boolean equals(Object o) {
    if (this == o)
        return true;
    if (o instanceof StringTemplate) {
        StringTemplate t = (StringTemplate) o;
        if (!super.equals(o) || this.templateType != t.templateType || !Utils.equals(this.defaultId, t.defaultId))
            return false;
        switch(this.templateType) {
            case TEMPLATE:
                if ((this.keys == null) != (t.keys == null))
                    return false;
                if (this.keys != null) {
                    if (this.keys.size() != t.keys.size() || this.keys.size() != this.replacements.size())
                        return false;
                    for (int i = 0; i < this.keys.size(); i++) {
                        if (!this.keys.get(i).equals(t.keys.get(i)))
                            return false;
                    }
                }
            case LABEL:
                if ((this.replacements == null) != (t.replacements == null))
                    return false;
                if (this.replacements != null) {
                    if (this.replacements.size() != t.replacements.size())
                        return false;
                    for (int i = 0; i < this.replacements.size(); i++) {
                        if (!this.replacements.get(i).equals(t.replacements.get(i)))
                            return false;
                    }
                }
                break;
            default:
                break;
        }
        return true;
    }
    return false;
}