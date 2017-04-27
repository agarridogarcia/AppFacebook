/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appfacebook;

import facebook4j.Comment;
import facebook4j.*;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.ResponseList;
import facebook4j.conf.ConfigurationBuilder;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Araceli
 */
public class Metodos {
    static Facebook facebook;
/**
 * acceso con contrasinales
 */
    public void acceso() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthAppId("1813009045693822")
                .setOAuthAppSecret("8eff926fb8b966d5b2e47c62b42954dd")
                .setOAuthAccessToken("EAAZAw7BAkpX4BAAm99h3r6IZAF6re0BteYvwhZCIssUNriqKdZCgBc6bGxxKtQZBCc4Jkr76POhzVu3BpPoUuco5ubI3q6ppQbubFbGc6Vxr0nDTWZAwP9KJVcveuY1azzZCkhgHBRjYiZBdlbzhUJZA8SWA8Q2xsJCMZD")
                .setOAuthPermissions("email,publish_stream,...");
        FacebookFactory ff = new FacebookFactory(cb.build());
        facebook = ff.getInstance();
    }
/**
 * publicar un estado
 * @param mensaxe mensaxe que queres publicar
 */
    public void publicar(String mensaxe) {
        try {
            facebook.postStatusMessage(mensaxe);
        } catch (FacebookException ex) {
            System.out.println("error 1" + ex.getMessage());
        }
    }

    
    /**
     * publicar unha foto
     */
    public void postFoto(){
        try {
            PostUpdate post = null;
            try {
                post = new PostUpdate(new URL("http://facebook4j.org"))
                    .picture(new URL("http://facebook4j.org/images/hero.png"))
                    .name("Facebook4J - A Java library for the Facebook Graph API")
                    .caption("facebook4j.org")
                    .description("Facebook4J is a Java library for the Facebook Graph API.");
facebook.postFeed(post);
            } catch (MalformedURLException ex) {
                Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
            }
            facebook.postFeed(post);
        } catch (FacebookException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /** 
     * facer comentario
     * @param mensaxe mensaxe que vas a enviar
     */
    public void comentarioFoto(String mensaxe){
        try {
            facebook.commentPhoto(" ", mensaxe);
        } catch (FacebookException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * busca comentarios de unha publicación
     * @param mensaxe a buscar na publicacion
     */
    public void buscarMens(String mensaxe){
        try {
            ResponseList<Group> results = facebook.searchGroups(mensaxe);
            for(int i=0;i<results.size();i++)
                System.out.println(results.get(i));
        } catch (FacebookException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * comentarios de unha publicacion
     */
    public void comentPublicacion(){
        try {
           ResponseList<Comment> results = facebook.getCommentReplies("1000");
             for(int i=0;i<results.size();i++)
                System.out.println(results.get(i));
        } catch (FacebookException ex) {
            Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
