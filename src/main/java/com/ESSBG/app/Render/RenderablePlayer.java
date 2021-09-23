package com.ESSBG.app.Render;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

public class RenderablePlayer implements Renderable {
    private ArrayList<RenderableCard> handCards = new ArrayList<>();
    private ArrayList<RenderableCard> placedCards = new ArrayList<>();

    private int coins;
    private int warPoints;

    public void updatePlayer(JSONObject data, AssetManager am){
        var handCardsJson = data.getJSONArray("handCards");
        var placedCardsJson = data.getJSONArray("placedCards");
        var resourcesJson = data.getJSONObject("resources");
        var monumentJson = data.getJSONObject("monument");
        var leftNeighbourJson = data.getJSONObject("leftNeighbour");
        var rightNeighbourJson = data.getJSONObject("rightNeighbour");

        int cardX = 0;
        for(var i : handCardsJson){
            var k = (JSONObject)i;
            JSONObject colorString = k.getJSONObject("color");
            System.out.println(colorString);

            String cardText = "";
            try {
                var resource = k.getJSONObject("resource");
                cardText += resource.getString("type") + " " + resource.getInt("amount");
            } catch (JSONException e) {}
            try {
                var action = k.getJSONObject("action");
                cardText += action;
            } catch (JSONException e) {}
            handCards.add(
                new RenderableCard(
                    am, "Assets/Textures/Cards/CardBase.png", 
                    cardText,
                    new Color(colorString.getInt("r"),colorString.getInt("g"),colorString.getInt("b"),colorString.getInt("a")),
                    cardX, 0)
            );
            cardX += 90;
        }
    }

    @Override
    public void render(SpriteBatch batch,BitmapFont font, float widthScale, float heightScale) {
        for (RenderableCard i : handCards) {
            i.render(batch, font, widthScale, heightScale);
        }
    }
    
}