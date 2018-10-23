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
import java.util.Arrays;

class OFPortDescPropBsnSffJsonVer14 implements OFPortDescPropBsnSffJson {
    private static final Logger logger = LoggerFactory.getLogger(OFPortDescPropBsnSffJsonVer14.class);
    // version: 1.4
    final static byte WIRE_VERSION = 5;
    final static int MINIMUM_LENGTH = 12;

        private final static byte[] DEFAULT_DATA_JSON = new byte[0];

    // OF message fields
    private final byte[] dataJson;
//
    // Immutable default instance
    final static OFPortDescPropBsnSffJsonVer14 DEFAULT = new OFPortDescPropBsnSffJsonVer14(
        DEFAULT_DATA_JSON
    );

    // package private constructor - used by readers, builders, and factory
    OFPortDescPropBsnSffJsonVer14(byte[] dataJson) {
        if(dataJson == null) {
            throw new NullPointerException("OFPortDescPropBsnSffJsonVer14: property dataJson cannot be null");
        }
        this.dataJson = dataJson;
    }

    // Accessors for OF message fields
    @Override
    public int getType() {
        return 0xffff;
    }

    @Override
    public long getExperimenter() {
        return 0x5c16c7L;
    }

    @Override
    public long getExpType() {
        return 0x6L;
    }

