/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.action.sequence;

import de.dfki.util.ios.IOSIndentWriter;
import de.dfki.util.xml.XMLWriteError;

/**
 * @author Patrick Gebhard
 */
public class Entry
{

    public String mContent;

    ;
    public TYPE mType;
    public Entry()
    {
        mType = TYPE.GENERIC;
    }

    public void writeXML(IOSIndentWriter out) throws XMLWriteError
    {
    }

    public String toString()
    {
        return "entry";
    }

    public static enum TYPE
    {

        GENERIC, WORD, TIMEMARK
    }
}
