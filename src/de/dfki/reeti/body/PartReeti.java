/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.reeti.body;

import de.dfki.common.animationlogic.Animator;
import de.dfki.common.part.Part3D;
import de.dfki.reeti.animationlogic.AnimatorReeti;
import javafx.application.Platform;
import javafx.scene.paint.PhongMaterial;
import java.net.URL;

/**
 * @author Beka Aptsiauri
 */
public abstract class PartReeti extends Part3D
{
    private static PhongMaterial material = null;

    public void init()
    {
        super.init();
    }

    @Override
    public void resetRotation()
    {
    }

    protected PhongMaterial getMaterial()
    {
        if (material == null)
        {
            URL imageUrl = getClass().getClassLoader().getResource("Images/difuseMap2.png");
            javafx.scene.image.Image image = new javafx.scene.image.Image(imageUrl.toExternalForm());
            material = new PhongMaterial();
            material.setDiffuseColor(mColor);
            material.setDiffuseMap(image);
            material.setSelfIlluminationMap(image);
        }
        return material;
    }


}
