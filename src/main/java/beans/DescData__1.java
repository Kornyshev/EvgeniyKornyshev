
package beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DescData__1 {

    @SerializedName("emoji")
    @Expose
    private Emoji__1 emoji;

    public Emoji__1 getEmoji() {
        return emoji;
    }

    public void setEmoji(Emoji__1 emoji) {
        this.emoji = emoji;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(DescData__1 .class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("emoji");
        sb.append('=');
        sb.append(((this.emoji == null)?"<null>":this.emoji));
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
        result = ((result* 31)+((this.emoji == null)? 0 :this.emoji.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DescData__1) == false) {
            return false;
        }
        DescData__1 rhs = ((DescData__1) other);
        return ((this.emoji == rhs.emoji)||((this.emoji!= null)&&this.emoji.equals(rhs.emoji)));
    }

}
