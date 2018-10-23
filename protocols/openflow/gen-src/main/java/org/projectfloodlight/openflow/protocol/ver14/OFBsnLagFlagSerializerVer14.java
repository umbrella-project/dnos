// Copyright (c) 2008 The Board of Trustees of The Leland Stanford Junior University
// Copyright (c) 2011, 2012 Open Networking Foundation
// Copyright (c) 2012, 2013 Big Switch Networks, Inc.
// This library was generated by the LoxiGen Compiler.
// See the file LICENSE.txt which should have been included in the source distribution

// Automatically generated by LOXI from template const_set_serializer.java
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
import org.projectfloodlight.openflow.protocol.OFBsnLagFlag;
import java.util.Set;
import io.netty.buffer.ByteBuf;
import com.google.common.hash.PrimitiveSink;
import java.util.EnumSet;
import java.util.Collections;


public class OFBsnLagFlagSerializerVer14 {

    public final static short BSN_LAG_FLAG_AUTO_RECOVERY_VAL = (short) 0x1;

    public static Set<OFBsnLagFlag> readFrom(ByteBuf bb) throws OFParseError {
        try {
            return ofWireValue(bb.readShort());
        } catch (IllegalArgumentException e) {
            throw new OFParseError(e);
        }
    }

    public static void writeTo(ByteBuf bb, Set<OFBsnLagFlag> set) {
        bb.writeShort(toWireValue(set));
    }

    public static void putTo(Set<OFBsnLagFlag> set, PrimitiveSink sink) {
        sink.putShort(toWireValue(set));
    }


    public static Set<OFBsnLagFlag> ofWireValue(short val) {
        EnumSet<OFBsnLagFlag> set = EnumSet.noneOf(OFBsnLagFlag.class);

        if((val & BSN_LAG_FLAG_AUTO_RECOVERY_VAL) != 0)
            set.add(OFBsnLagFlag.BSN_LAG_FLAG_AUTO_RECOVERY);
        return Collections.unmodifiableSet(set);
    }

    public static short toWireValue(Set<OFBsnLagFlag> set) {
        short wireValue = 0;

        for(OFBsnLagFlag e: set) {
            switch(e) {
                case BSN_LAG_FLAG_AUTO_RECOVERY:
                    wireValue |= BSN_LAG_FLAG_AUTO_RECOVERY_VAL;
                    break;
                default:
                    throw new IllegalArgumentException("Illegal enum value for type OFBsnLagFlag in version 1.4: " + e);
            }
        }
        return wireValue;
    }

}
