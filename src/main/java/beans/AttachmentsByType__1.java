
package beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AttachmentsByType__1 {

    @SerializedName("trello")
    @Expose
    private Trello__1 trello;

    public Trello__1 getTrello() {
        return trello;
    }

    public void setTrello(Trello__1 trello) {
        this.trello = trello;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AttachmentsByType__1 .class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
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
        if ((other instanceof AttachmentsByType__1) == false) {
            return false;
        }
        AttachmentsByType__1 rhs = ((AttachmentsByType__1) other);
        return ((this.trello == rhs.trello)||((this.trello!= null)&&this.trello.equals(rhs.trello)));
    }

}
