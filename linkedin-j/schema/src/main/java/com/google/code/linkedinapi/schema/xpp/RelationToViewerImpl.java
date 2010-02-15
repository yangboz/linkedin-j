
package com.google.code.linkedinapi.schema.xpp;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.linkedinapi.schema.RelationToViewer;

public class RelationToViewerImpl
    extends BaseSchemaEntity
    implements RelationToViewer
{

    /**
	 * 
	 */
	private static final long serialVersionUID = -5385043041125747824L;
	protected Long distance;

    public Long getDistance() {
        return distance;
    }

    public void setDistance(Long value) {
        this.distance = value;
    }

	@Override
	public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        while (parser.nextTag() == XmlPullParser.START_TAG) {
        	String name = parser.getName();
        	
        	if (name.equals("distance")) {
        		setDistance(XppUtils.getElementValueAsLongFromNode(parser));
            } else {
                // Consume something we don't understand.
            	System.err.println(getClass().getName() + ":Found tag that we don't recognize: " + name);
            	XppUtils.skipSubTree(parser);
            }
        }
	}

	@Override
	public void toXml(XmlSerializer serializer) throws IOException {
		XmlSerializer element = serializer.startTag(null, "relation-to-viewer");
		XppUtils.setElementValueToNode(element, "distance", getDistance());
		serializer.endTag(null, "relation-to-viewer");
	}
}
