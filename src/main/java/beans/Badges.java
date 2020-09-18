
package beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Badges {

    @SerializedName("attachmentsByType")
    @Expose
    private AttachmentsByType attachmentsByType;
    @SerializedName("location")
    @Expose
    private Boolean location;
    @SerializedName("votes")
    @Expose
    private Integer votes;
    @SerializedName("viewingMemberVoted")
    @Expose
    private Boolean viewingMemberVoted;
    @SerializedName("subscribed")
    @Expose
    private Boolean subscribed;
    @SerializedName("fogbugz")
    @Expose
    private String fogbugz;
    @SerializedName("checkItems")
    @Expose
    private Integer checkItems;
    @SerializedName("checkItemsChecked")
    @Expose
    private Integer checkItemsChecked;
    @SerializedName("checkItemsEarliestDue")
    @Expose
    private Object checkItemsEarliestDue;
    @SerializedName("comments")
    @Expose
    private Integer comments;
    @SerializedName("attachments")
    @Expose
    private Integer attachments;
    @SerializedName("description")
    @Expose
    private Boolean description;
    @SerializedName("due")
    @Expose
    private Object due;
    @SerializedName("dueComplete")
    @Expose
    private Boolean dueComplete;
    @SerializedName("start")
    @Expose
    private Object start;

    public AttachmentsByType getAttachmentsByType() {
        return attachmentsByType;
    }

    public void setAttachmentsByType(AttachmentsByType attachmentsByType) {
        this.attachmentsByType = attachmentsByType;
    }

    public Boolean getLocation() {
        return location;
    }

    public void setLocation(Boolean location) {
        this.location = location;
    }

    public Integer getVotes() {
        return votes;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }

    public Boolean getViewingMemberVoted() {
        return viewingMemberVoted;
    }

    public void setViewingMemberVoted(Boolean viewingMemberVoted) {
        this.viewingMemberVoted = viewingMemberVoted;
    }

    public Boolean getSubscribed() {
        return subscribed;
    }

    public void setSubscribed(Boolean subscribed) {
        this.subscribed = subscribed;
    }

    public String getFogbugz() {
        return fogbugz;
    }

    public void setFogbugz(String fogbugz) {
        this.fogbugz = fogbugz;
    }

    public Integer getCheckItems() {
        return checkItems;
    }

    public void setCheckItems(Integer checkItems) {
        this.checkItems = checkItems;
    }

    public Integer getCheckItemsChecked() {
        return checkItemsChecked;
    }

    public void setCheckItemsChecked(Integer checkItemsChecked) {
        this.checkItemsChecked = checkItemsChecked;
    }

    public Object getCheckItemsEarliestDue() {
        return checkItemsEarliestDue;
    }

    public void setCheckItemsEarliestDue(Object checkItemsEarliestDue) {
        this.checkItemsEarliestDue = checkItemsEarliestDue;
    }

    public Integer getComments() {
        return comments;
    }

    public void setComments(Integer comments) {
        this.comments = comments;
    }

    public Integer getAttachments() {
        return attachments;
    }

    public void setAttachments(Integer attachments) {
        this.attachments = attachments;
    }

    public Boolean getDescription() {
        return description;
    }

    public void setDescription(Boolean description) {
        this.description = description;
    }

    public Object getDue() {
        return due;
    }

    public void setDue(Object due) {
        this.due = due;
    }

    public Boolean getDueComplete() {
        return dueComplete;
    }

    public void setDueComplete(Boolean dueComplete) {
        this.dueComplete = dueComplete;
    }

    public Object getStart() {
        return start;
    }

    public void setStart(Object start) {
        this.start = start;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Badges.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("attachmentsByType");
        sb.append('=');
        sb.append(((this.attachmentsByType == null)?"<null>":this.attachmentsByType));
        sb.append(',');
        sb.append("location");
        sb.append('=');
        sb.append(((this.location == null)?"<null>":this.location));
        sb.append(',');
        sb.append("votes");
        sb.append('=');
        sb.append(((this.votes == null)?"<null>":this.votes));
        sb.append(',');
        sb.append("viewingMemberVoted");
        sb.append('=');
        sb.append(((this.viewingMemberVoted == null)?"<null>":this.viewingMemberVoted));
        sb.append(',');
        sb.append("subscribed");
        sb.append('=');
        sb.append(((this.subscribed == null)?"<null>":this.subscribed));
        sb.append(',');
        sb.append("fogbugz");
        sb.append('=');
        sb.append(((this.fogbugz == null)?"<null>":this.fogbugz));
        sb.append(',');
        sb.append("checkItems");
        sb.append('=');
        sb.append(((this.checkItems == null)?"<null>":this.checkItems));
        sb.append(',');
        sb.append("checkItemsChecked");
        sb.append('=');
        sb.append(((this.checkItemsChecked == null)?"<null>":this.checkItemsChecked));
        sb.append(',');
        sb.append("checkItemsEarliestDue");
        sb.append('=');
        sb.append(((this.checkItemsEarliestDue == null)?"<null>":this.checkItemsEarliestDue));
        sb.append(',');
        sb.append("comments");
        sb.append('=');
        sb.append(((this.comments == null)?"<null>":this.comments));
        sb.append(',');
        sb.append("attachments");
        sb.append('=');
        sb.append(((this.attachments == null)?"<null>":this.attachments));
        sb.append(',');
        sb.append("description");
        sb.append('=');
        sb.append(((this.description == null)?"<null>":this.description));
        sb.append(',');
        sb.append("due");
        sb.append('=');
        sb.append(((this.due == null)?"<null>":this.due));
        sb.append(',');
        sb.append("dueComplete");
        sb.append('=');
        sb.append(((this.dueComplete == null)?"<null>":this.dueComplete));
        sb.append(',');
        sb.append("start");
        sb.append('=');
        sb.append(((this.start == null)?"<null>":this.start));
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
        result = ((result* 31)+((this.comments == null)? 0 :this.comments.hashCode()));
        result = ((result* 31)+((this.attachments == null)? 0 :this.attachments.hashCode()));
        result = ((result* 31)+((this.attachmentsByType == null)? 0 :this.attachmentsByType.hashCode()));
        result = ((result* 31)+((this.dueComplete == null)? 0 :this.dueComplete.hashCode()));
        result = ((result* 31)+((this.start == null)? 0 :this.start.hashCode()));
        result = ((result* 31)+((this.description == null)? 0 :this.description.hashCode()));
        result = ((result* 31)+((this.checkItemsEarliestDue == null)? 0 :this.checkItemsEarliestDue.hashCode()));
        result = ((result* 31)+((this.subscribed == null)? 0 :this.subscribed.hashCode()));
        result = ((result* 31)+((this.due == null)? 0 :this.due.hashCode()));
        result = ((result* 31)+((this.viewingMemberVoted == null)? 0 :this.viewingMemberVoted.hashCode()));
        result = ((result* 31)+((this.location == null)? 0 :this.location.hashCode()));
        result = ((result* 31)+((this.votes == null)? 0 :this.votes.hashCode()));
        result = ((result* 31)+((this.fogbugz == null)? 0 :this.fogbugz.hashCode()));
        result = ((result* 31)+((this.checkItems == null)? 0 :this.checkItems.hashCode()));
        result = ((result* 31)+((this.checkItemsChecked == null)? 0 :this.checkItemsChecked.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Badges) == false) {
            return false;
        }
        Badges rhs = ((Badges) other);
        return ((((((((((((((((this.comments == rhs.comments)||((this.comments!= null)&&this.comments.equals(rhs.comments)))&&((this.attachments == rhs.attachments)||((this.attachments!= null)&&this.attachments.equals(rhs.attachments))))&&((this.attachmentsByType == rhs.attachmentsByType)||((this.attachmentsByType!= null)&&this.attachmentsByType.equals(rhs.attachmentsByType))))&&((this.dueComplete == rhs.dueComplete)||((this.dueComplete!= null)&&this.dueComplete.equals(rhs.dueComplete))))&&((this.start == rhs.start)||((this.start!= null)&&this.start.equals(rhs.start))))&&((this.description == rhs.description)||((this.description!= null)&&this.description.equals(rhs.description))))&&((this.checkItemsEarliestDue == rhs.checkItemsEarliestDue)||((this.checkItemsEarliestDue!= null)&&this.checkItemsEarliestDue.equals(rhs.checkItemsEarliestDue))))&&((this.subscribed == rhs.subscribed)||((this.subscribed!= null)&&this.subscribed.equals(rhs.subscribed))))&&((this.due == rhs.due)||((this.due!= null)&&this.due.equals(rhs.due))))&&((this.viewingMemberVoted == rhs.viewingMemberVoted)||((this.viewingMemberVoted!= null)&&this.viewingMemberVoted.equals(rhs.viewingMemberVoted))))&&((this.location == rhs.location)||((this.location!= null)&&this.location.equals(rhs.location))))&&((this.votes == rhs.votes)||((this.votes!= null)&&this.votes.equals(rhs.votes))))&&((this.fogbugz == rhs.fogbugz)||((this.fogbugz!= null)&&this.fogbugz.equals(rhs.fogbugz))))&&((this.checkItems == rhs.checkItems)||((this.checkItems!= null)&&this.checkItems.equals(rhs.checkItems))))&&((this.checkItemsChecked == rhs.checkItemsChecked)||((this.checkItemsChecked!= null)&&this.checkItemsChecked.equals(rhs.checkItemsChecked))));
    }

}
