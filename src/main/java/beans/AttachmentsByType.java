
package beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AttachmentsByType {

    @SerializedName("trello")
    @Expose
    private Trello trello;

    public Trello getTrello() {
        return trello;
    }

    public void setTrello(Trello trello) {
        this.trello = trello;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AttachmentsByType.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("trello");
        sb.append('=');
        sb.append(((this.trello == null)?"<null>":this.trello));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.trello == null)? 0 :this.trello.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AttachmentsByType) == false) {
            return false;
        }
        AttachmentsByType rhs = ((AttachmentsByType) other);
        return ((this.trello == rhs.trello)||((this.trello!= null)&&this.trello.equals(rhs.trello)));
    }

}
