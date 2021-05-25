package com.mygdx.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.Actors.ActorHero;


public class MainGameScreen extends BaseScreen {
    public MainGameScreen(MainGame game) {
        super(game);
        textureHero = new Texture("CharacterTilesSet-Right.png");
        regionHero = new TextureRegion(textureHero, textureHero.getWidth(), textureHero.getHeight());
    }

    private Stage stage;
    private ActorHero actorHero;
    private Texture textureHero;
    private TextureRegion regionHero;



    @Override
    public void show() {
        stage = new Stage();
        actorHero = new ActorHero(regionHero);
        stage.addActor(actorHero);
        actorHero.setPosition(stage.getWidth() / 3, stage.getHeight() / 2);
        actorHero.rotateBy(180);
        actorHero.act(100);
    }

    @Override
    public void hide() {
        stage.dispose();

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
    }


    @Override
    public void dispose()
    {
        textureHero.dispose();
    }
}
