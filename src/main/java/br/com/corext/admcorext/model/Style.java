package br.com.corext.admcorext.model;

public class Style {

    private String nameClass;
    private String valClass;

    public Style(String nameClass, String valClass) {
        this.nameClass = nameClass;
        this.valClass = valClass;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    public String getValClass() {
        return valClass;
    }

    public void setValClass(String valClass) {
        this.valClass = valClass;
    }

    @Override
    public String toString() {
        return "Style [nameClass=" + nameClass + ", valClass=" + valClass + "]";
    }

}
