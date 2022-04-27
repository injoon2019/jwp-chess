package chess.web.dao;

import chess.domain.piece.Piece;
import chess.domain.piece.position.Position;
import java.util.Map;

public interface ChessBoardDao {

    void save(Position position, Piece piece, int roomId);

    void deleteAll(int roomId);

    Map<Position, Piece> findAll(int roomId);
}
