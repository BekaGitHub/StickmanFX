package de.dfki.stickman3D.body;

import java.awt.Dimension;

import de.dfki.common.part.Part3D;
import javafx.scene.Group;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class UpperBodyAndHead3D extends PartStickman3D
{

	private Group mUpperBodyAndHead;


	public UpperBodyAndHead3D(Part3D head, Part3D upperBody, Part3D neck) {
		mSize = new Dimension(120, 300);
		mUpperBodyAndHead = new Group();
		mUpperBodyAndHead.getChildren().addAll(head, upperBody, neck);

		this.getChildren().addAll(mUpperBodyAndHead);
	}

	@Override
	public void calculate(int step) {
		Rotate rx = new Rotate(mXRotation, 65, mYTranslation + 280, -105, Rotate.X_AXIS);
		Rotate ry = new Rotate(mYRotation, 65, mYTranslation + 280, -105, Rotate.Y_AXIS);
		Rotate rz = new Rotate(mZRotation, 65, mYTranslation + 280, -105, Rotate.Z_AXIS);

		Translate translation = new Translate(mXTranslation, mYTranslation, mZTranslation);
		mUpperBodyAndHead.getTransforms().clear();
		mUpperBodyAndHead.getTransforms().addAll(rx, ry, rz, translation);
	}

	@Override
	public void setShape(String s)
	{

	}
}
