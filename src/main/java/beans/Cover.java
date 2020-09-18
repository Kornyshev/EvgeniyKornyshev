
package beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cover {

    @SerializedName("idAttachment")
    @Expose
    private Object idAttachment;
    @SerializedName("color")
    @Expose
    private Object color;
    @SerializedName("idUploadedBackground")
    @Expose
    private Object idUploadedBackground;
    @SerializedName("size")
    @Expose
    private String size;
    @SerializedName("brightness")
    @Expose
    private String brightness;

    public Object getIdAttachment() {
        return idAttachment;
    }

    public void setIdAttachment(Object idAttachment) {
        this.idAttachment = idAttachment;
    }

    public Object getColor() {
        return color;
    }

    public void setColor(Object color) {
        this.color = color;
    }

    public Object getIdUploadedBackground() {
        return idUploadedBackground;
    }

    public void setIdUploadedBackground(Object idUploadedBackground) {
        this.idUploadedBackground = idUploadedBackground;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getBrightness() {
        return brightness;
    }

    public void setBrightness(String brightness) {
        this.brightness = brightness;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Cover.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("idAttachment");
        sb.append('=');
        sb.append(((this.idAttachment == null)?"<null>":this.idAttachment));
        sb.append(',');
        sb.append("color");
        sb.append('=');
        sb.append(((this.color == null)?"<null>":this.color));
        sb.append(',');
        sb.append("idUploadedBackground");
        sb.append('=');
        sb.append(((this.idUploadedBackground == null)?"<null>":this.idUploadedBackground));
        sb.append(',');
        sb.append("size");
        sb.append('=');
        sb.append(((this.size == null)?"<null>":this.size));
        sb.append(',');
        sb.append("brightness");
        sb.append('=');
        sb.append(((this.brightness == null)?"<null>":this.brightness));
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
        result = ((result* 31)+((this.idUploadedBackground == null)? 0 :this.idUploadedBackground.hashCode()));
        result = ((result* 31)+((this.brightness == null)? 0 :this.brightness.hashCode()));
        result = ((result* 31)+((this.color == null)? 0 :this.color.hashCode()));
        result = ((result* 31)+((this.size == null)? 0 :this.size.hashCode()));
        result = ((result* 31)+((this.idAttachment == null)? 0 :this.idAttachment.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Cover) == false) {
            return false;
        }
        Cover rhs = ((Cover) other);
        return ((((((this.idUploadedBackground == rhs.idUploadedBackground)||((this.idUploadedBackground!= null)&&this.idUploadedBackground.equals(rhs.idUploadedBackground)))&&((this.brightness == rhs.brightness)||((this.brightness!= null)&&this.brightness.equals(rhs.brightness))))&&((this.color == rhs.color)||((this.color!= null)&&this.color.equals(rhs.color))))&&((this.size == rhs.size)||((this.size!= null)&&this.size.equals(rhs.size))))&&((this.idAttachment == rhs.idAttachment)||((this.idAttachment!= null)&&this.idAttachment.equals(rhs.idAttachment))));
    }

}
