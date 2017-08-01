/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.action.sequence;

import de.dfki.util.ios.IOSIndentWriter;
import de.dfki.util.xml.XMLParseError;
import de.dfki.util.xml.XMLParseable;
import de.dfki.util.xml.XMLWriteError;
import de.dfki.util.xml.XMLWriteable;
import org.w3c.dom.Element;

/**
 * @author Patrick Gebhard
 */
public class TimeMark extends Entry implements XMLParseable, XMLWriteable
{

    public TimeMark()
    {
        mType = TYPE.TIMEMARK;
    }

    public TimeMark(String content)
    {
        mType = TYPE.TIMEMARK;
        mContent = content;
    }

    @Override
    public void writeXML(IOSIndentWriter out) throws XMLWriteError
    {
        out.println("<TimeMarkEntry>").push();
        out.println(mContent);
        out.pop().println("</TimeMarkEntry>");
    }

    @Override
    public final void parseXML(final Element element) throws XMLParseError
    {
        mContent = element.getTextContent().trim();
    }

    @Override
    public String toString()
    {
        return mContent;
    }
}
