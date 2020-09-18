
package beans;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Trello {

    @SerializedName("board")
    @Expose
    private Integer board;
    @SerializedName("card")
    @Expose
    private Integer card;

    public Integer getBoard() {
        return board;
    }

    public void setBoard(Integer board) {
        this.board = board;
    }

    public Integer getCard() {
        return card;
    }

    public void setCard(Integer card) {
        this.card = card;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Trello.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("board");
        sb.append('=');
        sb.append(((this.board == null)?"<null>":this.board));
        sb.append(',');
        sb.append("card");
        sb.append('=');
        sb.append(((this.card == null)?"<null>":this.card));
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
        result = ((result* 31)+((this.board == null)? 0 :this.board.hashCode()));
        result = ((result* 31)+((this.card == null)? 0 :this.card.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Trello) == false) {
            return false;
        }
        Trello rhs = ((Trello) other);
        return (((this.board == rhs.board)||((this.board!= null)&&this.board.equals(rhs.board)))&&((this.card == rhs.card)||((this.card!= null)&&this.card.equals(rhs.card))));
    }

}
