package de.dfki.stickmanFX.decorators;

import de.dfki.common.client.ClientConnectionHandler;
import de.dfki.common.decorators.StageRoomNetworkDecorator;
import de.dfki.common.interfaces.StageRoom;
import de.dfki.stickmanFX.client.XMLCommandParserFX;

/**
 * Created by alvaro on 9/17/16.
 */
public class StageRoomNetworkFXDecorator extends StageRoomNetworkDecorator
{

    public StageRoomNetworkFXDecorator(StageRoom wrappedController, String host, int port)
    {
        super(wrappedController, host, port);
    }

    protected void initConnectionToServer(StageRoom wrappedController)
    {
        commonXMLCommandParser = new XMLCommandParserFX(getAgentsOnStage());
        mConnection = new ClientConnectionHandler(commonXMLCommandParser);
        mConnection.tryToConnect(mHost, mPort);
    }

}
