
package beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class TrelloCard {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("checkItemStates")
    @Expose
    private List<Object> checkItemStates = new ArrayList<Object>();
    @SerializedName("closed")
    @Expose
    private Boolean closed;
    @SerializedName("dateLastActivity")
    @Expose
    private String dateLastActivity;
    @SerializedName("desc")
    @Expose
    private String desc;
    @SerializedName("descData")
    @Expose
    private DescData__1 descData;
    @SerializedName("dueReminder")
    @Expose
    private Object dueReminder;
    @SerializedName("idBoard")
    @Expose
    private String idBoard;
    @SerializedName("idList")
    @Expose
    private String idList;
    @SerializedName("idMembersVoted")
    @Expose
    private List<Object> idMembersVoted = new ArrayList<Object>();
    @SerializedName("idShort")
    @Expose
    private Integer idShort;
    @SerializedName("idAttachmentCover")
    @Expose
    private Object idAttachmentCover;
    @SerializedName("idLabels")
    @Expose
    private List<Object> idLabels = new ArrayList<Object>();
    @SerializedName("manualCoverAttachment")
    @Expose
    private Boolean manualCoverAttachment;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("pos")
    @Expose
    private Integer pos;
    @SerializedName("shortLink")
    @Expose
    private String shortLink;
    @SerializedName("isTemplate")
    @Expose
    private Boolean isTemplate;
    @SerializedName("dueComplete")
    @Expose
    private Boolean dueComplete;
    @SerializedName("due")
    @Expose
    private Object due;
    @SerializedName("email")
    @Expose
    private Object email;
    @SerializedName("labels")
    @Expose
    private List<Object> labels = new ArrayList<Object>();
    @SerializedName("shortUrl")
    @Expose
    private String shortUrl;
    @SerializedName("start")
    @Expose
    private Object start;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("cover")
    @Expose
    private Cover__1 cover;
    @SerializedName("idMembers")
    @Expose
    private List<Object> idMembers = new ArrayList<Object>();
    @SerializedName("badges")
    @Expose
    private Badges__1 badges;
    @SerializedName("subscribed")
    @Expose
    private Boolean subscribed;
    @SerializedName("idChecklists")
    @Expose
    private List<Object> idChecklists = new ArrayList<Object>();
    @SerializedName("attachments")
    @Expose
    private List<Object> attachments = new ArrayList<Object>();
    @SerializedName("stickers")
    @Expose
    private List<Object> stickers = new ArrayList<Object>();
    @SerializedName("limits")
    @Expose
    private Limits__1 limits;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Object> getCheckItemStates() {
        return checkItemStates;
    }

    public void setCheckItemStates(List<Object> checkItemStates) {
        this.checkItemStates = checkItemStates;
    }

    public Boolean getClosed() {
        return closed;
    }

    public void setClosed(Boolean closed) {
        this.closed = closed;
    }

    public String getDateLastActivity() {
        return dateLastActivity;
    }

    public void setDateLastActivity(String dateLastActivity) {
        this.dateLastActivity = dateLastActivity;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public DescData__1 getDescData() {
        return descData;
    }

    public void setDescData(DescData__1 descData) {
        this.descData = descData;
    }

    public Object getDueReminder() {
        return dueReminder;
    }

    public void setDueReminder(Object dueReminder) {
        this.dueReminder = dueReminder;
    }

    public String getIdBoard() {
        return idBoard;
    }

    public void setIdBoard(String idBoard) {
        this.idBoard = idBoard;
    }

    public String getIdList() {
        return idList;
    }

    public void setIdList(String idList) {
        this.idList = idList;
    }

    public List<Object> getIdMembersVoted() {
        return idMembersVoted;
    }

    public void setIdMembersVoted(List<Object> idMembersVoted) {
        this.idMembersVoted = idMembersVoted;
    }

    public Integer getIdShort() {
        return idShort;
    }

    public void setIdShort(Integer idShort) {
        this.idShort = idShort;
    }

    public Object getIdAttachmentCover() {
        return idAttachmentCover;
    }

    public void setIdAttachmentCover(Object idAttachmentCover) {
        this.idAttachmentCover = idAttachmentCover;
    }

    public List<Object> getIdLabels() {
        return idLabels;
    }

    public void setIdLabels(List<Object> idLabels) {
        this.idLabels = idLabels;
    }

    public Boolean getManualCoverAttachment() {
        return manualCoverAttachment;
    }

    public void setManualCoverAttachment(Boolean manualCoverAttachment) {
        this.manualCoverAttachment = manualCoverAttachment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPos() {
        return pos;
    }

    public void setPos(Integer pos) {
        this.pos = pos;
    }

    public String getShortLink() {
        return shortLink;
    }

    public void setShortLink(String shortLink) {
        this.shortLink = shortLink;
    }

    public Boolean getIsTemplate() {
        return isTemplate;
    }

    public void setIsTemplate(Boolean isTemplate) {
        this.isTemplate = isTemplate;
    }

    public Boolean getDueComplete() {
        return dueComplete;
    }

    public void setDueComplete(Boolean dueComplete) {
        this.dueComplete = dueComplete;
    }

    public Object getDue() {
        return due;
    }

    public void setDue(Object due) {
        this.due = due;
    }

    public Object getEmail() {
        return email;
    }

    public void setEmail(Object email) {
        this.email = email;
    }

    public List<Object> getLabels() {
        return labels;
    }

    public void setLabels(List<Object> labels) {
        this.labels = labels;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public Object getStart() {
        return start;
    }

    public void setStart(Object start) {
        this.start = start;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Cover__1 getCover() {
        return cover;
    }

    public void setCover(Cover__1 cover) {
        this.cover = cover;
    }

    public List<Object> getIdMembers() {
        return idMembers;
    }

    public void setIdMembers(List<Object> idMembers) {
        this.idMembers = idMembers;
    }

    public Badges__1 getBadges() {
        return badges;
    }

    public void setBadges(Badges__1 badges) {
        this.badges = badges;
    }

    public Boolean getSubscribed() {
        return subscribed;
    }

    public void setSubscribed(Boolean subscribed) {
        this.subscribed = subscribed;
    }

    public List<Object> getIdChecklists() {
        return idChecklists;
    }

    public void setIdChecklists(List<Object> idChecklists) {
        this.idChecklists = idChecklists;
    }

    public List<Object> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Object> attachments) {
        this.attachments = attachments;
    }

    public List<Object> getStickers() {
        return stickers;
    }

    public void setStickers(List<Object> stickers) {
        this.stickers = stickers;
    }

    public Limits__1 getLimits() {
        return limits;
    }

    public void setLimits(Limits__1 limits) {
        this.limits = limits;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TrelloCard.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("checkItemStates");
        sb.append('=');
        sb.append(((this.checkItemStates == null)?"<null>":this.checkItemStates));
        sb.append(',');
        sb.append("closed");
        sb.append('=');
        sb.append(((this.closed == null)?"<null>":this.closed));
        sb.append(',');
        sb.append("dateLastActivity");
        sb.append('=');
        sb.append(((this.dateLastActivity == null)?"<null>":this.dateLastActivity));
        sb.append(',');
        sb.append("desc");
        sb.append('=');
        sb.append(((this.desc == null)?"<null>":this.desc));
        sb.append(',');
        sb.append("descData");
        sb.append('=');
        sb.append(((this.descData == null)?"<null>":this.descData));
        sb.append(',');
        sb.append("dueReminder");
        sb.append('=');
        sb.append(((this.dueReminder == null)?"<null>":this.dueReminder));
        sb.append(',');
        sb.append("idBoard");
        sb.append('=');
        sb.append(((this.idBoard == null)?"<null>":this.idBoard));
        sb.append(',');
        sb.append("idList");
        sb.append('=');
        sb.append(((this.idList == null)?"<null>":this.idList));
        sb.append(',');
        sb.append("idMembersVoted");
        sb.append('=');
        sb.append(((this.idMembersVoted == null)?"<null>":this.idMembersVoted));
        sb.append(',');
        sb.append("idShort");
        sb.append('=');
        sb.append(((this.idShort == null)?"<null>":this.idShort));
        sb.append(',');
        sb.append("idAttachmentCover");
        sb.append('=');
        sb.append(((this.idAttachmentCover == null)?"<null>":this.idAttachmentCover));
        sb.append(',');
        sb.append("idLabels");
        sb.append('=');
        sb.append(((this.idLabels == null)?"<null>":this.idLabels));
        sb.append(',');
        sb.append("manualCoverAttachment");
        sb.append('=');
        sb.append(((this.manualCoverAttachment == null)?"<null>":this.manualCoverAttachment));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("pos");
        sb.append('=');
        sb.append(((this.pos == null)?"<null>":this.pos));
        sb.append(',');
        sb.append("shortLink");
        sb.append('=');
        sb.append(((this.shortLink == null)?"<null>":this.shortLink));
        sb.append(',');
        sb.append("isTemplate");
        sb.append('=');
        sb.append(((this.isTemplate == null)?"<null>":this.isTemplate));
        sb.append(',');
        sb.append("dueComplete");
        sb.append('=');
        sb.append(((this.dueComplete == null)?"<null>":this.dueComplete));
        sb.append(',');
        sb.append("due");
        sb.append('=');
        sb.append(((this.due == null)?"<null>":this.due));
        sb.append(',');
        sb.append("email");
        sb.append('=');
        sb.append(((this.email == null)?"<null>":this.email));
        sb.append(',');
        sb.append("labels");
        sb.append('=');
        sb.append(((this.labels == null)?"<null>":this.labels));
        sb.append(',');
        sb.append("shortUrl");
        sb.append('=');
        sb.append(((this.shortUrl == null)?"<null>":this.shortUrl));
        sb.append(',');
        sb.append("start");
        sb.append('=');
        sb.append(((this.start == null)?"<null>":this.start));
        sb.append(',');
        sb.append("url");
        sb.append('=');
        sb.append(((this.url == null)?"<null>":this.url));
        sb.append(',');
        sb.append("cover");
        sb.append('=');
        sb.append(((this.cover == null)?"<null>":this.cover));
        sb.append(',');
        sb.append("idMembers");
        sb.append('=');
        sb.append(((this.idMembers == null)?"<null>":this.idMembers));
        sb.append(',');
        sb.append("badges");
        sb.append('=');
        sb.append(((this.badges == null)?"<null>":this.badges));
        sb.append(',');
        sb.append("subscribed");
        sb.append('=');
        sb.append(((this.subscribed == null)?"<null>":this.subscribed));
        sb.append(',');
        sb.append("idChecklists");
        sb.append('=');
        sb.append(((this.idChecklists == null)?"<null>":this.idChecklists));
        sb.append(',');
        sb.append("attachments");
        sb.append('=');
        sb.append(((this.attachments == null)?"<null>":this.attachments));
        sb.append(',');
        sb.append("stickers");
        sb.append('=');
        sb.append(((this.stickers == null)?"<null>":this.stickers));
        sb.append(',');
        sb.append("limits");
        sb.append('=');
        sb.append(((this.limits == null)?"<null>":this.limits));
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
        result = ((result* 31)+((this.descData == null)? 0 :this.descData.hashCode()));
        result = ((result* 31)+((this.attachments == null)? 0 :this.attachments.hashCode()));
        result = ((result* 31)+((this.idLabels == null)? 0 :this.idLabels.hashCode()));
        result = ((result* 31)+((this.shortUrl == null)? 0 :this.shortUrl.hashCode()));
        result = ((result* 31)+((this.dueComplete == null)? 0 :this.dueComplete.hashCode()));
        result = ((result* 31)+((this.dateLastActivity == null)? 0 :this.dateLastActivity.hashCode()));
        result = ((result* 31)+((this.idList == null)? 0 :this.idList.hashCode()));
        result = ((result* 31)+((this.idMembersVoted == null)? 0 :this.idMembersVoted.hashCode()));
        result = ((result* 31)+((this.shortLink == null)? 0 :this.shortLink.hashCode()));
        result = ((result* 31)+((this.cover == null)? 0 :this.cover.hashCode()));
        result = ((result* 31)+((this.dueReminder == null)? 0 :this.dueReminder.hashCode()));
        result = ((result* 31)+((this.subscribed == null)? 0 :this.subscribed.hashCode()));
        result = ((result* 31)+((this.pos == null)? 0 :this.pos.hashCode()));
        result = ((result* 31)+((this.idChecklists == null)? 0 :this.idChecklists.hashCode()));
        result = ((result* 31)+((this.stickers == null)? 0 :this.stickers.hashCode()));
        result = ((result* 31)+((this.id == null)? 0 :this.id.hashCode()));
        result = ((result* 31)+((this.email == null)? 0 :this.email.hashCode()));
        result = ((result* 31)+((this.limits == null)? 0 :this.limits.hashCode()));
        result = ((result* 31)+((this.idBoard == null)? 0 :this.idBoard.hashCode()));
        result = ((result* 31)+((this.start == null)? 0 :this.start.hashCode()));
        result = ((result* 31)+((this.checkItemStates == null)? 0 :this.checkItemStates.hashCode()));
        result = ((result* 31)+((this.url == null)? 0 :this.url.hashCode()));
        result = ((result* 31)+((this.labels == null)? 0 :this.labels.hashCode()));
        result = ((result* 31)+((this.idMembers == null)? 0 :this.idMembers.hashCode()));
        result = ((result* 31)+((this.badges == null)? 0 :this.badges.hashCode()));
        result = ((result* 31)+((this.idShort == null)? 0 :this.idShort.hashCode()));
        result = ((result* 31)+((this.due == null)? 0 :this.due.hashCode()));
        result = ((result* 31)+((this.idAttachmentCover == null)? 0 :this.idAttachmentCover.hashCode()));
        result = ((result* 31)+((this.isTemplate == null)? 0 :this.isTemplate.hashCode()));
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+((this.closed == null)? 0 :this.closed.hashCode()));
        result = ((result* 31)+((this.manualCoverAttachment == null)? 0 :this.manualCoverAttachment.hashCode()));
        result = ((result* 31)+((this.desc == null)? 0 :this.desc.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TrelloCard) == false) {
            return false;
        }
        TrelloCard rhs = ((TrelloCard) other);
        return ((((((((((((((((((((((((((((((((((this.descData == rhs.descData)||((this.descData!= null)&&this.descData.equals(rhs.descData)))&&((this.attachments == rhs.attachments)||((this.attachments!= null)&&this.attachments.equals(rhs.attachments))))&&((this.idLabels == rhs.idLabels)||((this.idLabels!= null)&&this.idLabels.equals(rhs.idLabels))))&&((this.shortUrl == rhs.shortUrl)||((this.shortUrl!= null)&&this.shortUrl.equals(rhs.shortUrl))))&&((this.dueComplete == rhs.dueComplete)||((this.dueComplete!= null)&&this.dueComplete.equals(rhs.dueComplete))))&&((this.dateLastActivity == rhs.dateLastActivity)||((this.dateLastActivity!= null)&&this.dateLastActivity.equals(rhs.dateLastActivity))))&&((this.idList == rhs.idList)||((this.idList!= null)&&this.idList.equals(rhs.idList))))&&((this.idMembersVoted == rhs.idMembersVoted)||((this.idMembersVoted!= null)&&this.idMembersVoted.equals(rhs.idMembersVoted))))&&((this.shortLink == rhs.shortLink)||((this.shortLink!= null)&&this.shortLink.equals(rhs.shortLink))))&&((this.cover == rhs.cover)||((this.cover!= null)&&this.cover.equals(rhs.cover))))&&((this.dueReminder == rhs.dueReminder)||((this.dueReminder!= null)&&this.dueReminder.equals(rhs.dueReminder))))&&((this.subscribed == rhs.subscribed)||((this.subscribed!= null)&&this.subscribed.equals(rhs.subscribed))))&&((this.pos == rhs.pos)||((this.pos!= null)&&this.pos.equals(rhs.pos))))&&((this.idChecklists == rhs.idChecklists)||((this.idChecklists!= null)&&this.idChecklists.equals(rhs.idChecklists))))&&((this.stickers == rhs.stickers)||((this.stickers!= null)&&this.stickers.equals(rhs.stickers))))&&((this.id == rhs.id)||((this.id!= null)&&this.id.equals(rhs.id))))&&((this.email == rhs.email)||((this.email!= null)&&this.email.equals(rhs.email))))&&((this.limits == rhs.limits)||((this.limits!= null)&&this.limits.equals(rhs.limits))))&&((this.idBoard == rhs.idBoard)||((this.idBoard!= null)&&this.idBoard.equals(rhs.idBoard))))&&((this.start == rhs.start)||((this.start!= null)&&this.start.equals(rhs.start))))&&((this.checkItemStates == rhs.checkItemStates)||((this.checkItemStates!= null)&&this.checkItemStates.equals(rhs.checkItemStates))))&&((this.url == rhs.url)||((this.url!= null)&&this.url.equals(rhs.url))))&&((this.labels == rhs.labels)||((this.labels!= null)&&this.labels.equals(rhs.labels))))&&((this.idMembers == rhs.idMembers)||((this.idMembers!= null)&&this.idMembers.equals(rhs.idMembers))))&&((this.badges == rhs.badges)||((this.badges!= null)&&this.badges.equals(rhs.badges))))&&((this.idShort == rhs.idShort)||((this.idShort!= null)&&this.idShort.equals(rhs.idShort))))&&((this.due == rhs.due)||((this.due!= null)&&this.due.equals(rhs.due))))&&((this.idAttachmentCover == rhs.idAttachmentCover)||((this.idAttachmentCover!= null)&&this.idAttachmentCover.equals(rhs.idAttachmentCover))))&&((this.isTemplate == rhs.isTemplate)||((this.isTemplate!= null)&&this.isTemplate.equals(rhs.isTemplate))))&&((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name))))&&((this.closed == rhs.closed)||((this.closed!= null)&&this.closed.equals(rhs.closed))))&&((this.manualCoverAttachment == rhs.manualCoverAttachment)||((this.manualCoverAttachment!= null)&&this.manualCoverAttachment.equals(rhs.manualCoverAttachment))))&&((this.desc == rhs.desc)||((this.desc!= null)&&this.desc.equals(rhs.desc))));
    }

}
