package graphicsPractice;

import comp127graphics.*;

import java.awt.*;

@SuppressWarnings("WeakerAccess")
public class Emojis {
    private static final Color
        HEAD_COLOR = new Color(0xFFDE30),
        HEAD_OUTLINE_COLOR = new Color(0xAC9620),
        MOUTH_COLOR = new Color(0xE45B5B),
        EYE_COLOR =   new Color(0x000000);

    public static void main(String[] args) {
        CanvasWindow canvas = new CanvasWindow("Emoji", 800, 600);

        GraphicsGroup littleSmiley = createSmileyFace(100);
        littleSmiley.setPosition(50, 400);
        canvas.add(littleSmiley);

        GraphicsGroup mediumSmiley = createWinkingFace(200);
        mediumSmiley.setPosition(150, 300);
        canvas.add(mediumSmiley);

        GraphicsGroup bigSmiley = createSmileyFace(300);
        bigSmiley.setPosition(350, 200);
        canvas.add(bigSmiley);
    }

    /**
     * Creates a smiley face emoji.
     *
     * @param size The overall width and height of the emoji.
     * @return A graphic that you can add to a window, or place inside some other graphics group.
     */
    public static GraphicsGroup createSmileyFace(double size) {
        GraphicsGroup group = new GraphicsGroup();

        group.add(createHead(size, size));

        Ellipse eye1 = createEyes(size * 0.3);
        eye1.setCenter(size * 0.35, size * .4);
        group.add(eye1);

        Ellipse eye2 = createEyes(size * 0.3);
        eye2.setCenter(size * .65, size * 0.4);
        group.add(eye2);

        Arc mouth = createSmile(size * 0.6, size * 0.5);
        mouth.setCenter(size * 0.5, size * 0.75);
        group.add(mouth);

        return group;
    }

    /**
     * Creates an empty emoji head. The head fits inside the box from (0,0)
     * to (width,height).
     */
    private static Ellipse createHead(double height, double width) {
        Ellipse head = new Ellipse(0, 0, width, height);
        head.setFillColor(HEAD_COLOR);
        head.setStrokeColor(HEAD_OUTLINE_COLOR);
        head.setStrokeWidth(2);
        return head;
    }

    private static Ellipse createEyes(double size){
        Ellipse eye = new Ellipse(0, 0, size * 0.3, size * 0.3);
        eye.setFillColor(Color.BLACK);
        eye.setStrokeColor(Color.BLACK);
        eye.setStrokeWidth(3);
        return eye;

    }

    /**
     * Creates a smile-shaped arc. The arc is measured relative to its “implied ellipse,” which is
     * the shape that would be formed if the arc were extend all the way around. The size of the
     * resulting arc will be smaller than the implied ellipse’s size.
     *
     * @param ellipseWidth  The width of the implied ellipse from which the smile’s arc is cut.
     * @param ellipseHeight The width of the implied ellipse from which the smile’s arc is cut.
     */
    private static Arc createSmile(double ellipseWidth, double ellipseHeight) {
        Arc mouth = new Arc(0, 0, ellipseWidth, ellipseHeight, 200, 140);
        mouth.setStrokeColor(MOUTH_COLOR);
        mouth.setStrokeWidth(4);
        return mouth;
    }

    public static GraphicsGroup createWinkingFace(double size){
        GraphicsGroup group2 = new GraphicsGroup();

        group2.add(createHead(size, size));

        Ellipse eye1 = createEyes(size * 0.3);
        eye1.setCenter(size * 0.35, size * .4);
        group2.add(eye1);

        Line eye2 = createWink(size);
        eye2.setCenter(size*0.65, size*.4);
        group2.add(eye2);

        Arc mouth = createSmile(size * 0.6, size * 0.5);
        mouth.setCenter(size * 0.5, size * 0.75);
        group2.add(mouth);

        return group2;
    }

    private static Line createWink(double size){
        Line wink = new Line(size*0.1, size*0.1, size*0.25, size*0.1);
        wink.setStrokeColor(Color.BLACK);
        wink.setStrokeWidth(10);
        return wink;
    }
}
