package com.mygdx.Actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;


public class ActorHero extends Actor {

    private Texture textureHero;
    private boolean alive;
    private Sprite spriteHero;
    //MoveByAction move = new MoveByAction();
    final float STEP = 10f;

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public ActorHero(Texture textureHero){
        this.textureHero=textureHero;
        this.alive=true;
        spriteHero = new Sprite(textureHero);
        setSize(spriteHero.getRegionWidth(), spriteHero.getRegionHeight());
    }

    public void act (float delta)
    {
        super.act(delta);
        if(Gdx.input.isKeyPressed(Input.Keys.UP))
        {
            textureHero = new Texture("CharacterTilesSet-Left.png");
            spriteHero = new Sprite(textureHero);
            spriteHero.setPosition(getX() - STEP - 5, getY());
            this.setPosition(getX() - STEP - 5, getY());
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN))
        {
            textureHero = new Texture("CharacterTilesSet-Right.png");
            spriteHero = new Sprite(textureHero);
            spriteHero.setPosition(getX() + STEP + 5, getY());
            this.setPosition(getX() + STEP + 5, getY());
        }
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT))
        {
            spriteHero = new Sprite(textureHero);
            spriteHero.setPosition(getX(), getY() - STEP);
            this.setPosition(getX(), getY() - STEP);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))
        {
            spriteHero = new Sprite(textureHero);
            spriteHero.setPosition(getX(), getY() + STEP);
            this.setPosition(getX(), getY() + STEP);
        }
    }

    public void draw (Batch batch, float parentAlpha){
        batch.draw(textureHero, getX(), getY());
    }
}
