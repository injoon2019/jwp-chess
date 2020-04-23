package wooteco.chess.controller;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import wooteco.chess.domain.board.Board;
import wooteco.chess.service.ChessGameService;

import java.sql.SQLException;
import java.util.Map;

import static spark.Spark.*;

public class SparkChessController {
    private ChessGameService chessGameService;

    public SparkChessController(final ChessGameService chessGameService) throws SQLException {
        this.chessGameService = chessGameService;
    }

    public void run() {
        staticFiles.location("/public");

        get("/", (req, res) -> {
            return render(chessGameService.receiveLoadedBoard(), "index.html");
        });

        post("/start", (req, res) -> {
            chessGameService.initializeTurn();
            return render(chessGameService.receiveInitializedBoard(), "index.html");
        });

        post("/end", (req, res) -> render(chessGameService.receiveEmptyBoard(), "index.html"));

        post("/load", (req, res) -> render(chessGameService.receiveLoadedBoard(), "index.html"));

        post("/move", (req, res) -> {
            try {
                Board board = chessGameService.receiveMovedBoard(
                        req.queryParams("fromPiece"), req.queryParams("toPiece"));
                if (chessGameService.isFinish(board)) {
                    return chessGameService.receiveWinner();
                }
            } catch(IllegalArgumentException e) {
                res.status(400);
                return e.getMessage();
            }
            return req.queryParams("fromPiece")+ " " +req.queryParams("toPiece");
        });

        post("/status", (req, res) -> {
            Map<String, Object> model = chessGameService.receiveScoreStatus();
            return render(model, "index.html");
        });

        get("/turn", (req, res) -> {
            return chessGameService.getCurrentTurn().toString();
        });
    }

    private static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