    @Override
    public byte[] getDataJson() {
        return dataJson;
    }

    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_14;
    }



    public OFPortDescPropBsnSffJson.Builder createBuilder() {
        return new BuilderWithParent(this);
    }

    static class BuilderWithParent implements OFPortDescPropBsnSffJson.Builder {
        final OFPortDescPropBsnSffJsonVer14 parentMessage;

        // OF message fields
        private boolean dataJsonSet;
        private byte[] dataJson;

        BuilderWithParent(OFPortDescPropBsnSffJsonVer14 parentMessage) {
            this.parentMessage = parentMessage;
        }

    @Override
    public int getType() {
        return 0xffff;
    }

    @Override
    public long getExperimenter() {
        return 0x5c16c7L;
    }

    @Override
    public long getExpType() {
        return 0x6L;
    }

    @Override
    public OFPortDescPropBsnSffJson.Builder setExpType(long expType) {
            throw new UnsupportedOperationException("Property expType is not writeable");
    }
    @Override
    public byte[] getDataJson() {
        return dataJson;
    }

    @Override
    public OFPortDescPropBsnSffJson.Builder setDataJson(byte[] dataJson) {
        this.dataJson = dataJson;
        this.dataJsonSet = true;
        return this;
    }
    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_14;
    }



        @Override
        public OFPortDescPropBsnSffJson build() {
                byte[] dataJson = this.dataJsonSet ? this.dataJson : parentMessage.dataJson;
                if(dataJson == null)
                    throw new NullPointerException("Property dataJson must not be null");

                //
                return new OFPortDescPropBsnSffJsonVer14(
                    dataJson
                );
        }

    }

    static class Builder implements OFPortDescPropBsnSffJson.Builder {
        // OF message fields
        private boolean dataJsonSet;
        private byte[] dataJson;

    @Override
    public int getType() {
        return 0xffff;
    }

    @Override
    public long getExperimenter() {
        return 0x5c16c7L;
    }

    @Override
    public long getExpType() {
        return 0x6L;
    }

    @Override
    public OFPortDescPropBsnSffJson.Builder setExpType(long expType) {
            throw new UnsupportedOperationException("Property expType is not writeable");
    }
    @Override
    public byte[] getDataJson() {
        return dataJson;
    }

    @Override
    public OFPortDescPropBsnSffJson.Builder setDataJson(byte[] dataJson) {
        this.dataJson = dataJson;
        this.dataJsonSet = true;
        return this;
    }
    @Override
    public OFVersion getVersion() {
        return OFVersion.OF_14;
    }

//
        @Override
        public OFPortDescPropBsnSffJson build() {
            byte[] dataJson = this.dataJsonSet ? this.dataJson : DEFAULT_DATA_JSON;
            if(dataJson == null)
                throw new NullPointerException("Property dataJson must not be null");


            return new OFPortDescPropBsnSffJsonVer14(
                    dataJson
                );
        }

    }


    final static Reader READER = new Reader();
    static class Reader implements OFMessageReader<OFPortDescPropBsnSffJson> {
        @Override
        public OFPortDescPropBsnSffJson readFrom(ByteBuf bb) throws OFParseError {
            int start = bb.readerIndex();
            // fixed value property type == 0xffff
            short type = bb.readShort();
            if(type != (short) 0xffff)
                throw new OFParseError("Wrong type: Expected=0xffff(0xffff), got="+type);
            int length = U16.f(bb.readShort());
            if(length < MINIMUM_LENGTH)
                throw new OFParseError("Wrong length: Expected to be >= " + MINIMUM_LENGTH + ", was: " + length);
            if(bb.readableBytes() + (bb.readerIndex() - start) < length) {
                // Buffer does not have all data yet
                bb.readerIndex(start);
                return null;
            }
            if(logger.isTraceEnabled())
                logger.trace("readFrom - length={}", length);
            // fixed value property experimenter == 0x5c16c7L
            int experimenter = bb.readInt();
            if(experimenter != 0x5c16c7)
                throw new OFParseError("Wrong experimenter: Expected=0x5c16c7L(0x5c16c7L), got="+experimenter);
            // fixed value property expType == 0x6L
            int expType = bb.readInt();
            if(expType != 0x6)
                throw new OFParseError("Wrong expType: Expected=0x6L(0x6L), got="+expType);
            byte[] dataJson = ChannelUtils.readBytes(bb, length - (bb.readerIndex() - start));

            OFPortDescPropBsnSffJsonVer14 portDescPropBsnSffJsonVer14 = new OFPortDescPropBsnSffJsonVer14(
                    dataJson
                    );
            if(logger.isTraceEnabled())
                logger.trace("readFrom - read={}", portDescPropBsnSffJsonVer14);
            return portDescPropBsnSffJsonVer14;
        }
    }

    public void putTo(PrimitiveSink sink) {
        FUNNEL.funnel(this, sink);
    }

    final static OFPortDescPropBsnSffJsonVer14Funnel FUNNEL = new OFPortDescPropBsnSffJsonVer14Funnel();
    static class OFPortDescPropBsnSffJsonVer14Funnel implements Funnel<OFPortDescPropBsnSffJsonVer14> {
        private static final long serialVersionUID = 1L;
        @Override
        public void funnel(OFPortDescPropBsnSffJsonVer14 message, PrimitiveSink sink) {
            // fixed value property type = 0xffff
            sink.putShort((short) 0xffff);
            // FIXME: skip funnel of length
            // fixed value property experimenter = 0x5c16c7L
            sink.putInt(0x5c16c7);
            // fixed value property expType = 0x6L
            sink.putInt(0x6);
            sink.putBytes(message.dataJson);
        }
    }


    public void writeTo(ByteBuf bb) {
        WRITER.write(bb, this);
    }

    final static Writer WRITER = new Writer();
    static class Writer implements OFMessageWriter<OFPortDescPropBsnSffJsonVer14> {
        @Override
        public void write(ByteBuf bb, OFPortDescPropBsnSffJsonVer14 message) {
            int startIndex = bb.writerIndex();
            // fixed value property type = 0xffff
            bb.writeShort((short) 0xffff);
            // length is length of variable message, will be updated at the end
            int lengthIndex = bb.writerIndex();
            bb.writeShort(U16.t(0));

            // fixed value property experimenter = 0x5c16c7L
            bb.writeInt(0x5c16c7);
            // fixed value property expType = 0x6L
            bb.writeInt(0x6);
            bb.writeBytes(message.dataJson);

            // update length field
            int length = bb.writerIndex() - startIndex;
            bb.setShort(lengthIndex, length);

        }
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder("OFPortDescPropBsnSffJsonVer14(");
        b.append("dataJson=").append(Arrays.toString(dataJson));
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
        OFPortDescPropBsnSffJsonVer14 other = (OFPortDescPropBsnSffJsonVer14) obj;

        if (!Arrays.equals(dataJson, other.dataJson))
                return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + Arrays.hashCode(dataJson);
        return result;
    }

}
