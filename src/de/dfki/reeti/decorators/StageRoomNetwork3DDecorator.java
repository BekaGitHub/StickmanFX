package de.dfki.reeti.decorators;

import de.dfki.common.client.ClientConnectionHandler;
import de.dfki.common.decorators.StageRoomNetworkDecorator;
import de.dfki.common.interfaces.StageRoom;
import de.dfki.reeti.XMLCommandParser3D;

/**
 * Created by alvaro on 11/19/16.
 */
public class StageRoomNetwork3DDecorator extends StageRoomNetworkDecorator
{

    public StageRoomNetwork3DDecorator(StageRoom wrappedController, String host, int port)
    {
        super(wrappedController, host, port);
    }

    @Override
    protected void initConnectionToServer(StageRoom wrappedController)
    {
        commonXMLCommandParser = new XMLCommandParser3D(getCommonStickmansOnStage());
        mConnection = new ClientConnectionHandler(commonXMLCommandParser);
        mConnection.tryToConnect(mHost, mPort);
    }
}
