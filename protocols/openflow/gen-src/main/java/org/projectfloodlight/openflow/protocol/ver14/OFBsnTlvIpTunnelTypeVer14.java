// Copyright (c) 2008 The Board of Trustees of The Leland Stanford Junior University
// Copyright (c) 2011, 2012 Open Networking Foundation
// Copyright (c) 2012, 2013 Big Switch Networks, Inc.
// This library was generated by the LoxiGen Compiler.
// See the file LICENSE.txt which should have been included in the source distribution

// Automatically generated by LOXI from template of_class.java
// Do not modify

package org.projectfloodlight.openflow.protocol.ver14;

import org.projectfloodlight.openflow.protocol.*;
import org.projectfloodlight.openflow.protocol.action.*;
import org.projectfloodlight.openflow.protocol.actionid.*;
import org.projectfloodlight.openflow.protocol.bsntlv.*;
import org.projectfloodlight.openflow.protocol.errormsg.*;
import org.projectfloodlight.openflow.protocol.meterband.*;
import org.projectfloodlight.openflow.protocol.instruction.*;
import org.projectfloodlight.openflow.protocol.instructionid.*;
import org.projectfloodlight.openflow.protocol.match.*;
import org.projectfloodlight.openflow.protocol.stat.*;
import org.projectfloodlight.openflow.protocol.oxm.*;
import org.projectfloodlight.openflow.protocol.oxs.*;
import org.projectfloodlight.openflow.protocol.queueprop.*;
import org.projectfloodlight.openflow.types.*;
import org.projectfloodlight.openflow.util.*;
import org.projectfloodlight.openflow.exceptions.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Set;
import io.netty.buffer.ByteBuf;
import com.google.common.hash.PrimitiveSink;
import com.google.common.hash.Funnel;

class OFBsnTlvIpTunnelTypeVer14 implements OFBsnTlvIpTunnelType {
    private static final Logger logger = LoggerFactory.getLogger(OFBsnTlvIpTunnelTypeVer14.class);
    // version: 1.4
    final static byte WIRE_VERSION = 5;
    final static int LENGTH = 6;


    // OF message fields
    private final OFBsnIpTunnelType value;
//

    // package private constructor - used by readers, builders, and factory
    OFBsnTlvIpTunnelTypeVer14(OFBsnIpTunnelType value) {
        if(value == null) {
            throw new NullPointerException("OFBsnTlvIpTunnelTypeVer14: property value cannot be null");
        }
        this.value = value;
    }

    // Accessors for OF message fields
    @Override
    public int getType() {
        return 0xa9;
    }

    @Override
    public OFBsnIpTunnelType getValue() {
        return value;
    }

    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_14;
    }



    public OFBsnTlvIpTunnelType.Builder createBuilder() {
        return new BuilderWithParent(this);
    }

    static class BuilderWithParent implements OFBsnTlvIpTunnelType.Builder {
        final OFBsnTlvIpTunnelTypeVer14 parentMessage;

        // OF message fields
        private boolean valueSet;
        private OFBsnIpTunnelType value;

        BuilderWithParent(OFBsnTlvIpTunnelTypeVer14 parentMessage) {
            this.parentMessage = parentMessage;
        }

    @Override
    public int getType() {
        return 0xa9;
    }

    @Override
    public OFBsnIpTunnelType getValue() {
        return value;
    }

    @Override
    public OFBsnTlvIpTunnelType.Builder setValue(OFBsnIpTunnelType value) {
        this.value = value;
        this.valueSet = true;
        return this;
    }
    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_14;
    }



        @Override
        public OFBsnTlvIpTunnelType build() {
                OFBsnIpTunnelType value = this.valueSet ? this.value : parentMessage.value;
                if(value == null)
                    throw new NullPointerException("Property value must not be null");

                //
                return new OFBsnTlvIpTunnelTypeVer14(
                    value
                );
        }

    }

    static class Builder implements OFBsnTlvIpTunnelType.Builder {
        // OF message fields
        private boolean valueSet;
        private OFBsnIpTunnelType value;

    @Override
    public int getType() {
        return 0xa9;
    }

    @Override
    public OFBsnIpTunnelType getValue() {
        return value;
    }

    @Override
    public OFBsnTlvIpTunnelType.Builder setValue(OFBsnIpTunnelType value) {
        this.value = value;
        this.valueSet = true;
        return this;
    }
    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_14;
    }

