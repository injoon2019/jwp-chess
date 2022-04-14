package chess.web;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;
import static spark.Spark.staticFileLocation;

import chess.web.controller.ChessController;
import chess.web.dao.ChessBoardDao;
import chess.web.dao.PlayerDao;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class WebApplication {

    public static void main(String[] args) {
        port(8082);
        staticFileLocation("/static");

        ChessBoardDao chessBoardDao = new ChessBoardDao();
        PlayerDao playerDao = new PlayerDao();
        ChessController chessController = new ChessController(chessBoardDao, playerDao);

        get("/", (req, res) -> render(chessController.root(req, res)));
        get("/start", (req, res) -> render(chessController.start(req, res)));
        get("/play", (req, res) -> render(chessController.play(req, res)));
        get("/end", (req, res) -> render(chessController.end(req, res)));

        post("/move", (req, res) -> render(chessController.move(req, res)));
    }

    private static String render(ModelAndView modelAndView) {
        return new HandlebarsTemplateEngine().render(modelAndView);
    }
}
