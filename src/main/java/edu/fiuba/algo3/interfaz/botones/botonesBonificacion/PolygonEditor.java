package edu.fiuba.algo3.interfaz.botones.botonesBonificacion;

import javafx.scene.shape.Polygon;
//https://stackoverflow.com/questions/49550428/on-javafx-is-there-any-way-to-draw-a-regular-polygon-without-knowing-the-coordi

public class PolygonEditor {

    public static Polygon setPolygonSides(Polygon polygon, double centerX, double centerY, double radius, int sides) {
        polygon.getPoints().clear();
        final double angleStep = Math.PI * 2 / sides;
        double angle = 0; // assumes one point is located directly beneat the center point
        for (int i = 0; i < sides; i++, angle += angleStep) {
            polygon.getPoints().addAll(
                    Math.sin(angle) * radius + centerX, // x coordinate of the corner
                    Math.cos(angle) * radius + centerY // y coordinate of the corner
            );
        }

        return polygon;
    }
}