//
        @Override
        public OFBsnTlvIpTunnelType build() {
            if(!this.valueSet)
                throw new IllegalStateException("Property value doesn't have default value -- must be set");
            if(value == null)
                throw new NullPointerException("Property value must not be null");


            return new OFBsnTlvIpTunnelTypeVer14(
                    value
                );
        }

    }


    final static Reader READER = new Reader();
    static class Reader implements OFMessageReader<OFBsnTlvIpTunnelType> {
        @Override
        public OFBsnTlvIpTunnelType readFrom(ByteBuf bb) throws OFParseError {
            int start = bb.readerIndex();
            // fixed value property type == 0xa9
            short type = bb.readShort();
            if(type != (short) 0xa9)
                throw new OFParseError("Wrong type: Expected=0xa9(0xa9), got="+type);
            int length = U16.f(bb.readShort());
            if(length != 6)
                throw new OFParseError("Wrong length: Expected=6(6), got="+length);
            if(bb.readableBytes() + (bb.readerIndex() - start) < length) {
                // Buffer does not have all data yet
                bb.readerIndex(start);
                return null;
            }
            if(logger.isTraceEnabled())
                logger.trace("readFrom - length={}", length);
            OFBsnIpTunnelType value = OFBsnIpTunnelTypeSerializerVer14.readFrom(bb);

            OFBsnTlvIpTunnelTypeVer14 bsnTlvIpTunnelTypeVer14 = new OFBsnTlvIpTunnelTypeVer14(
                    value
                    );
            if(logger.isTraceEnabled())
                logger.trace("readFrom - read={}", bsnTlvIpTunnelTypeVer14);
            return bsnTlvIpTunnelTypeVer14;
        }
    }

    public void putTo(PrimitiveSink sink) {
        FUNNEL.funnel(this, sink);
    }

    final static OFBsnTlvIpTunnelTypeVer14Funnel FUNNEL = new OFBsnTlvIpTunnelTypeVer14Funnel();
    static class OFBsnTlvIpTunnelTypeVer14Funnel implements Funnel<OFBsnTlvIpTunnelTypeVer14> {
        private static final long serialVersionUID = 1L;
        @Override
        public void funnel(OFBsnTlvIpTunnelTypeVer14 message, PrimitiveSink sink) {
            // fixed value property type = 0xa9
            sink.putShort((short) 0xa9);
            // fixed value property length = 6
            sink.putShort((short) 0x6);
            OFBsnIpTunnelTypeSerializerVer14.putTo(message.value, sink);
        }
    }


    public void writeTo(ByteBuf bb) {
        WRITER.write(bb, this);
    }

    final static Writer WRITER = new Writer();
    static class Writer implements OFMessageWriter<OFBsnTlvIpTunnelTypeVer14> {
        @Override
        public void write(ByteBuf bb, OFBsnTlvIpTunnelTypeVer14 message) {
            // fixed value property type = 0xa9
            bb.writeShort((short) 0xa9);
            // fixed value property length = 6
            bb.writeShort((short) 0x6);
            OFBsnIpTunnelTypeSerializerVer14.writeTo(bb, message.value);


        }
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder("OFBsnTlvIpTunnelTypeVer14(");
        b.append("value=").append(value);
        b.append(")");
        return b.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        OFBsnTlvIpTunnelTypeVer14 other = (OFBsnTlvIpTunnelTypeVer14) obj;

        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + ((value == null) ? 0 : value.hashCode());
        return result;
    }

}
