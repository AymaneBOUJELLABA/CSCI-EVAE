package fr.ubo.dosi.CSCIEVAE.entity;

import java.io.Serializable;
import java.util.Objects;

public class UniteEnseignementId implements Serializable {
    private String codeFormation;
    private String codeUe;
    public String getCodeFormation() {
        return codeFormation;
    }
    public void setCodeFormation(String codeFormation) {
        this.codeFormation = codeFormation;
    }
    public String getCodeUe() {
        return codeUe;
    }
    public void setCodeUe(String codeUe) {
        this.codeUe = codeUe;
    }
    @Override
    public int hashCode() {
        return Objects.hash(codeFormation, codeUe);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UniteEnseignementId other = (UniteEnseignementId) obj;
        return Objects.equals(codeFormation, other.codeFormation) && Objects.equals(codeUe, other.codeUe);
    }

}
