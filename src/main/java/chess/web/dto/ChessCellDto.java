package chess.web.dto;

public class ChessCellDto {
    private String position;
    private String piece;

    public ChessCellDto(String position, String piece) {
        this.position = position;
        this.piece = piece;
    }

    public String getPosition() {
        return position;
    }

    public String getPiece() {
        return piece;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setPiece(String piece) {
        this.piece = piece;
    }
}
